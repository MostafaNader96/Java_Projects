import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;

public class Stringmove extends Applet{

   
    int x=0;
    int y=10;
    int z;
   
    
    
    
    
    
    public void init() {
        addKeyListener(new keypresss());
    }
    
    
    class keypresss implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            
          z=e.getExtendedKeyCode();
          switch(z)
        {
            case KeyEvent.VK_UP: y-=20;
            break;
        
            case KeyEvent.VK_DOWN: y+=20;
            break;
        
        
            case KeyEvent.VK_RIGHT: x+=20;
            break;
        
            case KeyEvent.VK_LEFT: x-=20;
            break;
        
        }
        
    repaint();
          
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    
    }
    
    
    public void paint(Graphics g) {
        g.drawString("HELLO JAVA", x, y);
    }
    
    


}
