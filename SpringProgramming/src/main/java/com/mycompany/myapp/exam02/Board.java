package com.mycompany.myapp.exam02;

public class Board {
	private int bno;
	private String title;//객체를 생성해서 데이터를 보낼땐 클래스 필드변수명과 요청 변수 명이랑 같아야한다
	private String content;
	private int hitcount;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
}