package controller;

import java.awt.CardLayout;

import javax.swing.JPanel;

import view.MainFrame;
import view.app.ClosingDialog;

public class AppController {
    static private final CardLayout layout = new CardLayout();
    static private final JPanel cardPanel = new JPanel();

    private static AppController instance;

    private final MapFactoryController mapFactoryController = MapFactoryController.getInstance();
    private final MainMenuController mainMenuController = MainMenuController.getInstance();
    private final LevelSelectMenuController levelSelectMenuController = LevelSelectMenuController.getInstance();
    private final GameController gameController = GameController.getInstance();
    private final UserSystemController userSystemController = UserSystemController.getInstance();

    private AppController() {
        cardPanel.setVisible(true);
        cardPanel.setOpaque(false);
        cardPanel.setBounds(0, 0, 555, 785);
        cardPanel.setLayout(layout);

        cardPanel.add(mapFactoryController.getView(),"mapFactory");
        cardPanel.add(mainMenuController.getView(), "mainMenu");
        cardPanel.add(levelSelectMenuController.getView(), "levelSelectMenu");
        cardPanel.add(gameController.getView(), "game");
        cardPanel.add(userSystemController.getView(), "userSystem");
    }

    public static synchronized AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }
        return instance;
    }

    public void start(){
        try{
            MainFrame.getInstance().add(cardPanel);
            layout.show(cardPanel, "mainMenu");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void switchToMapFactory(){
        layout.show(cardPanel, "mapFactory");
    }

    public void switchToMainMenu(){
        layout.show(cardPanel, "mainMenu");
    }

    public void switchToLevelSelectMenu(){
        layout.show(cardPanel, "levelSelectMenu");
    }

    public void switchToGameController(){
        layout.show(cardPanel, "game");
    }

    public void switchToUserSystem(){
        userSystemController.init();
        layout.show(cardPanel, "userSystem");
    }

    public void handleWindowClosing(){
        new ClosingDialog().setVisible(true);
    }

    public void exitProgram(){
        System.exit(0);
    }
}
