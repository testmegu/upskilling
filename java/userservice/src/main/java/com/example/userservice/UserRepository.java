package com.example.userservice;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<UserModel, String> {

    Optional<UserModel> findByUserName(String username);

}
