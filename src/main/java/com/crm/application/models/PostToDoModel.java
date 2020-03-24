package com.crm.application.models;

import java.util.Date;

public class PostToDoModel {
	private String description;
	private Boolean isDone;
	private Date dateEnd;
	private Long idUser;
	
	public PostToDoModel() {
		
	}
	
	public PostToDoModel(String description, Boolean isDone, Date dateEnd, Long idUser) {
		this.description = description;
		this.isDone = isDone;
		this.dateEnd = dateEnd;
		this.idUser = idUser;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	

}
