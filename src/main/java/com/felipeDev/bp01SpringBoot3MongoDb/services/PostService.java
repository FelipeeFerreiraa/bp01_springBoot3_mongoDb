package com.felipeDev.bp01SpringBoot3MongoDb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeDev.bp01SpringBoot3MongoDb.domain.Post;
import com.felipeDev.bp01SpringBoot3MongoDb.repository.PostRepository;
import com.felipeDev.bp01SpringBoot3MongoDb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // mecanismo de injeção de dependencia automatica do SpringBoot
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("OBEJECT NOT FOUND..."));
	}

}
