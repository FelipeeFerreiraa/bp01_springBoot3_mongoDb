package com.felipeDev.bp01SpringBoot3MongoDb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipeDev.bp01SpringBoot3MongoDb.domain.Post;
import com.felipeDev.bp01SpringBoot3MongoDb.domain.User;
import com.felipeDev.bp01SpringBoot3MongoDb.dto.AuthorDTO;
import com.felipeDev.bp01SpringBoot3MongoDb.repository.PostRepository;
import com.felipeDev.bp01SpringBoot3MongoDb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		fmt.setTimeZone(TimeZone.getTimeZone("GMT")); // HORARIO DE LONDRES

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, "Livro entendendo algoritmos",
				"Livro para aprendizado de algoritmos básicos para a computação, usando python.....",
				fmt.parse("21/03/2025"), new AuthorDTO(maria));

		Post post2 = new Post(null, "Livro Senhores da guerra",
				"Livro sobre os principais individuos da segunda guerra mundia, sendo um britanico, um americano um russo e outro alemão",
				fmt.parse("29/03/2025"), new AuthorDTO(maria));

		Post post3 = new Post(null, "Livro Uma breve historia do tempo",
				"Escrito pelo professor Stephem Hawking, sobre física e buracos negros, tenhobq acabar de ler....",
				fmt.parse("29/03/2025"), new AuthorDTO(alex));

		postRepository.saveAll(Arrays.asList(post1, post2, post3));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.saveAll(Arrays.asList(maria));

		alex.getPosts().addAll(Arrays.asList(post3));
		userRepository.saveAll(Arrays.asList(alex));
	}

}
