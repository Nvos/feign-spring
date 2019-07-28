package com.czort.app;

import com.czort.app.backend.User;
import com.czort.app.client.UserClient;
import com.czort.app.view.StandardPresenter;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ViewScope
@SpringComponent
@RequiredArgsConstructor
public class MainPresenter extends StandardPresenter<MainView, MainModel> {
    private final UserClient userClient;

    public List<User> findUsers() {
        return userClient.getAll().getBody();
    }

    public User createUser(User params) {
        return userClient.save(params).getBody();
    }

    public User updateUser(User params) {
        return userClient.update(params).getBody();
    }

    public User findUserById(Integer id) {
        return userClient.getById(id).getBody();
    }

    @Override
    protected MainModel initialModel() {
        return new MainModel();
    }
}
