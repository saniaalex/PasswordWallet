import javax.swing.*;
import java.awt.*;
public class FB
{
 public static void main(String[] args)
 {
 JFrame f1= new JFrame("Password Wallet");
 f1.setSize(400,500);
 f1.setVisible(true);
 f1.setLayout(null);
  JLabel us,pw;
  JButton li,ca,help;
  JTextField ust;
  JPasswordField pwt;
  li = new JButton("Login");
        li.setBounds(120,260,100,25);
        ca = new JButton("Sign Up");
        ca.setBounds(250,260,100,25);
        help = new JButton("HELP");
        help.setBounds(180,400,100,25);
		f1.add(help);
        f1.add(li);
        f1.add(ca);
		ust = new JTextField(20);
        ust.setBounds(200,150,150,30);
        pwt = new JPasswordField();
        pwt.setBounds(200,190,150,30);
        us = new JLabel("User Name:");
        us.setBounds(120,150,100,30);
        pw = new JLabel("Password:");
        pw.setBounds(120,190,100,30);
        f1.add(ust);
        f1.add(pwt);
        f1.add(us);
        f1.add(pw);
        f1.setVisible(true); 
 f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 }
 }