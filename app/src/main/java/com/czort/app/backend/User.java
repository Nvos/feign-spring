package com.czort.app.backend;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of={ "id" })
public class User {
    private Integer id;
    private String username;
    private String email;
}
