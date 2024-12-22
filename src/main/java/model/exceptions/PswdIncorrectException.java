package model.exceptions;

public class PswdIncorrectException extends java.lang.Exception{
    @Override
    public String getMessage(){
        return "Incorrect Password!";
    }
}
