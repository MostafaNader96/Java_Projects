
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChatServer
{
ServerSocket serverSocket;
public ChatServer()
{
    try {
        serverSocket = new ServerSocket(5005);
    } catch (IOException ex) {
        Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
    }
while(true)
{
Socket s;
        try {
            s = serverSocket.accept();
            new ChatHandler(s);
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}
public static void main(String[] args)
{
new ChatServer();
}
}



class ChatHandler extends Thread implements Runnable
{
DataInputStream dis;
PrintStream ps;
static Vector<ChatHandler> clientsVector =
new Vector<ChatHandler>();

public ChatHandler(Socket cs)
{
    try {
        dis = new DataInputStream(cs.getInputStream());
    } catch (IOException ex) {
        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        ps = new PrintStream(cs.getOutputStream());
    } catch (IOException ex) {
        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
clientsVector.add(this);
start();
}



public void run()
{
while(true)
{
String str;
    try {
        str = dis.readLine();
        sendMessageToAll(str);
    } catch (IOException ex) {
        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
    }


}
}
void sendMessageToAll(String msg)
{
for(ChatHandler ch : clientsVector)
{
ch.ps.println(msg);
}
}
}

