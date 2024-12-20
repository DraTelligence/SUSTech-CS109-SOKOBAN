import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Test3 {
    public static void main(String[] args) {
        JFrame f=new JFrame("shadow test");

        f.setSize(800,600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLayeredPane mainPane= new JLayeredPane();
        f.add(mainPane);

        Dimension size=new Dimension(800,600);
        JPanel p1= new ShadowPanel(size);

        JPanel p2 =new JPanel();
        p2.setBounds(50,50,700,500);
        p2.setBackground(Color.RED);

        //mainPane.add(p2,0);
        mainPane.add(p1,1);
        

        f.setVisible(true);
    }

    static private class ShadowPanel extends JPanel{
        ShadowPanel(Dimension size){
            this.setSize(size);


        }  

        @Override 
        public void paintComponent(Graphics page){
            Graphics2D g2d=(Graphics2D) page.create();
            final int width=600,height=400;
            final int arcWidth=60, arcHeight=40;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(4.0f));

            for(int i=0;i<10;i++){
                g2d.setColor(new Color(0,0,0,50-i*5));
                g2d.drawRoundRect(100-i,100-i,width+i*2,height+i*2,arcWidth+i,arcHeight+i);
            }

            g2d.setStroke(new BasicStroke(0.0f));
            g2d.setColor(Color.BLUE);
            g2d.drawRoundRect(100, 100, width, height, arcWidth,arcHeight);
            g2d.fillRoundRect(100, 100, width, height, arcWidth,arcHeight);
        }
    }
}
