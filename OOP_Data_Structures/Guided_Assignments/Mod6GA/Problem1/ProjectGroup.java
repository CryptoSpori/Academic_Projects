package Mod6GA.Problem1;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-03
 *
 * Student name:  John Stelly
 * Completion date: 11/11/2020
 *
 * ProjectGroup.txt: template file of ProjectGroup.java
 * Student tasks: complete tasks specified in the file
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Represents a list of students for a project group.
 *
 */
public class ProjectGroup implements Iterable<Student>
{
	// instance variable
	private List<Student> list;

	/**
	 * Constructs an initially empty list representing a group project.
	 */
	public ProjectGroup()
	{
		//*** Task #1: add code here for the constructor

		list = new LinkedList<>();
	}


	/**
	 * Adds the specified student to the end of the student list.
	 *
	 * @param student as the student to add
	 */
	public void addStudent(Student student) {
		//*** Task #2: create the body of this method
		list.add(student);
	}

	/**
	 * Finds and returns the student matching the specified studentID
	 * @param studentID, as the studentID of the target student
	 * @return the student, or null if not found
	 */
	public Student find(String studentID){
		//*** Task #3: fill in the body of method find
		List<Student> tempList = list;
		Student found = null;
		Student check;
		Iterator<Student> review = tempList.iterator();
		while (review.hasNext()) {
			check = review.next();
			String checkStudentID = check.getStudentID();
			if (checkStudentID.equalsIgnoreCase(studentID)) {
				found = check;
			}
		}
		return found;
	}

	/**
	 * Adds the specified student after the target student. 
	 * Does nothing if either student is null or if the target is not found.
	 *
	 * @param target the student after which the new student will be added
	 * @param newStudent the student to add
	 */
	public void addStudentAfter(Student target, Student newStudent){
		//*** Task #4: ill in the body of method addStudentAfter
		int index = 0;
		Student check;
		Iterator<Student> searchList = list.iterator();
		while (searchList.hasNext()) {
			check = searchList.next();
			if (target.equals(check)) {
				list.add(index, newStudent);
			}
			index++;
		}
	}

	/**
	 * Replaces the specified target student with the new student. Does nothing if
	 * either student is null or if the target is not found.
	 *
	 * @param target the student to be replaced
	 * @param newStudent the new student to add
	 */
	public void replace(Student target, Student newStudent) {
		//*** Task #5: fill in the body of method replace
		int index = 0;
		Student check;
		Iterator<Student> searchList = list.iterator();
		while (searchList.hasNext()) {
			check = searchList.next();
			if (target.equals(check)) {
				list.remove(index);
				list.add(index, newStudent);
			}
			index++;
		}
	}

	/**
	 * Creates and returns a string representation of this ProjectGroup object.
	 *
	 * @return a string representation of the ProjectGroup object
	 */
	public String toString() {
		//*** Task #6: fill in the body of the method toString()
		String listText = "";
		Iterator<Student> searchList = list.iterator();
		while (searchList.hasNext()) {
			listText = listText + searchList.next().toString() + "\n";
		}
		return listText;
	}


	/**
	 * Returns an iterator for this Program of Study.
	 *
	 * @return an iterator for the Program of Study
	 */
	public Iterator<Student> iterator()
	{
		return list.iterator();
	}

}
