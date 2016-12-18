import java.io.Serializable;
import java.lang.Comparable;
import java.lang.Integer;

/**
 * Represents a course that might be taken by a student.
 * Base code comes from Java Foundations, extended by Joshua Brown
 */
public class Course implements Serializable, Comparable<Course>
{
	private String prefix;
	private int number;
	private String title;
	private String grade;
    private String department;
	
	/**
	 * Constructs the course with the specified information.
	 * 
	 * @param prefix the prefix of the course designation
	 * @param number the number of the course designation
	 * @param title the title of the course
	 * @param grade the grade received for the course
	 */
	public Course(String prefix, int number, String title, String grade, String department)
	{
		this.prefix = prefix;
		this.number = number;
		this.title = title;
		if (grade == null) {
            this.grade = "TBD";
        } else {
            this.grade = grade;
        }
        this.department = department;
	}
	
	/**
	 * Constructs the course with the specified information, with no grade
	 * established.
	 * 
	 * @param prefix the prefix of the course designation
	 * @param number the number of the course designation
	 * @param title the title of the course
	 */
	public Course(String prefix, int number, String title, String department)
	{
		this(prefix, number, title, "TBD", department);
	}

	/**
	 * Returns the prefix of the course designation.
	 * 
	 * @return the prefix of the course designation
	 */
	public String getPrefix()
	{
		return prefix;
	}

    /**
     * Returns the department of the course.
     *
     * @return the deparment of the course.
     */
    public String getDepartment()
    {
        return department;
    }
	
	/**
	 * Returns the number of the course designation.
	 * 
	 * @return the number of the course designation
	 */
	public int getNumber()
	{
		return number;
	}
	
	/**
	 * Returns the title of this course.
	 * 
	 * @return the prefix of the course
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Returns the grade for this course.
	 * 
	 * @return the grade for this course
	 */
	public String getGrade()
	{
		return grade;
	}
	
	/**
	 * Sets the grade for this course to the one specified.
	 * 
	 * @param grade the new grade for the course
	 */
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	
	/**
	 * Returns true if this course has been taken (if a grade has been received).
	 * 
	 * @return true if this course has been taken and false otherwise
	 */
	public boolean taken()
	{
		return !grade.equals("");
	}
	
	/**
	 * Determines if this course is equal to the one specified, based on the
	 * course designation (prefix and number).
	 * 
	 * @return true if this course is equal to the parameter
	 */
	public boolean equals(Object other)
	{
		boolean result = false;
		if (other instanceof Course)
		{
			Course otherCourse = (Course) other;
			if (prefix.equals(otherCourse.getPrefix()) && number == otherCourse.getNumber()) {
                result = true;
            }
		}
		return result;
	}
	
	/**
	 * Creates and returns a string representation of this course.
	 * 
	 * @return a string representation of the course
	 */
	public String toString()
	{

        String result;
        String numberString = Integer.toString(number);
        String resultGrade = "  [" + grade + "]";

        result = String.format("%16s%16s%16s%20s%16s", department, prefix, numberString, title, resultGrade);

        return result;
	}

    /**
     * Takes in a course object, uses it to determine where it should be sorted in the list.
     * This method is picked up by the ArrayOrderedList "add" method, which is then used by the
     * "addCourse()" method in ProgramOfStudy. It is used as the criteria for sorting the courses upon the
     * addCourse method being called in the POSTester.
     * @param course
     * @return
     */
    public int compareTo(Course course)
    {
        if (getDepartment().compareTo(course.getDepartment()) == 0){
            if (getNumber() < course.getNumber()) {
                return -1;
            }
            else if (getNumber() > course.getNumber()) {
                return 1;
            }

            return 0;
        }

        return getDepartment().compareTo(course.getDepartment());

    }
}
