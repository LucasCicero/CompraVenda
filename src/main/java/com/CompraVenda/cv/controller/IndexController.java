package com.CompraVenda.cv.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {		
	
	@RequestMapping("/")
	public String abrirIndex() {
		//ModelAndView mv = new ModelAndView("index");
		return "index";
	}
	
	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/funcionarios/";
		}
		else if (request.isUserInRole("ROLE_VENDEDOR")) {
			return "redirect:/clientes/";
		}
			return "redirect:/produtos/";

	}
	
	
	@RequestMapping("/relatorio")
	public void gerarRelatorio() {
		//ModelAndView mv = new ModelAndView("index");
		
	}
	
	
}
