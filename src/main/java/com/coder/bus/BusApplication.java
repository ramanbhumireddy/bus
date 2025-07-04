package com.coder.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@SpringBootApplication
public class BusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusApplication.class, args);
	}


	private final UserRepository userRepository;

	@Autowired
	public BusApplication(UserRepository userRepository){
		this.userRepository  = userRepository;
	}

	@GetMapping(value = "/")
	public String welcome(){
		return "welcome -" + System.currentTimeMillis();
	}

	@PostMapping(value= "/addUser")
	public String saveUser(@RequestBody User user) {
		userRepository.save(user);
		return "User added successfully::"+user.getId();

	}

	@GetMapping(value="/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping(value="/findUser/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}

	@GetMapping(value="/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "Deleted User Successfully::"+id;
	}

}
