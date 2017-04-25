package VolumeI.Chapter07_GraphicsProgramming.Section06_UsingColor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class ColorPaintTest extends JFrame{

	private ColorCanvas cc = null;
	
	public static void main(String[] args){
		ColorPaintTest cpt = new ColorPaintTest();
		cpt.setTitle("ColorPaintTest");
		cpt.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cpt.setVisible(true);
	}
	
	public ColorPaintTest(){
		add(cc = new ColorCanvas());
		pack();
	}
	
	public void repaint(){
		int w = this.getWidth();
		int h = this.getHeight();
		System.out.println(w + ", " + h);
        this.cc.DEFAULT_WIDTH = w;
        this.cc.DEFAULT_HEIGHT = h;
		super.repaint();
	}
}

class ColorCanvas extends JComponent{
	public static int DEFAULT_WIDTH = 510;
	public static int DEFAULT_HEIGHT = 510;
	
	private static final int COLOR_SHIFT = 0;
	private static final int COLOR_BLOCK = 1;
	
	public void paintComponent(Graphics g){
		test01(g);
	}
	
	public void test01(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		System.out.println("paintComponent");
//		System.out.println(DEFAULT_WIDTH + ", " + DEFAULT_HEIGHT);
		int i = 0;
		for(int w = 0; w < DEFAULT_WIDTH ; w+=COLOR_BLOCK){
			for(int h = 0; h < DEFAULT_HEIGHT; h+=COLOR_BLOCK){
//				System.out.println(w+ ", " + h);
				int rd = (w + COLOR_SHIFT)%255;
				int gr = (h + COLOR_SHIFT)%255;
				Color c = new Color(rd,gr,(i+=COLOR_BLOCK)%150);
//				Color c = new Color(50,150,250);
				if(w>=255){
					c = c.darker().darker().darker();
				}
				if(h>=255){
					c = c.brighter().brighter().brighter();
//					c = c.darker().darker().darker();
				}
				
				g2.setPaint(c);
//				System.out.println(rd + ", " + gr + ", " + c.getBlue());
				g2.fill(new Rectangle(w,h,COLOR_BLOCK,COLOR_BLOCK));
			}
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
