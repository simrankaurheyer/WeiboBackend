package com.niit.project2.model;

import java.util.Date;

public class OutputMessage extends Message {
	
private Date time;
	
	//getter and setter methods

	public OutputMessage(Message original,Date time)
	{
	super(original.getId(),original.getMessage());
	this.time=time;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}