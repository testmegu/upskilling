package com.example.cartservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.models.HttpMethod;

@RestController
public class cartcontroller {
    
    
    @Autowired
    RestTemplate restTemplate;
  @Autowired
    services cartservice;

    @Autowired
    private cartRepository repo;
    @Autowired 
    private repository repository;

    
    @PostMapping("/addtocart/allproducts/{id}")
    /* public ResponseEntity<?> addtocart(@PathVariable Long id,@RequestBody products product,cartitems Cart) */
     public void addtocart(@PathVariable Long id,cartitems cart,String Username)
    {
        products product =repository.findById(id).orElse(null);
        cart.setProductid(product.getId());
        cart.setSubtotal(product.getListprice());
        cart.setUsername(Username);
        repo.save(cart);
    }

    @GetMapping("/mycart/{username}")
    public List<cartitems> mycart(@PathVariable String username)
    {
        return repo.findusername(username);
        
    }
     
 
// restTemplate.exchange("http://localhost:8082/allproducts/"+id,HttpMethod.GET, product,RequestResponse.class );
    /* @PutMapping("/allproducts/{id}")
    public ResponseEntity<?> editproduct(@PathVariable Long id,@RequestBody products product) {
        restTemplate.put("http://localhost:8082/allproducts/"+id, product,RequestResponse.class );
        //("http://localhost:8082/allproducts/"+id);
        return ResponseEntity.ok("product Updated!"); */
/* 
        @PostMapping("/addtocart/{id}")
    public String addtocart(@PathVariable Long id,cartitems cart,String Username)
    {
        cartservice.addtocart(id, cart, Username);
        return Username;

    } */



    }

