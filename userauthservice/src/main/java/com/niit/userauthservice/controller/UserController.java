/*
 * Author : Naveen Kumar
 * Date : 10-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userauthservice.controller;

import com.niit.userauthservice.exception.UserAlreadyExists;
import com.niit.userauthservice.model.User;
import com.niit.userauthservice.service.SecurityTokenGenerator;
import com.niit.userauthservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    SecurityTokenGenerator securityTokenGenerator;
    UserService userService;
    @Autowired

    public UserController(SecurityTokenGenerator securityTokenGenerator, UserService userService) {
        this.securityTokenGenerator = securityTokenGenerator;
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> registerUser (@RequestBody User user) throws UserAlreadyExists {
        User user1 = userService.save(user);
        if(user1 != null){
            return new ResponseEntity<User>(user1, HttpStatus.CREATED);

        }else {
            return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/checkauth")
    public ResponseEntity<?> checkAuth(@RequestBody User user){
        User user2=userService.checkAuth(user);
        if(user2!=null){
            return new ResponseEntity<>(securityTokenGenerator.generateToken(user2),HttpStatus.OK);

        }else {
            return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }



}
