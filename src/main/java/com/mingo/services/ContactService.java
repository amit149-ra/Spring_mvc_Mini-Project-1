package com.mingo.services;

import com.mingo.pojo.Contact;

import java.util.List;

public interface ContactService {
	public Boolean saveContact(Contact c);
	public List<Contact> getAllContact();
	public Contact getContactById(Integer cid);
	public boolean deleteContactById(Integer cid);
	
}
