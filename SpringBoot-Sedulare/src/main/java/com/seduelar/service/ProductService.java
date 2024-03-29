package com.seduelar.service;

import com.seduelar.entity.Product;
import com.seduelar.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {
    @Autowired
  private   ProductRepo productRepo;
    @Scheduled(cron = "*/5 * * * * *")
    public  void addProduct(){
        Product p=new Product(new Random().nextInt(12),
                "product"+new Random().nextInt(12));
        productRepo.save(p);
        System.out.println("product with id"+p.getId()+ "is inserted in db"+"at time"+new Date());
    }
    @Scheduled(cron =  "*/15 * * * * *")
    public  void displayProduct() {
        List<Product> productList = productRepo.findAll();
        System.out.println("no of product fetch from db is:- " + productList.size()+"at time"+new Date());


    }



}
