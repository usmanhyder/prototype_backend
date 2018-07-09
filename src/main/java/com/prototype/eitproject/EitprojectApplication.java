package com.prototype.eitproject;

import com.prototype.eitproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EitprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EitprojectApplication.class, args);
    }

    @Bean
    protected CommandLineRunner init(final UserRepository userRepository) {
        return args -> {
/*			User user = new User();
			user.setUsername("admin2");
			user.setPassword("admin2");
			user.setName("Administrator");
			user.setLastname("Last Name");
			user.setEmail("admin@javahelps.com");
			user.setCompany("Company A");
			user.setStatus(1);
			userRepository.save(user);*/

        };
    }
}
