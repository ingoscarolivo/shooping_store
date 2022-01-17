package com.store.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.demo.models.ProductEntity;
 
@Repository
public interface ProductRepository
        extends JpaRepository<ProductEntity, Long> {
 
}


