package com.demo.beans;

import java.time.LocalDate;

public class Task {
	private int tid;
	private String assignedto;
	private String status;
	private String priority;
	private String comments;
	private LocalDate duedate;
	
	public Task() {
		super();
	}

	public Task(int tid, String assignedto, String status, String priority, String comments, LocalDate duedate) {
		super();
		this.tid = tid;
		this.assignedto = assignedto;
		this.status = status;
		this.priority = priority;
		this.comments = comments;
		this.duedate = duedate;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getAssignedto() {
		return assignedto;
	}

	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}

	@Override
	public String toString() {
		return "Product [tid=" + tid + ", assignedto=" + assignedto + ", status=" + status + ", priority=" + priority
				+ ", comments=" + comments + ", duedate=" + duedate + "]";
	}
	
}
