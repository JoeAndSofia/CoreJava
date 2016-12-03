package Chapter07_GraphicsProgramming.Section03_PositioningAFrame.Part02_DeterminingAGoodFrameSize;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class GraphicsEnvironmentTest {
	
	public static void main(String[] args){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gdArr = ge.getScreenDevices();
		for(GraphicsDevice gd : gdArr){
			System.out.println(gd.getAvailableAcceleratedMemory());
			System.out.println("________________________________________");
			System.out.println(gd.getIDstring());
			System.out.println("________________________________________");
			System.out.println(gd.getType());
			System.out.println("________________________________________");
//			System.out.println(gd.getBestConfiguration(null));
			System.out.println("________________________________________");
			System.out.println(gd.getConfigurations());
			System.out.println("________________________________________");
			System.out.println(gd.getDefaultConfiguration());
			System.out.println("________________________________________");
			System.out.println(gd.getDisplayMode());
			System.out.println("________________________________________");
			System.out.println(gd.getDisplayModes());
		}
	}
	
}
