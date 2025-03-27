package service;

import exception.BookNotFoundException;
import exception.EmptyFieldException;
import model.Book;
import model.BookAvailabilityStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryBookManagementService {

    // Used Hashmap for fast searching of books.
    private final Map<String, Book> books;

    public LibraryBookManagementService(){
        this.books = new HashMap<>();
    }

    public void addBook(Book book){
        if(books.containsKey(book.getBookID())){
            System.out.println("Book ID already exists!");
            return;
        }
        books.put(book.getBookID(), book);
        System.out.println("Book added successfully!");
    }
    public void updateBook(String bookID, Scanner read) throws BookNotFoundException, EmptyFieldException {
        if(books.containsKey(bookID)){
            Book book = books.get(bookID);
            System.out.print("Updating Book : "+book);
            System.out.print("Enter Book ID: ");
            String newBookID = read.nextLine();
            System.out.print("Enter Title: ");
            String newTitle = read.nextLine();
            System.out.print("Enter Author: ");
            String newAuthor = read.nextLine();
            System.out.print("Enter Genre: ");
            String newGenre = read.nextLine();
            System.out.print("Enter Availability Status (AVAILABLE/CHECKED_OUT): ");
            String newAvailabilityInput = read.nextLine();

            if (!newTitle.isEmpty()) book.setTitle(newTitle);
            if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);
            if (!newGenre.isEmpty()) book.setGenre(newGenre);
            if (!newAvailabilityInput.isEmpty()) {
                try {
                    book.setAvailabilityStatus(BookAvailabilityStatus.valueOf(newAvailabilityInput.toUpperCase()));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid availability status! Use AVAILABLE or CHECKED_OUT.");
                }
            }

        }else{
            throw new BookNotFoundException("No Book has been found with given BookID. Please Check for any spelling mistake !");
        }
    }
    public void deleteBook(){}
    public void listAllBooks(){}
    public void searchBook(){}


}
