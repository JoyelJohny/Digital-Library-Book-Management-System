package exception;

public class EmptyFieldException extends Exception{
    public EmptyFieldException(String errorMessage){
        super(errorMessage);
    }
}
