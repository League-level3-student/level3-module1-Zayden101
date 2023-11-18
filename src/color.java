

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;

/*
 * Goal: Create an animated retro sun image!
 * 
 * Follow the inline instructions below. Open RetroSun.html in this folder to
 * see final image and what each step should look like.
 */

public class color extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    //int a = 100;
    int a = 255;

	int c1 = 255;
    int c2 = 255;
    int c3 = 255;
    
    int m1=255;
    int m2=255;
    int m3=255;
    
    int mm1=255;
    int mm2=255;
    int mm3=255;
    
    int bgColor = color(31, 0, 48);


    List<Rectangle> rects = new ArrayList<Rectangle>();
    
    @Override
    public void settings() {
    	size(WIDTH, HEIGHT);
    	
    	
    }

    @Override
    public void setup() {
        // 2. Set bgColor as the background color
        background(bgColor);

    	mm1 = new Random().nextInt(30);
    	mm2 = new Random().nextInt(30);
    	mm3 = new Random().nextInt(30);

        
    }

    @Override
    public void draw() {





    	
if(mousePressed==true) {



c1-=5;
c2-=5;
c3-=5;

			noStroke();
			///////////////////////////////////////////////////a-=1;
			fill(c1,c2,c3,a);
			ellipse(mouseX,mouseY,100,100);
			//System.out.println(a);
			//System.out.println(c1 + c2 + c3);
			System.out.println(c1 +" " + c2 +" "+ c3);

		}

		if(a<=0) {
			a=100;
			//background(bgColor);
		}
		
		if(c1<=0 && c2<=0 && c3<=0) {
			
			m1-=mm1*2;
			m2-=mm2*2;
			m3-=mm3*2;
			
			c1=m1;
			c2=m2;
			c3=m3;
		
	    	//c1 = new Random().nextInt(255);
	    	//c2 = new Random().nextInt(255);
	    	//c3 = new Random().nextInt(255);
	    	
		}

if(m1<=0 || m2<=0 || m3<=0) {
		

	
	mm1 = new Random().nextInt(30);
	mm2 = new Random().nextInt(30);
	mm3 = new Random().nextInt(30);


	
			m1=255;
			m2=255;
			m3=255;
		}

}
        
    

    
    
	public void mousePressed() {
		//System.out.println("clicked");
		//System.out.println(a);
	}
    
    static public void main(String[] passedArgs) {
        PApplet.main(color.class.getName());
    }

    /*********************** DO NOT MODIFY THE CODE BELOW ********************/

    // Placed here so it can be used by all classes
    // Variable step should be between 0 and 1, inclusive
    int interpolateColor(int[] arr, float step) {
        int sz = arr.length;

        if (sz == 1 || step <= 0.0) {
            return arr[0];
        } else if (step >= 1.0) {
            return arr[sz - 1];
        }

        float scl = step * (sz - 1);
        int i = (int) scl;

        return lerpColor(arr[i], arr[i + 1], scl - i);
    }

    // Feel free to use this class to create a list of missing
    // sections in the sun, for example:
    // ArrayList<Rectangle> sections = new ArrayList<Rectangle>();
    class Rectangle {
        float x, y, w, h;

        Rectangle(float x, float y, float w, float h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }
    
}
