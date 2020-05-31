
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;


public class marquee extends Applet implements Runnable{

   
    Thread t;
    int x=0;
    int y=10;
    public void init() {
    t=new Thread(this);
    t.start();
    }
    
    public void paint(Graphics g) {
        g.drawString("HELLO JAVA", x, y);
    }
    
    public void run()
    {
    while(true)
    {
        if(x>=getWidth())
        {x=0; y+=10;}
        else
        x+=5;
    repaint();
    try
    {
    Thread.sleep(20);
    }
    catch(Exception e)
    {
    System.out.print("ERROR!");
    }
    }
    }


}
