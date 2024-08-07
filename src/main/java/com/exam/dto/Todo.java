package com.exam.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;
import org.springframework.lang.NonNull;

@Alias("Todo")
public class Todo {

	 private int id;
	 private String userid;
	 //@NotNull (null 불가) 
	 //@NotEmpty(null,빈문자열 불가)
	 //@NotBlank(null,빈문자열, space 불가
	 @Size(min = 2, message = "Enter at least 2 characters")
	 private String description;
	 
	 @Future(message = "현재 날짜보다 미래 날짜 입력")   // @Past
	 private LocalDate targetDate; // 컬럼명: target_date
	 
	 private boolean done;
	 
	public Todo() {}

	public Todo(int id, String userid, String description, LocalDate targetDate, boolean done) {
		this.id = id;
		this.userid = userid;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", userid=" + userid + ", description=" + description + ", targetDate=" + targetDate
				+ ", done=" + done + "]";
	}
	
}
