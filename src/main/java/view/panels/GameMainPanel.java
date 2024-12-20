package view.panels;

import java.awt.AWTEvent;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_H;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_UP;
import static java.awt.event.KeyEvent.VK_W;
import static java.awt.event.KeyEvent.VK_Z;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import map.Map;
import map.MapUtilis;
import model.Direction;
import view.game.ButtonPanel;
import view.game.InformationPanel;
import view.game.MapPanel;

public class GameMainPanel extends JLayeredPane {
    static private final int WIDTH = 555;
    static private final int HEIGHT = 785;

    private int step;

    ButtonPanel buttonPanel;
    InformationPanel informationPanel;
    MapPanel mapPanel;

    private final Deque<Map> record;

    public GameMainPanel() {
        // initialize the panel
        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setOpaque(false);
        this.setLayout(null);

        record = new ArrayDeque<>();
        record.push(MapUtilis.getMap(2));

        step=0;

        // initialize components
        // MapPanel map =new MapPanel();
        // EffectPanel effectPanel = new EffectPanel();
        this.buttonPanel = new ButtonPanel();
        this.informationPanel = new InformationPanel();
        this.mapPanel = new MapPanel(record.peek());

        // add components
        // this.add(effectPanel, DEFAULT_LAYER);
        this.add(buttonPanel, PALETTE_LAYER);
        this.add(informationPanel, PALETTE_LAYER);
        this.add(mapPanel, DEFAULT_LAYER);

        // add ActionListeners
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (var button:buttonPanel.getButtons()){
                    if (button.getButtonArea().contains(e.getPoint())) {
                        switch (button.getCommand()) {
                            case "DOWN" -> tryMove(Direction.DOWN);
                            case "UP" -> tryMove(Direction.UP);
                            case "LEFT" -> tryMove(Direction.LEFT);
                            case "RIGHT" -> tryMove(Direction.RIGHT);
                            case "HINT" -> {
                                System.out.print(record.pop());
                            }
                            case "REWIND" -> doRewind();
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                for (var button : buttonPanel.getButtons()) {
                    if (button.getButtonArea().contains(e.getPoint())) {
                        button.setPressed();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (var button : buttonPanel.getButtons()) {
                    if (button.getButtonArea().contains(e.getPoint())) {
                        button.setEntered();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                for (var button : buttonPanel.getButtons()) {
                    if (button.getButtonArea().contains(e.getPoint())) {
                        button.setEntered();
                    } else {
                        button.setNormal();
                    }
                }
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                for (var button : buttonPanel.getButtons()) {
                    switch (button.getCommand()) {
                        case "DOWN" -> {
                            if (e.getKeyCode() == VK_DOWN || e.getKeyCode() == VK_S) {
                                button.setPressed();
                                tryMove(Direction.DOWN);
                            }
                        }
                        case "UP" -> {
                            if (e.getKeyCode() == VK_UP || e.getKeyCode() == VK_W) {
                                button.setPressed();
                                tryMove(Direction.UP);
                            }
                        }
                        case "LEFT" -> {
                            if (e.getKeyCode() == VK_LEFT || e.getKeyCode() == VK_A) {
                                button.setPressed();
                                tryMove(Direction.LEFT);
                            }
                        }
                        case "RIGHT" -> {
                            if (e.getKeyCode() == VK_RIGHT || e.getKeyCode() == VK_D) {
                                button.setPressed();
                                tryMove(Direction.RIGHT);
                            }
                        }
                        case "HINT" -> {
                            if (e.isControlDown() && e.getKeyCode() == VK_H) {
                                button.setPressed();
                            }
                        }
                        case "REWIND" -> {
                            if (e.isControlDown() && e.getKeyCode() == VK_Z) {
                                button.setPressed();
                                doRewind();
                            }
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                for (var button : buttonPanel.getButtons()) {
                    switch (button.getCommand()) {
                        case "DOWN" -> {
                            if (e.getKeyCode() == VK_DOWN || e.getKeyCode() == VK_S) {
                                button.setNormal();
                            }
                        }
                        case "UP" -> {
                            if (e.getKeyCode() == VK_UP || e.getKeyCode() == VK_W) {
                                button.setNormal();
                            }
                        }
                        case "LEFT" -> {
                            if (e.getKeyCode() == VK_LEFT || e.getKeyCode() == VK_A) {
                                button.setNormal();
                            }
                        }
                        case "RIGHT" -> {
                            if (e.getKeyCode() == VK_RIGHT || e.getKeyCode() == VK_F) {
                                button.setNormal();
                            }
                        }
                        case "HINT" -> {
                            if (e.isControlDown() && e.getKeyCode() == VK_H) {
                                button.setNormal();
                            }
                        }
                        case "REWIND" -> {
                            if (e.isControlDown() && e.getKeyCode() == VK_Z) {
                                button.setNormal();
                            }
                        }
                    }
                }
            }

        });

        mapPanel.setBounds(0, 0, 555, 755);
        this.enableEvents(AWTEvent.KEY_EVENT_MASK);
        this.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        this.enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK);
        this.setFocusable(true);

        this.informationPanel.continueTiming();

        this.setVisible(true);
    }

    private void tryMove(Direction dir) {
        if (MapUtilis.checkMove(record.peek(), dir)) {
            doMove(dir);
        } else {
            doMoveFail(dir);
        }
    }

    private void doMove(Direction dir) {
        //update step
        step++;
        this.informationPanel.updateStep(step);

        record.push(MapUtilis.doMove(record.peek(), dir));
        mapPanel.doMove(dir);

        System.out.println(record.peek());
        
        if(MapUtilis.checkVictory(record.peek())){
            showVictory();
        }

        this.mapPanel.repaint();
    }

    private void doRewind() {
        if (record.size()==1) {
            System.out.println("this is the initial state!");
        } else {
            this.step--;
            this.informationPanel.updateStep(this.step);

            record.pop();
            mapPanel.doRewind();
        }
    }

    private void showVictory(){
        System.out.println(",,,");
    }

    private void doMoveFail(Direction dir) {
        mapPanel.doMoveFail(dir);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();

        jf.setBounds(0, 0, 555, 785);
        jf.setLocationRelativeTo(null);

        CardLayout layout = new CardLayout();
        jf.setLayout(layout);

        jf.add(new GameMainPanel(new CardLayout()));

        jf.setVisible(true);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}