package com.test.spring.mvc.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.spring.mvc.service.UserService;
import com.test.spring.mvc.viewBean.Form;

@Controller
public class OperationController {
	@Autowired
	private UserService service;

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST, params = "Search")
	public String submit(@ModelAttribute("searchBean") final Form form, final BindingResult result,
			final ModelMap model) throws SQLException {

		model.addAttribute("userDetails", service.retrieveUserDetails(form.getEmployeeId(), form.getFirstName()));
		return "welcome";

	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST, params = "cancel")
	public String cancel(@ModelAttribute("searchBean") final Form form, 
	  final BindingResult result, final ModelMap model) {
	    model.addAttribute("message", "You clicked cancel, please re-enter employee details:");
	    return "login";
	}

}
