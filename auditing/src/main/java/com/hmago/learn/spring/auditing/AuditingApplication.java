package com.hmago.learn.spring.auditing;

import com.hmago.learn.spring.auditing.model.Authority;
import com.hmago.learn.spring.auditing.model.User;
import com.hmago.learn.spring.auditing.repo.AuthorityRepo;
import com.hmago.learn.spring.auditing.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuditingApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AuthorityRepo authorityRepo;

	@Autowired
	private PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(AuditingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepo.save(User.builder().username("user1").password(encoder.encode("dev")).enabled(1).build());
		userRepo.save(User.builder().username("user2").password(encoder.encode("dev")).enabled(1).build());

		authorityRepo.save(Authority.builder().username("user1").role("USER").enabled(1).build());
		authorityRepo.save(Authority.builder().username("user2").role("USER").enabled(1).build());
	}
}
