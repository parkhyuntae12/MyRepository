package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.service.FreeBoardService;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue="1")int pageNo,Model model){//pageNo가 안넘어오면 디폴트로1을넘겨줘라
		int rowsPerPage = 10;//한페이지당 보이는 갯수
		int pagesPerGroup = 5;//한그룹당 페이지수 
		
		int totalBoardNo = freeBoardService.getCount();//총 게시판 갯수
		
		int totalPageNo = (totalBoardNo/rowsPerPage)+((totalBoardNo%rowsPerPage!=0)?1:0);//총 페이지수
		//                       정수/정수 =정수               나머지가있다면 1을 더해주고 없다면 0 
		
		int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (pageNo-1)/pagesPerGroup+1;
		
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		
		int endPageNo = startPageNo+pagesPerGroup-1;
		
		if(groupNo == totalGroupNo) {endPageNo=totalPageNo;}
		List<FreeBoard> list = freeBoardService.list(pageNo,10);
		
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);	
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		
		model.addAttribute("list", list);
		return "freeboard/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(FreeBoard freeBoard){
		return "freeboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(FreeBoard freeBoard,HttpSession session){
		String mid = (String) session.getAttribute("login");
		freeBoard.setBwriter(mid);
		int result = freeBoardService.write(freeBoard);
		if(result == FreeBoardService.WRITE_FAIL){
			return "freeboard/write";
		}else{
			return "redirect:/freeboard/list";
		}
	}
	
	@RequestMapping("/info")
	public String info(int bno,Model model){//bno가 안넘어올수가 없다
		FreeBoard freeBoard = freeBoardService.info(bno);
		freeBoard.setBhitcount(freeBoard.getBhitcount()+1);
		freeBoardService.modify(freeBoard);
		model.addAttribute("freeboard",freeBoard);
		return "freeboard/info";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modifyForm(int bno,Model model){//bno가 안넘어올수가 없다
		FreeBoard freeBoard = freeBoardService.info(bno);
		model.addAttribute("freeboard",freeBoard);
		return "freeboard/modify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(FreeBoard freeBoard){//bno가 안넘어올수가 없다
		FreeBoard dbFreeBoard = freeBoardService.info(freeBoard.getBno());
		freeBoard.setBhitcount(dbFreeBoard.getBhitcount());
		freeBoardService.modify(freeBoard);
		return "redirect:/freeboard/list";
	}
}