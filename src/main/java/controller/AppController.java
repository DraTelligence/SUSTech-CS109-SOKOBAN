package controller;

import java.awt.CardLayout;

import javax.swing.JPanel;

import view.app.ClosingDialog;

public class AppController {
    private static AppController instance;
    private final CardLayout layout;   
    private final JPanel cardPanel;

    private final MapFactoryController mapFactoryController = MapFactoryController.getInstance();
    private final MainMenuController mainMenuController = MainMenuController.getInstance();
    private final LevelSelectMenuController levelSelectMenuController = LevelSelectMenuController.getInstance();
    private final GameController gameController = GameController.getInstance();
    private final UserSystemController userSystemController = UserSystemController.getInstance();

    private AppController(CardLayout layout, JPanel cardPanel) {
        this.layout = layout;
        this.cardPanel = cardPanel;

        this.layout.addLayoutComponent(mapFactoryController.getView(),"mapFactory");
        this.layout.addLayoutComponent(mainMenuController.getView(), "mainMenu");
        this.layout.addLayoutComponent(levelSelectMenuController.getView(), "levelSelectMenu");
        this.layout.addLayoutComponent(gameController.getView(), "gameController");
        this.layout.addLayoutComponent(userSystemController.getView(), "userSystem");
    }

    public static synchronized AppController getInstance(CardLayout layout, JPanel cardPanel) {
        if (instance == null) {
            instance = new AppController(layout,cardPanel);
        }
        return instance;
    }

    public static synchronized AppController getInstance() {
        return instance;
    }

    public void start(){
        layout.show(cardPanel, "mainMenu");
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
        layout.show(cardPanel, "gameController");
    }

    public void switchToUserSystem(){
        layout.show(cardPanel, "userSystem");
    }

    public void handleWindowClosing(){
        new ClosingDialog().setVisible(true);
    }

    public void exitProgram(){
        System.exit(0);
    }
}
