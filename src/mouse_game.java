

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

public class mouse_game extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    //int bgColor = color(31, 0, 48);
    int bgColor = color(0, 0, 0);

    int x1;
    int y1;
    
    int mx = 0;
    int my = 0;
    
    int grav = 0;
    int grvy = 0;
    
    int lv3 = 0;
    
    int lv5 = 0;
    
    int upy = 0;
    
    int sc = 0;

    List<Rectangle> rects = new ArrayList<Rectangle>();
    
    @Override
    public void settings() {
    	size(WIDTH, HEIGHT);
    	
    	
    }

    @Override
    public void setup() {
        background(bgColor);

        noCursor();
        
    	x1 = new Random().nextInt(800);
    	y1 = new Random().nextInt(600);
        
    }

    @Override
    public void draw() {
        background(bgColor);
    	
        if(lv3==0) {
           ellipse(x1,y1,100,100);
        }else if(lv3==1) {
        	triangle(x1,y1,x1,y1+25,x1+15,y1+20);
    	}
        
        mx = mouseX;
        my = mouseY;
        
    	//triangle(100,100,100,125,115,120);
    	//triangle(mouseX,mouseY,mouseX,mouseY+25,mouseX+15,mouseY+20);

        //noStroke();
    	//ellipse(mouseX,mouseY,50,50);
       
    	if(sc==0) {
        	triangle(mouseX,mouseY,mouseX,mouseY+25,mouseX+15,mouseY+20);
            mx = mouseX;
            my = mouseY;

    	}

    	if(sc==1) {
        	triangle(mouseX,upy,mouseX,upy+25,mouseX+15,upy+20);
        	
        	//up
        	upy+=3;
        	
        	//down
        	if(mousePressed== true) {
        		upy-=6;
        	}
        	
        	
			//off screen prevention (Y)
        	if(upy>=575) {
        		upy=575;
        	}
        	if(upy<=0) {
        		upy=0;
        	}

        		
            mx = mouseX;
            my = upy;
    	}
    	
    	if(sc==2) {
        	triangle(mouseX,mouseY,mouseX,mouseY+25,mouseX+15,mouseY+20);
            mx = mouseX;
            my = mouseY;
            
            
            //random
            int c1;
        	c1 = new Random().nextInt(20);
        	
        	
        	//color switch
        	if(c1==5) {
                fill(255,255,255);
        	}else {
        		fill(0,0,0);
        	}
        	
    	}
    	
        	if(sc==3) {
  /*clean up*/  fill(255,255,255);

  
        		lv3=1;
            	ellipse(mouseX,mouseY,100,100);
                mx = mouseX;
                my = mouseY;

        	}
        	
        	if(sc==4) {
  /*clean up*/  lv3=0;

  
			triangle(mouseX,grvy,mouseX,grvy+25,mouseX+15,grvy+20);
			
			
			//gravity control
			if(grav==0) {
				grvy+=10;
			}
			if(grav==1) {
				grvy-=10;
			}
			
			
			
			//gravity control reset
			if(grav>=2) {
				grav=0;
			}
			
			
			//off screen prevention
			if(grvy>=575) {
				grvy=575;
			}
			if(grvy<=0) {
				grvy=0;
			}
			
			mx = mouseX;
			my = grvy;

        	}
    
        	if(sc==5) {

        		lv5=1;
            	triangle(mouseX,mouseY,mouseX,mouseY+25,mouseX+15,mouseY+20);
        		
        		mx = mouseX;
                my = mouseY;


                
        	}
    	
    }
    	
        
    
    
    
	public void mousePressed() {
		//System.out.println("clicked");
    	if(mx<=x1+50 && mx>=x1-50 && my<=y1+50 && my>=y1-50)  {
    		System.out.println("hit");
        	x1 = new Random().nextInt(800);
        	y1 = new Random().nextInt(600);
        	sc+=1;
    	}else {
    		System.out.println("miss");
    	}
    	
    	
    	//lv4 gravity switch
    	if(sc==4) {
			if(mousePressed==true) {
				grav+=1;
			}
    	}
    	
    	
    	
	}
    
    static public void main(String[] passedArgs) {
        PApplet.main(mouse_game.class.getName());
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
