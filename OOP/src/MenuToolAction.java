import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuToolAction extends JPanel implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() instanceof JButton)
		{
			JButton Tmp = (JButton)e.getSource();

			switch(Tmp.getText())
			{
			case "NEW" :
				ButtonPane.drawnVector.removeAllElements();
				break;
			case "EXIT" :
				System.exit(0);
				break;
			}
		}
		else if(e.getSource() instanceof JMenuItem)
		{
			JMenuItem Tmp = (JMenuItem)e.getSource();
			
			switch(Tmp.getText())
			{
			case "NEW" :
				ButtonPane.drawnVector.removeAllElements();
				break;
			case "EXIT" :
				System.exit(0);
				break;
			}
		}
		
	}
}
