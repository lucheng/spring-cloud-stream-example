package com.cheng.stream.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping
    public DateDTO test() {
        return new DateDTO();
    }
}

class DateDTO {
	
	private Date date = new Date();
	
	private LocalDate localDate = LocalDate.now();
	
	private LocalDateTime localDateTime = LocalDateTime.now();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
}