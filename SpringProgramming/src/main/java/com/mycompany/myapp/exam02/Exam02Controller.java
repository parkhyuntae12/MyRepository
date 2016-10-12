package com.mycompany.myapp.exam02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam02Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam02/index";
	}
	/*@RequestMapping("/join")
	public String join(String mid, String mname, String mage){
		logger.info("join 요청 처리");
		logger.info("mid:"+mid);
		logger.info("mname:"+mname);
		logger.info("mage:"+mage);
		return "exam02/index";
	}*/
	@RequestMapping("/join")
	public String join(Member member){
		logger.info("join 요청 처리");
		logger.info("mid:"+member.getMid());
		logger.info("mname:"+member.getMname());
		logger.info("mage:"+member.getMage());
		return "exam02/index";
	}
	@RequestMapping("/login")
	public String login(
			@RequestParam("id")String mid, //파라미터와 변수의 이름이 다를때쓴다(request param) 앞에 value가 생략되어있다(기본속성) value="id"
			@RequestParam("password")String mpassword){
		logger.info("login 요청 처리");
		logger.info("mid:"+mid);
		logger.info("mpassword:"+mpassword);
		return "exam02/index";
	}
	
	@RequestMapping("/order")
	public String order(int pid,String pname,int pprice,String pcompany){//string으로 넘어오지만 int로 선언해도 String에서 String으로 자동 변환한다
		logger.info("order 요청처리");
		logger.info("pid:"+pid);
		logger.info("pname:"+pname);
		logger.info("pprice:"+pprice);
		logger.info("pcompany:"+pcompany);
		
		return "exam02/index";
	}
	@RequestMapping("/write")
	public String writer(
			@RequestParam(defaultValue="1")int bno, //만약 값이 넘어오지 않으면 디폴트값을 넘겨준다
			String title, String content, 
			@RequestParam(defaultValue="0")int hitcount){
		logger.info("writer 요청처리");
		logger.info("bno:"+bno);
		logger.info("title:"+title);
		logger.info("content:"+content);
		logger.info("hitcount:"+hitcount);
		return "exam02/index";	
	}
	@RequestMapping("/update")
	public String update(
			@RequestParam(defaultValue="1")int bno, //만약 값이 넘어오지 않으면 디폴트값을 넘겨준다
			String title, String content, 
			@RequestParam(value="count",defaultValue="0")int hitcount){//어노테이션에서 두가지 값이 동시에 들어갈수 있는 상황에는 기본속성이라도 value를 넣어줘야 한다
		logger.info("writer 요청처리");
		logger.info("bno:"+bno);
		logger.info("title:"+title);
		logger.info("content:"+content);
		logger.info("hitcount:"+hitcount);
		return "exam02/index";	
	}
	@RequestMapping("/send")
	public String send(Board board){
		logger.info("writer 요청처리");
		logger.info("bno:"+board.getBno());
		logger.info("title:"+board.getTitle());
		logger.info("content:"+board.getContent());
		logger.info("hitcount:"+board.getHitcount());
		return "exam02/index";	
	}
	}
