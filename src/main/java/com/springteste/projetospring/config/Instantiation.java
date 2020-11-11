package com.springteste.projetospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springteste.projetospring.domain.Post;
import com.springteste.projetospring.domain.User;
import com.springteste.projetospring.dto.AuthorDTO;
import com.springteste.projetospring.repositories.PostRepository;
import com.springteste.projetospring.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "BobGrey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		
		Post p1 = new Post(null, Instant.parse("2017-12-25T20:30:50Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post p2 = new Post(null, Instant.parse("2018-03-23T15:45:19Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		maria.getPosts().addAll(Arrays.asList(p1,p2));
		userRepository.save(maria);
	}
}
