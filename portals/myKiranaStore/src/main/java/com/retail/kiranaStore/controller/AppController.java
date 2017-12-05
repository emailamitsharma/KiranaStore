package com.retail.kiranaStore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retail.kiranaStore.service.CategoryService;

@Controller
public class AppController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CategoryService categoryService; 

	@RequestMapping("/")
	String home(HttpServletRequest request, HttpSession session , ModelMap modal) {
		session.setAttribute("categories", categoryService.getAllCategories());
		session.setAttribute("app.url",env.getProperty("app.url"));
		session.setAttribute("serverl.url",request.getRequestURL());
		modal.addAttribute("title","My Kirana Store");
		return "index";
	}

	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}

}
