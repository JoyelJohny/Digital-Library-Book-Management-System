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

    private void addBook(){}
    private void updateBook(){}
    private void deleteBook(){}
    private void listAllBooks(){}
    private void searchBook(){}


}
