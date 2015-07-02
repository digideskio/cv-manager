package com.wesovi.cv.ui;

import javax.annotation.PostConstruct;

import lombok.extern.log4j.Log4j;

import org.springframework.context.annotation.Scope;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.wesovi.cv.application.model.FormEditableElement;
import com.wesovi.cv.application.service.BaseService;


@Log4j
@Scope("prototype")
public abstract class BaseEditionForm<S extends BaseService<E>, E extends FormEditableElement> extends FormLayout{

	private static final long serialVersionUID = -8664018690033240553L;

	protected final S service;
	
	public BaseEditionForm(S service){ 
		this.service = service;
	}
	
	protected abstract void addFormComponents(); 
	
	protected abstract FormEditionMode formEditionMode();
	
	protected abstract void clearForm();
	
	protected abstract E getElementInForm();
	
	protected void sendForm(){
		log.debug("Persisting element into the database.");
		FormEditionMode mode = formEditionMode();
		if(FormEditionMode.CREATION.equals(mode)){
			createElement();
		}else{
			updateElement();
		}
	}
	
	
	
	@PostConstruct
	private void initForm(){
		this.addFormComponents();
		
		final Button commit = new Button("Commit");
        final Button cancel = new Button("Cancel");

        cancel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
            	clearForm();
            }
        });
        commit.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                sendForm();
                clearForm();
            }
        });
        final HorizontalLayout buttonBar = new HorizontalLayout();

        buttonBar.addComponent(commit);
        buttonBar.addComponent(cancel);

        addComponent(buttonBar);
	}
	
	private void createElement(){
		E element  = getElementInForm();
		service.create(element);
	}
	
	private void updateElement(){
		E element  = getElementInForm();
		service.update(element);
	}
}
