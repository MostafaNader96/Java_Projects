import java.applet.*;
import java.awt.*;
        
public class font extends Applet {

    
    public void init() {

    }
    
    public void paint(Graphics g) {

        String s[];
        s=Toolkit.getDefaultToolkit().getFontList();
        int i=10;
        for(String S:s)
        {
        Font f= new Font(S,10,15);
        g.setFont(f);
        g.drawString(S, 10, i=i+20);
        
        
        }
    }
    

    // TODO overwrite start(), stop() and destroy() methods
}
