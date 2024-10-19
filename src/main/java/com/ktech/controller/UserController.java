package com.ktech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktech.entity.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}

	@PostMapping("/user")
	public String formSubmit(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index";
		}
		logger.info("success ");
		model.addAttribute("msg", "Successfully Login...!");
		return "success";
	}
}
