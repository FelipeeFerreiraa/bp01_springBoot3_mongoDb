package com.felipeDev.bp01SpringBoot3MongoDb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipeDev.bp01SpringBoot3MongoDb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
