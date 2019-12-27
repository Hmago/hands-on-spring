package com.hmago.learn.spring.annotations;

import com.hmago.learn.spring.annotations.model.Authority;
import com.hmago.learn.spring.annotations.model.User;
import com.hmago.learn.spring.annotations.repo.AuthorityRepo;
import com.hmago.learn.spring.annotations.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AnnotationsApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AuthorityRepo authorityRepo;

	@Autowired
	private PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(AnnotationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepo.save(User.builder().username("user1").password(encoder.encode("user1")).status(1).build());
		userRepo.save(User.builder().username("user2").password(encoder.encode("user2")).status(1).build());

		authorityRepo.save(Authority.builder().username("user1").role("USER").build());
		authorityRepo.save(Authority.builder().username("user1").role("ADMIN").build());
		authorityRepo.save(Authority.builder().username("user2").role("USER").build());
	}
}
