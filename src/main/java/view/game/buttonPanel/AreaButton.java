package view.game.buttonPanel;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;

import javax.swing.JButton;

import controller.GameController;
import view.game.buttonPanel.buttonState.ButtonState;

public class AreaButton extends JButton{
    private final String command;
    private Area buttonArea;
    private ButtonState buttonState;
    private int keyModifier;
    private int keyCode;

    protected AreaButton(String command, ButtonState buttonState){
        this.command = command;
        this.setText(command);
        this.addMouseListener(new mouseAdapter());

        this.setBounds(0,0,555,785);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        this.buttonState = buttonState;
    }

    protected final void setKeyModifier(int keyModifier){
        this.keyModifier = keyModifier;
    }

    protected final void setKeyCode(int keyCode){
        this.keyCode = keyCode;
    }

    private class mouseAdapter extends java.awt.event.MouseAdapter{
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e){
            buttonState = buttonState.getEnteredState();
            repaint();
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e){
            buttonState = buttonState.getNormalState();
            repaint();
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e){
            buttonState = buttonState.getPressedState();
            GameController.getInstance().handleCommand(command);
            repaint();
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e){
            buttonState = buttonState.getEnteredState();
            repaint();
        }
    }

    public void handleKeyEvent(KeyEvent e) {
        if(e.getKeyCode() == keyCode && e.getModifiersEx() == keyModifier){
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                buttonState = buttonState.getPressedState();
                GameController.getInstance().handleCommand(command);
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                buttonState = buttonState.getNormalState();
            }

            repaint();
        }
    }

    public final void setButtonArea(Area buttonArea){
        this.buttonArea = buttonArea;
    }

    @Override
    public final void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // paint the body of the button
        g2d.setColor(buttonState.getBUTTON_COLOR());
        g2d.fill(buttonArea);

        // paint the text of the button
        g2d.setColor(buttonState.getTEXT_COLOR());
        String text = getText();

        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2 - fm.getDescent();
        g2d.drawString(text, x, y);

        g2d.dispose();
    }

    @Override
    public final boolean contains(Point p){
        return buttonArea.contains(p);
    }
}