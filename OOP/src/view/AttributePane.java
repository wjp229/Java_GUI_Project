package view;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Controller.ButtonPane;
import model.Button;
import model.Circle;
import model.DrawnObject;
import model.Rectangle;
import model.RoundRectangle;

public class AttributePane extends JSplitPane
{
	JPanel button = new ButtonPane();
	JTable table = new TablePane();

	AttributePane(JFrame frame)
	{
		super(JSplitPane.VERTICAL_SPLIT);

		setAttributePane(frame);
		table.getSelectionModel().addListSelectionListener(new TableListSelectionListener());
	}

	public void setAttributePane(JFrame frame)
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

	class TableListSelectionListener implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent event) {	
			TablePane.selectedRow = table.getSelectedRow();			
		}		
	}
}
