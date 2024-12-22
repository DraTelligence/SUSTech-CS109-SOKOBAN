package view.panels;

import java.awt.AWTEvent;
import java.awt.event.KeyListener;

import javax.swing.JLayeredPane;

import model.game.Direction;
import model.game.Map;
import view.game.ButtonPanel;
import view.game.InformationPanel;
import view.game.MapPanel;

public class GameMainPanel extends JLayeredPane {
    private int step;

    ButtonPanel buttonPanel;
    InformationPanel informationPanel;
    MapPanel mapPanel;

    public GameMainPanel() {
        // initialize the panel
        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setOpaque(false);
        this.setLayout(null);

        step=0;

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                buttonPanel.handleKeyEvent(e);
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                buttonPanel.handleKeyEvent(e);
            }
        });
        this.enableEvents(AWTEvent.KEY_EVENT_MASK);
        this.setFocusable(true);

        // initialize components
        // MapPanel map =new MapPanel();
        this.buttonPanel = new ButtonPanel();
        this.informationPanel = new InformationPanel();
        this.mapPanel = new MapPanel();

        // add components
        // this.add(effectPanel, DEFAULT_LAYER);
        this.add(buttonPanel, PALETTE_LAYER);
        this.add(informationPanel, PALETTE_LAYER);
        this.add(mapPanel, DEFAULT_LAYER);

        mapPanel.setBounds(0, 0, 555, 755);
        this.enableEvents(AWTEvent.KEY_EVENT_MASK);
        this.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        this.enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK);
        this.setFocusable(true);

        this.informationPanel.continueTiming();

        this.setVisible(true);
    }

    public void initPanel(Map map){
        informationPanel.initPanel();
        mapPanel.initPanel(map);
    }

    public void doMove(Direction dir) {
        //update step
        step++;
        this.informationPanel.updateStep(step);

        mapPanel.doMove(dir);

        this.mapPanel.repaint();
    }

    public void doRewind() {
        step--;
        this.informationPanel.updateStep(step);

        mapPanel.doRewind();

        this.mapPanel.repaint();
    }

    public void showVictory(){
        System.out.println(",,,");
    }

    public void doMoveFail(Direction dir) {
        mapPanel.doMoveFail(dir);
    }

    public void showLoading(){
        System.out.println("loading...");

        this.buttonPanel.setEnabled(false);
        this.informationPanel.pause();
    }

    public void showLoadingDone(){
        System.out.println("done...");

        this.buttonPanel.setEnabled(true);
        this.informationPanel.continueTiming();
    }
}