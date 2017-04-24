package c08_EventHandling.s01_BasicsOfEventHandling.p05_AdapterClasses;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AdapterClassesFrame extends JFrame{
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;

	public AdapterClassesFrame(){
		this.addWindowListener(new WindowAdapter(){
			//following methods are all optional to implement
			
		    /**
		     * Invoked when a window has been opened.
		     */
		    public void windowOpened(WindowEvent e) {
		    	System.out.println("windowOpened");
		    }

		    /**
		     * Invoked when a window is in the process of being closed.
		     * The close operation can be overridden at this point.
		     */
		    public void windowClosing(WindowEvent e) {
		    	System.out.println("windowClosing");
		    }

		    /**
		     * Invoked when a window has been closed.
		     */
		    public void windowClosed(WindowEvent e) {
		    	System.out.println("windowClosed");
		    }

		    /**
		     * Invoked when a window is iconified.
		     */
		    public void windowIconified(WindowEvent e) {
		    	System.out.println("windowIconified");
		    }

		    /**
		     * Invoked when a window is de-iconified.
		     */
		    public void windowDeiconified(WindowEvent e) {
		    	System.out.println("windowDeiconified");
		    }

		    /**
		     * Invoked when a window is activated.
		     */
		    public void windowActivated(WindowEvent e) {
		    	System.out.println("windowActivated");
		    }

		    /**
		     * Invoked when a window is de-activated.
		     */
		    public void windowDeactivated(WindowEvent e) {
		    	System.out.println("windowDeactivated");
		    }

		    /**
		     * Invoked when a window state is changed.
		     * @since 1.4
		     */
		    public void windowStateChanged(WindowEvent e) {
		    	System.out.println("windowStateChanged");
		    }

		    /**
		     * Invoked when the Window is set to be the focused Window, which means
		     * that the Window, or one of its subcomponents, will receive keyboard
		     * events.
		     *
		     * @since 1.4
		     */
		    public void windowGainedFocus(WindowEvent e) {
		    	System.out.println("windowGainedFocus");
		    }

		    /**
		     * Invoked when the Window is no longer the focused Window, which means
		     * that keyboard events will no longer be delivered to the Window or any of
		     * its subcomponents.
		     *
		     * @since 1.4
		     */
		    public void windowLostFocus(WindowEvent e) {
		    	System.out.println("windowLostFocus");
		    }
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("AdapterClassesFrame");
	}
	
	public static void main(String[] args){
		AdapterClassesFrame acf = new AdapterClassesFrame();
		acf.setVisible(true);
	}
}
