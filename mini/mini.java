//Frame FB
//Frame HOME
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class mini extends JFrame
{
    
public static Connection conn;
	private JFrame F1;
	JLabel us,pw;
	JButton li,ca,help;
	JTextField ust,usid,urls,pws;
	JPasswordField pwt;
	JButton home,mng,view,lo,clp,cnfview;
	CheckboxGroup cbg;
	Checkbox add,mod,del;
	JComboBox box,box1;
        String selectdbox;
        JLabel tit,uid,upass,url;
	JTextArea msg;
        ResultSet Rs;
        String sql;
        String datauid = null;
	public static int choice;
	public static String [] name;
        public static Statement sta = null;
	public static String titledb;
	public static String uiddb,userid;
	public static String pwddb;
	private JLabel statusLabel;
            private JLabel headerlabel;
	public mini()
	{
		prepareGUI();//initial login page
	}
	public static void main(String[] args)
	{
	
		
		mini m = new mini();
		choice=0;
		String [] choicename={"no choice","add pass","mod pass","del pass","view pass"};
		System.out.println("Choice number :"+choice +"  Choice name:"+choicename[choice]);
		System.out.println("After object creation");
		try
		{
		System.out.println("Before query");
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 conn = DriverManager.getConnection("jdbc:odbc:mini");
		 sta = conn.createStatement(); 
		//String sql = "select * from Raghu";
		/*ResultSet rs = sta.executeQuery(sql);
		while(rs.next())
		{
		titledb = rs.getString("TITLE");
		uiddb = rs.getString("UID");
		pwddb = pwddb+rs.getString("PWD");
		System.out.println(titledb+ " " +uiddb+ " " +pwddb);
		       		
		}
		sta.close(); 
		conn.close();*/
		}
		catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
             
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
            F1.repaint();
            /*F1.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent windowEvent)
		{
                    System.exit(0);
		}
            });*/
            F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
                
	private class ButtonClickListener implements ActionListener,ItemListener
	{
            public void actionPerformed(ActionEvent ae)
            {
                String command = ae.getActionCommand();
                if(command.equals("Login"))
                {
                try
                {
                    String datapwd = new String(pwt.getPassword()); 
                    datauid = ust.getText(); 
                    String sqlin="Select * from MAIN_TB";// where ID='"+datauid+"'";
                    ResultSet rs=sta.executeQuery(sqlin);
                    int found=0;
                    while(rs.next())
                    {                       
                        found=0;
                        String compdbid=null;
                        compdbid=rs.getString("UID");
                        if(datauid.equals(compdbid))
                        {
                            System.out.println("UID MATCHED.");
                            found++;
                            break;
                        }
                    }
                    if(found==1)
                    {
                        sql="select PWD from MAIN_TB where UID='"+datauid+"'";    
                        ResultSet rs2=sta.executeQuery(sql);
                        while(rs2.next())
                        {
                            String compdbpwd = rs2.getString("PWD");
                            if(datapwd.equals(compdbpwd))
                            { 
                                System.out.println("PWD MATCHED.");
                                HOME();         
                                statusLabel.setText("satisfied");						   
                            }   
                            else
                            {    
                                JOptionPane.showMessageDialog(F1, "Entered Password is incorrect,Please Recheck it.",
                                "Wrong Password", JOptionPane.WARNING_MESSAGE);
                                statusLabel.setText("not satisfied");                    
                            }
                        }                
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(F1, "Entered UID is wrong,Please Recheck it.",
                        "UserId doesnt exist", JOptionPane.WARNING_MESSAGE);
                        System.out.println("UID doesnt exist.");                                                            
                    }
                }
                //}
                    catch(Exception ex)
                    {
                        System.out.println("Exception arised in Login Action Listener");
                        System.out.println(ex.getMessage());
                    }
                }
                else if(command.equals("Sign Up"))
                {
                    CA();
                    statusLabel.setText("Create your account");
                    F1.remove(help);
                } 
		else if(command.equals("View"))
		{
					
                    F1.getContentPane().removeAll();
                    HOME();
                    F1.add(statusLabel);
                    F1.remove(msg);
                    view();
                }
                else if(command.equals("Manage"))
                {
                    F1.getContentPane().removeAll();
                    HOME();
                    F1.add(statusLabel);
                    F1.remove(msg);
                    manage();
		}
		else if(command.equals("Log Out"))
		{
                    JOptionPane.showMessageDialog(F1, "Thank you,for using Password Wallet!",
                        "LOGOUT", JOptionPane.INFORMATION_MESSAGE);
                    pullThePlug();
		}
		else if(command.equals("HOME"))
		{
                    F1.getContentPane().removeAll();
                    HOME();
                    F1.add(statusLabel);
		}
		else if(command.equals("CANCEL"))
		{
                    F1.getContentPane().removeAll();
                    F1.dispose();
                    prepareGUI();
                }
                else if(command.equals("Modify"))
                {
                    System.out.println("Modify clicked bro");
                }
                else if(command.equals("Delete"))
                {
                    System.out.println("Manage->Delete clicked bro");
                }
	}
            
            public void itemStateChanged(ItemEvent ie)
            {
            	String secchoice = cbg.getSelectedCheckbox().getLabel();
            	if(secchoice=="Add Password")
            	{
                    F1.getContentPane().removeAll();
                    HOME();
                    F1.remove(msg);
                    manage();
                    cbg.setSelectedCheckbox(add);
                    addpass();
                    statusLabel.setText("IN ADD");
		}
		else if(secchoice=="Modify Password")
		{
                    F1.getContentPane().removeAll();
                    HOME();
                    F1.remove(msg);
                    manage();
                    cbg.setSelectedCheckbox(mod);
                    modpass();
                    statusLabel.setText("IN mod");
		}
		else if(secchoice=="Delete Password")
		{
                    F1.getContentPane().removeAll();
                    HOME();
                    F1.remove(msg);
                    manage();
                    cbg.setSelectedCheckbox(del);
                    delpass();
                    statusLabel.setText("IN del");
                }
            }		
	}
	private void HOME() //Home Frame
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
            view= new JButton("View");
            view.setBounds(200,140,100,25);
            lo= new JButton("Log Out");
            lo.setBounds(300,140,90,25);
            help = new JButton("HELP");
            help.setBounds(250,425,100,25);
            clp = new JButton("Change Login Pwd");
            clp.setBounds(10,425,160,25);
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
            mng.addActionListener(new ButtonClickListener());
            view.addActionListener(new ButtonClickListener());
            home.addActionListener(new ButtonClickListener());
            lo.addActionListener(new ButtonClickListener());
            F1.setVisible(true);
            F1.repaint();
            F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
        public void CA() //Create Account Form
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
            secans.setBounds(50,270,170,30);
            F1.add(submit);
            F1.add(cancel);
            F1.add(uid);
            F1.add(lipwd);
            F1.add(cnpwd);
            F1.add(secqn);
            F1.add(secans);
            F1.setVisible(true); 
            JTextField ust = new JTextField(20);
            ust.setBounds(180,115,100,20);
            JPasswordField pw = new JPasswordField();
            pw.setBounds(180,155,100,20);
            JPasswordField cpw = new JPasswordField();
            cpw.setBounds(180,195,100,20);
            JTextField ans = new JTextField(100);
            ans.setBounds(180,275,100,20);
            JComboBox box = new JComboBox();
            box.addItem("What is your first pet name?");
            box.addItem("What is the number of first vehicle?");
            box.addItem("What is your favourite colour?");
            box.setBounds(180,235,200,30);
            //box.addItemListener(this);
            cancel.addActionListener(new ButtonClickListener());
            F1.add(box);
            F1.add(ust);
            F1.add(pw);
            F1.add(cpw);
            F1.add(ans);
            F1.repaint();
            F1.setVisible(true);
            F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}   
        private void addpass() //Addpasswrd chckbox
	{
		
            F1.remove(msg);
            JButton submit,cancel;
            JTextField title,usname,pwd,cpwd,url;
            JLabel ltitle,lusname,lpwd,lcpwd,lurl;
            ltitle = new JLabel("TITLE :");
            ltitle.setBounds(70,220,100,30);
            lusname = new JLabel("User ID :");
            lusname.setBounds(70,240,100,30);
            lpwd = new JLabel ("Password :");
            lpwd.setBounds(70,260,120,30);
            lcpwd = new JLabel ("Confirm Pwd :");
            lcpwd.setBounds(70,280,160,30);
            lurl = new JLabel ("URL :");
            lurl.setBounds(70,300,100,30);
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
            title.setBounds(155,225,150,20);
            usname.setBounds(155,245,150,20);
            pwd.setBounds(155,265,150,20);
            cpwd.setBounds(155,285,150,20);
            url.setBounds(155,305,150,20);
            F1.add(title);
            F1.add(usname);
            F1.add(pwd);
            F1.add(cpwd);
            F1.add(url);
            submit = new JButton ("SUBMIT");
            submit.setBounds(100,370,80,25);
            cancel = new JButton ("CANCEL");
            cancel.setBounds(190,370,80,25);
            F1.add(submit);
            F1.add(cancel);
            F1.setVisible(true);
            F1.repaint();
            F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}   
        private void delpass() //Delpass chckbox
	{
            F1.remove(msg);
            JLabel maittl = new JLabel ("Choose which password to delete : ");
            maittl.setBounds(115,195,300,20);
            F1.add(maittl);
            JLabel Title = new JLabel ( "TITLE :");
            Title.setBounds(70,220,80,20);
            F1.add(Title);
            box = new JComboBox();
            box.addItem("");
            extrTitle();
            box.setBounds(115,220,200,20);
            F1.add(box);
            JButton Cnfdel = new JButton ("Delete");
            Cnfdel.setBounds(175,250,80,25);
            Cnfdel.addActionListener(new ButtonClickListener());
            F1.add(Cnfdel);
            F1.setVisible(true);
            F1.repaint();
            F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	private void modpass() //Modpass chckbox
	{
		F1.remove(msg);
		JLabel maittl = new JLabel ("Choose which password to modify : ");
		maittl.setBounds(115,195,300,20);
		F1.add(maittl);
		JLabel Title = new JLabel ( "TITLE :");
		Title.setBounds(70,220,80,20);
		F1.add(Title);
		 box = new JComboBox();
                box.addItem("");
		System.out.println("Bro here in modpass");
                extrTitle();
		box.setBounds(115,220,200,20);
		F1.add(box);
		JButton CnfMod = new JButton ("Modify");
		CnfMod.setBounds(175,250,80,25);
		CnfMod.addActionListener(new ButtonClickListener());
		F1.add(CnfMod);
		F1.setVisible(true);
		F1.repaint();
		F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void view() //View Frame
	{
		F1.remove(msg);
	    tit = new JLabel("Select Title :");
        tit.setBounds(50,180,100,30);
        uid = new JLabel("Your ID is :");
        uid.setBounds(50,240,100,30);
        upass = new JLabel("Your Password is :");
        upass.setBounds(50,280,150,30);
        url = new JLabel("URL :");
        url.setBounds(50,320,150,30);
		F1.add(tit);
		F1.add(uid);
		F1.add(upass);
		F1.add(url);
		F1.setVisible(true); 
		box = new JComboBox();
		System.out.println("Before try in IN");
		userid=	ust.getText();
		System.out.println("123");
		System.out.println(userid);
                cnfview = new JButton("View Password");
                cnfview.setBounds(140, 210, 125, 20);
                F1.add(cnfview);
                cnfview.addActionListener(new ButtonListener() );
                box.addItem("");
		box.setBounds(200,185,150,20);   
                //box.addItemListener(this);
                try
                {
                System.out.println("Bro here in extrTitle");
                String sql = "select * from "+datauid;
		
		System.out.println("Bro here");
		ResultSet rs1 = sta.executeQuery(sql);
                while(rs1.next())
		{
                    System.out.println(rs1);
                    String title = rs1.getString("TITLE");
                    System.out.println(title);
                    box.addItem(title);
		}
		
                
		}
		catch (Exception ex){
                System.out.println(ex.getMessage());}            
		usid = new JTextField(100);
		usid.setBounds(200,245,150,20);
		pws = new JTextField();
		pws.setBounds(200,285,150,20);
		urls = new JTextField(100);
		urls.setBounds(200,325,150,20);
                
		F1.add(box);
		F1.add(usid);
		F1.add(pws);
		F1.add(urls);
		F1.repaint();
		F1.setVisible(true);
		F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class ButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent ae)
            {
                String command = ae.getActionCommand();
                if(command.equals("View Password"))
                {                    
                    System.out.println("Selected View Password.");
                    try
                    {    
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        conn=DriverManager.getConnection("jdbc:odbc:mini");
                        // Creating a database table
                        sta = conn.createStatement(); 
                        String ch="FB PWD";
                        sql = "select * from "+datauid+" where Title='"+box.getSelectedItem()+"'";
                        ResultSet rs = sta.executeQuery(sql);
                        while(rs.next())
                        {
                            usid.setText(rs.getString("ID"));
                            pws.setText(rs.getString("PWD"));
                            urls.setText(rs.getString("URL"));
                        }
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        private void manage() //Manage Frame
	{	
		F1.remove(msg);
		cbg = new CheckboxGroup();
		add = new Checkbox("Add Password",cbg,false);
		mod = new Checkbox("Modify Password",cbg,false);
		del = new Checkbox("Delete Password",cbg,false);
		add.setBounds(30,175,100,15);
		mod.setBounds(140,175,115,15);
		del.setBounds(260,175,120,15);
		add.addItemListener(new ButtonClickListener());
		mod.addItemListener(new ButtonClickListener());
		del.addItemListener(new ButtonClickListener());	
		F1.add(add);
		F1.add(mod);
		F1.add(del);
		F1.repaint();
		F1.setVisible(true);
		F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void pullThePlug() 
	{
    // this will make sure WindowListener.windowClosing() et al. will be called.
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    // this will hide and dispose the frame, so that the application quits by
    // itself if there is nothing else around. 
		F1.setVisible(false);
		F1.dispose();
                try
                {
                sta.close(); 
                System.out.println("sta closed");
		conn.close();
                System.out.println("conn closed");    
                }
                catch(Exception ex)
                {
                    System.out.println("Error in pull the plug:"+ex.getMessage());
                }
    // if you have other similar frames around, you should dispose them, too.
    // finally, call this to really exit. 
    // i/o libraries such as WiiRemoteJ need this. 
    // also, this is what swing does for JFrame.EXIT_ON_CLOSE
		System.exit(0); 
	}
public void extrTitle()
{
    try
                {
                System.out.println("Bro here in extrTitle");
                String sql = "select * from "+datauid;
		
		System.out.println("Bro here");
		ResultSet rs1 = sta.executeQuery(sql);
                while(rs1.next())
		{
                    System.out.println(rs1);
                    String title = rs1.getString("TITLE");
                    System.out.println(title);
                    box.addItem(title);
		}
		
                
		}
		catch (Exception ex){
                System.out.println(ex.getMessage());}
}

}