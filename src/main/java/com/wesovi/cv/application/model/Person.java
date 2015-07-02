package com.wesovi.cv.application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "people")
@Data
public class Person implements FormEditableElement {

	@Id
	private String id;

	private String firstName;

	private String lastName;

	private Optional<Gender> gender;

	private Optional<LocalDate> bornDate;

	private ContactData contactData;

	private List<Education> education;

	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	public static class Builder {
		private String id;
		private String firstName;
		private String lastName;
		private Optional<Gender> gender;
		private Optional<LocalDate> bornDate;
		private ContactData contactData;
		private List<Education> education;
		private LocalDateTime createdDate;
		private LocalDateTime lastModifiedDate;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder gender(Optional<Gender> gender) {
			this.gender = gender;
			return this;
		}

		public Builder bornDate(Optional<LocalDate> bornDate) {
			this.bornDate = bornDate;
			return this;
		}

		public Builder contactData(ContactData contactData) {
			this.contactData = contactData;
			return this;
		}

		public Builder education(List<Education> education) {
			this.education = education;
			return this;
		}

		public Builder createdDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
			return this;
		}

		public Builder lastModifiedDate(LocalDateTime lastModifiedDate) {
			this.lastModifiedDate = lastModifiedDate;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}

	private Person(Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.gender = builder.gender;
		this.bornDate = builder.bornDate;
		this.contactData = builder.contactData;
		this.education = builder.education;
		this.createdDate = builder.createdDate;
		this.lastModifiedDate = builder.lastModifiedDate;
	}
}
