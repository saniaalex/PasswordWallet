import javax.swing.*;
import java.awt.*;
public class FB1
{
 public static void main(String[] args)
 {
 JFrame F1= new JFrame("Password Wallet");
 F1.setSize(400,500);
 F1.setVisible(true);
 F1.setLayout(null);
 JButton home,mng,view,lo,clp,help;
 JTextArea msg;
 home = new JButton("HOME");
 home.setBounds(0,140,100,25);
 mng = new JButton("Manage");
 mng.setBounds(100,140,100,25);
 view= new JButton("View Pwd");
 view.setBounds(200,140,100,25);
 lo= new JButton("Log Out");
 lo.setBounds(300,140,90,25);
 help = new JButton("HELP");
 help.setBounds(180,425,100,25);
 clp = new JButton("Change Login Pwd");
 clp.setBounds(0,425,100,25);
 msg = new JTextArea();
 msg.setBounds(40,200,200,150);
 msg.setText("Welcome <username>,\nThis is your \n personalized account to \nstore pwd's.");
 F1.add(home);
 F1.add(mng);
 F1.add(view);
 F1.add(lo);
 F1.add(clp);
 F1.add(help);
 F1.add(msg);
 F1.setVisible(true);
 F1.repaint();
 F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  }
  
