package com.test.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.spring.bean.Car;
import com.test.spring.mvc.delegate.LoginDelegate;
import com.test.spring.mvc.viewBean.Form;

@Controller
public class LoginController {
	@Autowired
	private LoginDelegate loginDelegate;

	@Autowired
	private Car carObject;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, Form form) {
		carObject.engine();
		ModelAndView model = new ModelAndView("login");
		model.addObject("searchBean", form);
		return model;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("searchBean") Form form) {
		ModelAndView model = null;
		try {
			boolean isValidUser = loginDelegate.isValidUser(form.getEmployeeId(), form.getFirstName());
			if (isValidUser) {
				System.out.println("User Login Successful");
				model = new ModelAndView("welcome");
				model.addObject("userDetails",
						loginDelegate.fetchUserDetails(form.getEmployeeId(), form.getFirstName()));

			} else {
				model = new ModelAndView("login");
				model.addObject("message", "Either employee Id OR First Name is required to Search !!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}
}
