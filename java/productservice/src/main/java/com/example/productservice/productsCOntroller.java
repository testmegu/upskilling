package com.example.productservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class productsCOntroller {
    
    @Autowired
    private repository Repository;

    @GetMapping("/")
    public String hello()
    {
        return "<hello>";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addproduct")
    public ResponseEntity<?> addproduct(@RequestBody products product) {
        Repository.save(product);
        return ResponseEntity.ok("Added product to the Database with id: " + product.getId());
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/allproducts")
    public List<products> getAllproducts() {
        return Repository.findAll();
    }
     @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/allproducts/{id}")
    public Optional<products> getproduct(@PathVariable Long id) {
        return Repository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteproduct(@PathVariable Long id) throws Exception {
        Repository.deleteById(id);
        return ResponseEntity.ok("Added product to the Database with id: " + id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/allproducts/{id}")
     public ResponseEntity<products> updateproductbyid(@PathVariable Long id,@RequestBody products productdetaails)
     {
         products product=Repository.findById(id).orElseThrow(()->new exception("productnot found"));
    
         product.setProductname(productdetaails.getProductname());
         product.setBrand(productdetaails.getBrand());
         product.setRam(productdetaails.getRam());
         product.setRom(productdetaails.getRom());
         product.setWeight(productdetaails.getWeight());
         product.setPublisher(productdetaails.getPublisher());
         product.setListprice(productdetaails.getListprice());  
         product.setImg(productdetaails.getImg());
         product.setDiscription(productdetaails.getDiscription());

         products updatedproduct=Repository.save(product);
        return ResponseEntity.ok(updatedproduct);
     }



    @GetMapping("/allproduct/{brand}")
    public @ResponseBody List<products> getProductById(@PathVariable String brand) {
		return Repository.findProductsByproductname(brand);
        // productService.findProductsByCategory(categoryName);
	}

    

     



}
