package view.animations;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**
* this panel creats a expanding circle on it to focus on something underneath.
*/
public class Focus extends JComponent {
   private final double beginRadius, radius, posX, posY;
   private final long timeMark;
   private final int width, height;

   public Focus(JComponent owner, int posx, int posy, int beginR, int endR) {
       this(owner, posx, posy, beginR, endR, 1000);
   }

   public Focus(JComponent owner, int posx, int posy, int beginR, int endR, int duration) {
       this(owner, posx, posy, beginR, endR, 1000, 30);
   }

   public Focus(JComponent owner, int posx, int posy, int beginR, int endR, int duration, int DELAY) {
       super(DELAY,duration);

       this.width = owner.getWidth();
       this.height = owner.getHeight();

       this.posX = posx;
       this.posY = posy;
       this.beginRadius = beginR;
       this.radius = endR - beginR;

       this.timeMark = System.currentTimeMillis();

       this.setBounds(0, 0, this.width, this.height);

       this.setVisible(true);
   }

   /**
    * to control the motion pattern of the component
    */
   private double getSpeed(long time) {
       return 1 - Math.pow(1 - ((double) time / super.getDuration()), 3);
   }

   @Override
   public void paintComponent(Graphics panel) {
       super.paintComponent(panel);
       this.paintFocus(panel);
   }

   private void paintFocus(Graphics panel) {
       Graphics2D g = (Graphics2D) panel.create();
       g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       // calculate the current radius
       long currentTime = System.currentTimeMillis() - this.timeMark;
       double currentR = this.beginRadius + this.radius * getSpeed(currentTime);

       // get the shape
       Shape rectangle = new Rectangle2D.Double(0, 0, this.width, this.height);
       Shape circle = new Ellipse2D.Double(posX - currentR, posY - currentR, currentR * 2, currentR * 2);
       Area focusArea = new Area(rectangle);
       focusArea.subtract(new Area(circle));

       // paint the shape
       g.setColor(Color.BLACK);
       g.draw(focusArea);
       g.fill(focusArea);

       g.dispose();
   }
}
