package vI_c08_EventHandling.s01_BasicsOfEventHandling.p03_CreatingListenersContainingASingleMethodCall;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventHandlerFrame extends JFrame{
	private JPanel buttonPanel;
	private JButton loadButton;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public EventHandlerFrame(){
//		setLayout(new );
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		buttonPanel = new JPanel();
		add(buttonPanel);
		loadButton = new JButton("Load");
		loadButton.addActionListener(EventHandler.create(ActionListener.class, buttonPanel, "hide"));
		buttonPanel.add(loadButton);
		
		setTitle("EventHandlerFrame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		EventHandlerFrame ehf = new EventHandlerFrame();
		ehf.setVisible(true);
	}
	
	public void loadData(){
		System.out.println("loadData");
	}
}
