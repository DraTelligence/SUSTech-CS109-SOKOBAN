
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class InvisibleButtonTest {
    public static void main(String[] args) {
        JFrame jf=new JFrame("TEST");

        JButton bt=new JButton("");

        bt.setContentAreaFilled(false);
        bt.setBorder(null);

        bt.addActionListener(_ -> {
            new JDialog(jf,"dialog",true).setVisible(true);
        });

        jf.setBounds(0,0, 400,400);
        jf.setLocationRelativeTo(null);

        jf.setBackground(Color.BLACK);
        jf.add(bt);

        jf.setVisible(true);
    }
}
