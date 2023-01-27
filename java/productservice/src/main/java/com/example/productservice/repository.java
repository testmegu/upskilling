package com.example.productservice;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends MongoRepository<products,Long>{

   // Optional<products> findById(String id);

//    public  List<products>findbyname(String productname);

   
//   List<products> findProductsByproductname(String Productname);
    @Query("{ 'Brand':{$regex:?0,$options:'i'} }") 
    List<products> findProductsByproductname(String brand);


    
    
}
