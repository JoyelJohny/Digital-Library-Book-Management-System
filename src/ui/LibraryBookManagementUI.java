package ui;

import exception.BookNotFoundException;
import model.Book;
import model.BookAvailabilityStatus;
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
    private void addBook(){
        System.out.println("------------------------------------------------");
        System.out.print("Enter Book ID: ");
        String bookID = read.nextLine();
        if(service.isBookIDExist(bookID)){
            System.out.println("Book ID already exists!");
            return;
        }
        if(bookID.isBlank()){
            System.out.println("Book ID cannot be Empty");
            return;
        }
        System.out.print("Enter Title: ");
        String title = read.nextLine();
        if(title.isBlank()){
            System.out.println("Title cannot be Empty");
            return;
        }
        System.out.print("Enter Author: ");
        String author = read.nextLine();
        if(author.isBlank()){
            System.out.println("Author cannot be Empty");
            return;
        }
        System.out.print("Enter Genre: ");
        String genre = read.nextLine();
        System.out.print("Enter Availability Status (AVAILABLE/CHECKED_OUT): ");
        String availabilityInput = read.nextLine();
        try {
            BookAvailabilityStatus availability = BookAvailabilityStatus.valueOf(availabilityInput.toUpperCase());
            service.addBook(new Book(bookID,title,author,genre,availability));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid availability status! Use AVAILABLE or CHECKED_OUT.");
        }
    }

    // The UI for updating a book
    private void updateBook(){
        System.out.println("------------------------------------------------");
        System.out.print("Enter BookID : ");
        String bookID = read.nextLine();
        try {
            service.updateBook(bookID,read);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // The UI for Deleting a book
    private void deleteBook(){
        System.out.print("Enter Book ID to delete: ");
        String deleteID = read.nextLine();
        try {
            service.deleteBook(deleteID);
            System.out.println("Book deleted successfully!");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // The UI for viewing all books
    private void listAllBooks(){
        service.listAllBooks();
    }

    // The UI for searching a Book
    private void searchBook(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter the BookID or Title to search : ");
        String input = read.nextLine();
        try {
            Book queriedBook = service.searchBook(input);
            System.out.println("--------------------------------------------------------");
            System.out.println("BookID : "+queriedBook.getBookID());
            System.out.println("Title : "+queriedBook.getTitle());
            System.out.println("Author : "+queriedBook.getAuthor());
            System.out.println("Genre : "+queriedBook.getGenre());
            System.out.println("Availability Status : "+queriedBook.getAvailabilityStatus());
        }catch (Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }

    // The UI for exiting the application
    private void exitApplication(){
        System.out.println("Exiting the system. Goodbye!");
        read.close();
        System.exit(0);
    }

}
