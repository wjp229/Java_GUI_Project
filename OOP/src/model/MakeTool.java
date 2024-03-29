package model;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import com.google.gson.*;

import Controller.ButtonPane;
import Controller.MenuToolAction;
import Controller.OpenDialog;
import Controller.SaveDialog;
import view.MainClass;

interface AddToolOpt{
	void AddToolBar(JToolBar ToolBar);
	void CreateTool(JToolBar ToolBar, JFrame Frame);
}
public class MakeTool extends JFrame implements AddToolOpt{

	static SaveDialog saveDialog = new SaveDialog(MainClass.frame,"Save File");
	public static OpenDialog openDialog = new OpenDialog(MainClass.frame,"Open File");
	@Override
	public void AddToolBar(JToolBar ToolBar) {
		MenuToolAction MTAction = new MenuToolAction();
		JButton TNew = new JButton(new ImageIcon("img/new.png"));
		JButton TOpen = new JButton(new ImageIcon("img/open.png"));
		JButton TSave = new JButton(new ImageIcon("img/save.png"));
		JButton TSaveAs = new JButton(new ImageIcon("img/saveas.png"));
		JButton TJava = new JButton(new ImageIcon("img/java.png"));
		JButton TExit = new JButton(new ImageIcon("img/exit.png"));
		
		TNew.addActionListener(MTAction);
		TOpen.addActionListener(MTAction);
		TSave.addActionListener(new SaveButtonActionListener());
		TSaveAs.addActionListener(new SaveAsButtonActionListener());
		TJava.addActionListener(MTAction);
		TExit.addActionListener(MTAction);
		
		ToolBar.add(TNew);
		ToolBar.add(TOpen);
		ToolBar.addSeparator();
		ToolBar.add(TSave);
		ToolBar.add(TSaveAs);
		ToolBar.addSeparator();
		ToolBar.add(TJava);
		ToolBar.add(TExit);
		
	}

	@Override
	public void CreateTool(JToolBar ToolBar, JFrame Frame) {
		AddToolBar(ToolBar);
		ToolBar.setFloatable(false);
		Frame.add(ToolBar, BorderLayout.NORTH);
	}
	
	class SaveAsButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			saveDialog.setVisible(true);
		}	
	}
	
	class SaveButtonActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event) {			
			try
			{
				FileWriter writer = new FileWriter("C:\\JavaFileIoEx\\abc.json");
				DrawnObject traversal;
				Gson gson = new Gson();
				
				for(int i=0;i<ButtonPane.drawnVector.size();i++)
				{
					traversal = ButtonPane.drawnVector.elementAt(i);
					String inp = gson.toJson(traversal);
					writer.write(inp);
					writer.flush();
				}
				writer.close();
			}
			catch(IOException io)
			{
				System.out.println("Tool.SaveButton.ActionListener.Exception Happened!!");
			}
		}
		
	}
}
