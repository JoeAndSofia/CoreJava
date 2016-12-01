package Chapter07_GraphicsProgramming.Section02_CreatingAFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SimpleFrameTest {
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frame.setUndecorated(true);
				frame.setVisible(true);
			
			}
		});
	}
}

class SimpleFrame extends JFrame{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public SimpleFrame(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
}
