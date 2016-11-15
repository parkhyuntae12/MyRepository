package com.mycompany.myweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.PhotoBoard;
import com.mycompany.myweb.service.PhotoBoardService;

@Controller
@RequestMapping("/photoboard")
public class PhotoBoardController {
	@Autowired
	private PhotoBoardService photoBoardService;
	
	@RequestMapping("/list")
	public String list(String pageNo,Model model,HttpSession session){//pageNo가 안넘어오면 디폴트로1을넘겨줘라

		int intPageNo=1;
		
		if(pageNo == null){
			pageNo= (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo=Integer.parseInt(pageNo);
			}
		}else{//pageNo가넘어오지도않고 세션에도 없을땐 바로전 리스트로 넘어간다
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo",String.valueOf(intPageNo));
		
		
		int rowsPerPage = 8;//한페이지당 보이는 갯수
		int pagesPerGroup = 5;//한그룹당 페이지수 
		
		int totalBoardNo = photoBoardService.getCount();//총 게시판 갯수
		
		int totalPageNo = (totalBoardNo/rowsPerPage)+((totalBoardNo%rowsPerPage!=0)?1:0);//총 페이지수
		//                       정수/정수 =정수               나머지가있다면 1을 더해주고 없다면 0 
		
		int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup+1;
		
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		
		int endPageNo = startPageNo+pagesPerGroup-1;
		
		if(groupNo == totalGroupNo) {endPageNo=totalPageNo;}
		
		List<PhotoBoard> list = photoBoardService.list(intPageNo,rowsPerPage);
		
		model.addAttribute("intPageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);	
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("list", list);
		
		return "photoboard/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(PhotoBoard photoBoard){
		return "photoboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(PhotoBoard photoBoard,HttpSession session){
		try{
			String mid = (String) session.getAttribute("login");
			photoBoard.setBwriter(mid);
			
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			//photoBoard.getPhoto() 멀티파트 파일객체
			String savedfile= new Date().getTime()+photoBoard.getPhoto().getOriginalFilename();
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);
			//절대경로 얻는이유는 파일을 저장하기 위해서 실제 저장 행위 = 87,89라인
			//C:\Users\Administrator\workspace\.metadata\.......\SpringFinalProgramming\에 저장
			photoBoard.getPhoto().transferTo(new File(realpath));//파일을 절대경로에 저장한다 실제파일을 저장
			photoBoard.setSavedfile(savedfile);
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType());//getContentType()) 파일의종류정보 
			
			int result = photoBoardService.write(photoBoard);//db에 저장

			return "redirect:/photoboard/list";
		}catch(Exception e){
			e.printStackTrace();
			return "photoboard/write";
		}
	}
	
	@RequestMapping("/showPhoto")
	public void showPhoto(String savedfile, HttpServletRequest request,HttpServletResponse response){
		try{
			String fileName = savedfile;
			/*
			브라우저에서 보여주지않고 강제로 다운로드 할 경우
			fileName = URLEncoder.encode(fileName,"UTF-8");//fileName을 16진수로 변환 
			response.setHeader("Content-Disposition","attachment; filename=\"" + fileName +"\"");//다운로드
			*/
			String mimeType = request.getServletContext().getMimeType(fileName);//파일의 확장명을 보고 .확장명(Mime)을 리턴해줌
			response.setContentType(mimeType);
			
			OutputStream os = response.getOutputStream();
			
			String filePath =  request.getServletContext().getRealPath("/resources/image/"+fileName);
			InputStream is = new FileInputStream(filePath);
			
			byte[] values = new byte[1024];
			int byteNum=-1;
			while((byteNum=is.read(values))!=-1){
				os.write(values,0,byteNum);
			}
			os.flush();
			is.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/info")
	public String info(int bno,Model model){
		PhotoBoard photoBoard = photoBoardService.info(bno);
		photoBoard.setBhitcount(photoBoard.getBhitcount()+1);
		photoBoardService.modify(photoBoard);
		model.addAttribute("photoboard",photoBoard);
		return "photoboard/info";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model,HttpSession session){
		PhotoBoard photoBoard = photoBoardService.info(bno);
		model.addAttribute("photoBoard", photoBoard);
		
		return "photoboard/modify";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String modify(PhotoBoard photoBoard, HttpSession session, Model model){
		
		PhotoBoard dbPhotoBoard = photoBoardService.info(photoBoard.getBno());
		try{
			String mid = (String)session.getAttribute("login");
			photoBoard.setBwriter(mid);
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			
			String savedfile = new Date().getTime()+photoBoard.getPhoto().getOriginalFilename();
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);
			
			photoBoard.getPhoto().transferTo(new File(realpath));//파일을 절대경로에 저장한다 실제파일을 저장
			photoBoard.setSavedfile(savedfile);
			//절대경로 얻는이유는 파일을 저장하기 위해서 실제 저장 행위
			//C:\Users\Administrator\workspace\.metadata\.......\SpringFinalProgramming\에 저장
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType());
			
			photoBoardService.modify(photoBoard);
			}catch (Exception e) {
				e.printStackTrace();
				
			}
		return "redirect:/photoboard/list";
	}
	
	@RequestMapping("/remove")
	public String remove(int bno){
		photoBoardService.remove(bno);
		return "redirect:/photoboard/list";
	}
}