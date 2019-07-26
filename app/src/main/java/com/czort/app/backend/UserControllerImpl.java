package com.czort.app.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<User> save(User params) {
        return ResponseEntity.ok(userService.save(params));
    }

    @Override
    public ResponseEntity<User> update(User params) {
        return ResponseEntity.ok(userService.update(params));
    }

    @Override
    public ResponseEntity<User> getById(Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @Override
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity handleException() {
        return ResponseEntity.notFound().build();
    }
}
