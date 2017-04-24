package c08_EventHandling.s01_BasicsOfEventHandling.p04_Example_ChangingTheLookAndFeel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafFrame extends JFrame{
	
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 200;
	
	public PlafFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("PlafFrame");
		
		buttonPanel = new JPanel();
		
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info : infos){
			makeButton(info.getName(), info.getClassName());
		}
		add(buttonPanel);
//		pack();
	}
	
	void makeButton(String name, final String plafName) {
		JButton button = new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				try{
					System.out.println(plafName);
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);	
//					pack();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args){
		PlafFrame pf = new PlafFrame();
		pf.setVisible(true);
	}
}
