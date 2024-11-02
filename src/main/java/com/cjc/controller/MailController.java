package com.cjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjc.model.User;
import com.cjc.service.MailService;

@Controller
public class MailController {

	@Autowired
	private MailService service;

	@RequestMapping("/")
	public String MailCheck() {
		return "index";

	}

	@RequestMapping("/logpage")
	public String loginPage() {
		System.out.println("Login :: Page Called");
		return "login";
	}

	@RequestMapping("/regpage")
	public String RegisterPage() {
		System.out.println("Register :: Page Called");
		return "register";
	}

	@ResponseBody
	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute User user) {
		System.out.println(user);
		service.saveUser(user);
		System.out.println("Data Saved");
		return "Thank you for registration";
	}

	@RequestMapping("/loginUser")
	public Object loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		User use = service.loginUser(username, password);

		boolean flag = use != null;

		if (flag) {
			model.addAttribute("data", use);
			return "success";
		} else
			return "index";

	}

}
