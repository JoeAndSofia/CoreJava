package c08_EventHandling.s01_BasicsOfEventHandling.p01_Example_HandlingAButtonClick;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame01 extends JFrame{
	
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame01(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		
		buttonPanel = new JPanel();
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		add(buttonPanel);
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
		
		setTitle("ButtonFrame01");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class ColorAction implements ActionListener{
		private Color backgroundColor;
		
		public ColorAction(Color c){
			backgroundColor = c;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(backgroundColor);
		}
	}
	
	public static void main(String[] args){
		ButtonFrame01 bf01 = new ButtonFrame01();
		bf01.setVisible(true);
	}
}
