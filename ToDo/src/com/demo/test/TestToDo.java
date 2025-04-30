package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Task;
import com.demo.service.TaskService;
import com.demo.service.TaskServiceImpl;

public class TestToDo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		TaskService ts=new TaskServiceImpl();
		int choice=0;
			do {
				System.out.println("1. Add new task\n2. Delete task\n3. update task\n4.Display all\n5.Exit \n Enter choice:");
				choice=sc.nextInt();
				switch(choice) {
				case 1->{
					boolean status=ts.addTask();
					if(status) {
						System.out.println("Task added successfully");
					}else {
						System.out.println("Task not added");
					}
				}
				case 2->{
					System.out.println("Enter id:");
					int id=sc.nextInt();
					boolean status= ts.deleteTask(id);
					if(status) {
						System.out.println("Task deleted successfully");
					}else {
						System.out.println("Task not deleted");
					}
				}
				case 3->{
					System.out.println("Enter id:");
					int tid=sc.nextInt();
					System.out.println("Enter new status:");
					String sta=sc.next();
					
					boolean status=ts.updateTask(tid,sta);
					if(status) {
						System.out.println("Task updated successfully");
					}else {
						System.out.println("Task not updated");
					}
				}
				case 4->{
					List<Task>plist=ts.getAllTasks();
					if(plist!=null) {
						plist.stream().forEach(System.out::println);
					}else {
						System.out.println("Not Found");
					}
				}
				
				case 5->{
					System.out.println("Thank you!!");
					sc.close();
					ts.closeTheConnecion();
				}
				default ->{
					System.out.println("Invalid choice...");
				}
				}
			}while(choice!=5);
		}
			
		
	}


