package controller;

import javax.swing.JPanel;

public class MapFactoryController {
    private static MapFactoryController instance;

    private final MapFactoryPanel view= new MapFactoryPanel();

    private MapFactoryController() {
        // 私有构造函数防止实例化
    }

    public JPanel getView() {
        return view;
    }

    public static synchronized MapFactoryController getInstance() {
        if (instance == null) {
            instance = new MapFactoryController();
        }
        return instance;
    }
}
