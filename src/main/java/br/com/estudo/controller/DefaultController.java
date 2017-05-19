package br.com.estudo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping("/")
	public String home1(){
		return "/main";
	}
	
	@GetMapping("/main")
	public String home2(){
		return "/main";
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