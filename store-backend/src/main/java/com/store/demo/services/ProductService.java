package com.store.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.demo.exception.RecordNotFoundException;
import com.store.demo.models.ProductEntity;
import com.store.demo.models.UserEntity;
import com.store.demo.repositories.ProductRepository;
 
@Service
public class ProductService {
     
    @Autowired
    ProductRepository repository;
     
    public List<ProductEntity> getAllProducts()
    {
        List<ProductEntity> productList = repository.findAll();
         
        if(productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<ProductEntity>();
        }
    }
     
    public ProductEntity getProductById(Long id) throws RecordNotFoundException
    {
        Optional<ProductEntity> product = repository.findById(id);
         
        if(product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
     
    public void deleteProductById(Long id) throws RecordNotFoundException
    {
        Optional<ProductEntity> product = repository.findById(id);
         
        if(product.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
}
