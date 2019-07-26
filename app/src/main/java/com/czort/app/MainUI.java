package com.czort.app;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import lombok.RequiredArgsConstructor;

@SpringUI
@Theme("valo")
@Title("Main")
@SpringViewDisplay
@RequiredArgsConstructor
public class MainUI extends UI {

    private final SpringNavigator springNavigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        springNavigator.addView(MainView.VIEW_NAME, MainView.class);
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        setContent(root);

        springNavigator.navigateTo(MainView.VIEW_NAME);
    }
}
