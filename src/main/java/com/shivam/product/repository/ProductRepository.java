package com.shivam.product.repository;

import com.shivam.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    void deleteByName(String name);
}
