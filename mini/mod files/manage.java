import javax.swing.*;
import java.awt.*;
public class manage
{
public static void main(String[] args)
{
JFrame f1= new JFrame("Password Wallet");
 f1.setSize(400,500);
 f1.setVisible(true);
 f1.setLayout(null);
 JLabel uname,pwd,cnfpwd,webadd;
 JButton sub,can;
 CheckboxGroup cbg;
Checkbox addpass,modfy,del;

 	cbg = new CheckboxGroup();
	
	addpass = new Checkbox("Add Password",cbg,false);
	modfy = new Checkbox("Modify Password",cbg,false);
	del = new Checkbox("Delete password",cbg,false);
	add(addpass);
	add(modfy);
	add(del);
 sub = new JButton("SUBMIT");
            sub.setBounds(120,350,80,25);
            can = new JButton("CANCEL");
            can.setBounds(250,350,80,25);
            uname = new JLabel("UserName :");
            uname.setBounds(50,210,100,30);
            pwd = new JLabel("Password :");
            pwd.setBounds(50,250,100,30);
            cnfpwd = new JLabel("Confirm Password :");
            cnfpwd.setBounds(50,290,150,30);
            webadd = new JLabel("Web Address");
            webadd.setBounds(50,330,150,30);
			
f1.add(sub);
f1.add(can);
f1.add(uname);
f1.add(pwd);
f1.add(cnfpwd);
f1.add(webadd);
f1.setVisible(true);
JTextField ust = new JTextField(20);
ust.setBounds(200,215,100,20);
JPasswordField pw = new JPasswordField();
pw.setBounds(200,255,100,20);
JPasswordField cpw = new JPasswordField();
cpw.setBounds(200,295,100,20);
JTextField webad = new JTextField(20);
webad.setBounds(200,335,100,20);
f1.add(ust);
f1.add(pw);
f1.add(cpw);
f1.add(webad);
f1.repaint();
f1.setVisible(true);
f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
            