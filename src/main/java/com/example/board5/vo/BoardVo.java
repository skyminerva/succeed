package com.example.board5.vo;

import java.util.Date;

public class BoardVo {
	
	private int id;
	
	private String name;
	
	private String title;
	
	private String content;
	
	private Date regdate;
	
	private Date update;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	@Override
	public String toString() {
		return "BoardVo [id=" + id + ", name=" + name + ", title=" + title + ", content=" + content + ", regdate="
				+ regdate + ", update=" + update + "]";
	}

	public BoardVo(int id, String name, String title, String content, Date regdate, Date update) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.update = update;
	}
	
	

}
