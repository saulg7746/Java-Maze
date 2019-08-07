import javax.swing.JFrame;

public class MazeWindow extends JFrame{
	
	public static void main (String args[])
	{
		MazeWindow window = new MazeWindow();
		window.add(new MazeBoard());
		window.setTitle("Java Maze");
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1505, 930);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
	}
}
