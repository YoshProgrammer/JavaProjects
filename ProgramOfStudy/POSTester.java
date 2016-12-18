import java.io.IOException;
import java.lang.System;

/**
 * Makes use of an ArrayOrderedList to add courses to the ProgramOfStudy list.
 * Since this is an ArrayOrderedList, it adds courses in a specific order, specified by the compareTo method.
 */
public class POSTester
{
	/**
	 * Creates and populates a Program of Study. Then saves it using serialization.
	 */
	public static void main(String[] args) throws IOException
	{
		ProgramOfStudy pos = new ProgramOfStudy();
		
		pos.addCourse(new Course("CS", 101, "Programming 101", "A-", "Engineering"));
		pos.addCourse(new Course("ARCH", 305, "Analytics", "A", "Architecture"));
		pos.addCourse(new Course("GER", 210, "German 210", "Languages"));
		pos.addCourse(new Course("CS", 320, "Microprocessors", "Engineering"));
		pos.addCourse(new Course("THE", 201, "Theatre Experience", "Arts"));
        pos.addCourse(new Course("CS", 100, "CPU Beginnings", "Engineering"));
        pos.addCourse(new Course("THE", 301, "Shakespeare Art", "Arts"));
        pos.addCourse(new Course("THE", 101, "Art 101", "Arts"));
        pos.addCourse(new Course("GER", 510, "Adv German", "Languages"));
        pos.addCourse(new Course("GER", 410, "Native German", "Languages"));

        System.out.println("\n");
        System.out.format("%16s%16s%16s%20s%16s", "Department", "Prefix", "Number", "Title", "Grade");
        System.out.println("\n");
        System.out.println(pos);
		
		pos.save("ProgramOfStudy");

        //testRunner(); //Uncomment this if you want to run the test
	}

    /**
     * Helper test method, basically what I expect the output of the command line to be and what it ends up being
     * I add spaces, so I'm not checking the exact output format but rather that the courses are being ordered
     * correctly.
     * @throws IOException
     */
    private static void testRunner() throws IOException {
        ProgramOfStudy pos = new ProgramOfStudy();

        pos.addCourse(new Course("CS", 101, "Programming 101", "A-", "Engineering"));
        pos.addCourse(new Course("CS", 320, "Microprocessors", "Engineering"));
        pos.addCourse(new Course("CS", 100, "CPU Beginnings", "Engineering"));
        pos.addCourse(new Course("AB", 320, "Adv Drawing", "Arts"));
        pos.addCourse(new Course("AB", 110, "Intro Art", "Arts"));


        System.out.println("EXPECTED FORMAT");
        System.out.println("\n");

        System.out.format("%16s%16s%16s%20s%16s", "Department", "Prefix", "Number", "Title", "Grade");
        System.out.println("\n");

        System.out.format("%16s%16s%16s%20s%16s", "Arts", "AB", "110", "Intro Art", "[TBD]");
        System.out.println("\n");
        System.out.format("%16s%16s%16s%20s%16s", "Arts", "AB", "320", "Adv Drawing", "[TBD]");
        System.out.println("\n");
        System.out.format("%16s%16s%16s%20s%16s", "Engineering", "CS", "100", "CPU Beginnings", "[TBD]");
        System.out.println("\n");
        System.out.format("%16s%16s%16s%20s%16s", "Engineering", "CS", "101", "Programming 101", "[A-]");
        System.out.println("\n");
        System.out.format("%16s%16s%16s%20s%16s", "Engineering", "CS", "320", "Microprocessors", "[TBD]");
        System.out.println("\n");


        System.out.println("\n");

        System.out.println("Outputted FORMAT");
        System.out.println("\n");
        System.out.format("%16s%16s%16s%20s%16s", "Department", "Prefix", "Number", "Title", "Grade");
        System.out.println("\n");
        System.out.println(pos);

        pos.save("ProgramOfStudy");
    }
}
