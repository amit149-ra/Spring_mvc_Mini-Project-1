package com.mingo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mingo.entity.ContactDetails;
import com.mingo.pojo.Contact;
import com.mingo.repo.ContactDtlsRepo;

@Service
@Transactional
public class ContactServicesImpl implements ContactService {
	
	private final ContactDtlsRepo contactDtlsRepo;

	@Autowired
	public ContactServicesImpl(ContactDtlsRepo contactDtlsRepo) {
		this.contactDtlsRepo = contactDtlsRepo;
	}

	@Override
	public Boolean saveContact(Contact c) {
		ContactDetails entity=new ContactDetails();
		BeanUtils.copyProperties(c, entity);
//		if(contactDtlsRepo.findById(c.getcId()).isPresent()) {
//			return contactDtlsRepo.
//		}
		System.out.println(entity);
		return contactDtlsRepo.save(entity).getCId()!=null;
	}

	@Override
	public List<Contact> getAllContact() {
		List<ContactDetails> contactDetails=(List<ContactDetails>) contactDtlsRepo.findAll();
		List <Contact> contacts=new ArrayList();
		
		for(ContactDetails entity :contactDetails) {
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			contacts.add(contact);
		}
		return contacts;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactDetails> optional= contactDtlsRepo.findById(cid);
		if(optional.isPresent()) {
			ContactDetails entity=optional.get();
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		Optional<ContactDetails> optional= contactDtlsRepo.findById(cid);
		if (optional.isPresent()) {
			contactDtlsRepo.deleteById(cid);
		    if (!contactDtlsRepo.existsById(cid)) {
		        System.out.println("Record deleted successfully");
		        return true;
		    } else {
		        System.out.println("Record deletion failed");
		    }
		} else {
		    System.out.println("Record not found");
		}
		return false;

	}
	
	
	
//	public void saveContact(String name, String email) {
//		ContactDetails con = new ContactDetails();
//		con.setCName(name);
//		con.setCEmail(email);
//		contactDtlsRepo.save(con);
//	}
}
