import java.awt.*;
import javax.swing.*;

interface addMenuOpt{//Interface forms entire menu
	void addMenuBar(JMenu Menu, JMenuBar MenuBar);
	void addMenu(JMenu Menu);
	void CreateMenu(JMenu Menu, JMenuBar MenuBar);
}
public class MakeMenu extends JFrame implements addMenuOpt{
	
	@Override
	public void addMenuBar(JMenu Menu, JMenuBar MenuBar) {//function inserting menu in menubar
		MenuBar.add(Menu);
	}
	
	@Override
	public void addMenu(JMenu Menu) {//insert Menu buttons in menu
		JMenuItem MNew = new JMenuItem("NEW");
		JMenuItem MOpen = new JMenuItem("OPEN");
		JMenuItem MSave = new JMenuItem("SAVE");
		JMenuItem MSaveAs = new JMenuItem("SAVE AS");
		JMenuItem MJava = new JMenuItem("NEW JAVA");
		JMenuItem MExit = new JMenuItem("EXIT");

		Menu.add(MNew);
		Menu.add(MOpen);
		Menu.add(MSave);
		Menu.add(MSaveAs);
		Menu.add(MJava);
		Menu.add(MExit);
	}

	@Override
	public void CreateMenu(JMenu Menu, JMenuBar MenuBar) {
		// creating menu directly
		addMenu(Menu);
		addMenuBar(Menu, MenuBar);
	}
}