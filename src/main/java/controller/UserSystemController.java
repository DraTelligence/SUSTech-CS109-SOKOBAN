package controller;

import javax.swing.JPanel;

import view.panels.UserSystemPanel;

public class UserSystemController {
    private static UserSystemController instance;

    private final UserSystemPanel view = new UserSystemPanel();

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
