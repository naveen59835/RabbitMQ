/*
 * Author : Naveen Kumar
 * Date : 10-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userauthservice.service;

import com.niit.userauthservice.exception.UserAlreadyExists;
import com.niit.userauthservice.model.User;
import com.niit.userauthservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;


    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User save(User user) throws UserAlreadyExists {
        return userRepo.save(user);
    }

    @Override
    public User checkAuth(User user) {
        User user1 =userRepo.findById(user.getUserId()).get();
        if(user1 != null){
            if(user1.getPassword().equals(user.getPassword())){
                return user;

            }else {
                return null;
            }
        }else {
            return null;
        }
    }

}
