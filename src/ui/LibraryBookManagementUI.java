package ui;

import service.LibraryBookManagementService;

import java.util.Scanner;

public class LibraryBookManagementUI {
    private LibraryBookManagementService service;
    private Scanner read;

    public LibraryBookManagementUI(){
        this.service = new LibraryBookManagementService();
        this.read = new Scanner(System.in);
    }

    // To run the application
    public void run(){}

    // To display the operations
    private void displayMenu(){}

    // To get the value of Selected operation
    private int getSelectedOperation(){}

    // To call the function corresponding to the selected operation
    private void handleSelectedOperation(){}

    // The UI for adding a book
    private void addBook(){}

    // The UI for updating a book
    private void updateBook(){}

    // The UI for Deleting a book
    private void deleteBook(){}

    // The UI for viewing all books
    private void listAllBooks(){}

    // The UI for searching a Book
    private void searchBook(){}

    // The UI for exiting the application
    private void exitApplication(){}

}
