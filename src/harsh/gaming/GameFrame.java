package harsh.gaming;
import javax.swing.JFrame;

public class GameFrame extends JFrame implements Constants {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor
	GameFrame() throws Exception{
		Board board = new Board();
		
		this.setSize(BOARD_HEIGHT, BOARD_WIDTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Game - 2022");
		setLocationRelativeTo(null);
		setResizable(false);
		add(board);
		setVisible(true);
	}

	//Timer (internally thread)

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GameFrame obj=new GameFrame();
		//System.out.println(Thread.currentThread());
		
	}

}