package com.springteste.projetospring.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springteste.projetospring.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User pedro = new User("1", "Pedro", "pedro@email.com");
		User maicon = new User("2", "Maicon", "maicon@email.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(pedro, maicon));
		return ResponseEntity.ok().body(list);
		
	}

}
