package com.czort.app.client;

import com.czort.app.backend.UserController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "localhost:8080/user")
public interface UserClient extends UserController {
}
