package com.example.cartservices;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
public class cartitems
{

    private Long cartid;
    public Long getProductid() {
        return productid;
    }
    public void setProductid(Long productid) {
        this.productid = productid;
    }
    private Long productid;
    private double subtotal;
    private String username;
    public Long getCartid() {
        return cartid;
    }
    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }
   
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
   

    

}