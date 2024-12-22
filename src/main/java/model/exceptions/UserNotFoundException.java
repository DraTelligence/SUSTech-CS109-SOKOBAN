package model.exceptions;

public class UserNotFoundException extends java.lang.Exception {
    @Override
    public String getMessage(){
        return "user not found, probably because of a spelling error!";
    }
}
