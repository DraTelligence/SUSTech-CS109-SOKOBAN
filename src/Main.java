import view.level.LevelFrame;
import view.login.LoginFrame;
import view.login.StartFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartFrame startFrame = new StartFrame();
            startFrame.setVisible(true);
        });
    }
}
