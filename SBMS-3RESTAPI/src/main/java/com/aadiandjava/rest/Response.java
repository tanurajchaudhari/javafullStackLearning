package com.aadiandjava.rest;

import java.time.LocalDateTime;

public class Response {
	
	String exceptioncode;
	String msg;
	LocalDateTime datetime;
	public String getExceptioncode() {
		return exceptioncode;
	}
	public void setExceptioncode(String exceptioncode) {
		this.exceptioncode = exceptioncode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	

}
