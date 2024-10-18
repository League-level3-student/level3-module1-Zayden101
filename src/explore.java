

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
	int collectedBlueKeys = 0;
	int collectedEndingKeys = 0;

	
	int totalYellowKeyCollected = 0;
	int totalPinkKeyCollected = 0;
	int totalOrangeKeyCollected = 0;
	int totalBlueKeyCollected = 0;
	int totalEndingKeyCollected = 0;


	int randomxred = 0;
	int randomyred = 0;
	int randomxorange = 0;
	int randomyorange = 0;
	int randomxyellow = 0;
	int randomyyellow = 0;
	int randomxgreen = 0;
	int randomygreen = 0;
	int randomxblue = 0;
	int randomyblue = 0;
	int randomxpurple = 0;
	int randomypurple = 0;
	int randomxgrey = 0;
	int randomygrey = 0;
	int randomxwhite = 0;
	int randomywhite = 0;
	

	int colorSwitch2 = 0;
	int colorSwitchdoor = 0;
	
	
	
	



	
	boolean finished = false;
	boolean displayEndingkey = false;
	
	
	int arandomxred = 0;
	int arandomyred = 0;
	int arandomxorange = 0;
	int arandomyorange = 0;
	int arandomxyellow = 0;
	int arandomyyellow = 0;
	int arandomxgreen = 0;
	int arandomygreen = 0;
	int arandomxblue = 0;
	int arandomyblue = 0;
	int arandomxpurple = 0;
	int arandomypurple = 0;
	int arandomxgrey = 0;
	int arandomygrey = 0;
	int arandomxwhite = 0;
	int arandomywhite = 0;
	
	int endingBlockSwitch = 0;

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
	Door door7 = new Door(movex-1500,movey+350,50,50);


	PinkDoor pinkdoor1 = new PinkDoor(movex-850,movey+800,50,50);
	PinkDoor pinkdoor2 = new PinkDoor(movex-1000,movey-600,50,50);
	PinkDoor pinkdoor3 = new PinkDoor(movex-1550,movey+350,50,50);
	PinkDoor pinkdoor4 = new PinkDoor(movex-600,movey-850,50,50);
	PinkDoor pinkdoor5 = new PinkDoor(movex+1750,movey-300,50,50);

	
	OrangeDoor orangedoor1 = new OrangeDoor(movex+150,movey+1350,50,50);
	OrangeDoor orangedoor2 = new OrangeDoor(movex-850,movey-800,50,50);
	OrangeDoor orangedoor3 = new OrangeDoor(movex+1000,movey-600,50,50);
	OrangeDoor orangedoor4 = new OrangeDoor(movex-1700,movey-800,50,50);
	OrangeDoor orangedoor5 = new OrangeDoor(movex+1450,movey+1350,50,50);


	BlueDoor bluedoor1 = new BlueDoor(movex-2150,movey-1050,50,50);
	BlueDoor bluedoor2 = new BlueDoor(movex-2200,movey-1150,50,50);
	BlueDoor bluedoor3 = new BlueDoor(movex-2350,movey-800,50,50);
	BlueDoor bluedoor4 = new BlueDoor(movex-1900,movey-1150,50,50);
	BlueDoor bluedoor5 = new BlueDoor(movex-1800,movey-800,50,50);

	Endingdoor endingdoor1 = new Endingdoor(movex+450,movey-1200,50,50);
	Endingdoor endingdoor2 = new Endingdoor(movex+400,movey+1050,50,50);

	
	
	
	Key key1 = new Key(movex+500,movey-500,50,50);
	Key key2 = new Key(movex-800,movey+550,50,50);
	Key key3 = new Key(movex-300,movey-550,50,50);
	Key key4 = new Key(movex-350,movey+850,50,50);
	Key key5 = new Key(movex+150,movey+500,50,50);
	Key key6 = new Key(movex-2250,movey-400,50,50);
	Key key7 = new Key(movex-100,movey-1050,50,50);


	PinkKey pinkkey1 = new PinkKey(movex+1000,movey+550,50,50);
	PinkKey pinkkey2 = new PinkKey(movex+800,movey+1250,50,50);
	PinkKey pinkkey3 = new PinkKey(movex-2150,movey+100,50,50);
	PinkKey pinkkey4 = new PinkKey(movex-800,movey-1150,50,50);
	PinkKey pinkkey5 = new PinkKey(movex+-100,movey+1050,50,50);


	OrangeKey orangekey1 = new OrangeKey(movex-1300,movey-450,50,50);
	OrangeKey orangekey2 = new OrangeKey(movex+1200,movey+150,50,50);
	OrangeKey orangekey3 = new OrangeKey(movex+1450,movey-150,50,50);
	OrangeKey orangekey4 = new OrangeKey(movex-1550,movey+450,50,50);
	OrangeKey orangekey5 = new OrangeKey(movex+700,movey-1050,50,50);
	


	BlueKey bluekey1 = new BlueKey(movex-750,movey-850,50,50);
	BlueKey bluekey2 = new BlueKey(movex+100,movey+1200,50,50);
	BlueKey bluekey3 = new BlueKey(movex+1900,movey+1250,50,50);
	BlueKey bluekey4 = new BlueKey(movex+1650,movey-400,50,50);
	BlueKey bluekey5 = new BlueKey(movex+1800,movey-950,50,50);

	
	
	Ending Ending = new Ending(movex-2350,movey-1150,50,50);

	
	
	
//rects.add(new ColorfulRectangle(movex+600,movey+1000, 50, 50, Color.WHITE));
	//rects.add(new ColorfulRectangle(movex+100,movey+750, 50, 50, Color.WHITE));

	
	int waitTime = 25;


	String enemy1upDisplay = "";
	String enemy1downDisplay = "";
	String enemy1leftDisplay = "";
	String enemy1rightDisplay = "";

	List<Rectangle> enemyList = new ArrayList<Rectangle>();


	boolean build = true;
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
		
		finished=false;

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


		
		//movex+100,movey+750
		//movex+600,movey+1000

		
    	randomxred = new Random().nextInt(500);
    	randomyred = new Random().nextInt(250);
    	randomxorange = new Random().nextInt(500);
    	randomyorange = new Random().nextInt(250);
    	randomxyellow = new Random().nextInt(500);
    	randomyyellow = new Random().nextInt(250);
    	randomxgreen = new Random().nextInt(500);
    	randomygreen = new Random().nextInt(250);
    	randomxblue = new Random().nextInt(500);
    	randomyblue = new Random().nextInt(250);
    	randomxpurple = new Random().nextInt(500);
    	randomypurple = new Random().nextInt(250);
    	randomxgrey = new Random().nextInt(500);
    	randomygrey = new Random().nextInt(250);
    	randomxwhite = new Random().nextInt(500);
    	randomywhite = new Random().nextInt(250);


		
		ColorfulRectangle Endingred2 = new ColorfulRectangle(movex+randomxred+100,movey+randomyred+750,50,50,Color.RED);
		ColorfulRectangle Endingorange2 = new ColorfulRectangle(movex+randomxorange+100,movey+randomyorange+750,45,45,Color.ORANGE);
		ColorfulRectangle Endingyellow2 = new ColorfulRectangle(movex+randomxyellow+100,movey+randomyyellow+750,40,40,Color.YELLOW);
		ColorfulRectangle Endinggreen2 = new ColorfulRectangle(movex+randomxgreen+100,movey+randomygreen+750,35,35,Color.GREEN);
		ColorfulRectangle Endingblue2 = new ColorfulRectangle(movex+randomxblue+100,movey+randomyblue+750,30,30,Color.BLUE);
		ColorfulRectangle Endingpurple2 = new ColorfulRectangle(movex+randomxpurple+100,movey+randomypurple+750,25,25,Color.MAGENTA);
		ColorfulRectangle Endinggray2 = new ColorfulRectangle(movex+randomxgrey+100,movey+randomygrey+750,20,20,Color.LIGHT_GRAY);
		ColorfulRectangle Endingwhite2 = new ColorfulRectangle(movex+randomxwhite+100,movey+randomywhite+750,15,15,Color.WHITE);
		 
		Endingred2.draw();
		Endingorange2.draw();
		Endingyellow2.draw();
		Endinggreen2.draw();
		Endingblue2.draw();
		Endingpurple2.draw();
		Endinggray2.draw();
		Endingwhite2.draw();
	


		//300-800
		
		
		
		if(player.x==movex-2350 && player.y==movey-1150) {
			movex=50;
			movey=-600;
			finished=true;
			collectedEndingKeys=2;
		}
		
		
		if(finished==true) {
    	arandomxred = new Random().nextInt(4300);
    	arandomyred = new Random().nextInt(3100);
    	arandomxorange = new Random().nextInt(4300);
    	arandomyorange = new Random().nextInt(3100);
    	arandomxyellow = new Random().nextInt(4300);
    	arandomyyellow = new Random().nextInt(3100);
    	arandomxgreen = new Random().nextInt(4300);
    	arandomygreen = new Random().nextInt(3100);
    	arandomxblue = new Random().nextInt(4300);
    	arandomyblue = new Random().nextInt(3100);
    	arandomxpurple = new Random().nextInt(4300);
    	arandomypurple = new Random().nextInt(3100);
    	arandomxgrey = new Random().nextInt(4300);
    	arandomygrey = new Random().nextInt(3100);
    	arandomxwhite = new Random().nextInt(4300);
    	arandomywhite = new Random().nextInt(3100);
		ColorfulRectangle aEndingred2 = new ColorfulRectangle(movex+arandomxred-2350,movey+arandomyred-1150,50,50,Color.RED);
		ColorfulRectangle aEndingorange2 = new ColorfulRectangle(movex+arandomxorange-2350,movey+arandomyorange-1150,45,45,Color.ORANGE);
		ColorfulRectangle aEndingyellow2 = new ColorfulRectangle(movex+arandomxyellow-2350,movey+arandomyyellow-1150,40,40,Color.YELLOW);
		ColorfulRectangle aEndinggreen2 = new ColorfulRectangle(movex+arandomxgreen-2350,movey+arandomygreen-1150,35,35,Color.GREEN);
		ColorfulRectangle aEndingblue2 = new ColorfulRectangle(movex+arandomxblue-2350,movey+arandomyblue-1150,30,30,Color.BLUE);
		ColorfulRectangle aEndingpurple2 = new ColorfulRectangle(movex+arandomxpurple-2350,movey+arandomypurple-1150,25,25,Color.MAGENTA);
		ColorfulRectangle aEndinggray2 = new ColorfulRectangle(movex+arandomxgrey-2350,movey+arandomygrey-1150,20,20,Color.LIGHT_GRAY);
		ColorfulRectangle aEndingwhite2 = new ColorfulRectangle(movex+arandomxwhite-2350,movey+arandomywhite-1150,15,15,Color.WHITE);
		aEndingred2.draw();
		aEndingorange2.draw();
		aEndingyellow2.draw();
		aEndinggreen2.draw();
		aEndingblue2.draw();
		aEndingpurple2.draw();
		aEndinggray2.draw();
		aEndingwhite2.draw();
		
		
		}

		
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

		
		
		if(finished==true) {
		endingBlocks();
		}


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

		



		ColorfulRectangle displaykey = new ColorfulRectangle(660,10, 30, 30, Color.YELLOW);
		
		ColorfulRectangle displaypinkkey = new ColorfulRectangle(510,10, 30, 30, Color.PINK);

		ColorfulRectangle displayorangekey = new ColorfulRectangle(360,10, 30, 30, Color.ORANGE);

		ColorfulRectangle displaybluekey = new ColorfulRectangle(210,10, 30, 30, Color.CYAN);

		ColorfulRectangle displayendingkey = new ColorfulRectangle(6000,10, 30, 30, Color.WHITE);
		
		if(finished==true) {
		ColorfulRectangle displayEndingred = new ColorfulRectangle(660,10,30,30,Color.RED);
		ColorfulRectangle displayEndingorange = new ColorfulRectangle(660,10,30,30,Color.ORANGE);
		ColorfulRectangle displayEndingyellow = new ColorfulRectangle(660,10,30,30,Color.YELLOW);
		ColorfulRectangle displayEndinggreen = new ColorfulRectangle(660,10,30,30,Color.GREEN);
		ColorfulRectangle displayEndingblue = new ColorfulRectangle(660,10,30,30,Color.BLUE);
		ColorfulRectangle displayEndingpurple = new ColorfulRectangle(660,10,30,30,Color.MAGENTA);
		ColorfulRectangle displayEndinggray = new ColorfulRectangle(660,10,30,30,Color.LIGHT_GRAY);
		ColorfulRectangle displayEndingwhite = new ColorfulRectangle(660,10,30,30,Color.WHITE);


		if(colorSwitchdoor==0) {
			displayEndingred.draw();
		}else if(colorSwitchdoor==1) {
			displayEndingorange.draw();
		}else if(colorSwitchdoor==2) {
			displayEndingyellow.draw();
		}else if(colorSwitchdoor==3) {
			displayEndinggreen.draw();
		}else if(colorSwitchdoor==4) {
			displayEndingblue.draw();
		}else if(colorSwitchdoor==5) {
			displayEndingpurple.draw();
		}else if(colorSwitchdoor==6) {
			displayEndinggray.draw();
		}else if(colorSwitchdoor==7) {
			displayEndingwhite.draw();
		}
		
		colorSwitchdoor+=1;
		
		if(colorSwitchdoor>=8) {
			colorSwitchdoor=0;
			}
		}

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
		if(collectedOrangeKeys==0) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(410,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(410,10, 10, 30, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(410,40, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(430,10, 10, 30, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();

		}else if(collectedOrangeKeys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(420,0, 10, 50, Color.WHITE);
			keynum1.draw();

		}else if(collectedOrangeKeys==2) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(410,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(430,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(410,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(410,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(410,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedOrangeKeys==3) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(410,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(430,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(410,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(430,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(410,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedOrangeKeys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(410,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(410,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(430,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
		}else if(collectedOrangeKeys==5) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(410,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(410,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(410,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(430,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(410,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();
		}

		
		
		//BLUE KEY COUNTER
		if(collectedBlueKeys==0) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(260,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(260,10, 10, 30, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(260,40, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(280,10, 10, 30, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();

		}else if(collectedBlueKeys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(270,0, 10, 50, Color.WHITE);
			keynum1.draw();

		}else if(collectedBlueKeys==2) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(260,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(280,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(260,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(260,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(260,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedBlueKeys==3) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(260,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(280,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(260,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(280,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(260,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();

		}else if(collectedBlueKeys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(260,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(260,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(280,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
		}else if(collectedBlueKeys==5) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(260,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(260,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(260,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(280,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(260,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();
		}
		
		
		if(finished==true) {
		//ENDING KEY COUNTER
		if(collectedEndingKeys==0) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(710,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(710,10, 10, 30, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(710,40, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(730,10, 10, 30, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();

		}else if(collectedEndingKeys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(720,0, 10, 50, Color.WHITE);
			keynum1.draw();

		}else if(collectedEndingKeys==2) {
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

		}else if(collectedEndingKeys==3) {
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

		}else if(collectedEndingKeys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(710,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(710,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(730,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
			
		}else if(collectedEndingKeys==5) {
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
		}
		
		
		
		
		if(totalYellowKeyCollected==7 && collectedKeys<=0) {
			collectedKeys=-1;
		}else {
			displaykey.draw();
		}
		
		if(totalPinkKeyCollected==5 && collectedPinkKeys<=0) {
			collectedPinkKeys=-1;
		}else {
			displaypinkkey.draw();
		}
		
		if(totalOrangeKeyCollected==5 && collectedOrangeKeys<=0) {
			collectedOrangeKeys=-1;
		}else {
			displayorangekey.draw();
		}
		
		if(totalBlueKeyCollected==5 && collectedBlueKeys<=0) {
			collectedBlueKeys=-1;
		}else {
			displaybluekey.draw();
		}
		
		if(finished==true) {
			if(collectedEndingKeys<=0) {
				collectedEndingKeys=-1;
			}else {
				displayendingkey.draw();
			}
		}
		
		
		
		if(finished==false){
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
		
		door6.draw();
		door6.update();
		
		door7.draw();
		door7.update();



		pinkdoor1.draw();
		pinkdoor1.update();

		pinkdoor2.draw();
		pinkdoor2.update();
		
		pinkdoor3.draw();
		pinkdoor3.update();
		
		pinkdoor4.draw();
		pinkdoor4.update();

		pinkdoor5.draw();
		pinkdoor5.update();



		orangedoor1.draw();
		orangedoor1.update();
		
		orangedoor2.draw();
		orangedoor2.update();
		
		orangedoor3.draw();
		orangedoor3.update();

		orangedoor4.draw();
		orangedoor4.update();
		
		orangedoor5.draw();
		orangedoor5.update();


		
		bluedoor1.draw();
		bluedoor1.update();
		
		bluedoor2.draw();
		bluedoor2.update();
		
		bluedoor3.draw();
		bluedoor3.update();
		
		bluedoor4.draw();
		bluedoor4.update();
		
		bluedoor5.draw();
		bluedoor5.update();


		
		
		
		
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

		key7.draw();
		key7.update();

		
		pinkkey1.draw();
		pinkkey1.update();

		pinkkey2.draw();
		pinkkey2.update();

		pinkkey3.draw();
		pinkkey3.update();

		pinkkey4.draw();
		pinkkey4.update();
		
		pinkkey5.draw();
		pinkkey5.update();
		
		
		orangekey1.draw();
		orangekey1.update();
		
		orangekey2.draw();
		orangekey2.update();
		
		orangekey3.draw();
		orangekey3.update();

		orangekey4.draw();
		orangekey4.update();

		orangekey5.draw();
		orangekey5.update();



		bluekey1.draw();
		bluekey1.update();

		bluekey2.draw();
		bluekey2.update();
		
		bluekey3.draw();
		bluekey3.update();
		
		bluekey4.draw();
		bluekey4.update();

		bluekey5.draw();
		bluekey5.update();
	}
		
		
		Ending.draw();
		Ending.update();
		
		
		endingdoor1.draw();
		endingdoor1.update();

		endingdoor2.draw();
		endingdoor2.update();

		
		
		
		
		weapon.draw();

		//System.out.println(endingBlockSwitch);
		

		
		
		
		
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
	
	
	public void endingBlocks() {
		int marker;

		
		ColorfulRectangle buildings2ChangeColorRect1;
		ColorfulRectangle buildings2ChangeColorRect2;
		ColorfulRectangle buildings2ChangeColorRect3;
		ColorfulRectangle buildings2ChangeColorRect4;
		ColorfulRectangle buildings2ChangeColorRect5;
		ColorfulRectangle buildings2ChangeColorRect6;
		ColorfulRectangle buildings2ChangeColorRect7;
		ColorfulRectangle buildings2ChangeColorRect8;
		ColorfulRectangle buildings2ChangeColorRect9;
		ColorfulRectangle buildings2ChangeColorRect10;
		ColorfulRectangle buildings2ChangeColorRect11;
		ColorfulRectangle buildings2ChangeColorRect12;
		ColorfulRectangle buildings2ChangeColorRect13;
		ColorfulRectangle buildings2ChangeColorRect14;
		ColorfulRectangle buildings2ChangeColorRect15;
		ColorfulRectangle buildings2ChangeColorRect16;
		ColorfulRectangle buildings2ChangeColorRect17;
		ColorfulRectangle buildings2ChangeColorRect18;
		ColorfulRectangle buildings2ChangeColorRect19;
		ColorfulRectangle buildings2ChangeColorRect20;
		ColorfulRectangle buildings2ChangeColorRect21;
		ColorfulRectangle buildings2ChangeColorRect22;
		ColorfulRectangle buildings2ChangeColorRect23;
		ColorfulRectangle buildings2ChangeColorRect24;
		ColorfulRectangle buildings2ChangeColorRect25;
		ColorfulRectangle buildings2ChangeColorRect26;
		ColorfulRectangle buildings2ChangeColorRect27;
		ColorfulRectangle buildings2ChangeColorRect28;
		ColorfulRectangle buildings2ChangeColorRect29;
		ColorfulRectangle buildings2ChangeColorRect30;
		ColorfulRectangle buildings2ChangeColorRect31;
		ColorfulRectangle buildings2ChangeColorRect32;
		ColorfulRectangle buildings2ChangeColorRect33;
		ColorfulRectangle buildings2ChangeColorRect34;
		ColorfulRectangle buildings2ChangeColorRect35;
		ColorfulRectangle buildings2ChangeColorRect36;
		ColorfulRectangle buildings2ChangeColorRect37;
		ColorfulRectangle buildings2ChangeColorRect38;
		ColorfulRectangle buildings2ChangeColorRect39;
		ColorfulRectangle buildings2ChangeColorRect40;
		ColorfulRectangle buildings2ChangeColorRect41;
		ColorfulRectangle buildings2ChangeColorRect42;
		ColorfulRectangle buildings2ChangeColorRect43;
		ColorfulRectangle buildings2ChangeColorRect44;
		ColorfulRectangle buildings2ChangeColorRect45;
		ColorfulRectangle buildings2ChangeColorRect46;
		ColorfulRectangle buildings2ChangeColorRect47;
		ColorfulRectangle buildings2ChangeColorRect48;
		ColorfulRectangle buildings2ChangeColorRect49;
		ColorfulRectangle buildings2ChangeColorRect50;
		ColorfulRectangle buildings2ChangeColorRect51;
		ColorfulRectangle buildings2ChangeColorRect52;
		ColorfulRectangle buildings2ChangeColorRect53;
		ColorfulRectangle buildings2ChangeColorRect53a;
		ColorfulRectangle buildings2ChangeColorRect54;
		ColorfulRectangle buildings2ChangeColorRect55;
		ColorfulRectangle buildings2ChangeColorRect56;
		ColorfulRectangle buildings2ChangeColorRect57;
		ColorfulRectangle buildings2ChangeColorRect58;
		ColorfulRectangle buildings2ChangeColorRect59;
		ColorfulRectangle buildings2ChangeColorRect60;
		ColorfulRectangle buildings2ChangeColorRect61;
		ColorfulRectangle buildings2ChangeColorRect62;
		ColorfulRectangle buildings2ChangeColorRect63;
		ColorfulRectangle buildings2ChangeColorRect64;
		ColorfulRectangle buildings2ChangeColorRect65;
		ColorfulRectangle buildings2ChangeColorRect66;
		ColorfulRectangle buildings2ChangeColorRect67;
		ColorfulRectangle buildings2ChangeColorRect68;
		ColorfulRectangle buildings2ChangeColorRect69;
		ColorfulRectangle buildings2ChangeColorRect70;
		ColorfulRectangle buildings2ChangeColorRect71;
		ColorfulRectangle buildings2ChangeColorRect72;
		ColorfulRectangle buildings2ChangeColorRect73;
		ColorfulRectangle buildings2ChangeColorRect74;
		ColorfulRectangle buildings2ChangeColorRect75;
		ColorfulRectangle buildings2ChangeColorRect76;
		ColorfulRectangle buildings2ChangeColorRect77;
		ColorfulRectangle buildings2ChangeColorRect78;
		ColorfulRectangle buildings2ChangeColorRect79;
		ColorfulRectangle buildings2ChangeColorRect80;
		ColorfulRectangle buildings2ChangeColorRect81;
		ColorfulRectangle buildings2ChangeColorRect82;
		ColorfulRectangle buildings2ChangeColorRect83;
		ColorfulRectangle buildings2ChangeColorRect84;
		ColorfulRectangle buildings2ChangeColorRect85;
		ColorfulRectangle buildings2ChangeColorRect86;
		ColorfulRectangle buildings2ChangeColorRect87;
		ColorfulRectangle buildings2ChangeColorRect88;
		ColorfulRectangle buildings2ChangeColorRect89;
		ColorfulRectangle buildings2ChangeColorRect90;
		ColorfulRectangle buildings2ChangeColorRect91;
		ColorfulRectangle buildings2ChangeColorRect92;
		ColorfulRectangle buildings2ChangeColorRect93;
		ColorfulRectangle buildings2ChangeColorRect94;
		ColorfulRectangle buildings2ChangeColorRect95;
		ColorfulRectangle buildings2ChangeColorRect96;
		ColorfulRectangle buildings2ChangeColorRect97;
		ColorfulRectangle buildings2ChangeColorRect98;
		ColorfulRectangle buildings2ChangeColorRect99;
		ColorfulRectangle buildings2ChangeColorRect100;
		ColorfulRectangle buildings2ChangeColorRect101;
		ColorfulRectangle buildings2ChangeColorRect102;
		ColorfulRectangle buildings2ChangeColorRect103;
		ColorfulRectangle buildings2ChangeColorRect104;
		ColorfulRectangle buildings2ChangeColorRect105;
		ColorfulRectangle buildings2ChangeColorRect106;
		ColorfulRectangle buildings2ChangeColorRect107;
		ColorfulRectangle buildings2ChangeColorRect108;
		ColorfulRectangle buildings2ChangeColorRect109;
		ColorfulRectangle buildings2ChangeColorRect110;
		ColorfulRectangle buildings2ChangeColorRect111;
		ColorfulRectangle buildings2ChangeColorRect112;
		ColorfulRectangle buildings2ChangeColorRect113;
		ColorfulRectangle buildings2ChangeColorRect114;
		ColorfulRectangle buildings2ChangeColorRect115;
		ColorfulRectangle buildings2ChangeColorRect116;
		ColorfulRectangle buildings2ChangeColorRect117;
		ColorfulRectangle buildings2ChangeColorRect118;
		ColorfulRectangle buildings2ChangeColorRect119;
		ColorfulRectangle buildings2ChangeColorRect120;
		ColorfulRectangle buildings2ChangeColorRect121;
		ColorfulRectangle buildings2ChangeColorRect122;
		ColorfulRectangle buildings2ChangeColorRect123;
		ColorfulRectangle buildings2ChangeColorRect124;
		ColorfulRectangle buildings2ChangeColorRect125;
		ColorfulRectangle buildings2ChangeColorRect126;
		ColorfulRectangle buildings2ChangeColorRect127;
		ColorfulRectangle buildings2ChangeColorRect128;
		ColorfulRectangle buildings2ChangeColorRect129;
		ColorfulRectangle buildings2ChangeColorRect130;
		ColorfulRectangle buildings2ChangeColorRect131;
		ColorfulRectangle buildings2ChangeColorRect132;
		ColorfulRectangle buildings2ChangeColorRect133;
		ColorfulRectangle buildings2ChangeColorRect134;
		ColorfulRectangle buildings2ChangeColorRect135;
		ColorfulRectangle buildings2ChangeColorRect136;
		ColorfulRectangle buildings2ChangeColorRect137;
		ColorfulRectangle buildings2ChangeColorRect138;
		ColorfulRectangle buildings2ChangeColorRect139;
		ColorfulRectangle buildings2ChangeColorRect140;
		ColorfulRectangle buildings2ChangeColorRect141;
		ColorfulRectangle buildings2ChangeColorRect142;
		ColorfulRectangle buildings2ChangeColorRect143;
		ColorfulRectangle buildings2ChangeColorRect144;
		ColorfulRectangle buildings2ChangeColorRect145;
		ColorfulRectangle buildings2ChangeColorRect146;
		ColorfulRectangle buildings2ChangeColorRect147;
		ColorfulRectangle buildings2ChangeColorRect148;
		ColorfulRectangle buildings2ChangeColorRect149;
		ColorfulRectangle buildings2ChangeColorRect150;
		ColorfulRectangle buildings2ChangeColorRect151;
		ColorfulRectangle buildings2ChangeColorRect152;
		ColorfulRectangle buildings2ChangeColorRect153;
		ColorfulRectangle buildings2ChangeColorRect154;
		ColorfulRectangle buildings2ChangeColorRect155;
		ColorfulRectangle buildings2ChangeColorRect156;
		ColorfulRectangle buildings2ChangeColorRect157;
		ColorfulRectangle buildings2ChangeColorRect158;
		ColorfulRectangle buildings2ChangeColorRect159;
		ColorfulRectangle buildings2ChangeColorRect160;
		ColorfulRectangle buildings2ChangeColorRect161;
		ColorfulRectangle buildings2ChangeColorRect162;
		ColorfulRectangle buildings2ChangeColorRect163;
		ColorfulRectangle buildings2ChangeColorRect164;
		ColorfulRectangle buildings2ChangeColorRect165;
		ColorfulRectangle buildings2ChangeColorRect166;
		ColorfulRectangle buildings2ChangeColorRect167;
		ColorfulRectangle buildings2ChangeColorRect168;
		ColorfulRectangle buildings2ChangeColorRect169;
		ColorfulRectangle buildings2ChangeColorRect170;
		ColorfulRectangle buildings2ChangeColorRect171;
		ColorfulRectangle buildings2ChangeColorRect172;
		ColorfulRectangle buildings2ChangeColorRect173;
		ColorfulRectangle buildings2ChangeColorRect174;
		ColorfulRectangle buildings2ChangeColorRect175;
		ColorfulRectangle buildings2ChangeColorRect176;
		ColorfulRectangle buildings2ChangeColorRect177;
		ColorfulRectangle buildings2ChangeColorRect178;
		ColorfulRectangle buildings2ChangeColorRect179;
		ColorfulRectangle buildings2ChangeColorRect180;
		ColorfulRectangle buildings2ChangeColorRect181;
		ColorfulRectangle buildings2ChangeColorRect182;
		ColorfulRectangle buildings2ChangeColorRect183;
		ColorfulRectangle buildings2ChangeColorRect184;
		ColorfulRectangle buildings2ChangeColorRect185;
		ColorfulRectangle buildings2ChangeColorRect186;
		ColorfulRectangle buildings2ChangeColorRect187;
		ColorfulRectangle buildings2ChangeColorRect188;
		ColorfulRectangle buildings2ChangeColorRect189;
		ColorfulRectangle buildings2ChangeColorRect190;
		ColorfulRectangle buildings2ChangeColorRect191;
		ColorfulRectangle buildings2ChangeColorRect192;
		ColorfulRectangle buildings2ChangeColorRect193;
		ColorfulRectangle buildings2ChangeColorRect194;
		ColorfulRectangle buildings2ChangeColorRect195;
		ColorfulRectangle buildings2ChangeColorRect196;
		ColorfulRectangle buildings2ChangeColorRect197;
		ColorfulRectangle buildings2ChangeColorRect198;
		ColorfulRectangle buildings2ChangeColorRect199;
		ColorfulRectangle buildings2ChangeColorRect200;
		ColorfulRectangle buildings2ChangeColorRect201;
		ColorfulRectangle buildings2ChangeColorRect202;
		ColorfulRectangle buildings2ChangeColorRect203;
		ColorfulRectangle buildings2ChangeColorRect204;
		ColorfulRectangle buildings2ChangeColorRect205;
		ColorfulRectangle buildings2ChangeColorRect206;
		ColorfulRectangle buildings2ChangeColorRect207;
		ColorfulRectangle buildings2ChangeColorRect208;
		ColorfulRectangle buildings2ChangeColorRect209;
		ColorfulRectangle buildings2ChangeColorRect210;
		ColorfulRectangle buildings2ChangeColorRect211;
		ColorfulRectangle buildings2ChangeColorRect212;
		ColorfulRectangle buildings2ChangeColorRect213;
		ColorfulRectangle buildings2ChangeColorRect214;
		ColorfulRectangle buildings2ChangeColorRect215;
		ColorfulRectangle buildings2ChangeColorRect216;
		ColorfulRectangle buildings2ChangeColorRect217;
		ColorfulRectangle buildings2ChangeColorRect218;
		ColorfulRectangle buildings2ChangeColorRect219;
		ColorfulRectangle buildings2ChangeColorRect220;
		ColorfulRectangle buildings2ChangeColorRect221;
		ColorfulRectangle buildings2ChangeColorRect222;
		ColorfulRectangle buildings2ChangeColorRect223;
		ColorfulRectangle buildings2ChangeColorRect224;
		ColorfulRectangle buildings2ChangeColorRect225;
		ColorfulRectangle buildings2ChangeColorRect226;
		ColorfulRectangle buildings2ChangeColorRect227;
		ColorfulRectangle buildings2ChangeColorRect228;
		ColorfulRectangle buildings2ChangeColorRect229;
		ColorfulRectangle buildings2ChangeColorRect230;
		ColorfulRectangle buildings2ChangeColorRect231;
		ColorfulRectangle buildings2ChangeColorRect232;
		ColorfulRectangle buildings2ChangeColorRect233;
		ColorfulRectangle buildings2ChangeColorRect234;
		ColorfulRectangle buildings2ChangeColorRect235;
		ColorfulRectangle buildings2ChangeColorRect236;
		ColorfulRectangle buildings2ChangeColorRect237;
		ColorfulRectangle buildings2ChangeColorRect238;
		ColorfulRectangle buildings2ChangeColorRect239;
		ColorfulRectangle buildings2ChangeColorRect240;
		ColorfulRectangle buildings2ChangeColorRect241;
		ColorfulRectangle buildings2ChangeColorRect242;
		ColorfulRectangle buildings2ChangeColorRect243;
		ColorfulRectangle buildings2ChangeColorRect244;
		ColorfulRectangle buildings2ChangeColorRect245;
		ColorfulRectangle buildings2ChangeColorRect246;
		ColorfulRectangle buildings2ChangeColorRect247;
		ColorfulRectangle buildings2ChangeColorRect248;
		ColorfulRectangle buildings2ChangeColorRect249;
		ColorfulRectangle buildings2ChangeColorRect250;
		ColorfulRectangle buildings2ChangeColorRect251;
		ColorfulRectangle buildings2ChangeColorRect252;
		ColorfulRectangle buildings2ChangeColorRect253;
		ColorfulRectangle buildings2ChangeColorRect254;
		ColorfulRectangle buildings2ChangeColorRect255;
		ColorfulRectangle buildings2ChangeColorRect256;
		ColorfulRectangle buildings2ChangeColorRect257;
		ColorfulRectangle buildings2ChangeColorRect258;
		ColorfulRectangle buildings2ChangeColorRect259;
		ColorfulRectangle buildings2ChangeColorRect260;
		ColorfulRectangle buildings2ChangeColorRect261;
		ColorfulRectangle buildings2ChangeColorRect262;
		ColorfulRectangle buildings2ChangeColorRect263;
		ColorfulRectangle buildings2ChangeColorRect264;
		ColorfulRectangle buildings2ChangeColorRect265;
		ColorfulRectangle buildings2ChangeColorRect266;
		ColorfulRectangle buildings2ChangeColorRect267;
		ColorfulRectangle buildings2ChangeColorRect268;
		ColorfulRectangle buildings2ChangeColorRect269;
		ColorfulRectangle buildings2ChangeColorRect270;
		ColorfulRectangle buildings2ChangeColorRect271;
		ColorfulRectangle buildings2ChangeColorRect272;
		ColorfulRectangle buildings2ChangeColorRect273;
		ColorfulRectangle buildings2ChangeColorRect274;
		ColorfulRectangle buildings2ChangeColorRect275;
		ColorfulRectangle buildings2ChangeColorRect276;
		ColorfulRectangle buildings2ChangeColorRect277;
		ColorfulRectangle buildings2ChangeColorRect278;
		ColorfulRectangle buildings2ChangeColorRect279;
		ColorfulRectangle buildings2ChangeColorRect280;
		ColorfulRectangle buildings2ChangeColorRect281;
		ColorfulRectangle buildings2ChangeColorRect282;
		ColorfulRectangle buildings2ChangeColorRect283;
		ColorfulRectangle buildings2ChangeColorRect284;
		ColorfulRectangle buildings2ChangeColorRect285;
		ColorfulRectangle buildings2ChangeColorRect286;
		ColorfulRectangle buildings2ChangeColorRect287;
		ColorfulRectangle buildings2ChangeColorRect288;
		ColorfulRectangle buildings2ChangeColorRect289;
		ColorfulRectangle buildings2ChangeColorRect290;
		ColorfulRectangle buildings2ChangeColorRect291;
		ColorfulRectangle buildings2ChangeColorRect292;
		ColorfulRectangle buildings2ChangeColorRect293;
		ColorfulRectangle buildings2ChangeColorRect294;
		ColorfulRectangle buildings2ChangeColorRect295;
		ColorfulRectangle buildings2ChangeColorRect296;
		ColorfulRectangle buildings2ChangeColorRect297;
		ColorfulRectangle buildings2ChangeColorRect298;
		ColorfulRectangle buildings2ChangeColorRect299;
		ColorfulRectangle buildings2ChangeColorRect300;
		ColorfulRectangle buildings2ChangeColorRect301;
		ColorfulRectangle buildings2ChangeColorRect302;
		ColorfulRectangle buildings2ChangeColorRect303;
		ColorfulRectangle buildings2ChangeColorRect304;
		ColorfulRectangle buildings2ChangeColorRect305;
		ColorfulRectangle buildings2ChangeColorRect306;
		ColorfulRectangle buildings2ChangeColorRect307;
		ColorfulRectangle buildings2ChangeColorRect308;
		ColorfulRectangle buildings2ChangeColorRect309;
		ColorfulRectangle buildings2ChangeColorRect310;
		ColorfulRectangle buildings2ChangeColorRect311;
		ColorfulRectangle buildings2ChangeColorRect312;
		ColorfulRectangle buildings2ChangeColorRect313;
		ColorfulRectangle buildings2ChangeColorRect314;
		ColorfulRectangle buildings2ChangeColorRect315;
		ColorfulRectangle buildings2ChangeColorRect316;
		ColorfulRectangle buildings2ChangeColorRect317;
		ColorfulRectangle buildings2ChangeColorRect318;
		ColorfulRectangle buildings2ChangeColorRect319;
		ColorfulRectangle buildings2ChangeColorRect320;
		ColorfulRectangle buildings2ChangeColorRect321;
		ColorfulRectangle buildings2ChangeColorRect322;
		ColorfulRectangle buildings2ChangeColorRect323;
		ColorfulRectangle buildings2ChangeColorRect324;
		ColorfulRectangle buildings2ChangeColorRect325;
		ColorfulRectangle buildings2ChangeColorRect326;
		ColorfulRectangle buildings2ChangeColorRect327;
		ColorfulRectangle buildings2ChangeColorRect328;
		ColorfulRectangle buildings2ChangeColorRect329;
		ColorfulRectangle buildings2ChangeColorRect330;
		ColorfulRectangle buildings2ChangeColorRect331;
		ColorfulRectangle buildings2ChangeColorRect332;
		ColorfulRectangle buildings2ChangeColorRect333;
		ColorfulRectangle buildings2ChangeColorRect334;
		ColorfulRectangle buildings2ChangeColorRect335;
		ColorfulRectangle buildings2ChangeColorRect336;
		ColorfulRectangle buildings2ChangeColorRect337;
		ColorfulRectangle buildings2ChangeColorRect338;
		ColorfulRectangle buildings2ChangeColorRect339;
		ColorfulRectangle buildings2ChangeColorRect340;
		ColorfulRectangle buildings2ChangeColorRect341;
		ColorfulRectangle buildings2ChangeColorRect342;
		ColorfulRectangle buildings2ChangeColorRect343;
		ColorfulRectangle buildings2ChangeColorRect344;
		ColorfulRectangle buildings2ChangeColorRect345;
		ColorfulRectangle buildings2ChangeColorRect346;
		ColorfulRectangle buildings2ChangeColorRect347;
		ColorfulRectangle buildings2ChangeColorRect348;
		ColorfulRectangle buildings2ChangeColorRect349;
		ColorfulRectangle buildings2ChangeColorRect350;
		ColorfulRectangle buildings2ChangeColorRect351;
		ColorfulRectangle buildings2ChangeColorRect352;
		ColorfulRectangle buildings2ChangeColorRect353;
		ColorfulRectangle buildings2ChangeColorRect354;
		ColorfulRectangle buildings2ChangeColorRect355;
		ColorfulRectangle buildings2ChangeColorRect356;
		ColorfulRectangle buildings2ChangeColorRect357;
		ColorfulRectangle buildings2ChangeColorRect358;
		ColorfulRectangle buildings2ChangeColorRect359;
		ColorfulRectangle buildings2ChangeColorRect360;
		ColorfulRectangle buildings2ChangeColorRect361;
		ColorfulRectangle buildings2ChangeColorRect362;
		ColorfulRectangle buildings2ChangeColorRect363;
		ColorfulRectangle buildings2ChangeColorRect364;
		ColorfulRectangle buildings2ChangeColorRect365;
		ColorfulRectangle buildings2ChangeColorRect366;
		ColorfulRectangle buildings2ChangeColorRect367;
		ColorfulRectangle buildings2ChangeColorRect368;
		ColorfulRectangle buildings2ChangeColorRect369;
		ColorfulRectangle buildings2ChangeColorRect370;
		ColorfulRectangle buildings2ChangeColorRect371;
		ColorfulRectangle buildings2ChangeColorRect372;
		ColorfulRectangle buildings2ChangeColorRect373;
		ColorfulRectangle buildings2ChangeColorRect374;
		ColorfulRectangle buildings2ChangeColorRect375;
		ColorfulRectangle buildings2ChangeColorRect376;
		ColorfulRectangle buildings2ChangeColorRect377;
		ColorfulRectangle buildings2ChangeColorRect378;
		ColorfulRectangle buildings2ChangeColorRect379;
		ColorfulRectangle buildings2ChangeColorRect380;
		ColorfulRectangle buildings2ChangeColorRect381;
		ColorfulRectangle buildings2ChangeColorRect382;
		ColorfulRectangle buildings2ChangeColorRect383;
		ColorfulRectangle buildings2ChangeColorRect384;
		ColorfulRectangle buildings2ChangeColorRect385;
		ColorfulRectangle buildings2ChangeColorRect386;
		ColorfulRectangle buildings2ChangeColorRect387;
		ColorfulRectangle buildings2ChangeColorRect388;
		ColorfulRectangle buildings2ChangeColorRect389;
		ColorfulRectangle buildings2ChangeColorRect390;
		ColorfulRectangle buildings2ChangeColorRect391;
		ColorfulRectangle buildings2ChangeColorRect392;
		ColorfulRectangle buildings2ChangeColorRect393;
		ColorfulRectangle buildings2ChangeColorRect394;
		ColorfulRectangle buildings2ChangeColorRect395;
		ColorfulRectangle buildings2ChangeColorRect396;
		ColorfulRectangle buildings2ChangeColorRect397;
		ColorfulRectangle buildings2ChangeColorRect398;
		ColorfulRectangle buildings2ChangeColorRect399;
		ColorfulRectangle buildings2ChangeColorRect400;
		ColorfulRectangle buildings2ChangeColorRect401;
		ColorfulRectangle buildings2ChangeColorRect402;
		ColorfulRectangle buildings2ChangeColorRect403;
		ColorfulRectangle buildings2ChangeColorRect404;
		ColorfulRectangle buildings2ChangeColorRect405;
		ColorfulRectangle buildings2ChangeColorRect406;
		ColorfulRectangle buildings2ChangeColorRect407;
		ColorfulRectangle buildings2ChangeColorRect408;
		ColorfulRectangle buildings2ChangeColorRect409;
		ColorfulRectangle buildings2ChangeColorRect410;
		ColorfulRectangle buildings2ChangeColorRect411;
		ColorfulRectangle buildings2ChangeColorRect412;
		ColorfulRectangle buildings2ChangeColorRect413;
		ColorfulRectangle buildings2ChangeColorRect414;
		ColorfulRectangle buildings2ChangeColorRect415;
		ColorfulRectangle buildings2ChangeColorRect416;
		ColorfulRectangle buildings2ChangeColorRect417;
		ColorfulRectangle buildings2ChangeColorRect418;
		ColorfulRectangle buildings2ChangeColorRect419;
		ColorfulRectangle buildings2ChangeColorRect420;
		ColorfulRectangle buildings2ChangeColorRect421;
		ColorfulRectangle buildings2ChangeColorRect422;
		ColorfulRectangle buildings2ChangeColorRect423;
		ColorfulRectangle buildings2ChangeColorRect424;
		ColorfulRectangle buildings2ChangeColorRect425;
		ColorfulRectangle buildings2ChangeColorRect426;
		ColorfulRectangle buildings2ChangeColorRect427;
		ColorfulRectangle buildings2ChangeColorRect428;
		ColorfulRectangle buildings2ChangeColorRect429;
		ColorfulRectangle buildings2ChangeColorRect430;
		ColorfulRectangle buildings2ChangeColorRect431;
		ColorfulRectangle buildings2ChangeColorRect432;
		ColorfulRectangle buildings2ChangeColorRect433;
		ColorfulRectangle buildings2ChangeColorRect434;
		ColorfulRectangle buildings2ChangeColorRect435;
		ColorfulRectangle buildings2ChangeColorRect436;
		ColorfulRectangle buildings2ChangeColorRect437;
		ColorfulRectangle buildings2ChangeColorRect438;
		ColorfulRectangle buildings2ChangeColorRect439;
		ColorfulRectangle buildings2ChangeColorRect440;
		ColorfulRectangle buildings2ChangeColorRect441;
		ColorfulRectangle buildings2ChangeColorRect442;
		ColorfulRectangle buildings2ChangeColorRect443;
		ColorfulRectangle buildings2ChangeColorRect444;
		ColorfulRectangle buildings2ChangeColorRect445;
		ColorfulRectangle buildings2ChangeColorRect446;
		ColorfulRectangle buildings2ChangeColorRect447;
		ColorfulRectangle buildings2ChangeColorRect448;
		ColorfulRectangle buildings2ChangeColorRect449;
		ColorfulRectangle buildings2ChangeColorRect450;
		ColorfulRectangle buildings2ChangeColorRect451;
		ColorfulRectangle buildings2ChangeColorRect452;
		ColorfulRectangle buildings2ChangeColorRect453;
		ColorfulRectangle buildings2ChangeColorRect454;
		ColorfulRectangle buildings2ChangeColorRect455;
		ColorfulRectangle buildings2ChangeColorRect456;
		ColorfulRectangle buildings2ChangeColorRect457;
		ColorfulRectangle buildings2ChangeColorRect458;
		ColorfulRectangle buildings2ChangeColorRect459;
		ColorfulRectangle buildings2ChangeColorRect460;
		ColorfulRectangle buildings2ChangeColorRect461;
		ColorfulRectangle buildings2ChangeColorRect462;
		ColorfulRectangle buildings2ChangeColorRect463;
		ColorfulRectangle buildings2ChangeColorRect464;
		ColorfulRectangle buildings2ChangeColorRect465;
		ColorfulRectangle buildings2ChangeColorRect466;
		ColorfulRectangle buildings2ChangeColorRect467;
		ColorfulRectangle buildings2ChangeColorRect468;
		ColorfulRectangle buildings2ChangeColorRect469;
		ColorfulRectangle buildings2ChangeColorRect470;
		ColorfulRectangle buildings2ChangeColorRect471;
		ColorfulRectangle buildings2ChangeColorRect472;
		ColorfulRectangle buildings2ChangeColorRect473;
		ColorfulRectangle buildings2ChangeColorRect474;
		ColorfulRectangle buildings2ChangeColorRect475;
		ColorfulRectangle buildings2ChangeColorRect476;
		ColorfulRectangle buildings2ChangeColorRect477;
		ColorfulRectangle buildings2ChangeColorRect478;
		ColorfulRectangle buildings2ChangeColorRect479;
		ColorfulRectangle buildings2ChangeColorRect480;
		ColorfulRectangle buildings2ChangeColorRect481;
		ColorfulRectangle buildings2ChangeColorRect482;
		ColorfulRectangle buildings2ChangeColorRect483;
		ColorfulRectangle buildings2ChangeColorRect484;
		ColorfulRectangle buildings2ChangeColorRect485;
		ColorfulRectangle buildings2ChangeColorRect486;
		ColorfulRectangle buildings2ChangeColorRect487;
		ColorfulRectangle buildings2ChangeColorRect488;
		ColorfulRectangle buildings2ChangeColorRect489;
		ColorfulRectangle buildings2ChangeColorRect490;
		ColorfulRectangle buildings2ChangeColorRect491;
		ColorfulRectangle buildings2ChangeColorRect492;
		ColorfulRectangle buildings2ChangeColorRect493;
		ColorfulRectangle buildings2ChangeColorRect494;
		ColorfulRectangle buildings2ChangeColorRect495;
		ColorfulRectangle buildings2ChangeColorRect496;
		ColorfulRectangle buildings2ChangeColorRect497;
		ColorfulRectangle buildings2ChangeColorRect498;
		ColorfulRectangle buildings2ChangeColorRect499;
		ColorfulRectangle buildings2ChangeColorRect500;
		ColorfulRectangle buildings2ChangeColorRect501;
		ColorfulRectangle buildings2ChangeColorRect502;
		ColorfulRectangle buildings2ChangeColorRect503;
		ColorfulRectangle buildings2ChangeColorRect504;
		ColorfulRectangle buildings2ChangeColorRect505;
		ColorfulRectangle buildings2ChangeColorRect506;
		ColorfulRectangle buildings2ChangeColorRect507;
		ColorfulRectangle buildings2ChangeColorRect508;
		ColorfulRectangle buildings2ChangeColorRect509;
		ColorfulRectangle buildings2ChangeColorRect510;
		ColorfulRectangle buildings2ChangeColorRect511;
		ColorfulRectangle buildings2ChangeColorRect512;
		ColorfulRectangle buildings2ChangeColorRect513;
		ColorfulRectangle buildings2ChangeColorRect514;
		ColorfulRectangle buildings2ChangeColorRect515;
		ColorfulRectangle buildings2ChangeColorRect516;
		ColorfulRectangle buildings2ChangeColorRect517;
		ColorfulRectangle buildings2ChangeColorRect518;
		ColorfulRectangle buildings2ChangeColorRect519;
		ColorfulRectangle buildings2ChangeColorRect520;
		ColorfulRectangle buildings2ChangeColorRect521;


		
		buildings2ChangeColorRect1 = new ColorfulRectangle(movex+-300,movey+750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect2 = new ColorfulRectangle(movex+-300,movey+700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect3 = new ColorfulRectangle(movex+-300,movey+650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect4 = new ColorfulRectangle(movex+0,movey+650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect5 = new ColorfulRectangle(movex+-50,movey+650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect6 = new ColorfulRectangle(movex+-400,movey+500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect7 = new ColorfulRectangle(movex+-350,movey+500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect8 = new ColorfulRectangle(movex+-300,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect9 = new ColorfulRectangle(movex+-300,movey+300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect10 = new ColorfulRectangle(movex+-1000,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect11 = new ColorfulRectangle(movex+-700,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect12 = new ColorfulRectangle(movex+-700,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect13 = new ColorfulRectangle(movex+-1000,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect14 = new ColorfulRectangle(movex+-450,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect15 = new ColorfulRectangle(movex+-400,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect16 = new ColorfulRectangle(movex+-400,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect17 = new ColorfulRectangle(movex+-400,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect18 = new ColorfulRectangle(movex+-100,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect19 = new ColorfulRectangle(movex+-100,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect20 = new ColorfulRectangle(movex+-50,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect21 = new ColorfulRectangle(movex+-50,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect22 = new ColorfulRectangle(movex+150,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect23 = new ColorfulRectangle(movex+200,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect24 = new ColorfulRectangle(movex+600,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect25 = new ColorfulRectangle(movex+650,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect26 = new ColorfulRectangle(movex+450,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect27 = new ColorfulRectangle(movex+450,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect28 = new ColorfulRectangle(movex+500,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect29 = new ColorfulRectangle(movex+1050,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect30 = new ColorfulRectangle(movex+1000,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect31 = new ColorfulRectangle(movex+950,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect32 = new ColorfulRectangle(movex+900,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect33 = new ColorfulRectangle(movex+850,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect34 = new ColorfulRectangle(movex+1100,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect35 = new ColorfulRectangle(movex+600,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect36 = new ColorfulRectangle(movex+1050,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect37 = new ColorfulRectangle(movex+1150,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect38 = new ColorfulRectangle(movex+1150,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect39 = new ColorfulRectangle(movex+1250,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect40 = new ColorfulRectangle(movex+1700,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect41 = new ColorfulRectangle(movex+1850,movey+-1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect42 = new ColorfulRectangle(movex+1000,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect43 = new ColorfulRectangle(movex+-50,movey+1300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect44 = new ColorfulRectangle(movex+-50,movey+1400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect45 = new ColorfulRectangle(movex+-500,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect46 = new ColorfulRectangle(movex+-450,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect47 = new ColorfulRectangle(movex+-400,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect48 = new ColorfulRectangle(movex+-350,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect49 = new ColorfulRectangle(movex+-350,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect50 = new ColorfulRectangle(movex+-650,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect51 = new ColorfulRectangle(movex+-650,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect52 = new ColorfulRectangle(movex+-750,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect53 = new ColorfulRectangle(movex+-800,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect53a = new ColorfulRectangle(movex+-150,movey+1150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect54 = new ColorfulRectangle(movex+-150,movey+1200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect55 = new ColorfulRectangle(movex+-150,movey+1250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect56 = new ColorfulRectangle(movex+-200,movey+1250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect57 = new ColorfulRectangle(movex+-200,movey+1300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect58 = new ColorfulRectangle(movex+-200,movey+1350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect59 = new ColorfulRectangle(movex+-50,movey+1350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect60 = new ColorfulRectangle(movex+-50,movey+1450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect61 = new ColorfulRectangle(movex+0,movey+1450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect62 = new ColorfulRectangle(movex+0,movey+1500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect63 = new ColorfulRectangle(movex+-200,movey+600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect64 = new ColorfulRectangle(movex+-150,movey+600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect65 = new ColorfulRectangle(movex+50,movey+650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect66 = new ColorfulRectangle(movex+-300,movey+600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect67 = new ColorfulRectangle(movex+-250,movey+600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect68 = new ColorfulRectangle(movex+-450,movey+450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect69 = new ColorfulRectangle(movex+-500,movey+450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect70 = new ColorfulRectangle(movex+-450,movey+500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect71 = new ColorfulRectangle(movex+-300,movey+500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect72 = new ColorfulRectangle(movex+-250,movey+500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect73 = new ColorfulRectangle(movex+-250,movey+550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect74 = new ColorfulRectangle(movex+-200,movey+550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect75 = new ColorfulRectangle(movex+-250,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect76 = new ColorfulRectangle(movex+-250,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect77 = new ColorfulRectangle(movex+-150,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect78 = new ColorfulRectangle(movex+-200,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect79 = new ColorfulRectangle(movex+-550,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect80 = new ColorfulRectangle(movex+-500,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect81 = new ColorfulRectangle(movex+-450,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect82 = new ColorfulRectangle(movex+-400,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect83 = new ColorfulRectangle(movex+-350,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect84 = new ColorfulRectangle(movex+-300,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect85 = new ColorfulRectangle(movex+-300,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect86 = new ColorfulRectangle(movex+-250,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect87 = new ColorfulRectangle(movex+-850,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect88 = new ColorfulRectangle(movex+-900,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect89 = new ColorfulRectangle(movex+-900,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect90 = new ColorfulRectangle(movex+-700,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect91 = new ColorfulRectangle(movex+-700,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect92 = new ColorfulRectangle(movex+-650,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect93 = new ColorfulRectangle(movex+-1050,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect94 = new ColorfulRectangle(movex+-2000,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect95 = new ColorfulRectangle(movex+-950,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect96 = new ColorfulRectangle(movex+-2000,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect97 = new ColorfulRectangle(movex+-950,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect98 = new ColorfulRectangle(movex+-650,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect99 = new ColorfulRectangle(movex+-700,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect100 = new ColorfulRectangle(movex+-650,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect101 = new ColorfulRectangle(movex+-650,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect102 = new ColorfulRectangle(movex+-700,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect103 = new ColorfulRectangle(movex+-750,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect104 = new ColorfulRectangle(movex+-2000,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect105 = new ColorfulRectangle(movex+-1050,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect106 = new ColorfulRectangle(movex+-1050,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect107 = new ColorfulRectangle(movex+-1050,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect108 = new ColorfulRectangle(movex+-1200,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect109 = new ColorfulRectangle(movex+-400,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect110 = new ColorfulRectangle(movex+-350,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect111 = new ColorfulRectangle(movex+-350,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect112 = new ColorfulRectangle(movex+-300,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect113 = new ColorfulRectangle(movex+-250,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect114 = new ColorfulRectangle(movex+-300,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect115 = new ColorfulRectangle(movex+-350,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect116 = new ColorfulRectangle(movex+-350,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect117 = new ColorfulRectangle(movex+-350,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect118 = new ColorfulRectangle(movex+-650,movey+-2000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect119 = new ColorfulRectangle(movex+-700,movey+-2000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect120 = new ColorfulRectangle(movex+-700,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect121 = new ColorfulRectangle(movex+-750,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect122 = new ColorfulRectangle(movex+-700,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect123 = new ColorfulRectangle(movex+-650,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect124 = new ColorfulRectangle(movex+-700,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect125 = new ColorfulRectangle(movex+-200,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect126 = new ColorfulRectangle(movex+-150,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect127 = new ColorfulRectangle(movex+-150,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect128 = new ColorfulRectangle(movex+-150,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect129 = new ColorfulRectangle(movex+-450,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect130 = new ColorfulRectangle(movex+-50,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect131 = new ColorfulRectangle(movex+-200,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect132 = new ColorfulRectangle(movex+-200,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect133 = new ColorfulRectangle(movex+-50,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect134 = new ColorfulRectangle(movex+0,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect135 = new ColorfulRectangle(movex+50,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect136 = new ColorfulRectangle(movex+50,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect137 = new ColorfulRectangle(movex+200,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect138 = new ColorfulRectangle(movex+200,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect139 = new ColorfulRectangle(movex+150,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect140 = new ColorfulRectangle(movex+200,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect141 = new ColorfulRectangle(movex+400,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect142 = new ColorfulRectangle(movex+400,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect143 = new ColorfulRectangle(movex+350,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect144 = new ColorfulRectangle(movex+500,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect145 = new ColorfulRectangle(movex+550,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect146 = new ColorfulRectangle(movex+550,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect147 = new ColorfulRectangle(movex+500,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect148 = new ColorfulRectangle(movex+550,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect149 = new ColorfulRectangle(movex+600,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect150 = new ColorfulRectangle(movex+700,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect151 = new ColorfulRectangle(movex+700,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect152 = new ColorfulRectangle(movex+750,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect153 = new ColorfulRectangle(movex+800,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect154 = new ColorfulRectangle(movex+800,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect155 = new ColorfulRectangle(movex+850,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect156 = new ColorfulRectangle(movex+850,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect157 = new ColorfulRectangle(movex+800,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect158 = new ColorfulRectangle(movex+800,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect159 = new ColorfulRectangle(movex+850,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect160 = new ColorfulRectangle(movex+900,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect161 = new ColorfulRectangle(movex+950,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect162 = new ColorfulRectangle(movex+750,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect163 = new ColorfulRectangle(movex+750,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect164 = new ColorfulRectangle(movex+700,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect165 = new ColorfulRectangle(movex+650,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect166 = new ColorfulRectangle(movex+1150,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect167 = new ColorfulRectangle(movex+1150,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect168 = new ColorfulRectangle(movex+1150,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect169 = new ColorfulRectangle(movex+1200,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect170 = new ColorfulRectangle(movex+1150,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect171 = new ColorfulRectangle(movex+1200,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect172 = new ColorfulRectangle(movex+1250,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect173 = new ColorfulRectangle(movex+1300,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect174 = new ColorfulRectangle(movex+550,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect175 = new ColorfulRectangle(movex+500,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect176 = new ColorfulRectangle(movex+500,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect177 = new ColorfulRectangle(movex+450,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect178 = new ColorfulRectangle(movex+450,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect179 = new ColorfulRectangle(movex+650,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect180 = new ColorfulRectangle(movex+700,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect181 = new ColorfulRectangle(movex+700,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect182 = new ColorfulRectangle(movex+750,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect183 = new ColorfulRectangle(movex+800,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect184 = new ColorfulRectangle(movex+800,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect185 = new ColorfulRectangle(movex+850,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect186 = new ColorfulRectangle(movex+850,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect187 = new ColorfulRectangle(movex+850,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect188 = new ColorfulRectangle(movex+900,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect189 = new ColorfulRectangle(movex+900,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect190 = new ColorfulRectangle(movex+950,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect191 = new ColorfulRectangle(movex+950,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect192 = new ColorfulRectangle(movex+-250,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect193 = new ColorfulRectangle(movex+1050,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect194 = new ColorfulRectangle(movex+1200,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect195 = new ColorfulRectangle(movex+1150,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect196 = new ColorfulRectangle(movex+1200,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect197 = new ColorfulRectangle(movex+1250,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect198 = new ColorfulRectangle(movex+1300,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect199 = new ColorfulRectangle(movex+1300,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect200 = new ColorfulRectangle(movex+1350,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect201 = new ColorfulRectangle(movex+1400,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect202 = new ColorfulRectangle(movex+1400,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect203 = new ColorfulRectangle(movex+1350,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect204 = new ColorfulRectangle(movex+1450,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect205 = new ColorfulRectangle(movex+1200,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect206 = new ColorfulRectangle(movex+1050,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect207 = new ColorfulRectangle(movex+1200,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect208 = new ColorfulRectangle(movex+1200,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect209 = new ColorfulRectangle(movex+1300,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect210 = new ColorfulRectangle(movex+1300,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect211 = new ColorfulRectangle(movex+1350,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect212 = new ColorfulRectangle(movex+1350,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect213 = new ColorfulRectangle(movex+1350,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect214 = new ColorfulRectangle(movex+1700,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect215 = new ColorfulRectangle(movex+1650,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect216 = new ColorfulRectangle(movex+1750,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect217 = new ColorfulRectangle(movex+1800,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect218 = new ColorfulRectangle(movex+1800,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect219 = new ColorfulRectangle(movex+1850,movey+-1200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect220 = new ColorfulRectangle(movex+1800,movey+-1200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect221 = new ColorfulRectangle(movex+1850,movey+-2000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect222 = new ColorfulRectangle(movex+1850,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect223 = new ColorfulRectangle(movex+1800,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect224 = new ColorfulRectangle(movex+1750,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect225 = new ColorfulRectangle(movex+1750,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect226 = new ColorfulRectangle(movex+1800,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect227 = new ColorfulRectangle(movex+1700,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect228 = new ColorfulRectangle(movex+1700,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect229 = new ColorfulRectangle(movex+950,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect230 = new ColorfulRectangle(movex+950,movey+-2000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect231 = new ColorfulRectangle(movex+950,movey+-1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect232 = new ColorfulRectangle(movex+900,movey+-1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect233 = new ColorfulRectangle(movex+900,movey+-2000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect234 = new ColorfulRectangle(movex+850,movey+-1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect235 = new ColorfulRectangle(movex+-250,movey+300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect236 = new ColorfulRectangle(movex+-250,movey+350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect237 = new ColorfulRectangle(movex+0,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect238 = new ColorfulRectangle(movex+400,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect239 = new ColorfulRectangle(movex+550,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect240 = new ColorfulRectangle(movex+450,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect241 = new ColorfulRectangle(movex+1200,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect242 = new ColorfulRectangle(movex+-1150,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect243 = new ColorfulRectangle(movex+1050,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect244 = new ColorfulRectangle(movex+1200,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect245 = new ColorfulRectangle(movex+-750,movey+1000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect246 = new ColorfulRectangle(movex+-700,movey+1000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect247 = new ColorfulRectangle(movex+-650,movey+1000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect248 = new ColorfulRectangle(movex+-650,movey+1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect249 = new ColorfulRectangle(movex+-650,movey+1100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect250 = new ColorfulRectangle(movex+-600,movey+1100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect251 = new ColorfulRectangle(movex+-600,movey+1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect252 = new ColorfulRectangle(movex+-550,movey+1100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect253 = new ColorfulRectangle(movex+-550,movey+1150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect254 = new ColorfulRectangle(movex+-500,movey+1150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect255 = new ColorfulRectangle(movex+-500,movey+1100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect256 = new ColorfulRectangle(movex+-550,movey+1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect257 = new ColorfulRectangle(movex+-700,movey+950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect258 = new ColorfulRectangle(movex+-700,movey+1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect259 = new ColorfulRectangle(movex+-950,movey+550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect260 = new ColorfulRectangle(movex+-950,movey+600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect261 = new ColorfulRectangle(movex+-950,movey+650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect262 = new ColorfulRectangle(movex+-950,movey+700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect263 = new ColorfulRectangle(movex+-950,movey+750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect264 = new ColorfulRectangle(movex+-950,movey+800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect265 = new ColorfulRectangle(movex+-900,movey+800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect266 = new ColorfulRectangle(movex+-900,movey+750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect267 = new ColorfulRectangle(movex+-1000,movey+700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect268 = new ColorfulRectangle(movex+-1000,movey+650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect269 = new ColorfulRectangle(movex+-1000,movey+600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect270 = new ColorfulRectangle(movex+-1000,movey+550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect271 = new ColorfulRectangle(movex+-1050,movey+550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect272 = new ColorfulRectangle(movex+-1050,movey+500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect273 = new ColorfulRectangle(movex+-1000,movey+500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect274 = new ColorfulRectangle(movex+-1100,movey+500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect275 = new ColorfulRectangle(movex+-1100,movey+450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect276 = new ColorfulRectangle(movex+-1050,movey+450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect277 = new ColorfulRectangle(movex+-850,movey+300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect278 = new ColorfulRectangle(movex+-800,movey+300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect279 = new ColorfulRectangle(movex+-800,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect280 = new ColorfulRectangle(movex+-750,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect281 = new ColorfulRectangle(movex+-750,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect282 = new ColorfulRectangle(movex+-700,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect283 = new ColorfulRectangle(movex+-650,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect284 = new ColorfulRectangle(movex+-650,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect285 = new ColorfulRectangle(movex+-650,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect286 = new ColorfulRectangle(movex+-650,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect287 = new ColorfulRectangle(movex+-1100,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect288 = new ColorfulRectangle(movex+-1100,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect289 = new ColorfulRectangle(movex+-1150,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect290 = new ColorfulRectangle(movex+-1150,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect291 = new ColorfulRectangle(movex+-1200,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect292 = new ColorfulRectangle(movex+-1150,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect293 = new ColorfulRectangle(movex+-1200,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect294 = new ColorfulRectangle(movex+-1250,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect295 = new ColorfulRectangle(movex+-1250,movey+-100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect296 = new ColorfulRectangle(movex+-1300,movey+-100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect297 = new ColorfulRectangle(movex+-1300,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect298 = new ColorfulRectangle(movex+-1300,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect299 = new ColorfulRectangle(movex+-1300,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect300 = new ColorfulRectangle(movex+-1350,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect301 = new ColorfulRectangle(movex+-1400,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect302 = new ColorfulRectangle(movex+-1400,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect303 = new ColorfulRectangle(movex+-1550,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect304 = new ColorfulRectangle(movex+-1550,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect305 = new ColorfulRectangle(movex+-1600,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect306 = new ColorfulRectangle(movex+-1600,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect307 = new ColorfulRectangle(movex+-1600,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect308 = new ColorfulRectangle(movex+-1550,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect309 = new ColorfulRectangle(movex+-1500,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect310 = new ColorfulRectangle(movex+-1500,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect311 = new ColorfulRectangle(movex+-1500,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect312 = new ColorfulRectangle(movex+-1550,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect313 = new ColorfulRectangle(movex+-1450,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect314 = new ColorfulRectangle(movex+-1600,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect315 = new ColorfulRectangle(movex+-1600,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect316 = new ColorfulRectangle(movex+-1550,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect317 = new ColorfulRectangle(movex+-800,movey+950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect318 = new ColorfulRectangle(movex+-1200,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect319 = new ColorfulRectangle(movex+-1250,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect320 = new ColorfulRectangle(movex+-1300,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect321 = new ColorfulRectangle(movex+-1300,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect322 = new ColorfulRectangle(movex+-1350,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect323 = new ColorfulRectangle(movex+-1350,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect324 = new ColorfulRectangle(movex+-150,movey+550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect325 = new ColorfulRectangle(movex+-250,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect326 = new ColorfulRectangle(movex+-600,movey+-100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect327 = new ColorfulRectangle(movex+-300,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect328 = new ColorfulRectangle(movex+-250,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect329 = new ColorfulRectangle(movex+-200,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect330 = new ColorfulRectangle(movex+-250,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect331 = new ColorfulRectangle(movex+-250,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect332 = new ColorfulRectangle(movex+-500,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect333 = new ColorfulRectangle(movex+-550,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect334 = new ColorfulRectangle(movex+-600,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect335 = new ColorfulRectangle(movex+-600,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect336 = new ColorfulRectangle(movex+-50,movey+600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect337 = new ColorfulRectangle(movex+-250,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect338 = new ColorfulRectangle(movex+-950,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect339 = new ColorfulRectangle(movex+-900,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect340 = new ColorfulRectangle(movex+-900,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect341 = new ColorfulRectangle(movex+-850,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect342 = new ColorfulRectangle(movex+-850,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect343 = new ColorfulRectangle(movex+-800,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect344 = new ColorfulRectangle(movex+-800,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect345 = new ColorfulRectangle(movex+-850,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect346 = new ColorfulRectangle(movex+-850,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect347 = new ColorfulRectangle(movex+-800,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect348 = new ColorfulRectangle(movex+-800,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect349 = new ColorfulRectangle(movex+-300,movey+-700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect350 = new ColorfulRectangle(movex+-50,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect351 = new ColorfulRectangle(movex+-50,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect352 = new ColorfulRectangle(movex+-100,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect353 = new ColorfulRectangle(movex+-50,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect354 = new ColorfulRectangle(movex+-500,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect355 = new ColorfulRectangle(movex+-450,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect356 = new ColorfulRectangle(movex+-400,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect357 = new ColorfulRectangle(movex+-550,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect358 = new ColorfulRectangle(movex+-750,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect359 = new ColorfulRectangle(movex+-750,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect360 = new ColorfulRectangle(movex+-800,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect361 = new ColorfulRectangle(movex+-850,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect362 = new ColorfulRectangle(movex+-900,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect363 = new ColorfulRectangle(movex+-800,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect364 = new ColorfulRectangle(movex+-300,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect365 = new ColorfulRectangle(movex+-300,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect366 = new ColorfulRectangle(movex+0,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect367 = new ColorfulRectangle(movex+-800,movey+1000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect368 = new ColorfulRectangle(movex+-850,movey+1000, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect369 = new ColorfulRectangle(movex+-850,movey+950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect370 = new ColorfulRectangle(movex+-850,movey+900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect371 = new ColorfulRectangle(movex+-850,movey+850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect372 = new ColorfulRectangle(movex+-900,movey+850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect373 = new ColorfulRectangle(movex+-1050,movey+700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect374 = new ColorfulRectangle(movex+-1100,movey+700, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect375 = new ColorfulRectangle(movex+-1100,movey+650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect376 = new ColorfulRectangle(movex+-1050,movey+400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect377 = new ColorfulRectangle(movex+-1050,movey+350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect378 = new ColorfulRectangle(movex+-1050,movey+300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect379 = new ColorfulRectangle(movex+-1000,movey+300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect380 = new ColorfulRectangle(movex+-1000,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect381 = new ColorfulRectangle(movex+1400,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect382 = new ColorfulRectangle(movex+-950,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect383 = new ColorfulRectangle(movex+-900,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect384 = new ColorfulRectangle(movex+-900,movey+300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect385 = new ColorfulRectangle(movex+-600,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect386 = new ColorfulRectangle(movex+-550,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect387 = new ColorfulRectangle(movex+-500,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect388 = new ColorfulRectangle(movex+-450,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect389 = new ColorfulRectangle(movex+-450,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect390 = new ColorfulRectangle(movex+-750,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect391 = new ColorfulRectangle(movex+-750,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect392 = new ColorfulRectangle(movex+-800,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect393 = new ColorfulRectangle(movex+-850,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect394 = new ColorfulRectangle(movex+-850,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect395 = new ColorfulRectangle(movex+-1350,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect396 = new ColorfulRectangle(movex+-1300,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect397 = new ColorfulRectangle(movex+-1350,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect398 = new ColorfulRectangle(movex+-1350,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect399 = new ColorfulRectangle(movex+-1400,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect400 = new ColorfulRectangle(movex+-1150,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect401 = new ColorfulRectangle(movex+-1150,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect402 = new ColorfulRectangle(movex+-1200,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect403 = new ColorfulRectangle(movex+-1250,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect404 = new ColorfulRectangle(movex+-1300,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect405 = new ColorfulRectangle(movex+-1350,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect406 = new ColorfulRectangle(movex+-1350,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect407 = new ColorfulRectangle(movex+-1300,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect408 = new ColorfulRectangle(movex+-1200,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect409 = new ColorfulRectangle(movex+-1400,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect410 = new ColorfulRectangle(movex+-1450,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect411 = new ColorfulRectangle(movex+-1500,movey+-950, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect412 = new ColorfulRectangle(movex+-1500,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect413 = new ColorfulRectangle(movex+-1450,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect414 = new ColorfulRectangle(movex+-1450,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect415 = new ColorfulRectangle(movex+-1450,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect416 = new ColorfulRectangle(movex+-1500,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect417 = new ColorfulRectangle(movex+-1550,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect418 = new ColorfulRectangle(movex+-250,movey+-450, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect419 = new ColorfulRectangle(movex+-250,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect420 = new ColorfulRectangle(movex+-300,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect421 = new ColorfulRectangle(movex+-300,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect422 = new ColorfulRectangle(movex+-350,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect423 = new ColorfulRectangle(movex+-300,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect424 = new ColorfulRectangle(movex+-250,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect425 = new ColorfulRectangle(movex+-700,movey+-1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect426 = new ColorfulRectangle(movex+-750,movey+-1050, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect427 = new ColorfulRectangle(movex+-750,movey+-1100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect428 = new ColorfulRectangle(movex+-750,movey+-1150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect429 = new ColorfulRectangle(movex+-750,movey+-1200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect430 = new ColorfulRectangle(movex+-800,movey+-1200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect431 = new ColorfulRectangle(movex+-800,movey+-1250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect432 = new ColorfulRectangle(movex+-800,movey+-1300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect433 = new ColorfulRectangle(movex+-850,movey+-1300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect434 = new ColorfulRectangle(movex+-850,movey+-1350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect435 = new ColorfulRectangle(movex+-900,movey+-1400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect436 = new ColorfulRectangle(movex+-850,movey+-1400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect437 = new ColorfulRectangle(movex+-100,movey+-650, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect438 = new ColorfulRectangle(movex+-100,movey+-600, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect439 = new ColorfulRectangle(movex+-100,movey+-550, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect440 = new ColorfulRectangle(movex+-100,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect441 = new ColorfulRectangle(movex+-50,movey+-500, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect442 = new ColorfulRectangle(movex+550,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect443 = new ColorfulRectangle(movex+450,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect444 = new ColorfulRectangle(movex+500,movey+250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect445 = new ColorfulRectangle(movex+450,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect446 = new ColorfulRectangle(movex+400,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect447 = new ColorfulRectangle(movex+350,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect448 = new ColorfulRectangle(movex+300,movey+200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect449 = new ColorfulRectangle(movex+300,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect450 = new ColorfulRectangle(movex+300,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect451 = new ColorfulRectangle(movex+400,movey+150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect452 = new ColorfulRectangle(movex+400,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect453 = new ColorfulRectangle(movex+450,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect454 = new ColorfulRectangle(movex+500,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect455 = new ColorfulRectangle(movex+250,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect456 = new ColorfulRectangle(movex+250,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect457 = new ColorfulRectangle(movex+250,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect458 = new ColorfulRectangle(movex+250,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect459 = new ColorfulRectangle(movex+200,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect460 = new ColorfulRectangle(movex+200,movey+-100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect461 = new ColorfulRectangle(movex+200,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect462 = new ColorfulRectangle(movex+150,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect463 = new ColorfulRectangle(movex+150,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect464 = new ColorfulRectangle(movex+200,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect465 = new ColorfulRectangle(movex+200,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect466 = new ColorfulRectangle(movex+150,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect467 = new ColorfulRectangle(movex+150,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect468 = new ColorfulRectangle(movex+300,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect469 = new ColorfulRectangle(movex+250,movey+-150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect470 = new ColorfulRectangle(movex+250,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect471 = new ColorfulRectangle(movex+900,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect472 = new ColorfulRectangle(movex+900,movey+0, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect473 = new ColorfulRectangle(movex+900,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect474 = new ColorfulRectangle(movex+950,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect475 = new ColorfulRectangle(movex+950,movey+100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect476 = new ColorfulRectangle(movex+1000,movey+50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect477 = new ColorfulRectangle(movex+1100,movey+-100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect478 = new ColorfulRectangle(movex+1050,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect479 = new ColorfulRectangle(movex+1100,movey+-50, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect480 = new ColorfulRectangle(movex+1250,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect481 = new ColorfulRectangle(movex+1800,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect482 = new ColorfulRectangle(movex+1800,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect483 = new ColorfulRectangle(movex+1750,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect484 = new ColorfulRectangle(movex+1700,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect485 = new ColorfulRectangle(movex+1650,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect486 = new ColorfulRectangle(movex+1650,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect487 = new ColorfulRectangle(movex+1600,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect488 = new ColorfulRectangle(movex+1550,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect489 = new ColorfulRectangle(movex+1500,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect490 = new ColorfulRectangle(movex+1500,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect491 = new ColorfulRectangle(movex+1450,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect492 = new ColorfulRectangle(movex+1400,movey+-200, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect493 = new ColorfulRectangle(movex+1400,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect494 = new ColorfulRectangle(movex+1350,movey+-250, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect495 = new ColorfulRectangle(movex+950,movey+-1100, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect496 = new ColorfulRectangle(movex+950,movey+-1150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect497 = new ColorfulRectangle(movex+900,movey+-1150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect498 = new ColorfulRectangle(movex+850,movey+-1150, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect499 = new ColorfulRectangle(movex+-1400,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect500 = new ColorfulRectangle(movex+-1400,movey+-400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect501 = new ColorfulRectangle(movex+-350,movey+-1300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect502 = new ColorfulRectangle(movex+-300,movey+-1300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect503 = new ColorfulRectangle(movex+-250,movey+-1300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect504 = new ColorfulRectangle(movex+-250,movey+-1350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect505 = new ColorfulRectangle(movex+-200,movey+-1350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect506 = new ColorfulRectangle(movex+-100,movey+-1350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect507 = new ColorfulRectangle(movex+-150,movey+-1350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect508 = new ColorfulRectangle(movex+-50,movey+-1350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect509 = new ColorfulRectangle(movex+-50,movey+-1400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect510 = new ColorfulRectangle(movex+0,movey+-1400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect511 = new ColorfulRectangle(movex+50,movey+-1400, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect512 = new ColorfulRectangle(movex+350,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect513 = new ColorfulRectangle(movex+400,movey+-900, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect514 = new ColorfulRectangle(movex+400,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect515 = new ColorfulRectangle(movex+450,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect516 = new ColorfulRectangle(movex+500,movey+-850, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect517 = new ColorfulRectangle(movex+500,movey+-800, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect518 = new ColorfulRectangle(movex+500,movey+-750, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect519 = new ColorfulRectangle(movex+1350,movey+-350, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect520 = new ColorfulRectangle(movex+1350,movey+-300, 50, 50, Color.MAGENTA);
		buildings2ChangeColorRect521 = new ColorfulRectangle(movex+1400,movey+-350, 50, 50, Color.MAGENTA);

		
		if(endingBlockSwitch<10) {
		buildings2ChangeColorRect1.col = Color.MAGENTA;
		buildings2ChangeColorRect2.col = Color.MAGENTA;
		buildings2ChangeColorRect3.col = Color.MAGENTA;
		buildings2ChangeColorRect4.col = Color.MAGENTA;
		buildings2ChangeColorRect5.col = Color.MAGENTA;
		buildings2ChangeColorRect6.col = Color.MAGENTA;
		buildings2ChangeColorRect7.col = Color.MAGENTA;
		buildings2ChangeColorRect8.col = Color.MAGENTA;
		buildings2ChangeColorRect9.col = Color.MAGENTA;
		buildings2ChangeColorRect10.col = Color.MAGENTA;
		buildings2ChangeColorRect11.col = Color.MAGENTA;
		buildings2ChangeColorRect12.col = Color.MAGENTA;
		buildings2ChangeColorRect13.col = Color.MAGENTA;
		buildings2ChangeColorRect14.col = Color.MAGENTA;
		buildings2ChangeColorRect15.col = Color.MAGENTA;
		buildings2ChangeColorRect16.col = Color.MAGENTA;
		buildings2ChangeColorRect17.col = Color.MAGENTA;
		buildings2ChangeColorRect18.col = Color.MAGENTA;
		buildings2ChangeColorRect19.col = Color.MAGENTA;
		buildings2ChangeColorRect20.col = Color.MAGENTA;
		buildings2ChangeColorRect21.col = Color.MAGENTA;
		buildings2ChangeColorRect22.col = Color.MAGENTA;
		buildings2ChangeColorRect23.col = Color.MAGENTA;
		buildings2ChangeColorRect24.col = Color.MAGENTA;
		buildings2ChangeColorRect25.col = Color.MAGENTA;
		buildings2ChangeColorRect26.col = Color.MAGENTA;
		buildings2ChangeColorRect27.col = Color.MAGENTA;
		buildings2ChangeColorRect28.col = Color.MAGENTA;
		buildings2ChangeColorRect29.col = Color.MAGENTA;
		buildings2ChangeColorRect30.col = Color.MAGENTA;
		buildings2ChangeColorRect31.col = Color.MAGENTA;
		buildings2ChangeColorRect32.col = Color.MAGENTA;
		buildings2ChangeColorRect33.col = Color.MAGENTA;
		buildings2ChangeColorRect34.col = Color.MAGENTA;
		buildings2ChangeColorRect35.col = Color.MAGENTA;
		buildings2ChangeColorRect36.col = Color.MAGENTA;
		buildings2ChangeColorRect37.col = Color.MAGENTA;
		buildings2ChangeColorRect38.col = Color.MAGENTA;
		buildings2ChangeColorRect39.col = Color.MAGENTA;
		buildings2ChangeColorRect40.col = Color.MAGENTA;
		buildings2ChangeColorRect41.col = Color.MAGENTA;
		buildings2ChangeColorRect42.col = Color.MAGENTA;
		buildings2ChangeColorRect43.col = Color.MAGENTA;
		buildings2ChangeColorRect44.col = Color.MAGENTA;
		buildings2ChangeColorRect45.col = Color.MAGENTA;
		buildings2ChangeColorRect46.col = Color.MAGENTA;
		buildings2ChangeColorRect47.col = Color.MAGENTA;
		buildings2ChangeColorRect48.col = Color.MAGENTA;
		buildings2ChangeColorRect49.col = Color.MAGENTA;
		buildings2ChangeColorRect50.col = Color.MAGENTA;
		buildings2ChangeColorRect51.col = Color.MAGENTA;
		buildings2ChangeColorRect52.col = Color.MAGENTA;
		buildings2ChangeColorRect53.col = Color.MAGENTA;	
		buildings2ChangeColorRect53a.col = Color.MAGENTA;	
		buildings2ChangeColorRect54.col = Color.MAGENTA;
		buildings2ChangeColorRect55.col = Color.MAGENTA;
		buildings2ChangeColorRect56.col = Color.MAGENTA;
		buildings2ChangeColorRect57.col = Color.MAGENTA;
		buildings2ChangeColorRect58.col = Color.MAGENTA;
		buildings2ChangeColorRect59.col = Color.MAGENTA;
		buildings2ChangeColorRect60.col = Color.MAGENTA;
		buildings2ChangeColorRect61.col = Color.MAGENTA;
		buildings2ChangeColorRect62.col = Color.MAGENTA;
		buildings2ChangeColorRect63.col = Color.MAGENTA;
		buildings2ChangeColorRect64.col = Color.MAGENTA;
		buildings2ChangeColorRect65.col = Color.MAGENTA;
		buildings2ChangeColorRect66.col = Color.MAGENTA;
		buildings2ChangeColorRect67.col = Color.MAGENTA;
		buildings2ChangeColorRect68.col = Color.MAGENTA;
		buildings2ChangeColorRect69.col = Color.MAGENTA;
		buildings2ChangeColorRect70.col = Color.MAGENTA;
		buildings2ChangeColorRect71.col = Color.MAGENTA;
		buildings2ChangeColorRect72.col = Color.MAGENTA;
		buildings2ChangeColorRect73.col = Color.MAGENTA;
		buildings2ChangeColorRect74.col = Color.MAGENTA;
		buildings2ChangeColorRect75.col = Color.MAGENTA;
		buildings2ChangeColorRect76.col = Color.MAGENTA;
		buildings2ChangeColorRect77.col = Color.MAGENTA;
		buildings2ChangeColorRect78.col = Color.MAGENTA;
		buildings2ChangeColorRect79.col = Color.MAGENTA;
		buildings2ChangeColorRect80.col = Color.MAGENTA;
		buildings2ChangeColorRect81.col = Color.MAGENTA;
		buildings2ChangeColorRect82.col = Color.MAGENTA;
		buildings2ChangeColorRect83.col = Color.MAGENTA;
		buildings2ChangeColorRect84.col = Color.MAGENTA;
		buildings2ChangeColorRect85.col = Color.MAGENTA;
		buildings2ChangeColorRect86.col = Color.MAGENTA;
		buildings2ChangeColorRect87.col = Color.MAGENTA;
		buildings2ChangeColorRect88.col = Color.MAGENTA;
		buildings2ChangeColorRect89.col = Color.MAGENTA;
		buildings2ChangeColorRect90.col = Color.MAGENTA;
		buildings2ChangeColorRect91.col = Color.MAGENTA;
		buildings2ChangeColorRect92.col = Color.MAGENTA;
		buildings2ChangeColorRect93.col = Color.MAGENTA;
		buildings2ChangeColorRect94.col = Color.MAGENTA;
		buildings2ChangeColorRect95.col = Color.MAGENTA;
		buildings2ChangeColorRect96.col = Color.MAGENTA;
		buildings2ChangeColorRect97.col = Color.MAGENTA;
		buildings2ChangeColorRect98.col = Color.MAGENTA;
		buildings2ChangeColorRect99.col = Color.MAGENTA;
		buildings2ChangeColorRect100.col = Color.MAGENTA;
		buildings2ChangeColorRect101.col = Color.MAGENTA;
		buildings2ChangeColorRect102.col = Color.MAGENTA;
		buildings2ChangeColorRect103.col = Color.MAGENTA;
		buildings2ChangeColorRect104.col = Color.MAGENTA;
		buildings2ChangeColorRect105.col = Color.MAGENTA;
		buildings2ChangeColorRect106.col = Color.MAGENTA;
		buildings2ChangeColorRect107.col = Color.MAGENTA;
		buildings2ChangeColorRect108.col = Color.MAGENTA;
		buildings2ChangeColorRect109.col = Color.MAGENTA;
		buildings2ChangeColorRect110.col = Color.MAGENTA;
		buildings2ChangeColorRect111.col = Color.MAGENTA;
		buildings2ChangeColorRect112.col = Color.MAGENTA;
		buildings2ChangeColorRect113.col = Color.MAGENTA;
		buildings2ChangeColorRect114.col = Color.MAGENTA;
		buildings2ChangeColorRect115.col = Color.MAGENTA;
		buildings2ChangeColorRect116.col = Color.MAGENTA;
		buildings2ChangeColorRect117.col = Color.MAGENTA;
		buildings2ChangeColorRect118.col = Color.MAGENTA;
		buildings2ChangeColorRect119.col = Color.MAGENTA;
		buildings2ChangeColorRect120.col = Color.MAGENTA;
		buildings2ChangeColorRect121.col = Color.MAGENTA;
		buildings2ChangeColorRect122.col = Color.MAGENTA;
		buildings2ChangeColorRect123.col = Color.MAGENTA;
		buildings2ChangeColorRect124.col = Color.MAGENTA;
		buildings2ChangeColorRect125.col = Color.MAGENTA;
		buildings2ChangeColorRect126.col = Color.MAGENTA;
		buildings2ChangeColorRect127.col = Color.MAGENTA;
		buildings2ChangeColorRect128.col = Color.MAGENTA;
		buildings2ChangeColorRect129.col = Color.MAGENTA;
		buildings2ChangeColorRect130.col = Color.MAGENTA;
		buildings2ChangeColorRect131.col = Color.MAGENTA;
		buildings2ChangeColorRect132.col = Color.MAGENTA;
		buildings2ChangeColorRect133.col = Color.MAGENTA;
		buildings2ChangeColorRect134.col = Color.MAGENTA;
		buildings2ChangeColorRect135.col = Color.MAGENTA;
		buildings2ChangeColorRect136.col = Color.MAGENTA;
		buildings2ChangeColorRect137.col = Color.MAGENTA;
		buildings2ChangeColorRect138.col = Color.MAGENTA;
		buildings2ChangeColorRect139.col = Color.MAGENTA;
		buildings2ChangeColorRect140.col = Color.MAGENTA;
		buildings2ChangeColorRect141.col = Color.MAGENTA;
		buildings2ChangeColorRect142.col = Color.MAGENTA;
		buildings2ChangeColorRect143.col = Color.MAGENTA;
		buildings2ChangeColorRect144.col = Color.MAGENTA;
		buildings2ChangeColorRect145.col = Color.MAGENTA;
		buildings2ChangeColorRect146.col = Color.MAGENTA;
		buildings2ChangeColorRect147.col = Color.MAGENTA;
		buildings2ChangeColorRect148.col = Color.MAGENTA;
		buildings2ChangeColorRect149.col = Color.MAGENTA;
		buildings2ChangeColorRect150.col = Color.MAGENTA;
		buildings2ChangeColorRect151.col = Color.MAGENTA;
		buildings2ChangeColorRect152.col = Color.MAGENTA;
		buildings2ChangeColorRect153.col = Color.MAGENTA;
		buildings2ChangeColorRect154.col = Color.MAGENTA;
		buildings2ChangeColorRect155.col = Color.MAGENTA;
		buildings2ChangeColorRect156.col = Color.MAGENTA;
		buildings2ChangeColorRect157.col = Color.MAGENTA;
		buildings2ChangeColorRect158.col = Color.MAGENTA;
		buildings2ChangeColorRect159.col = Color.MAGENTA;
		buildings2ChangeColorRect160.col = Color.MAGENTA;
		buildings2ChangeColorRect161.col = Color.MAGENTA;
		buildings2ChangeColorRect162.col = Color.MAGENTA;
		buildings2ChangeColorRect163.col = Color.MAGENTA;
		buildings2ChangeColorRect164.col = Color.MAGENTA;
		buildings2ChangeColorRect165.col = Color.MAGENTA;
		buildings2ChangeColorRect166.col = Color.MAGENTA;
		buildings2ChangeColorRect167.col = Color.MAGENTA;
		buildings2ChangeColorRect168.col = Color.MAGENTA;
		buildings2ChangeColorRect169.col = Color.MAGENTA;
		buildings2ChangeColorRect170.col = Color.MAGENTA;
		buildings2ChangeColorRect171.col = Color.MAGENTA;
		buildings2ChangeColorRect172.col = Color.MAGENTA;
		buildings2ChangeColorRect173.col = Color.MAGENTA;
		buildings2ChangeColorRect174.col = Color.MAGENTA;
		buildings2ChangeColorRect175.col = Color.MAGENTA;
		buildings2ChangeColorRect176.col = Color.MAGENTA;
		buildings2ChangeColorRect177.col = Color.MAGENTA;
		buildings2ChangeColorRect178.col = Color.MAGENTA;
		buildings2ChangeColorRect179.col = Color.MAGENTA;
		buildings2ChangeColorRect180.col = Color.MAGENTA;
		buildings2ChangeColorRect181.col = Color.MAGENTA;
		buildings2ChangeColorRect182.col = Color.MAGENTA;
		buildings2ChangeColorRect183.col = Color.MAGENTA;
		buildings2ChangeColorRect184.col = Color.MAGENTA;
		buildings2ChangeColorRect185.col = Color.MAGENTA;
		buildings2ChangeColorRect186.col = Color.MAGENTA;
		buildings2ChangeColorRect187.col = Color.MAGENTA;
		buildings2ChangeColorRect188.col = Color.MAGENTA;
		buildings2ChangeColorRect189.col = Color.MAGENTA;
		buildings2ChangeColorRect190.col = Color.MAGENTA;
		buildings2ChangeColorRect191.col = Color.MAGENTA;
		buildings2ChangeColorRect192.col = Color.MAGENTA;
		buildings2ChangeColorRect193.col = Color.MAGENTA;
		buildings2ChangeColorRect194.col = Color.MAGENTA;
		buildings2ChangeColorRect195.col = Color.MAGENTA;
		buildings2ChangeColorRect196.col = Color.MAGENTA;
		buildings2ChangeColorRect197.col = Color.MAGENTA;
		buildings2ChangeColorRect198.col = Color.MAGENTA;
		buildings2ChangeColorRect199.col = Color.MAGENTA;
		buildings2ChangeColorRect200.col = Color.MAGENTA;
		buildings2ChangeColorRect201.col = Color.MAGENTA;
		buildings2ChangeColorRect202.col = Color.MAGENTA;
		buildings2ChangeColorRect203.col = Color.MAGENTA;
		buildings2ChangeColorRect204.col = Color.MAGENTA;
		buildings2ChangeColorRect205.col = Color.MAGENTA;
		buildings2ChangeColorRect206.col = Color.MAGENTA;
		buildings2ChangeColorRect207.col = Color.MAGENTA;
		buildings2ChangeColorRect208.col = Color.MAGENTA;
		buildings2ChangeColorRect209.col = Color.MAGENTA;
		buildings2ChangeColorRect210.col = Color.MAGENTA;
		buildings2ChangeColorRect211.col = Color.MAGENTA;
		buildings2ChangeColorRect212.col = Color.MAGENTA;
		buildings2ChangeColorRect213.col = Color.MAGENTA;
		buildings2ChangeColorRect214.col = Color.MAGENTA;
		buildings2ChangeColorRect215.col = Color.MAGENTA;
		buildings2ChangeColorRect216.col = Color.MAGENTA;
		buildings2ChangeColorRect217.col = Color.MAGENTA;
		buildings2ChangeColorRect218.col = Color.MAGENTA;
		buildings2ChangeColorRect219.col = Color.MAGENTA;
		buildings2ChangeColorRect220.col = Color.MAGENTA;
		buildings2ChangeColorRect221.col = Color.MAGENTA;
		buildings2ChangeColorRect222.col = Color.MAGENTA;
		buildings2ChangeColorRect223.col = Color.MAGENTA;
		buildings2ChangeColorRect224.col = Color.MAGENTA;
		buildings2ChangeColorRect225.col = Color.MAGENTA;
		buildings2ChangeColorRect226.col = Color.MAGENTA;
		buildings2ChangeColorRect227.col = Color.MAGENTA;
		buildings2ChangeColorRect228.col = Color.MAGENTA;
		buildings2ChangeColorRect229.col = Color.MAGENTA;
		buildings2ChangeColorRect230.col = Color.MAGENTA;
		buildings2ChangeColorRect231.col = Color.MAGENTA;
		buildings2ChangeColorRect232.col = Color.MAGENTA;
		buildings2ChangeColorRect233.col = Color.MAGENTA;
		buildings2ChangeColorRect234.col = Color.MAGENTA;
		buildings2ChangeColorRect235.col = Color.MAGENTA;
		buildings2ChangeColorRect236.col = Color.MAGENTA;
		buildings2ChangeColorRect237.col = Color.MAGENTA;
		buildings2ChangeColorRect238.col = Color.MAGENTA;
		buildings2ChangeColorRect239.col = Color.MAGENTA;
		buildings2ChangeColorRect240.col = Color.MAGENTA;
		buildings2ChangeColorRect241.col = Color.MAGENTA;
		buildings2ChangeColorRect242.col = Color.MAGENTA;
		buildings2ChangeColorRect243.col = Color.MAGENTA;
		buildings2ChangeColorRect244.col = Color.MAGENTA;
		buildings2ChangeColorRect245.col = Color.MAGENTA;
		buildings2ChangeColorRect246.col = Color.MAGENTA;
		buildings2ChangeColorRect247.col = Color.MAGENTA;
		buildings2ChangeColorRect248.col = Color.MAGENTA;
		buildings2ChangeColorRect249.col = Color.MAGENTA;
		buildings2ChangeColorRect250.col = Color.MAGENTA;
		buildings2ChangeColorRect251.col = Color.MAGENTA;
		buildings2ChangeColorRect252.col = Color.MAGENTA;
		buildings2ChangeColorRect253.col = Color.MAGENTA;
		buildings2ChangeColorRect254.col = Color.MAGENTA;
		buildings2ChangeColorRect255.col = Color.MAGENTA;
		buildings2ChangeColorRect256.col = Color.MAGENTA;
		buildings2ChangeColorRect257.col = Color.MAGENTA;
		buildings2ChangeColorRect258.col = Color.MAGENTA;
		buildings2ChangeColorRect259.col = Color.MAGENTA;
		buildings2ChangeColorRect260.col = Color.MAGENTA;
		buildings2ChangeColorRect261.col = Color.MAGENTA;
		buildings2ChangeColorRect262.col = Color.MAGENTA;
		buildings2ChangeColorRect263.col = Color.MAGENTA;
		buildings2ChangeColorRect264.col = Color.MAGENTA;
		buildings2ChangeColorRect265.col = Color.MAGENTA;
		buildings2ChangeColorRect266.col = Color.MAGENTA;
		buildings2ChangeColorRect267.col = Color.MAGENTA;
		buildings2ChangeColorRect268.col = Color.MAGENTA;
		buildings2ChangeColorRect269.col = Color.MAGENTA;
		buildings2ChangeColorRect270.col = Color.MAGENTA;
		buildings2ChangeColorRect271.col = Color.MAGENTA;
		buildings2ChangeColorRect272.col = Color.MAGENTA;
		buildings2ChangeColorRect273.col = Color.MAGENTA;
		buildings2ChangeColorRect274.col = Color.MAGENTA;
		buildings2ChangeColorRect275.col = Color.MAGENTA;
		buildings2ChangeColorRect276.col = Color.MAGENTA;
		buildings2ChangeColorRect277.col = Color.MAGENTA;
		buildings2ChangeColorRect278.col = Color.MAGENTA;
		buildings2ChangeColorRect279.col = Color.MAGENTA;
		buildings2ChangeColorRect280.col = Color.MAGENTA;
		buildings2ChangeColorRect281.col = Color.MAGENTA;
		buildings2ChangeColorRect282.col = Color.MAGENTA;
		buildings2ChangeColorRect283.col = Color.MAGENTA;
		buildings2ChangeColorRect284.col = Color.MAGENTA;
		buildings2ChangeColorRect285.col = Color.MAGENTA;
		buildings2ChangeColorRect286.col = Color.MAGENTA;
		buildings2ChangeColorRect287.col = Color.MAGENTA;
		buildings2ChangeColorRect288.col = Color.MAGENTA;
		buildings2ChangeColorRect289.col = Color.MAGENTA;
		buildings2ChangeColorRect290.col = Color.MAGENTA;
		buildings2ChangeColorRect291.col = Color.MAGENTA;
		buildings2ChangeColorRect292.col = Color.MAGENTA;
		buildings2ChangeColorRect293.col = Color.MAGENTA;
		buildings2ChangeColorRect294.col = Color.MAGENTA;
		buildings2ChangeColorRect295.col = Color.MAGENTA;
		buildings2ChangeColorRect296.col = Color.MAGENTA;
		buildings2ChangeColorRect297.col = Color.MAGENTA;
		buildings2ChangeColorRect298.col = Color.MAGENTA;
		buildings2ChangeColorRect299.col = Color.MAGENTA;
		buildings2ChangeColorRect300.col = Color.MAGENTA;
		buildings2ChangeColorRect301.col = Color.MAGENTA;
		buildings2ChangeColorRect302.col = Color.MAGENTA;
		buildings2ChangeColorRect303.col = Color.MAGENTA;
		buildings2ChangeColorRect304.col = Color.MAGENTA;
		buildings2ChangeColorRect305.col = Color.MAGENTA;
		buildings2ChangeColorRect306.col = Color.MAGENTA;
		buildings2ChangeColorRect307.col = Color.MAGENTA;
		buildings2ChangeColorRect308.col = Color.MAGENTA;
		buildings2ChangeColorRect309.col = Color.MAGENTA;
		buildings2ChangeColorRect310.col = Color.MAGENTA;
		buildings2ChangeColorRect311.col = Color.MAGENTA;
		buildings2ChangeColorRect312.col = Color.MAGENTA;
		buildings2ChangeColorRect313.col = Color.MAGENTA;
		buildings2ChangeColorRect314.col = Color.MAGENTA;
		buildings2ChangeColorRect315.col = Color.MAGENTA;
		buildings2ChangeColorRect316.col = Color.MAGENTA;
		buildings2ChangeColorRect317.col = Color.MAGENTA;
		buildings2ChangeColorRect318.col = Color.MAGENTA;
		buildings2ChangeColorRect319.col = Color.MAGENTA;
		buildings2ChangeColorRect320.col = Color.MAGENTA;
		buildings2ChangeColorRect321.col = Color.MAGENTA;
		buildings2ChangeColorRect322.col = Color.MAGENTA;
		buildings2ChangeColorRect323.col = Color.MAGENTA;
		buildings2ChangeColorRect324.col = Color.MAGENTA;
		buildings2ChangeColorRect325.col = Color.MAGENTA;
		buildings2ChangeColorRect326.col = Color.MAGENTA;
		buildings2ChangeColorRect327.col = Color.MAGENTA;
		buildings2ChangeColorRect328.col = Color.MAGENTA;
		buildings2ChangeColorRect329.col = Color.MAGENTA;
		buildings2ChangeColorRect330.col = Color.MAGENTA;
		buildings2ChangeColorRect331.col = Color.MAGENTA;
		buildings2ChangeColorRect332.col = Color.MAGENTA;
		buildings2ChangeColorRect333.col = Color.MAGENTA;
		buildings2ChangeColorRect334.col = Color.MAGENTA;
		buildings2ChangeColorRect335.col = Color.MAGENTA;
		buildings2ChangeColorRect336.col = Color.MAGENTA;
		buildings2ChangeColorRect337.col = Color.MAGENTA;
		buildings2ChangeColorRect338.col = Color.MAGENTA;
		buildings2ChangeColorRect339.col = Color.MAGENTA;
		buildings2ChangeColorRect340.col = Color.MAGENTA;
		buildings2ChangeColorRect341.col = Color.MAGENTA;
		buildings2ChangeColorRect342.col = Color.MAGENTA;
		buildings2ChangeColorRect343.col = Color.MAGENTA;
		buildings2ChangeColorRect344.col = Color.MAGENTA;
		buildings2ChangeColorRect345.col = Color.MAGENTA;
		buildings2ChangeColorRect346.col = Color.MAGENTA;
		buildings2ChangeColorRect347.col = Color.MAGENTA;
		buildings2ChangeColorRect348.col = Color.MAGENTA;
		buildings2ChangeColorRect349.col = Color.MAGENTA;
		buildings2ChangeColorRect350.col = Color.MAGENTA;
		buildings2ChangeColorRect351.col = Color.MAGENTA;
		buildings2ChangeColorRect352.col = Color.MAGENTA;
		buildings2ChangeColorRect353.col = Color.MAGENTA;
		buildings2ChangeColorRect354.col = Color.MAGENTA;
		buildings2ChangeColorRect355.col = Color.MAGENTA;
		buildings2ChangeColorRect356.col = Color.MAGENTA;
		buildings2ChangeColorRect357.col = Color.MAGENTA;
		buildings2ChangeColorRect358.col = Color.MAGENTA;
		buildings2ChangeColorRect359.col = Color.MAGENTA;
		buildings2ChangeColorRect360.col = Color.MAGENTA;
		buildings2ChangeColorRect361.col = Color.MAGENTA;
		buildings2ChangeColorRect362.col = Color.MAGENTA;
		buildings2ChangeColorRect363.col = Color.MAGENTA;
		buildings2ChangeColorRect364.col = Color.MAGENTA;
		buildings2ChangeColorRect365.col = Color.MAGENTA;
		buildings2ChangeColorRect366.col = Color.MAGENTA;
		buildings2ChangeColorRect367.col = Color.MAGENTA;
		buildings2ChangeColorRect368.col = Color.MAGENTA;
		buildings2ChangeColorRect369.col = Color.MAGENTA;
		buildings2ChangeColorRect370.col = Color.MAGENTA;
		buildings2ChangeColorRect371.col = Color.MAGENTA;
		buildings2ChangeColorRect372.col = Color.MAGENTA;
		buildings2ChangeColorRect373.col = Color.MAGENTA;
		buildings2ChangeColorRect374.col = Color.MAGENTA;
		buildings2ChangeColorRect375.col = Color.MAGENTA;
		buildings2ChangeColorRect376.col = Color.MAGENTA;
		buildings2ChangeColorRect377.col = Color.MAGENTA;
		buildings2ChangeColorRect378.col = Color.MAGENTA;
		buildings2ChangeColorRect379.col = Color.MAGENTA;
		buildings2ChangeColorRect380.col = Color.MAGENTA;
		buildings2ChangeColorRect381.col = Color.MAGENTA;
		buildings2ChangeColorRect382.col = Color.MAGENTA;
		buildings2ChangeColorRect383.col = Color.MAGENTA;
		buildings2ChangeColorRect384.col = Color.MAGENTA;
		buildings2ChangeColorRect385.col = Color.MAGENTA;
		buildings2ChangeColorRect386.col = Color.MAGENTA;
		buildings2ChangeColorRect387.col = Color.MAGENTA;
		buildings2ChangeColorRect388.col = Color.MAGENTA;
		buildings2ChangeColorRect389.col = Color.MAGENTA;
		buildings2ChangeColorRect390.col = Color.MAGENTA;
		buildings2ChangeColorRect391.col = Color.MAGENTA;
		buildings2ChangeColorRect392.col = Color.MAGENTA;
		buildings2ChangeColorRect393.col = Color.MAGENTA;
		buildings2ChangeColorRect394.col = Color.MAGENTA;
		buildings2ChangeColorRect395.col = Color.MAGENTA;
		buildings2ChangeColorRect396.col = Color.MAGENTA;
		buildings2ChangeColorRect397.col = Color.MAGENTA;
		buildings2ChangeColorRect398.col = Color.MAGENTA;
		buildings2ChangeColorRect399.col = Color.MAGENTA;
		buildings2ChangeColorRect400.col = Color.MAGENTA;
		buildings2ChangeColorRect401.col = Color.MAGENTA;
		buildings2ChangeColorRect402.col = Color.MAGENTA;
		buildings2ChangeColorRect403.col = Color.MAGENTA;
		buildings2ChangeColorRect404.col = Color.MAGENTA;
		buildings2ChangeColorRect405.col = Color.MAGENTA;
		buildings2ChangeColorRect406.col = Color.MAGENTA;
		buildings2ChangeColorRect407.col = Color.MAGENTA;
		buildings2ChangeColorRect408.col = Color.MAGENTA;
		buildings2ChangeColorRect409.col = Color.MAGENTA;
		buildings2ChangeColorRect410.col = Color.MAGENTA;
		buildings2ChangeColorRect411.col = Color.MAGENTA;
		buildings2ChangeColorRect412.col = Color.MAGENTA;
		buildings2ChangeColorRect413.col = Color.MAGENTA;
		buildings2ChangeColorRect414.col = Color.MAGENTA;
		buildings2ChangeColorRect415.col = Color.MAGENTA;
		buildings2ChangeColorRect416.col = Color.MAGENTA;
		buildings2ChangeColorRect417.col = Color.MAGENTA;
		buildings2ChangeColorRect418.col = Color.MAGENTA;
		buildings2ChangeColorRect419.col = Color.MAGENTA;
		buildings2ChangeColorRect420.col = Color.MAGENTA;
		buildings2ChangeColorRect421.col = Color.MAGENTA;
		buildings2ChangeColorRect422.col = Color.MAGENTA;
		buildings2ChangeColorRect423.col = Color.MAGENTA;
		buildings2ChangeColorRect424.col = Color.MAGENTA;
		buildings2ChangeColorRect425.col = Color.MAGENTA;
		buildings2ChangeColorRect426.col = Color.MAGENTA;
		buildings2ChangeColorRect427.col = Color.MAGENTA;
		buildings2ChangeColorRect428.col = Color.MAGENTA;
		buildings2ChangeColorRect429.col = Color.MAGENTA;
		buildings2ChangeColorRect430.col = Color.MAGENTA;
		buildings2ChangeColorRect431.col = Color.MAGENTA;
		buildings2ChangeColorRect432.col = Color.MAGENTA;
		buildings2ChangeColorRect433.col = Color.MAGENTA;
		buildings2ChangeColorRect434.col = Color.MAGENTA;
		buildings2ChangeColorRect435.col = Color.MAGENTA;
		buildings2ChangeColorRect436.col = Color.MAGENTA;
		buildings2ChangeColorRect437.col = Color.MAGENTA;
		buildings2ChangeColorRect438.col = Color.MAGENTA;
		buildings2ChangeColorRect439.col = Color.MAGENTA;
		buildings2ChangeColorRect440.col = Color.MAGENTA;
		buildings2ChangeColorRect441.col = Color.MAGENTA;
		buildings2ChangeColorRect442.col = Color.MAGENTA;
		buildings2ChangeColorRect443.col = Color.MAGENTA;
		buildings2ChangeColorRect444.col = Color.MAGENTA;
		buildings2ChangeColorRect445.col = Color.MAGENTA;
		buildings2ChangeColorRect446.col = Color.MAGENTA;
		buildings2ChangeColorRect447.col = Color.MAGENTA;
		buildings2ChangeColorRect448.col = Color.MAGENTA;
		buildings2ChangeColorRect449.col = Color.MAGENTA;
		buildings2ChangeColorRect450.col = Color.MAGENTA;
		buildings2ChangeColorRect451.col = Color.MAGENTA;
		buildings2ChangeColorRect452.col = Color.MAGENTA;
		buildings2ChangeColorRect453.col = Color.MAGENTA;
		buildings2ChangeColorRect454.col = Color.MAGENTA;
		buildings2ChangeColorRect455.col = Color.MAGENTA;
		buildings2ChangeColorRect456.col = Color.MAGENTA;
		buildings2ChangeColorRect457.col = Color.MAGENTA;
		buildings2ChangeColorRect458.col = Color.MAGENTA;
		buildings2ChangeColorRect459.col = Color.MAGENTA;
		buildings2ChangeColorRect460.col = Color.MAGENTA;
		buildings2ChangeColorRect461.col = Color.MAGENTA;
		buildings2ChangeColorRect462.col = Color.MAGENTA;
		buildings2ChangeColorRect463.col = Color.MAGENTA;
		buildings2ChangeColorRect464.col = Color.MAGENTA;
		buildings2ChangeColorRect465.col = Color.MAGENTA;
		buildings2ChangeColorRect466.col = Color.MAGENTA;
		buildings2ChangeColorRect467.col = Color.MAGENTA;
		buildings2ChangeColorRect468.col = Color.MAGENTA;
		buildings2ChangeColorRect469.col = Color.MAGENTA;
		buildings2ChangeColorRect470.col = Color.MAGENTA;
		buildings2ChangeColorRect471.col = Color.MAGENTA;
		buildings2ChangeColorRect472.col = Color.MAGENTA;
		buildings2ChangeColorRect473.col = Color.MAGENTA;
		buildings2ChangeColorRect474.col = Color.MAGENTA;
		buildings2ChangeColorRect475.col = Color.MAGENTA;
		buildings2ChangeColorRect476.col = Color.MAGENTA;
		buildings2ChangeColorRect477.col = Color.MAGENTA;
		buildings2ChangeColorRect478.col = Color.MAGENTA;
		buildings2ChangeColorRect479.col = Color.MAGENTA;
		buildings2ChangeColorRect480.col = Color.MAGENTA;
		buildings2ChangeColorRect481.col = Color.MAGENTA;
		buildings2ChangeColorRect482.col = Color.MAGENTA;
		buildings2ChangeColorRect483.col = Color.MAGENTA;
		buildings2ChangeColorRect484.col = Color.MAGENTA;
		buildings2ChangeColorRect485.col = Color.MAGENTA;
		buildings2ChangeColorRect486.col = Color.MAGENTA;
		buildings2ChangeColorRect487.col = Color.MAGENTA;
		buildings2ChangeColorRect488.col = Color.MAGENTA;
		buildings2ChangeColorRect489.col = Color.MAGENTA;
		buildings2ChangeColorRect490.col = Color.MAGENTA;
		buildings2ChangeColorRect491.col = Color.MAGENTA;
		buildings2ChangeColorRect492.col = Color.MAGENTA;
		buildings2ChangeColorRect493.col = Color.MAGENTA;
		buildings2ChangeColorRect494.col = Color.MAGENTA;
		buildings2ChangeColorRect495.col = Color.MAGENTA;
		buildings2ChangeColorRect496.col = Color.MAGENTA;
		buildings2ChangeColorRect497.col = Color.MAGENTA;
		buildings2ChangeColorRect498.col = Color.MAGENTA;
		buildings2ChangeColorRect499.col = Color.MAGENTA;
		buildings2ChangeColorRect500.col = Color.MAGENTA;
		buildings2ChangeColorRect501.col = Color.MAGENTA;
		buildings2ChangeColorRect502.col = Color.MAGENTA;
		buildings2ChangeColorRect503.col = Color.MAGENTA;
		buildings2ChangeColorRect504.col = Color.MAGENTA;
		buildings2ChangeColorRect505.col = Color.MAGENTA;
		buildings2ChangeColorRect506.col = Color.MAGENTA;
		buildings2ChangeColorRect507.col = Color.MAGENTA;
		buildings2ChangeColorRect508.col = Color.MAGENTA;
		buildings2ChangeColorRect509.col = Color.MAGENTA;
		buildings2ChangeColorRect510.col = Color.MAGENTA;
		buildings2ChangeColorRect511.col = Color.MAGENTA;
		buildings2ChangeColorRect512.col = Color.MAGENTA;
		buildings2ChangeColorRect513.col = Color.MAGENTA;
		buildings2ChangeColorRect514.col = Color.MAGENTA;
		buildings2ChangeColorRect515.col = Color.MAGENTA;
		buildings2ChangeColorRect516.col = Color.MAGENTA;
		buildings2ChangeColorRect517.col = Color.MAGENTA;
		buildings2ChangeColorRect518.col = Color.MAGENTA;
		buildings2ChangeColorRect519.col = Color.MAGENTA;
		buildings2ChangeColorRect520.col = Color.MAGENTA;
		buildings2ChangeColorRect521.col = Color.MAGENTA;

		
		rects.add(buildings2ChangeColorRect1);
		rects.add(buildings2ChangeColorRect2);
		rects.add(buildings2ChangeColorRect3);
		rects.add(buildings2ChangeColorRect4);
		rects.add(buildings2ChangeColorRect5);
		rects.add(buildings2ChangeColorRect6);
		rects.add(buildings2ChangeColorRect7);
		rects.add(buildings2ChangeColorRect8);
		rects.add(buildings2ChangeColorRect9);
		rects.add(buildings2ChangeColorRect10);
		rects.add(buildings2ChangeColorRect11);
		rects.add(buildings2ChangeColorRect12);
		rects.add(buildings2ChangeColorRect13);
		rects.add(buildings2ChangeColorRect14);
		rects.add(buildings2ChangeColorRect15);
		rects.add(buildings2ChangeColorRect16);
		rects.add(buildings2ChangeColorRect17);
		rects.add(buildings2ChangeColorRect18);
		rects.add(buildings2ChangeColorRect19);
		rects.add(buildings2ChangeColorRect20);
		rects.add(buildings2ChangeColorRect21);
		rects.add(buildings2ChangeColorRect22);
		rects.add(buildings2ChangeColorRect23);
		rects.add(buildings2ChangeColorRect24);
		rects.add(buildings2ChangeColorRect25);
		rects.add(buildings2ChangeColorRect26);
		rects.add(buildings2ChangeColorRect27);
		rects.add(buildings2ChangeColorRect28);
		rects.add(buildings2ChangeColorRect29);
		rects.add(buildings2ChangeColorRect30);
		rects.add(buildings2ChangeColorRect31);
		rects.add(buildings2ChangeColorRect32);
		rects.add(buildings2ChangeColorRect33);
		rects.add(buildings2ChangeColorRect34);
		rects.add(buildings2ChangeColorRect35);
		rects.add(buildings2ChangeColorRect36);
		rects.add(buildings2ChangeColorRect37);
		rects.add(buildings2ChangeColorRect38);
		rects.add(buildings2ChangeColorRect39);
		rects.add(buildings2ChangeColorRect40);
		rects.add(buildings2ChangeColorRect41);
		rects.add(buildings2ChangeColorRect42);
		rects.add(buildings2ChangeColorRect43);
		rects.add(buildings2ChangeColorRect44);
		rects.add(buildings2ChangeColorRect45);
		rects.add(buildings2ChangeColorRect46);
		rects.add(buildings2ChangeColorRect47);
		rects.add(buildings2ChangeColorRect48);
		rects.add(buildings2ChangeColorRect49);
		rects.add(buildings2ChangeColorRect50);
		rects.add(buildings2ChangeColorRect51);
		rects.add(buildings2ChangeColorRect52);
		rects.add(buildings2ChangeColorRect53);
		rects.add(buildings2ChangeColorRect53a);
		rects.add(buildings2ChangeColorRect54);
		rects.add(buildings2ChangeColorRect55);
		rects.add(buildings2ChangeColorRect56);
		rects.add(buildings2ChangeColorRect57);
		rects.add(buildings2ChangeColorRect58);
		rects.add(buildings2ChangeColorRect59);
		rects.add(buildings2ChangeColorRect60);
		rects.add(buildings2ChangeColorRect61);
		rects.add(buildings2ChangeColorRect62);
		rects.add(buildings2ChangeColorRect63);
		rects.add(buildings2ChangeColorRect64);
		rects.add(buildings2ChangeColorRect65);
		rects.add(buildings2ChangeColorRect66);
		rects.add(buildings2ChangeColorRect67);
		rects.add(buildings2ChangeColorRect68);
		rects.add(buildings2ChangeColorRect69);
		rects.add(buildings2ChangeColorRect70);
		rects.add(buildings2ChangeColorRect71);
		rects.add(buildings2ChangeColorRect72);
		rects.add(buildings2ChangeColorRect73);
		rects.add(buildings2ChangeColorRect74);
		rects.add(buildings2ChangeColorRect75);
		rects.add(buildings2ChangeColorRect76);
		rects.add(buildings2ChangeColorRect77);
		rects.add(buildings2ChangeColorRect78);
		rects.add(buildings2ChangeColorRect79);
		rects.add(buildings2ChangeColorRect80);
		rects.add(buildings2ChangeColorRect81);
		rects.add(buildings2ChangeColorRect82);
		rects.add(buildings2ChangeColorRect83);
		rects.add(buildings2ChangeColorRect84);
		rects.add(buildings2ChangeColorRect85);
		rects.add(buildings2ChangeColorRect86);
		rects.add(buildings2ChangeColorRect87);
		rects.add(buildings2ChangeColorRect88);
		rects.add(buildings2ChangeColorRect89);
		rects.add(buildings2ChangeColorRect90);
		rects.add(buildings2ChangeColorRect91);
		rects.add(buildings2ChangeColorRect92);
		rects.add(buildings2ChangeColorRect93);
		rects.add(buildings2ChangeColorRect94);
		rects.add(buildings2ChangeColorRect95);
		rects.add(buildings2ChangeColorRect96);
		rects.add(buildings2ChangeColorRect97);
		rects.add(buildings2ChangeColorRect98);
		rects.add(buildings2ChangeColorRect99);
		rects.add(buildings2ChangeColorRect100);
		rects.add(buildings2ChangeColorRect101);
		rects.add(buildings2ChangeColorRect102);
		rects.add(buildings2ChangeColorRect103);
		rects.add(buildings2ChangeColorRect104);
		rects.add(buildings2ChangeColorRect105);
		rects.add(buildings2ChangeColorRect106);
		rects.add(buildings2ChangeColorRect107);
		rects.add(buildings2ChangeColorRect108);
		rects.add(buildings2ChangeColorRect109);
		rects.add(buildings2ChangeColorRect110);
		rects.add(buildings2ChangeColorRect111);
		rects.add(buildings2ChangeColorRect112);
		rects.add(buildings2ChangeColorRect113);
		rects.add(buildings2ChangeColorRect114);
		rects.add(buildings2ChangeColorRect115);
		rects.add(buildings2ChangeColorRect116);
		rects.add(buildings2ChangeColorRect117);
		rects.add(buildings2ChangeColorRect118);
		rects.add(buildings2ChangeColorRect119);
		rects.add(buildings2ChangeColorRect120);
		rects.add(buildings2ChangeColorRect121);
		rects.add(buildings2ChangeColorRect122);
		rects.add(buildings2ChangeColorRect123);
		rects.add(buildings2ChangeColorRect124);
		rects.add(buildings2ChangeColorRect125);
		rects.add(buildings2ChangeColorRect126);
		rects.add(buildings2ChangeColorRect127);
		rects.add(buildings2ChangeColorRect128);
		rects.add(buildings2ChangeColorRect129);
		rects.add(buildings2ChangeColorRect130);
		rects.add(buildings2ChangeColorRect131);
		rects.add(buildings2ChangeColorRect132);
		rects.add(buildings2ChangeColorRect133);
		rects.add(buildings2ChangeColorRect134);
		rects.add(buildings2ChangeColorRect135);
		rects.add(buildings2ChangeColorRect136);
		rects.add(buildings2ChangeColorRect137);
		rects.add(buildings2ChangeColorRect138);
		rects.add(buildings2ChangeColorRect139);
		rects.add(buildings2ChangeColorRect140);
		rects.add(buildings2ChangeColorRect141);
		rects.add(buildings2ChangeColorRect142);
		rects.add(buildings2ChangeColorRect143);
		rects.add(buildings2ChangeColorRect144);
		rects.add(buildings2ChangeColorRect145);
		rects.add(buildings2ChangeColorRect146);
		rects.add(buildings2ChangeColorRect147);
		rects.add(buildings2ChangeColorRect148);
		rects.add(buildings2ChangeColorRect149);
		rects.add(buildings2ChangeColorRect150);
		rects.add(buildings2ChangeColorRect151);
		rects.add(buildings2ChangeColorRect152);
		rects.add(buildings2ChangeColorRect153);
		rects.add(buildings2ChangeColorRect154);
		rects.add(buildings2ChangeColorRect155);
		rects.add(buildings2ChangeColorRect156);
		rects.add(buildings2ChangeColorRect157);
		rects.add(buildings2ChangeColorRect158);
		rects.add(buildings2ChangeColorRect159);
		rects.add(buildings2ChangeColorRect160);
		rects.add(buildings2ChangeColorRect161);
		rects.add(buildings2ChangeColorRect162);
		rects.add(buildings2ChangeColorRect163);
		rects.add(buildings2ChangeColorRect164);
		rects.add(buildings2ChangeColorRect165);
		rects.add(buildings2ChangeColorRect166);
		rects.add(buildings2ChangeColorRect167);
		rects.add(buildings2ChangeColorRect168);
		rects.add(buildings2ChangeColorRect169);
		rects.add(buildings2ChangeColorRect170);
		rects.add(buildings2ChangeColorRect171);
		rects.add(buildings2ChangeColorRect172);
		rects.add(buildings2ChangeColorRect173);
		rects.add(buildings2ChangeColorRect174);
		rects.add(buildings2ChangeColorRect175);
		rects.add(buildings2ChangeColorRect176);
		rects.add(buildings2ChangeColorRect177);
		rects.add(buildings2ChangeColorRect178);
		rects.add(buildings2ChangeColorRect179);
		rects.add(buildings2ChangeColorRect180);
		rects.add(buildings2ChangeColorRect181);
		rects.add(buildings2ChangeColorRect182);
		rects.add(buildings2ChangeColorRect183);
		rects.add(buildings2ChangeColorRect184);
		rects.add(buildings2ChangeColorRect185);
		rects.add(buildings2ChangeColorRect186);
		rects.add(buildings2ChangeColorRect187);
		rects.add(buildings2ChangeColorRect188);
		rects.add(buildings2ChangeColorRect189);
		rects.add(buildings2ChangeColorRect190);
		rects.add(buildings2ChangeColorRect191);
		rects.add(buildings2ChangeColorRect192);
		rects.add(buildings2ChangeColorRect193);
		rects.add(buildings2ChangeColorRect194);
		rects.add(buildings2ChangeColorRect195);
		rects.add(buildings2ChangeColorRect196);
		rects.add(buildings2ChangeColorRect197);
		rects.add(buildings2ChangeColorRect198);
		rects.add(buildings2ChangeColorRect199);
		rects.add(buildings2ChangeColorRect200);
		rects.add(buildings2ChangeColorRect201);
		rects.add(buildings2ChangeColorRect202);
		rects.add(buildings2ChangeColorRect203);
		rects.add(buildings2ChangeColorRect204);
		rects.add(buildings2ChangeColorRect205);
		rects.add(buildings2ChangeColorRect206);
		rects.add(buildings2ChangeColorRect207);
		rects.add(buildings2ChangeColorRect208);
		rects.add(buildings2ChangeColorRect209);
		rects.add(buildings2ChangeColorRect210);
		rects.add(buildings2ChangeColorRect211);
		rects.add(buildings2ChangeColorRect212);
		rects.add(buildings2ChangeColorRect213);
		rects.add(buildings2ChangeColorRect214);
		rects.add(buildings2ChangeColorRect215);
		rects.add(buildings2ChangeColorRect216);
		rects.add(buildings2ChangeColorRect217);
		rects.add(buildings2ChangeColorRect218);
		rects.add(buildings2ChangeColorRect219);
		rects.add(buildings2ChangeColorRect220);
		rects.add(buildings2ChangeColorRect221);
		rects.add(buildings2ChangeColorRect222);
		rects.add(buildings2ChangeColorRect223);
		rects.add(buildings2ChangeColorRect224);
		rects.add(buildings2ChangeColorRect225);
		rects.add(buildings2ChangeColorRect226);
		rects.add(buildings2ChangeColorRect227);
		rects.add(buildings2ChangeColorRect228);
		rects.add(buildings2ChangeColorRect229);
		rects.add(buildings2ChangeColorRect230);
		rects.add(buildings2ChangeColorRect231);
		rects.add(buildings2ChangeColorRect232);
		rects.add(buildings2ChangeColorRect233);
		rects.add(buildings2ChangeColorRect234);
		rects.add(buildings2ChangeColorRect235);
		rects.add(buildings2ChangeColorRect236);
		rects.add(buildings2ChangeColorRect237);
		rects.add(buildings2ChangeColorRect238);
		rects.add(buildings2ChangeColorRect239);
		rects.add(buildings2ChangeColorRect240);
		rects.add(buildings2ChangeColorRect241);
		rects.add(buildings2ChangeColorRect242);
		rects.add(buildings2ChangeColorRect243);
		rects.add(buildings2ChangeColorRect244);
		rects.add(buildings2ChangeColorRect245);
		rects.add(buildings2ChangeColorRect246);
		rects.add(buildings2ChangeColorRect247);
		rects.add(buildings2ChangeColorRect248);
		rects.add(buildings2ChangeColorRect249);
		rects.add(buildings2ChangeColorRect250);
		rects.add(buildings2ChangeColorRect251);
		rects.add(buildings2ChangeColorRect252);
		rects.add(buildings2ChangeColorRect253);
		rects.add(buildings2ChangeColorRect254);
		rects.add(buildings2ChangeColorRect255);
		rects.add(buildings2ChangeColorRect256);
		rects.add(buildings2ChangeColorRect257);
		rects.add(buildings2ChangeColorRect258);
		rects.add(buildings2ChangeColorRect259);
		rects.add(buildings2ChangeColorRect260);
		rects.add(buildings2ChangeColorRect261);
		rects.add(buildings2ChangeColorRect262);
		rects.add(buildings2ChangeColorRect263);
		rects.add(buildings2ChangeColorRect264);
		rects.add(buildings2ChangeColorRect265);
		rects.add(buildings2ChangeColorRect266);
		rects.add(buildings2ChangeColorRect267);
		rects.add(buildings2ChangeColorRect268);
		rects.add(buildings2ChangeColorRect269);
		rects.add(buildings2ChangeColorRect270);
		rects.add(buildings2ChangeColorRect271);
		rects.add(buildings2ChangeColorRect272);
		rects.add(buildings2ChangeColorRect273);
		rects.add(buildings2ChangeColorRect274);
		rects.add(buildings2ChangeColorRect275);
		rects.add(buildings2ChangeColorRect276);
		rects.add(buildings2ChangeColorRect277);
		rects.add(buildings2ChangeColorRect278);
		rects.add(buildings2ChangeColorRect279);
		rects.add(buildings2ChangeColorRect280);
		rects.add(buildings2ChangeColorRect281);
		rects.add(buildings2ChangeColorRect282);
		rects.add(buildings2ChangeColorRect283);
		rects.add(buildings2ChangeColorRect284);
		rects.add(buildings2ChangeColorRect285);
		rects.add(buildings2ChangeColorRect286);
		rects.add(buildings2ChangeColorRect287);
		rects.add(buildings2ChangeColorRect288);
		rects.add(buildings2ChangeColorRect289);
		rects.add(buildings2ChangeColorRect290);
		rects.add(buildings2ChangeColorRect291);
		rects.add(buildings2ChangeColorRect292);
		rects.add(buildings2ChangeColorRect293);
		rects.add(buildings2ChangeColorRect294);
		rects.add(buildings2ChangeColorRect295);
		rects.add(buildings2ChangeColorRect296);
		rects.add(buildings2ChangeColorRect297);
		rects.add(buildings2ChangeColorRect298);
		rects.add(buildings2ChangeColorRect299);
		rects.add(buildings2ChangeColorRect300);
		rects.add(buildings2ChangeColorRect301);
		rects.add(buildings2ChangeColorRect302);
		rects.add(buildings2ChangeColorRect303);
		rects.add(buildings2ChangeColorRect304);
		rects.add(buildings2ChangeColorRect305);
		rects.add(buildings2ChangeColorRect306);
		rects.add(buildings2ChangeColorRect307);
		rects.add(buildings2ChangeColorRect308);
		rects.add(buildings2ChangeColorRect309);
		rects.add(buildings2ChangeColorRect310);
		rects.add(buildings2ChangeColorRect311);
		rects.add(buildings2ChangeColorRect312);
		rects.add(buildings2ChangeColorRect313);
		rects.add(buildings2ChangeColorRect314);
		rects.add(buildings2ChangeColorRect315);
		rects.add(buildings2ChangeColorRect316);
		rects.add(buildings2ChangeColorRect317);
		rects.add(buildings2ChangeColorRect318);
		rects.add(buildings2ChangeColorRect319);
		rects.add(buildings2ChangeColorRect320);
		rects.add(buildings2ChangeColorRect321);
		rects.add(buildings2ChangeColorRect322);
		rects.add(buildings2ChangeColorRect323);
		rects.add(buildings2ChangeColorRect324);
		rects.add(buildings2ChangeColorRect325);
		rects.add(buildings2ChangeColorRect326);
		rects.add(buildings2ChangeColorRect327);
		rects.add(buildings2ChangeColorRect328);
		rects.add(buildings2ChangeColorRect329);
		rects.add(buildings2ChangeColorRect330);
		rects.add(buildings2ChangeColorRect331);
		rects.add(buildings2ChangeColorRect332);
		rects.add(buildings2ChangeColorRect333);
		rects.add(buildings2ChangeColorRect334);
		rects.add(buildings2ChangeColorRect335);
		rects.add(buildings2ChangeColorRect336);
		rects.add(buildings2ChangeColorRect337);
		rects.add(buildings2ChangeColorRect338);
		rects.add(buildings2ChangeColorRect339);
		rects.add(buildings2ChangeColorRect340);
		rects.add(buildings2ChangeColorRect341);
		rects.add(buildings2ChangeColorRect342);
		rects.add(buildings2ChangeColorRect343);
		rects.add(buildings2ChangeColorRect344);
		rects.add(buildings2ChangeColorRect345);
		rects.add(buildings2ChangeColorRect346);
		rects.add(buildings2ChangeColorRect347);
		rects.add(buildings2ChangeColorRect348);
		rects.add(buildings2ChangeColorRect349);
		rects.add(buildings2ChangeColorRect350);
		rects.add(buildings2ChangeColorRect351);
		rects.add(buildings2ChangeColorRect352);
		rects.add(buildings2ChangeColorRect353);
		rects.add(buildings2ChangeColorRect354);
		rects.add(buildings2ChangeColorRect355);
		rects.add(buildings2ChangeColorRect356);
		rects.add(buildings2ChangeColorRect357);
		rects.add(buildings2ChangeColorRect358);
		rects.add(buildings2ChangeColorRect359);
		rects.add(buildings2ChangeColorRect360);
		rects.add(buildings2ChangeColorRect361);
		rects.add(buildings2ChangeColorRect362);
		rects.add(buildings2ChangeColorRect363);
		rects.add(buildings2ChangeColorRect364);
		rects.add(buildings2ChangeColorRect365);
		rects.add(buildings2ChangeColorRect366);
		rects.add(buildings2ChangeColorRect367);
		rects.add(buildings2ChangeColorRect368);
		rects.add(buildings2ChangeColorRect369);
		rects.add(buildings2ChangeColorRect370);
		rects.add(buildings2ChangeColorRect371);
		rects.add(buildings2ChangeColorRect372);
		rects.add(buildings2ChangeColorRect373);
		rects.add(buildings2ChangeColorRect374);
		rects.add(buildings2ChangeColorRect375);
		rects.add(buildings2ChangeColorRect376);
		rects.add(buildings2ChangeColorRect377);
		rects.add(buildings2ChangeColorRect378);
		rects.add(buildings2ChangeColorRect379);
		rects.add(buildings2ChangeColorRect380);
		rects.add(buildings2ChangeColorRect381);
		rects.add(buildings2ChangeColorRect382);
		rects.add(buildings2ChangeColorRect383);
		rects.add(buildings2ChangeColorRect384);
		rects.add(buildings2ChangeColorRect385);
		rects.add(buildings2ChangeColorRect386);
		rects.add(buildings2ChangeColorRect387);
		rects.add(buildings2ChangeColorRect388);
		rects.add(buildings2ChangeColorRect389);
		rects.add(buildings2ChangeColorRect390);
		rects.add(buildings2ChangeColorRect391);
		rects.add(buildings2ChangeColorRect392);
		rects.add(buildings2ChangeColorRect393);
		rects.add(buildings2ChangeColorRect394);
		rects.add(buildings2ChangeColorRect395);
		rects.add(buildings2ChangeColorRect396);
		rects.add(buildings2ChangeColorRect397);
		rects.add(buildings2ChangeColorRect398);
		rects.add(buildings2ChangeColorRect399);
		rects.add(buildings2ChangeColorRect400);
		rects.add(buildings2ChangeColorRect401);
		rects.add(buildings2ChangeColorRect402);
		rects.add(buildings2ChangeColorRect403);
		rects.add(buildings2ChangeColorRect404);
		rects.add(buildings2ChangeColorRect405);
		rects.add(buildings2ChangeColorRect406);
		rects.add(buildings2ChangeColorRect407);
		rects.add(buildings2ChangeColorRect408);
		rects.add(buildings2ChangeColorRect409);
		rects.add(buildings2ChangeColorRect410);
		rects.add(buildings2ChangeColorRect411);
		rects.add(buildings2ChangeColorRect412);
		rects.add(buildings2ChangeColorRect413);
		rects.add(buildings2ChangeColorRect414);
		rects.add(buildings2ChangeColorRect415);
		rects.add(buildings2ChangeColorRect416);
		rects.add(buildings2ChangeColorRect417);
		rects.add(buildings2ChangeColorRect418);
		rects.add(buildings2ChangeColorRect419);
		rects.add(buildings2ChangeColorRect420);
		rects.add(buildings2ChangeColorRect421);
		rects.add(buildings2ChangeColorRect422);
		rects.add(buildings2ChangeColorRect423);
		rects.add(buildings2ChangeColorRect424);
		rects.add(buildings2ChangeColorRect425);
		rects.add(buildings2ChangeColorRect426);
		rects.add(buildings2ChangeColorRect427);
		rects.add(buildings2ChangeColorRect428);
		rects.add(buildings2ChangeColorRect429);
		rects.add(buildings2ChangeColorRect430);
		rects.add(buildings2ChangeColorRect431);
		rects.add(buildings2ChangeColorRect432);
		rects.add(buildings2ChangeColorRect433);
		rects.add(buildings2ChangeColorRect434);
		rects.add(buildings2ChangeColorRect435);
		rects.add(buildings2ChangeColorRect436);
		rects.add(buildings2ChangeColorRect437);
		rects.add(buildings2ChangeColorRect438);
		rects.add(buildings2ChangeColorRect439);
		rects.add(buildings2ChangeColorRect440);
		rects.add(buildings2ChangeColorRect441);
		rects.add(buildings2ChangeColorRect442);
		rects.add(buildings2ChangeColorRect443);
		rects.add(buildings2ChangeColorRect444);
		rects.add(buildings2ChangeColorRect445);
		rects.add(buildings2ChangeColorRect446);
		rects.add(buildings2ChangeColorRect447);
		rects.add(buildings2ChangeColorRect448);
		rects.add(buildings2ChangeColorRect449);
		rects.add(buildings2ChangeColorRect450);
		rects.add(buildings2ChangeColorRect451);
		rects.add(buildings2ChangeColorRect452);
		rects.add(buildings2ChangeColorRect453);
		rects.add(buildings2ChangeColorRect454);
		rects.add(buildings2ChangeColorRect455);
		rects.add(buildings2ChangeColorRect456);
		rects.add(buildings2ChangeColorRect457);
		rects.add(buildings2ChangeColorRect458);
		rects.add(buildings2ChangeColorRect459);
		rects.add(buildings2ChangeColorRect460);
		rects.add(buildings2ChangeColorRect461);
		rects.add(buildings2ChangeColorRect462);
		rects.add(buildings2ChangeColorRect463);
		rects.add(buildings2ChangeColorRect464);
		rects.add(buildings2ChangeColorRect465);
		rects.add(buildings2ChangeColorRect466);
		rects.add(buildings2ChangeColorRect467);
		rects.add(buildings2ChangeColorRect468);
		rects.add(buildings2ChangeColorRect469);
		rects.add(buildings2ChangeColorRect470);
		rects.add(buildings2ChangeColorRect471);
		rects.add(buildings2ChangeColorRect472);
		rects.add(buildings2ChangeColorRect473);
		rects.add(buildings2ChangeColorRect474);
		rects.add(buildings2ChangeColorRect475);
		rects.add(buildings2ChangeColorRect476);
		rects.add(buildings2ChangeColorRect477);
		rects.add(buildings2ChangeColorRect478);
		rects.add(buildings2ChangeColorRect479);
		rects.add(buildings2ChangeColorRect480);
		rects.add(buildings2ChangeColorRect481);
		rects.add(buildings2ChangeColorRect482);
		rects.add(buildings2ChangeColorRect483);
		rects.add(buildings2ChangeColorRect484);
		rects.add(buildings2ChangeColorRect485);
		rects.add(buildings2ChangeColorRect486);
		rects.add(buildings2ChangeColorRect487);
		rects.add(buildings2ChangeColorRect488);
		rects.add(buildings2ChangeColorRect489);
		rects.add(buildings2ChangeColorRect490);
		rects.add(buildings2ChangeColorRect491);
		rects.add(buildings2ChangeColorRect492);
		rects.add(buildings2ChangeColorRect493);
		rects.add(buildings2ChangeColorRect494);
		rects.add(buildings2ChangeColorRect495);
		rects.add(buildings2ChangeColorRect496);
		rects.add(buildings2ChangeColorRect497);
		rects.add(buildings2ChangeColorRect498);
		rects.add(buildings2ChangeColorRect499);
		rects.add(buildings2ChangeColorRect500);
		rects.add(buildings2ChangeColorRect501);
		rects.add(buildings2ChangeColorRect502);
		rects.add(buildings2ChangeColorRect503);
		rects.add(buildings2ChangeColorRect504);
		rects.add(buildings2ChangeColorRect505);
		rects.add(buildings2ChangeColorRect506);
		rects.add(buildings2ChangeColorRect507);
		rects.add(buildings2ChangeColorRect508);
		rects.add(buildings2ChangeColorRect509);
		rects.add(buildings2ChangeColorRect510);
		rects.add(buildings2ChangeColorRect511);
		rects.add(buildings2ChangeColorRect512);
		rects.add(buildings2ChangeColorRect513);
		rects.add(buildings2ChangeColorRect514);
		rects.add(buildings2ChangeColorRect515);
		rects.add(buildings2ChangeColorRect516);
		rects.add(buildings2ChangeColorRect517);
		rects.add(buildings2ChangeColorRect518);
		rects.add(buildings2ChangeColorRect519);
		rects.add(buildings2ChangeColorRect520);
		rects.add(buildings2ChangeColorRect521);

		
		endingBlockSwitch+=1;
		}else if(endingBlockSwitch>=10 && endingBlockSwitch<20) {
			buildings2ChangeColorRect1.col = Color.PINK;
			buildings2ChangeColorRect2.col = Color.PINK;
			buildings2ChangeColorRect3.col = Color.PINK;
			buildings2ChangeColorRect4.col = Color.PINK;
			buildings2ChangeColorRect5.col = Color.PINK;
			buildings2ChangeColorRect6.col = Color.PINK;
			buildings2ChangeColorRect7.col = Color.PINK;
			buildings2ChangeColorRect8.col = Color.PINK;
			buildings2ChangeColorRect9.col = Color.PINK;
			buildings2ChangeColorRect10.col = Color.PINK;
			buildings2ChangeColorRect11.col = Color.PINK;
			buildings2ChangeColorRect12.col = Color.PINK;
			buildings2ChangeColorRect13.col = Color.PINK;
			buildings2ChangeColorRect14.col = Color.PINK;
			buildings2ChangeColorRect15.col = Color.PINK;
			buildings2ChangeColorRect16.col = Color.PINK;
			buildings2ChangeColorRect17.col = Color.PINK;
			buildings2ChangeColorRect18.col = Color.PINK;
			buildings2ChangeColorRect19.col = Color.PINK;
			buildings2ChangeColorRect20.col = Color.PINK;
			buildings2ChangeColorRect21.col = Color.PINK;
			buildings2ChangeColorRect22.col = Color.PINK;
			buildings2ChangeColorRect23.col = Color.PINK;
			buildings2ChangeColorRect24.col = Color.PINK;
			buildings2ChangeColorRect25.col = Color.PINK;
			buildings2ChangeColorRect26.col = Color.PINK;
			buildings2ChangeColorRect27.col = Color.PINK;
			buildings2ChangeColorRect28.col = Color.PINK;
			buildings2ChangeColorRect29.col = Color.PINK;
			buildings2ChangeColorRect30.col = Color.PINK;
			buildings2ChangeColorRect31.col = Color.PINK;
			buildings2ChangeColorRect32.col = Color.PINK;
			buildings2ChangeColorRect33.col = Color.PINK;
			buildings2ChangeColorRect34.col = Color.PINK;
			buildings2ChangeColorRect35.col = Color.PINK;
			buildings2ChangeColorRect36.col = Color.PINK;
			buildings2ChangeColorRect37.col = Color.PINK;
			buildings2ChangeColorRect38.col = Color.PINK;
			buildings2ChangeColorRect39.col = Color.PINK;
			buildings2ChangeColorRect40.col = Color.PINK;
			buildings2ChangeColorRect41.col = Color.PINK;
			buildings2ChangeColorRect42.col = Color.PINK;
			buildings2ChangeColorRect43.col = Color.PINK;
			buildings2ChangeColorRect44.col = Color.PINK;
			buildings2ChangeColorRect45.col = Color.PINK;
			buildings2ChangeColorRect46.col = Color.PINK;
			buildings2ChangeColorRect47.col = Color.PINK;
			buildings2ChangeColorRect48.col = Color.PINK;
			buildings2ChangeColorRect49.col = Color.PINK;
			buildings2ChangeColorRect50.col = Color.PINK;
			buildings2ChangeColorRect51.col = Color.PINK;
			buildings2ChangeColorRect52.col = Color.PINK;
			buildings2ChangeColorRect53.col = Color.PINK;
			buildings2ChangeColorRect53a.col = Color.PINK;
			buildings2ChangeColorRect54.col = Color.PINK;
			buildings2ChangeColorRect55.col = Color.PINK;
			buildings2ChangeColorRect56.col = Color.PINK;
			buildings2ChangeColorRect57.col = Color.PINK;
			buildings2ChangeColorRect58.col = Color.PINK;
			buildings2ChangeColorRect59.col = Color.PINK;
			buildings2ChangeColorRect60.col = Color.PINK;
			buildings2ChangeColorRect61.col = Color.PINK;
			buildings2ChangeColorRect62.col = Color.PINK;
			buildings2ChangeColorRect63.col = Color.PINK;
			buildings2ChangeColorRect64.col = Color.PINK;
			buildings2ChangeColorRect65.col = Color.PINK;
			buildings2ChangeColorRect66.col = Color.PINK;
			buildings2ChangeColorRect67.col = Color.PINK;
			buildings2ChangeColorRect68.col = Color.PINK;
			buildings2ChangeColorRect69.col = Color.PINK;
			buildings2ChangeColorRect70.col = Color.PINK;
			buildings2ChangeColorRect71.col = Color.PINK;
			buildings2ChangeColorRect72.col = Color.PINK;
			buildings2ChangeColorRect73.col = Color.PINK;
			buildings2ChangeColorRect74.col = Color.PINK;
			buildings2ChangeColorRect75.col = Color.PINK;
			buildings2ChangeColorRect76.col = Color.PINK;
			buildings2ChangeColorRect77.col = Color.PINK;
			buildings2ChangeColorRect78.col = Color.PINK;
			buildings2ChangeColorRect79.col = Color.PINK;
			buildings2ChangeColorRect80.col = Color.PINK;
			buildings2ChangeColorRect81.col = Color.PINK;
			buildings2ChangeColorRect82.col = Color.PINK;
			buildings2ChangeColorRect83.col = Color.PINK;
			buildings2ChangeColorRect84.col = Color.PINK;
			buildings2ChangeColorRect85.col = Color.PINK;
			buildings2ChangeColorRect86.col = Color.PINK;
			buildings2ChangeColorRect87.col = Color.PINK;
			buildings2ChangeColorRect88.col = Color.PINK;
			buildings2ChangeColorRect89.col = Color.PINK;
			buildings2ChangeColorRect90.col = Color.PINK;
			buildings2ChangeColorRect91.col = Color.PINK;
			buildings2ChangeColorRect92.col = Color.PINK;
			buildings2ChangeColorRect93.col = Color.PINK;
			buildings2ChangeColorRect94.col = Color.PINK;
			buildings2ChangeColorRect95.col = Color.PINK;
			buildings2ChangeColorRect96.col = Color.PINK;
			buildings2ChangeColorRect97.col = Color.PINK;
			buildings2ChangeColorRect98.col = Color.PINK;
			buildings2ChangeColorRect99.col = Color.PINK;
			buildings2ChangeColorRect100.col = Color.PINK;
			buildings2ChangeColorRect101.col = Color.PINK;
			buildings2ChangeColorRect102.col = Color.PINK;
			buildings2ChangeColorRect103.col = Color.PINK;
			buildings2ChangeColorRect104.col = Color.PINK;
			buildings2ChangeColorRect105.col = Color.PINK;
			buildings2ChangeColorRect106.col = Color.PINK;
			buildings2ChangeColorRect107.col = Color.PINK;
			buildings2ChangeColorRect108.col = Color.PINK;
			buildings2ChangeColorRect109.col = Color.PINK;
			buildings2ChangeColorRect110.col = Color.PINK;
			buildings2ChangeColorRect111.col = Color.PINK;
			buildings2ChangeColorRect112.col = Color.PINK;
			buildings2ChangeColorRect113.col = Color.PINK;
			buildings2ChangeColorRect114.col = Color.PINK;
			buildings2ChangeColorRect115.col = Color.PINK;
			buildings2ChangeColorRect116.col = Color.PINK;
			buildings2ChangeColorRect117.col = Color.PINK;
			buildings2ChangeColorRect118.col = Color.PINK;
			buildings2ChangeColorRect119.col = Color.PINK;
			buildings2ChangeColorRect120.col = Color.PINK;
			buildings2ChangeColorRect121.col = Color.PINK;
			buildings2ChangeColorRect122.col = Color.PINK;
			buildings2ChangeColorRect123.col = Color.PINK;
			buildings2ChangeColorRect124.col = Color.PINK;
			buildings2ChangeColorRect125.col = Color.PINK;
			buildings2ChangeColorRect126.col = Color.PINK;
			buildings2ChangeColorRect127.col = Color.PINK;
			buildings2ChangeColorRect128.col = Color.PINK;
			buildings2ChangeColorRect129.col = Color.PINK;
			buildings2ChangeColorRect130.col = Color.PINK;
			buildings2ChangeColorRect131.col = Color.PINK;
			buildings2ChangeColorRect132.col = Color.PINK;
			buildings2ChangeColorRect133.col = Color.PINK;
			buildings2ChangeColorRect134.col = Color.PINK;
			buildings2ChangeColorRect135.col = Color.PINK;
			buildings2ChangeColorRect136.col = Color.PINK;
			buildings2ChangeColorRect137.col = Color.PINK;
			buildings2ChangeColorRect138.col = Color.PINK;
			buildings2ChangeColorRect139.col = Color.PINK;
			buildings2ChangeColorRect140.col = Color.PINK;
			buildings2ChangeColorRect141.col = Color.PINK;
			buildings2ChangeColorRect142.col = Color.PINK;
			buildings2ChangeColorRect143.col = Color.PINK;
			buildings2ChangeColorRect144.col = Color.PINK;
			buildings2ChangeColorRect145.col = Color.PINK;
			buildings2ChangeColorRect146.col = Color.PINK;
			buildings2ChangeColorRect147.col = Color.PINK;
			buildings2ChangeColorRect148.col = Color.PINK;
			buildings2ChangeColorRect149.col = Color.PINK;
			buildings2ChangeColorRect150.col = Color.PINK;
			buildings2ChangeColorRect151.col = Color.PINK;
			buildings2ChangeColorRect152.col = Color.PINK;
			buildings2ChangeColorRect153.col = Color.PINK;
			buildings2ChangeColorRect154.col = Color.PINK;
			buildings2ChangeColorRect155.col = Color.PINK;
			buildings2ChangeColorRect156.col = Color.PINK;
			buildings2ChangeColorRect157.col = Color.PINK;
			buildings2ChangeColorRect158.col = Color.PINK;
			buildings2ChangeColorRect159.col = Color.PINK;
			buildings2ChangeColorRect160.col = Color.PINK;
			buildings2ChangeColorRect161.col = Color.PINK;
			buildings2ChangeColorRect162.col = Color.PINK;
			buildings2ChangeColorRect163.col = Color.PINK;
			buildings2ChangeColorRect164.col = Color.PINK;
			buildings2ChangeColorRect165.col = Color.PINK;
			buildings2ChangeColorRect166.col = Color.PINK;
			buildings2ChangeColorRect167.col = Color.PINK;
			buildings2ChangeColorRect168.col = Color.PINK;
			buildings2ChangeColorRect169.col = Color.PINK;
			buildings2ChangeColorRect170.col = Color.PINK;
			buildings2ChangeColorRect171.col = Color.PINK;
			buildings2ChangeColorRect172.col = Color.PINK;
			buildings2ChangeColorRect173.col = Color.PINK;
			buildings2ChangeColorRect174.col = Color.PINK;
			buildings2ChangeColorRect175.col = Color.PINK;
			buildings2ChangeColorRect176.col = Color.PINK;
			buildings2ChangeColorRect177.col = Color.PINK;
			buildings2ChangeColorRect178.col = Color.PINK;
			buildings2ChangeColorRect179.col = Color.PINK;
			buildings2ChangeColorRect180.col = Color.PINK;
			buildings2ChangeColorRect181.col = Color.PINK;
			buildings2ChangeColorRect182.col = Color.PINK;
			buildings2ChangeColorRect183.col = Color.PINK;
			buildings2ChangeColorRect184.col = Color.PINK;
			buildings2ChangeColorRect185.col = Color.PINK;
			buildings2ChangeColorRect186.col = Color.PINK;
			buildings2ChangeColorRect187.col = Color.PINK;
			buildings2ChangeColorRect188.col = Color.PINK;
			buildings2ChangeColorRect189.col = Color.PINK;
			buildings2ChangeColorRect190.col = Color.PINK;
			buildings2ChangeColorRect191.col = Color.PINK;
			buildings2ChangeColorRect192.col = Color.PINK;
			buildings2ChangeColorRect193.col = Color.PINK;
			buildings2ChangeColorRect194.col = Color.PINK;
			buildings2ChangeColorRect195.col = Color.PINK;
			buildings2ChangeColorRect196.col = Color.PINK;
			buildings2ChangeColorRect197.col = Color.PINK;
			buildings2ChangeColorRect198.col = Color.PINK;
			buildings2ChangeColorRect199.col = Color.PINK;
			buildings2ChangeColorRect200.col = Color.PINK;
			buildings2ChangeColorRect201.col = Color.PINK;
			buildings2ChangeColorRect202.col = Color.PINK;
			buildings2ChangeColorRect203.col = Color.PINK;
			buildings2ChangeColorRect204.col = Color.PINK;
			buildings2ChangeColorRect205.col = Color.PINK;
			buildings2ChangeColorRect206.col = Color.PINK;
			buildings2ChangeColorRect207.col = Color.PINK;
			buildings2ChangeColorRect208.col = Color.PINK;
			buildings2ChangeColorRect209.col = Color.PINK;
			buildings2ChangeColorRect210.col = Color.PINK;
			buildings2ChangeColorRect211.col = Color.PINK;
			buildings2ChangeColorRect212.col = Color.PINK;
			buildings2ChangeColorRect213.col = Color.PINK;
			buildings2ChangeColorRect214.col = Color.PINK;
			buildings2ChangeColorRect215.col = Color.PINK;
			buildings2ChangeColorRect216.col = Color.PINK;
			buildings2ChangeColorRect217.col = Color.PINK;
			buildings2ChangeColorRect218.col = Color.PINK;
			buildings2ChangeColorRect219.col = Color.PINK;
			buildings2ChangeColorRect220.col = Color.PINK;
			buildings2ChangeColorRect221.col = Color.PINK;
			buildings2ChangeColorRect222.col = Color.PINK;
			buildings2ChangeColorRect223.col = Color.PINK;
			buildings2ChangeColorRect224.col = Color.PINK;
			buildings2ChangeColorRect225.col = Color.PINK;
			buildings2ChangeColorRect226.col = Color.PINK;
			buildings2ChangeColorRect227.col = Color.PINK;
			buildings2ChangeColorRect228.col = Color.PINK;
			buildings2ChangeColorRect229.col = Color.PINK;
			buildings2ChangeColorRect230.col = Color.PINK;
			buildings2ChangeColorRect231.col = Color.PINK;
			buildings2ChangeColorRect232.col = Color.PINK;
			buildings2ChangeColorRect233.col = Color.PINK;
			buildings2ChangeColorRect234.col = Color.PINK;
			buildings2ChangeColorRect235.col = Color.PINK;
			buildings2ChangeColorRect236.col = Color.PINK;
			buildings2ChangeColorRect237.col = Color.PINK;
			buildings2ChangeColorRect238.col = Color.PINK;
			buildings2ChangeColorRect239.col = Color.PINK;
			buildings2ChangeColorRect240.col = Color.PINK;
			buildings2ChangeColorRect241.col = Color.PINK;
			buildings2ChangeColorRect242.col = Color.PINK;
			buildings2ChangeColorRect243.col = Color.PINK;
			buildings2ChangeColorRect244.col = Color.PINK;
			buildings2ChangeColorRect245.col = Color.PINK;
			buildings2ChangeColorRect246.col = Color.PINK;
			buildings2ChangeColorRect247.col = Color.PINK;
			buildings2ChangeColorRect248.col = Color.PINK;
			buildings2ChangeColorRect249.col = Color.PINK;
			buildings2ChangeColorRect250.col = Color.PINK;
			buildings2ChangeColorRect251.col = Color.PINK;
			buildings2ChangeColorRect252.col = Color.PINK;
			buildings2ChangeColorRect253.col = Color.PINK;
			buildings2ChangeColorRect254.col = Color.PINK;
			buildings2ChangeColorRect255.col = Color.PINK;
			buildings2ChangeColorRect256.col = Color.PINK;
			buildings2ChangeColorRect257.col = Color.PINK;
			buildings2ChangeColorRect258.col = Color.PINK;
			buildings2ChangeColorRect259.col = Color.PINK;
			buildings2ChangeColorRect260.col = Color.PINK;
			buildings2ChangeColorRect261.col = Color.PINK;
			buildings2ChangeColorRect262.col = Color.PINK;
			buildings2ChangeColorRect263.col = Color.PINK;
			buildings2ChangeColorRect264.col = Color.PINK;
			buildings2ChangeColorRect265.col = Color.PINK;
			buildings2ChangeColorRect266.col = Color.PINK;
			buildings2ChangeColorRect267.col = Color.PINK;
			buildings2ChangeColorRect268.col = Color.PINK;
			buildings2ChangeColorRect269.col = Color.PINK;
			buildings2ChangeColorRect270.col = Color.PINK;
			buildings2ChangeColorRect271.col = Color.PINK;
			buildings2ChangeColorRect272.col = Color.PINK;
			buildings2ChangeColorRect273.col = Color.PINK;
			buildings2ChangeColorRect274.col = Color.PINK;
			buildings2ChangeColorRect275.col = Color.PINK;
			buildings2ChangeColorRect276.col = Color.PINK;
			buildings2ChangeColorRect277.col = Color.PINK;
			buildings2ChangeColorRect278.col = Color.PINK;
			buildings2ChangeColorRect279.col = Color.PINK;
			buildings2ChangeColorRect280.col = Color.PINK;
			buildings2ChangeColorRect281.col = Color.PINK;
			buildings2ChangeColorRect282.col = Color.PINK;
			buildings2ChangeColorRect283.col = Color.PINK;
			buildings2ChangeColorRect284.col = Color.PINK;
			buildings2ChangeColorRect285.col = Color.PINK;
			buildings2ChangeColorRect286.col = Color.PINK;
			buildings2ChangeColorRect287.col = Color.PINK;
			buildings2ChangeColorRect288.col = Color.PINK;
			buildings2ChangeColorRect289.col = Color.PINK;
			buildings2ChangeColorRect290.col = Color.PINK;
			buildings2ChangeColorRect291.col = Color.PINK;
			buildings2ChangeColorRect292.col = Color.PINK;
			buildings2ChangeColorRect293.col = Color.PINK;
			buildings2ChangeColorRect294.col = Color.PINK;
			buildings2ChangeColorRect295.col = Color.PINK;
			buildings2ChangeColorRect296.col = Color.PINK;
			buildings2ChangeColorRect297.col = Color.PINK;
			buildings2ChangeColorRect298.col = Color.PINK;
			buildings2ChangeColorRect299.col = Color.PINK;
			buildings2ChangeColorRect300.col = Color.PINK;
			buildings2ChangeColorRect301.col = Color.PINK;
			buildings2ChangeColorRect302.col = Color.PINK;
			buildings2ChangeColorRect303.col = Color.PINK;
			buildings2ChangeColorRect304.col = Color.PINK;
			buildings2ChangeColorRect305.col = Color.PINK;
			buildings2ChangeColorRect306.col = Color.PINK;
			buildings2ChangeColorRect307.col = Color.PINK;
			buildings2ChangeColorRect308.col = Color.PINK;
			buildings2ChangeColorRect309.col = Color.PINK;
			buildings2ChangeColorRect310.col = Color.PINK;
			buildings2ChangeColorRect311.col = Color.PINK;
			buildings2ChangeColorRect312.col = Color.PINK;
			buildings2ChangeColorRect313.col = Color.PINK;
			buildings2ChangeColorRect314.col = Color.PINK;
			buildings2ChangeColorRect315.col = Color.PINK;
			buildings2ChangeColorRect316.col = Color.PINK;
			buildings2ChangeColorRect317.col = Color.PINK;
			buildings2ChangeColorRect318.col = Color.PINK;
			buildings2ChangeColorRect319.col = Color.PINK;
			buildings2ChangeColorRect320.col = Color.PINK;
			buildings2ChangeColorRect321.col = Color.PINK;
			buildings2ChangeColorRect322.col = Color.PINK;
			buildings2ChangeColorRect323.col = Color.PINK;
			buildings2ChangeColorRect324.col = Color.PINK;
			buildings2ChangeColorRect325.col = Color.PINK;
			buildings2ChangeColorRect326.col = Color.PINK;
			buildings2ChangeColorRect327.col = Color.PINK;
			buildings2ChangeColorRect328.col = Color.PINK;
			buildings2ChangeColorRect329.col = Color.PINK;
			buildings2ChangeColorRect330.col = Color.PINK;
			buildings2ChangeColorRect331.col = Color.PINK;
			buildings2ChangeColorRect332.col = Color.PINK;
			buildings2ChangeColorRect333.col = Color.PINK;
			buildings2ChangeColorRect334.col = Color.PINK;
			buildings2ChangeColorRect335.col = Color.PINK;
			buildings2ChangeColorRect336.col = Color.PINK;
			buildings2ChangeColorRect337.col = Color.PINK;
			buildings2ChangeColorRect338.col = Color.PINK;
			buildings2ChangeColorRect339.col = Color.PINK;
			buildings2ChangeColorRect340.col = Color.PINK;
			buildings2ChangeColorRect341.col = Color.PINK;
			buildings2ChangeColorRect342.col = Color.PINK;
			buildings2ChangeColorRect343.col = Color.PINK;
			buildings2ChangeColorRect344.col = Color.PINK;
			buildings2ChangeColorRect345.col = Color.PINK;
			buildings2ChangeColorRect346.col = Color.PINK;
			buildings2ChangeColorRect347.col = Color.PINK;
			buildings2ChangeColorRect348.col = Color.PINK;
			buildings2ChangeColorRect349.col = Color.PINK;
			buildings2ChangeColorRect350.col = Color.PINK;
			buildings2ChangeColorRect351.col = Color.PINK;
			buildings2ChangeColorRect352.col = Color.PINK;
			buildings2ChangeColorRect353.col = Color.PINK;
			buildings2ChangeColorRect354.col = Color.PINK;
			buildings2ChangeColorRect355.col = Color.PINK;
			buildings2ChangeColorRect356.col = Color.PINK;
			buildings2ChangeColorRect357.col = Color.PINK;
			buildings2ChangeColorRect358.col = Color.PINK;
			buildings2ChangeColorRect359.col = Color.PINK;
			buildings2ChangeColorRect360.col = Color.PINK;
			buildings2ChangeColorRect361.col = Color.PINK;
			buildings2ChangeColorRect362.col = Color.PINK;
			buildings2ChangeColorRect363.col = Color.PINK;
			buildings2ChangeColorRect364.col = Color.PINK;
			buildings2ChangeColorRect365.col = Color.PINK;
			buildings2ChangeColorRect366.col = Color.PINK;
			buildings2ChangeColorRect367.col = Color.PINK;
			buildings2ChangeColorRect368.col = Color.PINK;
			buildings2ChangeColorRect369.col = Color.PINK;
			buildings2ChangeColorRect370.col = Color.PINK;
			buildings2ChangeColorRect371.col = Color.PINK;
			buildings2ChangeColorRect372.col = Color.PINK;
			buildings2ChangeColorRect373.col = Color.PINK;
			buildings2ChangeColorRect374.col = Color.PINK;
			buildings2ChangeColorRect375.col = Color.PINK;
			buildings2ChangeColorRect376.col = Color.PINK;
			buildings2ChangeColorRect377.col = Color.PINK;
			buildings2ChangeColorRect378.col = Color.PINK;
			buildings2ChangeColorRect379.col = Color.PINK;
			buildings2ChangeColorRect380.col = Color.PINK;
			buildings2ChangeColorRect381.col = Color.PINK;
			buildings2ChangeColorRect382.col = Color.PINK;
			buildings2ChangeColorRect383.col = Color.PINK;
			buildings2ChangeColorRect384.col = Color.PINK;
			buildings2ChangeColorRect385.col = Color.PINK;
			buildings2ChangeColorRect386.col = Color.PINK;
			buildings2ChangeColorRect387.col = Color.PINK;
			buildings2ChangeColorRect388.col = Color.PINK;
			buildings2ChangeColorRect389.col = Color.PINK;
			buildings2ChangeColorRect390.col = Color.PINK;
			buildings2ChangeColorRect391.col = Color.PINK;
			buildings2ChangeColorRect392.col = Color.PINK;
			buildings2ChangeColorRect393.col = Color.PINK;
			buildings2ChangeColorRect394.col = Color.PINK;
			buildings2ChangeColorRect395.col = Color.PINK;
			buildings2ChangeColorRect396.col = Color.PINK;
			buildings2ChangeColorRect397.col = Color.PINK;
			buildings2ChangeColorRect398.col = Color.PINK;
			buildings2ChangeColorRect399.col = Color.PINK;
			buildings2ChangeColorRect400.col = Color.PINK;
			buildings2ChangeColorRect401.col = Color.PINK;
			buildings2ChangeColorRect402.col = Color.PINK;
			buildings2ChangeColorRect403.col = Color.PINK;
			buildings2ChangeColorRect404.col = Color.PINK;
			buildings2ChangeColorRect405.col = Color.PINK;
			buildings2ChangeColorRect406.col = Color.PINK;
			buildings2ChangeColorRect407.col = Color.PINK;
			buildings2ChangeColorRect408.col = Color.PINK;
			buildings2ChangeColorRect409.col = Color.PINK;
			buildings2ChangeColorRect410.col = Color.PINK;
			buildings2ChangeColorRect411.col = Color.PINK;
			buildings2ChangeColorRect412.col = Color.PINK;
			buildings2ChangeColorRect413.col = Color.PINK;
			buildings2ChangeColorRect414.col = Color.PINK;
			buildings2ChangeColorRect415.col = Color.PINK;
			buildings2ChangeColorRect416.col = Color.PINK;
			buildings2ChangeColorRect417.col = Color.PINK;
			buildings2ChangeColorRect418.col = Color.PINK;
			buildings2ChangeColorRect419.col = Color.PINK;
			buildings2ChangeColorRect420.col = Color.PINK;
			buildings2ChangeColorRect421.col = Color.PINK;
			buildings2ChangeColorRect422.col = Color.PINK;
			buildings2ChangeColorRect423.col = Color.PINK;
			buildings2ChangeColorRect424.col = Color.PINK;
			buildings2ChangeColorRect425.col = Color.PINK;
			buildings2ChangeColorRect426.col = Color.PINK;
			buildings2ChangeColorRect427.col = Color.PINK;
			buildings2ChangeColorRect428.col = Color.PINK;
			buildings2ChangeColorRect429.col = Color.PINK;
			buildings2ChangeColorRect430.col = Color.PINK;
			buildings2ChangeColorRect431.col = Color.PINK;
			buildings2ChangeColorRect432.col = Color.PINK;
			buildings2ChangeColorRect433.col = Color.PINK;
			buildings2ChangeColorRect434.col = Color.PINK;
			buildings2ChangeColorRect435.col = Color.PINK;
			buildings2ChangeColorRect436.col = Color.PINK;
			buildings2ChangeColorRect437.col = Color.PINK;
			buildings2ChangeColorRect438.col = Color.PINK;
			buildings2ChangeColorRect439.col = Color.PINK;
			buildings2ChangeColorRect440.col = Color.PINK;
			buildings2ChangeColorRect441.col = Color.PINK;
			buildings2ChangeColorRect442.col = Color.PINK;
			buildings2ChangeColorRect443.col = Color.PINK;
			buildings2ChangeColorRect444.col = Color.PINK;
			buildings2ChangeColorRect445.col = Color.PINK;
			buildings2ChangeColorRect446.col = Color.PINK;
			buildings2ChangeColorRect447.col = Color.PINK;
			buildings2ChangeColorRect448.col = Color.PINK;
			buildings2ChangeColorRect449.col = Color.PINK;
			buildings2ChangeColorRect450.col = Color.PINK;
			buildings2ChangeColorRect451.col = Color.PINK;
			buildings2ChangeColorRect452.col = Color.PINK;
			buildings2ChangeColorRect453.col = Color.PINK;
			buildings2ChangeColorRect454.col = Color.PINK;
			buildings2ChangeColorRect455.col = Color.PINK;
			buildings2ChangeColorRect456.col = Color.PINK;
			buildings2ChangeColorRect457.col = Color.PINK;
			buildings2ChangeColorRect458.col = Color.PINK;
			buildings2ChangeColorRect459.col = Color.PINK;
			buildings2ChangeColorRect460.col = Color.PINK;
			buildings2ChangeColorRect461.col = Color.PINK;
			buildings2ChangeColorRect462.col = Color.PINK;
			buildings2ChangeColorRect463.col = Color.PINK;
			buildings2ChangeColorRect464.col = Color.PINK;
			buildings2ChangeColorRect465.col = Color.PINK;
			buildings2ChangeColorRect466.col = Color.PINK;
			buildings2ChangeColorRect467.col = Color.PINK;
			buildings2ChangeColorRect468.col = Color.PINK;
			buildings2ChangeColorRect469.col = Color.PINK;
			buildings2ChangeColorRect470.col = Color.PINK;
			buildings2ChangeColorRect471.col = Color.PINK;
			buildings2ChangeColorRect472.col = Color.PINK;
			buildings2ChangeColorRect473.col = Color.PINK;
			buildings2ChangeColorRect474.col = Color.PINK;
			buildings2ChangeColorRect475.col = Color.PINK;
			buildings2ChangeColorRect476.col = Color.PINK;
			buildings2ChangeColorRect477.col = Color.PINK;
			buildings2ChangeColorRect478.col = Color.PINK;
			buildings2ChangeColorRect479.col = Color.PINK;
			buildings2ChangeColorRect480.col = Color.PINK;
			buildings2ChangeColorRect481.col = Color.PINK;
			buildings2ChangeColorRect482.col = Color.PINK;
			buildings2ChangeColorRect483.col = Color.PINK;
			buildings2ChangeColorRect484.col = Color.PINK;
			buildings2ChangeColorRect485.col = Color.PINK;
			buildings2ChangeColorRect486.col = Color.PINK;
			buildings2ChangeColorRect487.col = Color.PINK;
			buildings2ChangeColorRect488.col = Color.PINK;
			buildings2ChangeColorRect489.col = Color.PINK;
			buildings2ChangeColorRect490.col = Color.PINK;
			buildings2ChangeColorRect491.col = Color.PINK;
			buildings2ChangeColorRect492.col = Color.PINK;
			buildings2ChangeColorRect493.col = Color.PINK;
			buildings2ChangeColorRect494.col = Color.PINK;
			buildings2ChangeColorRect495.col = Color.PINK;
			buildings2ChangeColorRect496.col = Color.PINK;
			buildings2ChangeColorRect497.col = Color.PINK;
			buildings2ChangeColorRect498.col = Color.PINK;
			buildings2ChangeColorRect499.col = Color.PINK;
			buildings2ChangeColorRect500.col = Color.PINK;
			buildings2ChangeColorRect501.col = Color.PINK;
			buildings2ChangeColorRect502.col = Color.PINK;
			buildings2ChangeColorRect503.col = Color.PINK;
			buildings2ChangeColorRect504.col = Color.PINK;
			buildings2ChangeColorRect505.col = Color.PINK;
			buildings2ChangeColorRect506.col = Color.PINK;
			buildings2ChangeColorRect507.col = Color.PINK;
			buildings2ChangeColorRect508.col = Color.PINK;
			buildings2ChangeColorRect509.col = Color.PINK;
			buildings2ChangeColorRect510.col = Color.PINK;
			buildings2ChangeColorRect511.col = Color.PINK;
			buildings2ChangeColorRect512.col = Color.PINK;
			buildings2ChangeColorRect513.col = Color.PINK;
			buildings2ChangeColorRect514.col = Color.PINK;
			buildings2ChangeColorRect515.col = Color.PINK;
			buildings2ChangeColorRect516.col = Color.PINK;
			buildings2ChangeColorRect517.col = Color.PINK;
			buildings2ChangeColorRect518.col = Color.PINK;
			buildings2ChangeColorRect519.col = Color.PINK;
			buildings2ChangeColorRect520.col = Color.PINK;
			buildings2ChangeColorRect521.col = Color.PINK;

			
		rects.add(buildings2ChangeColorRect1);
		rects.add(buildings2ChangeColorRect2);
		rects.add(buildings2ChangeColorRect3);
		rects.add(buildings2ChangeColorRect4);
		rects.add(buildings2ChangeColorRect5);
		rects.add(buildings2ChangeColorRect6);
		rects.add(buildings2ChangeColorRect7);
		rects.add(buildings2ChangeColorRect8);
		rects.add(buildings2ChangeColorRect9);
		rects.add(buildings2ChangeColorRect10);
		rects.add(buildings2ChangeColorRect11);
		rects.add(buildings2ChangeColorRect12);
		rects.add(buildings2ChangeColorRect13);
		rects.add(buildings2ChangeColorRect14);
		rects.add(buildings2ChangeColorRect15);
		rects.add(buildings2ChangeColorRect16);
		rects.add(buildings2ChangeColorRect17);
		rects.add(buildings2ChangeColorRect18);
		rects.add(buildings2ChangeColorRect19);
		rects.add(buildings2ChangeColorRect20);
		rects.add(buildings2ChangeColorRect21);
		rects.add(buildings2ChangeColorRect22);
		rects.add(buildings2ChangeColorRect23);
		rects.add(buildings2ChangeColorRect24);
		rects.add(buildings2ChangeColorRect25);
		rects.add(buildings2ChangeColorRect26);
		rects.add(buildings2ChangeColorRect27);
		rects.add(buildings2ChangeColorRect28);
		rects.add(buildings2ChangeColorRect29);
		rects.add(buildings2ChangeColorRect30);
		rects.add(buildings2ChangeColorRect31);
		rects.add(buildings2ChangeColorRect32);
		rects.add(buildings2ChangeColorRect33);
		rects.add(buildings2ChangeColorRect34);
		rects.add(buildings2ChangeColorRect35);
		rects.add(buildings2ChangeColorRect36);
		rects.add(buildings2ChangeColorRect37);
		rects.add(buildings2ChangeColorRect38);
		rects.add(buildings2ChangeColorRect39);
		rects.add(buildings2ChangeColorRect40);
		rects.add(buildings2ChangeColorRect41);
		rects.add(buildings2ChangeColorRect42);
		rects.add(buildings2ChangeColorRect43);
		rects.add(buildings2ChangeColorRect44);
		rects.add(buildings2ChangeColorRect45);
		rects.add(buildings2ChangeColorRect46);
		rects.add(buildings2ChangeColorRect47);
		rects.add(buildings2ChangeColorRect48);
		rects.add(buildings2ChangeColorRect49);
		rects.add(buildings2ChangeColorRect50);
		rects.add(buildings2ChangeColorRect51);
		rects.add(buildings2ChangeColorRect52);
		rects.add(buildings2ChangeColorRect53);
		rects.add(buildings2ChangeColorRect53a);
		rects.add(buildings2ChangeColorRect54);
		rects.add(buildings2ChangeColorRect55);
		rects.add(buildings2ChangeColorRect56);
		rects.add(buildings2ChangeColorRect57);
		rects.add(buildings2ChangeColorRect58);
		rects.add(buildings2ChangeColorRect59);
		rects.add(buildings2ChangeColorRect60);
		rects.add(buildings2ChangeColorRect61);
		rects.add(buildings2ChangeColorRect62);
		rects.add(buildings2ChangeColorRect63);
		rects.add(buildings2ChangeColorRect64);
		rects.add(buildings2ChangeColorRect65);
		rects.add(buildings2ChangeColorRect66);
		rects.add(buildings2ChangeColorRect67);
		rects.add(buildings2ChangeColorRect68);
		rects.add(buildings2ChangeColorRect69);
		rects.add(buildings2ChangeColorRect70);
		rects.add(buildings2ChangeColorRect71);
		rects.add(buildings2ChangeColorRect72);
		rects.add(buildings2ChangeColorRect73);
		rects.add(buildings2ChangeColorRect74);
		rects.add(buildings2ChangeColorRect75);
		rects.add(buildings2ChangeColorRect76);
		rects.add(buildings2ChangeColorRect77);
		rects.add(buildings2ChangeColorRect78);
		rects.add(buildings2ChangeColorRect79);
		rects.add(buildings2ChangeColorRect80);
		rects.add(buildings2ChangeColorRect81);
		rects.add(buildings2ChangeColorRect82);
		rects.add(buildings2ChangeColorRect83);
		rects.add(buildings2ChangeColorRect84);
		rects.add(buildings2ChangeColorRect85);
		rects.add(buildings2ChangeColorRect86);
		rects.add(buildings2ChangeColorRect87);
		rects.add(buildings2ChangeColorRect88);
		rects.add(buildings2ChangeColorRect89);
		rects.add(buildings2ChangeColorRect90);
		rects.add(buildings2ChangeColorRect91);
		rects.add(buildings2ChangeColorRect92);
		rects.add(buildings2ChangeColorRect93);
		rects.add(buildings2ChangeColorRect94);
		rects.add(buildings2ChangeColorRect95);
		rects.add(buildings2ChangeColorRect96);
		rects.add(buildings2ChangeColorRect97);
		rects.add(buildings2ChangeColorRect98);
		rects.add(buildings2ChangeColorRect99);
		rects.add(buildings2ChangeColorRect100);
		rects.add(buildings2ChangeColorRect101);
		rects.add(buildings2ChangeColorRect102);
		rects.add(buildings2ChangeColorRect103);
		rects.add(buildings2ChangeColorRect104);
		rects.add(buildings2ChangeColorRect105);
		rects.add(buildings2ChangeColorRect106);
		rects.add(buildings2ChangeColorRect107);
		rects.add(buildings2ChangeColorRect108);
		rects.add(buildings2ChangeColorRect109);
		rects.add(buildings2ChangeColorRect110);
		rects.add(buildings2ChangeColorRect111);
		rects.add(buildings2ChangeColorRect112);
		rects.add(buildings2ChangeColorRect113);
		rects.add(buildings2ChangeColorRect114);
		rects.add(buildings2ChangeColorRect115);
		rects.add(buildings2ChangeColorRect116);
		rects.add(buildings2ChangeColorRect117);
		rects.add(buildings2ChangeColorRect118);
		rects.add(buildings2ChangeColorRect119);
		rects.add(buildings2ChangeColorRect120);
		rects.add(buildings2ChangeColorRect121);
		rects.add(buildings2ChangeColorRect122);
		rects.add(buildings2ChangeColorRect123);
		rects.add(buildings2ChangeColorRect124);
		rects.add(buildings2ChangeColorRect125);
		rects.add(buildings2ChangeColorRect126);
		rects.add(buildings2ChangeColorRect127);
		rects.add(buildings2ChangeColorRect128);
		rects.add(buildings2ChangeColorRect129);
		rects.add(buildings2ChangeColorRect130);
		rects.add(buildings2ChangeColorRect131);
		rects.add(buildings2ChangeColorRect132);
		rects.add(buildings2ChangeColorRect133);
		rects.add(buildings2ChangeColorRect134);
		rects.add(buildings2ChangeColorRect135);
		rects.add(buildings2ChangeColorRect136);
		rects.add(buildings2ChangeColorRect137);
		rects.add(buildings2ChangeColorRect138);
		rects.add(buildings2ChangeColorRect139);
		rects.add(buildings2ChangeColorRect140);
		rects.add(buildings2ChangeColorRect141);
		rects.add(buildings2ChangeColorRect142);
		rects.add(buildings2ChangeColorRect143);
		rects.add(buildings2ChangeColorRect144);
		rects.add(buildings2ChangeColorRect145);
		rects.add(buildings2ChangeColorRect146);
		rects.add(buildings2ChangeColorRect147);
		rects.add(buildings2ChangeColorRect148);
		rects.add(buildings2ChangeColorRect149);
		rects.add(buildings2ChangeColorRect150);
		rects.add(buildings2ChangeColorRect151);
		rects.add(buildings2ChangeColorRect152);
		rects.add(buildings2ChangeColorRect153);
		rects.add(buildings2ChangeColorRect154);
		rects.add(buildings2ChangeColorRect155);
		rects.add(buildings2ChangeColorRect156);
		rects.add(buildings2ChangeColorRect157);
		rects.add(buildings2ChangeColorRect158);
		rects.add(buildings2ChangeColorRect159);
		rects.add(buildings2ChangeColorRect160);
		rects.add(buildings2ChangeColorRect161);
		rects.add(buildings2ChangeColorRect162);
		rects.add(buildings2ChangeColorRect163);
		rects.add(buildings2ChangeColorRect164);
		rects.add(buildings2ChangeColorRect165);
		rects.add(buildings2ChangeColorRect166);
		rects.add(buildings2ChangeColorRect167);
		rects.add(buildings2ChangeColorRect168);
		rects.add(buildings2ChangeColorRect169);
		rects.add(buildings2ChangeColorRect170);
		rects.add(buildings2ChangeColorRect171);
		rects.add(buildings2ChangeColorRect172);
		rects.add(buildings2ChangeColorRect173);
		rects.add(buildings2ChangeColorRect174);
		rects.add(buildings2ChangeColorRect175);
		rects.add(buildings2ChangeColorRect176);
		rects.add(buildings2ChangeColorRect177);
		rects.add(buildings2ChangeColorRect178);
		rects.add(buildings2ChangeColorRect179);
		rects.add(buildings2ChangeColorRect180);
		rects.add(buildings2ChangeColorRect181);
		rects.add(buildings2ChangeColorRect182);
		rects.add(buildings2ChangeColorRect183);
		rects.add(buildings2ChangeColorRect184);
		rects.add(buildings2ChangeColorRect185);
		rects.add(buildings2ChangeColorRect186);
		rects.add(buildings2ChangeColorRect187);
		rects.add(buildings2ChangeColorRect188);
		rects.add(buildings2ChangeColorRect189);
		rects.add(buildings2ChangeColorRect190);
		rects.add(buildings2ChangeColorRect191);
		rects.add(buildings2ChangeColorRect192);
		rects.add(buildings2ChangeColorRect193);
		rects.add(buildings2ChangeColorRect194);
		rects.add(buildings2ChangeColorRect195);
		rects.add(buildings2ChangeColorRect196);
		rects.add(buildings2ChangeColorRect197);
		rects.add(buildings2ChangeColorRect198);
		rects.add(buildings2ChangeColorRect199);
		rects.add(buildings2ChangeColorRect200);
		rects.add(buildings2ChangeColorRect201);
		rects.add(buildings2ChangeColorRect202);
		rects.add(buildings2ChangeColorRect203);
		rects.add(buildings2ChangeColorRect204);
		rects.add(buildings2ChangeColorRect205);
		rects.add(buildings2ChangeColorRect206);
		rects.add(buildings2ChangeColorRect207);
		rects.add(buildings2ChangeColorRect208);
		rects.add(buildings2ChangeColorRect209);
		rects.add(buildings2ChangeColorRect210);
		rects.add(buildings2ChangeColorRect211);
		rects.add(buildings2ChangeColorRect212);
		rects.add(buildings2ChangeColorRect213);
		rects.add(buildings2ChangeColorRect214);
		rects.add(buildings2ChangeColorRect215);
		rects.add(buildings2ChangeColorRect216);
		rects.add(buildings2ChangeColorRect217);
		rects.add(buildings2ChangeColorRect218);
		rects.add(buildings2ChangeColorRect219);
		rects.add(buildings2ChangeColorRect220);
		rects.add(buildings2ChangeColorRect221);
		rects.add(buildings2ChangeColorRect222);
		rects.add(buildings2ChangeColorRect223);
		rects.add(buildings2ChangeColorRect224);
		rects.add(buildings2ChangeColorRect225);
		rects.add(buildings2ChangeColorRect226);
		rects.add(buildings2ChangeColorRect227);
		rects.add(buildings2ChangeColorRect228);
		rects.add(buildings2ChangeColorRect229);
		rects.add(buildings2ChangeColorRect230);
		rects.add(buildings2ChangeColorRect231);
		rects.add(buildings2ChangeColorRect232);
		rects.add(buildings2ChangeColorRect233);
		rects.add(buildings2ChangeColorRect234);
		rects.add(buildings2ChangeColorRect235);
		rects.add(buildings2ChangeColorRect236);
		rects.add(buildings2ChangeColorRect237);
		rects.add(buildings2ChangeColorRect238);
		rects.add(buildings2ChangeColorRect239);
		rects.add(buildings2ChangeColorRect240);
		rects.add(buildings2ChangeColorRect241);
		rects.add(buildings2ChangeColorRect242);
		rects.add(buildings2ChangeColorRect243);
		rects.add(buildings2ChangeColorRect244);
		rects.add(buildings2ChangeColorRect245);
		rects.add(buildings2ChangeColorRect246);
		rects.add(buildings2ChangeColorRect247);
		rects.add(buildings2ChangeColorRect248);
		rects.add(buildings2ChangeColorRect249);
		rects.add(buildings2ChangeColorRect250);
		rects.add(buildings2ChangeColorRect251);
		rects.add(buildings2ChangeColorRect252);
		rects.add(buildings2ChangeColorRect253);
		rects.add(buildings2ChangeColorRect254);
		rects.add(buildings2ChangeColorRect255);
		rects.add(buildings2ChangeColorRect256);
		rects.add(buildings2ChangeColorRect257);
		rects.add(buildings2ChangeColorRect258);
		rects.add(buildings2ChangeColorRect259);
		rects.add(buildings2ChangeColorRect260);
		rects.add(buildings2ChangeColorRect261);
		rects.add(buildings2ChangeColorRect262);
		rects.add(buildings2ChangeColorRect263);
		rects.add(buildings2ChangeColorRect264);
		rects.add(buildings2ChangeColorRect265);
		rects.add(buildings2ChangeColorRect266);
		rects.add(buildings2ChangeColorRect267);
		rects.add(buildings2ChangeColorRect268);
		rects.add(buildings2ChangeColorRect269);
		rects.add(buildings2ChangeColorRect270);
		rects.add(buildings2ChangeColorRect271);
		rects.add(buildings2ChangeColorRect272);
		rects.add(buildings2ChangeColorRect273);
		rects.add(buildings2ChangeColorRect274);
		rects.add(buildings2ChangeColorRect275);
		rects.add(buildings2ChangeColorRect276);
		rects.add(buildings2ChangeColorRect277);
		rects.add(buildings2ChangeColorRect278);
		rects.add(buildings2ChangeColorRect279);
		rects.add(buildings2ChangeColorRect280);
		rects.add(buildings2ChangeColorRect281);
		rects.add(buildings2ChangeColorRect282);
		rects.add(buildings2ChangeColorRect283);
		rects.add(buildings2ChangeColorRect284);
		rects.add(buildings2ChangeColorRect285);
		rects.add(buildings2ChangeColorRect286);
		rects.add(buildings2ChangeColorRect287);
		rects.add(buildings2ChangeColorRect288);
		rects.add(buildings2ChangeColorRect289);
		rects.add(buildings2ChangeColorRect290);
		rects.add(buildings2ChangeColorRect291);
		rects.add(buildings2ChangeColorRect292);
		rects.add(buildings2ChangeColorRect293);
		rects.add(buildings2ChangeColorRect294);
		rects.add(buildings2ChangeColorRect295);
		rects.add(buildings2ChangeColorRect296);
		rects.add(buildings2ChangeColorRect297);
		rects.add(buildings2ChangeColorRect298);
		rects.add(buildings2ChangeColorRect299);
		rects.add(buildings2ChangeColorRect300);
		rects.add(buildings2ChangeColorRect301);
		rects.add(buildings2ChangeColorRect302);
		rects.add(buildings2ChangeColorRect303);
		rects.add(buildings2ChangeColorRect304);
		rects.add(buildings2ChangeColorRect305);
		rects.add(buildings2ChangeColorRect306);
		rects.add(buildings2ChangeColorRect307);
		rects.add(buildings2ChangeColorRect308);
		rects.add(buildings2ChangeColorRect309);
		rects.add(buildings2ChangeColorRect310);
		rects.add(buildings2ChangeColorRect311);
		rects.add(buildings2ChangeColorRect312);
		rects.add(buildings2ChangeColorRect313);
		rects.add(buildings2ChangeColorRect314);
		rects.add(buildings2ChangeColorRect315);
		rects.add(buildings2ChangeColorRect316);
		rects.add(buildings2ChangeColorRect317);
		rects.add(buildings2ChangeColorRect318);
		rects.add(buildings2ChangeColorRect319);
		rects.add(buildings2ChangeColorRect320);
		rects.add(buildings2ChangeColorRect321);
		rects.add(buildings2ChangeColorRect322);
		rects.add(buildings2ChangeColorRect323);
		rects.add(buildings2ChangeColorRect324);
		rects.add(buildings2ChangeColorRect325);
		rects.add(buildings2ChangeColorRect326);
		rects.add(buildings2ChangeColorRect327);
		rects.add(buildings2ChangeColorRect328);
		rects.add(buildings2ChangeColorRect329);
		rects.add(buildings2ChangeColorRect330);
		rects.add(buildings2ChangeColorRect331);
		rects.add(buildings2ChangeColorRect332);
		rects.add(buildings2ChangeColorRect333);
		rects.add(buildings2ChangeColorRect334);
		rects.add(buildings2ChangeColorRect335);
		rects.add(buildings2ChangeColorRect336);
		rects.add(buildings2ChangeColorRect337);
		rects.add(buildings2ChangeColorRect338);
		rects.add(buildings2ChangeColorRect339);
		rects.add(buildings2ChangeColorRect340);
		rects.add(buildings2ChangeColorRect341);
		rects.add(buildings2ChangeColorRect342);
		rects.add(buildings2ChangeColorRect343);
		rects.add(buildings2ChangeColorRect344);
		rects.add(buildings2ChangeColorRect345);
		rects.add(buildings2ChangeColorRect346);
		rects.add(buildings2ChangeColorRect347);
		rects.add(buildings2ChangeColorRect348);
		rects.add(buildings2ChangeColorRect349);
		rects.add(buildings2ChangeColorRect350);
		rects.add(buildings2ChangeColorRect351);
		rects.add(buildings2ChangeColorRect352);
		rects.add(buildings2ChangeColorRect353);
		rects.add(buildings2ChangeColorRect354);
		rects.add(buildings2ChangeColorRect355);
		rects.add(buildings2ChangeColorRect356);
		rects.add(buildings2ChangeColorRect357);
		rects.add(buildings2ChangeColorRect358);
		rects.add(buildings2ChangeColorRect359);
		rects.add(buildings2ChangeColorRect360);
		rects.add(buildings2ChangeColorRect361);
		rects.add(buildings2ChangeColorRect362);
		rects.add(buildings2ChangeColorRect363);
		rects.add(buildings2ChangeColorRect364);
		rects.add(buildings2ChangeColorRect365);
		rects.add(buildings2ChangeColorRect366);
		rects.add(buildings2ChangeColorRect367);
		rects.add(buildings2ChangeColorRect368);
		rects.add(buildings2ChangeColorRect369);
		rects.add(buildings2ChangeColorRect370);
		rects.add(buildings2ChangeColorRect371);
		rects.add(buildings2ChangeColorRect372);
		rects.add(buildings2ChangeColorRect373);
		rects.add(buildings2ChangeColorRect374);
		rects.add(buildings2ChangeColorRect375);
		rects.add(buildings2ChangeColorRect376);
		rects.add(buildings2ChangeColorRect377);
		rects.add(buildings2ChangeColorRect378);
		rects.add(buildings2ChangeColorRect379);
		rects.add(buildings2ChangeColorRect380);
		rects.add(buildings2ChangeColorRect381);
		rects.add(buildings2ChangeColorRect382);
		rects.add(buildings2ChangeColorRect383);
		rects.add(buildings2ChangeColorRect384);
		rects.add(buildings2ChangeColorRect385);
		rects.add(buildings2ChangeColorRect386);
		rects.add(buildings2ChangeColorRect387);
		rects.add(buildings2ChangeColorRect388);
		rects.add(buildings2ChangeColorRect389);
		rects.add(buildings2ChangeColorRect390);
		rects.add(buildings2ChangeColorRect391);
		rects.add(buildings2ChangeColorRect392);
		rects.add(buildings2ChangeColorRect393);
		rects.add(buildings2ChangeColorRect394);
		rects.add(buildings2ChangeColorRect395);
		rects.add(buildings2ChangeColorRect396);
		rects.add(buildings2ChangeColorRect397);
		rects.add(buildings2ChangeColorRect398);
		rects.add(buildings2ChangeColorRect399);
		rects.add(buildings2ChangeColorRect400);
		rects.add(buildings2ChangeColorRect401);
		rects.add(buildings2ChangeColorRect402);
		rects.add(buildings2ChangeColorRect403);
		rects.add(buildings2ChangeColorRect404);
		rects.add(buildings2ChangeColorRect405);
		rects.add(buildings2ChangeColorRect406);
		rects.add(buildings2ChangeColorRect407);
		rects.add(buildings2ChangeColorRect408);
		rects.add(buildings2ChangeColorRect409);
		rects.add(buildings2ChangeColorRect410);
		rects.add(buildings2ChangeColorRect411);
		rects.add(buildings2ChangeColorRect412);
		rects.add(buildings2ChangeColorRect413);
		rects.add(buildings2ChangeColorRect414);
		rects.add(buildings2ChangeColorRect415);
		rects.add(buildings2ChangeColorRect416);
		rects.add(buildings2ChangeColorRect417);
		rects.add(buildings2ChangeColorRect418);
		rects.add(buildings2ChangeColorRect419);
		rects.add(buildings2ChangeColorRect420);
		rects.add(buildings2ChangeColorRect421);
		rects.add(buildings2ChangeColorRect422);
		rects.add(buildings2ChangeColorRect423);
		rects.add(buildings2ChangeColorRect424);
		rects.add(buildings2ChangeColorRect425);
		rects.add(buildings2ChangeColorRect426);
		rects.add(buildings2ChangeColorRect427);
		rects.add(buildings2ChangeColorRect428);
		rects.add(buildings2ChangeColorRect429);
		rects.add(buildings2ChangeColorRect430);
		rects.add(buildings2ChangeColorRect431);
		rects.add(buildings2ChangeColorRect432);
		rects.add(buildings2ChangeColorRect433);
		rects.add(buildings2ChangeColorRect434);
		rects.add(buildings2ChangeColorRect435);
		rects.add(buildings2ChangeColorRect436);
		rects.add(buildings2ChangeColorRect437);
		rects.add(buildings2ChangeColorRect438);
		rects.add(buildings2ChangeColorRect439);
		rects.add(buildings2ChangeColorRect440);
		rects.add(buildings2ChangeColorRect441);
		rects.add(buildings2ChangeColorRect442);
		rects.add(buildings2ChangeColorRect443);
		rects.add(buildings2ChangeColorRect444);
		rects.add(buildings2ChangeColorRect445);
		rects.add(buildings2ChangeColorRect446);
		rects.add(buildings2ChangeColorRect447);
		rects.add(buildings2ChangeColorRect448);
		rects.add(buildings2ChangeColorRect449);
		rects.add(buildings2ChangeColorRect450);
		rects.add(buildings2ChangeColorRect451);
		rects.add(buildings2ChangeColorRect452);
		rects.add(buildings2ChangeColorRect453);
		rects.add(buildings2ChangeColorRect454);
		rects.add(buildings2ChangeColorRect455);
		rects.add(buildings2ChangeColorRect456);
		rects.add(buildings2ChangeColorRect457);
		rects.add(buildings2ChangeColorRect458);
		rects.add(buildings2ChangeColorRect459);
		rects.add(buildings2ChangeColorRect460);
		rects.add(buildings2ChangeColorRect461);
		rects.add(buildings2ChangeColorRect462);
		rects.add(buildings2ChangeColorRect463);
		rects.add(buildings2ChangeColorRect464);
		rects.add(buildings2ChangeColorRect465);
		rects.add(buildings2ChangeColorRect466);
		rects.add(buildings2ChangeColorRect467);
		rects.add(buildings2ChangeColorRect468);
		rects.add(buildings2ChangeColorRect469);
		rects.add(buildings2ChangeColorRect470);
		rects.add(buildings2ChangeColorRect471);
		rects.add(buildings2ChangeColorRect472);
		rects.add(buildings2ChangeColorRect473);
		rects.add(buildings2ChangeColorRect474);
		rects.add(buildings2ChangeColorRect475);
		rects.add(buildings2ChangeColorRect476);
		rects.add(buildings2ChangeColorRect477);
		rects.add(buildings2ChangeColorRect478);
		rects.add(buildings2ChangeColorRect479);
		rects.add(buildings2ChangeColorRect480);
		rects.add(buildings2ChangeColorRect481);
		rects.add(buildings2ChangeColorRect482);
		rects.add(buildings2ChangeColorRect483);
		rects.add(buildings2ChangeColorRect484);
		rects.add(buildings2ChangeColorRect485);
		rects.add(buildings2ChangeColorRect486);
		rects.add(buildings2ChangeColorRect487);
		rects.add(buildings2ChangeColorRect488);
		rects.add(buildings2ChangeColorRect489);
		rects.add(buildings2ChangeColorRect490);
		rects.add(buildings2ChangeColorRect491);
		rects.add(buildings2ChangeColorRect492);
		rects.add(buildings2ChangeColorRect493);
		rects.add(buildings2ChangeColorRect494);
		rects.add(buildings2ChangeColorRect495);
		rects.add(buildings2ChangeColorRect496);
		rects.add(buildings2ChangeColorRect497);
		rects.add(buildings2ChangeColorRect498);
		rects.add(buildings2ChangeColorRect499);
		rects.add(buildings2ChangeColorRect500);
		rects.add(buildings2ChangeColorRect501);
		rects.add(buildings2ChangeColorRect502);
		rects.add(buildings2ChangeColorRect503);
		rects.add(buildings2ChangeColorRect504);
		rects.add(buildings2ChangeColorRect505);
		rects.add(buildings2ChangeColorRect506);
		rects.add(buildings2ChangeColorRect507);
		rects.add(buildings2ChangeColorRect508);
		rects.add(buildings2ChangeColorRect509);
		rects.add(buildings2ChangeColorRect510);
		rects.add(buildings2ChangeColorRect511);
		rects.add(buildings2ChangeColorRect512);
		rects.add(buildings2ChangeColorRect513);
		rects.add(buildings2ChangeColorRect514);
		rects.add(buildings2ChangeColorRect515);
		rects.add(buildings2ChangeColorRect516);
		rects.add(buildings2ChangeColorRect517);
		rects.add(buildings2ChangeColorRect518);
		rects.add(buildings2ChangeColorRect519);
		rects.add(buildings2ChangeColorRect520);
		rects.add(buildings2ChangeColorRect521);

		
		endingBlockSwitch+=1;
		}else if(endingBlockSwitch>=20 && endingBlockSwitch<30) {
			buildings2ChangeColorRect1.col = Color.BLUE;
			buildings2ChangeColorRect2.col = Color.BLUE;
			buildings2ChangeColorRect3.col = Color.BLUE;
			buildings2ChangeColorRect4.col = Color.BLUE;
			buildings2ChangeColorRect5.col = Color.BLUE;
			buildings2ChangeColorRect6.col = Color.BLUE;
			buildings2ChangeColorRect7.col = Color.BLUE;
			buildings2ChangeColorRect8.col = Color.BLUE;
			buildings2ChangeColorRect9.col = Color.BLUE;
			buildings2ChangeColorRect10.col = Color.BLUE;
			buildings2ChangeColorRect11.col = Color.BLUE;
			buildings2ChangeColorRect12.col = Color.BLUE;
			buildings2ChangeColorRect13.col = Color.BLUE;
			buildings2ChangeColorRect14.col = Color.BLUE;
			buildings2ChangeColorRect15.col = Color.BLUE;
			buildings2ChangeColorRect16.col = Color.BLUE;
			buildings2ChangeColorRect17.col = Color.BLUE;
			buildings2ChangeColorRect18.col = Color.BLUE;
			buildings2ChangeColorRect19.col = Color.BLUE;
			buildings2ChangeColorRect20.col = Color.BLUE;
			buildings2ChangeColorRect21.col = Color.BLUE;
			buildings2ChangeColorRect22.col = Color.BLUE;
			buildings2ChangeColorRect23.col = Color.BLUE;
			buildings2ChangeColorRect24.col = Color.BLUE;
			buildings2ChangeColorRect25.col = Color.BLUE;
			buildings2ChangeColorRect26.col = Color.BLUE;
			buildings2ChangeColorRect27.col = Color.BLUE;
			buildings2ChangeColorRect28.col = Color.BLUE;
			buildings2ChangeColorRect29.col = Color.BLUE;
			buildings2ChangeColorRect30.col = Color.BLUE;
			buildings2ChangeColorRect31.col = Color.BLUE;
			buildings2ChangeColorRect32.col = Color.BLUE;
			buildings2ChangeColorRect33.col = Color.BLUE;
			buildings2ChangeColorRect34.col = Color.BLUE;
			buildings2ChangeColorRect35.col = Color.BLUE;
			buildings2ChangeColorRect36.col = Color.BLUE;
			buildings2ChangeColorRect37.col = Color.BLUE;
			buildings2ChangeColorRect38.col = Color.BLUE;
			buildings2ChangeColorRect39.col = Color.BLUE;
			buildings2ChangeColorRect40.col = Color.BLUE;
			buildings2ChangeColorRect41.col = Color.BLUE;
			buildings2ChangeColorRect42.col = Color.BLUE;
			buildings2ChangeColorRect43.col = Color.BLUE;
			buildings2ChangeColorRect44.col = Color.BLUE;
			buildings2ChangeColorRect45.col = Color.BLUE;
			buildings2ChangeColorRect46.col = Color.BLUE;
			buildings2ChangeColorRect47.col = Color.BLUE;
			buildings2ChangeColorRect48.col = Color.BLUE;
			buildings2ChangeColorRect49.col = Color.BLUE;
			buildings2ChangeColorRect50.col = Color.BLUE;
			buildings2ChangeColorRect51.col = Color.BLUE;
			buildings2ChangeColorRect52.col = Color.BLUE;
			buildings2ChangeColorRect53.col = Color.BLUE;
			buildings2ChangeColorRect53a.col = Color.BLUE;
			buildings2ChangeColorRect54.col = Color.BLUE;
			buildings2ChangeColorRect55.col = Color.BLUE;
			buildings2ChangeColorRect56.col = Color.BLUE;
			buildings2ChangeColorRect57.col = Color.BLUE;
			buildings2ChangeColorRect58.col = Color.BLUE;
			buildings2ChangeColorRect59.col = Color.BLUE;
			buildings2ChangeColorRect60.col = Color.BLUE;
			buildings2ChangeColorRect61.col = Color.BLUE;
			buildings2ChangeColorRect62.col = Color.BLUE;
			buildings2ChangeColorRect63.col = Color.BLUE;
			buildings2ChangeColorRect64.col = Color.BLUE;
			buildings2ChangeColorRect65.col = Color.BLUE;
			buildings2ChangeColorRect66.col = Color.BLUE;
			buildings2ChangeColorRect67.col = Color.BLUE;
			buildings2ChangeColorRect68.col = Color.BLUE;
			buildings2ChangeColorRect69.col = Color.BLUE;
			buildings2ChangeColorRect70.col = Color.BLUE;
			buildings2ChangeColorRect71.col = Color.BLUE;
			buildings2ChangeColorRect72.col = Color.BLUE;
			buildings2ChangeColorRect73.col = Color.BLUE;
			buildings2ChangeColorRect74.col = Color.BLUE;
			buildings2ChangeColorRect75.col = Color.BLUE;
			buildings2ChangeColorRect76.col = Color.BLUE;
			buildings2ChangeColorRect77.col = Color.BLUE;
			buildings2ChangeColorRect78.col = Color.BLUE;
			buildings2ChangeColorRect79.col = Color.BLUE;
			buildings2ChangeColorRect80.col = Color.BLUE;
			buildings2ChangeColorRect81.col = Color.BLUE;
			buildings2ChangeColorRect82.col = Color.BLUE;
			buildings2ChangeColorRect83.col = Color.BLUE;
			buildings2ChangeColorRect84.col = Color.BLUE;
			buildings2ChangeColorRect85.col = Color.BLUE;
			buildings2ChangeColorRect86.col = Color.BLUE;
			buildings2ChangeColorRect87.col = Color.BLUE;
			buildings2ChangeColorRect88.col = Color.BLUE;
			buildings2ChangeColorRect89.col = Color.BLUE;
			buildings2ChangeColorRect90.col = Color.BLUE;
			buildings2ChangeColorRect91.col = Color.BLUE;
			buildings2ChangeColorRect92.col = Color.BLUE;
			buildings2ChangeColorRect93.col = Color.BLUE;
			buildings2ChangeColorRect94.col = Color.BLUE;
			buildings2ChangeColorRect95.col = Color.BLUE;
			buildings2ChangeColorRect96.col = Color.BLUE;
			buildings2ChangeColorRect97.col = Color.BLUE;
			buildings2ChangeColorRect98.col = Color.BLUE;
			buildings2ChangeColorRect99.col = Color.BLUE;
			buildings2ChangeColorRect100.col = Color.BLUE;
			buildings2ChangeColorRect101.col = Color.BLUE;
			buildings2ChangeColorRect102.col = Color.BLUE;
			buildings2ChangeColorRect103.col = Color.BLUE;
			buildings2ChangeColorRect104.col = Color.BLUE;
			buildings2ChangeColorRect105.col = Color.BLUE;
			buildings2ChangeColorRect106.col = Color.BLUE;
			buildings2ChangeColorRect107.col = Color.BLUE;
			buildings2ChangeColorRect108.col = Color.BLUE;
			buildings2ChangeColorRect109.col = Color.BLUE;
			buildings2ChangeColorRect110.col = Color.BLUE;
			buildings2ChangeColorRect111.col = Color.BLUE;
			buildings2ChangeColorRect112.col = Color.BLUE;
			buildings2ChangeColorRect113.col = Color.BLUE;
			buildings2ChangeColorRect114.col = Color.BLUE;
			buildings2ChangeColorRect115.col = Color.BLUE;
			buildings2ChangeColorRect116.col = Color.BLUE;
			buildings2ChangeColorRect117.col = Color.BLUE;
			buildings2ChangeColorRect118.col = Color.BLUE;
			buildings2ChangeColorRect119.col = Color.BLUE;
			buildings2ChangeColorRect120.col = Color.BLUE;
			buildings2ChangeColorRect121.col = Color.BLUE;
			buildings2ChangeColorRect122.col = Color.BLUE;
			buildings2ChangeColorRect123.col = Color.BLUE;
			buildings2ChangeColorRect124.col = Color.BLUE;
			buildings2ChangeColorRect125.col = Color.BLUE;
			buildings2ChangeColorRect126.col = Color.BLUE;
			buildings2ChangeColorRect127.col = Color.BLUE;
			buildings2ChangeColorRect128.col = Color.BLUE;
			buildings2ChangeColorRect129.col = Color.BLUE;
			buildings2ChangeColorRect130.col = Color.BLUE;
			buildings2ChangeColorRect131.col = Color.BLUE;
			buildings2ChangeColorRect132.col = Color.BLUE;
			buildings2ChangeColorRect133.col = Color.BLUE;
			buildings2ChangeColorRect134.col = Color.BLUE;
			buildings2ChangeColorRect135.col = Color.BLUE;
			buildings2ChangeColorRect136.col = Color.BLUE;
			buildings2ChangeColorRect137.col = Color.BLUE;
			buildings2ChangeColorRect138.col = Color.BLUE;
			buildings2ChangeColorRect139.col = Color.BLUE;
			buildings2ChangeColorRect140.col = Color.BLUE;
			buildings2ChangeColorRect141.col = Color.BLUE;
			buildings2ChangeColorRect142.col = Color.BLUE;
			buildings2ChangeColorRect143.col = Color.BLUE;
			buildings2ChangeColorRect144.col = Color.BLUE;
			buildings2ChangeColorRect145.col = Color.BLUE;
			buildings2ChangeColorRect146.col = Color.BLUE;
			buildings2ChangeColorRect147.col = Color.BLUE;
			buildings2ChangeColorRect148.col = Color.BLUE;
			buildings2ChangeColorRect149.col = Color.BLUE;
			buildings2ChangeColorRect150.col = Color.BLUE;
			buildings2ChangeColorRect151.col = Color.BLUE;
			buildings2ChangeColorRect152.col = Color.BLUE;
			buildings2ChangeColorRect153.col = Color.BLUE;
			buildings2ChangeColorRect154.col = Color.BLUE;
			buildings2ChangeColorRect155.col = Color.BLUE;
			buildings2ChangeColorRect156.col = Color.BLUE;
			buildings2ChangeColorRect157.col = Color.BLUE;
			buildings2ChangeColorRect158.col = Color.BLUE;
			buildings2ChangeColorRect159.col = Color.BLUE;
			buildings2ChangeColorRect160.col = Color.BLUE;
			buildings2ChangeColorRect161.col = Color.BLUE;
			buildings2ChangeColorRect162.col = Color.BLUE;
			buildings2ChangeColorRect163.col = Color.BLUE;
			buildings2ChangeColorRect164.col = Color.BLUE;
			buildings2ChangeColorRect165.col = Color.BLUE;
			buildings2ChangeColorRect166.col = Color.BLUE;
			buildings2ChangeColorRect167.col = Color.BLUE;
			buildings2ChangeColorRect168.col = Color.BLUE;
			buildings2ChangeColorRect169.col = Color.BLUE;
			buildings2ChangeColorRect170.col = Color.BLUE;
			buildings2ChangeColorRect171.col = Color.BLUE;
			buildings2ChangeColorRect172.col = Color.BLUE;
			buildings2ChangeColorRect173.col = Color.BLUE;
			buildings2ChangeColorRect174.col = Color.BLUE;
			buildings2ChangeColorRect175.col = Color.BLUE;
			buildings2ChangeColorRect176.col = Color.BLUE;
			buildings2ChangeColorRect177.col = Color.BLUE;
			buildings2ChangeColorRect178.col = Color.BLUE;
			buildings2ChangeColorRect179.col = Color.BLUE;
			buildings2ChangeColorRect180.col = Color.BLUE;
			buildings2ChangeColorRect181.col = Color.BLUE;
			buildings2ChangeColorRect182.col = Color.BLUE;
			buildings2ChangeColorRect183.col = Color.BLUE;
			buildings2ChangeColorRect184.col = Color.BLUE;
			buildings2ChangeColorRect185.col = Color.BLUE;
			buildings2ChangeColorRect186.col = Color.BLUE;
			buildings2ChangeColorRect187.col = Color.BLUE;
			buildings2ChangeColorRect188.col = Color.BLUE;
			buildings2ChangeColorRect189.col = Color.BLUE;
			buildings2ChangeColorRect190.col = Color.BLUE;
			buildings2ChangeColorRect191.col = Color.BLUE;
			buildings2ChangeColorRect192.col = Color.BLUE;
			buildings2ChangeColorRect193.col = Color.BLUE;
			buildings2ChangeColorRect194.col = Color.BLUE;
			buildings2ChangeColorRect195.col = Color.BLUE;
			buildings2ChangeColorRect196.col = Color.BLUE;
			buildings2ChangeColorRect197.col = Color.BLUE;
			buildings2ChangeColorRect198.col = Color.BLUE;
			buildings2ChangeColorRect199.col = Color.BLUE;
			buildings2ChangeColorRect200.col = Color.BLUE;
			buildings2ChangeColorRect201.col = Color.BLUE;
			buildings2ChangeColorRect202.col = Color.BLUE;
			buildings2ChangeColorRect203.col = Color.BLUE;
			buildings2ChangeColorRect204.col = Color.BLUE;
			buildings2ChangeColorRect205.col = Color.BLUE;
			buildings2ChangeColorRect206.col = Color.BLUE;
			buildings2ChangeColorRect207.col = Color.BLUE;
			buildings2ChangeColorRect208.col = Color.BLUE;
			buildings2ChangeColorRect209.col = Color.BLUE;
			buildings2ChangeColorRect210.col = Color.BLUE;
			buildings2ChangeColorRect211.col = Color.BLUE;
			buildings2ChangeColorRect212.col = Color.BLUE;
			buildings2ChangeColorRect213.col = Color.BLUE;
			buildings2ChangeColorRect214.col = Color.BLUE;
			buildings2ChangeColorRect215.col = Color.BLUE;
			buildings2ChangeColorRect216.col = Color.BLUE;
			buildings2ChangeColorRect217.col = Color.BLUE;
			buildings2ChangeColorRect218.col = Color.BLUE;
			buildings2ChangeColorRect219.col = Color.BLUE;
			buildings2ChangeColorRect220.col = Color.BLUE;
			buildings2ChangeColorRect221.col = Color.BLUE;
			buildings2ChangeColorRect222.col = Color.BLUE;
			buildings2ChangeColorRect223.col = Color.BLUE;
			buildings2ChangeColorRect224.col = Color.BLUE;
			buildings2ChangeColorRect225.col = Color.BLUE;
			buildings2ChangeColorRect226.col = Color.BLUE;
			buildings2ChangeColorRect227.col = Color.BLUE;
			buildings2ChangeColorRect228.col = Color.BLUE;
			buildings2ChangeColorRect229.col = Color.BLUE;
			buildings2ChangeColorRect230.col = Color.BLUE;
			buildings2ChangeColorRect231.col = Color.BLUE;
			buildings2ChangeColorRect232.col = Color.BLUE;
			buildings2ChangeColorRect233.col = Color.BLUE;
			buildings2ChangeColorRect234.col = Color.BLUE;
			buildings2ChangeColorRect235.col = Color.BLUE;
			buildings2ChangeColorRect236.col = Color.BLUE;
			buildings2ChangeColorRect237.col = Color.BLUE;
			buildings2ChangeColorRect238.col = Color.BLUE;
			buildings2ChangeColorRect239.col = Color.BLUE;
			buildings2ChangeColorRect240.col = Color.BLUE;
			buildings2ChangeColorRect241.col = Color.BLUE;
			buildings2ChangeColorRect242.col = Color.BLUE;
			buildings2ChangeColorRect243.col = Color.BLUE;
			buildings2ChangeColorRect244.col = Color.BLUE;
			buildings2ChangeColorRect245.col = Color.BLUE;
			buildings2ChangeColorRect246.col = Color.BLUE;
			buildings2ChangeColorRect247.col = Color.BLUE;
			buildings2ChangeColorRect248.col = Color.BLUE;
			buildings2ChangeColorRect249.col = Color.BLUE;
			buildings2ChangeColorRect250.col = Color.BLUE;
			buildings2ChangeColorRect251.col = Color.BLUE;
			buildings2ChangeColorRect252.col = Color.BLUE;
			buildings2ChangeColorRect253.col = Color.BLUE;
			buildings2ChangeColorRect254.col = Color.BLUE;
			buildings2ChangeColorRect255.col = Color.BLUE;
			buildings2ChangeColorRect256.col = Color.BLUE;
			buildings2ChangeColorRect257.col = Color.BLUE;
			buildings2ChangeColorRect258.col = Color.BLUE;
			buildings2ChangeColorRect259.col = Color.BLUE;
			buildings2ChangeColorRect260.col = Color.BLUE;
			buildings2ChangeColorRect261.col = Color.BLUE;
			buildings2ChangeColorRect262.col = Color.BLUE;
			buildings2ChangeColorRect263.col = Color.BLUE;
			buildings2ChangeColorRect264.col = Color.BLUE;
			buildings2ChangeColorRect265.col = Color.BLUE;
			buildings2ChangeColorRect266.col = Color.BLUE;
			buildings2ChangeColorRect267.col = Color.BLUE;
			buildings2ChangeColorRect268.col = Color.BLUE;
			buildings2ChangeColorRect269.col = Color.BLUE;
			buildings2ChangeColorRect270.col = Color.BLUE;
			buildings2ChangeColorRect271.col = Color.BLUE;
			buildings2ChangeColorRect272.col = Color.BLUE;
			buildings2ChangeColorRect273.col = Color.BLUE;
			buildings2ChangeColorRect274.col = Color.BLUE;
			buildings2ChangeColorRect275.col = Color.BLUE;
			buildings2ChangeColorRect276.col = Color.BLUE;
			buildings2ChangeColorRect277.col = Color.BLUE;
			buildings2ChangeColorRect278.col = Color.BLUE;
			buildings2ChangeColorRect279.col = Color.BLUE;
			buildings2ChangeColorRect280.col = Color.BLUE;
			buildings2ChangeColorRect281.col = Color.BLUE;
			buildings2ChangeColorRect282.col = Color.BLUE;
			buildings2ChangeColorRect283.col = Color.BLUE;
			buildings2ChangeColorRect284.col = Color.BLUE;
			buildings2ChangeColorRect285.col = Color.BLUE;
			buildings2ChangeColorRect286.col = Color.BLUE;
			buildings2ChangeColorRect287.col = Color.BLUE;
			buildings2ChangeColorRect288.col = Color.BLUE;
			buildings2ChangeColorRect289.col = Color.BLUE;
			buildings2ChangeColorRect290.col = Color.BLUE;
			buildings2ChangeColorRect291.col = Color.BLUE;
			buildings2ChangeColorRect292.col = Color.BLUE;
			buildings2ChangeColorRect293.col = Color.BLUE;
			buildings2ChangeColorRect294.col = Color.BLUE;
			buildings2ChangeColorRect295.col = Color.BLUE;
			buildings2ChangeColorRect296.col = Color.BLUE;
			buildings2ChangeColorRect297.col = Color.BLUE;
			buildings2ChangeColorRect298.col = Color.BLUE;
			buildings2ChangeColorRect299.col = Color.BLUE;
			buildings2ChangeColorRect300.col = Color.BLUE;
			buildings2ChangeColorRect301.col = Color.BLUE;
			buildings2ChangeColorRect302.col = Color.BLUE;
			buildings2ChangeColorRect303.col = Color.BLUE;
			buildings2ChangeColorRect304.col = Color.BLUE;
			buildings2ChangeColorRect305.col = Color.BLUE;
			buildings2ChangeColorRect306.col = Color.BLUE;
			buildings2ChangeColorRect307.col = Color.BLUE;
			buildings2ChangeColorRect308.col = Color.BLUE;
			buildings2ChangeColorRect309.col = Color.BLUE;
			buildings2ChangeColorRect310.col = Color.BLUE;
			buildings2ChangeColorRect311.col = Color.BLUE;
			buildings2ChangeColorRect312.col = Color.BLUE;
			buildings2ChangeColorRect313.col = Color.BLUE;
			buildings2ChangeColorRect314.col = Color.BLUE;
			buildings2ChangeColorRect315.col = Color.BLUE;
			buildings2ChangeColorRect316.col = Color.BLUE;
			buildings2ChangeColorRect317.col = Color.BLUE;
			buildings2ChangeColorRect318.col = Color.BLUE;
			buildings2ChangeColorRect319.col = Color.BLUE;
			buildings2ChangeColorRect320.col = Color.BLUE;
			buildings2ChangeColorRect321.col = Color.BLUE;
			buildings2ChangeColorRect322.col = Color.BLUE;
			buildings2ChangeColorRect323.col = Color.BLUE;
			buildings2ChangeColorRect324.col = Color.BLUE;
			buildings2ChangeColorRect325.col = Color.BLUE;
			buildings2ChangeColorRect326.col = Color.BLUE;
			buildings2ChangeColorRect327.col = Color.BLUE;
			buildings2ChangeColorRect328.col = Color.BLUE;
			buildings2ChangeColorRect329.col = Color.BLUE;
			buildings2ChangeColorRect330.col = Color.BLUE;
			buildings2ChangeColorRect331.col = Color.BLUE;
			buildings2ChangeColorRect332.col = Color.BLUE;
			buildings2ChangeColorRect333.col = Color.BLUE;
			buildings2ChangeColorRect334.col = Color.BLUE;
			buildings2ChangeColorRect335.col = Color.BLUE;
			buildings2ChangeColorRect336.col = Color.BLUE;
			buildings2ChangeColorRect337.col = Color.BLUE;
			buildings2ChangeColorRect338.col = Color.BLUE;
			buildings2ChangeColorRect339.col = Color.BLUE;
			buildings2ChangeColorRect340.col = Color.BLUE;
			buildings2ChangeColorRect341.col = Color.BLUE;
			buildings2ChangeColorRect342.col = Color.BLUE;
			buildings2ChangeColorRect343.col = Color.BLUE;
			buildings2ChangeColorRect344.col = Color.BLUE;
			buildings2ChangeColorRect345.col = Color.BLUE;
			buildings2ChangeColorRect346.col = Color.BLUE;
			buildings2ChangeColorRect347.col = Color.BLUE;
			buildings2ChangeColorRect348.col = Color.BLUE;
			buildings2ChangeColorRect349.col = Color.BLUE;
			buildings2ChangeColorRect350.col = Color.BLUE;
			buildings2ChangeColorRect351.col = Color.BLUE;
			buildings2ChangeColorRect352.col = Color.BLUE;
			buildings2ChangeColorRect353.col = Color.BLUE;
			buildings2ChangeColorRect354.col = Color.BLUE;
			buildings2ChangeColorRect355.col = Color.BLUE;
			buildings2ChangeColorRect356.col = Color.BLUE;
			buildings2ChangeColorRect357.col = Color.BLUE;
			buildings2ChangeColorRect358.col = Color.BLUE;
			buildings2ChangeColorRect359.col = Color.BLUE;
			buildings2ChangeColorRect360.col = Color.BLUE;
			buildings2ChangeColorRect361.col = Color.BLUE;
			buildings2ChangeColorRect362.col = Color.BLUE;
			buildings2ChangeColorRect363.col = Color.BLUE;
			buildings2ChangeColorRect364.col = Color.BLUE;
			buildings2ChangeColorRect365.col = Color.BLUE;
			buildings2ChangeColorRect366.col = Color.BLUE;
			buildings2ChangeColorRect367.col = Color.BLUE;
			buildings2ChangeColorRect368.col = Color.BLUE;
			buildings2ChangeColorRect369.col = Color.BLUE;
			buildings2ChangeColorRect370.col = Color.BLUE;
			buildings2ChangeColorRect371.col = Color.BLUE;
			buildings2ChangeColorRect372.col = Color.BLUE;
			buildings2ChangeColorRect373.col = Color.BLUE;
			buildings2ChangeColorRect374.col = Color.BLUE;
			buildings2ChangeColorRect375.col = Color.BLUE;
			buildings2ChangeColorRect376.col = Color.BLUE;
			buildings2ChangeColorRect377.col = Color.BLUE;
			buildings2ChangeColorRect378.col = Color.BLUE;
			buildings2ChangeColorRect379.col = Color.BLUE;
			buildings2ChangeColorRect380.col = Color.BLUE;
			buildings2ChangeColorRect381.col = Color.BLUE;
			buildings2ChangeColorRect382.col = Color.BLUE;
			buildings2ChangeColorRect383.col = Color.BLUE;
			buildings2ChangeColorRect384.col = Color.BLUE;
			buildings2ChangeColorRect385.col = Color.BLUE;
			buildings2ChangeColorRect386.col = Color.BLUE;
			buildings2ChangeColorRect387.col = Color.BLUE;
			buildings2ChangeColorRect388.col = Color.BLUE;
			buildings2ChangeColorRect389.col = Color.BLUE;
			buildings2ChangeColorRect390.col = Color.BLUE;
			buildings2ChangeColorRect391.col = Color.BLUE;
			buildings2ChangeColorRect392.col = Color.BLUE;
			buildings2ChangeColorRect393.col = Color.BLUE;
			buildings2ChangeColorRect394.col = Color.BLUE;
			buildings2ChangeColorRect395.col = Color.BLUE;
			buildings2ChangeColorRect396.col = Color.BLUE;
			buildings2ChangeColorRect397.col = Color.BLUE;
			buildings2ChangeColorRect398.col = Color.BLUE;
			buildings2ChangeColorRect399.col = Color.BLUE;
			buildings2ChangeColorRect400.col = Color.BLUE;
			buildings2ChangeColorRect401.col = Color.BLUE;
			buildings2ChangeColorRect402.col = Color.BLUE;
			buildings2ChangeColorRect403.col = Color.BLUE;
			buildings2ChangeColorRect404.col = Color.BLUE;
			buildings2ChangeColorRect405.col = Color.BLUE;
			buildings2ChangeColorRect406.col = Color.BLUE;
			buildings2ChangeColorRect407.col = Color.BLUE;
			buildings2ChangeColorRect408.col = Color.BLUE;
			buildings2ChangeColorRect409.col = Color.BLUE;
			buildings2ChangeColorRect410.col = Color.BLUE;
			buildings2ChangeColorRect411.col = Color.BLUE;
			buildings2ChangeColorRect412.col = Color.BLUE;
			buildings2ChangeColorRect413.col = Color.BLUE;
			buildings2ChangeColorRect414.col = Color.BLUE;
			buildings2ChangeColorRect415.col = Color.BLUE;
			buildings2ChangeColorRect416.col = Color.BLUE;
			buildings2ChangeColorRect417.col = Color.BLUE;
			buildings2ChangeColorRect418.col = Color.BLUE;
			buildings2ChangeColorRect419.col = Color.BLUE;
			buildings2ChangeColorRect420.col = Color.BLUE;
			buildings2ChangeColorRect421.col = Color.BLUE;
			buildings2ChangeColorRect422.col = Color.BLUE;
			buildings2ChangeColorRect423.col = Color.BLUE;
			buildings2ChangeColorRect424.col = Color.BLUE;
			buildings2ChangeColorRect425.col = Color.BLUE;
			buildings2ChangeColorRect426.col = Color.BLUE;
			buildings2ChangeColorRect427.col = Color.BLUE;
			buildings2ChangeColorRect428.col = Color.BLUE;
			buildings2ChangeColorRect429.col = Color.BLUE;
			buildings2ChangeColorRect430.col = Color.BLUE;
			buildings2ChangeColorRect431.col = Color.BLUE;
			buildings2ChangeColorRect432.col = Color.BLUE;
			buildings2ChangeColorRect433.col = Color.BLUE;
			buildings2ChangeColorRect434.col = Color.BLUE;
			buildings2ChangeColorRect435.col = Color.BLUE;
			buildings2ChangeColorRect436.col = Color.BLUE;
			buildings2ChangeColorRect437.col = Color.BLUE;
			buildings2ChangeColorRect438.col = Color.BLUE;
			buildings2ChangeColorRect439.col = Color.BLUE;
			buildings2ChangeColorRect440.col = Color.BLUE;
			buildings2ChangeColorRect441.col = Color.BLUE;
			buildings2ChangeColorRect442.col = Color.BLUE;
			buildings2ChangeColorRect443.col = Color.BLUE;
			buildings2ChangeColorRect444.col = Color.BLUE;
			buildings2ChangeColorRect445.col = Color.BLUE;
			buildings2ChangeColorRect446.col = Color.BLUE;
			buildings2ChangeColorRect447.col = Color.BLUE;
			buildings2ChangeColorRect448.col = Color.BLUE;
			buildings2ChangeColorRect449.col = Color.BLUE;
			buildings2ChangeColorRect450.col = Color.BLUE;
			buildings2ChangeColorRect451.col = Color.BLUE;
			buildings2ChangeColorRect452.col = Color.BLUE;
			buildings2ChangeColorRect453.col = Color.BLUE;
			buildings2ChangeColorRect454.col = Color.BLUE;
			buildings2ChangeColorRect455.col = Color.BLUE;
			buildings2ChangeColorRect456.col = Color.BLUE;
			buildings2ChangeColorRect457.col = Color.BLUE;
			buildings2ChangeColorRect458.col = Color.BLUE;
			buildings2ChangeColorRect459.col = Color.BLUE;
			buildings2ChangeColorRect460.col = Color.BLUE;
			buildings2ChangeColorRect461.col = Color.BLUE;
			buildings2ChangeColorRect462.col = Color.BLUE;
			buildings2ChangeColorRect463.col = Color.BLUE;
			buildings2ChangeColorRect464.col = Color.BLUE;
			buildings2ChangeColorRect465.col = Color.BLUE;
			buildings2ChangeColorRect466.col = Color.BLUE;
			buildings2ChangeColorRect467.col = Color.BLUE;
			buildings2ChangeColorRect468.col = Color.BLUE;
			buildings2ChangeColorRect469.col = Color.BLUE;
			buildings2ChangeColorRect470.col = Color.BLUE;
			buildings2ChangeColorRect471.col = Color.BLUE;
			buildings2ChangeColorRect472.col = Color.BLUE;
			buildings2ChangeColorRect473.col = Color.BLUE;
			buildings2ChangeColorRect474.col = Color.BLUE;
			buildings2ChangeColorRect475.col = Color.BLUE;
			buildings2ChangeColorRect476.col = Color.BLUE;
			buildings2ChangeColorRect477.col = Color.BLUE;
			buildings2ChangeColorRect478.col = Color.BLUE;
			buildings2ChangeColorRect479.col = Color.BLUE;
			buildings2ChangeColorRect480.col = Color.BLUE;
			buildings2ChangeColorRect481.col = Color.BLUE;
			buildings2ChangeColorRect482.col = Color.BLUE;
			buildings2ChangeColorRect483.col = Color.BLUE;
			buildings2ChangeColorRect484.col = Color.BLUE;
			buildings2ChangeColorRect485.col = Color.BLUE;
			buildings2ChangeColorRect486.col = Color.BLUE;
			buildings2ChangeColorRect487.col = Color.BLUE;
			buildings2ChangeColorRect488.col = Color.BLUE;
			buildings2ChangeColorRect489.col = Color.BLUE;
			buildings2ChangeColorRect490.col = Color.BLUE;
			buildings2ChangeColorRect491.col = Color.BLUE;
			buildings2ChangeColorRect492.col = Color.BLUE;
			buildings2ChangeColorRect493.col = Color.BLUE;
			buildings2ChangeColorRect494.col = Color.BLUE;
			buildings2ChangeColorRect495.col = Color.BLUE;
			buildings2ChangeColorRect496.col = Color.BLUE;
			buildings2ChangeColorRect497.col = Color.BLUE;
			buildings2ChangeColorRect498.col = Color.BLUE;
			buildings2ChangeColorRect499.col = Color.BLUE;
			buildings2ChangeColorRect500.col = Color.BLUE;
			buildings2ChangeColorRect501.col = Color.BLUE;
			buildings2ChangeColorRect502.col = Color.BLUE;
			buildings2ChangeColorRect503.col = Color.BLUE;
			buildings2ChangeColorRect504.col = Color.BLUE;
			buildings2ChangeColorRect505.col = Color.BLUE;
			buildings2ChangeColorRect506.col = Color.BLUE;
			buildings2ChangeColorRect507.col = Color.BLUE;
			buildings2ChangeColorRect508.col = Color.BLUE;
			buildings2ChangeColorRect509.col = Color.BLUE;
			buildings2ChangeColorRect510.col = Color.BLUE;
			buildings2ChangeColorRect511.col = Color.BLUE;
			buildings2ChangeColorRect512.col = Color.BLUE;
			buildings2ChangeColorRect513.col = Color.BLUE;
			buildings2ChangeColorRect514.col = Color.BLUE;
			buildings2ChangeColorRect515.col = Color.BLUE;
			buildings2ChangeColorRect516.col = Color.BLUE;
			buildings2ChangeColorRect517.col = Color.BLUE;
			buildings2ChangeColorRect518.col = Color.BLUE;
			buildings2ChangeColorRect519.col = Color.BLUE;
			buildings2ChangeColorRect520.col = Color.BLUE;
			buildings2ChangeColorRect521.col = Color.BLUE;

		
		rects.add(buildings2ChangeColorRect1);
		rects.add(buildings2ChangeColorRect2);
		rects.add(buildings2ChangeColorRect3);
		rects.add(buildings2ChangeColorRect4);
		rects.add(buildings2ChangeColorRect5);
		rects.add(buildings2ChangeColorRect6);
		rects.add(buildings2ChangeColorRect7);
		rects.add(buildings2ChangeColorRect8);
		rects.add(buildings2ChangeColorRect9);
		rects.add(buildings2ChangeColorRect10);
		rects.add(buildings2ChangeColorRect11);
		rects.add(buildings2ChangeColorRect12);
		rects.add(buildings2ChangeColorRect13);
		rects.add(buildings2ChangeColorRect14);
		rects.add(buildings2ChangeColorRect15);
		rects.add(buildings2ChangeColorRect16);
		rects.add(buildings2ChangeColorRect17);
		rects.add(buildings2ChangeColorRect18);
		rects.add(buildings2ChangeColorRect19);
		rects.add(buildings2ChangeColorRect20);
		rects.add(buildings2ChangeColorRect21);
		rects.add(buildings2ChangeColorRect22);
		rects.add(buildings2ChangeColorRect23);
		rects.add(buildings2ChangeColorRect24);
		rects.add(buildings2ChangeColorRect25);
		rects.add(buildings2ChangeColorRect26);
		rects.add(buildings2ChangeColorRect27);
		rects.add(buildings2ChangeColorRect28);
		rects.add(buildings2ChangeColorRect29);
		rects.add(buildings2ChangeColorRect30);
		rects.add(buildings2ChangeColorRect31);
		rects.add(buildings2ChangeColorRect32);
		rects.add(buildings2ChangeColorRect33);
		rects.add(buildings2ChangeColorRect34);
		rects.add(buildings2ChangeColorRect35);
		rects.add(buildings2ChangeColorRect36);
		rects.add(buildings2ChangeColorRect37);
		rects.add(buildings2ChangeColorRect38);
		rects.add(buildings2ChangeColorRect39);
		rects.add(buildings2ChangeColorRect40);
		rects.add(buildings2ChangeColorRect41);
		rects.add(buildings2ChangeColorRect42);
		rects.add(buildings2ChangeColorRect43);
		rects.add(buildings2ChangeColorRect44);
		rects.add(buildings2ChangeColorRect45);
		rects.add(buildings2ChangeColorRect46);
		rects.add(buildings2ChangeColorRect47);
		rects.add(buildings2ChangeColorRect48);
		rects.add(buildings2ChangeColorRect49);
		rects.add(buildings2ChangeColorRect50);
		rects.add(buildings2ChangeColorRect51);
		rects.add(buildings2ChangeColorRect52);
		rects.add(buildings2ChangeColorRect53);
		rects.add(buildings2ChangeColorRect53a);
		rects.add(buildings2ChangeColorRect54);
		rects.add(buildings2ChangeColorRect55);
		rects.add(buildings2ChangeColorRect56);
		rects.add(buildings2ChangeColorRect57);
		rects.add(buildings2ChangeColorRect58);
		rects.add(buildings2ChangeColorRect59);
		rects.add(buildings2ChangeColorRect60);
		rects.add(buildings2ChangeColorRect61);
		rects.add(buildings2ChangeColorRect62);
		rects.add(buildings2ChangeColorRect63);
		rects.add(buildings2ChangeColorRect64);
		rects.add(buildings2ChangeColorRect65);
		rects.add(buildings2ChangeColorRect66);
		rects.add(buildings2ChangeColorRect67);
		rects.add(buildings2ChangeColorRect68);
		rects.add(buildings2ChangeColorRect69);
		rects.add(buildings2ChangeColorRect70);
		rects.add(buildings2ChangeColorRect71);
		rects.add(buildings2ChangeColorRect72);
		rects.add(buildings2ChangeColorRect73);
		rects.add(buildings2ChangeColorRect74);
		rects.add(buildings2ChangeColorRect75);
		rects.add(buildings2ChangeColorRect76);
		rects.add(buildings2ChangeColorRect77);
		rects.add(buildings2ChangeColorRect78);
		rects.add(buildings2ChangeColorRect79);
		rects.add(buildings2ChangeColorRect80);
		rects.add(buildings2ChangeColorRect81);
		rects.add(buildings2ChangeColorRect82);
		rects.add(buildings2ChangeColorRect83);
		rects.add(buildings2ChangeColorRect84);
		rects.add(buildings2ChangeColorRect85);
		rects.add(buildings2ChangeColorRect86);
		rects.add(buildings2ChangeColorRect87);
		rects.add(buildings2ChangeColorRect88);
		rects.add(buildings2ChangeColorRect89);
		rects.add(buildings2ChangeColorRect90);
		rects.add(buildings2ChangeColorRect91);
		rects.add(buildings2ChangeColorRect92);
		rects.add(buildings2ChangeColorRect93);
		rects.add(buildings2ChangeColorRect94);
		rects.add(buildings2ChangeColorRect95);
		rects.add(buildings2ChangeColorRect96);
		rects.add(buildings2ChangeColorRect97);
		rects.add(buildings2ChangeColorRect98);
		rects.add(buildings2ChangeColorRect99);
		rects.add(buildings2ChangeColorRect100);
		rects.add(buildings2ChangeColorRect101);
		rects.add(buildings2ChangeColorRect102);
		rects.add(buildings2ChangeColorRect103);
		rects.add(buildings2ChangeColorRect104);
		rects.add(buildings2ChangeColorRect105);
		rects.add(buildings2ChangeColorRect106);
		rects.add(buildings2ChangeColorRect107);
		rects.add(buildings2ChangeColorRect108);
		rects.add(buildings2ChangeColorRect109);
		rects.add(buildings2ChangeColorRect110);
		rects.add(buildings2ChangeColorRect111);
		rects.add(buildings2ChangeColorRect112);
		rects.add(buildings2ChangeColorRect113);
		rects.add(buildings2ChangeColorRect114);
		rects.add(buildings2ChangeColorRect115);
		rects.add(buildings2ChangeColorRect116);
		rects.add(buildings2ChangeColorRect117);
		rects.add(buildings2ChangeColorRect118);
		rects.add(buildings2ChangeColorRect119);
		rects.add(buildings2ChangeColorRect120);
		rects.add(buildings2ChangeColorRect121);
		rects.add(buildings2ChangeColorRect122);
		rects.add(buildings2ChangeColorRect123);
		rects.add(buildings2ChangeColorRect124);
		rects.add(buildings2ChangeColorRect125);
		rects.add(buildings2ChangeColorRect126);
		rects.add(buildings2ChangeColorRect127);
		rects.add(buildings2ChangeColorRect128);
		rects.add(buildings2ChangeColorRect129);
		rects.add(buildings2ChangeColorRect130);
		rects.add(buildings2ChangeColorRect131);
		rects.add(buildings2ChangeColorRect132);
		rects.add(buildings2ChangeColorRect133);
		rects.add(buildings2ChangeColorRect134);
		rects.add(buildings2ChangeColorRect135);
		rects.add(buildings2ChangeColorRect136);
		rects.add(buildings2ChangeColorRect137);
		rects.add(buildings2ChangeColorRect138);
		rects.add(buildings2ChangeColorRect139);
		rects.add(buildings2ChangeColorRect140);
		rects.add(buildings2ChangeColorRect141);
		rects.add(buildings2ChangeColorRect142);
		rects.add(buildings2ChangeColorRect143);
		rects.add(buildings2ChangeColorRect144);
		rects.add(buildings2ChangeColorRect145);
		rects.add(buildings2ChangeColorRect146);
		rects.add(buildings2ChangeColorRect147);
		rects.add(buildings2ChangeColorRect148);
		rects.add(buildings2ChangeColorRect149);
		rects.add(buildings2ChangeColorRect150);
		rects.add(buildings2ChangeColorRect151);
		rects.add(buildings2ChangeColorRect152);
		rects.add(buildings2ChangeColorRect153);
		rects.add(buildings2ChangeColorRect154);
		rects.add(buildings2ChangeColorRect155);
		rects.add(buildings2ChangeColorRect156);
		rects.add(buildings2ChangeColorRect157);
		rects.add(buildings2ChangeColorRect158);
		rects.add(buildings2ChangeColorRect159);
		rects.add(buildings2ChangeColorRect160);
		rects.add(buildings2ChangeColorRect161);
		rects.add(buildings2ChangeColorRect162);
		rects.add(buildings2ChangeColorRect163);
		rects.add(buildings2ChangeColorRect164);
		rects.add(buildings2ChangeColorRect165);
		rects.add(buildings2ChangeColorRect166);
		rects.add(buildings2ChangeColorRect167);
		rects.add(buildings2ChangeColorRect168);
		rects.add(buildings2ChangeColorRect169);
		rects.add(buildings2ChangeColorRect170);
		rects.add(buildings2ChangeColorRect171);
		rects.add(buildings2ChangeColorRect172);
		rects.add(buildings2ChangeColorRect173);
		rects.add(buildings2ChangeColorRect174);
		rects.add(buildings2ChangeColorRect175);
		rects.add(buildings2ChangeColorRect176);
		rects.add(buildings2ChangeColorRect177);
		rects.add(buildings2ChangeColorRect178);
		rects.add(buildings2ChangeColorRect179);
		rects.add(buildings2ChangeColorRect180);
		rects.add(buildings2ChangeColorRect181);
		rects.add(buildings2ChangeColorRect182);
		rects.add(buildings2ChangeColorRect183);
		rects.add(buildings2ChangeColorRect184);
		rects.add(buildings2ChangeColorRect185);
		rects.add(buildings2ChangeColorRect186);
		rects.add(buildings2ChangeColorRect187);
		rects.add(buildings2ChangeColorRect188);
		rects.add(buildings2ChangeColorRect189);
		rects.add(buildings2ChangeColorRect190);
		rects.add(buildings2ChangeColorRect191);
		rects.add(buildings2ChangeColorRect192);
		rects.add(buildings2ChangeColorRect193);
		rects.add(buildings2ChangeColorRect194);
		rects.add(buildings2ChangeColorRect195);
		rects.add(buildings2ChangeColorRect196);
		rects.add(buildings2ChangeColorRect197);
		rects.add(buildings2ChangeColorRect198);
		rects.add(buildings2ChangeColorRect199);
		rects.add(buildings2ChangeColorRect200);
		rects.add(buildings2ChangeColorRect201);
		rects.add(buildings2ChangeColorRect202);
		rects.add(buildings2ChangeColorRect203);
		rects.add(buildings2ChangeColorRect204);
		rects.add(buildings2ChangeColorRect205);
		rects.add(buildings2ChangeColorRect206);
		rects.add(buildings2ChangeColorRect207);
		rects.add(buildings2ChangeColorRect208);
		rects.add(buildings2ChangeColorRect209);
		rects.add(buildings2ChangeColorRect210);
		rects.add(buildings2ChangeColorRect211);
		rects.add(buildings2ChangeColorRect212);
		rects.add(buildings2ChangeColorRect213);
		rects.add(buildings2ChangeColorRect214);
		rects.add(buildings2ChangeColorRect215);
		rects.add(buildings2ChangeColorRect216);
		rects.add(buildings2ChangeColorRect217);
		rects.add(buildings2ChangeColorRect218);
		rects.add(buildings2ChangeColorRect219);
		rects.add(buildings2ChangeColorRect220);
		rects.add(buildings2ChangeColorRect221);
		rects.add(buildings2ChangeColorRect222);
		rects.add(buildings2ChangeColorRect223);
		rects.add(buildings2ChangeColorRect224);
		rects.add(buildings2ChangeColorRect225);
		rects.add(buildings2ChangeColorRect226);
		rects.add(buildings2ChangeColorRect227);
		rects.add(buildings2ChangeColorRect228);
		rects.add(buildings2ChangeColorRect229);
		rects.add(buildings2ChangeColorRect230);
		rects.add(buildings2ChangeColorRect231);
		rects.add(buildings2ChangeColorRect232);
		rects.add(buildings2ChangeColorRect233);
		rects.add(buildings2ChangeColorRect234);
		rects.add(buildings2ChangeColorRect235);
		rects.add(buildings2ChangeColorRect236);
		rects.add(buildings2ChangeColorRect237);
		rects.add(buildings2ChangeColorRect238);
		rects.add(buildings2ChangeColorRect239);
		rects.add(buildings2ChangeColorRect240);
		rects.add(buildings2ChangeColorRect241);
		rects.add(buildings2ChangeColorRect242);
		rects.add(buildings2ChangeColorRect243);
		rects.add(buildings2ChangeColorRect244);
		rects.add(buildings2ChangeColorRect245);
		rects.add(buildings2ChangeColorRect246);
		rects.add(buildings2ChangeColorRect247);
		rects.add(buildings2ChangeColorRect248);
		rects.add(buildings2ChangeColorRect249);
		rects.add(buildings2ChangeColorRect250);
		rects.add(buildings2ChangeColorRect251);
		rects.add(buildings2ChangeColorRect252);
		rects.add(buildings2ChangeColorRect253);
		rects.add(buildings2ChangeColorRect254);
		rects.add(buildings2ChangeColorRect255);
		rects.add(buildings2ChangeColorRect256);
		rects.add(buildings2ChangeColorRect257);
		rects.add(buildings2ChangeColorRect258);
		rects.add(buildings2ChangeColorRect259);
		rects.add(buildings2ChangeColorRect260);
		rects.add(buildings2ChangeColorRect261);
		rects.add(buildings2ChangeColorRect262);
		rects.add(buildings2ChangeColorRect263);
		rects.add(buildings2ChangeColorRect264);
		rects.add(buildings2ChangeColorRect265);
		rects.add(buildings2ChangeColorRect266);
		rects.add(buildings2ChangeColorRect267);
		rects.add(buildings2ChangeColorRect268);
		rects.add(buildings2ChangeColorRect269);
		rects.add(buildings2ChangeColorRect270);
		rects.add(buildings2ChangeColorRect271);
		rects.add(buildings2ChangeColorRect272);
		rects.add(buildings2ChangeColorRect273);
		rects.add(buildings2ChangeColorRect274);
		rects.add(buildings2ChangeColorRect275);
		rects.add(buildings2ChangeColorRect276);
		rects.add(buildings2ChangeColorRect277);
		rects.add(buildings2ChangeColorRect278);
		rects.add(buildings2ChangeColorRect279);
		rects.add(buildings2ChangeColorRect280);
		rects.add(buildings2ChangeColorRect281);
		rects.add(buildings2ChangeColorRect282);
		rects.add(buildings2ChangeColorRect283);
		rects.add(buildings2ChangeColorRect284);
		rects.add(buildings2ChangeColorRect285);
		rects.add(buildings2ChangeColorRect286);
		rects.add(buildings2ChangeColorRect287);
		rects.add(buildings2ChangeColorRect288);
		rects.add(buildings2ChangeColorRect289);
		rects.add(buildings2ChangeColorRect290);
		rects.add(buildings2ChangeColorRect291);
		rects.add(buildings2ChangeColorRect292);
		rects.add(buildings2ChangeColorRect293);
		rects.add(buildings2ChangeColorRect294);
		rects.add(buildings2ChangeColorRect295);
		rects.add(buildings2ChangeColorRect296);
		rects.add(buildings2ChangeColorRect297);
		rects.add(buildings2ChangeColorRect298);
		rects.add(buildings2ChangeColorRect299);
		rects.add(buildings2ChangeColorRect300);
		rects.add(buildings2ChangeColorRect301);
		rects.add(buildings2ChangeColorRect302);
		rects.add(buildings2ChangeColorRect303);
		rects.add(buildings2ChangeColorRect304);
		rects.add(buildings2ChangeColorRect305);
		rects.add(buildings2ChangeColorRect306);
		rects.add(buildings2ChangeColorRect307);
		rects.add(buildings2ChangeColorRect308);
		rects.add(buildings2ChangeColorRect309);
		rects.add(buildings2ChangeColorRect310);
		rects.add(buildings2ChangeColorRect311);
		rects.add(buildings2ChangeColorRect312);
		rects.add(buildings2ChangeColorRect313);
		rects.add(buildings2ChangeColorRect314);
		rects.add(buildings2ChangeColorRect315);
		rects.add(buildings2ChangeColorRect316);
		rects.add(buildings2ChangeColorRect317);
		rects.add(buildings2ChangeColorRect318);
		rects.add(buildings2ChangeColorRect319);
		rects.add(buildings2ChangeColorRect320);
		rects.add(buildings2ChangeColorRect321);
		rects.add(buildings2ChangeColorRect322);
		rects.add(buildings2ChangeColorRect323);
		rects.add(buildings2ChangeColorRect324);
		rects.add(buildings2ChangeColorRect325);
		rects.add(buildings2ChangeColorRect326);
		rects.add(buildings2ChangeColorRect327);
		rects.add(buildings2ChangeColorRect328);
		rects.add(buildings2ChangeColorRect329);
		rects.add(buildings2ChangeColorRect330);
		rects.add(buildings2ChangeColorRect331);
		rects.add(buildings2ChangeColorRect332);
		rects.add(buildings2ChangeColorRect333);
		rects.add(buildings2ChangeColorRect334);
		rects.add(buildings2ChangeColorRect335);
		rects.add(buildings2ChangeColorRect336);
		rects.add(buildings2ChangeColorRect337);
		rects.add(buildings2ChangeColorRect338);
		rects.add(buildings2ChangeColorRect339);
		rects.add(buildings2ChangeColorRect340);
		rects.add(buildings2ChangeColorRect341);
		rects.add(buildings2ChangeColorRect342);
		rects.add(buildings2ChangeColorRect343);
		rects.add(buildings2ChangeColorRect344);
		rects.add(buildings2ChangeColorRect345);
		rects.add(buildings2ChangeColorRect346);
		rects.add(buildings2ChangeColorRect347);
		rects.add(buildings2ChangeColorRect348);
		rects.add(buildings2ChangeColorRect349);
		rects.add(buildings2ChangeColorRect350);
		rects.add(buildings2ChangeColorRect351);
		rects.add(buildings2ChangeColorRect352);
		rects.add(buildings2ChangeColorRect353);
		rects.add(buildings2ChangeColorRect354);
		rects.add(buildings2ChangeColorRect355);
		rects.add(buildings2ChangeColorRect356);
		rects.add(buildings2ChangeColorRect357);
		rects.add(buildings2ChangeColorRect358);
		rects.add(buildings2ChangeColorRect359);
		rects.add(buildings2ChangeColorRect360);
		rects.add(buildings2ChangeColorRect361);
		rects.add(buildings2ChangeColorRect362);
		rects.add(buildings2ChangeColorRect363);
		rects.add(buildings2ChangeColorRect364);
		rects.add(buildings2ChangeColorRect365);
		rects.add(buildings2ChangeColorRect366);
		rects.add(buildings2ChangeColorRect367);
		rects.add(buildings2ChangeColorRect368);
		rects.add(buildings2ChangeColorRect369);
		rects.add(buildings2ChangeColorRect370);
		rects.add(buildings2ChangeColorRect371);
		rects.add(buildings2ChangeColorRect372);
		rects.add(buildings2ChangeColorRect373);
		rects.add(buildings2ChangeColorRect374);
		rects.add(buildings2ChangeColorRect375);
		rects.add(buildings2ChangeColorRect376);
		rects.add(buildings2ChangeColorRect377);
		rects.add(buildings2ChangeColorRect378);
		rects.add(buildings2ChangeColorRect379);
		rects.add(buildings2ChangeColorRect380);
		rects.add(buildings2ChangeColorRect381);
		rects.add(buildings2ChangeColorRect382);
		rects.add(buildings2ChangeColorRect383);
		rects.add(buildings2ChangeColorRect384);
		rects.add(buildings2ChangeColorRect385);
		rects.add(buildings2ChangeColorRect386);
		rects.add(buildings2ChangeColorRect387);
		rects.add(buildings2ChangeColorRect388);
		rects.add(buildings2ChangeColorRect389);
		rects.add(buildings2ChangeColorRect390);
		rects.add(buildings2ChangeColorRect391);
		rects.add(buildings2ChangeColorRect392);
		rects.add(buildings2ChangeColorRect393);
		rects.add(buildings2ChangeColorRect394);
		rects.add(buildings2ChangeColorRect395);
		rects.add(buildings2ChangeColorRect396);
		rects.add(buildings2ChangeColorRect397);
		rects.add(buildings2ChangeColorRect398);
		rects.add(buildings2ChangeColorRect399);
		rects.add(buildings2ChangeColorRect400);
		rects.add(buildings2ChangeColorRect401);
		rects.add(buildings2ChangeColorRect402);
		rects.add(buildings2ChangeColorRect403);
		rects.add(buildings2ChangeColorRect404);
		rects.add(buildings2ChangeColorRect405);
		rects.add(buildings2ChangeColorRect406);
		rects.add(buildings2ChangeColorRect407);
		rects.add(buildings2ChangeColorRect408);
		rects.add(buildings2ChangeColorRect409);
		rects.add(buildings2ChangeColorRect410);
		rects.add(buildings2ChangeColorRect411);
		rects.add(buildings2ChangeColorRect412);
		rects.add(buildings2ChangeColorRect413);
		rects.add(buildings2ChangeColorRect414);
		rects.add(buildings2ChangeColorRect415);
		rects.add(buildings2ChangeColorRect416);
		rects.add(buildings2ChangeColorRect417);
		rects.add(buildings2ChangeColorRect418);
		rects.add(buildings2ChangeColorRect419);
		rects.add(buildings2ChangeColorRect420);
		rects.add(buildings2ChangeColorRect421);
		rects.add(buildings2ChangeColorRect422);
		rects.add(buildings2ChangeColorRect423);
		rects.add(buildings2ChangeColorRect424);
		rects.add(buildings2ChangeColorRect425);
		rects.add(buildings2ChangeColorRect426);
		rects.add(buildings2ChangeColorRect427);
		rects.add(buildings2ChangeColorRect428);
		rects.add(buildings2ChangeColorRect429);
		rects.add(buildings2ChangeColorRect430);
		rects.add(buildings2ChangeColorRect431);
		rects.add(buildings2ChangeColorRect432);
		rects.add(buildings2ChangeColorRect433);
		rects.add(buildings2ChangeColorRect434);
		rects.add(buildings2ChangeColorRect435);
		rects.add(buildings2ChangeColorRect436);
		rects.add(buildings2ChangeColorRect437);
		rects.add(buildings2ChangeColorRect438);
		rects.add(buildings2ChangeColorRect439);
		rects.add(buildings2ChangeColorRect440);
		rects.add(buildings2ChangeColorRect441);
		rects.add(buildings2ChangeColorRect442);
		rects.add(buildings2ChangeColorRect443);
		rects.add(buildings2ChangeColorRect444);
		rects.add(buildings2ChangeColorRect445);
		rects.add(buildings2ChangeColorRect446);
		rects.add(buildings2ChangeColorRect447);
		rects.add(buildings2ChangeColorRect448);
		rects.add(buildings2ChangeColorRect449);
		rects.add(buildings2ChangeColorRect450);
		rects.add(buildings2ChangeColorRect451);
		rects.add(buildings2ChangeColorRect452);
		rects.add(buildings2ChangeColorRect453);
		rects.add(buildings2ChangeColorRect454);
		rects.add(buildings2ChangeColorRect455);
		rects.add(buildings2ChangeColorRect456);
		rects.add(buildings2ChangeColorRect457);
		rects.add(buildings2ChangeColorRect458);
		rects.add(buildings2ChangeColorRect459);
		rects.add(buildings2ChangeColorRect460);
		rects.add(buildings2ChangeColorRect461);
		rects.add(buildings2ChangeColorRect462);
		rects.add(buildings2ChangeColorRect463);
		rects.add(buildings2ChangeColorRect464);
		rects.add(buildings2ChangeColorRect465);
		rects.add(buildings2ChangeColorRect466);
		rects.add(buildings2ChangeColorRect467);
		rects.add(buildings2ChangeColorRect468);
		rects.add(buildings2ChangeColorRect469);
		rects.add(buildings2ChangeColorRect470);
		rects.add(buildings2ChangeColorRect471);
		rects.add(buildings2ChangeColorRect472);
		rects.add(buildings2ChangeColorRect473);
		rects.add(buildings2ChangeColorRect474);
		rects.add(buildings2ChangeColorRect475);
		rects.add(buildings2ChangeColorRect476);
		rects.add(buildings2ChangeColorRect477);
		rects.add(buildings2ChangeColorRect478);
		rects.add(buildings2ChangeColorRect479);
		rects.add(buildings2ChangeColorRect480);
		rects.add(buildings2ChangeColorRect481);
		rects.add(buildings2ChangeColorRect482);
		rects.add(buildings2ChangeColorRect483);
		rects.add(buildings2ChangeColorRect484);
		rects.add(buildings2ChangeColorRect485);
		rects.add(buildings2ChangeColorRect486);
		rects.add(buildings2ChangeColorRect487);
		rects.add(buildings2ChangeColorRect488);
		rects.add(buildings2ChangeColorRect489);
		rects.add(buildings2ChangeColorRect490);
		rects.add(buildings2ChangeColorRect491);
		rects.add(buildings2ChangeColorRect492);
		rects.add(buildings2ChangeColorRect493);
		rects.add(buildings2ChangeColorRect494);
		rects.add(buildings2ChangeColorRect495);
		rects.add(buildings2ChangeColorRect496);
		rects.add(buildings2ChangeColorRect497);
		rects.add(buildings2ChangeColorRect498);
		rects.add(buildings2ChangeColorRect499);
		rects.add(buildings2ChangeColorRect500);
		rects.add(buildings2ChangeColorRect501);
		rects.add(buildings2ChangeColorRect502);
		rects.add(buildings2ChangeColorRect503);
		rects.add(buildings2ChangeColorRect504);
		rects.add(buildings2ChangeColorRect505);
		rects.add(buildings2ChangeColorRect506);
		rects.add(buildings2ChangeColorRect507);
		rects.add(buildings2ChangeColorRect508);
		rects.add(buildings2ChangeColorRect509);
		rects.add(buildings2ChangeColorRect510);
		rects.add(buildings2ChangeColorRect511);
		rects.add(buildings2ChangeColorRect512);
		rects.add(buildings2ChangeColorRect513);
		rects.add(buildings2ChangeColorRect514);
		rects.add(buildings2ChangeColorRect515);
		rects.add(buildings2ChangeColorRect516);
		rects.add(buildings2ChangeColorRect517);
		rects.add(buildings2ChangeColorRect518);
		rects.add(buildings2ChangeColorRect519);
		rects.add(buildings2ChangeColorRect520);
		rects.add(buildings2ChangeColorRect521);


		endingBlockSwitch+=1;
		}
		if(endingBlockSwitch==30) {
		endingBlockSwitch=0;
		}

	
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
		
		if(finished==false)
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
		if(finished==false)
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
			rects.add(new ColorfulRectangle(movex+1000,movey+-650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+200,movey+-800, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+0,movey+800, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+600,movey+650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+-450,movey+-550, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+850,movey+-650, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+850,movey+-600, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+850,movey+-550, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+900,movey+-500, 50, 50, Color.DARK_GRAY));
			rects.add(new ColorfulRectangle(movex+950,movey+-500, 50, 50, Color.DARK_GRAY));



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

		rects.add(new ColorfulRectangle(movex+-2300,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2350,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2350,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2300,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2250,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2200,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2150,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2100,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2050,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-2000,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1950,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1900,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1850,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1800,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1750,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1700,movey+-1150, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(movex+-550,movey+-850, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(movex+900,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1950,movey+-1150, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(movex+1000,movey+-650, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-500,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-450,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1650,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1600,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1550,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1450,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1400,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1300,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-1350,movey+-1050, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+-1350,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+300,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+600,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+550,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+650,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+700,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+750,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1000,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+950,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1300,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+-900, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+850,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+850,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+200,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+100,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+0,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-100,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-200,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+-1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+-300,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+0,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1100,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+-1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1200,movey+-650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+-600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+-250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-250, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(movex+1900,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+-50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+0, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+50, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+-100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1350,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1150,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1250,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+500, 50, 50, Color.WHITE));
		
		rects.add(new ColorfulRectangle(movex+1400,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1450,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+500, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+700, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+650, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+600, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+550, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+950, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+900, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+850, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+800, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+750, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1400,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1500,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1550,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1600,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1650,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+1100, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+1050, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+1000, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+950, 50, 50, Color.WHITE));

		rects.add(new ColorfulRectangle(movex+1900,movey+1150, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+1200, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+1250, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1800,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+1300, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1750,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1700,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+1350, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1850,movey+1400, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+1900,movey+-450, 50, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(movex+400,movey+-1150, 50, 50, Color.WHITE));



		
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
				
				collectedKeys-=1;
				collectedPinkKeys-=1;
				collectedOrangeKeys-=1;
				collectedBlueKeys-=1;

				
				//shoot=1;

				//rects.clear();

			}else if (keyCode == CONTROL) {
				
				finished=true;
				totalYellowKeyCollected=7;
				totalPinkKeyCollected=5;
				totalOrangeKeyCollected=5;
				totalBlueKeyCollected=5;
				
				movex=50;
				movey=-600;
				collectedEndingKeys=2;
				
				wall1=false;
				wall2=false;
				
				door1.x=10000;
				door2.x=10000;
				door3.x=10000;
				door4.x=10000;
				door5.x=10000;
				door6.x=10000;
				door7.x=10000;

				pinkdoor1.x=10000;
				pinkdoor2.x=10000;
				pinkdoor3.x=10000;
				pinkdoor4.x=10000;
				pinkdoor5.x=10000;

				orangedoor1.x=10000;
				orangedoor2.x=10000;
				orangedoor3.x=10000;
				orangedoor4.x=10000;
				orangedoor5.x=10000;

				bluedoor1.x=10000;
				bluedoor2.x=10000;
				bluedoor3.x=10000;
				bluedoor4.x=10000;
				bluedoor5.x=10000;
				
				
				key1.x=10000;
				key2.x=10000;
				key3.x=10000;
				key4.x=10000;
				key5.x=10000;
				key6.x=10000;
				key7.x=10000;

				pinkkey1.x=10000;
				pinkkey2.x=10000;
				pinkkey3.x=10000;
				pinkkey4.x=10000;
				pinkkey5.x=10000;

				orangekey1.x=10000;
				orangekey2.x=10000;
				orangekey3.x=10000;
				orangekey4.x=10000;
				orangekey5.x=10000;

				bluekey1.x=10000;
				bluekey2.x=10000;
				bluekey3.x=10000;
				bluekey4.x=10000;
				bluekey5.x=10000;


				
			}
		}

	}





	public void mousePressed() {


		int moX = ((mouseX/50)*50)+-movex;
		int moY = ((mouseY/50)*50)+-movey;

		//System.out.println("X:" + moX + "   Y:" + moY);

		//System.out.println("rects.add(new ColorfulRectangle("+ "movex+"+ moX +",movey+" + moY + ", 50, 50, Color.DARK_GRAY));");
		System.out.println("rects.add(new ColorfulRectangle("+ "movex+"+ moX +",movey+" + moY + ", 50, 50, Color.MAGENTA));");
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
			
			totalYellowKeyCollected+=1;
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
			
			totalPinkKeyCollected+=1;
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
			
			totalOrangeKeyCollected+=1;
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
		
		if(x==player.x && y==player.y && collectedOrangeKeys>=1){
			collectedOrangeKeys-=1;
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

	class BlueKey extends ColorfulRectangle{

		int bluekeyx=x;
		int bluekeyy=y;
		

		boolean collected = false;

		public BlueKey(int x, int y, int width, int height) {

			super(x, y, width, height, Color.CYAN);

		}
		
		
		
		void draw() {
			

			if(!collected) {
				super.draw();
			}	
		}
		
		public void update() {
		
		x=bluekeyx+movex;
		y=bluekeyy+movey;
		
		if(x==player.x && y==player.y){
			collectedBlueKeys+=1;
			bluekeyx=-10000;
			bluekeyy=-10000;
			
			totalBlueKeyCollected+=1;
		}
		
		}

	}

	
	
	class BlueDoor extends ColorfulRectangle{

		int bluedoorx=x;
		int bluedoory=y;
		
		boolean open = false;

		public BlueDoor(int x, int y, int width, int height) {

			super(x, y, width, height, Color.WHITE);


		}
		
		
		void draw() {
			
			if(!open) {
				super.draw();
			}	
		}
		
		public void update() {
		
			ColorfulRectangle BlueDoorin = new ColorfulRectangle(x+10,y+10,30,30,Color.CYAN);
			BlueDoorin.draw();
			
		x=bluedoorx+movex;
		y=bluedoory+movey;
		
		if(x==player.x && y==player.y && collectedBlueKeys>=1){
			collectedBlueKeys-=1;
			bluedoorx=-10000;
			bluedoory=-10000;
			BlueDoorin.x=-10000;
			BlueDoorin.y=-10000;

		}else if(x==player.x && y==player.y && collectedBlueKeys==0){
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
	
	
	
	class Ending extends ColorfulRectangle{

		int endingx=x;
		int endingy=y;
		
		int colorSwitch = 0;

		
		boolean open = false;

		public Ending(int x, int y, int width, int height) {

			super(x, y, width, height, Color.BLACK);


		}
		
		
		void draw() {
			
			if(!open) {
				super.draw();
			}	
			
		}
		
		public void update() {
			
			x=endingx+movex;
			y=endingy+movey;
			
			
//			ColorfulRectangle Endingred = new ColorfulRectangle(x,y,50,50,Color.RED);
//			ColorfulRectangle Endingorange = new ColorfulRectangle(x,y,50,50,Color.ORANGE);
//			ColorfulRectangle Endingyellow = new ColorfulRectangle(x,y,50,50,Color.YELLOW);
//			ColorfulRectangle Endinggreen = new ColorfulRectangle(x,y,50,50,Color.GREEN);
//			ColorfulRectangle Endingblue = new ColorfulRectangle(x,y,50,50,Color.BLUE);
//			ColorfulRectangle Endingpurple = new ColorfulRectangle(x,y,50,50,Color.MAGENTA);
//			ColorfulRectangle Endinggray = new ColorfulRectangle(x,y,50,50,Color.LIGHT_GRAY);
//			ColorfulRectangle Endingwhite = new ColorfulRectangle(x,y,50,50,Color.WHITE);
			
			ColorfulRectangle Endingred = new ColorfulRectangle(x,y,50,50,Color.RED);
			ColorfulRectangle Endingorange = new ColorfulRectangle(x+2,y+2,45,45,Color.ORANGE);
			ColorfulRectangle Endingyellow = new ColorfulRectangle(x+5,y+5,40,40,Color.YELLOW);
			ColorfulRectangle Endinggreen = new ColorfulRectangle(x+7,y+7,35,35,Color.GREEN);
			ColorfulRectangle Endingblue = new ColorfulRectangle(x+10,y+10,30,30,Color.BLUE);
			ColorfulRectangle Endingpurple = new ColorfulRectangle(x+12,y+12,25,25,Color.MAGENTA);
			ColorfulRectangle Endinggray = new ColorfulRectangle(x+15,y+15,20,20,Color.LIGHT_GRAY);
			ColorfulRectangle Endingwhite = new ColorfulRectangle(x+17,y+17,15,15,Color.WHITE);


			if(colorSwitch==0) {
			Endingred.draw();
			}else if(colorSwitch==1) {
			Endingorange.draw();
			}else if(colorSwitch==2) {
			Endingyellow.draw();
			}else if(colorSwitch==3) {
			Endinggreen.draw();
			}else if(colorSwitch==4) {
			Endingblue.draw();
			}else if(colorSwitch==5) {
			Endingpurple.draw();
			}else if(colorSwitch==6) {
			Endinggray.draw();
			}else if(colorSwitch==7) {
			Endingwhite.draw();
			}
			
			colorSwitch+=1;
			
			if(colorSwitch>=8) {
				colorSwitch=0;
			}
			
		 if(x==player.x && y==player.y){
			 
			
		}
		
		}

	}

	
	
	class Endingdoor extends ColorfulRectangle{

		int endingdoorx=x;
		int endingdoory=y;
		
		boolean open = false;

		public Endingdoor(int x, int y, int width, int height) {

			super(x, y, width, height, Color.WHITE);


		}
		
		
		void draw() {
			
			if(!open) {
				super.draw();
			}	
		}
		
		public void update() {
			
			ColorfulRectangle Endingred = new ColorfulRectangle(x+10,y+10,30,30,Color.RED);
			ColorfulRectangle Endingorange = new ColorfulRectangle(x+10,y+10,30,30,Color.ORANGE);
			ColorfulRectangle Endingyellow = new ColorfulRectangle(x+10,y+10,30,30,Color.YELLOW);
			ColorfulRectangle Endinggreen = new ColorfulRectangle(x+10,y+10,30,30,Color.GREEN);
			ColorfulRectangle Endingblue = new ColorfulRectangle(x+10,y+10,30,30,Color.BLUE);
			ColorfulRectangle Endingpurple = new ColorfulRectangle(x+10,y+10,30,30,Color.MAGENTA);
			ColorfulRectangle Endinggray = new ColorfulRectangle(x+10,y+10,30,30,Color.LIGHT_GRAY);
			ColorfulRectangle Endingwhite = new ColorfulRectangle(x+10,y+10,30,30,Color.WHITE);


			if(colorSwitchdoor==0) {
			Endingred.draw();
			}else if(colorSwitchdoor==1) {
			Endingorange.draw();
			}else if(colorSwitchdoor==2) {
			Endingyellow.draw();
			}else if(colorSwitchdoor==3) {
			Endinggreen.draw();
			}else if(colorSwitchdoor==4) {
			Endingblue.draw();
			}else if(colorSwitchdoor==5) {
			Endingpurple.draw();
			}else if(colorSwitchdoor==6) {
			Endinggray.draw();
			}else if(colorSwitchdoor==7) {
			Endingwhite.draw();
			}
			
			colorSwitchdoor+=1;
			
			if(colorSwitchdoor>=8) {
				colorSwitchdoor=0;
			}
					
		x=endingdoorx+movex;
		y=endingdoory+movey;
		
		if(x==player.x && y==player.y && collectedEndingKeys>=1){
			collectedEndingKeys-=1;
			endingdoorx=-10000;
			endingdoory=-10000;
			Endingred.x=-10000;
			Endingorange.x=-10000;
			Endingyellow.x=-10000;
			Endinggreen.x=-10000;
			Endingblue.x=-10000;
			Endingpurple.x=-10000;
			Endinggray.x=-10000;
			Endingwhite.x=-10000;


		}else if(x==player.x && y==player.y && collectedEndingKeys==0){
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
