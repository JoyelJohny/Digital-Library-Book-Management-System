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
        if(isBookIDExist(book.getBookID())){
            System.out.println("Book ID already exists!");
            return;
        }
        books.put(book.getBookID(), book);
        System.out.println("Book added successfully!");
    }

    public void updateBook(String bookID, Scanner read) throws BookNotFoundException, EmptyFieldException {
        if(isBookIDExist(bookID)){
            Book book = books.get(bookID);
            System.out.println("Updating Book : "+book);
            System.out.print("Enter Book ID: ");
            String newBookID = read.nextLine();
            if(isBookIDExist(newBookID)){
                System.out.println("Book ID already exists!");
                return;
            }
            System.out.print("Enter Title: ");
            String newTitle = read.nextLine();
            System.out.print("Enter Author: ");
            String newAuthor = read.nextLine();
            System.out.print("Enter Genre: ");
            String newGenre = read.nextLine();
            System.out.print("Enter Availability Status (AVAILABLE/CHECKED_OUT): ");
            String newAvailabilityInput = read.nextLine();

            if (!newBookID.isEmpty() && !newBookID.equals(book.getBookID())){
                Book newBook = new Book(newBookID,book.getTitle(),book.getAuthor(),book.getGenre(),book.getAvailabilityStatus());
                books.put(newBookID,newBook);
                books.remove(book.getBookID());
                book = newBook;
            }
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

            System.out.println("Updated Book Details successfully");

        }else{
            throw new BookNotFoundException("No Book has been found with given BookID. Please Check for any spelling mistake !");
        }
    }

    public void deleteBook(String deleteID) throws BookNotFoundException{
        if(isBookIDExist(deleteID)){
            books.remove(deleteID);
            System.out.println("Successfully Deleted Book From the collection");
        }else{
            throw new BookNotFoundException("No Book has been found with given BookID. Please Check for any spelling mistake !");
        }
    }

    public void listAllBooks(){
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for(Book book : books.values()) {
            System.out.println("----------------------------------------------");
            System.out.println("BookID : " + book.getBookID());
            System.out.println("Title : " + book.getTitle());
            System.out.println("Author : " + book.getAuthor());
            System.out.println("Genre : " + book.getGenre());
            System.out.println("Availability Status : " + book.getAvailabilityStatus());
        }
    }

    public Book searchBook(String input) throws BookNotFoundException {
        if(isBookIDExist(input)){
            return books.get(input);
        }
        return books.values()
                .stream()
                .filter(book->book.getTitle().equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(()->new BookNotFoundException("No Book has been found with given Title or BookID. Please Check for any spelling mistake !"));
    }

    public boolean isBookIDExist(String bookID){
        return books.containsKey(bookID);
    }


}
