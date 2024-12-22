package controller;

import javax.swing.JPanel;

import view.panels.UserSystemPanel;
import model.user.UserSystem;

public class UserSystemController {
    private static UserSystemController instance;

    private static final UserSystemPanel view = new UserSystemPanel();
    private final UserSystem model = new UserSystem();

    private UserSystemController() {
        
    }

    public JPanel getView() {
        return view;
    }

    public static synchronized UserSystemController getInstance() {
        if (instance == null) {
            instance = new UserSystemController();
        }
        return instance;
    }
}
