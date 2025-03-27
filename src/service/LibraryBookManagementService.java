package service;

import model.Book;

import java.util.HashMap;
import java.util.Map;

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
    public void updateBook(){}
    public void deleteBook(){}
    public void listAllBooks(){}
    public void searchBook(){}


}
