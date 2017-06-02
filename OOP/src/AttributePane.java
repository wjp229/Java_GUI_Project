import java.awt.Component;
import java.awt.GridLayout;

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
	static final String[] strb = {"button","panel","rectangle","circle"};
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
			this.add(buttons[i]);
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
