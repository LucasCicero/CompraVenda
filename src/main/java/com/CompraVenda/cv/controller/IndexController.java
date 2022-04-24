package com.CompraVenda.cv.controller;

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
	
}
