/*
 * Author : Naveen Kumar
 * Date : 10-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.controller;

import com.niit.userproductservice.model.Product;
import com.niit.userproductservice.model.User;
import com.niit.userproductservice.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")

public class UserProductController {
    ResponseEntity responseEntity;
    UserProductService userProductService;
    @Autowired

    public UserProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }
    @GetMapping("/demo")
    public ResponseEntity <String> get() {
        return new ResponseEntity<String>("Sample", HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity<?> saveProducts(@RequestBody User user) {
        try {
            User user1= userProductService.saveUser(user);
            return new ResponseEntity<User>(user1, HttpStatus.OK);

        }
        catch (Exception e) {
            System.out.println("exception arised");
            return new ResponseEntity<String>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/product/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable ("email") String email){
        try {
            userProductService.deleteUser(email);
            responseEntity=new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
//    @GetMapping("/products")
//    public ResponseEntity<?> getAllProducts() {
//        try{
//            responseEntity=new ResponseEntity(userProductService.getProductList(),HttpStatus.OK);
//        }
//        catch (Exception e) {
//            responseEntity=new ResponseEntity (e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return responseEntity;
//    }
    @GetMapping("/products/{productName}")
    public ResponseEntity<?> getproductsByCustomer(@PathVariable String productName){
        try {
            responseEntity=new ResponseEntity(userProductService.getProductsByCustomer(productName),HttpStatus.OK);
        }

        catch (Exception e) {
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userProductService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getproductsByUserId(@PathVariable String userId) {

        List<Product> products=userProductService.getUserById(userId);
        return new ResponseEntity<>(products, HttpStatus.OK);



    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = userProductService.getProductList();
        return users;
    }





}
