package com.valtech.training.firstspringboot.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.firstspringboot.models.ChangePasswordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.services.AuthenticationService;

@Controller
public class AuthenticationController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@PostMapping("changePassword")
	public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute ChangePasswordModel changePasswordModel,Model model) {
		changePasswordModel.setUsername(userDetails.getUsername());
		if (Objects.equals(changePasswordModel.getNewPassword(), changePasswordModel.getConfirmNewPassword())) {
			if (authenticationService.changePassword(changePasswordModel)) {
				model.addAttribute("message", "Passwords changed successfully");
			} else {
				model.addAttribute("message", "Old password does not match");
			}
		} else {
			model.addAttribute("message", "Both the passwords do not match");
			return "changePassword";
		}
		return "redirect:logout";
		
	}
	
	@GetMapping("/changePassword")
	public String changePasswordForm() {
		return "changePassword";
	}
	
	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute RegisterUserModel registerUserModel,Model model) {
		if(registerUserModel.getPassword().equals(registerUserModel.getConfirmPassword())){
			authenticationService.createUser(registerUserModel);
			model.addAttribute("message", "Proceed to login");
		}else {
			model.addAttribute("message", "password and ConfirmPassword doesn't match");
			return "register";
		}
		return "login";
			
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "register";
		
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/user")
	@ResponseBody
	public String userPage() {
		return "User Page";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String adminPage() {
		return "Admin Page";
	}

	@GetMapping("/anonymous")
	@ResponseBody
	public String anonymousPage() {
		return "Anonymous Page";
	}

}
