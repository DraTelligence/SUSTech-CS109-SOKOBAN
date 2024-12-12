package exceptions;

public class AnswerNotFoundException extends java.lang.Exception{
    @Override
    public String getMessage(){
        return "The given map has no corresponding answer...";
    }
}
