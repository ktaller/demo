package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByName (String name);
}
