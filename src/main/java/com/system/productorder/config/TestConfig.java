package com.system.productorder.config;

import com.system.productorder.entities.*;
import com.system.productorder.entities.enums.OrderStatus;
import com.system.productorder.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Cellphones");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null, "Iphone 11", "Desempenho incrivel", 500.4,"");
        Product p2 = new Product(null, "Head first Java", "Melhor livro sobre java", 1800.1, "");
        Product p3 = new Product(null, "Macbook m1", "Incrivel", 6000.3, "");
        Product p4 = new Product(null, "Iphone 14", "É o futuro", 540.2, "");
        Product p5 = new Product(null, "Macbook pro m2", "Vai ser a meta desse ano", 9333.45, "");

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(c1);
        p2.getCategories().add(c2);
        p3.getCategories().add(c3);
        p4.getCategories().add(c1);
        p5.getCategories().add(c3);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Cristina Freitas", "cristina@gmai.com" , "999999", "12345");
        User u2 = new User(null, "David Michel", "David@gmail.com", "92999999", "32212");

        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:04Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2023-04-22T03:23:12Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2023-12-29T23:12:12Z"), u1, OrderStatus.DELIVERED);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 1, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p2, 2, p2.getPrice());
        OrderItem oi3 = new OrderItem(o2, p2, 2, p2.getPrice());
        OrderItem oi4 = new OrderItem(o3,p3, 1, p3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2023-06-20T21:00:03Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}