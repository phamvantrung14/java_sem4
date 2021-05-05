package com.example.fullstackassignment2.todo;

import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class TodoService {
    private  final TodoRepository stockRepository;
    public List<Todo> findAll(){
        return  stockRepository.findAll();
    }
    public  List<Todo> saveAll(List<Todo> todos){
        return stockRepository.saveAll();
    }

}
