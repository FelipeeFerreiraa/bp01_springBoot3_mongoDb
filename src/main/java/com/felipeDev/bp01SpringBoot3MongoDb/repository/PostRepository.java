package com.felipeDev.bp01SpringBoot3MongoDb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipeDev.bp01SpringBoot3MongoDb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	// QueryMethods
	List<Post> findByTitleContainingIgnoreCase(String text);

}
