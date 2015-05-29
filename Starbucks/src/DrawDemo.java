import java.awt.Color;

import org.dalton.DaltonDraw;


public class DrawDemo {
	public static void main(String[] args) {
		DaltonDraw frame1 = new DaltonDraw();
		DaltonDraw frame2 = new DaltonDraw();
		
		frame1.drawImage("Blank Cup.jpg", 800, 800, 0, 0);
		frame2.drawImage("Decaf 1-2.jpg", 800, 800, 0, 0);
		//frame.drawString("Decaf 1-2", 800, 800, 30, Color.green);
		
		
		frame1.render();
		frame2.render();
		
	}
}
