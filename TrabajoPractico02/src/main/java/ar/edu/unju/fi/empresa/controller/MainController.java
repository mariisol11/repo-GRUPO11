package ar.edu.unju.fi.empresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/home")
	public String getPageHome() {
		return "home";
	}
}
