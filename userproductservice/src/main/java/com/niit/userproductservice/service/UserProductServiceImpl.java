package com.niit.userproductservice.service;

import com.niit.userproductservice.config.ProductDTO;
import com.niit.userproductservice.model.Product;
import com.niit.userproductservice.model.User;
import com.niit.userproductservice.proxy.UserProxy;
import com.niit.userproductservice.repo.UserProductRepo;
import org.json.simple.JSONObject;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserProductServiceImpl implements UserProductService {
    @Autowired
    UserProductRepo userProductRepo;
    @Autowired
    UserProxy userProxy;
    @Autowired
    DirectExchange exchange;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    public UserProductServiceImpl(UserProductRepo userProductRepo) {
        this.userProductRepo = userProductRepo;
    }




    @Override
    public User saveUser(User user) {
        User user2= userProductRepo.save(user);
        if(!user2.getUserId().isEmpty()) {
            ResponseEntity responseEntity=userProxy.saveUserInAuth(user2);


        }
        return user2;
    }

    @Override
    public boolean deleteUser(String email) {
        if(userProductRepo.findById(email).isPresent()){
            User user1=userProductRepo.findById(email).get();
            userProductRepo.delete(user1);
            return true;

        }
        return false;

    }

    @Override
    public List<User> getProductList() {
        return userProductRepo.findAll();
    }

    @Override
    public List<User> getProductsByCustomer(String productName) {
        return userProductRepo.findByCustomer(productName);
    }

    @Override
    public User createUser(User user) {
        return userProductRepo.save(user);
    }


    @Override
    public List<Product> getUserById(String userId) {
        List<Product> users = userProductRepo.findById(userId).get().getProductList();
        ProductDTO productDTO=new ProductDTO();
        List<Product> notInStock = new ArrayList<>();
        for (Product prod: users) {
            if(!prod.isProductInStock()) {
                notInStock.add(prod);
            }

        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("notInStock",notInStock);
        jsonObject.put("userId",userId);
        rabbitTemplate.convertAndSend(exchange.getName(),"direct-routing",productDTO);
        return users;

    }
}
