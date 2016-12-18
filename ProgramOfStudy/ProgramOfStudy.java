import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.lang.System;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import jsjf.*;

/**
 * Represents a Program of Study, a list of courses taken and planned, for an
 * individual student.
 *
 * Base code comes from Java Foundations, extended by Joshua Brown
 */
public class ProgramOfStudy implements Iterable<Course>, Serializable
{
	private ArrayOrderedList<Course> list;
	
	/**
	 * Constructs an initially empty Program of Study.
	 */
	public ProgramOfStudy()
	{
		list = new ArrayOrderedList<Course>();
	}
	
	/**
	 * Adds the specified course to the end of the course list.
	 * 
	 * @param course the course to add
	 */
	public void addCourse(Course course) {
        if (course != null) {
            list.add(course);
        }
    }
	
	/**
	 * Finds and returns the course matching the specified prefix and number.
	 * 
	 * @param prefix the prefix of the target course
	 * @param number the number of the target course
	 * @return the course, or null if not found
	 */
	public Course find(String prefix, int number)
	{
		for (Course course : list) {
            if (prefix.equals(course.getPrefix()) && number == course.getNumber()) {
                return course;
            }
        }

		return null;
	}

	/**
	 * Creates and returns a string representation of this Program of Study.
	 * 
	 * @return a string representation of the Program of Study
	 */
	public String toString()
	{
		String result = "";
		for (Course course : list) {
            result += course + "\n";
        }

		return result;
	}
	
	/**
	 * Returns an iterator for this Program of Study.
	 * 
	 * @return an iterator for the Program of Study
	 */
	public Iterator<Course> iterator()
	{
		return list.iterator();
	}

	/**
	 * Saves a serialized version of this Program of Study to the specified
	 * file name.
	 * 
	 * @param fileName the file name under which the POS will be stored
	 * @throws IOException
	 */
	public void save(String fileName) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(fileName); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		oos.writeObject(this); 
		oos.flush(); 
		oos.close(); 
	}

	/**
	 * Loads a serialized Program of Study from the specified file.
	 * 
	 * @param fileName the file from which the POS is read
	 * @return the loaded Program of Study
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ProgramOfStudy load(String fileName) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ProgramOfStudy pos = (ProgramOfStudy) ois.readObject();
		ois.close();
		
		return pos;
	}
}
