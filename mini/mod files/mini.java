//Frame FB
//Frame FB1
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class mini extends JFrame
{
	private JFrame F1;
	JLabel us,pw;
	JButton li,ca,help;
	JTextField ust;
	JPasswordField pwt;
	JButton home,mng,view,lo,clp;
	JTextArea msg;
	private JLabel statusLabel;
        private JLabel headerlabel;
	public mini()
	{
		prepareGUI();//initial login page
	}
	public static void main(String[] args)
	{
		mini m = new mini();
	}
	private void prepareGUI()//This is for the main login frame
	{
	
		F1 = new JFrame("Password Wallet");
		F1.setSize(400,500);
		F1.setVisible(true);
		F1.setLayout(null);
		statusLabel = new JLabel("");    
		statusLabel.setBounds(10,20,1000,20);
		li = new JButton("Login");
        li.setBounds(120,260,100,25);
		li.setcommand("LI");
		ca = new JButton("Sign Up");
        ca.setBounds(250,260,100,25);
        help = new JButton("HELP");
        help.setBounds(180,400,100,25);
	ust = new JTextField(6);
        ust.setBounds(200,150,150,30);
        pwt = new JPasswordField(6);
        pwt.setBounds(200,190,150,30);
	pwt.setEchoChar('*');
        us = new JLabel("User Name:");
        us.setBounds(120,150,100,30);
        pw = new JLabel("Password:");
        pw.setBounds(120,190,100,30);
        F1.add(help);
        F1.add(li);
        F1.add(ca);
	F1.add(ust);
        F1.add(pwt);
        F1.add(us);
        F1.add(pw);
	F1.add(statusLabel);
        F1.setVisible(true); 
		li.addActionListener(new ButtonClickListener()); 
		ca.addActionListener(new ButtonClickListener());
		
/*{
		
		
		    public void actionPerformed(ActionEvent ae)
                    {			
                        String data = new String(pwt.getPassword()); 
                        statusLabel.setText(data);
                        if(data.equals("data"))
                        { 
                           FB1();                                 
                        }   
                        else
                        {    
                            statusLabel.setText("not satisfied");
                            F1.remove(help);
                        }
                    }}); */
		F1.repaint();
		F1.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}
		});
		F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
                
	private class ButtonClickListener implements ActionListener,ItemListener
	{
		public void actionPerformed(ActionEvent ae)
		{
                    String command = ae.getActionCommand();
                    if(command.equals("Login"))
                    {
			String data = new String(pwt.getPassword()); 
                        statusLabel.setText(data);
                        if(data.equals("data"))
                        { 
						statusLabel.setText("we're in login Action ;)");						   
                           CA();//FB1();     
statusLabel.setText("we're in login Action ;)");						   
F1.remove(help);				
F1.repaint();		   
                        }   
                        else
                        {    
                            statusLabel.setText("not satisfied");
                            F1.remove(help);
                        }
                    }
                    else if(command.equals("Sign Up"))
                    {
                        F1.remove(help);
                        CA();
                    }
					
                }
		public void itemStateChanged(ItemEvent ie)
		{
			
		}		
	}
	public void pullThePlug()
	{
		//used to close the application
	}
	private void FB1() //Frame FB1 (refer diagram paper for doubts)
	{
             F1.remove(help);
            F1.remove(li);
            F1.remove(ca);
            F1.remove(ust);
            F1.remove(pwt);
            F1.remove(us);
            F1.remove(pw);
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
		mng.addActionListener(new ButtonClickListener()); 
		{
		public void actionPerformed(ActionEvent ae)
                    {			
                        String command = ae.getCommand(); 
                        statusLabel.setText(data);
                        if(command.equals("Manage"))
                        { 
                           manage();                                 
                        }   
                        else
                        {    
                            statusLabel.setText("not satisfied");
                            F1.remove(help);
                        }
					}
}					
		
		F1.repaint();
		F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void CA() //Create Account Form
	{
            JLabel uid,lipwd,cnpwd,secqn,secans;
            JButton submit,cancel;
            JTextField caust;
            JPasswordField capwd,cacpwd;
            F1.remove(help);
            F1.remove(li);
            F1.remove(ca);
            F1.remove(ust);
            F1.remove(pwt);
            F1.remove(us);
            F1.remove(pw);
            submit = new JButton("SUBMIT");
            submit.setBounds(120,260,100,25);
            cancel = new JButton("CANCEL");
            cancel.setBounds(250,260,100,25);
            uid = new JLabel("Enter UserID :");
            uid.setBounds(200,110,40,20);
            lipwd = new JLabel("Enter Login Pwd :");
            lipwd.setBounds(200,110,40,20);
            cnpwd = new JLabel("Confirm Login Pwd :");
            cnpwd.setBounds(200,110,40,20);
            secqn = new JLabel("Choose Security Qn. :");
            secqn.setBounds(200,110,40,20);
            secans = new JLabel("Enter Security Answer :");
            secans.setBounds(200,110,40,20);
            
            
            
	}
}


private void manage()
{
JLabel uname,pwd,cnfpwd,webadd;
 JButton sub,can;
 sub = new JButton("SUBMIT");
            sub.setBounds(120,350,80,25);
            can = new JButton("CANCEL");
            can.setBounds(250,350,80,25);
            uname = new JLabel("UserName :");
            uname.setBounds(50,110,100,30);
            pwd = new JLabel("Password :");
            pwd.setBounds(50,150,100,30);
            cnfpwd = new JLabel("Confirm Password :");
            cnfpwd.setBounds(50,190,150,30);
            webadd = new JLabel("Web Address");
            webadd.setBounds(50,230,150,30);
F1.add(sub);
F1.add(can);
F1.add(uname);
F1.add(pwd);
F1.add(cnfpwd);
F1.add(webadd);
F1.setVisible(true);
JTextField ust = new JTextField(20);
ust.setBounds(200,115,100,20);
JPasswordField pw = new JPasswordField();
pw.setBounds(200,155,100,20);
JPasswordField cpw = new JPasswordField();
cpw.setBounds(200,195,100,20);
JTextField webad = new JTextField(20);
webad.setBounds(200,235,100,20);
F1.add(ust);
F1.add(pw);
F1.add(cpw);
F1.add(webad);
F1.repaint();
F1.setVisible(true);
F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}