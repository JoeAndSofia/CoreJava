package Chapter08_EventHandling.Section02_Actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * A frame with a panel that demonstrates color change actions.
 *
 */
public class ActionFrame extends JFrame{

	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public static String SET_YELLOW = "ctrl shift Y";
	public static String SET_BLUE = "ctrl shift B";
	public static String SET_RED = "ctrl shift R";
	
	public ActionFrame(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		buttonPanel = new JPanel();
		
		// define actions
		Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
		Action blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
		Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);
		Action changeAction = new ChangeKeyStrokeAction("ctrl E");
		
		// add buttons for these actions
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		buttonPanel.add(new JButton(changeAction));
		
		// add panel to frame
		add(buttonPanel);
		
		//associate the Y, B and R keys with names
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke(SET_YELLOW), "p.y");
		imap.put(KeyStroke.getKeyStroke(SET_BLUE), "p.b");
		imap.put(KeyStroke.getKeyStroke(SET_RED), "p.r");
		
		//associate the names with actions
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("p.y", yellowAction);
		amap.put("p.b", blueAction);
		amap.put("p.r", redAction);
		
	}
	
	public class ColorAction extends AbstractAction{

		public ColorAction(String name, Icon icon, Color c){
			putValue(Action.NAME, name);	//button name
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());	//tooltip
			putValue("color", c);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Color c = (Color) getValue("color");
			buttonPanel.setBackground(c);
		}
	}
	
	public class ChangeKeyStrokeAction extends AbstractAction{
		
		public ChangeKeyStrokeAction(String key){
			putValue(Action.NAME, "Change");	//button name
			putValue(Action.SMALL_ICON, null);
			putValue(Action.SHORT_DESCRIPTION, "Change the color changing key stroke");	//tooltip
			putValue("key",key);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			SET_YELLOW = (String) getValue("key");
			InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
			imap.put(KeyStroke.getKeyStroke(SET_YELLOW), "p.y");
			
//			ActionMap amap = buttonPanel.getActionMap();
//			amap.put("p.y", yellowAction);
		}
	}
	
	public static void main(String[] args){
		ActionFrame af = new ActionFrame();
		af.setVisible(true);
	}
}
