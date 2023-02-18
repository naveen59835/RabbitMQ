package com.niit.userauthservice.service;

import com.niit.userauthservice.exception.UserAlreadyExists;
import com.niit.userauthservice.model.User;

public interface UserService {
    User save(User user) throws UserAlreadyExists;
    public User checkAuth(User user);
}
