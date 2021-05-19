package com.example.springbootonetomanybidirectionalrestmysql.controller;


import com.example.springbootonetomanybidirectionalrestmysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class Book1Controller {

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "")
    public String getAll()
    {

        return "book";
    }

    @RequestMapping(path = "/library")
    public String getLibrary()
    {
        return "library";
    }
}
