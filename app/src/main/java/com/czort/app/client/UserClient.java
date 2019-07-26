package com.czort.app.client;

import com.czort.app.backend.UserController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "http://localhost:8080")
public interface UserClient extends UserController {
}
