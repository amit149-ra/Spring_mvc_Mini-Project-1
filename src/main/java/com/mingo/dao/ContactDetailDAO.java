package com.mingo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mingo.services.ContactService;

@Repository
public class ContactDetailDAO {

	private final ContactService contactService;

	@Autowired
	public ContactDetailDAO(ContactService contactService) {
		this.contactService = contactService;
	}
	
//	public void save(String name, String email) {
//		contactService.saveContact(name, email);
//	}
}
