

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
	
	
	int createx = 0;
	int createy = 0;
	int createBuilding = 4;

	
	int collectedKeys = 0;
	
	
	
	ColorfulRectangle player = new ColorfulRectangle(350,250,50,50,Color.BLUE);

	List<Rectangle> rects = new ArrayList<Rectangle>();
	List<Rectangle> elips = new ArrayList<Rectangle>();
	
	List<Enemy> enemies = new ArrayList<Enemy>();


	Enemy emeny = new Enemy(100,250,50,50);
	Enemy emeny2 = new Enemy(0,-250,50,50);
	Enemy emeny3 = new Enemy(-100,500,50,50);

	
	
	ColorfulRectangle enemy = new ColorfulRectangle(100,250,50,50,Color.RED);
	ColorfulRectangle enemy2 = new ColorfulRectangle(0,-250,50,50, Color.RED);
	ColorfulRectangle enemy3 = new ColorfulRectangle(-100,500,50,50, Color.RED);

	
	ColorfulRectangle playerup = new ColorfulRectangle(enemy.x,enemy.y-50,10,10,Color.BLUE);
	ColorfulRectangle playerdown = new ColorfulRectangle(enemy.x,enemy.y+50,10,10, Color.BLUE);
	ColorfulRectangle playerleft = new ColorfulRectangle(enemy.x-50,enemy.y,10,10, Color.BLUE);
	ColorfulRectangle playerright = new ColorfulRectangle(enemy.x+50,enemy.y,10,10, Color.BLUE);

	
	ColorfulRectangle enemy1up = new ColorfulRectangle(enemy.x,enemy.y-50,10,10,Color.RED);
	ColorfulRectangle enemy1down = new ColorfulRectangle(enemy.x,enemy.y+50,10,10, Color.RED);
	ColorfulRectangle enemy1left = new ColorfulRectangle(enemy.x-50,enemy.y,10,10, Color.RED);
	ColorfulRectangle enemy1right = new ColorfulRectangle(enemy.x+50,enemy.y,10,10, Color.RED);

	
	ColorfulRectangle enemy2up = new ColorfulRectangle(enemy2.x,enemy2.y-50,10,10,Color.RED);
	ColorfulRectangle enemy2down = new ColorfulRectangle(enemy2.x,enemy2.y+50,10,10, Color.RED);
	ColorfulRectangle enemy2left = new ColorfulRectangle(enemy2.x-50,enemy2.y,10,10, Color.RED);
	ColorfulRectangle enemy2right = new ColorfulRectangle(enemy2.x+50,enemy2.y,10,10, Color.RED);
	
	
	ColorfulRectangle enemy3up = new ColorfulRectangle(enemy3.x,enemy3.y-50,10,10,Color.RED);
	ColorfulRectangle enemy3down = new ColorfulRectangle(enemy3.x,enemy3.y+50,10,10, Color.RED);
	ColorfulRectangle enemy3left = new ColorfulRectangle(enemy3.x-50,enemy3.y,10,10, Color.RED);
	ColorfulRectangle enemy3right = new ColorfulRectangle(enemy3.x+50,enemy3.y,10,10, Color.RED);
	
	
	
	
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
	
	boolean enemy1moved = false;
	
	
	boolean wall1 = true;
	
	boolean spookydead = false;
	
	int wall1buttonx = 500;
	int wall1buttony = -150;
	
	int yellowdoor1x = 350;
	int yellowdoor1inx = 360;

	int key1x = 500;
	int key1y = -500;
	
	int key2x = -800;
	int key2y = 550;
	
	int key3x = -300;
	int key3y = -550;

	int waitTime = 25;
	
	
	String enemy1upDisplay = "";
	String enemy1downDisplay = "";
	String enemy1leftDisplay = "";
	String enemy1rightDisplay = "";
	
	String enemy2upDisplay = "";
	String enemy2downDisplay = "";
	String enemy2leftDisplay = "";
	String enemy2rightDisplay = "";
	
	String enemy3upDisplay = "";
	String enemy3downDisplay = "";
	String enemy3leftDisplay = "";
	String enemy3rightDisplay = "";

	//List<Rectangle> enemy = new ArrayList<Rectangle>();

	
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


		enemymovex=100;
		enemymovey=250;
		
		enemy2movex=0;
		enemy2movey=-250;
		
		enemy3movex=-300;
		enemy3movey=150;

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

		
		enemies.add(emeny);
		enemies.add(emeny2);
		enemies.add(emeny3);


		//fill(255,0,0);
		//enemy.add(new Rectangle(500, 500, 50, 50 ));
		//fill(255,255,255);


		emliv = true;
		emliv2 = true;
		emliv3 = true;

		

		
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

		
		for(Enemy e : enemies) {
			e.draw();
			e.update();
			
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
		
		
		
		
		//draw

		if(build==false){
		rects.clear();
		}	

	
		buildings();
		
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
		
		
		
		ColorfulRectangle yellowdoor1 = new ColorfulRectangle(movex+yellowdoor1x,movey+-450, 50, 50, Color.WHITE);
		ColorfulRectangle yellowdoor1in = new ColorfulRectangle(movex+yellowdoor1inx,movey+-440, 30, 30, Color.YELLOW);

		yellowdoor1.draw();
		yellowdoor1in.draw();

		if(player.x==yellowdoor1.x && player.y==yellowdoor1.y) {
			if(collectedKeys==0) {
					if(facing==1) {
					movey+=50;
					}		
					if(facing==2) {
					movey-=50;
					}
					if(facing==3) {
					movex-=50;
					}
					if(facing==4) {
					movex+=50;
					}
			}else {
			collectedKeys-=1;
			yellowdoor1x=10000;
			yellowdoor1inx=10000;
			}
		}

		
		
		ColorfulRectangle wall1button = new ColorfulRectangle(movex+wall1buttonx,movey+wall1buttony,50,50, Color.GREEN);
		if(player.x==wall1button.x && player.y==wall1button.y) {
			wall1=false;
			wall1buttonx=10000;
			wall1buttony=10000;
		}
		wall1button.draw();

		
		
		
		
		ColorfulRectangle displaykey = new ColorfulRectangle(660,10, 30, 30, Color.YELLOW);
		displaykey.draw();
		
		ColorfulRectangle key1 = new ColorfulRectangle(movex+key1x,movey+key1y, 50, 50, Color.YELLOW);
		key1.draw();
		
		ColorfulRectangle key2 = new ColorfulRectangle(movex+key2x,movey+key2y, 50, 50, Color.YELLOW);
		key2.draw();
		
		ColorfulRectangle key3 = new ColorfulRectangle(movex+key3x,movey+key3y, 50, 50, Color.YELLOW);
		key3.draw();

		
		if(player.x==key1.x && player.y==key1.y) {
			collectedKeys+=1;
			key1x=10000;
			key1y=10000;
		}
		if(player.x==key2.x && player.y==key2.y) {
			collectedKeys+=1;
			key2x=10000;
			key2y=10000;
		}
		if(player.x==key3.x && player.y==key3.y) {
			collectedKeys+=1;
			key3x=10000;
			key3y=10000;
		}

		
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
		}
		
		
		
		/*
		if(enemy1upInterectsBlock()==false) {
			enemy1upDisplay = "Yes";
		}else {
			enemy1upDisplay = "";
		}
		if(enemy1downInterectsBlock()==false) {
			enemy1downDisplay = "Yes";
		}else {
			enemy1downDisplay = "";
		}
		if(enemy1leftInterectsBlock()==false) {
			enemy1leftDisplay = "Yes";
		}else {
			enemy1leftDisplay = "";
		}
		if(enemy1rightInterectsBlock()==false) {
			enemy1rightDisplay = "Yes";
		}else {
			enemy1rightDisplay = "";
		}
		
		
		if(enemy2upInterectsBlock()==false) {
			enemy2upDisplay = "Yes";
		}else {
			enemy2upDisplay = "";
		}
		if(enemy2downInterectsBlock()==false) {
			enemy2downDisplay = "Yes";
		}else {
			enemy2downDisplay = "";
		}
		if(enemy2leftInterectsBlock()==false) {
			enemy2leftDisplay = "Yes";
		}else {
			enemy2leftDisplay = "";
		}
		if(enemy2rightInterectsBlock()==false) {
			enemy2rightDisplay = "Yes";
		}else {
			enemy2rightDisplay = "";
		}
		
		
		if(enemy3upInterectsBlock()==false) {
			enemy3upDisplay = "Yes";
		}else {
			enemy3upDisplay = "";
		}
		if(enemy3downInterectsBlock()==false) {
			enemy3downDisplay = "Yes";
		}else {
			enemy3downDisplay = "";
		}
		if(enemy3leftInterectsBlock()==false) {
			enemy3leftDisplay = "Yes";
		}else {
			enemy3leftDisplay = "";
		}
		if(enemy3rightInterectsBlock()==false) {
			enemy3rightDisplay = "Yes";
		}else {
			enemy3rightDisplay = "";
		}
		*/
		
		//System.out.println("up:" + enemy1upDisplay + "    down:" + enemy1downDisplay + "      left:"  + enemy1leftDisplay + "     right:"   + enemy1rightDisplay);
		//System.out.println("up:" + enemy2upDisplay + "    down:" + enemy2downDisplay + "      left:"  + enemy2leftDisplay + "     right:"   + enemy2rightDisplay);

//		enemy1upInterectsBlock();
//		enemy1downInterectsBlock();
//		enemy1leftInterectsBlock();
//		enemy1rightInterectsBlock();
		
		//frameRate(1);
		
		if(enemymove == true) {
					
		wait+=1;
		
		if(wait>=waitTime) {
			wait=0;


			if(enemy1downInterectsBlock()==true && enemy1rightInterectsBlock()==true && enemy1leftInterectsBlock()==true) {
				enemyfacing1=1;
			}
			if(enemy1upInterectsBlock()==true && enemy1rightInterectsBlock()==true && enemy1leftInterectsBlock()==true) {
				enemyfacing1=2;
			}
			if(enemy1upInterectsBlock()==true && enemy1downInterectsBlock()==true && enemy1leftInterectsBlock()==true) {
				enemyfacing1=3;
			}
			if(enemy1upInterectsBlock()==true && enemy1downInterectsBlock()==true && enemy1rightInterectsBlock()==true) {
				enemyfacing1=4;
			}
			
			if(enemy2downInterectsBlock()==true && enemy2rightInterectsBlock()==true && enemy2leftInterectsBlock()==true) {
				enemyfacing2=1;
			}
			if(enemy2upInterectsBlock()==true && enemy2rightInterectsBlock()==true && enemy2leftInterectsBlock()==true) {
				enemyfacing2=2;
			}
			if(enemy2upInterectsBlock()==true && enemy2downInterectsBlock()==true && enemy2leftInterectsBlock()==true) {
				enemyfacing2=3;
			}
			if(enemy2upInterectsBlock()==true && enemy2downInterectsBlock()==true && enemy2rightInterectsBlock()==true) {
				enemyfacing2=4;
			}
			
			if(enemy3downInterectsBlock()==true && enemy3rightInterectsBlock()==true && enemy3leftInterectsBlock()==true) {
				enemyfacing3=1;
			}
			if(enemy3upInterectsBlock()==true && enemy3rightInterectsBlock()==true && enemy3leftInterectsBlock()==true) {
				enemyfacing3=2;
			}
			if(enemy3upInterectsBlock()==true && enemy3downInterectsBlock()==true && enemy3leftInterectsBlock()==true) {
				enemyfacing3=3;
			}
			if(enemy3upInterectsBlock()==true && enemy3downInterectsBlock()==true && enemy3rightInterectsBlock()==true) {
				enemyfacing3=4;
			}
			
			
			
			
		if(enemymove1 == true) {
			for (int i = 0; i < 100; i++) {
				enemyRandomMove1 = new Random().nextInt(4);
				
				if(enemyfacing1!=2) {
				if(enemy1upInterectsBlock()==false) {
			if(enemyRandomMove1==0) {
				enemymovey-=50;
				enemyfacing1=1;
				//System.out.println("UP  " + enemy1upInterectsBlock());
				break;
			}
		}
				}
				if(enemyfacing1!=1) {
				if(enemy1downInterectsBlock()==false) {
			 if(enemyRandomMove1==1) {
				enemymovey+=50;
				enemyfacing1=2;	
				//System.out.println("DOWN  " + enemy1downInterectsBlock());
				break;
			}
		}
				}
				if(enemyfacing1!=4) {
				if(enemy1rightInterectsBlock()==false) {
			if(enemyRandomMove1==2) {
				enemymovex+=50;
				enemyfacing1=3;
				//System.out.println("RIGHT  " + enemy1rightInterectsBlock());
				break;
			}
		}
				}
				if(enemyfacing1!=3) {
				if(enemy1leftInterectsBlock()==false) {
				if(enemyRandomMove1==3) {
				enemymovex-=50;
				enemyfacing1=4;
				//System.out.println("LEFT  " + enemy1leftInterectsBlock());
				break;
				}
		}
				}
				
			}
			
		}
		
		

		if(enemymove2 == true) {
			for (int i = 0; i < 100; i++) {
				enemyRandomMove2 = new Random().nextInt(4);

				if(enemyfacing2!=2) {
				if(enemy2upInterectsBlock()==false) {
			if(enemyRandomMove2==0) {
				enemy2movey-=50;
				enemyfacing2=1;
				break;
			}
		}
				}
				if(enemyfacing2!=1) {
				if(enemy2downInterectsBlock()==false) {
			 if(enemyRandomMove2==1) {
				enemy2movey+=50;
				enemyfacing2=2;	
				break;
			}
		}
				}
				if(enemyfacing2!=4) {
				if(enemy2rightInterectsBlock()==false) {
			if(enemyRandomMove2==2) {
				enemy2movex+=50;
				enemyfacing2=3;
				break;
			}
		}
				}
				if(enemyfacing2!=3) {
				if(enemy2leftInterectsBlock()==false) {
				if(enemyRandomMove2==3) {
				enemy2movex-=50;
				enemyfacing2=4;
				break;
				}
		}
				}
				
			}
			
		}
		
		
		if(enemymove3== true) {
			for (int i = 0; i < 100; i++) {
				enemyRandomMove3 = new Random().nextInt(4);

				if(enemyfacing3!=2) {
				if(enemy3upInterectsBlock()==false) {
			if(enemyRandomMove3==0) {
				enemy3movey-=50;
				enemyfacing3=1;
				break;
			}
		}
				}
				if(enemyfacing3!=1) {
				if(enemy3downInterectsBlock()==false) {
			 if(enemyRandomMove3==1) {
				enemy3movey+=50;
				enemyfacing3=2;	
				break;
			}
		}
				}
				if(enemyfacing3!=4) {
				if(enemy3rightInterectsBlock()==false) {
			if(enemyRandomMove3==2) {
				enemy3movex+=50;
				enemyfacing3=3;
				break;
			}
		}
				}
				if(enemyfacing3!=3) {
				if(enemy3leftInterectsBlock()==false) {
				if(enemyRandomMove3==3) {
				enemy3movex-=50;
				enemyfacing3=4;
				break;
				}
		}
				}
				
			}
			
		}

		}
		}
		
		
		
		
		if(enemyInterectsBlock()) {
			if(enemyfacing1==1) {
			enemymovey+=50;
			}		
			
			if(enemyfacing1==2) {
			enemymovey-=50;
			}
			
			if(enemyfacing1==3) {
			enemymovex-=50;
			}
			
			if(enemyfacing1==4) {
			enemymovex+=50;
			}
		}
		
		if(enemy2InterectsBlock()) {
			if(enemyfacing2==1) {
			enemy2movey+=50;
			}		
			
			if(enemyfacing2==2) {
			enemy2movey-=50;
			}
			
			if(enemyfacing2==3) {
			enemy2movex-=50;
			}
			
			if(enemyfacing2==4) {
			enemy2movex+=50;
			}
		}
		
		if(enemy3InterectsBlock()) {
			if(enemyfacing3==1) {
			enemy3movey+=50;
			}		
			
			if(enemyfacing3==2) {
			enemy3movey-=50;
			}
			
			if(enemyfacing3==3) {
			enemy3movex-=50;
			}
			
			if(enemyfacing3==4) {
			enemy3movex+=50;
			}
		}
		


		
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
		
		
		//System.out.println(movingblockInterectsBlock());

		//if()
		

		//if(numOfKeys==goalOfKeys) {
		//	doorlocked=1;
		//}

		//door
		//System.out.println(doorlocked);

		
		
		
		//SHOOTING
		/*
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
		
		bullet.draw();
		 */

		//		if (btv1.x==enemy.x && btv1.y==enemy.y || btv2.x==enemy.x && btv2.y==enemy.y || bth1.x==enemy.x && bth1.y==enemy.y || bth2.x==enemy.x && bth2.y==enemy.y){
		//			emliv=0;
		//		}

		
		
		//System.out.println(firemove);
		//System.out.println(firelit);

		


		//rect(enemy.x, enemy.y, enemy.width, enemy.height   ); // Draw enemy

		//Kill enemy
		
		/*ATTACK
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
		 */
		
		//		if(shoot==1) {        	
		//		if(bullet.x==enemy.x && bullet.y==enemy.y){
		//			emliv=0;
		//			}
		//		}

		/*
		//Attack
		if(att==1) {
			attx = player.x-50;
			atty = player.y-50;

			fill(0,0,255);
			rect(player.x-50, player.y-50, 150, 150);
			//fill(255,255,255);
			att=0;
		}
		 */
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


		//        brdx = 250;
		//        brdy = 250;
		//        rect(brdx,brdy,50,50);
	
		
		
		if(spooky==true) {
			waitTime = 3;
			
			ColorfulRectangle spooky1 = new ColorfulRectangle(0,0,800,150,Color.BLACK);
			ColorfulRectangle spooky2 = new ColorfulRectangle(0,0,250,600,Color.BLACK);
			ColorfulRectangle spooky3 = new ColorfulRectangle(500,0,300,600,Color.BLACK);
			ColorfulRectangle spooky4 = new ColorfulRectangle(0,400,800,200,Color.BLACK);

			spooky1.draw();
			spooky2.draw();
			spooky3.draw();
			spooky4.draw();
			
			if(enemy.x==player.x && enemy.y==player.y || enemy2.x==player.x && enemy2.y==player.y || enemy3.x==player.x && enemy3.y==player.y) {
				spookydead = true;
			}
			if(spookydead==true) {
				ColorfulRectangle jumpscare = new ColorfulRectangle(0,0,800,600,Color.red);
				jumpscare.draw();
			}
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
		rects.add(new ColorfulRectangle(movex+-850,movey+650, 50, 50, Color.WHITE));
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
		
		
		int marker2;
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

	
	
	boolean enemy1upInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy1up)){
					return true;
				}
		}
		return false;
	}
	
	boolean enemy1downInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy1down)){
					return true;
			}
		}
		return false;
	}

	boolean enemy1leftInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy1left)){
					return true;
			}
		}
		return false;
	}

	boolean enemy1rightInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy1right)){
					return true;
				}
		}
		return false;
	}

	
	boolean enemy2upInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy2up)){
					return true;
				}
		}
		return false;
	}
	
	boolean enemy2downInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy2down)){
					return true;
			}
		}
		return false;
	}

	boolean enemy2leftInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy2left)){
					return true;
			}
		}
		return false;
	}

	boolean enemy2rightInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy2right)){
					return true;
				}
		}
		return false;
	}

	boolean enemy3upInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy3up)){
					return true;
				}
		}
		return false;
	}
	
	boolean enemy3downInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy3down)){
					return true;
			}
		}
		return false;
	}

	boolean enemy3leftInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy3left)){
					return true;
			}
		}
		return false;
	}

	boolean enemy3rightInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(enemy3right)){
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
		
		boolean intersectsRects() {
			for(Rectangle r: rects) {
				for(ColorfulRectangle d : direction)
				if( r.intersects(d)){
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
				
				x=movex+enemymovex;
				y=movey+enemymovey;

		}

	}

	}
