package Mod6GA.Problem1;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-03
 *
 * Student name:  John Stelly
 * Completion date: 11/11/2020
 *
 * ProjectGroupDriver.txt: template file of ProjectGroupDriver.java
 * Student tasks: complete tasks specified in the file
 */

import java.io.IOException;

/**
 * Demonstrates the use of a list to manage a set of objects.
 *
 *
 */
public class ProjectGroupDriver
{
	/**
	 * Creates and populates a Program of Study. Then saves it using serialization.
	 */
	public static void main(String[] args) throws IOException
	{
		ProjectGroup pg = new ProjectGroup();

		pg.addStudent(new Student("101", "Jim Sanders",23, "A-"));
		pg.addStudent(new Student("173", "Anna Prince", 18, "A"));

		//*** Task #1: add additional two students to the list


		pg.addStudent(new Student("110", "John Doe",30, "B"));
		pg.addStudent(new Student("111", "Bob Smith", 31, "C-"));

		//*** Task #2: one of the students newly added should have no grade posted - see the constructor from Course
		pg.addStudent(new Student("105", "Lizard Liz", 20));


		System.out.println("Initial Project Group: ");
		System.out.println("***********************");
		// *** list the four students you have in the initial list

		System.out.println(pg.toString());

		//*** Task #3: find student with student ID 101 in the list, making sure to invoke the method with correct arguments
		System.out.println("*******************");
		System.out.println("find student with student ID 101 ");
		Student findSomeone = pg.find("101");
		System.out.println(findSomeone);

		//*** Task #4: add one course after the student with ID 101

		//*** Task #5: post a grade for one of the students that did not have grade.

		pg.find("105").setGrade("-D");

		//*	replace a studentcourse with a brand new course, which you should instantiate.

		System.out.println("Final Project Group");
		System.out.println("*******************");
		//*** Task #6: print the new list of students

		System.out.println(pg.toString());

	}
}
