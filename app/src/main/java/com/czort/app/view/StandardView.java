package com.czort.app.view;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import javax.annotation.PostConstruct;

public abstract class StandardView<PRESENTER extends StandardPresenter> extends CustomComponent implements View {

	@Autowired
	protected PRESENTER presenter;

	@Autowired
	protected ApplicationEventPublisher eventPublisher;

	public abstract Component root();

	@PostConstruct
	public void bootstrap() {
		presenter.bootstrap(this);
		setCompositionRoot(root());
		afterBootstrap();
	}

	protected void afterBootstrap() {

	}

}
