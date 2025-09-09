package com.felipeDev.bp01SpringBoot3MongoDb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeDev.bp01SpringBoot3MongoDb.domain.User;
import com.felipeDev.bp01SpringBoot3MongoDb.repository.UserRepository;

@Service
public class UserService {

	@Autowired // mecanismo de injeção de dependencia automatica do SpringBoot
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
}
