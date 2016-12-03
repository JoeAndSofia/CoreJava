package Chapter07_GraphicsProgramming.Section03_PositioningAFrame.Part02_DeterminingAGoodFrameSize;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.peer.ComponentPeer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.RepaintManager;

public class SizedFrameTest {

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new SizedFrame();
				frame.setTitle("SizedFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
	}
}

class SizedFrame extends JFrame{
	public static boolean painted = false;
	
	public SizedFrame(){
		try{
			// get screen dimensions
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			
			// set frame width, height and let platform pick screen location
			setSize(screenWidth/2, screenHeight/2);
			setLocationByPlatform(true);
			
			// set frame icon
			Image img = new ImageIcon("bin/Chapter07_GraphicsProgramming/eg/white.png").getImage();
			setIconImage(img);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    public void reshape(int x, int y, int width, int height) {
    	painted = false;
    	System.out.println("reshape");
        if (isMinimumSizeSet()) {
            Dimension minSize = getMinimumSize();
            if (width < minSize.width) {
                width = minSize.width;
            }
            if (height < minSize.height) {
                height = minSize.height;
            }
        }
        super.reshape(x, y, width, height);
    }
	
    public void resize(int width, int height) {
    	painted = false;
    	System.out.println("resize");
    	super.resize(width, height);
    }
    
    public void reshape(){
    	
    }
	
    public void paint(Graphics g) {
    	if(!painted){
    		System.out.println("paint image");
    		painted = true;
        	Image img = new ImageIcon("bin/Chapter07_GraphicsProgramming/eg/IMG_0743.JPG").getImage();
        	int imageHeight = img.getHeight(null);
        	int imageWidth = img.getWidth(null);
        	System.out.println(imageHeight + ", " + imageWidth);
        	g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    	}else{
    		System.out.println("paint nothing");
    	}
    }
    
    public void repaint(long time, int x, int y, int width, int height) {
    	painted = false;
    	System.out.println("repaint");
    	super.repaint(time, x, y, width, height);
    	
    }
}