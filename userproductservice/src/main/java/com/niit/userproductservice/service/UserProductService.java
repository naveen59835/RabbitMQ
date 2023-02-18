package com.niit.userproductservice.service;

import com.niit.userproductservice.model.Product;
import com.niit.userproductservice.model.User;
import com.niit.userproductservice.repo.UserProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserProductService {

    User saveUser(User user);

    boolean deleteUser(String email);
    List<User> getProductList();
    List<User> getProductsByCustomer(String productName);
    User createUser(User user);
    List <Product> getUserById(String userId);
}
