package com.codingdojo.javaspring.thecode.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CodeController {
	@RequestMapping(value="/success", method=RequestMethod.POST)
	public String codes(@RequestParam(value="code")String code, RedirectAttributes errormsg) {
		if(code.equals("Bushido")) {
			return "redirect:/success";
		}
		else {
			errormsg.addFlashAttribute("wrooong", "You Must Train Harder");
			return "redirect:/";
		}
	}
	@RequestMapping("/success")
	public String displayCode() {
		return "success.jsp";
	}
}
