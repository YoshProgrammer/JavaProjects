/*
 * This is a Java class implementing the "Book" class, which has four properties.
 * These properties are title, author, publisher, and copyright date.
 * Written by Joshua Brown
 */

import java.lang.Integer;

public class Book {

    private String title;
    private String author;
    private String publisher;
    private int copyrightDate;

    public Book(String bookTitle, String bookAuthor, String bookPublisher, int bookCopyrightDate) {
        title = bookTitle;
        author = bookAuthor;
        publisher = bookPublisher;
        copyrightDate = bookCopyrightDate;
    }

    public String getBookTitle() {
        return title;
    }

    public void setBookTitle(String bookTitle) {
        title = bookTitle;
    }

    public String getBookAuthor() {
        return author;
    }

    public void setBookAuthor(String bookAuthor) {
        author = bookAuthor;
    }

    public String getBookPublisher() {
        return publisher;
    }

    public void setBookPublisher(String bookPublisher) {
        publisher = bookPublisher;
    }

    public int getCopyrightDate() {
        return copyrightDate;
    }

    public void setCopyrightDate(int bookCopyrightDate) {
        copyrightDate = bookCopyrightDate;
    }

    public String toString() {
        String finalFormat = "";

        finalFormat += "Author: " + "  " + author + "  " + "\n";
        finalFormat += "Title: " + "  " + title + "  " + "\n";
        finalFormat += "Copyright Date: " + "  " + Integer.toString(copyrightDate) + "  " + "\n";
        finalFormat += "Published By: " + "  " + publisher + "  " + "\n";

        return finalFormat;
    }
}

