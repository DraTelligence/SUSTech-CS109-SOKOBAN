package controller;

import javax.swing.JPanel;

public class LevelSelectMenuController {
    private static LevelSelectMenuController instance;

    private final LevelSelectMenuPanel view= new LevelSelectMenuPanel();

    private LevelSelectMenuController() {
        
    }

    public JPanel getView() {
        return view;
    }

    public static synchronized LevelSelectMenuController getInstance() {
        if (instance == null) {
            instance = new LevelSelectMenuController();
        }
        return instance;
    }
}
