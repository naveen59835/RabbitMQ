package com.niit.userauthservice.service;

import com.niit.userauthservice.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public Map<String, String> generateToken(User user);

}
