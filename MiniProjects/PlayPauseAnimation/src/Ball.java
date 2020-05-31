
import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Ball extends Applet implements Runnable{

    Button b; 
    Button c;
    Thread t;
    int flag=0;
    volatile int flagg;
    int x=0;
    int y=317;
    public void init() {
        b=new Button("Start");
  
        b.addActionListener(new MyButtonListener());
        add(b);
        c=new Button("Stop");
        c.addActionListener(new MyButton1Listener());
        add(c);
    t=new Thread(this);
    t.start();
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, 30, 30);
    }
    
    
    class MyButtonListener implements ActionListener
    {
    public void actionPerformed(ActionEvent ev)
    {
        flagg=1;
    }
    }
    
    class MyButton1Listener implements ActionListener
    {
    public void actionPerformed(ActionEvent ev)
    {
       flagg=0;
    }
    }
    
    
    
    public void run()
    {
        
    while(true)
    {
        if(flagg==1)
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



}
