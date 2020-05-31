import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class DrawLine extends Applet {

    //int x1,y1,x2,y2;
    int []x1;
    int []y1;
    int []x2;
    int []y2;
    int i=0;
    int flag=1;
    
    
    public void init() {
        x1= new int[20];
        y1= new int[20];
        x2= new int[20];
        y2= new int[20];
        
        
        addMouseListener(new mousee());
        addMouseMotionListener(new motio());
    }
    
    
    class mousee implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
               
        }

        
         
        
        @Override
        public void mousePressed(MouseEvent e) {
            if(flag==1)
            {
               x1[i]=e.getX();
               y1[i]=e.getY();       
            }
            
            }

       @Override
        public void mouseReleased(MouseEvent e) {
            if(i<=18)
            {
            i++;
            flag=1;
            }
            else
            {
            flag=0;
            }
                
                
               
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
  
    }
    
    class motio implements MouseMotionListener 
            {

        @Override
        public void mouseDragged(MouseEvent e) {
if(flag==1)
{
               x2[i]=e.getX();
               y2[i]=e.getY();
               repaint();
} 
}

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    
    }
    
    
    public void paint(Graphics g) {
        
        
        if(flag==0)
        {
        for(int j=0;j<20;j++)
        {
        g.drawLine(x1[j], y1[j], x2[j], y2[j]);
        }
        g.drawString("EXCEEDED!!", 10, 10);
        }
        else
        {
        for(int j=0;j<20;j++)
        {
        g.drawLine(x1[j], y1[j], x2[j], y2[j]);
        }
        }
    }
    
    
    


}
