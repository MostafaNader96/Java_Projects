import java.applet.*;
import javax.swing.*;
import java.awt.*;

public class draw extends Applet {


    public void init() {
        setSize(1000, 1000); 
  
        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black); 
  
      
        g.drawOval(475, 103, 250, 70);
        g.setColor(Color.YELLOW);
        g.fillOval(475, 103, 250, 70);
        g.fillOval(685, 217, 35, 70);
        g.fillOval(485, 217, 35, 70);
        g.fillOval(572, 192, 64, 120);
        g.setColor(Color.BLACK);
        g.drawOval(685, 217, 35, 70);
        g.drawOval(485, 217, 35, 70);
        g.drawOval(572, 192, 64, 120);

          g.drawArc(423, 310, 364, 27, 0, -180);
        
      g.drawLine(475,138 , 423, 323);
      g.drawLine(725, 141, 787, 322);
      g.drawLine(577,338 , 552, 412);
      g.drawLine(611,338 , 626, 412);
      g.drawLine(502,413 , 502, 433);
      g.drawLine(682,413 , 683, 433);
      g.drawLine(502,412 , 682, 413);
      g.drawLine(502,434 , 682, 434);
    }
}
