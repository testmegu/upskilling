package com.example.blogs;

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
import org.springframework.web.bind.annotation.RestController;


@RestController
public class blogscontroller {
    

    @Autowired
    private BlogRepository repo;
    
    @GetMapping("/")
    public String hello()
    {
        return "<hello>";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addblog")
    public ResponseEntity<?> addproduct(@RequestBody blogs product) {
        repo.save(product);
        return ResponseEntity.ok("Added User to the Database with id: " + product.getId());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/allblogs")
    public List<blogs> getAllproducts() {
        return repo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/allblogs/{id}")
    public Optional<blogs> getproduct(@PathVariable Long id) {
        return repo.findById(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws Exception {
        repo.deleteById(id);
        return ResponseEntity.ok("Added User to the Database with id: " + id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/allblogs/{id}")
    public ResponseEntity<blogs> updateproductbyid(@PathVariable Long id,@RequestBody blogs productdetaails)
    {
        blogs blog=repo.findById(id).orElseThrow(()->new exception("productnot found"));
   
       blog.setHeadline(productdetaails.getHeadline());
       blog.setDiscription(productdetaails.getDiscription());
       blog.setImg(productdetaails.getImg());
       blog.setProductname(productdetaails.getProductname());


       

        blogs updatedproduct=repo.save(blog);
       return ResponseEntity.ok(updatedproduct);
    }

}
