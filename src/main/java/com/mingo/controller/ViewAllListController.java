package com.mingo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mingo.pojo.Contact;
import com.mingo.services.ContactService;

@Controller
public class ViewAllListController {
	
	private final ContactService contactService; // Change to interface

    @Autowired
    public ViewAllListController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/editContact")
	public String editContact( @RequestParam("cId") Integer contactId,Model model) {
		Contact contact=contactService.getContactById(contactId);
		contact.setcId(contactId);
		model.addAttribute("contact",contact);
		return "home";
	}
    @GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cId") Integer contactId,RedirectAttributes model) {
    	if(contactService.deleteContactById(contactId)) {
    		model.addFlashAttribute("successMsg","Contact deleted");
    	}else {
    		model.addFlashAttribute("successMsg","Contact not deleted");
    	}
    	return "redirect:/viewContacts";
	}
}
