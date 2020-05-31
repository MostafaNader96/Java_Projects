import java.applet.*;
import java.awt.*;
import java.awt.event.*;




public class Buttonapp extends Applet {

    int x;
    Button b; 
    Button c;
    public void init() {
        b=new Button("increment +");
        b.addActionListener(new MyButtonListener());
        add(b);
        c=new Button("decrement -");
        c.addActionListener(new MyButton1Listener());
        add(c);
    }

    public void paint(Graphics g) {
    
    g.drawString("x=" + x , 100, 100);
    
    }
    
    class MyButtonListener implements ActionListener
    {
    public void actionPerformed(ActionEvent ev)
    {
        if(x<10)
    x++;
    repaint();
    }
    }
    
    class MyButton1Listener implements ActionListener
    {
    public void actionPerformed(ActionEvent ev)
    {
        if(x>0)
    x--;
    repaint();
    }
    }

    
      
}
