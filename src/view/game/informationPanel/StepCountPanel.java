package view.game.informationPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JLabel;

@SuppressWarnings("FieldMayBeFinal")
public class StepCountPanel extends JComponent {

    private JLabel stepText;
    private JComponent stepCountPanelBody;

    public StepCountPanel() {
        this.setBounds(120, 30, 170, 110);

        this.stepText = new JLabel();
        this.stepCountPanelBody = new StepCountPanelBody();

        stepText.setBounds(20, 5, 170, 70);
        stepText.setFont(new Font("Courier", Font.BOLD, 60));
        stepText.setText("000");

        this.add(stepText, 0);
        this.add(stepCountPanelBody, 1);
    }

    public void init(){
        this.setBounds(120, 30, 170, 110);
    }

    private class StepCountPanelBody extends JComponent {
        public StepCountPanelBody() {
            this.setBounds(0, 0, 170, 110);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(new Color(246, 234, 234));
            g2d.fillRoundRect(0, 0, 140, 80, 30, 30);

            g2d.dispose();
        }
    }

    /**
     * set step=step+1, then update the panel
     */
    public void updateStep(int step) {
        this.stepText.setText(String.format("%03d", step));
        repaint();
    }

    /**
     * set step=0, then update the panel
     */
    public void reset() {
        this.stepText.setText(String.format("%03d", 0));
        repaint();
    }
}
