package com.example.demo.service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private Repo repository;

    public ProductEntity saveProductEntity(ProductEntity product){
        return repository.save(product);
    }
    public List<ProductEntity> saveProductEntity(List<ProductEntity> products) {
        return repository.saveAll(products);
    }

    public List<ProductEntity> getProducts(){
        return repository.findAll();
    }
    public ProductEntity getproductsById(int id){
        return repository.findById(id).orElse(null);
    }
    public ProductEntity getproductsByName(String name){
        return repository.findByName(name);
    }

    //method delete
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed! "+id;
    }

    public ProductEntity updateProduct(ProductEntity product){
    ProductEntity existingProduct = repository.findById(product.getId()).orElse(null);
    existingProduct.setName(product.getName());
    existingProduct.setDescription(product.getDescription());
    existingProduct.setPrice(product.getPrice());
    return repository.save(existingProduct);
    }
}
