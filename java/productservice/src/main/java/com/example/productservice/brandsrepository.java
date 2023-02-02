package com.example.productservice;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface brandsrepository extends MongoRepository<brands,Long> {
    
}
