package VolumeI.Chapter08_EventHandling.Section01_BasicsOfEventHandling.Part02_BecomingComfortableWithInnerClasses;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame02 extends JFrame{
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame02(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		buttonPanel = new JPanel();
		setTitle("ButtonFrame02");
		add(buttonPanel);
		makeButton("Yellow",Color.YELLOW);
		makeButton("Blue",Color.BLUE);
		makeButton("Red",Color.RED);
		makeButton("Black",Color.BLACK);
		makeButton("Original",null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void makeButton(String name, final Color backgroundColor){
		JButton button = new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(backgroundColor);
			}
		});
	}
	
	public static void main(String[] args){
		ButtonFrame02 bf02 = new ButtonFrame02();
		bf02.setVisible(true);
	}
}
