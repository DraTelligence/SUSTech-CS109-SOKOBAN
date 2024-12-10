
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InvisibleButtonTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame("TEST");
        jf.setLayout(null);

        JButton bt = new JButton("");
        bt.setBounds(400, 400, 200, 200);
        JPanel jp = new JPanel();
        jp.setBackground(Color.CYAN);
        jp.setBounds(400, 400, 200, 200);

        bt.setContentAreaFilled(false);
        bt.setBorder(null);
        bt.setVisible(true);

        bt.addActionListener(_ -> {
            new JDialog(jf, "dialog", true).setVisible(true);
        });

        jf.setBounds(0, 0, 1000, 1000);
        jf.setLocationRelativeTo(null);

        jf.setBackground(Color.BLACK);
        // jf.add(bt);
        jf.add(jp);
        jf.add(bt);

        jf.setVisible(true);
    }
}
