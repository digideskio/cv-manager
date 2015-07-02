package com.wesovi.cv.ui;

import java.util.Optional;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.ui.TextField;
import com.wesovi.cv.application.model.FormEditableElement;
import com.wesovi.cv.application.model.Person;
import com.wesovi.cv.application.model.Person.Builder;
import com.wesovi.cv.application.service.PersonService;

@Log4j
@Component
public class PersonForm extends BaseEditionForm<PersonService,Person>{
	
	private static final long serialVersionUID = -3487679303512133552L;

	private Optional<String> id;
	
	private TextField tfFirstName = new TextField("First name:"); 
	
	private TextField tfLastName = new TextField("Last name:");
 
	
	@Autowired
	public PersonForm(PersonService personService){
		super(personService);
	}
	
	@Override
	protected void addFormComponents() {
		this.addComponent(tfFirstName);
		this.addComponent(tfLastName);
	}

	@Override
	protected void clearForm() {
		this.tfFirstName.clear();
		this.tfLastName.clear();	
	}

	@Override
	protected Person getElementInForm() {
		return new Builder()
			.id(id.get())
			.firstName(tfFirstName.getValue())
			.lastName(tfLastName.getValue()).build();
	}

	@Override
	protected FormEditionMode formEditionMode() {
		return id.isPresent()?FormEditionMode.UPDATE:FormEditionMode.CREATION;
	}
	
	
}
