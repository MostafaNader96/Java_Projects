
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SampleUI extends JFrame {

    public SampleUI() {
        this.setLayout(new FlowLayout());
        JTextArea ta = new JTextArea(5, 150);
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setViewportView(ta);
        JTextField tf = new JTextField(30);
        JButton okButton = new JButton("Send");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
// ta.append(tf.getText()+"\n");
            }
        });
        add(scroll);
        add(tf);
        add(okButton);
    }

    public static void main(String args[]) {
        SampleUI ui = new SampleUI();
        ui.setSize(400, 500);
        ui.setVisible(true);
    }
}
