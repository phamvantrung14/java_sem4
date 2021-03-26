package springboot_bootstrap.springboot_bootstrap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springboot_bootstrap.springboot_bootstrap.entity.User;
import springboot_bootstrap.springboot_bootstrap.model.UserModel;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserModel userModel;



    @RequestMapping(path = "/add")
    public String login(Model model)
    {
        User u = new User();
        model.addAttribute("u",u);
        return "user/login";
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("u")User u,Model model)
    {
        User user = userModel.save(u);
        return "redirect:list";
    }


    @RequestMapping(path = {"/list","/"})
    public String listUser(Model model)
    {
        List<User> list = (List<User>) userModel.findAll();
        model.addAttribute("list",list);
        return "index";
    }

    @RequestMapping(path = "/edit")
    public String editUser(@RequestParam("id")Integer userId,Model model)
    {
        Optional<User> user = userModel.findById(userId);
        model.addAttribute("user",user);
        return "user/edit";

    }
    @RequestMapping(path = "/updateUser",method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user")User user,Model model)
    {
        int id = user.getId();User us = userModel.findById(id).get();
        us.setEmail(user.getEmail());
        us.setName(user.getName());
        us.setPhone(user.getPhone());
        userModel.save(us);
        return "redirect:list";

    }

    @RequestMapping(path = "/delete")
    public String deleteUser(@RequestParam("id")Integer id)
    {
        userModel.deleteById(id);
        return "redirect:list";
    }













}
