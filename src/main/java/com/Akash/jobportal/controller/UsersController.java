package com.Akash.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Akash.jobportal.entity.Users;
import com.Akash.jobportal.entity.UsersType;
import com.Akash.jobportal.services.UsersService;
import com.Akash.jobportal.services.UsersTypeService;

import jakarta.validation.Valid;

@Controller
public class UsersController {

	private final UsersTypeService usersTypeService;
	private final UsersService usersService;
	
	@Autowired
	public UsersController(UsersTypeService usersTypeService
			,UsersService usersService) {
		this.usersTypeService = usersTypeService;
		this.usersService = usersService;
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<UsersType> usersTypes = usersTypeService.getAll();
		model.addAttribute("getAllTypes",usersTypes);
		model.addAttribute("user",new Users());
		return "register";
	}
	
	@PostMapping("register/new")
	public String userRegistration(@Valid Users users,Model model) {
//		System.out.println("User:: "+users);
		//Bug Fix:Duplicate Email
		Optional<Users> optionalUsers = usersService.getUserByEmail(users.getEmail());
		if(optionalUsers.isPresent()) 
		{   //Bug Fix:Duplicate Email
			model.addAttribute("error","Email already Existed try to login or register with other Email.!");
			List<UsersType> usersTypes = usersTypeService.getAll();
			model.addAttribute("getAllTypes",usersTypes);
			model.addAttribute("user",new Users());
			return "register";
		}
		usersService.addNew(users);
		return "dashboard";
	}
}
