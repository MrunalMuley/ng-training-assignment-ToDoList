package com.demo.dao;

import java.util.List;

import com.demo.beans.Task;

public interface TaskDao {

	boolean save(Task pro);

	boolean removeTask(int id);

	boolean updateTask(int tid,String status);

	List<Task> findAllTasks();

	void TurnOffConnection();

}
