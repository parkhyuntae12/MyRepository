package com.mycompany.myapp.exam07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam07")

public class Exam07Controller {
	@RequestMapping("/index")
	public String index(){
		return "exam07/index";
	}	
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){
		request.setAttribute("data1", "value1");//value1에는 어떤 객체든 올 수 있다
		request.setAttribute("data2", "value2");
		return "exam07/usedata";
	}
	
	@RequestMapping("/method2")
	public String method2(HttpSession session){
		session.setAttribute("data1", "value1");
		session.setAttribute("data2", "value2");
		return "exam07/usedata";
	}
	
	@RequestMapping("/method3")
	public String method3(Model model){
		model.addAttribute("data1", "value1");//model 저장값이 request에 저장이 됨
		model.addAttribute("data2", "value2");
		return "exam07/usedata";
	}
}