import java.awt.Color;
import java.util.Iterator;



public class explo  {

	public static void main(String[] args) {
		//x:-240/+195     y:-120/+145
		//x:400			  y:280
		//88			  54

		int x = 160;
		int y = 160;
		y=235;
		y=310;
		y=385;
		//System.out.println(x + "   1");

		for (int i = 0; i < 9; i++) {
			//System.out.println(x + "   2");
			for (int j = 0; j < 88; j++) {
			System.out.println("rects.add(new ColorfulRectangle(" + x + "," + y + ", 5, 5, Color.BLACK));");
			//System.out.println("rects.add(new ColorfulRectangle(400+" + x + ",280+" + y + ", 5, 5, Color.BLACK));");
			x+=5;
			//System.out.println(x + "   3");
			}
		x = 160;
		y+=5;
		//System.out.println(y);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}





