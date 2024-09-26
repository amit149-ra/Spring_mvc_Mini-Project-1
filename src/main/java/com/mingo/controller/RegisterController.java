package com.mingo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mingo.dao.ContactDetailDAO;
import com.mingo.pojo.Contact;
import com.mingo.services.ContactService;
import com.mingo.services.ContactServicesImpl;

@Controller
public class RegisterController {
	
	private final ContactService contactService; // Change to interface

    @Autowired
    public RegisterController(ContactService contactService) {
        this.contactService = contactService;
    }

	@GetMapping("/")
	public String loadContactForm(Model model) {
		Contact contactObj=new Contact();
		model.addAttribute("contact",contactObj);
		return "home";
	}
	
	@PostMapping("/saveContact")
	public String handleSubmitButton(@ModelAttribute("contact") Contact contact,RedirectAttributes model) {
		
		if(contactService.saveContact(contact)) {
			if(contact.getcId()!=null) {
				model.addFlashAttribute("successMsg","Update saved");
				return "redirect:/submitContact";
			}
			model.addFlashAttribute("successMsg","Contact saved");
		}else {
			model.addFlashAttribute("failedMsh","Contact not saved");
		}
		return "redirect:/submitContact";
	}
	
	@GetMapping("/submitContact")
	public String submitContactForm(Model model) {
		Contact contactObj=new Contact();
		model.addAttribute("contact",contactObj);
		return "home";
	}
	
	@GetMapping("/viewContacts")
	public String viewContact(Model model) {
		List<Contact> contacts=contactService.getAllContact();
		model.addAttribute("contacts",contacts);
		return "viewContacts";
	}
	
}
