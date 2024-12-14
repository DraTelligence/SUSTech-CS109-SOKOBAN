//package view.panels;
//
//import java.awt.CardLayout;
//import java.awt.Dimension;
//import javax.swing.JLayeredPane;
//import view.game.*;
//
//public class GameMainPanel extends JLayeredPane {
//    private final int WIDTH=555;
//    private final int HEIGHT=785;
//    private final Integer MAP_LAYER = 1;
//    private final Integer EFFECT_LAYER = 2;
//    private final Integer GUI_LAYER = 3;
//
//
//    public GameMainPanel(CardLayout ownerLayout) {
//        // initialize the panel
//        this.setSize(new Dimension(WIDTH,HEIGHT));
//
//        // initialize components
//        // MapPanel map =new MapPanel();
//        EffectPanel effectPanel=new EffectPanel();
//        ButtonPanel buttonPanel=new ButtonPanel();
//        InformationPanel informationPanel = new InformationPanel();
//
//        // add components
//        // this.add(map, MAP_LAYER);
//        this.add(effectPanel, EFFECT_LAYER);
//        this.add(buttonPanel, GUI_LAYER);
//        this.add(informationPanel, GUI_LAYER);
//
//        this.setVisible(true);
//    }
//}