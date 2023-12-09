

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.parser.Entity;

import processing.core.PApplet;


public class gmae extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    int bgColor = color(0, 0, 0);
    //int bgColor = color(31, 0, 48);

    int value = 0;
    
    int x1 = 0;
    int y1 = 0;
    
    int att = 0;
    int attx = 0;
    int atty = 0;
    
    int emlv = 0;
    
    int brdx = 0;
    int brdy = 0;

    Rectangle player = new Rectangle(0,0,50,50);
    
    List<Rectangle> rects = new ArrayList<Rectangle>();
    
    Rectangle enemy = new Rectangle(500,500,50,50);

    //List<Rectangle> enemy = new ArrayList<Rectangle>();

    
    @Override
    public void settings() {
    	size(WIDTH, HEIGHT);
    	
    	
    }

    @Override
    public void setup() {
        background(bgColor);

        noCursor();
        
        rects.add(new Rectangle(0, 250, 50, 50 ));
        rects.add(new Rectangle(50, 250, 50, 50 ));
        rects.add(new Rectangle(100, 250, 50, 50 ));
        rects.add(new Rectangle(150, 250, 50, 50 ));
        rects.add(new Rectangle(200, 250, 50, 50 ));
        rects.add(new Rectangle(250, 250, 50, 50 ));
        rects.add(new Rectangle(300, 250, 50, 50 ));
        rects.add(new Rectangle(350, 250, 50, 50 ));
        rects.add(new Rectangle(400, 250, 50, 50 ));

        rects.add(new Rectangle(400, 200, 50, 50 ));
        rects.add(new Rectangle(400, 150, 50, 50 ));
        rects.add(new Rectangle(400, 100, 50, 50 ));
        
        rects.add(new Rectangle(200, 0, 50, 50 ));
        rects.add(new Rectangle(200, 50, 50, 50 ));
        rects.add(new Rectangle(200, 100, 50, 50 ));
        
        rects.add(new Rectangle(200, 550, 50, 50 ));
        rects.add(new Rectangle(200, 500, 50, 50 ));
        rects.add(new Rectangle(200, 400, 50, 50 ));
        rects.add(new Rectangle(200, 350, 50, 50 ));
        rects.add(new Rectangle(200, 300, 50, 50 ));


    	//fill(255,0,0);
        //enemy.add(new Rectangle(500, 500, 50, 50 ));
    	//fill(255,255,255);
        
        
        emlv = 1;

    }

    @Override
    public void draw() {
        background(bgColor);
        
     //   rect(x1,y1,50,50);
        
        
        //Attack
//        if(att==1) {
//        	attx = player.x-50;
//        	atty = player.y-50;
//        	
//        	fill(0,0,255);
//        	rect(player.x-50, player.y-50, 150, 150);
//        	fill(255,255,255);
//        	att=0;
//        }
        	
        	
        	//if enemy adjacent to player, remove enemy from List.
        	//player.
        
        
    	/*
    	 fill(255,0,0);
    	 
        for(Rectangle r: enemy) {    // Draw all the enemy rects
        	rect(r.x,r.y,r.width,r.height);
        }
    	fill(255,255,255);
		*/


        //Enemy
        if(emlv==1) {
        fill(255,0,0);
        rect(enemy.x, enemy.y, enemy.width, enemy.height   ); // Draw enemy
    	fill(255,255,255);
        }else if(emlv==0) {
        fill(0,0,0);
        rect(enemy.x, enemy.y, enemy.width, enemy.height   ); // Draw enemy
        fill(255,255,255);
        }
        
        //rect(enemy.x, enemy.y, enemy.width, enemy.height   ); // Draw enemy
        
        if(att==1) {        	
        if(50 == Math.abs(player.x-enemy.x) && 50 == Math.abs(player.y-enemy.y)){
        	//System.out.println("dead");
        	emlv=0;
        }
        if( (50 == Math.abs(player.x-enemy.x) && player.y == enemy.y) ||
        	((50 == Math.abs(player.y-enemy.y) && player.x == enemy.x)) ){
        	//System.out.println("dead");
        	emlv=0;
        }
        }
        
        
        if(att==1) {
        	attx = player.x-50;
        	atty = player.y-50;
        	
        	fill(0,0,255);
        	rect(player.x-50, player.y-50, 150, 150);
        	fill(255,255,255);
        	att=0;
        }
        
        rect(player.x, player.y, player.width, player.height   ); // Draw player
        
        
        if (player.y>=550) {
        	player.y=550;
        }     
        if (player.y<=0) {
        	player.y=0;
        }
        if (player.x>=750) {
        	player.x=750;
        }
        if (player.x<=0) {
        	player.x=0;
        }
        
        
        for(Rectangle r: rects) {    // Draw all the blocking rects
        	rect(r.x,r.y,r.width,r.height);
        }
        
        
//        brdx = 250;
//        brdy = 250;
//        rect(brdx,brdy,50,50);


    	
        	}
    	
    boolean playerInterectsBlock() {
    	
    	for(Rectangle r: rects) {
    		if( r.intersects(player)){
    			return true;
    		}
    	}
    	
    	
    	return false;
    }
    
    
    
    
    public void keyPressed() {
    	  if (key == CODED) {
    	    if (keyCode == UP) {
    	    	player.y-=50;
    	    	
    	    // if player Rectangle intersects with any of those in the list, move him back	
    	    	if(playerInterectsBlock()) {
    	    		player.y+=50;
    	    	}
//    	      if(x1==brdx && y1==brdy) {
//    	    	  y1+=50;
//    	      }
    	    } else if (keyCode == DOWN) {
    	    	player.y+=50;
    	      if(playerInterectsBlock()) {
    	    	  player.y-=50;
    	      }
    	    } else if (keyCode == LEFT) {
    	    	player.x-=50;
    	      if(playerInterectsBlock()) {
    	    	  player.x+=50;
    	      }
      	    } else if (keyCode == RIGHT) {
      	    	player.x+=50;
    	      if(playerInterectsBlock()) {
    	    	  player.x-=50;
    	      }
    	    } else if (keyCode == SHIFT) {
    	    	att=1;
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
//    class Rectangle {
//        float x, y, w, h;
//
//        Rectangle(float x, float y, float w, float h) {
//            this.x = x;
//            this.y = y;
//            this.w = w;
//            this.h = h;
//        }
//    }
    
}
