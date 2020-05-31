
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;


public class Bounce extends Applet implements Runnable{

   
    Thread t;
    int flag=0;
    int x=0;
    int y=317;
    public void init() {
    t=new Thread(this);
    t.start();
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.blue);
       // g.drawOval(x, y, 30, 30);
        g.fillOval(x, y, 30, 30);
    }
    
    public void run()
    {
    while(true)
    {
        
        
        if(x>=getWidth() || flag==2)
        {x-=4; y+=4;
        if(y>=getHeight() )
        flag=3;
        else if(x<=0)
            flag=1;}
        else if(x<=0 || flag==0)
            {x+=4; y-=4;
        if(y<=0 )
            flag=1;
        else if(x>getWidth() )
            flag=3;
            }
        else if(y<=0 || flag==1)
            {x+=4; y+=4;
            if(x>=getWidth() )
            flag=2;
            else if(y>=getHeight() )
            flag=0;
            }
        else if(y>=getHeight() || flag==3)
            {x-=4; y-=4;
            if(x<=0 )
            flag=0;
            else if(y<=0)
                flag=2;}
        
    repaint();
    try
    {
    Thread.sleep(1);
    }
    catch(Exception e)
    {
    System.out.print("ERROR!");
    }
    }
    }


}
