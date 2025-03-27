package model;

import exception.EmptyFieldException;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private BookAvailabilityStatus availabilityStatus;

    public Book(String bookID,String title,String author,String genre,BookAvailabilityStatus availabilityStatus){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    // Getter methods

    public String getBookID(){
        return this.bookID;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getGenre(){
        return this.genre;
    }

    public BookAvailabilityStatus getAvailabilityStatus(){
        return this.availabilityStatus;
    }

    // Setter methods

    public void setBookID(String bookID){
        this.bookID = bookID;
    }

    public void setTitle(String title) throws EmptyFieldException {
        if(title.isBlank()){
            throw new EmptyFieldException("Title cannot be Empty");
        }
        this.title = title;
    }

    public void setAuthor(String author) throws EmptyFieldException {
        if(author.isBlank()){
            throw  new EmptyFieldException("Author cannot be Empty");
        }
        this.author = author;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setAvailabilityStatus(BookAvailabilityStatus availabilityStatus){
        this.availabilityStatus = availabilityStatus;
    }
}
