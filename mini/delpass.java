import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class delpass extends Frame implements ActionListener
{
 JFrame F1;
 public static void main(String[] args)
 {
 JFrame F1= new JFrame("Password Wallet");
 F1.setSize(400,500);
 F1.setVisible(true);
 F1.setLayout(null);
 }
 delpass()
 {
 JLabel maittl = new JLabel ("Choose which password to delete : ");
 maittl.setBounds(120,150,300,30);
 F1.add(maittl);
 JLabel Title = new JLabel ( "TITLE :");
 Title.setBounds(70,190,80,30);
 F1.add(Title);
 JComboBox box = new JComboBox();
 box.addItem("Title 1");
 box.addItem("Title 2");
 box.addItem("Title 3");
 box.setBounds(115,190,200,30);
 F1.add(box);
 JButton Cnfdel = new JButton ("Delete");
 Cnfdel.setBounds(175,245,80,25);
 Cnfdel.addActionListener(this);
 F1.add(Cnfdel);
 F1.setVisible(true);
 F1.repaint();
 F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
  /*public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		if(command.equals("Delete"))
		{
			JOptionPane.showMessageDialog(F1,"Are you sure you want to delete?",
			"YES",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}*/
}