package com.codingdojo.javaspring.dojosurvey.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String survey(@RequestParam(value="myname")String myname, @RequestParam(value="mylocation")String mylocation, @RequestParam(value="mylanguage")String mylanguage, @RequestParam(value="mycomment")String mycomment, RedirectAttributes errormsg, HttpSession session) {
		session.setAttribute("name", myname);
		session.setAttribute("location", mylocation);
		session.setAttribute("language", mylanguage);
		session.setAttribute("comment", mycomment);
		return "redirect:/result";
	}
	@RequestMapping("/result")
	public String displayinfo() {
		return "result.jsp";
	}
}
