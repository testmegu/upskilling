package com.example.productservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class products
{
    
    private Long id;
    private String Productname;
   
    private String Brand;
    private String Ram;
    private String Rom;
    private String Weight;
    private String Publisher;
    private double Listprice;
    private String img;
    private String discription;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProductname() {
        return Productname;
    }
    public void setProductname(String productname) {
        Productname = productname;
    }
 
    public String getRam() {
        return Ram;
    }
    public void setRam(String ram) {
        Ram = ram;
    }
    public String getRom() {
        return Rom;
    }
    public void setRom(String rom) {
        Rom = rom;
    }
    public String getWeight() {
        return Weight;
    }
    public void setWeight(String weight) {
        Weight = weight;
    }
    public String getPublisher() {
        return Publisher;
    }
    public void setPublisher(String publisher) {
        Publisher = publisher;
    }
    public double getListprice() {
        return Listprice;
    }
    public void setListprice(double listprice) {
        Listprice = listprice;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    public String getBrand() {
        return Brand;
    }
    public void setBrand(String brand) {
        Brand = brand;
    }
    /* public products(Long id, String productname, String brand, String ram, String rom, String weight, String publisher,
            double listprice, String img, String discription) {
        this.id = id;
        Productname = productname;
        Brand = brand;
        Ram = ram;
        Rom = rom;
        Weight = weight;
        Publisher = publisher;
        Listprice = listprice;
        this.img = img;
        this.discription = discription;
    } */
   /*  public products(long id2, String productname2, String brand2, String ram2, String rom2, String weight2,
            String publisher2, double listprice2, String img2, String discription2) {
    } */

   
  
  
}