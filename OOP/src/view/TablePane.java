package view;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import model.DrawnObject;

public class TablePane extends JTable
{
	static final Object[][] rowData = {{"Attribute","Value"},{"Type","a"},{"Height",100}
	,{"Width",200},{"PosX",100},{"PosY",100},{"TextField","b"},{"Variable","c"}};
	static final String[] columnData = {"Attribute","Value"};
	public static DrawnObject selectedObject;
	static DefaultTableModel model = new DefaultTableModel(rowData,columnData);
	static int selectedRow;

	TablePane()
	{
		this.setModel(model);
		model.addTableModelListener(new TablePaneModelListener());
	}

	static public void setTablePane()
	{
		model.setValueAt(selectedObject.type,1,1);
		model.setValueAt(selectedObject.height,2,1);
		model.setValueAt(selectedObject.width,3,1);
		model.setValueAt(selectedObject.x,4,1);
		model.setValueAt(selectedObject.y,5,1);
		model.setValueAt(selectedObject.text,6,1);
		model.setValueAt(selectedObject.variable,7,1);
	}

	class TablePaneModelListener implements TableModelListener
	{

		@Override
		public void tableChanged(TableModelEvent event) {


			if(selectedRow!=0)
			{
				switch(selectedRow)
				{
				case 1:
					selectedObject.text = (String)model.getValueAt(selectedRow, 1);
					break;
				case 2:
					selectedObject.height = Integer.parseInt(""+model.getValueAt(selectedRow, 1));
					break;
				case 3:
					selectedObject.width = Integer.parseInt(""+model.getValueAt(selectedRow, 1));
					break;
				case 4:
					selectedObject.x = Integer.parseInt(""+model.getValueAt(selectedRow, 1));
					break;
				case 5:
					selectedObject.y = Integer.parseInt(""+model.getValueAt(selectedRow, 1));
					break;
				case 6:
					selectedObject.text = (String)(model.getValueAt(selectedRow, 1));
					break;
				case 7:
					selectedObject.variable = (String)(model.getValueAt(selectedRow, 1));
					break;
				}
				selectedRow = 0;
				setTablePane();
				EditorPane.DO.repaint();
			}
		}
	}
}