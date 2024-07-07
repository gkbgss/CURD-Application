package com.curd.Client;



	import java.sql.SQLException;
	import java.util.Scanner;

import com.curd.model.Student;
import com.curd.service.StudentService;



	public class test {
	public static void main(String[] args) throws SQLException {
		StudentService student = new StudentService();  //taking from user 
		  Scanner sc = new Scanner(System.in); 
		  char ch = 'y';
		 
		   do {
		    System.out.println("1. Press 1 to add student details.");   
		    System.out.println("2. Press 2 to Display Student details.");
		    System.out.println("3. Press 3 to Delete Student.");  
		    System.out.println("4. Press 4 to exit.");
		    int option = sc.nextInt();    
		    switch (option) {
		    case 1: {
		     System.out.println("Enter the detail of student");    
		     System.out.println("Enter student rollNo");
		     int rollNo = sc.nextInt();     
		     System.out.println("Enter student name.");
		     String name = sc.next();
		     System.out.println("Enter student age");   
		     int age = sc.nextInt();
		     System.out.println("Enter student phone number");   
		     String phoneNum = sc.next();
		     System.out.println(student.setStudentDetail(rollNo, name, age, phoneNum));  
		     }
		     break;   
		     case 2: {
		     for (Student std : student.getStudentDetail()) {
		      System.out.println("Student Id: " + std.getRollNo());    
		      System.out.println("Student Name " + std.getName());
		      System.out.println("Student age " + std.getAge());    
		      System.out.println("Student Phonenumber " + std.getPhoneNum());
		     }
		    }  
		     break;
		    case 3: {     
		    	System.out.println("Enter student rollNo");
		     int rollNo = sc.nextInt();     
		     System.out.println(student.deleteStudentDetail(rollNo));
		    }    
		    break;
		    case 4: {
		     System.out.println("Program Exited");   
		     System.exit(0);
		    }
		     break;
		    default: {   
		    	System.out.println("wrong choice");
		    }    }
		    
		    System.out.println("Do you want to continue: press y");
		    ch = sc.next().charAt(0);
		   } 
		   while (ch == 'y'); 
		   }


	}



