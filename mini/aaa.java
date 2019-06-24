import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class aaa extends JFrame implements ItemListener,ActionListener
{
   public static JFrame F1;
   public static Connection conn;
   public static Statement sta;
   public static ResultSet rs;
   public static String sql;
   public static JTextField T1,T2,T3;
   public static JButton B1,B2;
   
   aaa()
   {
        //Create a thing to extract interact etc wid db
        F1 = new JFrame("Password Wallet");
        F1.setSize(400,500);
        F1.setVisible(true);
        F1.setLayout(null);
        F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        T1= new JTextField(30);
        T1.setBounds(50,150,200,30);
        T2= new JTextField(30);
        T2.setBounds(50,190,200,30);
        F1.add(T1);
        F1.add(T2);
        B1=new JButton("Button 1");
        B1.setBounds(50,230,100,25);
        B1.addActionListener(this);
        F1.add(B1);
        B2=new JButton("Button 2");
        B2.setBounds(160,230,100,25);
        B2.addActionListener(this);
        F1.add(B2);
        
   }
   public static void main(String [] args) 
   {
       aaa a = new aaa();
       try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           conn = DriverManager.getConnection("jdbc:odbc:mini");
           sta = conn.createStatement(); 
           
           System.out.println("Enter Name:");
           
           
       }
       catch(Exception ex)
       {
           System.out.println("Exception : "+ex.getMessage());
       }
   }
   public void itemStateChanged(ItemEvent ie)
   {
       
   }
   public void actionPerformed(ActionEvent ae)
   {
       try
       {
          
       //EXTRACT CONTENTS FROM DBchoi=rs.getString("ID");sql="Select * from "+T1.getText();
       sql="select PWD from Raghu where TITLE='"+T1.getText()+"'";    
           System.out.println(sql);
       rs=sta.executeQuery(sql);
       while(rs.next())
       {
           System.out.println(rs.getString("PWD"));
       }
       System.out.println("Name is:"+T1.getText());
       }
       catch(Exception ex)
       {
           System.out.println(ex.getMessage());
       }
   }
}