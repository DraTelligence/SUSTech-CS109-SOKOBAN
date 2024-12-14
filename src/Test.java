import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import view.animations.Focus;

public class Test {
    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> {
            JFrame jf = new JFrame();

            CardLayout layout = new CardLayout();

            jf.setBounds(0, 0, 900, 600);
            jf.setLocationRelativeTo(null);
            jf.setLayout(layout);

            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();

            Dimension size = new Dimension(500, 400);
            panel.setBackground(Color.BLUE);
            panel.setSize(size);
            panel.setLocation(200, 80);
            panel.setVisible(true);
            panel2.setBackground(Color.GREEN);
            panel2.setSize(size);
            panel2.setLocation(150, 60);
            panel2.setVisible(true);

            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);

            JLayeredPane container = new JLayeredPane();
            container.setBounds(0, 0, 1200, 750);
            container.setVisible(true);

            JButton bt = new JButton("click here to gooooo");
            bt.setBounds(0, 0, 80, 20);
            bt.setVisible(true);
            bt.addActionListener((ActionEvent e) -> {

                System.out.println("here we go!");

                Focus f = new Focus(container, 300, 150, 50, 0, 1000);

                container.add(f, JLayeredPane.DEFAULT_LAYER, 0);

                f.start();

                bt.setEnabled(false);

                Timer timer = new Timer(1000, (var noUse) -> {
                    bt.setEnabled(true);
                    System.out.println("bt enabled");
                });

                timer.start();
                timer.setRepeats(false);

                System.out.println("------------");
            });
            

            container.add(bt, JLayeredPane.DEFAULT_LAYER, 1);
            container.add(panel2, JLayeredPane.DEFAULT_LAYER, 3);
            container.add(panel, JLayeredPane.DEFAULT_LAYER, 4);
            
            bt.setVisible(true);

            jf.setLayout(layout);
            jf.add(container,"container");
            layout.show(jf.getContentPane(),"container");
        });
    }
}
