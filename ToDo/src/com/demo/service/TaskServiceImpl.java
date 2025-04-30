package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Task;
import com.demo.dao.TaskDao;
import com.demo.dao.TaskDaoImpl;

public class TaskServiceImpl implements TaskService{
	
	private TaskDao pdao;
	
	public TaskServiceImpl() {
		super();
		pdao=new TaskDaoImpl();
	}

	@Override
	public boolean addTask() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter tid:");
		int tid=sc.nextInt();
		System.out.println("Enter assigned:");
		String asg=sc.next();
		System.out.println("Enter status:");
		String sta=sc.next();
		System.out.println("Enter priority:");
		String prio=sc.next();
		System.out.println("Enter comments:");
		String com=sc.next();
		System.out.println("Enter date: dd/MM/yyyy");
		String date=sc.next();
		LocalDate ldt=LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Task task=new Task(tid,asg,sta,prio,com,ldt);
		return pdao.save(task);
	}

	@Override
	public boolean deleteTask(int id) {
		return pdao.removeTask(id);
	}

	@Override
	public boolean updateTask(int tid,String status) {
		return pdao.updateTask(tid,status);
	}

	@Override
	public List<Task> getAllTasks() {
		return pdao.findAllTasks();
	}
	
	@Override
	public void closeTheConnecion() {
		pdao.TurnOffConnection();
	}

}
