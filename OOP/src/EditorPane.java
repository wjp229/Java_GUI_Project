import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JList;
import javax.swing.JScrollPane;

class EditorPane extends JScrollPane
{
	static DrawingObject DO = new DrawingObject();
	static Boolean Made = false;
	
	EditorPane()
	{
		super(DO);
		setScroll();
		this.addMouseListener(new ButtonMouseListener());
		this.addMouseMotionListener(new ButtonMouseListener());
	}

	public void setScroll()
	{
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}

	class ButtonMouseListener implements MouseListener, MouseMotionListener{
		DrawnObject DOP ;
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			ClickComponent(e.getX(), e.getY());

			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(EditorPane.Made)
			{
				DOP = ButtonPane.drawnVector.lastElement();
				DOP.x = e.getX();
				DOP.y = e.getY();
				TablePane.selectedObject = DOP;
				TablePane.setTablePane();
				//System.out.println("P");
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

			if(EditorPane.Made)
			{
				//System.out.println("R");
				DOP.width = - DOP.x + e.getX();
				DOP.height = - DOP.y + e.getY();
				DOP.Clicked = false;
				TablePane.setTablePane();
				repaint();

				EditorPane.Made = false;
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void ClickComponent(int x, int y)
		{
			for(int a = ButtonPane.drawnVector.size() - 1; a >= 0; a--)
			{
				DOP = ButtonPane.drawnVector.get(a);

				if((DOP.x < x) && (x < DOP.x + DOP.width))
				{		
					if((DOP.y < y) && (y < DOP.y + DOP.height))
					{
						DOP.Clicked = true;
					}
					else
						DOP.Clicked = false;
				}
				else  DOP.Clicked = false;
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println(EditorPane.Made);
			if(!EditorPane.Made)
			{
				for(int a = ButtonPane.drawnVector.size() - 1; a >= 0; a--)
				{
					DOP = ButtonPane.drawnVector.get(a);
					if(DOP.Clicked)
					{
						//ChangeSize(e.getX(), e.getY(), DOP);
						break;
					}
				}
				if(DOP.Clicked)
				ChangeSize(e.getX(), e.getY(), DOP);
				TablePane.setTablePane();
				
				repaint();
			}
			
		}
		public void ChangeSize(int x, int y, DrawnObject DOP)
		{
			DOP.width = x - DOP.x;
			DOP.height = y - DOP.y;
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

}
}
