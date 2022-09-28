package com.ms.product.repository;

import com.ms.product.entity.Category;
import com.ms.product.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RepositoryProduct {

    @PersistenceContext
    private EntityManager em;

    public List<Product> findByFilterAndSorting(String name, Long categoryId, Long orderId) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);
        Join<Product, Category> categoryJoin = productRoot.join("category");
        if(categoryId!=null && categoryId>0) {
            criteriaQuery.where(criteriaBuilder.equal(categoryJoin.get("id"), categoryId));
        }
        if(name!=null && !name.isEmpty()) {
            criteriaQuery.where(criteriaBuilder.like(productRoot.get("name"), "% "+name+"%"));
        }

        if(orderId==1) {
            criteriaQuery.orderBy(criteriaBuilder.asc(productRoot.get("name")));
        }

        if(orderId==2) {
            criteriaQuery.orderBy(criteriaBuilder.desc(productRoot.get("name")));
        }

        if(orderId==3) {
            criteriaQuery.orderBy(criteriaBuilder.asc(productRoot.get("price")));
        }

        if(orderId==4) {
            criteriaQuery.orderBy(criteriaBuilder.desc(productRoot.get("price")));
        }

        Query query = em.createQuery(criteriaQuery);
        List<Product> productList = query.getResultList();
        return productList;
    }

}
