import javax.swing.*;
import view.level.LevelFrame;
import view.login.LoginFrame;

public class Main {
    public static void main(String[] args) {
            LoginFrame loginFrame = new LoginFrame(500,300);
            loginFrame.setVisible(true);

            LevelFrame levelFrame = new LevelFrame(500,300);
            levelFrame.setVisible(false);
            loginFrame.setLevelFrame(levelFrame);


    }
}
