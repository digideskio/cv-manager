package com.wesovi.cv.application.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Reference {
	
	private LocalDateTime referenceDate;
	
	private String fullName;
	
	private String title;
	
	private String content;

}
