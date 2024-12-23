package view.panels;

import java.awt.CardLayout;

import javax.swing.JPanel;

import view.userSystem.LogInPanel;
import view.userSystem.UserProfilePanel;

public class UserSystemPanel extends JPanel{
    private static UserSystemPanel instance;
    final private static UserProfilePanel profilePanel=new UserProfilePanel();
    final private static LogInPanel logInPanel=new LogInPanel();

    static CardLayout layout=new CardLayout();

    public static UserSystemPanel getInstance() {
        if (instance == null) {
            instance = new UserSystemPanel();
        }
        return instance;
    }

    private UserSystemPanel(){
        this.setLayout(layout);

        this.add(profilePanel,"profile");
        this.add(logInPanel,"logIn");
    }

    public void switchPanel(String panel){
        layout.show(this, panel);
    }

    public JPanel getView(){
        return this;
    }
}
