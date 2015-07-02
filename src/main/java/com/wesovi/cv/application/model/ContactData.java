package com.wesovi.cv.application.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.Data;

import org.springframework.data.mongodb.core.index.TextIndexed;

@Data
public class ContactData {
	
	private Optional<String> fullAddress;
	
	@TextIndexed
	private String email;
	
	private Optional<List<String>> phones;
	
	private Optional<Map<SocialNetwork,String>> socialNetworkAccounts;
	
	
}
