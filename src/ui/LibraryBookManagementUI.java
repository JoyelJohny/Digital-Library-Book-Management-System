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
    public void run(){
        while (true){
            displayMenu();
            int choice = getSelectedOperation();
            handleSelectedOperation(choice);
        }
    }

    // To display the operations
    private void displayMenu(){
        System.out.println("------------------ Digital Library Book Management System -------------------");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book");
        System.out.println("3. Delete Book");
        System.out.println("4. View All Books");
        System.out.println("5. Search Book");
        System.out.println("6. Exit");
        System.out.println("Enter the number to perform the corresponding operation");
    }

    // To get the value of Selected operation
    private int getSelectedOperation(){
        while(!read.hasNextInt()){
            System.out.println("Invalid input. Please enter a number !");
            read.next();
        }
        return read.nextInt();
    }

    // To call the function corresponding to the selected operation
    private void handleSelectedOperation(int choice){
        read.nextLine();
        switch (choice){
            case 1-> addBook();
            case 2-> updateBook();
            case 3-> deleteBook();
            case 4-> listAllBooks();
            case 5-> searchBook();
            case 6-> exitApplication();
            default-> System.out.println("Invalid Choice. Please Select a valid Choice !");
        }
    }

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
