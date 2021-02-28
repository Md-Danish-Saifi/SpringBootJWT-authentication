package com.jwt.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jwt.demo.model.User;
import com.jwt.demo.repository.UserRepository;
import com.jwt.demo.service.UserServices;

@RestController()
public class Controller {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserServices userService;

	@RequestMapping("/")
	@ResponseBody
	public String empty()
	{
		return "Hello you are on Naviya Technologies home Page";
	}

	@GetMapping("/all")
	public List<User> allUsers()
	{
		return userRepository.findAll();
	}
	@PostMapping("/saveuser")
	@ResponseBody
	public String saveUser(@RequestBody User user)
	{
		User exist = userRepository.findByEmailIgnoreCase(user.getEmail());
		if(exist!=null)
		{
			return "this email "+user.getEmail()+" already registerd";
		}
		userService.saveUser(user);
		return "user "+user.getName()+" saved";
	}
	
	@PostMapping("/blockuser")
	@ResponseBody
	public String blockUser(@RequestBody User user)
	{
		User exist = userRepository.findByEmailIgnoreCase(user.getEmail());
		if(exist!=null)
		{
			if(exist.isActive()==false)
			return "user "+user.getName()+" already blocked";
			
		}
		exist.setActive(false);
		userService.saveUser(user);
		return "this email "+user.getEmail()+" sexfully blocked";
	}
	
	@PostMapping("/unblockuser")
	@ResponseBody
	public String unBlockUser(@RequestBody User user)
	{
		User exist = userRepository.findByEmailIgnoreCase(user.getEmail());
		if(exist!=null)
		{
			if(exist.isActive()==true)
			return "user "+user.getName()+" already unblocked";
			
		}	
		exist.setActive(true);
		userService.saveUser(user);
		return "this email "+user.getEmail()+" sexfully unblocked";

	}

}
