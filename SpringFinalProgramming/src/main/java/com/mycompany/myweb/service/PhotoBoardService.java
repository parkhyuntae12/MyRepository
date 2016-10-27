package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.PhotoBoardDao;
import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardService {
	private static final int WRITE_SUCCESS=0;
	private static final int WRITE_FAIL=1;
	private static final int MODIFY_SUCCESS=0;
	private static final int MODIFY_FAIL=1;
	private static final int REMOVE_SUCCESS=0;
	private static final int REMOVE_FAIL=1;
	
	@Autowired
	private PhotoBoardDao PhotoBoardDao;
	
	public List<PhotoBoard> list(int pageNo, int rowsPerPage){
		return PhotoBoardDao.selectByPage(pageNo,rowsPerPage);
	}
	public int write(PhotoBoard PhotoBoard){
		int row = PhotoBoardDao.insert(PhotoBoard);//1이 아닌 값이 나올수가 없다 1과 예외만 발생
		return WRITE_SUCCESS;
	}
	public int modify(PhotoBoard PhotoBoard){
		int row = PhotoBoardDao.update(PhotoBoard);//1이 아닌 값이 나올수가 없다 1과 예외만 발생
		if(row==0){return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
	public int remove(int bno){
		int row = PhotoBoardDao.delete(bno);//1이 아닌 값이 나올수가 없다 1과 예외만 발생
		if(row==0){return REMOVE_FAIL;}
		return REMOVE_SUCCESS;
	}
	public PhotoBoard info(int bno){
		return PhotoBoardDao.selectByBno(bno);
	}
}