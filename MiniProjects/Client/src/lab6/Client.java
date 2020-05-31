
package lab6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class SampleUI extends JFrame {

    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    public static void main(String[] args) {
        SampleUI ui = new SampleUI();
        ui.setSize(400, 500);
        ui.setVisible(true);
        new SampleUI();
    }

    public SampleUI() {
              try
{
mySocket = new Socket("127.0.0.1", 5005);
dis = new DataInputStream(mySocket.getInputStream ());
ps = new PrintStream(mySocket.getOutputStream ());




}
catch(IOException ex)
{
ex.printStackTrace();
}

        this.setLayout(new FlowLayout());
        JTextArea ta = new JTextArea(5, 20);
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setViewportView(ta);
        JTextField tf = new JTextField(30);
        JButton okButton = new JButton("Send");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                
                    
                  String s=tf.getText();
                  ps.println(s);
                  tf.setText(" ");
                
                
                   
            }
        });
        add(scroll);
        add(tf);
        add(okButton);
        //---------------------------------------------------------//
//try
//{
//ps.close();
//dis.close();
//mySocket.close();
//}
//catch(Exception ex)
//{
//ex.printStackTrace();
//}
new Thread(new Runnable() {
    @Override
    public void run() {
while(true)
{
String replyMsg;
    try {
        replyMsg = dis.readLine();
        ta.append(replyMsg);

    } catch (IOException ex) {
        Logger.getLogger(SampleUI.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    }
}).start();

        
    }
}


/*public class Client
{
Socket mySocket;
DataInputStream dis ;
PrintStream ps;
public static void main(String[] args)
{
    SampleUI ui = new SampleUI();
        ui.setSize(400, 500);
        ui.setVisible(true);
new Client();
}
public Client()
{
try
{
mySocket = new Socket("127.0.0.1", 5005);
dis = new DataInputStream(mySocket.getInputStream ());
ps = new PrintStream(mySocket.getOutputStream ());
ps.println("Test Test");
String replyMsg = dis.readLine();
System.out.println(replyMsg);


}
catch(IOException ex)
{
ex.printStackTrace();
}
try
{
ps.close();
dis.close();
mySocket.close();
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
}*/

