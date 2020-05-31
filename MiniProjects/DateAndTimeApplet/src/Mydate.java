import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class Mydate extends Applet implements Runnable{

    Thread t;
    
    public void init() {
    t=new Thread(this);
    t.start();
    }
    
    public void paint(Graphics g) {
        Date d=new Date();
        g.drawString(d.toString(), 100, 100);  
    }
    
    public void run()
    {
    while(true)
    {
    repaint();
    try
    {
    Thread.sleep(1000);
    }
    catch(Exception e)
    {
    System.out.print("ERROR!");
    }
    }
    }


}
