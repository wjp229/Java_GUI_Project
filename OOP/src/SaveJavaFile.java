import java.io.FileWriter;
import java.io.IOException;

public class SaveJavaFile {
	public SaveJavaFile() throws IOException
	{
		FileWriter writer = new FileWriter("C:\\JavaFileEx\\"+MainClass.frame.getTitle()+".java");

		String Title = MainClass.frame.getTitle();

		System.out.println(Title);

		DrawnObject traversal;

		String inp = "import javax.swing.*;"
				+ "import java.awt.*;"
				+ "public class " + MainClass.frame.getTitle() + " extends JFrame {"
				+ "Container contentPane;"
				+ MainClass.frame.getTitle() + "() {"
				+ "setTitle(\""+ MainClass.frame.getTitle() +"\");"
				+ "setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);"
				+ "contentPane = getContentPane();"
				+ "MyPanel panel = new MyPanel();"
				+ "contentPane.add(panel , BorderLayout.CENTER);"
				+ "setSize(500,500);"
				+ "setVisible(true);"
				+ "}"
				+ ""
				+ "class MyPanel extends JPanel {"
				+ "public void paintComponent(Graphics g) {"
				+ "super.paintComponent(g);"
				+ "g.setColor(Color.BLUE);"
				+ "g.drawRect(10,10, 50, 50);"
				+ "}"
				+ "}"
				+ "public static void main(String [] args) {"
				+ "new "+ MainClass.frame.getTitle() +"();"
				+ "}"
				+ "}";

		writer.write(inp);
		writer.flush();
}
}
