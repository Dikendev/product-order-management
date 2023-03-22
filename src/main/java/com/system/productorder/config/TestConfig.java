package com.system.productorder.config;

import com.system.productorder.entities.User;
import com.system.productorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Cristina Freitas","cristina@gmai.com" ,"999999", "12345");
        User u2 = new User(null,"David Michel", "David@gmail.com", "92999999", "32212");
        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
