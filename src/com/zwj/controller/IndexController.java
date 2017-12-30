package com.zwj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index.do")
	public String getIndex(){
		return "redirect:jsp/login.jsp";
	}
}
