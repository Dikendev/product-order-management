package com.system.productorder.resources;

import com.system.productorder.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User a = new User(1L, "Diego", "diken.dev@gmail.com",
                "47991717381", "999999");
        return ResponseEntity.ok().body(a);
    }
}
