package com.example.fullstackspringbootcrudmysqlvuejs.service;

import com.example.fullstackspringbootcrudmysqlvuejs.model.Product;
import com.example.fullstackspringbootcrudmysqlvuejs.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id)
    {
        return productRepository.findById(id);
    }

    public Product save(Product stock)
    {
        return productRepository.save(stock);
    }
    public void deleteById(Long id)
    {
        productRepository.deleteById(id);
    }

}
