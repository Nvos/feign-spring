package com.czort.app.backend;

import com.czort.app.client.UserClient;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest {

	@Autowired
	private UserClient userClient;

	@Test
	public void saveUser() {
	    // https://assertj.github.io/doc/#assertj-core-recursive-comparison
		User user = User.builder().email("email").username("username").build();
		ResponseEntity<User> result = userClient.save(user);
		assertThat(HttpStatus.OK, Matchers.equalTo(result.getStatusCode()));
		assertThat(user, Matchers.samePropertyValuesAs(result.getBody(), "id"));
	}

}
