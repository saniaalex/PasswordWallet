import javax.swing.*;
import java.awt.*;
public class ca
{
 public static void main(String[] args)
 {
 JFrame f1= new JFrame("Password Wallet");
 f1.setSize(400,500);
 f1.setVisible(true);
 f1.setLayout(null);
	JLabel uid,lipwd,cnpwd,secqn,secans;
    JButton submit,cancel;
    JTextField caust;
    JPasswordField capwd,cacpwd;
    submit = new JButton("SUBMIT");
            submit.setBounds(120,350,80,25);
            cancel = new JButton("CANCEL");
            cancel.setBounds(250,350,80,25);
            uid = new JLabel("Enter UserID :");
            uid.setBounds(50,110,100,30);
            lipwd = new JLabel("Enter Login Pwd :");
            lipwd.setBounds(50,150,100,30);
            cnpwd = new JLabel("Confirm Login Pwd :");
            cnpwd.setBounds(50,190,150,30);
            secqn = new JLabel("Choose Security Qn. :");
            secqn.setBounds(50,230,150,30);
            secans = new JLabel("Enter Security Answer :");
            secans.setBounds(50,270,150,30);
f1.add(submit);
f1.add(cancel);
f1.add(uid);
f1.add(lipwd);
f1.add(cnpwd);
f1.add(secqn);
f1.add(secans);
f1.setVisible(true); 
JTextField ust = new JTextField(20);
ust.setBounds(200,115,100,20);
JPasswordField pw = new JPasswordField();
pw.setBounds(200,155,100,20);
JPasswordField cpw = new JPasswordField();
cpw.setBounds(200,195,100,20);
JTextField ans = new JTextField(100);
ans.setBounds(200,275,100,20);
JComboBox box = new JComboBox();
box.addItem("What is your first pet name?");
box.addItem("What is the number of first vehicle?");
box.addItem("What is your favourite colour?");
box.setBounds(200,235,200,30);
box.addItemListener(this);
f1.add(box);
f1.add(ust);
f1.add(pw);
f1.add(cpw);
f1.add(ans);
f1.repaint();
f1.setVisible(true);
 f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}