package com.czort.app.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {
    @PostMapping("/user") public ResponseEntity<User> save(@RequestBody User params);
    @PutMapping("/user") public ResponseEntity<User> update(@RequestBody User params);
    @GetMapping("/user/{id}") public ResponseEntity<User> getById(@PathVariable("id") Integer id);
    @GetMapping("/user") public ResponseEntity<List<User>> getAll();
}
