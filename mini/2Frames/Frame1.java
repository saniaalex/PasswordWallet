import java.awt.*;
import java.awt.event.*;
class Frame1 extends Frame implements ActionListener
{
Button b1,b2;
Frame1()
{
 setLayout(null);
 b1=new Button("Next");
 b2=new Button("Close");
 b1.setBounds(100,100,70,40);
 b2.setBounds(200,100,70,40);
 add(b1);
 add(b2);
 b1.addActionListener(this);
 b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
	Frame2 f2=new Frame2();
	f2.setSize(500,500);
	f2.setVisible(true);
	Button b3 = new Button("B3");
	b3.setBounds(200,200,70,40);
	b3.addActionListener(this);
	add(b3);
}
else
{
	System.exit(0);
}
}
public static void main(String [] args)
{
	Frame1 f1=new Frame1();
	f1.setSize(500,500);
	f1.setTitle("First Frame");
	f1.setVisible(true);
}
}