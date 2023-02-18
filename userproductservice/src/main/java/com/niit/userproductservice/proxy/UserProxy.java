package com.niit.userproductservice.proxy;

import com.niit.userproductservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-auth-service",url ="localhost:8082")
public interface UserProxy {
    @PostMapping("/api/v1/user")
    public ResponseEntity saveUserInAuth(@RequestBody User user);

}
