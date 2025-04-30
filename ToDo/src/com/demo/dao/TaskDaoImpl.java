package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Task;

public class TaskDaoImpl implements TaskDao{
	static Connection conn;
	static PreparedStatement tinsert,tdelete,tupdate,tall;
	
	static {
		try {
			conn=DBUTIL.getConnection();
			tinsert=conn.prepareStatement("insert into todo values(?,?,?,?,?,?)");
			tdelete=conn.prepareStatement("delete from todo where tid=?");
			tupdate=conn.prepareStatement("update todo set status=? where tid=?");
			tall=conn.prepareStatement("select * from todo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean save(Task ta) {
		try {
			tinsert.setString(1,ta.getAssignedto());
			tinsert.setString(2,ta.getStatus());
			tinsert.setDate(3, Date.valueOf(ta.getDuedate()));
			tinsert.setString(4,ta.getPriority());
			tinsert.setString(5,ta.getComments());
			int res=tinsert.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeTask(int id) {
		try {
			tdelete.setInt(1, id);
			int result=tdelete.executeUpdate();
			if(result>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateTask(int tid,String status) {
		try {
			tupdate.setInt(2,tid);
			tupdate.setString(1,status);
			int result=tupdate.executeUpdate();
			if(result>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Task> findAllTasks() {
		List<Task>tlist=new ArrayList<Task>();
		try {
			ResultSet rs=tall.executeQuery();
			while(rs.next()) {
				Task t=new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6).toLocalDate());
				tlist.add(t);
			}
			if(tlist.size()>0) {
				return tlist;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void TurnOffConnection() {
		DBUTIL.closeConnecion();
	}
}
