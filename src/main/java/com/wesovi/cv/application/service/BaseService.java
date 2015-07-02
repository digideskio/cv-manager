package com.wesovi.cv.application.service;

import com.wesovi.cv.application.model.FormEditableElement;

public interface BaseService<E extends FormEditableElement> {

	void create(E element);
	
	void update(E element);
}
