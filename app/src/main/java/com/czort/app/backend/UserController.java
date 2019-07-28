package com.czort.app.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {
    @PostMapping() public ResponseEntity<User> save(@RequestBody User params);
    @PutMapping() public ResponseEntity<User> update(@RequestBody User params);
    @GetMapping("/{id}") public ResponseEntity<User> getById(@PathVariable("id") Integer id);
    @GetMapping() public ResponseEntity<List<User>> getAll();
}
