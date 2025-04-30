package com.demo.service;

import java.util.List;

import com.demo.beans.Task;

public interface TaskService {

	boolean addTask();

	boolean deleteTask(int id);

	boolean updateTask(int tid,String status);

	List<Task> getAllTasks();

	void closeTheConnecion();

}
