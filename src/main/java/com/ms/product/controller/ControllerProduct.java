package com.ms.product.controller;

import com.ms.product.entity.Product;
import com.ms.product.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ControllerProduct {

    @Autowired
    private ServiceProduct serviceProduct;

    @GetMapping("/")
    public ResponseEntity<List<Product>> get(@RequestParam("name") String name, @RequestParam("category") Long categoryId, @RequestParam("order") Long orderId) {
        System.out.println(name);
        System.out.println(categoryId);
        System.out.println(orderId);
        List<Product> products = serviceProduct.find(name, categoryId, orderId);
        return ResponseEntity.ok(products);
    }

}
