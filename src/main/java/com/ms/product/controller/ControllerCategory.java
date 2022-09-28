package com.ms.product.controller;

import com.ms.product.entity.Category;
import com.ms.product.service.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class ControllerCategory {

    @Autowired
    private ServiceCategory serviceCategory;

    @GetMapping("/")
    public ResponseEntity<List<Category>> get() {
        List<Category> categories = serviceCategory.find();
        return ResponseEntity.ok(categories);
    }

}
