//POJO Class representing Student model
package com.studentdirectory.model;

public class Student
{
	public String name;
	public int rollNumber; //Assumption: Roll number is an integer
	
	public Student(String name, int i)
	{
		this.name = name;
		this.rollNumber = i;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getRollNumber()
	{
		return rollNumber;
	}
}