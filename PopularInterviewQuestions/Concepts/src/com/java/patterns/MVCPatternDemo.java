package com.java.patterns;

public class MVCPatternDemo {
	public static void main(String[] args) {
		Student studentModel = new Student();
		StudentView view = new StudentView();
		StudentController controller = new StudentController(studentModel, view);
		controller.setStudentName("Andrew");
		controller.setStudentRollNumber(99);
		controller.printStudentDetails();
	}
}

// Model.
class Student {
	int rollNumber;
	String name;

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

// View.
class StudentView {

	public void display(String name, int rollNumber) {
		System.out.println("Student Name:" + name + "     Student Roll Number:" + rollNumber);
	}
}

// Controller.

class StudentController {
	Student student;
	StudentView view;

	public StudentController(Student student, StudentView view) {
		this.student = student;
		this.view = view;
	}

	public String getStudentName() {
		return this.student.getName();
	}

	public int getStudentRollNumber() {
		return this.student.getRollNumber();
	}

	public void setStudentName(String name) {
		this.student.setName(name);
	}

	public void setStudentRollNumber(int number) {
		this.student.setRollNumber(number);
	}

	public void printStudentDetails() {
		view.display(student.getName(), student.getRollNumber());
	}
}
