package emi_aplication.emi_aplication.controller;

import emi_aplication.emi_aplication.model.Customer;
import emi_aplication.emi_aplication.model.Emi;
import emi_aplication.emi_aplication.repository.CustomerRepository;
import emi_aplication.emi_aplication.repository.EmiRepository;
import emi_aplication.emi_aplication.service.EmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "emi")
public class EmiController {
    @Autowired
    private EmiService emiService;

    @Autowired
    private CustomerRepository customerRepository;

    @InitBinder
    public void InitBinder(WebDataBinder data)
    {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(path = "")
    public String insertEmi(Model model)
    {
        Emi emi = new Emi();
        List<Customer> listCust = customerRepository.findAll();
        model.addAttribute("emiNew",emi);
        model.addAttribute("listCust",listCust);
        return "insertEmi";
    }
    @RequestMapping(path = "saveEmi",method = RequestMethod.POST)
    public String saveEmi(@ModelAttribute("emiNew")Emi emi)
    {
        boolean bl = emiService.saveEmi(emi);
        if (bl)
        {
            return "redirect:/emi?success=insert success";
        }
        return "redirect:/emi?error=insert failed";
    }
}
