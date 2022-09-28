package com.ms.product.service;

import com.ms.product.entity.Category;
import com.ms.product.repository.RepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategory {

    @Autowired
    private RepositoryCategory repositoryCategory;

    public List<Category> find() {
        List<Category> categories = repositoryCategory.findAll();
        return categories;
    }

}
