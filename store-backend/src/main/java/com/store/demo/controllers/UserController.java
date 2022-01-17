package com.store.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.demo.exception.RecordNotFoundException;
import com.store.demo.models.ProductEntity;
import com.store.demo.models.UserEntity;
import com.store.demo.services.UserService;
import com.store.demo.services.ProductService;
 
@RestController
@RequestMapping("/store")
public class UserController
{
    @Autowired
    UserService service;
    
    @Autowired
    ProductService productService;
 
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> list = service.getAllUsers();
 
        return new ResponseEntity<List<UserEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> list = productService.getAllProducts();
 
        return new ResponseEntity<List<ProductEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        UserEntity entity = service.getUserById(id);
 
        return new ResponseEntity<UserEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
	/*
	 * @PostMapping public ResponseEntity<EmployeeEntity>
	 * createOrUpdateEmployee(EmployeeEntity employee) throws
	 * RecordNotFoundException { EmployeeEntity updated =
	 * service.createOrUpdateEmployee(employee); return new
	 * ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK); }
	 */
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}