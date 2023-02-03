package com.example.cartservices;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface cartRepository extends MongoRepository<cartitems, Long> {
    
    @Query("{ 'username':{$regex:?0,$options:'i'} }") 
    List<cartitems> findusername(String brand);
}
