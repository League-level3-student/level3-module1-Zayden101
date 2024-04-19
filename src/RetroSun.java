

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

/*
 * Goal: Create an animated retro sun image!
 * 
 * Follow the inline instructions below. Open RetroSun.html in this folder to
 * see final image and what each step should look like.
 */

public class RetroSun extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
//    float y = WIDTH / 2;
//    float h = 40;
//    float x = 400 - 150;
//    float w = 2 * 150;

    
    // RGB colors
    int bgColor = color(0, 0, 0);

    List<Rectangle> rects = new ArrayList<Rectangle>();
    
    @Override
    public void settings() {
    	size(WIDTH, HEIGHT);
    	
    	
    }

    @Override
    public void setup() {
        // 2. Set bgColor as the background color
        background(bgColor);
        
    }

    @Override
    public void draw() {
        /*
         * PART 1: Drawing the sun
         */
        background(bgColor);


        fill(bgColor);
        stroke(0,0,0,0);
        
        for (Rectangle rct : rects) {
			rect(rct.x,rct.y,rct.w,rct.h);
		
	       		}
        
        
    }

    
    static public void main(String[] passedArgs) {
        PApplet.main(RetroSun.class.getName());
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
