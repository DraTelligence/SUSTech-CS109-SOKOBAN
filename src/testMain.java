import exceptions.PswdIncorrectException;
import exceptions.UserNotFoundException;
import java.util.*;
import user.*;

public class testMain {
    public static void main(String[] args) throws Exception {
        try(Scanner sc=new Scanner(System.in)){
            System.out.print("enter ur name:");
            String userName= sc.next();
            System.out.print("enter ur pswd:");
            String pswd=sc.next();

            UserSystem userSystem= new UserSystem();

            try {
                userSystem.logIn(userName, pswd);
                System.out.println(userSystem.getCurrentUser());
            } catch (PswdIncorrectException | UserNotFoundException e) {
                System.out.print(e.getMessage());
            }
        }
    }
}
