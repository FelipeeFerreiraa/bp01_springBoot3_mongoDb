package com.felipeDev.bp01SpringBoot3MongoDb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeDev.bp01SpringBoot3MongoDb.domain.User;
import com.felipeDev.bp01SpringBoot3MongoDb.dto.UserDTO;
import com.felipeDev.bp01SpringBoot3MongoDb.repository.UserRepository;
import com.felipeDev.bp01SpringBoot3MongoDb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired // mecanismo de injeção de dependencia automatica do SpringBoot
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("OBEJECT NOT FOUND..."));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
