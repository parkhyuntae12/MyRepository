package com.mycompany.myweb;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/") //  "/" 의 의미는 홈페이지 주소의 context 뒤에 들어간다. 그리고 /+리턴값이 된다.
	public String home() { //변수이름은 중요하지 않다.
		logger.info("home() 실행"); //views 의 home.jsp 와 같은거다

		return "home";
	}
}
