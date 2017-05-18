package br.com.estudo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPadrao {

	@GetMapping("/")
	public String home1(){
		return "/home";
	}
	
	@GetMapping("/home")
	public String home2(){
		return "/home";
	}
	
	@GetMapping("/admin")
	public String admin(){
		return "/admin";
	}
	
	@GetMapping("/user")
	public String user(){
		return "/user";
	}
	
	@GetMapping("/about")
	public String sobre(){
		return "/about";
	}
	
	@GetMapping("/login")
	public String login(){
		return "/login";
	}
	
	@GetMapping("/403")
	public String error403(){
		return "/403";
	}
}