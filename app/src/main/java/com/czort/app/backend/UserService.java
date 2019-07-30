package com.czort.app.backend;

import java.util.List;

public interface UserService {

	User save(User user);

	User update(User user);

	User getById(Integer id);

	List<User> getAll();

}
