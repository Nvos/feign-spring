package com.czort.app.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class StandardView<PRESENTER extends StandardPresenter> extends CustomComponent implements View {

    @Autowired
    protected PRESENTER presenter;

    public abstract Component root();

    @PostConstruct
    public void bootstrap() {
        presenter.bootstrap(this);
        setCompositionRoot(root());
    }
}
