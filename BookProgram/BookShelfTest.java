/*
* This is a Java driver class called "BookShelfTest". This is used as a separate class driver, used to validate
* the methods in the "Book" class. It creates initial Book objects, gets the initial items, validates they match
* and then it sets them to a new value and validates they match.
* Written by Joshua Brown
*/


import java.lang.Integer;

public class BookShelfTest {

    public static void main(String[] args) {

        //Data members for testing
        String firstBookTitle;
        String firstBookAuthor;
        String firstBookPublisher;
        int firstBookCopyrightDate;

        String secondBookTitle;
        String secondBookAuthor;
        String secondBookPublisher;
        int secondBookCopyrightDate;

        Book firstBook = new Book("firstbook", "firstauthor", "firstpublisher", 1994);
        Book secondBook = new Book("secondbook", "secondauthor", "secondpublisher", 1990);

        firstBookTitle = firstBook.getBookTitle();
        verifyResult(firstBookTitle, "firstbook");

        firstBookAuthor = firstBook.getBookAuthor();
        verifyResult(firstBookAuthor, "firstauthor");

        firstBookPublisher = firstBook.getBookPublisher();
        verifyResult(firstBookPublisher, "firstpublisher");

        firstBookCopyrightDate = firstBook.getCopyrightDate();
        verifyResult(Integer.toString(firstBookCopyrightDate), "1994");

        secondBookTitle = secondBook.getBookTitle();
        verifyResult(secondBookTitle, "secondbook");

        secondBookAuthor = secondBook.getBookAuthor();
        verifyResult(secondBookAuthor, "secondauthor");

        secondBookPublisher = secondBook.getBookPublisher();
        verifyResult(secondBookPublisher, "secondpublisher");

        secondBookCopyrightDate = secondBook.getCopyrightDate();
        verifyResult(Integer.toString(secondBookCopyrightDate), "1990");

        firstBook.setBookTitle("firstBookTitle");
        firstBook.setBookAuthor("firstBookAuthor");
        firstBook.setBookPublisher("firstBookPublisher");
        firstBook.setCopyrightDate(2016);

        secondBook.setBookTitle("secondBookTitle");
        secondBook.setBookAuthor("secondBookAuthor");
        secondBook.setBookPublisher("secondBookPublisher");
        secondBook.setCopyrightDate(2016);

        firstBookTitle = firstBook.getBookTitle();
        verifyResult(firstBookTitle, "firstBookTitle");

        firstBookAuthor = firstBook.getBookAuthor();
        verifyResult(firstBookAuthor, "firstBookAuthor");

        firstBookPublisher = firstBook.getBookPublisher();
        verifyResult(firstBookPublisher, "firstBookPublisher");

        firstBookCopyrightDate = firstBook.getCopyrightDate();
        verifyResult(Integer.toString(firstBookCopyrightDate), "2016");

        secondBookTitle = secondBook.getBookTitle();
        verifyResult(secondBookTitle, "secondBookTitle");

        secondBookAuthor = secondBook.getBookAuthor();
        verifyResult(secondBookAuthor, "secondBookAuthor");

        secondBookPublisher = secondBook.getBookPublisher();
        verifyResult(secondBookPublisher, "secondBookPublisher");

        secondBookCopyrightDate = secondBook.getCopyrightDate();
        verifyResult(Integer.toString(secondBookCopyrightDate), "2016");
    }

    static void verifyResult(String value, String expectedValue) {
        if (value.contains(expectedValue)) {
            System.out.println("PASS"); // ALL TESTS PASSED
        } else {
            System.out.println("FAILED" + value + " expected value: " + expectedValue);
        }
    }
}

