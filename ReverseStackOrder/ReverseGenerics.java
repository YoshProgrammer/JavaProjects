import jsjf.*;

import java.util.Scanner;

/**
 * Class that takes the inputs and reverses the user input
 */
public class ReverseGenerics<T> {

    private static ArrayStack stack;
    private static Scanner input = new Scanner(System.in);

    /**
     * Main method to instiniate a new arraystack
     * @param stack
     */
    public ReverseGenerics() {     
        this.stack = new ArrayStack<T>(); 
    }
        
    /**
     * Helper method to print a line out to the console
     * @param prompt
     */
    private static void promptUser(String prompt) {
        System.out.print(prompt);
    }

    /**
     * Helper method to print out a new line to the console
     * @param prompt
     */
    private static void printConsole(String prompt) {
        System.out.println(prompt);
    }

    /**
     * Takes user inputs (characters) and prints them in a reverse order
     */
    public static void reverseCharacters() {
        int initialArrayCount = 0;
        int arraySize = 0;
        String nextInput = "";
        String originalOutput = "Stack as entered: ";
        String finalOutput = "Reversed Stack: ";

        while (!nextInput.contains("yes")) {
            promptUser("Input Character. Hit enter after entering a single character: ");
            nextInput = input.next();
            Character nextChar = nextInput.charAt(0);
            stack.push(nextChar);
            originalOutput += nextChar;
            originalOutput += " ";
            arraySize++;
            promptUser("Are you done entering characters? (yes to exit, no to continue) ");
            nextInput = input.next();
        }

        while (initialArrayCount < arraySize) {
            Object poppedChar = stack.pop();
            finalOutput += poppedChar;
            finalOutput += " ";
            initialArrayCount++;
        }

        printConsole(originalOutput);
        printConsole(finalOutput);
        printConsole("");
    }


    /**
     * Takes user inputs (strings) and prints them in a reverse order
     */
    public static void reverseStrings() {
        int initialArrayCount = 0;
        int arraySize = 0;
        String nextInput = "";
        String originalOutput = "Stack as entered: ";
        String finalOutput = "Reversed Stack: ";

        while (!nextInput.contains("yes")) {
            promptUser("Input String. Hit enter after entering a string: ");
            nextInput = input.next();
            stack.push(nextInput);
            originalOutput += nextInput;
            originalOutput += " ";
            arraySize++;
            promptUser("Are you done entering strings? (yes to exit, no to continue) ");
            nextInput = input.next();
        }

        while (initialArrayCount < arraySize) {
            Object poppedString = stack.pop();
            finalOutput += poppedString;
            finalOutput += " ";
            initialArrayCount++;
        }

        printConsole(originalOutput);
        printConsole(finalOutput);
        printConsole("");
    }

    /**
     * Takes user inputs (numbers) and prints them in a reverse order
     */
    public static void reverseIntegers() {
        int nextInput = 0;
        int initialArrayCount = 0;
        int arraySize = 0;
        String exitAnswer = "";
        String originalOutput = "Stack as entered: ";
        String finalOutput = "Reversed Stack: ";
        
        while (!exitAnswer.contains("yes")) {
            promptUser("Please input a number. Hit enter after entering a number. ");
            nextInput = input.nextInt();
            stack.push(nextInput);
            originalOutput += nextInput;
            originalOutput += " ";
            arraySize++;
            promptUser("Are you done entering numbers? (yes to exit, no to continue) ");
            exitAnswer = input.next();
        }

        while (initialArrayCount < arraySize) {
            Object poppedInt = stack.pop();
            finalOutput += poppedInt;
            finalOutput += " ";
            initialArrayCount++;
        }

        printConsole(originalOutput);
        printConsole(finalOutput);
        printConsole("");
    }
    
    /**
     * TEST METHOD
     * Validates the reverseCharacters method
     * Pushes characters into the array, and then reverses them. Verifies the expected output matches.
     */
    public static void testReverseCharacters() {
        int initialArrayCount = 0;
        int arraySize = 10;
        String finalOutput = "";

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("i");
        stack.push("j");

        while (initialArrayCount < arraySize) {
            Object poppedChar = stack.pop();
            finalOutput += poppedChar;
            initialArrayCount++;
        }

        if (finalOutput.contentEquals("jihgfedcba")) {
            printConsole("Character Test Passed");
        } else {
            printConsole("Character Test Failed: " + finalOutput);
        }
    }

    /**
     * TEST METHOD
     * Validates the reverseStrings method
     * Pushes strings into the array, and then reverses them. Verifies the expected output matches.
     */
    public static void testReverseStrings() {
        int initialArrayCount = 0;
        int arraySize = 5;
        String finalOutput = "";

        stack.push("hey");
        stack.push("how");
        stack.push("are");
        stack.push("you");
        stack.push("today");

        while (initialArrayCount < arraySize) {
            Object poppedString = stack.pop();
            finalOutput += poppedString;
            initialArrayCount++;
        }

        if (finalOutput.contentEquals("todayyouarehowhey")) {
            printConsole("String Test Passed");
        } else {
            printConsole("String Test Failed: " + finalOutput);
        }
    }

    /**
     * TEST METHOD
     * Validates the reverseIntegers method
     * Pushes numbers into the array, and then reverses them. Verifies the expected output matches.
     */
    public static void testReverseIntegers() {
        int initialArrayCount = 0;
        int arraySize = 10;
        String finalOutput = "";

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        while (initialArrayCount < arraySize) {
            Object poppedInt = stack.pop();
            finalOutput += poppedInt;
            initialArrayCount++;
        }

        if (finalOutput.contentEquals("10987654321")) {
            printConsole("Integer Test Passed");
        } else {
            printConsole("Integer Test Failed: " + finalOutput);
        }
    }
}
