import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import view.myComponents.Focus;

public class Test {
    public static void main(String[] args) throws Exception {
        Timer tm=new Timer(1,null);
        
        int x = 2;

        JFrame jf = new JFrame();

        CardLayout layout = new CardLayout();

        // jf.setLayout(layout);

        jf.setBounds(0, 0, 600, 300);
        jf.setLocationRelativeTo(null);

        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);

        JLayeredPane container = new JLayeredPane();
        container.setBounds(0, 0, 600, 300);
        container.setVisible(true);

        JButton bt = new JButton("click here to gooooo");
        bt.setBounds(0, 0, 80, 20);
        bt.setVisible(true);
        bt.addActionListener((ActionEvent e) -> {

            System.out.println("here we go!");
            container.add(new Focus(tm,container, 300, 150, 0, 300, 1000), JLayeredPane.DEFAULT_LAYER, x);
            tm.start();

            Timer auto=new Timer(1000,(var v)->{
                tm.stop();
            });

            auto.setRepeats(false);
        });

        // layout.addLayoutComponent(container, "main");
        // layout.show(jf, "main");
        jf.add(container);
        container.add(bt, JLayeredPane.DEFAULT_LAYER, 1);
        bt.setVisible(true);

    }
}
