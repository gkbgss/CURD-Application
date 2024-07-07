package com.curd.service;

import java.sql.SQLException;
import java.util.List;

import com.curd.controller.StudentController;
import com.curd.model.Student;

public class StudentService {
	StudentController sd = new StudentController();
	public String setStudentDetail(int rollNo, String name, int age, String phoneNum) throws SQLException {
		Student std = new Student();
		if( name !=null && rollNo>0 && phoneNum.length()==  10 && age > 0 ) {
			std.setRollNo(rollNo);
			std.setName(name);
			std.setAge(age);
			std.setPhoneNum(phoneNum);
			int inserted = sd.addStudent(std); 
			if (inserted == 1) {
			    return "Record Inserted successfully";
			   }
			
		}
		
			return"Please check the detail";
		
	}

	
	public List<Student> getStudentDetail() throws SQLException {
		List<Student> stdList = sd.displayStudent(); 
		if (stdList.isEmpty()) {
			   System.out.println( "Student not found in database."); 
		       return stdList;}
		else
			   return stdList;
	}

	
	public String deleteStudentDetail(int rollNo) throws SQLException {

		int deleted = sd.deleteStudent(rollNo);  
		if (deleted == 1) {
			   return "Record deleted successfully";  
			   }
			  return "No Student found in data base.";

	}

	

}


