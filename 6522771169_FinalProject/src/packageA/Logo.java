package packageA;

import java.awt.*;
import javax.swing.*;


public class Logo extends JPanel{
	
	Logo(){
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		g.setFont(new Font("Times New Roman", Font.BOLD, 50));
		g.setColor(Color.BLACK);
		g.drawString("B", 130, 125);
		g.drawString("A", 130, 180);
		g.drawString("Y", 130, 240);
		
		g.setColor(new Color(0,200,0));
		g.fillRect(40, 130, 50, 70);
		
		g.setColor(new Color(0,250,0));
		int[] x = {40, 30, 20};
		int[] y = {130, 110, 120};
		g.fillPolygon(x, y, 3);
		int[] x2 = {100, 110, 90};
		int[] y2 = {110, 120, 130};
		g.fillPolygon(x2, y2, 3);
		int[] x4 = {90, 110, 100};
		int[] y4 = {200, 210, 220};
		g.fillPolygon(x4, y4, 3);
		int[] x6 = {40, 30, 20};
		int[] y6 = {200, 220, 210};
		g.fillPolygon(x6, y6, 3);
		
		g.setColor(new Color(0,115,0));
		int[] x1 = {30, 100, 90, 40};
		int[] y1 = {110, 110, 130, 130};
		g.fillPolygon(x1, y1, 4);
		int[] x3 = {90, 110, 110, 90};
		int[] y3 = {130, 120, 210, 200};
		g.fillPolygon(x3, y3, 4);
		int[] x5 = {90, 100, 30, 40};
		int[] y5 = {200, 220, 220, 200};
		g.fillPolygon(x5, y5, 4);
		int[] x7 = {40, 20, 20, 40};
		int[] y7 = {200, 210, 120, 130};
		g.fillPolygon(x7, y7, 4);
		
		g.setColor(new Color(163,143,133)); //latte
		g.fillOval(10,10,30,30);
			
	}
	
}