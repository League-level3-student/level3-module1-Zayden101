

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


//fix stupid enemy collision

//work on adding keys

//fix weapon

//add new keys, and maybe map

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

	int enemyRandomMove=4;

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
	

	int atmovx = 50;
	int atmovy = 50;
	
	int collectedKeys = 0;
	int collectedPinkKeys = 0;
	int collectedOrangeKeys = 0;


	//int endswitch = 1;
	
	int count=-2400;

	
	ColorfulRectangle player = new ColorfulRectangle(350,250,50,50,Color.BLUE);

	List<Rectangle> rects = new ArrayList<Rectangle>();
	List<Rectangle> elips = new ArrayList<Rectangle>();

	List<Enemy> enemies = new ArrayList<Enemy>();


	Enemy emeny = new Enemy(100,250,50,50);
//	Enemy emeny2 = new Enemy(0,-250,50,50);
//	Enemy emeny3 = new Enemy(-100,500,50,50);
//
//
//
	ColorfulRectangle enemy = new ColorfulRectangle(100,250,50,50,Color.RED);
//	ColorfulRectangle enemy2 = new ColorfulRectangle(0,-250,50,50, Color.RED);
//	ColorfulRectangle enemy3 = new ColorfulRectangle(-100,500,50,50, Color.RED);


	ColorfulRectangle playerup = new ColorfulRectangle(enemy.x,enemy.y-50,10,10,Color.BLUE);
	ColorfulRectangle playerdown = new ColorfulRectangle(enemy.x,enemy.y+50,10,10, Color.BLUE);
	ColorfulRectangle playerleft = new ColorfulRectangle(enemy.x-50,enemy.y,10,10, Color.BLUE);
	ColorfulRectangle playerright = new ColorfulRectangle(enemy.x+50,enemy.y,10,10, Color.BLUE);


	ColorfulRectangle weapon = new ColorfulRectangle(100005+movex,100005+movey, 40, 40, Color.GRAY);

	int weaponx;
	int weapony;
	boolean weaponShot;

	ColorfulRectangle bullet;
	ColorfulRectangle btv1, btv2;    //bullet trail vertical
	ColorfulRectangle bth1, bth2;    //bullet trail horizontal
	//private boolean addlevel1Rects = true;
	//private boolean addlevel2Rects = true;


	boolean enemymove = true;


	boolean wall1 = true;
	boolean wall2 = true;


	boolean spookydead = false;

	int wall1buttonx = 500;
	int wall1buttony = -150;
	
	int wall2buttonx = -900;
	int wall2buttony = 900;


//	int yellowdoor1x = 350;
//	int yellowdoor1inx = 360;
//
//	int yellowdoor2x = -1000;
//	int yellowdoor2inx = -990;
	
	Door door1 = new Door(movex+350,movey-450,50,50);
	Door door2 = new Door(movex+-1000,movey+100,50,50);
	Door door3 = new Door(movex+650,movey+500,50,50);
	Door door4 = new Door(movex+800,movey+200,50,50);
	Door door5 = new Door(movex+950,movey+250,50,50);
	Door door6 = new Door(movex+0,movey+1250,50,50);


	PinkDoor pinkdoor1 = new PinkDoor(movex-850,movey+800,50,50);
	PinkDoor pinkdoor2 = new PinkDoor(movex-1000,movey-600,50,50);
	
	OrangeDoor orangedoor1 = new OrangeDoor(movex+800,movey+850,50,50);

	
	
	Key key1 = new Key(movex+500,movey-500,50,50);
	Key key2 = new Key(movex-800,movey+550,50,50);
	Key key3 = new Key(movex-300,movey-550,50,50);
	Key key4 = new Key(movex-350,movey+850,50,50);
	Key key5 = new Key(movex+150,movey+500,50,50);
	Key key6 = new Key(movex-2250,movey-400,50,50);


	PinkKey pinkkey1 = new PinkKey(movex+1000,movey+550,50,50);
	PinkKey pinkkey2 = new PinkKey(movex+800,movey+1250,50,50);
	PinkKey pinkkey3 = new PinkKey(movex-2150,movey+100,50,50);
	PinkKey pinkkey4 = new PinkKey(movex-800,movey-1150,50,50);

	OrangeKey orangekey1 = new OrangeKey(movex-1300,movey-450,50,50);

	
	
	int waitTime = 25;


	String enemy1upDisplay = "";
	String enemy1downDisplay = "";
	String enemy1leftDisplay = "";
	String enemy1rightDisplay = "";

	List<Rectangle> enemyList = new ArrayList<Rectangle>();


	boolean build = false;
	boolean spooky = false;


	@Override
	public void settings() {
		size(WIDTH, HEIGHT);

	}


	@Override
	public void setup() {

		int marker;

		//JOptionPane.showMessageDialog(null, "Arrow keys to move \n*Shift* to surround attack \n*Alt* to shoot bullet (shoots through walls cuz im too lazy to fix it)");

		background(bgColor);

	}

	@Override
	public void draw() {
		background(bgColor);

		int marker;

//ENEMY 1=up, 2=down, 3=right, 4=left
//PLAYER 1=up, 2=left, 3=down, 4=right
		
		//Key key_1 = new Key(movex+350,movey+150,50,50);

		//System.out.println(collectedKeys);

		//stroke();


		for(Rectangle r : rects) {
			if(r instanceof ColorfulRectangle) {
				((ColorfulRectangle) r).draw();
			}else {
				rect(r.x, r.y, r.width, r.height);
			}
		}

emeny.draw();
emeny.update();



//System.out.println("rects.add(new ColorfulRectangle(movex+" + count + ",movey+1450, 50, 50, Color.WHITE));");
//count=count+50;



	//Enemy enemy1 = new Enemy(movex+100, movey+250, 50, 50);
	//enemy1.draw();
	//enemy1.update();

		
//		for(Enemy e : enemies) {
//			e.draw();
//			e.update();
//
//		}


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



		//		//Enemy
		//		if(emliv==true) {
		//			enemy.draw();
		//		}else if(emliv==false) {
		//			enemy.x=-50;
		//			enemy.y=-50;
		//		}
		//
		//		if(emliv2==true) {
		//			//fill(255,0,0);
		//			//rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
		//			enemy2.draw();
		//			//fill(255,255,255);
		//		}else if(emliv2==false) {
		//			//fill(0,0,0);
		//			enemy2.x=-50;
		//			enemy2.y=-50;
		//			//rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
		//			//enemy2.draw();
		//			//fill(255,255,255);
		//			
		//		}if(emliv3==true) {
		//			//fill(255,0,0);
		//			//rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
		//			enemy3.draw();
		//			//fill(255,255,255);
		//		}else if(emliv3==false) {
		//			//fill(0,0,0);
		//			enemy3.x=-50;
		//			enemy3.y=-50;
		//			//rect(enemy2.x, enemy2.y, enemy2.width, enemy2.height); // Draw enemy
		//			//enemy2.draw();
		//			//fill(255,255,255);
		//		}
		//		


		//playerDead=true;


/**ColorfulRectangle end1 = new ColorfulRectangle(-850,1250,50,50,Color.RED);
ColorfulRectangle end2 = new ColorfulRectangle(-850,1250,50,50,Color.YELLOW);
ColorfulRectangle end3 = new ColorfulRectangle(-850,1250,50,50,Color.GREEN);
ColorfulRectangle end4 = new ColorfulRectangle(-850,1250,50,50,Color.WHITE);
ColorfulRectangle end5 = new ColorfulRectangle(-850,1250,50,50,Color.CYAN);

endswitch=+1;

if(endswitch==1) {
	end1.draw();
}else if(endswitch==2) {
	end2.draw();
}else if(endswitch==3) {
	end3.draw();
}else if(endswitch==4) {
	end4.draw();
}else if(endswitch==5) {
	end5.draw();
}**/


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




		//draw

		if(build==false){
			rects.clear();
		}	


		buildings();
		buildings2();


		playerup.x=player.x;
		playerup.y=player.y-50;
		playerdown.x=player.x;
		playerdown.y=player.y+50;
		playerleft.x=player.x-50;
		playerleft.y=player.y;
		playerright.x=player.x+50;
		playerright.y=player.y;

		//		enemy1up.x=enemy.x;
		//		enemy1up.y=enemy.y-50;
		//		enemy1down.x=enemy.x;
		//		enemy1down.y=enemy.y+50;
		//		enemy1left.x=enemy.x-50;
		//		enemy1left.y=enemy.y;
		//		enemy1right.x=enemy.x+50;
		//		enemy1right.y=enemy.y;
		//		
		//		enemy2up.x=enemy2.x;
		//		enemy2up.y=enemy2.y-50;
		//		enemy2down.x=enemy2.x;
		//		enemy2down.y=enemy2.y+50;
		//		enemy2left.x=enemy2.x-50;
		//		enemy2left.y=enemy2.y;
		//		enemy2right.x=enemy2.x+50;
		//		enemy2right.y=enemy2.y;
		//		
		//		enemy3up.x=enemy3.x;
		//		enemy3up.y=enemy3.y-50;
		//		enemy3down.x=enemy3.x;
		//		enemy3down.y=enemy3.y+50;
		//		enemy3left.x=enemy3.x-50;
		//		enemy3left.y=enemy3.y;
		//		enemy3right.x=enemy3.x+50;
		//		enemy3right.y=enemy3.y;


		//System.out.println("x:" + yeldoorkey.x + "  y:" + yeldoorkey.y);
		//System.out.println(firered.x + " " + firered.y);

		//		enemy.x=movex+enemymovex;
		//		enemy.y=movey+enemymovey;
		//		
		//		enemy2.x=movex+enemy2movex;
		//		enemy2.y=movey+enemy2movey;
		//		
		//		enemy3.x=movex+enemy3movex;
		//		enemy3.y=movey+enemy3movey;



		
		
		
		
		//Need To Add Doors: 
		//rects.add(new ColorfulRectangle(movex+800,movey+200, 50, 50, Color.WHITE));
		//rects.add(new ColorfulRectangle(movex+950,movey+250, 50, 50, Color.WHITE));
		//rects.add(new ColorfulRectangle(movex+950,movey+450, 50, 50, Color.WHITE));
		//rects.add(new ColorfulRectangle(movex+650,movey+500, 50, 50, Color.WHITE));

		
		
//		ColorfulRectangle yellowdoor1 = new ColorfulRectangle(movex+yellowdoor1x,movey+-450, 50, 50, Color.WHITE);
//		ColorfulRectangle yellowdoor1in = new ColorfulRectangle(movex+yellowdoor1inx,movey+-440, 30, 30, Color.YELLOW);
//
//		yellowdoor1.draw();
//		yellowdoor1in.draw();
//
//		if(player.x==yellowdoor1.x && player.y==yellowdoor1.y) {
//			if(collectedKeys==0) {
//				if(facing==1) {
//					movey+=50;
//				}		
//				if(facing==2) {
//					movey-=50;
//				}
//				if(facing==3) {
//					movex-=50;
//				}
//				if(facing==4) {
//					movex+=50;
//				}
//			}else {
//				collectedKeys-=1;
//				yellowdoor1x=10000;
//				yellowdoor1inx=10000;
//			}
//		}
		
//		ColorfulRectangle yellowdoor2 = new ColorfulRectangle(movex+yellowdoor2x,movey+100, 50, 50, Color.WHITE);
//		ColorfulRectangle yellowdoor2in = new ColorfulRectangle(movex+yellowdoor2inx,movey+110, 30, 30, Color.YELLOW);
//
//		yellowdoor2.draw();
//		yellowdoor2in.draw();
//
//		if(player.x==yellowdoor2.x && player.y==yellowdoor2.y) {
//			if(collectedKeys==0) {
//				if(facing==1) {
//					movey+=50;
//				}		
//				if(facing==2) {
//					movey-=50;
//				}
//				if(facing==3) {
//					movex-=50;
//				}
//				if(facing==4) {
//					movex+=50;
//				}
//			}else {
//				collectedKeys-=1;
//				yellowdoor2x=10000;
//				yellowdoor2inx=10000;
//			}
//		}

		
		
		
		



		ColorfulRectangle wall1button = new ColorfulRectangle(movex+wall1buttonx,movey+wall1buttony,50,50, Color.GREEN);
		if(player.x==wall1button.x && player.y==wall1button.y) {
			wall1=false;
			wall1buttonx=10000;
			wall1buttony=10000;
		}
		wall1button.draw();

		ColorfulRectangle wall2button = new ColorfulRectangle(movex+wall2buttonx,movey+wall2buttony,50,50, Color.GREEN);
		if(player.x==wall2button.x && player.y==wall2button.y) {
			wall2=false;
			wall2buttonx=10000;
			wall2buttony=10000;
		}
		wall2button.draw();

		
		door1.draw();
		door1.update();

		door2.draw();
		door2.update();

		door3.draw();
		door3.update();

		door4.draw();
		door4.update();

		door5.draw();
		door5.update();

		pinkdoor1.draw();
		pinkdoor1.update();

		pinkdoor2.draw();
		pinkdoor2.update();

		orangedoor1.draw();
		orangedoor1.update();


		ColorfulRectangle displaykey = new ColorfulRectangle(660,10, 30, 30, Color.YELLOW);
		displaykey.draw();

		ColorfulRectangle displaypinkkey = new ColorfulRectangle(510,10, 30, 30, Color.PINK);
		displaypinkkey.draw();

		
		
		key1.draw();
		key1.update();
		
		key2.draw();
		key2.update();
		
		key3.draw();
		key3.update();
		
		key4.draw();
		key4.update();
		
		key5.draw();
		key5.update();

		key6.draw();
		key6.update();

		
		
		pinkkey1.draw();
		pinkkey1.update();

		pinkkey2.draw();
		pinkkey2.update();

		pinkkey3.draw();
		pinkkey3.update();

		pinkkey4.draw();
		pinkkey4.update();

		
		orangekey1.draw();
		orangekey1.update();

		

		//KEY COUNTER
		if(collectedKeys==0) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(710,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(710,10, 10, 30, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(710,40, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(730,10, 10, 30, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();

		}else if(collectedKeys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(720,0, 10, 50, Color.WHITE);
			keynum1.draw();

		}else if(collectedKeys==2) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(710,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(730,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(710,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(710,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(710,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedKeys==3) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(710,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(730,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(710,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(730,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(710,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedKeys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(710,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(710,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(730,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
			
		}else if(collectedKeys==5) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(710,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(710,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(710,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(730,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(710,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}

		
		
		//PINK KEY COUNTER
		if(collectedPinkKeys==0) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(560,10, 10, 30, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(560,40, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(580,10, 10, 30, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();

		}else if(collectedPinkKeys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(570,0, 10, 50, Color.WHITE);
			keynum1.draw();

		}else if(collectedPinkKeys==2) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(580,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(560,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(560,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(560,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedPinkKeys==3) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(580,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(560,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(580,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(560,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedPinkKeys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(560,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(580,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
		}else if(collectedPinkKeys==5) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(560,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(560,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(580,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(560,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();
		}

		
		
		//ORANGE KEY COUNTER
		if(collectedPinkKeys==0) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(560,10, 10, 30, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(560,40, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(580,10, 10, 30, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();

		}else if(collectedPinkKeys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(570,0, 10, 50, Color.WHITE);
			keynum1.draw();

		}else if(collectedPinkKeys==2) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(580,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(560,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(560,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(560,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedPinkKeys==3) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(580,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(560,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(580,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(560,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedPinkKeys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(560,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(580,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
		}else if(collectedPinkKeys==5) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(560,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(560,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(580,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(560,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();
		}

		
		weapon.draw();


		
		
		//WEAPON

		/*if(att==1) {
			weapon.x=player.x+5;
			weapon.y=player.y+5;
			
			if(facing==1) {
				att=0;
				while (!weaponInterectsBlock()) {
					weapon.y-=50;
				}
				if(weaponInterectsBlock());{
					weapon.y+=50;
					weapony=weapon.x;
					weapony=weapon.y;
				}
			}
			
			if(facing==2) {
				att=0;
				while (!weaponInterectsBlock()) {
					weapon.y+=50;
				}
				if(weaponInterectsBlock());{
					weapon.y-=50;
					weapony=player.x;
					weapony=weapon.y;
				}
			}
			
			if(facing==3) {
				att=0;
				while (!weaponInterectsBlock()) {
					weapon.x+=50;
				}
				if(weaponInterectsBlock());{
					weapon.x-=50;
					weaponx=weapon.x;
					weapony=weapon.y;
				}
			}
			
			if(facing==4) {
				att=0;
				while (!weaponInterectsBlock()) {
					weapon.x-=50;
				}
				if(weaponInterectsBlock());{
					weapon.x+=50;
					weaponx=weapon.x;
					weapony=weapon.y;
				}
			}
			weaponShot=true;
		}

		
		if(weaponShot==true) {
			weapon.x=weaponx+movex;
			weapon.y=weapony+movey;
		}else {
			weapon.x=100005;
			weapon.y=100005;
		}

		if(player.x==weapon.x && player.y==weapon.y) {
			weaponShot=false;
		}*/


		
		//System.out.println(player.x + " " + weaponx);
		
		//System.out.println(weapon.x+movex + " " + weapon.y);


		/*
		playerup.draw();
		playerdown.draw();
		playerleft.draw();
		playerright.draw();

		enemy1up.draw();
		enemy1down.draw();
		enemy1left.draw();
		enemy1right.draw();

		enemy2up.draw();
		enemy2down.draw();
		enemy2left.draw();
		enemy2right.draw();

		enemy3up.draw();
		enemy3down.draw();
		enemy3left.draw();
		enemy3right.draw();
		 */

		
		//rect(player.x, player.y, player.width, player.height); // Draw player
		player.draw();




	}

	public void buildings() {

		int marker;

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


		rects.add(new ColorfulRectangle(movex+300,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-250, 50, 50, Color.WHITE)); 
		rects.add(new ColorfulRectangle(movex+250,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+-300, 50, 50, Color.WHITE));


		rects.add(new ColorfulRectangle(movex+-550,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+300, 50, 50, Color.WHITE));


		rects.add(new ColorfulRectangle(movex+-550,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+-150, 50, 50, Color.WHITE));


		rects.add(new ColorfulRectangle(movex+350,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-700, 50, 50, Color.WHITE));


		rects.add(new ColorfulRectangle(movex+-50,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+-450, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+100,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+550, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+550,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+100, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+700,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-500, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+1000,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-550, 50, 50, Color.WHITE));


		rects.add(new ColorfulRectangle(movex+1100,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-250, 50, 50, Color.WHITE));
		
		
		rects.add(new ColorfulRectangle(movex+-850,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-250, 50, 50, Color.WHITE));
		
		
		rects.add(new ColorfulRectangle(movex+-700,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+1050, 50, 50, Color.WHITE));
		
		
		rects.add(new ColorfulRectangle(movex+-550,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-450, 50, 50, Color.WHITE));
		
		
		rects.add(new ColorfulRectangle(movex+-650,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+0,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+-850, 50, 50, Color.WHITE));

		
		rects.add(new ColorfulRectangle(movex+-1050,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+100, 50, 50, Color.WHITE));
		
		
		rects.add(new ColorfulRectangle(movex+600,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+500, 50, 50, Color.WHITE));
		
		
		rects.add(new ColorfulRectangle(movex+-900,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+-500, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+50,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+1000, 50, 50, Color.WHITE));

		
		rects.add(new ColorfulRectangle(movex+50,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+1250, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(movex+750,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+1050, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(movex+750,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+1000, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+1250,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+450, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+1350,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-200, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-500,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-1100, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-50,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+1300, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-800,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+1200, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-1150,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+1250, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-1700,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+1200, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(movex+-1250,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+600, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-1400,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+300, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-1750,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+700, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-2050,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+950, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-2250,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+1400, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-1450,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+-50, 50, 50, Color.WHITE));

		
		
		
		
		
		
		//TOP BORDER
		rects.add(new ColorfulRectangle(movex+-800,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2350,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+0,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2000,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2050,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2100,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2150,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2200,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2250,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2300,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2350,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2400,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2450,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2500,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2550,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2600,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2650,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2700,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2750,movey+-1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2800,movey+-1200, 50, 50, Color.WHITE));
		
		
		//LEFT BORDER
		rects.add(new ColorfulRectangle(movex+-2400,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2400,movey+1450, 50, 50, Color.WHITE));

		
		//BOTTOM BORDER
		rects.add(new ColorfulRectangle(movex+-2400,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2350,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1500,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1250,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1200,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1150,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1100,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1050,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1000,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-950,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-900,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-850,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-800,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-750,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-700,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-650,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-600,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-550,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-500,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-400,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-350,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-250,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-150,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-50,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+0,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+50,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+150,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+250,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+350,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+450,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+500,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+800,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+900,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1050,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2000,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2050,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2100,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2150,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2200,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2250,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2300,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2350,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2400,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2450,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2500,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2550,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2600,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2650,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2700,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2750,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2800,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2850,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2900,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+2950,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+3000,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+3050,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+3100,movey+1450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+3150,movey+1450, 50, 50, Color.WHITE));

		
				
		
		//WALL
		if(wall1==true) {
			rects.add(new ColorfulRectangle(movex+450,movey+-50, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+0, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+50, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+100, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+150, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+200, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+250, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+300, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+350, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+400, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+450, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+500, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+550, 50, 50, Color.DARK_GRAY));		
			rects.add(new ColorfulRectangle(movex+0,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+50,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+100,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+150,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+200,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+250,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+300,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+350,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+400,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+400,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+450,movey+600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-500,movey+650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-450,movey+650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-400,movey+650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-350,movey+650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-300,movey+650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-900,movey+50, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-900,movey+0, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+500,movey+-100, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+550,movey+-100, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+550,movey+-150, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+550,movey+-200, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+550,movey+-250, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+550,movey+-300, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+550,movey+-350, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+550,movey+-400, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+0,movey+-700, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-350,movey+-450, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-350,movey+-400, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-350,movey+-350, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-550,movey+0, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-550,movey+50, 50, 50, Color.DARK_GRAY));
		}

		
		
		//WALL 2
		if(wall2==true) {
			rects.add(new ColorfulRectangle(movex+-450,movey+-800, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-450,movey+-850, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-800,movey+-450, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-850,movey+-450, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+1050,movey+150, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+1050,movey+100, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+1250,movey+-250, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+1000,movey+-600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+1000,movey+-650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+200,movey+-800, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+0,movey+800, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+600,movey+650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-450,movey+-550, 50, 50, Color.DARK_GRAY));


		}

		
		

		int marker2;
	}

	public void buildings2() {
		
		rects.add(new ColorfulRectangle(movex+-2300,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+350, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-2000,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-500, 50, 50, Color.WHITE));

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


	boolean enemyInterectsBlock(Enemy e) {
		for(Rectangle r: rects) {
			//if(r!=bullet && r!=btv1 && r!=btv2 && r!=bth1 && r!=bth2) {
				if( r.intersects(e)){
					return true;
				}
			//}
		}
		return false;
	}

//	boolean enemy2InterectsBlock() {
//		for(Rectangle r: rects) {
//			if(r!=bullet && r!=btv1 && r!=btv2 && r!=bth1 && r!=bth2) {
//				if( r.intersects(enemy2)){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
//	boolean enemy3InterectsBlock() {
//		for(Rectangle r: rects) {
//			if(r!=bullet && r!=btv1 && r!=btv2 && r!=bth1 && r!=bth2) {
//				if( r.intersects(enemy3)){
//					return true;
//				}
//			}
//		}
//		return false;
//	}

	
	boolean weaponInterectsBlock() {
		for(Rectangle r: rects) {
			if( r.intersects(weapon)){
				return true;
			}
		}
		return false;
	}

	
	

	boolean playerupInterectsBlock() {
		for(Rectangle r: rects) {
			if( r.intersects(playerup)){
				return true;
			}
		}
		return false;
	}

	boolean playerdownInterectsBlock() {
		for(Rectangle r: rects) {
			if( r.intersects(playerdown)){
				return true;
			}
		}
		return false;
	}

	boolean playerleftInterectsBlock() {
		for(Rectangle r: rects) {
			if( r.intersects(playerleft)){
				return true;
			}
		}
		return false;
	}

	boolean playerrightInterectsBlock() {
		for(Rectangle r: rects) {
			if( r.intersects(playerright)){
				return true;
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

				if(playerupInterectsBlock()==false) {
					movey+=50;
					facing=1;
				}

				if(build==true){
					rects.clear();
				}

				if(playerInterectsBlock()) {
					movey-=50;
				}				

			} else if (keyCode == DOWN) {

				if(playerdownInterectsBlock()==false) { 
					movey-=50;
					facing=3;
				}

				if(build==true){
					rects.clear();
				}

				if(playerInterectsBlock()) {
					movey+=50;
				}

			} else if (keyCode == LEFT) {

				if(playerleftInterectsBlock()==false) {
					movex+=50;
					facing=2;
				}

				if(build==true){
					rects.clear();
				}

				if(playerInterectsBlock()) {
					movex-=50;
				}	

			} else if (keyCode == RIGHT) {

				if(playerrightInterectsBlock()==false) {
					movex-=50;
					facing=4;
				}

				if(build==true){
					rects.clear();
				}

				if(playerInterectsBlock()) {
					movex+=50;
				}
			} else if (keyCode == SHIFT) {
				att=1;
			} else if (keyCode == ALT) {
				
				if(wall1==true) {
					wall1=false;
				}else if(wall1==false) {
					wall1=true;
				}
				
				if(wall2==true) {
					wall2=false;
				}else if(wall2==false) {
					wall2=true;
				}
				
				shoot=1;

				//collectedKeys+=1;

				//rects.clear();

			}

		}

	}





	public void mousePressed() {


		int moX = ((mouseX/50)*50)+-movex;
		int moY = ((mouseY/50)*50)+-movey;

		//System.out.println("X:" + moX + "   Y:" + moY);

		//System.out.println("rects.add(new ColorfulRectangle("+ "movex+"+ moX +",movey+" + moY + ", 50, 50, Color.DARK_GRAY));");
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




		public void setDirection() {
			// TODO Auto-generated method stub

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




	class Enemy extends ColorfulRectangle{
		boolean alive = true;

		int enemyfacing = 0;

		int emovedx;
		int emovedy;

		ColorfulRectangle enemyup = new ColorfulRectangle(x,y-50,10,10,Color.RED);
		ColorfulRectangle enemydown = new ColorfulRectangle(x,y+50,10,10, Color.RED);
		ColorfulRectangle enemyleft = new ColorfulRectangle(x-50,y,10,10, Color.RED);
		ColorfulRectangle enemyright = new ColorfulRectangle(x+50,y,10,10, Color.RED);
		
		ColorfulRectangle enemyup_green = new ColorfulRectangle(x,y-10,10,10,Color.GREEN);
		ColorfulRectangle enemydown_green = new ColorfulRectangle(x,y+50,10,10, Color.GREEN);
		ColorfulRectangle enemyleft_green = new ColorfulRectangle(x-10,y,10,10, Color.GREEN);
		ColorfulRectangle enemyright_green = new ColorfulRectangle(x+50,y,10,10, Color.GREEN);


		List<ColorfulRectangle> direction = new ArrayList<ColorfulRectangle>();

		public Enemy(int x, int y, int width, int height) {


			super(x, y, width, height, Color.RED);

			direction.add(enemyup);
			direction.add(enemydown);
			direction.add(enemyright);
			direction.add(enemyleft);



		}
		void draw() {
			if(alive) {
				super.draw();
			}
		}

		boolean intersectsBlock(Rectangle intblock) {
			for(Rectangle r: rects) {
				if( r.intersects(intblock)){
					return true;
				}
			}
			return false;
		}


				boolean enemyupInterectsBlock() {
					for(Rectangle r: rects) {
							if( r.intersects(enemyup)){
								return true;
							}
					}
					return false;
				}
				
				boolean enemydownInterectsBlock() {
					for(Rectangle r: rects) {
							if( r.intersects(enemydown)){
								return true;
						}
					}
					return false;
				}
		
				boolean enemyleftInterectsBlock() {
					for(Rectangle r: rects) {
							if( r.intersects(enemyleft)){
								return true;
						}
					}
					return false;
				}
		
				boolean enemyrightInterectsBlock() {
					for(Rectangle r: rects) {
							if( r.intersects(enemyright)){
								return true;
							}
					}
					return false;
				}

		public void update() {

			if(!alive){
				x=-10000;
				y=-10000;
			}

			

			enemyup.x=x;
			enemyup.y=y-50;
			enemydown.x=x;
			enemydown.y=y+50;
			enemyleft.x=x-50;
			enemyleft.y=y;
			enemyright.x=x+50;
			enemyright.y=y;
			
		
			x=movex+emovedx;
			y=movey+emovedy;

	/////		enemyfacing = new Random().nextInt(3)+1;
			
			if(intersectsBlock(enemydown) && intersectsBlock(enemyright) && intersectsBlock(enemyleft)) {
				enemyfacing=1;
			}
			if(intersectsBlock(enemyup) && intersectsBlock(enemyright) && intersectsBlock(enemyleft)) {
				enemyfacing=2;
			}
			if(intersectsBlock(enemyup) && intersectsBlock(enemydown) && intersectsBlock(enemyleft)) {
				enemyfacing=3;
			}
			if(intersectsBlock(enemyup) && intersectsBlock(enemydown) && intersectsBlock(enemyright)) {
				enemyfacing=4;
			}
			
			
			if(enemymove == true) {

				wait+=1;

				if(wait>=150) {
					wait=0;


					if(enemymove == true) {
						
//						if(enemyfacing==1) {
//							enemymovey-=50;
//						}
//						if(enemyfacing==2) {
//							enemymovey+=50;
//						}
//						if(enemyfacing==3) {
//							enemymovex+=50;
//						}
//						if(enemyfacing==4) {
//							enemymovex-=50;
//						}
						
						
						for (int i = 0; i < 100; i++) {
							enemyRandomMove = new Random().nextInt(4);
							//System.out.println(enemyRandomMove);
							
							if(enemyfacing!=2) {
								if(!intersectsBlock(enemyup)) {
									if(enemyRandomMove==0) {
										emovedy-=50;
										enemyfacing=1;
										break;
									}
								}
							}
							if(enemyfacing!=1) {
								if(!intersectsBlock(enemydown)) {
									if(enemyRandomMove==1) {
										emovedy+=50;
										enemyfacing=2;	
										break;
									}
								}
							}
							if(enemyfacing!=4) {
								if(!intersectsBlock(enemyright)) {
									if(enemyRandomMove==2) {
										emovedx+=50;
										enemyfacing=3;
										break;
									}
								}
							}
							if(enemyfacing!=3) {
								if(!intersectsBlock(enemyleft)) {
									if(enemyRandomMove==3) {
										emovedx-=50;
										enemyfacing=4;
										break;
									}
								}
							}

						}
					/*	if(enemyInterectsBlock(this)) {
							if(enemyfacing==1) {
								emovedy+=50;
							}		
							if(enemyfacing==2) {
								emovedy-=50;
							}
							if(enemyfacing==3) {
								emovedx-=50;
							}
							if(enemyfacing==4) {
								emovedx+=50;
							}
						}*/

					}					
					
					
					//System.out.println("up: " + enemyup + "right: " + enemyright);
					//System.out.println(enemyfacing);
					//System.out.println(enemyInterectsBlock(this));
				}
			}
		}

	}
	
	
	class Key extends ColorfulRectangle{

		int keyx=x;
		int keyy=y;
		

		boolean collected = false;

		public Key(int x, int y, int width, int height) {

			super(x, y, width, height, Color.YELLOW);

		}
		
		
		
		void draw() {
			

			if(!collected) {
				super.draw();
			}	
		}
		
		public void update() {
		
		x=keyx+movex;
		y=keyy+movey;
		
		if(x==player.x && y==player.y){
			collectedKeys+=1;
			keyx=-10000;
			keyy=-10000;
		}
		
		}

	}

	
	
	class Door extends ColorfulRectangle{

		int doorx=x;
		int doory=y;
		
		boolean open = false;

		public Door(int x, int y, int width, int height) {

			super(x, y, width, height, Color.WHITE);


		}
		
		
		void draw() {
			
			if(!open) {
				super.draw();
			}	
		}
		
		public void update() {
		
			ColorfulRectangle Doorin = new ColorfulRectangle(x+10,y+10,30,30,Color.YELLOW);
			Doorin.draw();
			
		x=doorx+movex;
		y=doory+movey;
		
		if(x==player.x && y==player.y && collectedKeys>=1){
			collectedKeys-=1;
			doorx=-10000;
			doory=-10000;
			Doorin.x=-10000;
			Doorin.y=-10000;

		}else if(x==player.x && y==player.y && collectedKeys==0){
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
		
		}

	}

	
	
	class PinkKey extends ColorfulRectangle{

		int pinkkeyx=x;
		int pinkkeyy=y;
		

		boolean collected = false;

		public PinkKey(int x, int y, int width, int height) {

			super(x, y, width, height, Color.PINK);

		}
		
		
		
		void draw() {
			

			if(!collected) {
				super.draw();
			}	
		}
		
		public void update() {
		
		x=pinkkeyx+movex;
		y=pinkkeyy+movey;
		
		if(x==player.x && y==player.y){
			collectedPinkKeys+=1;
			pinkkeyx=-10000;
			pinkkeyy=-10000;
		}
		
		}

	}


	
	class PinkDoor extends ColorfulRectangle{

		int pinkdoorx=x;
		int pinkdoory=y;
		
		boolean open = false;

		public PinkDoor(int x, int y, int width, int height) {

			super(x, y, width, height, Color.WHITE);


		}
		
		
		void draw() {
			
			if(!open) {
				super.draw();
			}	
		}
		
		public void update() {
		
			ColorfulRectangle PinkDoorin = new ColorfulRectangle(x+10,y+10,30,30,Color.PINK);
			PinkDoorin.draw();
			
		x=pinkdoorx+movex;
		y=pinkdoory+movey;
		
		if(x==player.x && y==player.y && collectedPinkKeys>=1){
			collectedPinkKeys-=1;
			pinkdoorx=-10000;
			pinkdoory=-10000;
			PinkDoorin.x=-10000;
			PinkDoorin.y=-10000;

		}else if(x==player.x && y==player.y && collectedPinkKeys==0){
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
		
		}

	}
	
	
	class OrangeKey extends ColorfulRectangle{

		int orangekeyx=x;
		int orangekeyy=y;
		

		boolean collected = false;

		public OrangeKey(int x, int y, int width, int height) {

			super(x, y, width, height, Color.ORANGE);

		}
		
		
		
		void draw() {
			

			if(!collected) {
				super.draw();
			}	
		}
		
		public void update() {
		
		x=orangekeyx+movex;
		y=orangekeyy+movey;
		
		if(x==player.x && y==player.y){
			collectedOrangeKeys+=1;
			orangekeyx=-10000;
			orangekeyy=-10000;
		}
		
		}

	}


	class OrangeDoor extends ColorfulRectangle{

		int orangedoorx=x;
		int orangedoory=y;
		
		boolean open = false;

		public OrangeDoor(int x, int y, int width, int height) {

			super(x, y, width, height, Color.WHITE);


		}
		
		
		void draw() {
			
			if(!open) {
				super.draw();
			}	
		}
		
		public void update() {
		
			ColorfulRectangle OrangeDoorin = new ColorfulRectangle(x+10,y+10,30,30,Color.ORANGE);
			OrangeDoorin.draw();
			
		x=orangedoorx+movex;
		y=orangedoory+movey;
		
		if(x==player.x && y==player.y && collectedPinkKeys>=1){
			collectedPinkKeys-=1;
			orangedoorx=-10000;
			orangedoory=-10000;
			OrangeDoorin.x=-10000;
			OrangeDoorin.y=-10000;

		}else if(x==player.x && y==player.y && collectedOrangeKeys==0){
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
		
		}

	}

	
}
