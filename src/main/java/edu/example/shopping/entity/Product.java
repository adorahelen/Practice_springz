package edu.example.shopping.entity;

import lombok.Data;

@Data
public class Product {
    private String  id;
    private String name;
    private Integer price;
    private Integer stock;

}

//CREATE TABLE Product (
//        id VARCHAR(255) PRIMARY KEY,
//name VARCHAR(255) NOT NULL,
//price INT NOT NULL,
//stock INT NOT NULL
//);

//select * from Product;


//insert into Product (id, name, price, stock) values('p01', '지우개', 100, 10);
//insert into Product (id, name, price, stock) values('p02', '노트', 200, 20);
//insert into Product (id, name, price, stock) values('p03', 'pname', 300, 30);