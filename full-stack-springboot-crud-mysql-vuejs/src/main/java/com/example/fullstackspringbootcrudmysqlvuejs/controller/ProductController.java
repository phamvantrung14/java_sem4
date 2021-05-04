package com.example.fullstackspringbootcrudmysqlvuejs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class ProductController {

    @RequestMapping(path = "")
    public String list()
    {
        return "products";
    }
}
