package model.exceptions;

public class UserAlreadyExistsException extends java.lang.Exception{
    @Override 
    public String getMessage(){
        return "The user name has been occupied!";
    }
}
