import java.sql.*;
public class msacc 
{
public static Connection conn;
public static void main(String[] args) 
{
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:mini");
        // Creating a database table
	Statement sta = conn.createStatement(); 
        String ch="FB PWD";
	String sql = "select * from Raghu where TITLE='"+ch+"'";
	ResultSet rs = sta.executeQuery(sql);
	System.out.println(rs);
        while(rs.next())
	{
            
            String fname = rs.getString("ID");
            String lname = rs.getString("Title");
            String age = rs.getString("UID");
            System.out.println(fname+ " " +lname+ " " +age);
        }
	sta.close();        
	conn.close();	
    }
    catch (Exception ex)
    {
        System.out.println(ex.getMessage());
    }
}
}