package edu.example.shopping.service;

import edu.example.shopping.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(String id);
}
