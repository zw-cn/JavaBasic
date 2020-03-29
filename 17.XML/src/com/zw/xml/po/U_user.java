package com.zw.xml.po;

import java.sql.*;
import java.util.*;

public class U_user{

	private java.sql.Timestamp lastLogin;
	private java.sql.Blob image;
	private java.sql.Clob book;
	private String name;
	private java.sql.Date regDate;
	private Integer id;

	public java.sql.Timestamp getLastLogin(){
		return lastLogin;
	}
	public void setLastLogin(java.sql.Timestamp lastLogin){
		this.lastLogin = lastLogin;
	}
	public java.sql.Blob getImage(){
		return image;
	}
	public void setImage(java.sql.Blob image){
		this.image = image;
	}
	public java.sql.Clob getBook(){
		return book;
	}
	public void setBook(java.sql.Clob book){
		this.book = book;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public java.sql.Date getRegDate(){
		return regDate;
	}
	public void setRegDate(java.sql.Date regDate){
		this.regDate = regDate;
	}
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
}
