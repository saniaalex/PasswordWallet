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
 JButton submit,cancel;
 JTextField title,usname,pwd,cpwd,url;
 JLabel ltitle,lusname,lpwd,lcpwd,lurl;
 ltitle = new JLabel("TITLE :");
 ltitle.setBounds(70,185,100,30);
 lusname = new JLabel("User ID :");
 lusname.setBounds(70,205,100,30);
 lpwd = new JLabel ("Password :");
 lpwd.setBounds(70,225,120,30);
 lcpwd = new JLabel ("Confirm Pwd :");
 lcpwd.setBounds(70,245,160,30);
 lurl = new JLabel ("URL :");
 lurl.setBounds(70,265,100,30);
 F1.add(ltitle);
 F1.add(lusname);
 F1.add(lpwd);
 F1.add(lcpwd);
 F1.add(lurl);
 title=new JTextField(200);
 usname= new JTextField(100);
 pwd= new JTextField(100);
 cpwd = new JTextField(100);
 url = new JTextField(100);
 title.setBounds(155,190,150,20);
 usname.setBounds(155,210,150,20);
 pwd.setBounds(155,230,150,20);
 cpwd.setBounds(155,250,150,20);
 url.setBounds(155,270,150,20);
 F1.add(title);
 F1.add(usname);
 F1.add(pwd);
 F1.add(cpwd);
 F1.add(url);
 submit = new JButton ("SUBMIT");
 submit.setBounds(100,320,80,25);
 cancel = new JButton ("CANCEL");
 cancel.setBounds(190,320,80,25);
 F1.add(submit);
 F1.add(cancel);
 F1.setVisible(true);
 F1.repaint();
 F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  }
  
