

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.text.html.parser.Entity;

import processing.core.PApplet;


//*DONE* WORK ON REMOVING LOCKED DOOR
//WORK ON BULLET TRAIL




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

	int emliv = 0;     //enemy alive
	int emliv2 = 0;     //enemy2 alive

	int lv2_setup = 0;

	int gol = 0;	//goal

	int brdx = 0;
	int brdy = 0;

	int doorlocked = 0;

	int facing;

	int shoot;

	int skip;
	
	int level = 1;
	
	int numOfKeys = 0;
	int goalOfKeys = 1;
	
	int numOfEnemy = 0;
	int goalOfEnemy = 0;


	Rectangle player = new Rectangle(0,0,50,50);

	List<Rectangle> rects = new ArrayList<Rectangle>();


	Rectangle enemy = new Rectangle(500,500,50,50);
	Rectangle enemy2 = new Rectangle(-50,-50,50,50);

	Rectangle goal = new Rectangle(0,500,50,50);

	Rectangle doorkey = new Rectangle(550,200,50,50);
	Rectangle doorkey2 = new Rectangle(550,200,50,50);

	Rectangle door1, door2;

	Rectangle bullet;
	Rectangle btv1, btv2;    //bullet trail vertical
	Rectangle bth1, bth2;    //bullet trail horizontal
	private boolean addlevel1Rects = true;
	private boolean addlevel2Rects = true;
	private boolean isLevel2Setup = false;



	//List<Rectangle> enemy = new ArrayList<Rectangle>();


	@Override
	public void settings() {
		size(WIDTH, HEIGHT);


	}

	@Override
	public void setup() {
		background(bgColor);

		noCursor();

		level1Rects();

		goalOfKeys = 1;
		goalOfEnemy = 1;


		bullet = new Rectangle(player.x, player.y, 50, 50);

		btv1 = new Rectangle(player.x+12, player.y, 25, 50);
		btv2 = new Rectangle(player.x+12, player.y, 25, 50);

		bth1 = new Rectangle(player.x, player.y-12, 50, 25);
		bth2 = new Rectangle(player.x, player.y-12, 50, 25);


		rects.add(door1);
		rects.add(door2);
		rects.add(bullet);

		rects.add(btv1);
		rects.add(btv2);
		rects.add(bth1);
		rects.add(bth2);


		//fill(255,0,0);
		//enemy.add(new Rectangle(500, 500, 50, 50 ));
		//fill(255,255,255);


		emliv = 1;
		emliv2 = 1;

		doorkey2.x=-50;
	}

	@Override
	public void draw() {
		background(bgColor);

		//   rect(x1,y1,50,50);

//		if(level==1) {
//			if(addlevel1Rects) {
//				level1Rects();
//				addlevel1Rects = false;
//			}
//		}

		if(level==2 && !isLevel2Setup) {

			rects.removeAll(rects);

			level2Rects();
			
			//door1 = new Rectangle(650, 250, 50, 50 );
			//door2 = new Rectangle(663, 263, 25, 25 );
		}


		//System.out.println(level);


		//System.out.println(numOfEnemy + "   " + goalOfEnemy);
		//System.out.println(doorlocked);
		//System.out.println(numOfKeys + "   " + goalOfKeys);

		
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
		if(emliv==1) {
			fill(255,0,0);
			rect(enemy.x, enemy.y, enemy.width, enemy.height); // Draw enemy
			fill(255,255,255);
		}else if(emliv==0) {
			fill(0,0,0);
			rect(enemy.x, enemy.y, enemy.width, enemy.height); // Draw enemy
			fill(255,255,255);
		}
		
		if(emliv2==1) {
			fill(255,0,0);
			rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
			fill(255,255,255);
		}else if(emliv2==0) {
			fill(0,0,0);
			rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
			fill(255,255,255);
		}
		
		if(numOfEnemy==goalOfEnemy) {
			gol=1;
		}


		//door key
		if (doorlocked==0) {
			fill(255,255,0);
			rect(doorkey.x, doorkey.y, doorkey.width, doorkey.height); // Draw key
			fill(255,255,255);
			
			fill(255,255,0);
			rect(doorkey2.x, doorkey2.y, doorkey2.width, doorkey2.height); // Draw key
			fill(255,255,255);
		}else {
//			fill(0,0,0);
//			rect(doorkey.x, doorkey.y, doorkey.width, doorkey.height); // Draw key
//			fill(255,255,255);
		}

		if(player.x==doorkey.x && player.y==doorkey.y) {
			doorkey.x=-50;
			doorkey.y=-50;
			numOfKeys+=1;
		}
		
		if(player.x==doorkey2.x && player.y==doorkey2.y) {
			doorkey2.x=-50;
			doorkey2.y=-50;
			numOfKeys+=1;
		}

		if(numOfKeys==goalOfKeys) {
		doorlocked=1;
		}

		//door
		//System.out.println(doorlocked);
		if(doorlocked==1) {
			rects.remove(door1);
			rects.remove(door2);
		}

		

		bullet.x=player.x;
		bullet.y=player.y;

		bth1.x=player.x;
		bth1.y=player.y+12;
		bth2.x=player.x;
		bth2.y=player.y+12;

		btv1.x=player.x+12;
		btv1.y=player.y;
		btv2.x=player.x+12;
		btv2.y=player.y;

		rects.remove(bth1);
		rects.remove(bth2);
		rects.remove(btv1);
		rects.remove(btv2);


		if(shoot==1) {
			//for (int i = 0; i < 3; i++) {

			if(facing==1) {
				rects.add(btv1);
				rects.add(btv2);
				bullet.y-=150;
				btv1.y-=50;
				btv2.y-=100;
			}
			if(facing==2) {
				rects.add(bth1);
				rects.add(bth2);
				bullet.x-=150;
				bth1.x-=50;
				bth2.x-=100;
			}
			if(facing==3) {
				rects.add(btv1);
				rects.add(btv2);
				bullet.y+=150;
				btv1.y+=50;
				btv2.y+=100;
			}
			if(facing==4) {
				rects.add(bth1);
				rects.add(bth2);
				bullet.x+=150;
				bth1.x+=50;
				bth2.x+=100;
			}
			//System.out.println(bullet.x + " " + bullet.y + "  " + facing);
		}

		shoot=0;
		//}

		//System.out.println(facing);

		if(bullet.x==enemy.x && bullet.y==enemy.y) {
			if(emliv==1) {
			numOfEnemy+=1;
			}
			emliv=0;
		}

		if(bullet.x==enemy2.x && bullet.y==enemy2.y) {
			if(emliv2==1) {
			numOfEnemy+=1;
			}
			emliv2=0;
		}

		//		if (btv1.x==enemy.x && btv1.y==enemy.y || btv2.x==enemy.x && btv2.y==enemy.y || bth1.x==enemy.x && bth1.y==enemy.y || bth2.x==enemy.x && bth2.y==enemy.y){
		//			emliv=0;
		//		}



		//rect(enemy.x, enemy.y, enemy.width, enemy.height   ); // Draw enemy

		//Kill enemy
		if(att==1) {        	
			if(50 == Math.abs(player.x-enemy.x) && 50 == Math.abs(player.y-enemy.y)){
				//System.out.println("dead");
				if(emliv==1) {
					numOfEnemy+=1;
					}
					emliv=0;
			}
			if( (50 == Math.abs(player.x-enemy.x) && player.y == enemy.y) ||
					((50 == Math.abs(player.y-enemy.y) && player.x == enemy.x)) ){
				//System.out.println("dead");
				if(emliv==1) {
					numOfEnemy+=1;
					}
					emliv=0;
			}
			if(50 == Math.abs(player.x-enemy2.x) && 50 == Math.abs(player.y-enemy2.y)){
				//System.out.println("dead");
				if(emliv2==1) {
					numOfEnemy+=1;
					}
					emliv2=0;
			}
			if( (50 == Math.abs(player.x-enemy2.x) && player.y == enemy2.y) ||
					((50 == Math.abs(player.y-enemy2.y) && player.x == enemy2.x)) ){
				//System.out.println("dead");
				if(emliv2==1) {
					numOfEnemy+=1;
					}
					emliv2=0;
			}

		}

		//		if(shoot==1) {        	
		//		if(bullet.x==enemy.x && bullet.y==enemy.y){
		//			emliv=0;
		//			}
		//		}

		//Attack
		if(att==1) {
			attx = player.x-50;
			atty = player.y-50;

			fill(0,0,255);
			rect(player.x-50, player.y-50, 150, 150);
			fill(255,255,255);
			att=0;
		}

		rect(player.x, player.y, player.width, player.height); // Draw player

		if(gol==0) {

		}else if(gol==1) {
			fill(0,255,0);
			rect(goal.x, goal.y, goal.width, goal.height); // Draw goal
			fill(255,255,255);
		}

		if(player.x==goal.x && player.y==goal.y && gol==1) {
			//			System.out.println("you win");
			//			System.exit(0);
			level=2;

		}

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


		for(Rectangle r : rects) {
			rect(r.x, r.y, r.width, r.height);
		}
		rect(bullet.x, bullet.y, 50 , 50);


		//        brdx = 250;
		//        brdy = 250;
		//        rect(brdx,brdy,50,50);

		if(skip==1) {
			if(level==1);
			level=2;
			player.x=0;
			player.y=500;
		}
		skip=0;

	}

	private void level1Rects() {
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

		rects.add(new Rectangle(450, 250, 50, 50 ));
		rects.add(new Rectangle(500, 250, 50, 50 ));
		rects.add(new Rectangle(550, 250, 50, 50 ));
		rects.add(new Rectangle(600, 250, 50, 50 ));
		rects.add(new Rectangle(700, 250, 50, 50 ));
		rects.add(new Rectangle(750, 250, 50, 50 ));
		rects.add(new Rectangle(600, 200, 50, 50 ));
		rects.add(new Rectangle(600, 150, 50, 50 ));
		rects.add(new Rectangle(650, 150, 50, 50 ));
		rects.add(new Rectangle(500, 50, 50, 50 ));
		rects.add(new Rectangle(500, 100, 50, 50 ));
		rects.add(new Rectangle(500, 150, 50, 50 ));
		rects.add(new Rectangle(600, 50, 50, 50 ));
		rects.add(new Rectangle(550, 150, 50, 50 ));
		rects.add(new Rectangle(700, 50, 50, 50 ));
		rects.add(new Rectangle(600, 0, 50, 50 ));
		rects.add(new Rectangle(700, 100, 50, 50 ));
		rects.add(new Rectangle(700, 150, 50, 50 ));
		rects.add(new Rectangle(400, 0, 50, 50 ));
		rects.add(new Rectangle(300, 50, 50, 50 ));
		rects.add(new Rectangle(300, 100, 50, 50 ));
		rects.add(new Rectangle(300, 150, 50, 50 ));
		rects.add(new Rectangle(350, 100, 50, 50 ));

		door1 = new Rectangle(650, 250, 50, 50 );
		door2 = new Rectangle(663, 263, 25, 25 );
	}

	private void level2Rects() {
		
		if(lv2_setup==0) {
		emliv = 1;
		emliv2 = 1;

		enemy.x=300;
		enemy.y=350;
		
		enemy2.x=500;	
		enemy2.y=250;
		
		lv2_setup = 1;
		
		doorlocked = 0;
		
		gol = 0;
		
		goal.x=0;
		goal.y=100;
		
		numOfEnemy = 0;
		goalOfEnemy = 2;

		numOfKeys = 0;
		goalOfKeys = 2;
		
		rects.add(door1);
		rects.add(door2);
		
		door1.x=500;
		door1.y=0;
		door2.x=513;
		door2.y=13;

		doorkey.x=550;
		doorkey.y=200;
		
		doorkey2.x=0;
		doorkey2.y=300;

		}
		
		
		rects.add(new Rectangle(350, 500, 50, 50 ));
		rects.add(new Rectangle(150, 550, 50, 50 ));
		
		rects.add(new Rectangle(150, 500, 50, 50 ));
		rects.add(new Rectangle(150, 450, 50, 50 ));
		rects.add(new Rectangle(0, 400, 50, 50 ));
		rects.add(new Rectangle(50, 400, 50, 50 ));
		rects.add(new Rectangle(50, 350, 50, 50 ));
		rects.add(new Rectangle(100, 350, 50, 50 ));
		rects.add(new Rectangle(150, 350, 50, 50 ));
		rects.add(new Rectangle(200, 350, 50, 50 ));
		rects.add(new Rectangle(250, 350, 50, 50 ));
		rects.add(new Rectangle(250, 400, 50, 50 ));
		rects.add(new Rectangle(250, 450, 50, 50 ));
		rects.add(new Rectangle(250, 500, 50, 50 ));
		rects.add(new Rectangle(450, 550, 50, 50 ));
		rects.add(new Rectangle(450, 500, 50, 50 ));
		rects.add(new Rectangle(500, 500, 50, 50 ));
		rects.add(new Rectangle(300, 400, 50, 50 ));
		rects.add(new Rectangle(350, 400, 50, 50 ));
		rects.add(new Rectangle(400, 400, 50, 50 ));
		rects.add(new Rectangle(450, 400, 50, 50 ));
		rects.add(new Rectangle(500, 400, 50, 50 ));

		rects.add(new Rectangle(550, 400, 50, 50 ));
		rects.add(new Rectangle(550, 350, 50, 50 ));
		rects.add(new Rectangle(650, 400, 50, 50 ));
		rects.add(new Rectangle(700, 400, 50, 50 ));
		rects.add(new Rectangle(700, 450, 50, 50 ));

		rects.add(new Rectangle(600, 500, 50, 50 ));
		rects.add(new Rectangle(600, 550, 50, 50 ));
		rects.add(new Rectangle(700, 550, 50, 50 ));
		
		rects.add(new Rectangle(550, 350, 50, 50 ));
		rects.add(new Rectangle(550, 300, 50, 50 ));
		
		rects.add(new Rectangle(700, 350, 50, 50 ));
		rects.add(new Rectangle(700, 300, 50, 50 ));
		rects.add(new Rectangle(700, 250, 50, 50 ));
		rects.add(new Rectangle(700, 200, 50, 50 ));
		rects.add(new Rectangle(700, 150, 50, 50 ));
		rects.add(new Rectangle(700, 100, 50, 50 ));
		rects.add(new Rectangle(700, 50, 50, 50 ));
		rects.add(new Rectangle(650, 50, 50, 50 ));
		rects.add(new Rectangle(600, 50, 50, 50 ));
		rects.add(new Rectangle(550, 50, 50, 50 ));
		rects.add(new Rectangle(500, 50, 50, 50 ));
		rects.add(new Rectangle(450, 50, 50, 50 ));
		rects.add(new Rectangle(400, 50, 50, 50 ));
		rects.add(new Rectangle(400, 100, 50, 50 ));
		rects.add(new Rectangle(350, 100, 50, 50 ));
		rects.add(new Rectangle(350, 150, 50, 50 ));
		rects.add(new Rectangle(350, 200, 50, 50 ));
		rects.add(new Rectangle(350, 300, 50, 50 ));
		rects.add(new Rectangle(350, 350, 50, 50 ));
		
		rects.add(new Rectangle(300, 200, 50, 50 ));
		rects.add(new Rectangle(250, 200, 50, 50 ));
		rects.add(new Rectangle(250, 250, 50, 50 ));
		rects.add(new Rectangle(200, 250, 50, 50 ));
		rects.add(new Rectangle(150, 250, 50, 50 ));
		rects.add(new Rectangle(100, 250, 50, 50 ));
		rects.add(new Rectangle(50, 250, 50, 50 ));
		rects.add(new Rectangle(0, 250, 50, 50 ));

		rects.add(new Rectangle(600, 300, 50, 50 ));

		rects.add(new Rectangle(600, 200, 50, 50 ));
		rects.add(new Rectangle(600, 250, 50, 50 ));
		rects.add(new Rectangle(600, 150, 50, 50 ));
		rects.add(new Rectangle(550, 150, 50, 50 ));
		rects.add(new Rectangle(500, 150, 50, 50 ));
		rects.add(new Rectangle(500, 200, 50, 50 ));
		rects.add(new Rectangle(450, 200, 50, 50 ));
		rects.add(new Rectangle(450, 250, 50, 50 ));
		rects.add(new Rectangle(450, 300, 50, 50 ));
		
		rects.add(new Rectangle(250, 0, 50, 50 ));
		rects.add(new Rectangle(250, 50, 50, 50 ));
		rects.add(new Rectangle(250, 100, 50, 50 ));
		rects.add(new Rectangle(200, 100, 50, 50 ));
		rects.add(new Rectangle(150, 100, 50, 50 ));
		rects.add(new Rectangle(150, 50, 50, 50 ));
		rects.add(new Rectangle(150, 200, 50, 50 ));
		rects.add(new Rectangle(0, 200, 50, 50 ));
		rects.add(new Rectangle(0, 150, 50, 50 ));
		rects.add(new Rectangle(50, 150, 50, 50 ));
		rects.add(new Rectangle(50, 100, 50, 50 ));
		rects.add(new Rectangle(50, 50, 50, 50 ));


		rects.add(new Rectangle(300, 0, 50, 50 ));


		isLevel2Setup  = true;
	}

	boolean playerInterectsBlock() {

		for(Rectangle r: rects) {

			if(r!=bullet && r!=btv1 && r!=btv2 && r!=bth1 && r!=bth2) {
				if( r.intersects(player)){
					return true;
				}
			}
		}


		return false;
	}




	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				player.y-=50;
				facing=1;
				// if player Rectangle intersects with any of those in the list, move him back	
				if(playerInterectsBlock()) {
					player.y+=50;
				}
				//    	      if(x1==brdx && y1==brdy) {
				//    	    	  y1+=50;
				//    	      }
			} else if (keyCode == DOWN) {
				player.y+=50;
				facing=3;
				if(playerInterectsBlock()) {
					player.y-=50;
				}
			} else if (keyCode == LEFT) {
				player.x-=50;
				facing=2;
				if(playerInterectsBlock()) {
					player.x+=50;
				}
			} else if (keyCode == RIGHT) {
				player.x+=50;
				facing=4;
				if(playerInterectsBlock()) {
					player.x-=50;
				}
			} else if (keyCode == SHIFT) {
				att=1;
			} else if (keyCode == ALT) {
				shoot=1;
			} else if (keyCode == CONTROL) {
				skip=1;
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
