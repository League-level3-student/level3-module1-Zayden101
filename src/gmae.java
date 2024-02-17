

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.text.html.parser.Entity;

import processing.core.PApplet;


//*DONE* WORK ON REMOVING LOCKED DOOR
//*NVM* WORK ON BULLET TRAIL
//WORK ON LV 3
// FIX
/*		if(numOfEnemy==goalOfEnemy) {
rects.remove(enmdoor1);
rects.remove(enmdoor2);
}*/


WORK ON NOT MOVING ALL THE WAY WHEN TOUCHING BLOCK, SO YOU CAN NOT BE ALINGED



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

	boolean emliv = false;     //enemy alive
	boolean emliv2 = false;     //enemy2 alive
	boolean emliv3 = false;     //enemy2 alive


	boolean lv2_setup = true;
	boolean lv3_setup = true;
	boolean lv4_setup = true;
	boolean lv5_setup = true;
	boolean lv6_setup = true;


	int gol = 0;	//goal

	int brdx = 0;
	int brdy = 0;

	boolean yeldoorlocked = true;
	boolean purdoorlocked = true;
	boolean oradoorlocked = true;
	boolean cyadoorlocked = true;
	boolean enmdoorlocked = true;

	
	int facing;

	int shoot;

	int level = 1;

	int numOfKeys = 0;
	int goalOfKeys = 1;

	int numOfEnemy = 0;
	int goalOfEnemy = 0;
	
	


	ColorfulRectangle player = new ColorfulRectangle(0,0,50,50,Color.BLUE);

	List<Rectangle> rects = new ArrayList<Rectangle>();

	ColorfulRectangle enemy = new ColorfulRectangle(500,500,50,50,Color.RED);
	ColorfulRectangle enemy2 = new ColorfulRectangle(-50,-50,50,50, Color.RED);
	ColorfulRectangle enemy3 = new ColorfulRectangle(-50,-50,50,50, Color.RED);

	
	ColorfulRectangle goal = new ColorfulRectangle(0,500,50,50, Color.GREEN);

	ColorfulRectangle yeldoorkey = new ColorfulRectangle(550,200,50,50,Color.YELLOW);
	ColorfulRectangle purdoorkey = new ColorfulRectangle(-50,-50,50,50,Color.MAGENTA);
	ColorfulRectangle oradoorkey = new ColorfulRectangle(-50,-50,50,50,Color.ORANGE);
	ColorfulRectangle cyadoorkey = new ColorfulRectangle(-50,-50,50,50,Color.CYAN);

	ColorfulRectangle yeldoorkey2cuzidontwanttofixthefirstone = new ColorfulRectangle(-50,-50,50,50,Color.YELLOW);


	ColorfulRectangle yeldoor1 = new ColorfulRectangle(550,200,50,50,Color.WHITE);
	ColorfulRectangle yeldoor2 = new ColorfulRectangle(550,200,25,25,Color.YELLOW);
	ColorfulRectangle purdoor1 = new ColorfulRectangle(-50,-50,50,50,Color.WHITE);
	ColorfulRectangle purdoor2 = new ColorfulRectangle(-50,-50,25,25,Color.MAGENTA);
	ColorfulRectangle oradoor1 = new ColorfulRectangle(-50,-50,50,50,Color.WHITE);
	ColorfulRectangle oradoor2 = new ColorfulRectangle(-50,-50,25,25,Color.ORANGE);
	ColorfulRectangle cyadoor1 = new ColorfulRectangle(-50,-50,50,50,Color.WHITE);
	ColorfulRectangle cyadoor2 = new ColorfulRectangle(-50,-50,25,25,Color.CYAN);
	ColorfulRectangle enmdoor1 = new ColorfulRectangle(-50,-50,50,50,Color.WHITE);
	ColorfulRectangle enmdoor2 = new ColorfulRectangle(-50,-50,25,25,Color.RED);

	ColorfulRectangle tp1 = new ColorfulRectangle(-50,-50,50,50,Color.PINK);
	ColorfulRectangle tp2 = new ColorfulRectangle(-50,-50,50,50,Color.PINK);

	boolean canTp = true;

	ColorfulRectangle bullet;
	ColorfulRectangle btv1, btv2;    //bullet trail vertical
	ColorfulRectangle bth1, bth2;    //bullet trail horizontal
	//private boolean addlevel1Rects = true;
	//private boolean addlevel2Rects = true;
	private boolean isLevel2Setup = false;
	private boolean isLevel3Setup = false;
	private boolean isLevel4Setup = false;
	private boolean isLevel5Setup = false;
	private boolean isLevel6Setup = false;

	
	
	int skip;

	int playerposX = 0;
	int playerposY = 0;

	boolean devmode = false;

	boolean outline = false;


	//List<Rectangle> enemy = new ArrayList<Rectangle>();


	@Override
	public void settings() {
		size(WIDTH, HEIGHT);

		/*
		level = 5;
		player.x=750;
		player.y=550;
		*/
		
	}


	@Override
	public void setup() {
		
		int marker;

		
		//JOptionPane.showMessageDialog(null, "Arrow keys to move \n*Shift* to surround attack \n*Alt* to shoot bullet (shoots through walls cuz im too lazy to fix it)");
		
		background(bgColor);

		//noCursor();

		level1Rects();

		goalOfKeys = 1;
		goalOfEnemy = 1;


		bullet = new ColorfulRectangle(player.x, player.y, 50, 49, Color.BLUE);

		btv1 = new ColorfulRectangle(player.x+12, player.y, 25, 50, Color.BLUE);
		btv2 = new ColorfulRectangle(player.x+12, player.y, 25, 50, Color.BLUE);

		bth1 = new ColorfulRectangle(player.x, player.y-12, 50, 25, Color.BLUE);
		bth2 = new ColorfulRectangle(player.x, player.y-12, 50, 25, Color.BLUE);

		
		if(outline==true) {
		level=5;
		player.x=750;
		player.y=550;
		}
		

		//rects.add(door3);
		rects.add(bullet);

		rects.add(btv1);
		rects.add(btv2);
		rects.add(bth1);
		rects.add(bth2);


		//fill(255,0,0);
		//enemy.add(new Rectangle(500, 500, 50, 50 ));
		//fill(255,255,255);


		emliv = true;
		emliv2 = true;

		purdoorkey.x=-50;
	}

	@Override
	public void draw() {
		background(bgColor);

		int marker;
		
		if(outline==true) {
		noStroke();
		rects.add(new ColorfulRectangle(0, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(50, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(100, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(150, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(200, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(250, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(300, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(350, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(400, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(450, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(500, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(550, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(600, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(650, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(700, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(750, 0, 1, 600, Color.WHITE));
		rects.add(new ColorfulRectangle(800, 0, 1, 600, Color.WHITE));

		rects.add(new ColorfulRectangle(0, 0, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 50, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 100, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 150, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 200, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 250, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 300, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 350, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 400, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 450, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 500, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 550, 800, 1, Color.WHITE));
		rects.add(new ColorfulRectangle(0, 600, 800, 1, Color.WHITE));
		}
		

		//stroke();
		

		
		for(Rectangle r : rects) {
			if(r instanceof ColorfulRectangle) {
				((ColorfulRectangle) r).draw();
			}else {
				rect(r.x, r.y, r.width, r.height);
			}
		}

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

			//yeldoor1 = new Rectangle(650, 250, 50, 50 );
			//yeldoor2 = new Rectangle(663, 263, 25, 25 );
		}

		if(level==3 && !isLevel3Setup) {

			rects.removeAll(rects);

			level3Rects();
		}
		
		if(level==4 && !isLevel4Setup) {

			rects.removeAll(rects);

			level4Rects();
		}
		
		if(level==5 && !isLevel5Setup) {

			rects.removeAll(rects);

			level5Rects();
		}

		if(level==6 && !isLevel6Setup) {

			rects.removeAll(rects);

			level6Rects();
		}

		//System.out.println(level);

		
		
		
		
		
		
		/*
		(WALLS)		Color.WHITE
		(PLAYER)	Color.BLUE
		(KEY)		Color.CYAN
					Color.DARK_GRAY
					Color.GRAY
		(GOAL)		Color.GREEN
					Color.LIGHT_GRAY
		(KEY)		Color.MAGENTA
		(Key)		Color.ORANGE
		(TP)		Color.PINK
		(ENEMY)		Color.RED
		(KEY)		Color.YELLOW
					Color.BLACK
		 */

		
		
		//if(player.x!=tp1.x && player.y!=tp1.y){
		//	System.out.println("player=tp1");
		//}
		/*if(player.x==tp1.x && player.y==tp1.y) {
			System.out.println("touching tp1");
		}
		if(player.x==tp2.x && player.y==tp2.y) {
			System.out.println("touching tp2");
		}*/
		 
		
		
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


		
		
		
		
		/*if(player.x!=tp1.x && player.y!=tp1.y){
			System.out.println("player!=tp1");
		}
		if(player.x!=tp2.x && player.y!=tp2.y){
			System.out.println("player!=tp2");
		}*/
		
		
		
		//Enemy
		if(emliv==true) {
			//fill(255,0,0);
			//rect(enemy.x, enemy.y, enemy.width, enemy.height); // Draw enemy
			enemy.draw();
			//fill(255,255,255);
		}else if(emliv==false) {
			//fill(0,0,0);
			enemy.x=-50;
			enemy.y=-50;
			//rect(enemy.x, enemy.y, enemy.width, enemy.height); // Draw enemy
			//enemy.draw();
			//fill(255,255,255);
		}

		if(emliv2==true) {
			//fill(255,0,0);
			//rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
			enemy2.draw();
			//fill(255,255,255);
		}else if(emliv2==false) {
			//fill(0,0,0);
			enemy2.x=-50;
			enemy2.y=-50;
			//rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
			//enemy2.draw();
			//fill(255,255,255);
			
		}if(emliv3==true) {
			//fill(255,0,0);
			//rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
			enemy3.draw();
			//fill(255,255,255);
		}else if(emliv3==false) {
			//fill(0,0,0);
			enemy3.x=-50;
			enemy3.y=-50;
			//rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
			//enemy2.draw();
			//fill(255,255,255);
		}
		
		if(numOfEnemy==goalOfEnemy) {
			gol=1;
		}

		if (player.x==enemy.x && player.y==enemy.y || player.x==enemy2.x && player.y==enemy2.y) {
			rects.removeAll(rects);

			player.x=-9000;
			
			//Y
			rects.add(new ColorfulRectangle(50, 50, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(50, 100, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(100, 100, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(150, 100, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(150, 50, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(100, 150, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(100, 200, 50, 50, Color.WHITE));

			//O
			rects.add(new ColorfulRectangle(300, 50, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(300, 100, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(300, 150, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(300, 200, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(350, 50, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(350, 200, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(400, 50, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(400, 100, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(400, 150, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(400, 200, 50, 50, Color.WHITE));

			//U
			rects.add(new ColorfulRectangle(550, 50, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(550, 100, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(550, 150, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(550, 200, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(600, 200, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(650, 200, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(650, 50, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(650, 100, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(650, 150, 50, 50, Color.WHITE));
			
			//D
			rects.add(new ColorfulRectangle(50, 300, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(150, 350, 50, 50, Color.WHITE));

			rects.add(new ColorfulRectangle(50, 350, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(100, 300, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(50, 400, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(50, 450, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(50, 500, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(100, 500, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(150, 450, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(150, 400, 50, 50, Color.WHITE));

			//I
			rects.add(new ColorfulRectangle(250, 300, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(250, 350, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(250, 400, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(250, 450, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(250, 500, 50, 50, Color.WHITE));
			
			//E
			rects.add(new ColorfulRectangle(400, 300, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(450, 300, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(350, 300, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(350, 350, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(350, 400, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(400, 400, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(450, 400, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(350, 450, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(350, 500, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(400, 500, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(450, 500, 50, 50, Color.WHITE));

			//D
			rects.add(new ColorfulRectangle(550, 300, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(650, 350, 50, 50, Color.WHITE));

			rects.add(new ColorfulRectangle(550, 350, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(600, 300, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(550, 400, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(550, 450, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(550, 500, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(600, 500, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(650, 450, 50, 50, Color.WHITE));
			rects.add(new ColorfulRectangle(650, 400, 50, 50, Color.WHITE));

		}
		
		//door key
		/*if (yeldoorlocked==0) {
			//fill(255,255,0);
			//rect(yeldoorkey.x, yeldoorkey.y, yeldoorkey.width, yeldoorkey.height); // Draw key
			yeldoorkey.draw();
			//fill(255,255,255);
		if (purdoorlocked==0) {
			//fill(255,255,0);
			//rect(purdoorkey.x, purdoorkey.y, purdoorkey.width, purdoorkey.height); // Draw key
			purdoorkey.draw();
			//fill(255,255,255);
		}
		}else {
			//			fill(0,0,0);
			//			rect(yeldoorkey.x, yeldoorkey.y, yeldoorkey.width, yeldoorkey.height); // Draw key
			//			fill(255,255,255);
		}*/

		//purdoorkey.draw();
		
		tp1.draw();
		tp2.draw();
		
		if(player.x==tp1.x && player.y==tp1.y && canTp){
			player.x=tp2.x;
			player.y=tp2.y;
			canTp = false;
		}
		
		if(player.x==tp2.x && player.y==tp2.y && canTp){
			player.x=tp1.x;
			player.y=tp1.y;
			canTp = false;
		}
		
		
		//System.out.println(canTp);
		
		
		if(player.x==yeldoorkey.x && player.y==yeldoorkey.y  || bullet.x==yeldoorkey.x && bullet.y==yeldoorkey.y) {
			yeldoorkey.x=-50;
			yeldoorkey.y=-50;
//			rects.remove(yeldoorkey);

			
			yeldoorlocked=false;
			System.out.println("Yellow Door Unlocked");
		}
		
		if(player.x==yeldoorkey2cuzidontwanttofixthefirstone.x && player.y==yeldoorkey2cuzidontwanttofixthefirstone.y  || bullet.x==yeldoorkey2cuzidontwanttofixthefirstone.x && bullet.y==yeldoorkey2cuzidontwanttofixthefirstone.y) {
			yeldoorkey2cuzidontwanttofixthefirstone.x=-50;
			yeldoorkey2cuzidontwanttofixthefirstone.y=-50;
//			rects.remove(yeldoorkey);

			
			yeldoorlocked=false;
			System.out.println("Yellow Door Unlocked");
		}

		
		if(player.x==purdoorkey.x && player.y==purdoorkey.y || bullet.x==purdoorkey.x && bullet.y==purdoorkey.y) {
			purdoorkey.x=-50;
			purdoorkey.y=-50;
			purdoorlocked=false;
			System.out.println("Purple Door Unlocked");
		}
		
		if(player.x==oradoorkey.x && player.y==oradoorkey.y || bullet.x==oradoorkey.x && bullet.y==oradoorkey.y) {
			oradoorkey.x=-50;
			oradoorkey.y=-50;
			oradoorlocked=false;
			System.out.println("Orange Door Unlocked");
		}
		
		if(player.x==cyadoorkey.x && player.y==cyadoorkey.y || bullet.x==cyadoorkey.x && bullet.y==cyadoorkey.y) {
			cyadoorkey.x=-50;
			cyadoorkey.y=-50;
			cyadoorlocked=false;
			System.out.println("Cyan Door Unlocked");
		}

		if(numOfEnemy==goalOfEnemy) {
			enmdoorlocked=false;
		}
		
		
		
		if(yeldoorlocked==true) {
			yeldoor1.draw();
			yeldoor2.draw();
		}

		if(purdoorlocked==true) {
			purdoor1.draw();
			purdoor2.draw();
		}
		
		if(oradoorlocked==true) {
			oradoor1.draw();
			oradoor2.draw();
		}

		if(cyadoorlocked==true) {
			cyadoor1.draw();
			cyadoor2.draw();
		}
		
		if(enmdoorlocked==true) {
			enmdoor1.draw();
			enmdoor2.draw();
		}
		
		
		

		//if(numOfKeys==goalOfKeys) {
		//	doorlocked=1;
		//}

		//door
		//System.out.println(doorlocked);
		if(yeldoorlocked==false) {
			rects.remove(yeldoor1);
			rects.remove(yeldoor2);
		}

		if(purdoorlocked==false) {
			rects.remove(purdoor1);
			rects.remove(purdoor2);
		}
		
		if(oradoorlocked==false) {
			rects.remove(oradoor1);
			rects.remove(oradoor2);
		}

		if(cyadoorlocked==false) {
			rects.remove(cyadoor1);
			rects.remove(cyadoor2);
		}
		
		if(enmdoorlocked==false) {
			rects.remove(enmdoor1);
			rects.remove(enmdoor2);
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
		rects.remove(bullet);
		
		if(shoot==1) {
			//for (int i = 0; i < 3; i++) {
			rects.add(bullet);
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
			if(emliv==true) {
				numOfEnemy+=1;
			}
			emliv=false;
		}

		if(bullet.x==enemy2.x && bullet.y==enemy2.y) {
			if(emliv2==true) {
				numOfEnemy+=1;
			}
			emliv2=false;
		}
		
		if(bullet.x==enemy3.x && bullet.y==enemy3.y) {
			if(emliv3==true) {
				numOfEnemy+=1;
			}
			emliv3=false;
		}


		//		if (btv1.x==enemy.x && btv1.y==enemy.y || btv2.x==enemy.x && btv2.y==enemy.y || bth1.x==enemy.x && bth1.y==enemy.y || bth2.x==enemy.x && bth2.y==enemy.y){
		//			emliv=0;
		//		}



		//rect(enemy.x, enemy.y, enemy.width, enemy.height   ); // Draw enemy

		//Kill enemy
		if(att==1) {        	
			if(50 == Math.abs(player.x-enemy.x) && 50 == Math.abs(player.y-enemy.y)){
				//System.out.println("dead");
				if(emliv==true) {
					numOfEnemy+=1;
				}
				emliv=false;
			}
			if( (50 == Math.abs(player.x-enemy.x) && player.y == enemy.y) ||
					((50 == Math.abs(player.y-enemy.y) && player.x == enemy.x)) ){
				//System.out.println("dead");
				if(emliv==true) {
					numOfEnemy+=1;
				}
				emliv=false;
			}
			if(50 == Math.abs(player.x-enemy2.x) && 50 == Math.abs(player.y-enemy2.y)){
				//System.out.println("dead");
				if(emliv2==true) {
					numOfEnemy+=1;
				}
				emliv2=false;
			}
			if( (50 == Math.abs(player.x-enemy2.x) && player.y == enemy2.y) ||
					((50 == Math.abs(player.y-enemy2.y) && player.x == enemy2.x)) ){
				//System.out.println("dead");
				if(emliv2==true) {
					numOfEnemy+=1;
				}
				emliv2=false;
			}
			if(50 == Math.abs(player.x-enemy3.x) && 50 == Math.abs(player.y-enemy3.y)){
				//System.out.println("dead");
				if(emliv3==true) {
					numOfEnemy+=1;
				}
				emliv3=false;
			}
			if( (50 == Math.abs(player.x-enemy3.x) && player.y == enemy3.y) ||
					((50 == Math.abs(player.y-enemy3.y) && player.x == enemy3.x)) ){
				//System.out.println("dead");
				if(emliv3==true) {
					numOfEnemy+=1;
				}
				emliv3=false;
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
			//fill(255,255,255);
			att=0;
		}

		//rect(player.x, player.y, player.width, player.height); // Draw player
		player.draw();

		if(gol==0) {

		}else if(gol==1) {
			//fill(0,255,0);
			//rect(goal.x, goal.y, goal.width, goal.height); // Draw goal
			goal.draw();
			//fill(255,255,255);
		}

		if(player.x==goal.x && player.y==goal.y && gol==1 && level==1) {
			//			System.out.println("you win");
			//			System.exit(0);
			level=2;
		}else if(player.x==goal.x && player.y==goal.y && gol==1 && level==2) {
			level=3;
		}else if(player.x==goal.x && player.y==goal.y && gol==1 && level==3) {
			level=4;
		}else if(player.x==goal.x && player.y==goal.y && gol==1 && level==4) {
			level=5;
		}

		

//		if (player.y>=550) {
//			player.y=550;
//		}     
//		if (player.y<=0) {
//			player.y=0;
//		}
//		if (player.x>=750) {
//			player.x=750;
//		}
//		if (player.x<=0) {
//			player.x=0;
//		}


		//rect(bullet.x, bullet.y, 50 , 50);
		bullet.draw();


		//        brdx = 250;
		//        brdy = 250;
		//        rect(brdx,brdy,50,50);

		if(skip==1) {
			//devmode=true;
			if(level==1){
				level=2;
				player.x=0;
				player.y=500;
			}else if(level==2){
				level=3;
				player.x=0;
				player.y=100;
			}else if(level==3){
			level=4;
			player.x=750;
			player.y=450;
		}else if(level==4){
			level=5;
			player.x=750;
			player.y=550;
		}else if(level==5){
			level=6;
			player.x=750;
			player.y=550;
		}
		}

		skip=0;

	}

	private void level1Rects() {
		int marker;

		
		rects.add(new ColorfulRectangle(0, 250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50, 250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(300, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(400, 250, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(400, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(400, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(400, 100, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(200, 0, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 100, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(200, 550, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 300, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(450, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(750, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(650, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 0, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(400, 0, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(300, 50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(300, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 100, 50, 50, Color.WHITE ));

		yeldoor1 = new ColorfulRectangle(650, 250, 50, 50, Color.WHITE);
		yeldoor2 = new ColorfulRectangle(663, 263, 25, 25, Color.YELLOW);
		rects.add(yeldoor1);
		rects.add(yeldoor2);
		rects.add(yeldoorkey);
		
		playerposX = 0;
		playerposY = 0;

	}

	private void level2Rects() {
		int marker;

		if(lv2_setup==true) {
			emliv = true;
			emliv2 = true;

			enemy.x=300;
			enemy.y=350;

			enemy2.x=500;	
			enemy2.y=250;

			lv2_setup = false;

			yeldoorlocked = true;
			purdoorlocked = true;

			gol = 0;

			goal.x=0;
			goal.y=100;

			numOfEnemy = 0;
			goalOfEnemy = 2;

			numOfKeys = 0;
			goalOfKeys = 2;

			rects.add(yeldoor1);
			rects.add(yeldoor2);
			rects.add(purdoor1);
			rects.add(purdoor2);

			rects.add(yeldoorkey);
			//rects.add(yeldoorkey2cuzidontwanttofixthefirstone);			
			
			rects.add(purdoorkey);
			
			yeldoor1.x=350;
			yeldoor1.y=150;
			yeldoor2.x=363;
			yeldoor2.y=163;
			
			purdoor1.x=700;
			purdoor1.y=500;
			purdoor2.x=713;
			purdoor2.y=513;
			
			yeldoorkey.x=550;
			yeldoorkey.y=200;
			
			//yeldoorkey2cuzidontwanttofixthefirstone.x=550;
			//yeldoorkey2cuzidontwanttofixthefirstone.y=200;


			purdoorkey.x=0;
			purdoorkey.y=300;
			
			
			playerposX = 0;
			playerposY = 500;

		}


		rects.add(new ColorfulRectangle(350, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 550, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(150, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 450, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(0, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(100, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 450, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 550, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(300, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(400, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 400, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(550, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(650, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 450, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(600, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 550, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 550, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(550, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 300, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(700, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 300, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(650, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(400, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(400, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(100, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 350, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(300, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(100, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 300, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(600, 300, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(600, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 300, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(250, 0, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 0, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(300, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(0, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 50, 50, 50, Color.WHITE ));

		rects.add(new Rectangle(300, 0, 50, 50 ));

		lv2_setup=false;
		
		isLevel2Setup  = true;
	}

	private void level3Rects() {
		int marker;
		
		if(lv3_setup==true) {
			emliv = true;
			emliv2 = true;

			enemy.x=300;
			enemy.y=350;

			enemy2.x=500;	
			enemy2.y=250;

			lv3_setup = false;

			yeldoorlocked = true;
			purdoorlocked = true;

			gol = 0;

			goal.x=750;
			goal.y=450;

			numOfEnemy = 0;
			goalOfEnemy = 2;

			numOfKeys = 0;
			goalOfKeys = 3;


			yeldoor1.x=450;
			yeldoor1.y=500;
			yeldoor2.x=463;
			yeldoor2.y=513;
			
			purdoor1.x=150;
			purdoor1.y=200;
			purdoor2.x=163;
			purdoor2.y=213;
			
			oradoor1.x=50;
			oradoor1.y=200;
			oradoor2.x=63;
			oradoor2.y=213;

			yeldoorkey.x=100;
			yeldoorkey.y=500;

			yeldoorkey2cuzidontwanttofixthefirstone.x=-50;
			yeldoorkey2cuzidontwanttofixthefirstone.y=-50;
			
			purdoorkey.x=300;
			purdoorkey.y=300;
			
			oradoorkey.x=650;
			oradoorkey.y=200;

			rects.add(yeldoor1);
			rects.add(yeldoor2);
			rects.add(purdoor1);
			rects.add(purdoor2);
			rects.add(oradoor1);
			rects.add(oradoor2);

			rects.add(yeldoorkey);
			rects.add(purdoorkey);
			rects.add(oradoorkey);
			
			
			playerposX = 0;
			playerposY = 100;
		}

		rects.add(new ColorfulRectangle(350,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,0, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(100,450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,300, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(350, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(0, 150, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(400, 450, 50, 50, Color.WHITE ));
		
		rects.add(new ColorfulRectangle(150, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 0, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 300, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 400, 50, 50, Color.WHITE ));
		
		rects.add(new ColorfulRectangle(50, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 450, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 500, 50, 50, Color.WHITE ));

		
		rects.add(new ColorfulRectangle(50, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 300, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(50, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 450, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(150, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(200, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(300, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 500, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 450, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 300, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(300, 250, 50, 50, Color.WHITE ));
		
		rects.add(new ColorfulRectangle(250, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(250, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 0, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(350, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(400, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 50, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 0, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 100, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(650, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 150, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 200, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 250, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 300, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 550, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(450, 450, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(500, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 350, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 400, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 300, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(600, 300, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(650, 300, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(700, 300, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(750, 300, 50, 50, Color.WHITE ));

		rects.add(new ColorfulRectangle(550, 550, 50, 50, Color.WHITE ));
		rects.add(new ColorfulRectangle(550, 500, 50, 50, Color.WHITE ));

		
		
		lv3_setup=false;
		
		isLevel3Setup  = true;
	}

	
	private void level4Rects() {
		int marker;

		if(lv4_setup==true) {
			emliv = true;
			emliv2 = true;

			enemy.x=500;
			enemy.y=200;

			enemy2.x=150;	
			enemy2.y=150;

			lv4_setup = false;

			yeldoorlocked = true;
			purdoorlocked = true;
			oradoorlocked = true;

			gol = 0;

			goal.x=750;
			goal.y=550;

			numOfEnemy = 0;
			goalOfEnemy = 2;

			numOfKeys = 0;
			goalOfKeys = 3;


			yeldoor1.x=600;
			yeldoor1.y=450;
			yeldoor2.x=613;
			yeldoor2.y=463;
			
			purdoor1.x=450;
			purdoor1.y=300;
			purdoor2.x=463;
			purdoor2.y=313;
			
			oradoor1.x=50;
			oradoor1.y=350;
			oradoor2.x=63;
			oradoor2.y=363;
			
			yeldoorkey.x=700;
			yeldoorkey.y=300;
			//yeldoorkey.x=550;
			//yeldoorkey.y=450;

			purdoorkey.x=250;
			purdoorkey.y=250;
			
			oradoorkey.x=450;
			oradoorkey.y=150;

			rects.add(yeldoor1);
			rects.add(yeldoor2);
			rects.add(purdoor1);
			rects.add(purdoor2);
			rects.add(oradoor1);
			rects.add(oradoor2);

			rects.add(yeldoorkey);
			rects.add(purdoorkey);
			rects.add(oradoorkey);
			
			
			playerposX = 750;
			playerposY = 450;
		}


		rects.add(new ColorfulRectangle(750, 500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(700, 500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650, 500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600, 500, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(750, 400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(700, 400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650, 400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600, 400, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(550, 500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(500, 500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(450, 500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400, 500, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(500, 450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(500, 400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(500, 350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(500, 300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550, 300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600, 300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650, 300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(750, 300, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(750, 250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(750, 200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(700, 200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600, 250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600, 200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600, 150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600, 100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650, 100, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(750, 100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(750, 50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(750, 0, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(700,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(500,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(450,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(500,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(750,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(450,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(350,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,50, 50, 50, Color.WHITE));

		
		rects.add(new ColorfulRectangle(250,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(0,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(0,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(0,250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(0,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(0,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(0,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(0,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(0,0, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(450,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,300, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(300,100, 50, 50, Color.WHITE));



		lv4_setup=false;
		
		isLevel4Setup  = true;
	}

	private void level5Rects() {
		int marker;

		if(lv5_setup==true) {
			emliv = true;
			emliv2 = true;
			emliv3 = true;

			enemy.x=400;
			enemy.y=550;

			enemy2.x=50;	
			enemy2.y=50;
			
			enemy3.x=150;	
			enemy3.y=550;


			lv5_setup = false;

			yeldoorlocked = true;
			purdoorlocked = true;
			oradoorlocked = true;
			cyadoorlocked = true;
			enmdoorlocked = true;

			tp1.x = 600;
			tp1.y = 500;
			tp2.x = 650;
			tp2.y = 0;

			gol = 0;

			goal.x=700;
			goal.y=400;

			numOfEnemy = 0;
			goalOfEnemy = 3;			

			yeldoor1.x=200;
			yeldoor1.y=200;
			yeldoor2.x=yeldoor1.x+13;;
			yeldoor2.y=yeldoor1.y+13;;
			
			purdoor1.x=0;
			purdoor1.y=200;
			purdoor2.x=purdoor1.x+13;
			purdoor2.y=purdoor1.y+13;
			
			oradoor1.x=450;
			oradoor1.y=200;
			oradoor2.x=oradoor1.x+13;
			oradoor2.y=oradoor1.y+13;
			
			cyadoor1.x=150;
			cyadoor1.y=150;
			cyadoor2.x=cyadoor1.x+13;
			cyadoor2.y=cyadoor1.y+13;

			enmdoor1.x=100;
			enmdoor1.y=300;
			enmdoor2.x=enmdoor1.x+13;;
			enmdoor2.y=enmdoor1.y+13;;


			yeldoorkey.x=400;
			yeldoorkey.y=450;

			purdoorkey.x=100;
			purdoorkey.y=550;
			
			oradoorkey.x=350;
			oradoorkey.y=150;
			
			cyadoorkey.x=250;
			cyadoorkey.y=50;


			rects.add(yeldoor1);
			rects.add(yeldoor2);
			rects.add(purdoor1);
			rects.add(purdoor2);
			rects.add(oradoor1);
			rects.add(oradoor2);
			rects.add(cyadoor1);
			rects.add(cyadoor2);
			rects.add(enmdoor1);
			rects.add(enmdoor2);

			rects.add(yeldoorkey);
			rects.add(purdoorkey);
			rects.add(oradoorkey);
			rects.add(cyadoorkey);
			
			
			playerposX = 750;
			playerposY = 550;

		}

		rects.add(new ColorfulRectangle(600,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600,450, 50, 50, Color.WHITE));


		rects.add(new ColorfulRectangle(700,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650,450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(700,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(750,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650,250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(700,250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(700,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(700,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(700,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(650,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(600,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(500,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(550,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(500,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(500,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(450,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(450,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(450,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(350,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(350,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(350,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(200,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(50,550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(450,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(400,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(350,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(350,550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(450,450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(750,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(700,0, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(50,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(100,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(350,50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,50, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(250,350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(250,550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(150,450, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(100,400, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(0,550, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(300,100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(300,0, 50, 50, Color.WHITE));


		
		lv5_setup=false;
		
		isLevel5Setup  = true;
	}

	
	private void level6Rects() {
		int marker;

		if(lv6_setup==true) {
			emliv = true;
			emliv2 = true;
			emliv3 = true;

			enemy.x=400;
			enemy.y=550;

			enemy2.x=50;	
			enemy2.y=50;
			
			enemy3.x=150;	
			enemy3.y=550;


			lv6_setup = false;

			yeldoorlocked = true;
			purdoorlocked = true;
			oradoorlocked = true;
			cyadoorlocked = true;

			tp1.x = 600;
			tp1.y = 500;
			tp2.x = 650;
			tp2.y = 0;

			gol = 0;

			goal.x=750;
			goal.y=550;

			numOfEnemy = 0;
			goalOfEnemy = 3;			

			yeldoor1.x=200;
			yeldoor1.y=200;
			yeldoor2.x=yeldoor1.x+13;;
			yeldoor2.y=yeldoor1.y+13;;
			
			purdoor1.x=0;
			purdoor1.y=200;
			purdoor2.x=purdoor1.x+13;
			purdoor2.y=purdoor1.y+13;
			
			oradoor1.x=450;
			oradoor1.y=200;
			oradoor2.x=oradoor1.x+13;
			oradoor2.y=oradoor1.y+13;
			
			cyadoor1.x=150;
			cyadoor1.y=150;
			cyadoor2.x=cyadoor1.x+13;
			cyadoor2.y=cyadoor1.y+13;

			enmdoor1.x=100;
			enmdoor1.y=300;
			enmdoor2.x=enmdoor1.x+13;;
			enmdoor2.y=enmdoor1.y+13;;


			yeldoorkey.x=400;
			yeldoorkey.y=450;

			purdoorkey.x=100;
			purdoorkey.y=550;
			
			oradoorkey.x=350;
			oradoorkey.y=150;
			
			cyadoorkey.x=250;
			cyadoorkey.y=50;


			rects.add(yeldoor1);
			rects.add(yeldoor2);
			rects.add(purdoor1);
			rects.add(purdoor2);
			rects.add(oradoor1);
			rects.add(oradoor2);
			rects.add(cyadoor1);
			rects.add(cyadoor2);
			rects.add(enmdoor1);
			rects.add(enmdoor2);

			rects.add(yeldoorkey);
			rects.add(purdoorkey);
			rects.add(oradoorkey);
			rects.add(cyadoorkey);

		}

		rects.add(new ColorfulRectangle(600,0, 50, 50, Color.WHITE));

		
		lv6_setup=false;
		
		isLevel6Setup  = true;
	}
	

	boolean playerInterectsBlock() {
		if(devmode==false) {

		for(Rectangle r: rects) {

			if(r!=bullet && r!=btv1 && r!=btv2 && r!=bth1 && r!=bth2 && r!=yeldoorkey && r!=purdoorkey && r!=oradoorkey) {
				if( r.intersects(player)){
					return true;
				}
			}
		}

		}
		
		return false;
	}


/*
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
	}*/

	public void keyPressed() {
		int marker;

		if (key == CODED) {
			if (keyCode == UP) {
				
				if(player.x==tp1.x && player.y==tp1.y || player.x==tp2.x && player.y==tp2.y){
					canTp = false;
				}else {
					canTp = true;
				}
				
				/*if(player.x==tp2.x && player.y==tp2.y){
					canTp = false;
				}else {
					canTp = true;
				}*/
				

				
				if (player.y>=50) {
				player.y-=50;
				}
				facing=1;

				
				/*if(player.x!=tp2.x && player.y!=tp2.y){
					System.out.println("can tp2 up");
					canTp = true;
				}*/

				
				// if player Rectangle intersects with any of those in the list, move him back	
				if(playerInterectsBlock()) {
					while (playerInterectsBlock()) {
						player.y+=10;
					}
				}				
				
				
			} else if (keyCode == DOWN) {
				
				if(player.x==tp1.x && player.y==tp1.y || player.x==tp2.x && player.y==tp2.y){
					canTp = false;
				}else {
					canTp = true;
				}
				
				
				if (player.y<=500) {
				player.y+=50;
				}
				facing=3;

			
				
				if(playerInterectsBlock()) {
					player.y-=50;
				}
			} else if (keyCode == LEFT) {
				
				
				if(player.x==tp1.x && player.y==tp1.y || player.x==tp2.x && player.y==tp2.y){
					canTp = false;
				}else {
					canTp = true;
				}
				
				
				
				if (player.x>=50) {
					player.x-=50;
				}
				facing=2;

				
				if(playerInterectsBlock()) {
					player.x+=50;
				}
			} else if (keyCode == RIGHT) {
				
				
				if(player.x==tp1.x && player.y==tp1.y || player.x==tp2.x && player.y==tp2.y){
					canTp = false;
				}else {
					canTp = true;
				}
				
				
				
				if (player.x<=700) {
				player.x+=50;
				}
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


public void mousePressed() {
	int moX = (mouseX/50)*50;
	int moY = (mouseY/50)*50;

	//System.out.println("X:" + moX + "   Y:" + moY);
	System.out.println("rects.add(new ColorfulRectangle("+ moX +"," + moY + ", 50, 50, Color.WHITE));");
	rects.add(new ColorfulRectangle(moX,moY, 50, 50, Color.WHITE));

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

	class ColorfulRectangle extends Rectangle{

		Color col;

		public ColorfulRectangle(int x, int y, int width, int height, Color col) {
			super(x, y, width, height);
			this.col=col;
		}


		void draw(){

			fill(col.getRGB());
			
			rect(x, y, width, height);

		}


	}


}
