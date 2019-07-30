package com.czort.app.backend;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class User {

	private Integer id;

	private String username;

	private String email;

}
