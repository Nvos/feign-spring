package com.czort.app;

import com.czort.app.backend.User;
import com.czort.app.client.UserClient;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.Query;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@SpringComponent
@SpringView(name = MainView.VIEW_NAME)
@RequiredArgsConstructor
public class MainView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "MainView";

    private final UserClient userClient;
    private Grid<User> grid;
    private Binder<User> userBinder;

    private Grid<User> createUserGrid() {
        Grid<User> grid = new Grid<>();
        grid.setItems(Objects.requireNonNull(userClient.getAll().getBody()));

        grid.addColumn(User::getId).setCaption("id");
        grid.addColumn(User::getUsername).setCaption("username");
        grid.addColumn(User::getEmail).setCaption("email");

        grid.addItemClickListener(event -> {
            if(event.getMouseEventDetails().isDoubleClick()) {
                userBinder.setBean(event.getItem());
            }
        });

        return grid;
    }

    private VerticalLayout createUserForm() {
        userBinder = new Binder<>(User.class);
        userBinder.setBean(new User());

        TextField nameField = new TextField();
        TextField emailField = new TextField();

        userBinder.forField(nameField).bind("username");
        userBinder.forField(emailField).bind("email");

        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(nameField);
        layout.addComponent(emailField);

        Button save = new Button("Save", (clickEvent) -> {

            User bean = userBinder.getBean();
            User result = null;
            if (bean.getId() != null) {
                result = userClient.update(bean).getBody();
                grid.getDataProvider().refreshItem(result);
            } else {
                result = userClient.save(bean).getBody();
                List<User> users = grid.getDataProvider().fetch(new Query<>()).collect(Collectors.toList());
                users.add(0, result);
                grid.setItems(users);
                grid.getDataProvider().refreshAll();
            }

            userBinder.setBean(new User());
        });

        layout.addComponent(save);

        return layout;
    }

    @PostConstruct()
    public void init() {
        log.info("Init");

        addComponent(createUserForm());
        this.grid = createUserGrid();
        addComponent(grid);
    }
}
