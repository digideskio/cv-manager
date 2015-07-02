package com.wesovi.cv.ui;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = HomeView.VIEW_NAME)
public class HomeView extends VerticalLayout implements View {

	private static final long serialVersionUID = 7024780329807307897L;
	public static final String VIEW_NAME = "";

    @PostConstruct
    void init() {
        addComponent(new Label("Home View"));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}
