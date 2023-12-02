

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

public class gmae extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    int bgColor = color(31, 0, 48);

    int value = 0;
    
    int x1 = 0;
    int y1 = 0;
    
    int brdx = 0;
    int brdy = 0;

    
    List<Rectangle> rects = new ArrayList<Rectangle>();
    
    @Override
    public void settings() {
    	size(WIDTH, HEIGHT);
    	
    	
    }

    @Override
    public void setup() {
        background(bgColor);

        noCursor();
        
        
    }

    @Override
    public void draw() {
        background(bgColor);
        
        rect(x1,y1,50,50);
        
        if (y1>=550) {
        	y1=550;
        }     
        if (y1<=0) {
        	y1=0;
        }
        if (x1>=750) {
        	x1=750;
        }
        if (x1<=0) {
        	x1=0;
        }
        
        
        
        brdx = 250;
        brdy = 250;
        rect(brdx,brdy,50,50);


    	
        	}
    	
    
    public void keyPressed() {
    	  if (key == CODED) {
    	    if (keyCode == UP) {
    	      y1-=50;
    	      if(x1==brdx && y1==brdy) {
    	    	  y1+=50;
    	      }
    	    } else if (keyCode == DOWN) {
    	      y1+=50;
    	      if(x1==brdx && y1==brdy) {
    	    	  y1-=50;
    	      }
    	    } else if (keyCode == LEFT) {
      	      x1-=50;
    	      if(x1==brdx && y1==brdy) {
    	    	  x1+=50;
    	      }
      	    } else if (keyCode == RIGHT) {
      	      x1+=50;
    	      if(x1==brdx && y1==brdy) {
    	    	  x1-=50;
    	      }
      	    } 

    	    
           
    	  }
    	  
    	}
        
    
    
    
    	
    	
    	
	
    
    static public void main(String[] passedArgs) {
        PApplet.main(gmae.class.getName());
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
