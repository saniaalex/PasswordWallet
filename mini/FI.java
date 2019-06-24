/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raghu
 */
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class FI extends JFrame implements ItemListener
{
    JTextField usid,pws;
    ResultSet rs;
    String sql;
	Statement sta;
        JComboBox box;
        String [] name = new String [20];
    public static Connection conn;
    FI()
    {
        JLabel us,pw;
        JButton li,ca,help;
        JTextField ust;
        JPasswordField pwt;
        JFrame F1;
        F1 = new JFrame("PASSWORD WALLET");
        F1.setSize(400,500);
        F1.setLayout(null);
	JLabel tit = new JLabel("Select Title :");
        tit.setBounds(50,200,100,30);
        JLabel uid = new JLabel("Your ID is :");
        uid.setBounds(50,240,100,30);
        JLabel upass = new JLabel("Your Password is :");
        upass.setBounds(50,280,150,30);
        JLabel url = new JLabel("URL :");
        url.setBounds(50,320,150,30);
		F1.add(tit);
		F1.add(uid);
		F1.add(upass);
		F1.add(url);
		F1.setVisible(true); 
		 box = new JComboBox();
		box.addItem("");
		box.addItemListener(this);
        F1.repaint();
        box.setBounds(200,205,150,20);   
		usid = new JTextField(100);
		usid.setBounds(200,245,150,20);
		pws = new JTextField();
		pws.setBounds(200,285,150,20);
		
		int i=0;
		JTextField urls = new JTextField(100);
		urls.setBounds(200,325,150,20);
		F1.add(box);
		F1.add(usid);
		F1.add(pws);
		F1.add(urls);
		F1.repaint();
		F1.setVisible(true);
		F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:mini");
        // Creating a database table
             sta = conn.createStatement(); 
            String ch="FB PWD";
            sql = "select * from Raghu ";
		//where TITLE='"+ch+"'
            rs = sta.executeQuery(sql);
            System.out.println(rs);
        while(rs.next())
		{
                    //name[i]=rs.getString("Title");
                    //i++;
                    //box.addItem(rs.getString("Title"));
		    String fname = rs.getString("ID");
                    String lname = rs.getString("Title");
                    name[i]=lname;
                    box.addItem(lname);
                    System.out.println("name["+i+"]:"+name[i]);
                    i++;
                    String age = rs.getString("UID");
                }
            sta.close();
            conn.close();
        }
    catch (Exception ex)
    {
        System.out.println(ex.getMessage());
    }
       
	while(i>=0)
	{			
		System.out.println("i:"+i);
		System.out.println(name[i]);
		i--;
	}
   }
    public static void main(String [] args)
    {
        FI f = new FI();
        System.out.println("");
    }
	public void itemStateChanged(ItemEvent ie)
	{
            try
            {    
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                conn=DriverManager.getConnection("jdbc:odbc:mini");
                // Creating a database table
		sta = conn.createStatement(); 
                String ch="FB PWD";
		sql = "select * from Raghu where Title='"+box.getSelectedItem()+"'";
                rs = sta.executeQuery(sql);
                while(rs.next())
                {
                    usid.setText(rs.getString("ID"));
                    pws.setText(rs.getString("PWD"));
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
	}  
        
}

