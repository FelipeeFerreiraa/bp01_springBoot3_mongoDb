package com.felipeDev.bp01SpringBoot3MongoDb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipeDev.bp01SpringBoot3MongoDb.domain.User;
import com.felipeDev.bp01SpringBoot3MongoDb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	// @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {

//		User aux = new User("1", "Felipe Domingues", "felipe@gmail.com");
//		User aux1 = new User("2", "Irineu Ferreira", "irineu@gmail.com");

		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

}
