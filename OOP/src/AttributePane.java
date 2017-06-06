import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class AttributePane extends JSplitPane
{
	AttributePane(JFrame frame)
	{
		super(JSplitPane.VERTICAL_SPLIT);
		
		JPanel button = new ButtonPane();
		JTable table = new TablePane();
		
		setAttributePane(frame,button,table);
	}
	
	public void setAttributePane(JFrame frame,JPanel button, JTable table)
	{	
		setSplitPane(frame);
		
		this.setTopComponent(button);
		this.setBottomComponent(table);	
	}
	
	public void setSplitPane(Component frame)
	{
		this.setDividerLocation((int)frame.getSize().getHeight()/3*2);
		this.setDividerSize(5);
		this.setContinuousLayout(true);
	}
	
}

class ButtonPane extends JPanel 
{
	static final String[] strb = {"button","roundrectangle","rectangle","circle"};
	public static Vector<DrawnObject> drawnVector = new Vector<DrawnObject>();
	static int Make = 0;
	JButton[] buttons = new JButton[4];
	
	ButtonPane()
	{
		this.setLayout(new GridLayout(2,2));
		setButtons();
	}
	
	public void setButtons()
	{
		for(int i=0;i<strb.length;i++)
		{
			buttons[i] = new JButton(strb[i]);
			buttons[i].addActionListener(new ButtonActionListener());
			this.add(buttons[i]);
		}
	}
	
	class ButtonActionListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent action)
		{
			JButton button = (JButton)action.getSource();
			String text = button.getText();
			
			if(strb[0].equals(text))
			{
			    drawnVector.addElement(new Button());
				
			    System.out.println("*" + ButtonPane.drawnVector.size());
				DrawnObject DOP = ButtonPane.drawnVector.get(0);
				System.out.println("XXXXX  " + DOP.width);
			}
			else if(strb[1].equals(text))
			{
				drawnVector.addElement(new RoundRectangle());
			}
			else if(strb[2].equals(text))
			{
				drawnVector.addElement(new Rectangle());
			}
			else if(strb[3].equals(text))
			{
				drawnVector.addElement(new Circle());
			}
		}
	}
	
}

class TablePane extends JTable
{
	static final String[] strb = {"button","panel","rectangle","circle","sqare","arrow"};
	static final Object[][] rowData = {{"Attribute","Value"},{"Type",1},{"Height",2}
						 ,{"Width",3},{"PosX",4},{"PosY",5},{"TextField",6},{"Variable",7}};
	static final String[] columnData = {"Attribute","Value"};
	
	TablePane()
	{
		super(rowData,columnData);	
	}
	
}
