package com.example.productservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "brands")
public class brands {

    @Id
    private Long Brandid;
    private String Name;
    public Long getBrandid() {
        return Brandid;
    }
    public void setBrandid(Long brandid) {
        Brandid = brandid;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
   
   
    

    
}
