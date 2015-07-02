package com.wesovi.cv.application.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import lombok.Data;

@Data
public class Education {
	
	private String title;
	
	private String resume;
	
	private LocalDate fromDate;
	
	private Optional<LocalDate> untilDate;
	
	private Optional<List<Reference>> references;
}
