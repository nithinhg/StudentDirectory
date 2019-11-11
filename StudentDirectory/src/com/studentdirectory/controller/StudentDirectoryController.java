package com.studentdirectory.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.studentdirectory.model.Student;

public class StudentDirectoryController {

	static List<Student> studentsList = new ArrayList<Student>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while(true) //keep the program running indefinitely.
		{
			//Display 3 options to the user
			System.out.println("\nSelect your option:\n1 for Enter Student information\n2 for Print students list sorted by name\n3 For Print students list sorted by roll number\n");
			
			String userInput = scanner.nextLine(); //Scan user input.
			
			if(userInput.equals("1")) // Prompt user for Student Name and Roll Number and store it in in memory after checking for duplicates.
			{
				storeStudentInfo();
			}
			else if(userInput.equals("2")) // Sort Students based on Name and print.
			{
				sortStudentName();
			}
			else if(userInput.equals("3")) // Sort Students based on Roll Number and print.
			{
				sortStudentRollNumber();
			}
			else
			{
				System.out.println("Invalid option!\n");
			}
		}
	}

	//Method takes user input and stores in in memory.
	public static void storeStudentInfo()
	{
		System.out.println("Enter Student Name:");
		String studentName = scanner.nextLine();
		System.out.println("Enter Student Roll Number:");
		String studentRollNumber = scanner.nextLine();
		if(checkIfInteger(studentRollNumber)) //Assumption: Roll number is an integer
		{
			Student stu = new Student(studentName, Integer.parseInt(studentRollNumber));
			if(isDuplicate(Integer.parseInt(studentRollNumber)))
			{
				System.out.println("Student with roll number " +studentRollNumber+" already exists.\n");
			}
			else
			{
				studentsList.add(stu);
				System.out.println("Student with roll number " +studentRollNumber+" and name " +studentName+ " is created successfully.\n");
			}
		}
		else {
			System.out.println("Please enter integer as Student's roll number.\n");
		}
	}

	//Method checks for duplicates
	public static boolean isDuplicate(int rollNumber)
	{
		boolean isDuplicate = false;
		for(Student stu : studentsList)
		{
			if(stu.rollNumber == rollNumber)
			{
				isDuplicate = true;
				break;
			}
		}
		return isDuplicate;
	}

	//Method sorts based on Student's name.
	public static void sortStudentName()
	{
		if(!studentsList.isEmpty())
		{
			System.out.println("Student's list sorted based on Name:");
			studentsList.sort(Comparator.comparing(Student::getName));
			printStudentList();
		}
		else
		{
			System.out.println("No student record is available.\n");
		}
	}

	//Method sorts based on Student's Roll number.
	public static void sortStudentRollNumber()
	{
		if(!studentsList.isEmpty())
		{
			System.out.println("Student's list sorted based on Roll Number:");
			studentsList.sort(Comparator.comparing(Student::getRollNumber));
			printStudentList();
		}
		else
		{
			System.out.println("No student record is available.\n");
		}

	}

	//Method lists Students in in memory.
	public static void printStudentList()
	{
		for(Student stu : studentsList)
		{
			System.out.println("Name:"+stu.name+", Roll Number:"+stu.rollNumber);
		}
	}
	
	// Method checks if the user input is integer.
	public static boolean checkIfInteger(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		} 
	}
}