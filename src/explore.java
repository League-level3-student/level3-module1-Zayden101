

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.text.html.parser.Entity;

import processing.core.PApplet;


//*DONE* WORK ON REMOVING LOCKED DOO//*NVM* WORK ON BULLET TRAIL
//WORK ON LV 3
// FIX
/*		if(numOfEnemy==goalOfEnemy) {
rects.remove(enmdoor1);
rects.remove(enmdoor2);
}*/


//WORK ON NOT MOVING ALL THE WAY WHEN TOUCHING BLOCK, SO YOU CAN NOT BE ALINGED

//WORK ON LV 7

//WORK ON MOVING BLOCKS AND LEVEL 7

//Finish menu screen and fix moving block showing up for level 7, and many start lv 8

//work on lv 8 and traps and stairs

//do fill blocks

//finish working on enemy moving


//work on fill blocks and lv 10


public class explore extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;

	int bgColor = color(0, 0, 0);
	//int bgColor = color(31, 0, 48);

	int value = 0;

	int x1 = 0;
	int y1 = 0;

	int att = 0;
	int atty = 0;

	boolean emliv = false;     //enemy alive
	boolean emliv2 = false;     //enemy2 alive
	int attx = 0;
	boolean emliv3 = false;     //enemy3 alive



	int brdx = 0;
	int brdy = 0;

	
	boolean playerDead = false;
	
	int facing;

	int shoot;
	
	int enemyRandomMove1=4;
	int enemyRandomMove2=4;
	int enemyRandomMove3=4;

	int wait = 0;
	
	
	int movex = 0;
	int movey = 0;
	
	int enemymovex = 0;
	int enemymovey = 0;
	
	int enemy2movex = 0;
	int enemy2movey = 0;

	int enemy3movex = 0;
	int enemy3movey = 0;

	
	
	ColorfulRectangle player = new ColorfulRectangle(350,250,50,50,Color.BLUE);

	List<Rectangle> rects = new ArrayList<Rectangle>();
	List<Rectangle> elips = new ArrayList<Rectangle>();


	ColorfulRectangle enemy = new ColorfulRectangle(100,250,50,50,Color.RED);
	ColorfulRectangle enemy2 = new ColorfulRectangle(0,-250,50,50, Color.RED);
	ColorfulRectangle enemy3 = new ColorfulRectangle(-100,500,50,50, Color.RED);
	
	ColorfulRectangle bullet;
	ColorfulRectangle btv1, btv2;    //bullet trail vertical
	ColorfulRectangle bth1, bth2;    //bullet trail horizontal
	//private boolean addlevel1Rects = true;
	//private boolean addlevel2Rects = true;

	
	boolean enemymove = true;

	boolean enemymove1 = false;
	int enemyfacing1 = 0;
	boolean enemymove2 = false;
	int enemyfacing2 = 0;
	boolean enemymove3 = false;
	int enemyfacing3 = 0;

	//List<Rectangle> enemy = new ArrayList<Rectangle>();


	@Override
	public void settings() {
		size(WIDTH, HEIGHT);

		//level=7;
		//player.x=750;
		//player.y=550;
					
		
	}


	@Override
	public void setup() {
		
		int marker;
		
		//JOptionPane.showMessageDialog(null, "Arrow keys to move \n*Shift* to surround attack \n*Alt* to shoot bullet (shoots through walls cuz im too lazy to fix it)");
		
		background(bgColor);


		enemymovex=100;
		enemymovey=250;
		
		enemy2movex=0;
		enemy2movey=-250;
		
		enemy3movex=-100;
		enemy3movey=500;

		//noCursor();

		
		bullet = new ColorfulRectangle(player.x, player.y, 50, 49, Color.BLUE);

		btv1 = new ColorfulRectangle(player.x+12, player.y, 25, 50, Color.BLUE);
		btv2 = new ColorfulRectangle(player.x+12, player.y, 25, 50, Color.BLUE);

		bth1 = new ColorfulRectangle(player.x, player.y-12, 50, 25, Color.BLUE);
		bth2 = new ColorfulRectangle(player.x, player.y-12, 50, 25, Color.BLUE);
		
		
		

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
	}

	@Override
	public void draw() {
		background(bgColor);

		int marker;
				

		//stroke();

		
		for(Rectangle r : rects) {
			if(r instanceof ColorfulRectangle) {
				((ColorfulRectangle) r).draw();
			}else {
				rect(r.x, r.y, r.width, r.height);
			}
		}

		
		
		/*
		(WALLS)		Color.WHITE
		(PLAYER)	Color.BLUE
		(KEY)		Color.CYAN
					Color.DARK_GRAY
		(MOVABLE)	Color.GRAY
		(GOAL)		Color.GREEN
					Color.LIGHT_GRAY
		(KEY)		Color.MAGENTA
		(Key)		Color.ORANGE
		(TP)		Color.PINK
		(ENEMY)		Color.RED
		(KEY)		Color.YELLOW
					Color.BLACK
		 */

	
		
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
		

	
			//playerDead=true;
		
		
		
	
		
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
		
		if(playerInterectsBlock()) {
			if(facing==1) {
			movey-=50;
			}		
			
			if(facing==2) {
			movex-=50;
			}
			
			if(facing==3) {
			movey+=50;
			}
			
			if(facing==4) {
			movex+=50;
			}
		}
		
		if(enemyInterectsBlock()) {
			if(enemyfacing1==1) {
			enemymovey+=50;
			}		
			
			if(enemyfacing1==2) {
			enemymovex+=50;
			}
			
			if(enemyfacing1==3) {
			enemymovey-=50;
			}
			
			if(enemyfacing1==4) {
			enemymovex-=50;
			}
		}
		
		if(enemy2InterectsBlock()) {
			if(enemyfacing2==1) {
			enemy2movey+=50;
			}		
			
			if(enemyfacing2==2) {
			enemy2movex+=50;
			}
			
			if(enemyfacing2==3) {
			enemy2movey-=50;
			}
			
			if(enemyfacing2==4) {
			enemy2movex-=50;
			}
		}
		
		if(enemy3InterectsBlock()) {
			if(enemyfacing3==1) {
			enemy3movey+=50;
			}		
			
			if(enemyfacing3==2) {
			enemy3movex+=50;
			}
			
			if(enemyfacing3==3) {
			enemy3movey-=50;
			}
			
			if(enemyfacing3==4) {
			enemy3movex-=50;
			}
		}
		
		
		
		//draw

	rects.clear();
	rects.add(new ColorfulRectangle(movex+100,movey+50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+150,movey+50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+200,movey+50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+250,movey+50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+250,movey+100, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+250,movey+150, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+200,movey+150, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+150,movey+150, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+150,movey+200, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+150,movey+250, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+150,movey+300, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+100,movey+300, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+50,movey+300, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+50,movey+250, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+50,movey+150, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+0,movey+150, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+0,movey+100, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+0,movey+50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+0,movey+250, 50, 50, Color.WHITE));
	
	rects.add(new ColorfulRectangle(movex+-150,movey+-50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-200,movey+-50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-250,movey+-50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-250,movey+0, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-250,movey+50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-300,movey+50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-350,movey+50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-350,movey+100, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-350,movey+150, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-350,movey+200, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-300,movey+200, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-250,movey+200, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-250,movey+150, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-150,movey+50, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-150,movey+100, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-150,movey+150, 50, 50, Color.WHITE));
	
	rects.add(new ColorfulRectangle(movex+-300,movey+350, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-300,movey+400, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-300,movey+450, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-300,movey+500, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-300,movey+550, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-300,movey+600, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-250,movey+600, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-200,movey+600, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-150,movey+600, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-100,movey+600, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-50,movey+600, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-50,movey+550, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-50,movey+500, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-50,movey+450, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-100,movey+450, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-150,movey+450, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-150,movey+500, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-250,movey+500, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-250,movey+350, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-200,movey+350, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-150,movey+350, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-250,movey+450, 50, 50, Color.WHITE));
		
	rects.add(new ColorfulRectangle(movex+100,movey+-100, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+100,movey+-150, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+100,movey+-200, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+100,movey+-250, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+100,movey+-300, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+50,movey+-300, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+0,movey+-300, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-50,movey+-300, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-50,movey+-250, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-50,movey+-200, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+0,movey+-200, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+50,movey+-100, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+0,movey+-100, 50, 50, Color.WHITE));
	rects.add(new ColorfulRectangle(movex+-50,movey+-100, 50, 50, Color.WHITE));
		
	
	
		//System.out.println("x:" + yeldoorkey.x + "  y:" + yeldoorkey.y);
		//System.out.println(firered.x + " " + firered.y);
		
		enemy.x=movex+enemymovex;
		enemy.y=movey+enemymovey;
		
		enemy2.x=movex+enemy2movex;
		enemy2.y=movey+enemy2movey;
		
		enemy3.x=movex+enemy3movex;
		enemy3.y=movey+enemy3movey;
		
		
		
		
		
		if(enemymove == true) {
					
		wait+=1;
		
		if(wait>=100) {
			wait=0;
	
			
		if(enemymove1 = true) {
				enemyRandomMove1 = new Random().nextInt(4);
				///up
			if(enemyRandomMove1==0) {
				enemymovey-=50;
				enemyfacing1=1;
				//left
			}else if(enemyRandomMove1==1) {
				enemymovex-=50;
				enemyfacing1=2;
				//down
			}else if(enemyRandomMove1==2) {
				enemymovey+=50;
				enemyfacing1=3;
				//right
			}else if(enemyRandomMove1==3) {
				enemymovex+=50;
				enemyfacing1=4; 
			}
		}
		
		
		
		if(enemymove2 = true) {
			enemyRandomMove2 = new Random().nextInt(4);
			//up
			if(enemyRandomMove2==0) {
				enemy2movey-=50;
				enemyfacing2=1;
			}
			//left
			if(enemyRandomMove2==1) {
				enemy2movex-=50;
				enemyfacing2=2;
			}
			//down
			if(enemyRandomMove2==2) {
				enemy2movey+=50;
				enemyfacing2=3;
			}
			//right
			if(enemyRandomMove2==3) {
				enemy2movex+=50;
				enemyfacing2=4;
			}
		
		}
		
		
		if(enemymove3 = true) {
			enemyRandomMove3 = new Random().nextInt(4);
			//up
			if(enemyRandomMove3==0) {
				enemy3movey-=50;
				enemyfacing3=1;
			}
			//left
			if(enemyRandomMove3==1) {
				enemy3movex-=50;
				enemyfacing3=2;
			}
			//down
			if(enemyRandomMove3==2) {
				enemy3movey+=50;
				enemyfacing3=3;
			}
			//right
			if(enemyRandomMove3==3) {
				enemy3movex+=50;
				enemyfacing3=4;
			}
			}

		
		
		
		}
		
		}
		
		
		//System.out.println(movingblockInterectsBlock());

		//if()
		

		//if(numOfKeys==goalOfKeys) {
		//	doorlocked=1;
		//}

		//door
		//System.out.println(doorlocked);

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

			emliv=false;
		}

		if(bullet.x==enemy2.x && bullet.y==enemy2.y) {

			emliv2=false;
		}
		
		if(bullet.x==enemy3.x && bullet.y==enemy3.y) {

			emliv3=false;
		}


		//		if (btv1.x==enemy.x && btv1.y==enemy.y || btv2.x==enemy.x && btv2.y==enemy.y || bth1.x==enemy.x && bth1.y==enemy.y || bth2.x==enemy.x && bth2.y==enemy.y){
		//			emliv=0;
		//		}

		
		
		//System.out.println(firemove);
		//System.out.println(firelit);

		


		//rect(enemy.x, enemy.y, enemy.width, enemy.height   ); // Draw enemy

		//Kill enemy
		if(att==1) {        	
			if(50 == Math.abs(player.x-enemy.x) && 50 == Math.abs(player.y-enemy.y)){
				//System.out.println("dead");
				emliv=false;
			}
			if( (50 == Math.abs(player.x-enemy.x) && player.y == enemy.y) ||
					((50 == Math.abs(player.y-enemy.y) && player.x == enemy.x)) ){
				//System.out.println("dead");
				emliv=false;
			}
			if(50 == Math.abs(player.x-enemy2.x) && 50 == Math.abs(player.y-enemy2.y)){
				//System.out.println("dead");
				emliv2=false;
			}
			if( (50 == Math.abs(player.x-enemy2.x) && player.y == enemy2.y) ||
					((50 == Math.abs(player.y-enemy2.y) && player.x == enemy2.x)) ){
				//System.out.println("dead");
				emliv2=false;
			}
			if(50 == Math.abs(player.x-enemy3.x) && 50 == Math.abs(player.y-enemy3.y)){
				//System.out.println("dead");
				emliv3=false;
			}
			if( (50 == Math.abs(player.x-enemy3.x) && player.y == enemy3.y) ||
					((50 == Math.abs(player.y-enemy3.y) && player.x == enemy3.x)) ){
				//System.out.println("dead");
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

		//ColorfulRectangle player = new ColorfulRectangle(0,0,25,25,Color.BLUE);
		
//System.out.println(player.width);
		//rect(bullet.x, bullet.y, 50 , 50);
		bullet.draw();


		//        brdx = 250;
		//        brdy = 250;
		//        rect(brdx,brdy,50,50);
	
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

	
	boolean enemyInterectsBlock() {
		for(Rectangle r: rects) {
			if(r!=bullet && r!=btv1 && r!=btv2 && r!=bth1 && r!=bth2) {
				if( r.intersects(enemy)){
					return true;
				}
			}
		}
		return false;
	}
	
	boolean enemy2InterectsBlock() {
		for(Rectangle r: rects) {
			if(r!=bullet && r!=btv1 && r!=btv2 && r!=bth1 && r!=bth2) {
				if( r.intersects(enemy2)){
					return true;
				}
			}
		}
		return false;
	}
	
	boolean enemy3InterectsBlock() {
		for(Rectangle r: rects) {
			if(r!=bullet && r!=btv1 && r!=btv2 && r!=bth1 && r!=bth2) {
				if( r.intersects(enemy3)){
					return true;
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
				
				movey+=50;
				
				facing=1;

				if(playerInterectsBlock()) {
						movey-=50;
				}				
				
			} else if (keyCode == DOWN) {
				
					movey-=50;

					facing=3;
			
					if(playerInterectsBlock()) {
							movey+=50;
					}

			} else if (keyCode == LEFT) {
								
					movex+=50;
					
					facing=2;

					if(playerInterectsBlock()) {
						movex-=50;
				}	

			} else if (keyCode == RIGHT) {
				
				movex-=50;

				facing=4;
							
				if(playerInterectsBlock()) {
						movex+=50;
				}
			} else if (keyCode == SHIFT) {
				att=1;
			} else if (keyCode == ALT) {
				shoot=1;
				//rects.clear();
			}
			
		}

		}





public void mousePressed() {


	int moX = ((mouseX/50)*50)+-movex;
	int moY = ((mouseY/50)*50)+-movey;

	//System.out.println("X:" + moX + "   Y:" + moY);
	System.out.println("rects.add(new ColorfulRectangle("+ "movex+"+ moX +",movey+" + moY + ", 50, 50, Color.WHITE));");
	rects.add(new ColorfulRectangle(moX+movex,moY+movey, 50, 50, Color.WHITE));

}





	static public void main(String[] passedArgs) {
		PApplet.main(explore.class.getName());
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

	@SuppressWarnings("serial")
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
	
	class ColorfulEllipse extends Rectangle{

		Color col;

		public ColorfulEllipse(int x, int y, int width, int height, Color col) {
			super(x, y, width, height);
			this.col=col;
		}


		void draw(){

			fill(col.getRGB());
			
			ellipse(x, y, width, height);

		}

	}

	}
