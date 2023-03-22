package com.system.productorder.config;

import com.system.productorder.entities.Order;
import com.system.productorder.entities.User;
import com.system.productorder.repositories.OrderRepository;
import com.system.productorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Cristina Freitas","cristina@gmai.com" ,"999999", "12345");
        User u2 = new User(null,"David Michel", "David@gmail.com", "92999999", "32212");

        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:04Z"), u1);
        Order o2 = new Order(null, Instant.parse("2023-04-22T03:23:12Z"), u2);
        Order o3 = new Order(null, Instant.parse("2023-12-29T23:12:12Z"), u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}