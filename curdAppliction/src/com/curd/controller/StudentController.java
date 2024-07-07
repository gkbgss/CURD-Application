package com.curd.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.curd.model.Student;

import java.sql.*;
public class StudentController {
	Connection conn = null;
    PreparedStatement pstmt = null;
    public StudentController() {
    String url = "jdbc:mysql://localhost:3306/test" ;
    
    try {
   	  
				Class.forName("com.mysql.cj.jdbc.Driver");
		
   	 conn = DriverManager.getConnection(url,"root","admin");
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
    
    
    
    }
	
	public int addStudent(Student std) throws SQLException {
		pstmt = conn.prepareStatement("insert into Student values (?,?,?,?)");
		pstmt.setInt(1, std.getRollNo());
		pstmt.setString(2, std.getName());
		pstmt.setInt(3, std.getAge());
		pstmt.setString(4,std.getPhoneNum());
		return pstmt.executeUpdate();
	}

	public List<Student> displayStudent() throws SQLException {
		List<Student> stdList = new ArrayList();
		pstmt = conn.prepareStatement("Select * From Student");  
		ResultSet rs = pstmt.executeQuery();
		  if (rs != null) {   
			  while (rs.next()) {
		    Student std = new Student();    
		    std.setRollNo(rs.getInt(1));
		    std.setName(rs.getString(2));    
		    std.setAge(rs.getInt(3));
		    std.setPhoneNum(rs.getString(4));    
		    stdList.add(std);
		       }
		  }  
		  return stdList;

		
	}

	public int deleteStudent(int rollNo) throws SQLException {
		pstmt = conn.prepareStatement("delete from Student where rollNo=?");  
		pstmt.setInt(1, rollNo);
		  return pstmt.executeUpdate();

	}

}


