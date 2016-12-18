import jsjf.*;

import java.util.Scanner;

/**
 * Reverse class which executes (3) functions.
 * These functions take user input for characters, strings and integers.
 * These inputs are then reversed and printed out. The original output is printed as well.
 */
public class Reverse {

    private static Scanner scan = new Scanner(System.in);

    /**
     * Runs the reverse steps for the characters, strings and integers
     * Also, user can opt to run tests which reuses generics to run the tests.
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("Are you running tests? Y/N ");
        String userResponse = scan.next();
        ReverseGenerics<Character> reverseCharacters = new ReverseGenerics<Character>();
        ReverseGenerics<String> reverseStrings = new ReverseGenerics<String>();
        ReverseGenerics<Integer> reverseIntegers = new ReverseGenerics<Integer>();
        
        if (userResponse.contains("Y")) {
            reverseCharacters.testReverseCharacters();
            reverseStrings.testReverseStrings();
            reverseIntegers.testReverseIntegers();
        } else {
            reverseCharacters.reverseCharacters();
            reverseStrings.reverseStrings();
            reverseIntegers.reverseIntegers();
        }
    }
}

