package view.game.informationPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

@SuppressWarnings("FieldMayBeFinal")
public class TimePanel extends JLayeredPane {
    private long time;
    final private Timer task;

    private JLabel timeText;
    private JComponent timePanelBody;

    @SuppressWarnings("unused")
    public TimePanel() {
        this.setBounds(280, 30, 170, 110);

        this.time = 0;

        this.timeText = new JLabel();
        this.timePanelBody = new TimePanelBody();

        timeText.setBounds(6, 5, 170, 70);
        timeText.setFont(new Font("Courier", Font.BOLD, 50));
        timeText.setText("00:00");

        this.add(timeText, 0);
        this.add(timePanelBody, 1);

        this.task = new Timer(1000, (var noUse) -> {
            this.time += 1000;
            this.timeText.setText(this.getTime());
            this.repaint();
        });
        task.setRepeats(true);
    }

    public void init(){
        this.setBounds(280, 30, 170, 110);
    }

    private class TimePanelBody extends JComponent {
        public TimePanelBody() {
            this.setBounds(0, 0, 170, 110);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // paint the body
            g2d.setColor(new Color(246, 234, 234));
            g2d.fillRoundRect(0, 0, 140, 80, 30, 30);

            g2d.dispose();
        }
    }

    private String getTime() {
        return String.format("%02d:%02d", (this.time / 60000), (this.time / 1000) % 60);
    }

    public void pauseTiming() {
        task.stop();
    }

    public void continueTiming() {
        task.start();
    }

    public void reset() {
        this.time = -1000;
        this.repaint();
    }
}
