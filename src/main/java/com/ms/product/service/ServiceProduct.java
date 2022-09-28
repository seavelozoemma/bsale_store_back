package com.ms.product.service;

import com.ms.product.entity.Product;
import com.ms.product.repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct {

    @Autowired
    private RepositoryProduct repositoryProduct;

    public List<Product> find(String name, Long categoryId, Long orderId) {
        List<Product> products = repositoryProduct.findByFilterAndSorting(name, categoryId, orderId);
        return products;
    }



}
