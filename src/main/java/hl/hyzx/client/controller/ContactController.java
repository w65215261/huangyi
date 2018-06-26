package hl.hyzx.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hl.hyzx.client.dto.ContactDTO;
import hl.hyzx.client.service.ContactService;


@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping("contactClient")
	public String contactClient(Model model) {
		List<ContactDTO> contacts =  contactService.getContactList();
		model.addAttribute("contacts", contacts);
		return "client/contact";
	}
	
}