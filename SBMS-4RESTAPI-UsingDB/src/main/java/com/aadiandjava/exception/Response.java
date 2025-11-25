package com.aadiandjava.exception;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Response {
	
	private String msg;
	 private String excCode;
	 private LocalDate date;
	 /*
	 public String getMsg() {
		 return msg;
	 }
	 public void setMsg(String msg) {
		 this.msg = msg;
	 }
	 public String getExcCode() {
		 return excCode;
	 }
	 public void setExcCode(String excCode) {
		 this.excCode = excCode;
	 }
	 public LocalDate getDate() {
		 return date;
	 }
	 public void setDate(LocalDate date) {
		 this.date = date;
	 }
	 @Override
	 public int hashCode() {
		return Objects.hash(date, excCode, msg);
	 }
	 @Override
	 public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Response other = (Response) obj;
		return Objects.equals(date, other.date) && Objects.equals(excCode, other.excCode)
				&& Objects.equals(msg, other.msg);
	 }
	 */

}
