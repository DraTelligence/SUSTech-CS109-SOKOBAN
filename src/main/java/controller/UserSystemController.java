package controller;

import javax.swing.JPanel;

import model.user.UserSystem;
import view.userSystem.UserSystemPanel;

public class UserSystemController {
    private static UserSystemController instance;

    private static final UserSystemPanel view = new UserSystemPanel();
    private final UserSystem model = new UserSystem();

    public JPanel getView() {
        return view;
    }

    public static synchronized UserSystemController getInstance() {
        if (instance == null) {
            instance = new UserSystemController();
        }
        return instance;
    }

    /**
     * the method will be called by view to get the name of the current user from model
     * @return
     */
    public String getUserName(){}

    /**
     * the method will be called by view to get the password of the current user from model
     */
    public void get
}
