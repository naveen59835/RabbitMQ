package com.niit.userproductservice.repo;

import com.niit.userproductservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductRepo extends MongoRepository<User,String> {
    @Query("{'productList.productName':{$in:[?0]}}")
    List<User> findByCustomer (String name);


}
