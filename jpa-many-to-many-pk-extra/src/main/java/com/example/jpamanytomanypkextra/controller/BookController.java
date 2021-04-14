package com.example.jpamanytomanypkextra.controller;


import com.example.jpamanytomanypkextra.model.Book;
import com.example.jpamanytomanypkextra.model.Publisher;
import com.example.jpamanytomanypkextra.repository.BookRepository;
import com.example.jpamanytomanypkextra.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @RequestMapping(path = "")
    public String getListBook(Model model)
    {
        List<Book> list = bookRepository.findAll();
        model.addAttribute("list",list);
        return "listBook";
    }

    @RequestMapping(path = "/publisher")
    public String getPublisher(Model model)
    {
        List<Publisher> list = publisherRepository.findAll();
        model.addAttribute("list",list);
        return "listPublisher";
    }
}
