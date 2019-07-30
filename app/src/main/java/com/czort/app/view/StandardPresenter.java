package com.czort.app.view;

public abstract class StandardPresenter<VIEW, MODEL> {

	protected VIEW view;

	protected MODEL model;

	protected void bootstrap(VIEW view) {
		this.view = view;
	}

	protected abstract MODEL initialModel();

}
