package com.example.demo.controllers;

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllers {

    @Autowired
    private ProductService service;
    //post
    @PostMapping("/addProduct")
    public ProductEntity addProduct(@RequestBody ProductEntity product){
        return service.saveProductEntity(product);
    }

    @PostMapping("/addProducts")
    public List<ProductEntity> addProducts(@RequestBody List<ProductEntity> products){
        return service.saveProductEntity(products);
    }
    //get
    @GetMapping("/products")
    public List<ProductEntity> findAllProducts(){
        return service.getProducts();
    }
    @GetMapping("/product/{id}")
    public ProductEntity findProductById(@PathVariable int id){
        return service.getproductsById(id);
    }
    @GetMapping("/products/{name}")
    public ProductEntity findProductByName(@PathVariable String name){
        return service.getproductsByName(name);
    }
    //put
    @PutMapping("/update")
    public ProductEntity updateProduct(@RequestBody ProductEntity product){
        return service.updateProduct(product);
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
