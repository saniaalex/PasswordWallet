import java.awt.*;
import java.awt.event.*;
class Frame2 extends Frame implements ActionListener
{
 Button b;
 Frame2()
 {
	setLayout(null);
	b= new Button("Back");
	add(b);
	b.addActionListener(this);
	setVisible(true);
 }
 public void actionPerformed(ActionEvent ae)
 {
	if(ae.getSource()==b)
	{
		dispose();
	}
 }
}