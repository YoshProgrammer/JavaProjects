/*
 * This is a Java driver class called "BookShelf". This invokes the various public methods available from the "Book"
 * class. This allows BookShelf to update it's local Book objects, as well as create as many Book objects as desired.
 * Written by Joshua Brown
 */


public class BookShelf {

   public static void main(String[] args) {

       Book firstBook = new Book("New Ways to Make Money", "Jeff", "PearsonExpensiveBooks", 1994);
       Book secondBook = new Book("The New Millenium", "John", "PearsonMoMoneyEducation", 1990);
       Book thirdBook = new Book("Top 10 ways to pass CSC205", "Victoria", "McgrawHill", 2016);

       System.out.println("First Book:  " + "\n" + firstBook);
       System.out.println("Second Book: " + "\n" + secondBook);
       System.out.println("Third Book: " + "\n" + thirdBook);

       firstBook.setBookTitle("10 New New Ways to Make Money");
       secondBook.setBookAuthor("Jimmy Graham");
       thirdBook.setBookPublisher("NewPearsonMcgraw");
       firstBook.setCopyrightDate(2005);

       System.out.println("Updated First Book:  " + "\n" + firstBook);
       System.out.println("Updated Second Book: " + "\n" + secondBook);
       System.out.println("Updated Third Book: " + "\n" + thirdBook);
       System.out.println("Updated First Book:  " + "\n" + firstBook);

   }
}

