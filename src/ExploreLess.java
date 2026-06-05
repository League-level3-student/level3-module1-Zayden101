 
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;

import javax.swing.JOptionPane;

import processing.core.PApplet;

//16/12 blocks

public class ExploreLess extends PApplet {
	static final int WIDTH = 800; //800
	static final int HEIGHT = 600; //600

	Color bgColor = new Color(0,0,0);
	Color EnemyBorderColor = new Color(0,0,0);
	Color bgColorOutline = new Color(0,0,0);
	Color enemyDifficultyOutline = new Color(0,0,0);
	
	
	Color grayYellow = new Color(200,200,200);
	Color grayPink = new Color(165,165,165);
	Color grayOrange = new Color(120,120,120);
	Color grayCyan = new Color(70,70,70);
	Color grayRed = new Color(185,185,185);
	Color grayGreen = new Color(95,95,95);
	Color grayBlue = new Color(150,150,150);
	Color grayMagenta = new Color(170,170,170);

	Color Yellow = new Color(255,255,0);
	Color Pink = new Color(255,180,200);
	Color Orange = new Color(255,165,0);
	Color Cyan = new Color(0,255,255);
	Color Red = new Color(255,0,0);
	Color Green = new Color(0,255,0);
	Color Blue = new Color(0,0,255);
	Color Magenta = new Color(255,0,255);
	Color Black = new Color(0,0,0);

	//int bgColor = color(31, 0, 48);

	int value = 0;

	int x1 = 0;
	int y1 = 0;
	
	int facing;

	int movex = 0;
	int movey = 0;

	Integer collectedKeys = 0;
	Integer collectedPinkKeys = 0;
	Integer collectedOrangeKeys = 0;
	Integer collectedBlueKeys = 0;
	Integer collectedEndingKeys = 0;
	Integer collectedBlackKeys = 0;
	Integer collectedPurpleKeys = 0;
	
	KeyCount yellowKeyCount = new KeyCount();
	KeyCount pinkKeyCount = new KeyCount();
	KeyCount orangeKeyCount = new KeyCount();
	KeyCount blueKeyCount = new KeyCount();
	KeyCount endingKeyCount = new KeyCount();
	KeyCount blackKeyCount = new KeyCount();
	KeyCount purpleKeyCount = new KeyCount();

	int totalYellowKeyCollected = 0;
	int totalPinkKeyCollected = 0;
	int totalOrangeKeyCollected = 0;
	int totalBlueKeyCollected = 0;
	int totalEndingKeyCollected = 0;
	int totalBlackKeyCollected = 0;
	int totalPurpleKeyCollected = 0;

	int colorSwitch2 = 0;
	int colorSwitchdoor = 0;

	boolean secret = false;
	boolean finished = false;
	boolean displayEndingkey = false;
	

	int endingBlockSwitch = 0;

	ColorfulRectangle player = new ColorfulRectangle(350,250,50,50,Blue,grayBlue);
	//ColorfulRectangle player = new ColorfulRectangle(850,500,50,50,Color.BLUE);

	List<Rectangle> rects = new ArrayList<Rectangle>();
	
	List<Rectangle> enemyBorder = new ArrayList<Rectangle>();
	
	List<Key> keys = new ArrayList<Key>();
	
	List<Door> doors = new ArrayList<Door>();

		
	Enemy emeny = new Enemy(100,250,50,50);
	Enemy emeny2 = new Enemy(-1300,-150,50,50);
	Enemy emeny3 = new Enemy(-2150,-100,50,50);

	ColorfulRectangle playerup = new ColorfulRectangle(player.x,player.y-50,10,10,Color.BLUE);
	ColorfulRectangle playerdown = new ColorfulRectangle(player.x,player.y+50,10,10, Color.BLUE);
	ColorfulRectangle playerleft = new ColorfulRectangle(player.x-50,player.y,10,10, Color.BLUE);
	ColorfulRectangle playerright = new ColorfulRectangle(player.x+50,player.y,10,10, Color.BLUE);

	int timer = 60;
	int timetrack = 80;
	
	boolean noDoubleClickOptions = true;

	boolean enemymove = true;

	boolean wall1 = true;
	boolean wall2 = true;

	int wall1buttonx = 500;
	int wall1buttony = -150;

	int wall2buttonx = -900;
	int wall2buttony = 900;
	
	int teleport1colorswitch = 0;
	int teleport2colorswitch = 0;
	int teleport3colorswitch = 0;

	boolean teleportavaible = true;

	
	Door door1 = new Door(movex+350,movey-450,50,50,Yellow,grayYellow);
	Door door2 = new Door(movex+-1000,movey+100,50,50,Yellow,grayYellow);
	Door door3 = new Door(movex+650,movey+500,50,50,Yellow,grayYellow);
	Door door4 = new Door(movex+800,movey+200,50,50,Yellow,grayYellow);
	Door door5 = new Door(movex+950,movey+250,50,50,Yellow,grayYellow);
	Door door6 = new Door(movex+0,movey+1250,50,50,Yellow,grayYellow);
	Door door7 = new Door(movex-1500,movey+350,50,50,Yellow,grayYellow);

	Door pinkdoor1 = new Door(movex-850,movey+800,50,50,Pink,grayPink);
	Door pinkdoor2 = new Door(movex-1000,movey-600,50,50,Pink,grayPink);
	Door pinkdoor3 = new Door(movex-1550,movey+350,50,50,Pink,grayPink);
	Door pinkdoor4 = new Door(movex-600,movey-850,50,50,Pink,grayPink);
	Door pinkdoor5 = new Door(movex+1750,movey-300,50,50,Pink,grayPink);

	Door orangedoor1 = new Door(movex+150,movey+1350,50,50,Orange,grayOrange);
	Door orangedoor2 = new Door(movex-850,movey-800,50,50,Orange,grayOrange);
	Door orangedoor3 = new Door(movex+1000,movey-600,50,50,Orange,grayOrange);
	Door orangedoor4 = new Door(movex-1700,movey-800,50,50,Orange,grayOrange);
	Door orangedoor5 = new Door(movex+1450,movey+1350,50,50,Orange,grayOrange);

	Door bluedoor1 = new Door(movex-2150,movey-1050,50,50,Cyan,grayCyan);
	Door bluedoor2 = new Door(movex-2200,movey-1150,50,50,Cyan,grayCyan);
	Door bluedoor3 = new Door(movex-2350,movey-800,50,50,Cyan,grayCyan);
	Door bluedoor4 = new Door(movex-1900,movey-1150,50,50,Cyan,grayCyan);
	Door bluedoor5 = new Door(movex-1800,movey-800,50,50,Cyan,grayCyan);

	Endingdoor endingdoor1 = new Endingdoor(movex+451,movey-1199,49,49);
	Endingdoor endingdoor2 = new Endingdoor(movex+400,movey+1050,50,50);

	Door blackdoor1 = new Door(movex+1950,movey+850,50,50,Black,Black);
	Door blackdoor2 = new Door(movex-1500,movey-1200,50,50,Black,Black);
	Door blackdoor3 = new Door(movex-1850,movey+1350,50,50,Black,Black);
	Door blackdoor4 = new Door(movex+950,movey+1450,50,50,Black,Black);

	Door purpledoor = new Door(movex-950,movey+1150,50,50,Magenta,grayMagenta);

	Key key1 = new Key(movex+500,movey-500,50,50,Yellow,grayYellow);
	Key key2a = new Key(movex-800,movey+550,50,50,Yellow,grayYellow); //Used in 0,2
	Key key2b = new Key(movex-100,movey+500,50,50,Yellow,grayYellow); //Used in 1
	Key key3a = new Key(movex-300,movey-550,50,50,Yellow,grayYellow); //Used in 0
	Key key3b = new Key(movex-650,movey-250,50,50,Yellow,grayYellow);  //Used in 1
	Key key3c = new Key(movex+200,movey+100,50,50,Yellow,grayYellow);  //Used in 2
	Key key4 = new Key(movex-350,movey+850,50,50,Yellow,grayYellow);
	Key key5a = new Key(movex+150,movey+500,50,50,Yellow,grayYellow); //Used in 0
	Key key5b = new Key(movex-1100,movey+100,50,50,Yellow,grayYellow); //Used in 1
	Key key5c = new Key(movex-1300,movey-350,50,50,Yellow,grayYellow); //Used in 2
	Key key6 = new Key(movex-2250,movey-400,50,50,Yellow,grayYellow);
	Key key7 = new Key(movex-100,movey-1050,50,50,Yellow,grayYellow);

	Key pinkkey1 = new Key(movex+1000,movey+550,50,50,Pink,grayPink);
	Key pinkkey2a = new Key(movex+800,movey+1250,50,50,Pink,grayPink);
	Key pinkkey2b = new Key(movex+750,movey-750,50,50,Pink,grayPink);
	Key pinkkey3a = new Key(movex-2150,movey+100,50,50,Pink,grayPink);
	Key pinkkey3b = new Key(movex-1850,movey-100,50,50,Pink,grayPink);
	Key pinkkey4 = new Key(movex-800,movey-1150,50,50,Pink,grayPink);
	Key pinkkey5 = new Key(movex+-100,movey+1100,50,50,Pink,grayPink);

	Key orangekey1 = new Key(movex-1300,movey-450,50,50,Orange,grayOrange);
	Key orangekey2 = new Key(movex+1200,movey+150,50,50,Orange,grayOrange);
	Key orangekey3 = new Key(movex-2000,movey+600,50,50,Orange,grayOrange);
	Key orangekey4 = new Key(movex-1550,movey+450,50,50,Orange,grayOrange);
	Key orangekey5 = new Key(movex+1450,movey-150,50,50,Orange,grayOrange);
	
	Key bluekey1 = new Key(movex-750,movey-850,50,50,Cyan,grayCyan);
	Key bluekey2 = new Key(movex+100,movey+1200,50,50,Cyan,grayCyan);
	Key bluekey3 = new Key(movex+1900,movey+1250,50,50,Cyan,grayCyan);
	Key bluekey4 = new Key(movex+1650,movey-400,50,50,Cyan,grayCyan);
	Key bluekey5a = new Key(movex+1800,movey-950,50,50,Cyan,grayCyan);
	Key bluekey5b = new Key(movex+1750,movey-700,50,50,Cyan,grayCyan);

	Key blackkey1 = new Key(movex-2250,movey+1400,5,5,Black,Black);
	Key blackkey2 = new Key(movex+1350,movey-350,5,5,Black,Black);
	Key blackkey3 = new Key(movex+450,movey-800,5,5,Black,Black);
	Key blackkey4 = new Key(movex+700,movey+1050,5,5,Black,Black);
	ColorfulRectangle blackkeydisplay1 = new ColorfulRectangle(movex-2228,movey+1422,5,5,Color.white);
	ColorfulRectangle blackkeydisplay2 = new ColorfulRectangle(movex+1372,movey-328,5,5,Color.white);
	ColorfulRectangle blackkeydisplay3 = new ColorfulRectangle(movex+472,movey-778,5,5,Color.white);
	ColorfulRectangle blackkeydisplay4 = new ColorfulRectangle(movex+722,movey+1072,5,5,Color.white);
	int blackkeydisplay1x = -2228;
	int blackkeydisplay2x = 1372;
	int blackkeydisplay3x = 472;
	int blackkeydisplay4x = 722;

	Key purplekey = new Key(movex-1500,movey-1100,50,50,Magenta,grayMagenta);

	Ending Ending = new Ending(movex-2350,movey-1150,50,50);
	SecretEnding SecretEnding = new SecretEnding(movex+750,movey-100,50,50);

	Random randon = new Random();
	
	SecretTeleport st1 = new SecretTeleport(movex-850,movey+1250,50,50);
	SecretTeleport st2 = new SecretTeleport(movex-1350,movey+350,50,50);
	SecretTeleport st3 = new SecretTeleport(movex-2150,movey-100,50,50);
	SecretTeleport st4 = new SecretTeleport(movex-2050,movey-100,50,50);
	SecretTeleport st5 = new SecretTeleport(movex-350,movey+1000,50,50);
	SecretTeleport st6 = new SecretTeleport(movex+1400,movey+500,50,50);
	SecretTeleport st7 = new SecretTeleport(movex-1650,movey+1150,50,50);
	SecretTeleport st8 = new SecretTeleport(movex-1450,movey+1150,50,50);
	SecretTeleport st9 = new SecretTeleport(movex+1150,movey-350,50,50);
	SecretTeleport st10 = new SecretTeleport(movex-1750,movey-550,50,50);
	SecretTeleport st11 = new SecretTeleport(movex-1850,movey-450,50,50);
	SecretTeleport st12 = new SecretTeleport(movex+1150,movey-500,50,50);
	SecretTeleport st13 = new SecretTeleport(movex+750,movey-350,50,50);

	boolean key1collected = false;
	boolean key2collected = false;
	boolean key3collected = false;
	boolean key4collected = false;
	boolean key5collected = false;
	boolean key6collected = false;
	boolean key7collected = false;

	boolean pinkkey1collected = false;
	boolean pinkkey2collected = false;
	boolean pinkkey3collected = false;
	boolean pinkkey4collected = false;
	boolean pinkkey5collected = false;

	boolean orangekey1collected = false;
	boolean orangekey2collected = false;
	boolean orangekey3collected = false;
	boolean orangekey4collected = false;
	boolean orangekey5collected = false;

	boolean bluekey1collected = false;
	boolean bluekey2collected = false;
	boolean bluekey3collected = false;
	boolean bluekey4collected = false;
	boolean bluekey5collected = false;
	
	boolean door1opened = false;
	boolean door2opened = false;
	boolean door3opened = false;
	boolean door4opened = false;
	boolean door5opened = false;
	boolean door6opened = false;
	boolean door7opened = false;
	
	boolean pinkdoor1opened = false;
	boolean pinkdoor2opened = false;
	boolean pinkdoor3opened = false;
	boolean pinkdoor4opened = false;
	boolean pinkdoor5opened = false;

	boolean orangedoor1opened = false;
	boolean orangedoor2opened = false;
	boolean orangedoor3opened = false;
	boolean orangedoor4opened = false;
	boolean orangedoor5opened = false;

	boolean bluedoor1opened = false;
	boolean bluedoor2opened = false;
	boolean bluedoor3opened = false;
	boolean bluedoor4opened = false;
	boolean bluedoor5opened = false;

	boolean showPurplekey = false;
	boolean showTeleport = false;

	

	int waitTime = 25;

	int stageVariation = 0;
	
	boolean escaped = false;
	
	String enemy1upDisplay = "";
	String enemy1downDisplay = "";
	String enemy1leftDisplay = "";
	String enemy1rightDisplay = "";

	List<Rectangle> enemyList = new ArrayList<Rectangle>();

	Map<ColorfulRectangle, KeyCount> doorToKey = new HashMap<ColorfulRectangle, KeyCount>();
	Map<ColorfulRectangle, KeyCount> keyToKeyCount= new HashMap<ColorfulRectangle, KeyCount>();
	boolean build = false; //false
	int noclip = 0;
	boolean nocliped = false; //false
	boolean enemyInfo = false;
	
	//MENUS
	boolean map = false;
	boolean mapshown = false;
	boolean menushown = true; //true
	boolean pausedshown = false; //false
	boolean optionsshown = false; //false

	//OPTIONS
	boolean Stroke = true;
	int chosenBGcolor = 6; //| 1=red | 2=orange | 3=yellow | 4=green | 5=blue | 6=black |
	int chosenBGcolorOutline = 6; //| 1=red | 2=orange | 3=yellow | 4=green | 5=blue | 6=black |
	int enemyDifficulty = 2; //| 1=easy | 2=medium | 3=hard | 4=extreme |
	int chosenEnemyDifficultyOutline = 2; //| 1=green | 2=yellow | 3=red | 4=magenta |
	boolean GrayScale = true;
	boolean FlashingLights = true;

	int blockplacesize = 0;
	
	boolean showblockmap = false;
	
	int movedelay = 0;

	private static final Color[] TILE_COLORS = {Color.WHITE, Color.DARK_GRAY};

	private int[][] loadCSV(String file, int cols) {
		java.util.List<int[]> rows = new java.util.ArrayList<>();
		try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || line.isEmpty()) continue;
				String[] p = line.split(",");
				int[] row = new int[cols];
				for (int i = 0; i < cols; i++) row[i] = Integer.parseInt(p[i].trim());
				rows.add(row);
			}
		} catch (Exception e) { e.printStackTrace(); }
		return rows.toArray(new int[0][]);
	}

	private int[][] worldTileData, enemyTileData, darkTileData;
	int[][] b2Offsets;
	private java.util.Map<String, int[][]> mapTileCache = new java.util.HashMap<>();

	private int[][] getMapTiles(String section) {
		return mapTileCache.computeIfAbsent(section, sec -> {
			java.util.List<int[]> rows = new java.util.ArrayList<>();
			try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("src/map_tiles.csv"))) {
				String line;
				while ((line = br.readLine()) != null) {
					if (line.startsWith("#") || line.isEmpty()) continue;
					String[] p = line.split(",");
					if (!p[0].equals(sec)) continue;
					rows.add(new int[]{Integer.parseInt(p[1]), Integer.parseInt(p[2]),
					                   Integer.parseInt(p[3]), Integer.parseInt(p[4]),
					                   p[5].contains("DARK") ? 1 : 0});
				}
			} catch (Exception e) { e.printStackTrace(); }
			return rows.toArray(new int[0][]);
		});
	}

	private void loadMapTiles(String section) {
		for (int[] t : getMapTiles(section))
			rects.add(new ColorfulRectangle(t[0], t[1], t[2], t[3], TILE_COLORS[t[4]]));
	}

	private void loadWorldTiles() {
		for (int[] t : worldTileData)
			rects.add(new ColorfulRectangle(movex+t[0], movey+t[1], t[2], t[3], TILE_COLORS[t[4]]));
		for (int[] t : enemyTileData)
			enemyBorder.add(new ColorfulRectangle(movex+t[0], movey+t[1], t[2], t[3], EnemyBorderColor));
	}

	private void loadWorldTiles2() { /* buildings2 included in worldTileData */ }

	private void loadDarkTiles() {
		for (int[] t : darkTileData)
			rects.add(new ColorfulRectangle(movex+t[0], movey+t[1], t[2], t[3], bgColor));
	}

	private void loadDarkTiles2() { loadDarkTiles(); }

	private void drawAndUpdate(Door o)          { o.draw(); o.update(); }
	private void drawAndUpdate(Key o)           { o.draw(); o.update(); }
	private void drawAndUpdate(Enemy o)         { o.draw(); o.update(); }
	private void drawAndUpdate(Ending o)        { o.draw(); o.update(); }
	private void drawAndUpdate(Endingdoor o)    { o.draw(); o.update(); }
	private void drawAndUpdate(SecretEnding o)  { o.draw(); o.update(); }
	private void drawAndUpdate(SecretTeleport o){ o.draw(); o.update(); }

	private static final int[][][] DIGIT_SEGS = {
		{},
		{{10,0,10,50}},
		{{0,0,30,10},{20,10,10,20},{0,20,30,10},{0,30,10,20},{0,40,30,10}},
		{{0,0,30,10},{20,10,10,20},{0,20,30,10},{20,30,10,20},{0,40,30,10}},
		{{0,0,10,30},{0,20,30,10},{20,0,10,50}},
		{{0,0,30,10},{0,10,10,20},{0,20,30,10},{20,30,10,20},{0,40,30,10}},
	};

	private void drawKeyCount(int baseX, int count) {
		if (count <= 0 || count >= DIGIT_SEGS.length) return;
		for (int[] s : DIGIT_SEGS[count])
			new ColorfulRectangle(baseX+s[0], s[1], s[2], s[3], Color.WHITE).draw();
	}

	private static final int[] FLASH_SIZES = {50, 45, 40, 35, 30, 25, 20, 15};
	private ColorfulRectangle[] flashRects;
	private ColorfulRectangle[] aFlashRects;

	private void drawFlash(ColorfulRectangle[] fr, int ox, int oy, int xRange, int yRange) {
		for (int i = 0; i < 8; i++) {
			int rx = randon.nextInt(xRange), ry = randon.nextInt(yRange);
			fr[i].setBounds(movex+ox+rx, movey+oy+ry, FLASH_SIZES[i], FLASH_SIZES[i]);
			fr[i].draw();
		}
	}

	private void initTileCaches() {
		worldTileData = loadCSV("src/world_tiles.csv", 5);
		enemyTileData = loadCSV("src/enemy_tiles.csv", 4);
		darkTileData  = loadCSV("src/dark_tiles.csv", 4);
		b2Offsets     = loadCSV("src/ending_tiles.csv", 2);
		Color[] fc  = {Red,Orange,Yellow,Green,Blue,Magenta,Color.LIGHT_GRAY,Color.WHITE};
		Color[] fgc = {grayRed,grayOrange,grayYellow,grayGreen,grayBlue,grayMagenta,Color.LIGHT_GRAY,Color.WHITE};
		flashRects  = new ColorfulRectangle[8];
		aFlashRects = new ColorfulRectangle[8];
		for (int i = 0; i < 8; i++) {
			flashRects[i]  = new ColorfulRectangle(0,0,FLASH_SIZES[i],FLASH_SIZES[i],fc[i],fgc[i]);
			aFlashRects[i] = new ColorfulRectangle(0,0,FLASH_SIZES[i],FLASH_SIZES[i],fc[i],fgc[i]);
		}
	}

	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		initTileCaches();

		
		doorToKey.put(door1, yellowKeyCount);
		doorToKey.put(door2, yellowKeyCount);
		doorToKey.put(door3, yellowKeyCount);
		doorToKey.put(door4, yellowKeyCount);
		doorToKey.put(door5, yellowKeyCount);
		doorToKey.put(door6, yellowKeyCount);
		doorToKey.put(door7, yellowKeyCount);
		
		doorToKey.put(pinkdoor1, pinkKeyCount);
		doorToKey.put(pinkdoor2, pinkKeyCount);
		doorToKey.put(pinkdoor3, pinkKeyCount);
		doorToKey.put(pinkdoor4, pinkKeyCount);
		doorToKey.put(pinkdoor5, pinkKeyCount);

		doorToKey.put(orangedoor1, orangeKeyCount);
		doorToKey.put(orangedoor2, orangeKeyCount);
		doorToKey.put(orangedoor3, orangeKeyCount);
		doorToKey.put(orangedoor4, orangeKeyCount);
		doorToKey.put(orangedoor5, orangeKeyCount);

		doorToKey.put(bluedoor1, blueKeyCount);
		doorToKey.put(bluedoor2, blueKeyCount);
		doorToKey.put(bluedoor3, blueKeyCount);
		doorToKey.put(bluedoor4, blueKeyCount);
		doorToKey.put(bluedoor5, blueKeyCount);
		
		doorToKey.put(endingdoor1, endingKeyCount);
		doorToKey.put(endingdoor2, endingKeyCount);
		
		doorToKey.put(blackdoor1, blackKeyCount);
		doorToKey.put(blackdoor2, blackKeyCount);
		doorToKey.put(blackdoor3, blackKeyCount);
		doorToKey.put(blackdoor4, blackKeyCount);
		
		doorToKey.put(purpledoor, purpleKeyCount);

		
		keyToKeyCount.put(key1, yellowKeyCount);
		keyToKeyCount.put(key2a, yellowKeyCount);
		keyToKeyCount.put(key2b, yellowKeyCount);
		keyToKeyCount.put(key3a, yellowKeyCount);
		keyToKeyCount.put(key3b, yellowKeyCount);
		keyToKeyCount.put(key3c, yellowKeyCount);
		keyToKeyCount.put(key4, yellowKeyCount);
		keyToKeyCount.put(key5a, yellowKeyCount);
		keyToKeyCount.put(key5b, yellowKeyCount);
		keyToKeyCount.put(key5c, yellowKeyCount);
		keyToKeyCount.put(key6, yellowKeyCount);
		keyToKeyCount.put(key7, yellowKeyCount);
		
		keyToKeyCount.put(pinkkey1, pinkKeyCount);
		keyToKeyCount.put(pinkkey2a, pinkKeyCount);
		keyToKeyCount.put(pinkkey2b, pinkKeyCount);
		keyToKeyCount.put(pinkkey3a, pinkKeyCount);
		keyToKeyCount.put(pinkkey3b, pinkKeyCount);
		keyToKeyCount.put(pinkkey4, pinkKeyCount);
		keyToKeyCount.put(pinkkey5, pinkKeyCount);

		keyToKeyCount.put(orangekey1, orangeKeyCount);
		keyToKeyCount.put(orangekey2, orangeKeyCount);
		keyToKeyCount.put(orangekey3, orangeKeyCount);
		keyToKeyCount.put(orangekey4, orangeKeyCount);
		keyToKeyCount.put(orangekey5, orangeKeyCount);

		keyToKeyCount.put(bluekey1, blueKeyCount);
		keyToKeyCount.put(bluekey2, blueKeyCount);
		keyToKeyCount.put(bluekey3, blueKeyCount);
		keyToKeyCount.put(bluekey4, blueKeyCount);
		keyToKeyCount.put(bluekey5a, blueKeyCount);
		keyToKeyCount.put(bluekey5b, blueKeyCount);
		
		keyToKeyCount.put(endingdoor1, endingKeyCount);
		keyToKeyCount.put(endingdoor2, endingKeyCount);
		
		keyToKeyCount.put(blackkey1, blackKeyCount);
		keyToKeyCount.put(blackkey2, blackKeyCount);
		keyToKeyCount.put(blackkey3, blackKeyCount);
		keyToKeyCount.put(blackkey4, blackKeyCount);
		
		keyToKeyCount.put(purplekey, purpleKeyCount);

		//background(bgColor);

		finished=false;
		
		stageVariation = randon.nextInt(3); //0-2
		System.out.println(stageVariation);
		keys.add(key1);
		keys.add(key2a);
		keys.add(key2b);
		keys.add(key3a);
		keys.add(key3b);
		keys.add(key3c);
		keys.add(key4);
		keys.add(key5a);
		keys.add(key5b);
		keys.add(key5c);
		keys.add(key6);
		keys.add(key7);
		keys.add(pinkkey1);
		keys.add(pinkkey2a);
		keys.add(pinkkey2b);
		keys.add(pinkkey3a);
		keys.add(pinkkey3b);
		keys.add(pinkkey4);
		keys.add(pinkkey5);
		keys.add(orangekey1);
		keys.add(orangekey2);
		keys.add(orangekey3);
		keys.add(orangekey4);
		keys.add(orangekey5);
		keys.add(bluekey1);
		keys.add(bluekey2);
		keys.add(bluekey3);
		keys.add(bluekey4);
		keys.add(bluekey5a);
		keys.add(bluekey5b);
		keys.add(blackkey1);
		keys.add(blackkey2);
		keys.add(blackkey3);
		keys.add(blackkey4);
		
		doors.add(door1);
		doors.add(door2);
		doors.add(door3);
		doors.add(door4);
		doors.add(door5);
		doors.add(door6);
		doors.add(door7);
		doors.add(pinkdoor1);
		doors.add(pinkdoor2);
		doors.add(pinkdoor3);
		doors.add(pinkdoor4);
		doors.add(pinkdoor5);
		doors.add(orangedoor1);
		doors.add(orangedoor2);
		doors.add(orangedoor3);
		doors.add(orangedoor4);
		doors.add(orangedoor5);
		doors.add(bluedoor1);
		doors.add(bluedoor2);
		doors.add(bluedoor3);
		doors.add(bluedoor4);
		doors.add(bluedoor5);
		doors.add(blackdoor1);
		doors.add(blackdoor2);
		doors.add(blackdoor3);
		doors.add(blackdoor4);
	}

	@Override
	public void draw() {
		background(bgColor.getRGB());
		

		//ENEMY 1=up, 2=down, 3=right, 4=left
		//PLAYER 1=up, 2=left, 3=down, 4=right

		for(Rectangle r : rects) {
			if(r instanceof ColorfulRectangle) {
				((ColorfulRectangle) r).draw();
			}else {
				rect(r.x, r.y, r.width, r.height);
			}
		}
		
		for(Rectangle r : enemyBorder) {
			if(r instanceof ColorfulRectangle) {
				((ColorfulRectangle) r).draw();
			}else {
				rect(r.x, r.y, r.width, r.height);
			}
		}

		//System.out.println(movex + " " + movey);
		if(!menushown && !optionsshown && !pausedshown && !mapshown && !finished) {
			emeny.draw(); 
			emeny.update();
				if(!wall1) {
					emeny2.draw(); 
					emeny2.update();
				}
				if(!wall2) {
										drawAndUpdate(emeny3);
				}
			}

		if(!map && !nocliped) {
			if(playerInterectsBlock()) {
				if(mapshown==true) {
				if(facing==1) {
					movey-=50;}		
				if(facing==2) {
					movex-=50;}
				if(facing==3) {
					movey+=50;}
				if(facing==4) {
					movex+=50;}
				}
			}
		}
		
		//System.out.println(yellowKeyCount.keys + " " + pinkKeyCount.keys + " " + blackKeyCount.keys);
		//draw

		if(build==false || nocliped==false){
			rects.clear();
		}	
		enemyBorder.clear();
		
		if(menushown==true) {
			noStroke();
			menuBlocks();
		}else if(pausedshown==true) {
			noStroke();
			pausedBlocks();
		}else if(optionsshown==true) {
			noStroke();
			optionsBlocks();
		}else if(Stroke){
			stroke(bgColor.getRGB());
		}
		

		if(!menushown && !optionsshown && !pausedshown && !mapshown) {
			buildings();
			buildings2();
			buildingdarkness();
		}
		
		playerup.x=player.x;
		playerup.y=player.y-50;
		playerdown.x=player.x;
		playerdown.y=player.y+50;
		playerleft.x=player.x-50;
		playerleft.y=player.y;
		playerright.x=player.x+50;
		playerright.y=player.y;
		
		
		if(nocliped==true) {
		playerup.x=9999;
		playerup.y=9999;
		playerdown.x=9999;
		playerdown.y=9999;
		playerleft.x=9999;
		playerleft.y=9999;
		playerright.x=9999;
		playerright.y=9999;
		}

		//System.out.println(nocliped);
		
		if(noclip==8) { nocliped = !nocliped; noclip=0; }
		
//		if(NoStroke==true) {
//			noStroke();
//		}else {
//			stroke(0,0,0);
//		}

		
		if(!wall1 && !menushown && !optionsshown && !pausedshown && !mapshown && FlashingLights) {
		drawFlash(flashRects, 100, 750, 500, 250);
		}

		if(player.x==movex-2350 && player.y==movey-1150) {
			movex=50;
			movey=-600;
			finished=true;
			collectedEndingKeys=2;
		}

		if(finished && !optionsshown && !pausedshown && FlashingLights) {
			drawFlash(aFlashRects, -2350, -1150, 4300, 3100);
		}

		if(finished==true && !optionsshown && !pausedshown) {
			endingBlocks();
			yellowKeyCount.keys=0;
			pinkKeyCount.keys=0;	
			orangeKeyCount.keys=0;	
			blueKeyCount.keys=0;	
			blackKeyCount.keys=0;	
			purpleKeyCount.keys=0;	
		}

		if(!menushown && !optionsshown && !pausedshown && !mapshown) {
			ColorfulRectangle wall1button = new ColorfulRectangle(movex+wall1buttonx,movey+wall1buttony,50,50, Green,grayGreen);
			if(player.x==wall1button.x && player.y==wall1button.y) {
				wall1=false;
				wall1buttonx=10000;
				wall1buttony=10000;
			}
			wall1button.draw();

			if(wall1==false) {
			ColorfulRectangle wall2button = new ColorfulRectangle(movex+wall2buttonx,movey+wall2buttony,50,50, Green,grayGreen);
			if(player.x==wall2button.x && player.y==wall2button.y) {
				wall2=false;
				wall2buttonx=10000;
				wall2buttony=10000;
			}
			wall2button.draw();
		}
		}

		if(!menushown && !optionsshown && !pausedshown && !mapshown && !finished) {
								drawAndUpdate(door1);
				if(wall1==false) {
								drawAndUpdate(door2);
								drawAndUpdate(door3);
								drawAndUpdate(door4);
								drawAndUpdate(door5);

								drawAndUpdate(pinkdoor1);
				}
				if(wall2==false) {
								drawAndUpdate(door6);
								drawAndUpdate(door7);
					
								drawAndUpdate(pinkdoor2);
								drawAndUpdate(pinkdoor3);
								drawAndUpdate(pinkdoor4);
								drawAndUpdate(pinkdoor5);

								drawAndUpdate(orangedoor1);
								drawAndUpdate(orangedoor2);
								drawAndUpdate(orangedoor3);
								drawAndUpdate(orangedoor4);
								drawAndUpdate(orangedoor5);

								drawAndUpdate(bluedoor1);
								drawAndUpdate(bluedoor2);
								drawAndUpdate(bluedoor3);
								drawAndUpdate(bluedoor4);
								drawAndUpdate(bluedoor5);
				}				
				if(secret==true){
										drawAndUpdate(purpledoor);
				}
				
				if(stageVariation==0) {
										drawAndUpdate(key1);
										drawAndUpdate(key2a);
										drawAndUpdate(key3a);
										drawAndUpdate(key5a);
					
					if(wall1==false) {
										drawAndUpdate(key4);
					}
					
					if(wall2==false) {
										drawAndUpdate(key6);
										drawAndUpdate(key7);
										drawAndUpdate(pinkkey2a);
										drawAndUpdate(pinkkey3a);
										drawAndUpdate(bluekey5a);
					}
				} else if(stageVariation==1) {
										drawAndUpdate(key1);
										drawAndUpdate(key2b);
										drawAndUpdate(key3b);
					
					if(wall1==false) {
										drawAndUpdate(key4);
										drawAndUpdate(key5b);
					}
					
					if(wall2==false) {
										drawAndUpdate(key6);
										drawAndUpdate(key7);
										drawAndUpdate(pinkkey2b);
										drawAndUpdate(pinkkey3b);
										drawAndUpdate(bluekey5a);
					}
				} else if(stageVariation==2) {
										drawAndUpdate(key1);
										drawAndUpdate(key2a);
										drawAndUpdate(key3c);
					
					if(wall1==false) {
										drawAndUpdate(key4);
										drawAndUpdate(key5c);
					}
					
					if(wall2==false) {
										drawAndUpdate(key6);
										drawAndUpdate(key7);
										drawAndUpdate(pinkkey2b);

										drawAndUpdate(pinkkey3b);
										drawAndUpdate(bluekey5b);
					}
				}

				
				if(wall1==false) {
								drawAndUpdate(pinkkey1);
				}
				if(wall2==false) {
								drawAndUpdate(pinkkey4);
								drawAndUpdate(pinkkey5);

								drawAndUpdate(orangekey1);
								drawAndUpdate(orangekey2);
								drawAndUpdate(orangekey3);
								drawAndUpdate(orangekey4);
								drawAndUpdate(orangekey5);

								drawAndUpdate(bluekey1);
								drawAndUpdate(bluekey2);
								drawAndUpdate(bluekey3);
								drawAndUpdate(bluekey4);

								drawAndUpdate(blackkey1);
								drawAndUpdate(blackkey2);
								drawAndUpdate(blackkey3);
								drawAndUpdate(blackkey4);
				purplekey.update();
								
				if(showPurplekey==true){
					purplekey.draw();
				}else if(movex<=2250 && movex>=1500 && movey<=1100) {
					purplekey.draw();
				}
				
				if(secret==true) {
								drawAndUpdate(blackdoor1);
								drawAndUpdate(blackdoor2);
								drawAndUpdate(blackdoor3);
								drawAndUpdate(blackdoor4);
				}
			}
		}
		if(movex==-100 && movey==1500) {
			escaped = true;
		}
		if(movex==1850 && movey==1450) {
			showPurplekey = true;
		}
		
		if(finished==true && !optionsshown && !pausedshown) {
			//System.out.println(timer);
			//System.out.println(escaped);
		if(escaped==false) {
			
			rects.add(new ColorfulRectangle(350, 0, 100, 60, Color.BLACK));

		timer-=1;
		if(timer<0) {
			timer=60;
			timetrack-=1;
			//TIME 60/65/70
			//System.out.println("time " + timetrack);
		}
		if(timetrack>=80) {
		rects.add(new ColorfulRectangle(360, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 50, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(380, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 25, 30, 10, Color.WHITE));
		}else if(timetrack>=70) {
		//7
		rects.add(new ColorfulRectangle(360, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(380, 0, 10, 60, Color.WHITE));
		}else if(timetrack>=60) {
		//6
		rects.add(new ColorfulRectangle(360, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(380, 30, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 25, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 50, 30, 10, Color.WHITE));
		}else if(timetrack>=50) {
		//5
		rects.add(new ColorfulRectangle(360, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 0, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(380, 30, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 25, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 50, 30, 10, Color.WHITE));
		}else if(timetrack>=40) {
		//4
		rects.add(new ColorfulRectangle(360, 0, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(380, 0, 10, 60, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 20, 30, 10, Color.WHITE));
		}else if(timetrack>=30) {
		//3
		rects.add(new ColorfulRectangle(360, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(380, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 25, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 50, 30, 10, Color.WHITE));
		}else if(timetrack>=20) {
		//2
		rects.add(new ColorfulRectangle(360, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(380, 0, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 30, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 25, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 50, 30, 10, Color.WHITE));
		}else if(timetrack>=10) {
		//1
		rects.add(new ColorfulRectangle(380, 0, 10, 60, Color.WHITE));
		}else if(timetrack>=0) {
		//0
		rects.add(new ColorfulRectangle(360, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(360, 50, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(380, 0, 10, 50, Color.WHITE));
		}
		
		
		if(timetrack==0 || timetrack==10 || timetrack==20 || timetrack==30 || timetrack==40 || timetrack==50 || timetrack==60  || timetrack==70 || timetrack==80) {
		rects.add(new ColorfulRectangle(410, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 50, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(430, 0, 10, 50, Color.WHITE));
		}else if(timetrack==1 || timetrack==11 || timetrack==21 || timetrack==31 || timetrack==41 || timetrack==51 || timetrack==61 || timetrack==71) {
		rects.add(new ColorfulRectangle(430, 0, 10, 60, Color.WHITE));
		}else if(timetrack==2 || timetrack==12 || timetrack==22 || timetrack==32 || timetrack==42 || timetrack==52 || timetrack==62 || timetrack==72) {
		rects.add(new ColorfulRectangle(410, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(430, 0, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 30, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 25, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 50, 30, 10, Color.WHITE));
		}else if(timetrack==3 || timetrack==13 || timetrack==23 || timetrack==33 || timetrack==43 || timetrack==53 || timetrack==63 || timetrack==73) {
		rects.add(new ColorfulRectangle(410, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(430, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 25, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 50, 30, 10, Color.WHITE));
		}else if(timetrack==4 || timetrack==14 || timetrack==24 || timetrack==34 || timetrack==44 || timetrack==54 || timetrack==64 || timetrack==74) {
		rects.add(new ColorfulRectangle(410, 0, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(430, 0, 10, 60, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 25, 30, 10, Color.WHITE));
		}else if(timetrack==5 || timetrack==15 || timetrack==25 || timetrack==35 || timetrack==45 || timetrack==55 || timetrack==65 || timetrack==75) {
		rects.add(new ColorfulRectangle(410, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 0, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(430, 30, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 25, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 50, 30, 10, Color.WHITE));
		}else if(timetrack==6 || timetrack==16 || timetrack==26 || timetrack==36 || timetrack==46 || timetrack==56 || timetrack==66 || timetrack==76) {
		rects.add(new ColorfulRectangle(410, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(430, 30, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 25, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 50, 30, 10, Color.WHITE));
		}else if(timetrack==7 || timetrack==17 || timetrack==27 || timetrack==37 || timetrack==47 || timetrack==57 || timetrack==67 || timetrack==77) {
		rects.add(new ColorfulRectangle(410, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(430, 0, 10, 60, Color.WHITE));
		}else if(timetrack==8 || timetrack==18 || timetrack==28 || timetrack==38 || timetrack==48 || timetrack==58 || timetrack==68 || timetrack==78) {
		rects.add(new ColorfulRectangle(410, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 50, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(430, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 25, 30, 10, Color.WHITE));
		}else if(timetrack==9 || timetrack==19 || timetrack==29 || timetrack==39 || timetrack==49 || timetrack==59 || timetrack==69 || timetrack==79) {
		rects.add(new ColorfulRectangle(410, 0, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 0, 10, 30, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 50, 30, 10, Color.WHITE));
		rects.add(new ColorfulRectangle(430, 0, 10, 50, Color.WHITE));
		rects.add(new ColorfulRectangle(410, 25, 30, 10, Color.WHITE));
		}

		if(timetrack==0) {
		System.exit(0);
		}
	}
	}
		
//		System.out.println(noDoubleClickOptions);

		if(!Stroke) {
			noStroke();
		}
		
		if(blackKeyCount.keys==3) {
			secret=true;
		}
		
		if(teleportavaible==true) {
			if(player.x==movex-1000 && player.y==movey+1250) {
				movex=movex-1800;
				movey=movey-150;
				teleportavaible=false;
			}else if(player.x==movex+800 && player.y==movey+1400) {
				movex=movex+1800;
				movey=movey+150;
				teleportavaible=false;
			}
		}
		if(!menushown && !optionsshown && !pausedshown && !mapshown) {
		if(secret==true) {
						drawAndUpdate(st1);
		}
		}
		
		if(movex==1200 && movey==-1000) {
			showTeleport=true;
		}
		
		if(showTeleport==true) {

			
						drawAndUpdate(SecretEnding);
			
			st1.draw(); st1.update();
			st2.draw(); st2.update();
			st3.draw(); st3.update();
			st4.draw(); st4.update();
			st5.draw(); st5.update();
			st6.draw(); st6.update();
			st7.draw(); st7.update();
			st8.draw(); st8.update();
			st9.draw(); st9.update();
			st10.draw(); st10.update();
			st11.draw(); st11.update();
			st12.draw(); st12.update();
		
			if(movex==1200 && movey==-1000) {
				movex=1700;
				movey=-200;
			}
			if(movex==1700 && movey==-100) {
				movex=2500;
				movey=600;
			}
			if(movex==2500 && movey==350) {
				movex=2200;
				movey=800;
			}
			if(movex==2200 && movey==700) {
				movex=-700;
				movey=650;
			}
			if(movex==-800 && movey==750) {
				movex=2100;
				movey=-900;
			}
			if(movex==-800 && movey==750) {
				movex=2100;
				movey=-900;
			}
			if(movex==1800 && movey==-900) {
				movex=2100;
				movey=700;
			}
			if(movex==2100 && movey==800) {
				movex=1000;
				movey=-750;
			}
			if(movex==700 && movey==-750) {
				movex=-900;
				movey=750;
			}
			if(movex==-800 && movey==600) {
				movex=2600;
				movey=350;
			}
			if(movex==2400 && movey==350) {
				movex=-1050;
				movey=-150;
			}
			if(movex==-1050 && movey==-250) {
				movex=2100;
				movey=-800;
			}
			if(movex==2000 && movey==-900) {
				movex=-250;
				movey=200;
			}
			if(movex==-400 && movey==350) {
				movex=-1700;
				movey=3400;
			}
		}
		
		//System.out.println(movex + " " + movey);
		if(!menushown && !optionsshown && !pausedshown && !mapshown && !wall2 && !finished) {
		blackkeydisplay1 = new ColorfulRectangle(movex+blackkeydisplay1x,movey+1422,5,5,Color.white);
		blackkeydisplay1.draw();
		blackkeydisplay2 = new ColorfulRectangle(movex+blackkeydisplay2x,movey-328,5,5,Color.white);
		blackkeydisplay2.draw();
		blackkeydisplay3 = new ColorfulRectangle(movex+blackkeydisplay3x,movey-778,5,5,Color.white);
		blackkeydisplay3.draw();
		blackkeydisplay4 = new ColorfulRectangle(movex+blackkeydisplay4x,movey+1072,5,5,Color.white);
		blackkeydisplay4.draw();
		}
		
		
		if(player.x==movex-2250 && player.y==movey+1400) {
			blackkeydisplay1x+=9999;
		}
		if(player.x==movex+1350 && player.y==movey-350) {
			blackkeydisplay2x+=9999;
		}
		if(player.x==movex+450 && player.y==movey-800) {
			blackkeydisplay3x+=9999;
		}
		if(player.x==movex+700 && player.y==movey+1050) {
			blackkeydisplay4x+=9999;
		}
		
		if(secret) {
		new ColorfulRectangle(movex+800,movey+1400, 50, 50, Red,grayRed);
		new ColorfulRectangle(movex-1000,movey+1250, 50, 50, Red,grayRed);
		ColorfulRectangle[] tp1 = {new ColorfulRectangle(0,0,50,50,Red,grayRed),
		    new ColorfulRectangle(0,0,50,50,Orange,grayOrange),
		    new ColorfulRectangle(0,0,50,50,Yellow,grayYellow)};
		int tp1a = teleport1colorswitch/20, tp1b = (teleport1colorswitch/20+1)%3;
		tp1[tp1a].setBounds(movex+800,  movey+1400, 50, 50);
		tp1[tp1b].setBounds(movex-1000, movey+1250, 50, 50);
		tp1[(tp1a+2)%3].setBounds(movex+9999, movey+9999, 50, 50);
		teleport1colorswitch = (teleport1colorswitch+1) % 60;
		if(!menushown && !optionsshown && !pausedshown && !mapshown) {
			for(ColorfulRectangle tp : tp1) tp.draw();
		}
		}
				
		ColorfulRectangle displaykey = new ColorfulRectangle(660,10, 30, 30, Yellow,grayYellow);
		ColorfulRectangle displaypinkkey = new ColorfulRectangle(510,10, 30, 30, Pink,grayPink);
		ColorfulRectangle displayorangekey = new ColorfulRectangle(360,10, 30, 30, Orange,grayOrange);
		ColorfulRectangle displaybluekey = new ColorfulRectangle(210,10, 30, 30, Cyan,grayCyan);
		ColorfulRectangle displayblackkey = new ColorfulRectangle(72,22, 5, 5, Color.WHITE);
		ColorfulRectangle displayendingkey = new ColorfulRectangle(6000,10, 30, 30, Color.WHITE);
		ColorfulRectangle displaypurplekey = new ColorfulRectangle(60,560, 30, 30, Magenta,grayMagenta);

		
		//System.out.println(yellowKeyCount.keys + " " + pinkKeyCount.keys + " " + orangeKeyCount.keys + " " + blueKeyCount.keys);
		
		if(!mapshown && !optionsshown) {
		if(yellowKeyCount.keys>0) {
		ColorfulRectangle backdisplayyellowkey = new ColorfulRectangle(650,0, 100, 50, bgColor);
		backdisplayyellowkey.draw();}
		if(pinkKeyCount.keys>0) {
		ColorfulRectangle backdisplaypinkkey = new ColorfulRectangle(500,0, 100, 50, bgColor);
		backdisplaypinkkey.draw();}
		if(orangeKeyCount.keys>0) {
		ColorfulRectangle backdisplayorangekey = new ColorfulRectangle(350,0, 100, 50, bgColor);
		backdisplayorangekey.draw();}
		if(blueKeyCount.keys>0) {
		ColorfulRectangle backdisplaybluekey = new ColorfulRectangle(200,0, 100, 50, bgColor);
		backdisplaybluekey.draw();}
		if(escaped == false) {
		if(finished==true) {
		ColorfulRectangle backdisplayendingkey = new ColorfulRectangle(650,0, 100, 50, bgColor);
		backdisplayendingkey.draw();}
		}
		if(blackKeyCount.keys>0) {
		ColorfulRectangle backdisplayblackkey = new ColorfulRectangle(50,0, 100, 50, bgColor);
		backdisplayblackkey.draw();}
		if(purpleKeyCount.keys>0) {
		ColorfulRectangle backdisplaypurplekey = new ColorfulRectangle(50,550, 100, 50, bgColor);
		backdisplaypurplekey.draw();}
		}
		

		
		if(finished==true) {
			if(collectedEndingKeys>=1) {
			ColorfulRectangle displayEndingred = new ColorfulRectangle(660,10,30,30,Red,grayRed);
			ColorfulRectangle displayEndingorange = new ColorfulRectangle(660,10,30,30,Orange,grayOrange);
			ColorfulRectangle displayEndingyellow = new ColorfulRectangle(660,10,30,30,Yellow,grayYellow);
			ColorfulRectangle displayEndinggreen = new ColorfulRectangle(660,10,30,30,Green,grayGreen);
			ColorfulRectangle displayEndingblue = new ColorfulRectangle(660,10,30,30,Blue,grayBlue);
			ColorfulRectangle displayEndingpurple = new ColorfulRectangle(660,10,30,30,Magenta,grayMagenta);
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
		}
		
		
		if(!menushown && !optionsshown && !pausedshown && !mapshown) {
		
			noStroke();
		//KEY COUNTER
		if(yellowKeyCount.keys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(720,0, 10, 50, Color.WHITE);
			keynum1.draw();
		}else if(yellowKeyCount.keys==2) {
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
		}else if(yellowKeyCount.keys==3) {
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
		}else if(yellowKeyCount.keys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(710,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(710,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(730,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
		}else if(yellowKeyCount.keys==5) {
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
		if(pinkKeyCount.keys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(570,0, 10, 50, Color.WHITE);
			keynum1.draw();
		}else if(pinkKeyCount.keys==2) {
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
		}else if(pinkKeyCount.keys==3) {
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
		}else if(pinkKeyCount.keys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(560,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(560,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(580,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
		}else if(pinkKeyCount.keys==5) {
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
		if(orangeKeyCount.keys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(420,0, 10, 50, Color.WHITE);
			keynum1.draw();
		}else if(orangeKeyCount.keys==2) {
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
		}else if(orangeKeyCount.keys==3) {
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
		}else if(orangeKeyCount.keys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(410,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(410,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(430,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
		}else if(orangeKeyCount.keys==5) {
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
		if(blueKeyCount.keys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(270,0, 10, 50, Color.WHITE);
			keynum1.draw();
		}else if(blueKeyCount.keys==2) {
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
		}else if(blueKeyCount.keys==3) {
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
		}else if(blueKeyCount.keys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(260,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(260,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(280,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
		}else if(blueKeyCount.keys==5) {
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
		if(!escaped && finished) {
			//ENDING KEY COUNTER
			if(collectedEndingKeys==0) {
				//nothing
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
			}
		}
		
		//BLACK KEY COUNTER
		if(blackKeyCount.keys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(120,0, 10, 50, Color.WHITE);
			keynum1.draw();
		}else if(blackKeyCount.keys==2) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(110,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(130,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(110,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(110,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(110,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();
		}else if(blackKeyCount.keys==3) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(110,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(130,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(110,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(130,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(110,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();
		}else if(blackKeyCount.keys==4) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(110,0, 10, 30, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(110,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(130,0, 10, 50, Color.WHITE);		
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();		
		}else if(blackKeyCount.keys==5) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(110,0, 30, 10, Color.WHITE);
			ColorfulRectangle keynum2 = new ColorfulRectangle(110,10, 10, 20, Color.WHITE);
			ColorfulRectangle keynum3 = new ColorfulRectangle(110,20, 30, 10, Color.WHITE);
			ColorfulRectangle keynum4 = new ColorfulRectangle(130,30, 10, 20, Color.WHITE);
			ColorfulRectangle keynum5 = new ColorfulRectangle(110,40, 30, 10, Color.WHITE);
			keynum1.draw();
			keynum2.draw();
			keynum3.draw();
			keynum4.draw();
			keynum5.draw();
		}

		//PURPLE KEY COUNTER
		if(purpleKeyCount.keys==1) {
			ColorfulRectangle keynum1 = new ColorfulRectangle(120,551, 10, 49, Color.WHITE);
			keynum1.draw();
		}
		
		}
		
		
		if(!menushown && !optionsshown && !pausedshown && !mapshown) {
		if(yellowKeyCount.keys<=0) {
			displaykey.x=9999;
		}else {
			displaykey.draw();
		}
		if(pinkKeyCount.keys<=0) {
			displaypinkkey.x=9999;
		}else {
			displaypinkkey.draw();
		}
		if(orangeKeyCount.keys<=0) {
			displayorangekey.x=9999;
		}else {
			displayorangekey.draw();
		}
		if(blueKeyCount.keys<=0) {
			displaybluekey.x=9999;
		}else {
			displaybluekey.draw();
		}
		if(blackKeyCount.keys<=0) {
			displayblackkey.x=9999;
		}else {
			displayblackkey.draw();
		}
		if(purpleKeyCount.keys<=0) {
			displaypurplekey.x=9999;
		}else {
			displaypurplekey.draw();
		}

		if(!escaped && finished) {
			if(collectedEndingKeys<=0) {
				collectedEndingKeys=-1;
			}else {
				displayendingkey.draw();
			}
		}
		}

		if(movex==-100 && movey==1450) {
			movex=-1700;
			movey=3400;
			finished=false;
		}
		
		if(!menushown && !optionsshown && !pausedshown && !mapshown) {
		Ending.draw();
		endingdoor1.draw();
		endingdoor2.draw();
		}
		
		Ending.update();
		endingdoor1.update();
		endingdoor2.update();

		if(map==true && !optionsshown && !pausedshown) {
			facing=0;
			mapp();
			mapp2();
			mappdarkness();
		}
			
		if(movedelay!=0) {
			movedelay-=1;
		}
		
		
		//KEY
		if(stageVariation==0) {
		if(player.x==movex+500 && player.y==movey-500) {
			key1collected = true;}
		if(player.x==movex-800 && player.y==movey+550) {
			key2collected = true;
			key2b.x=9999;}
		if(player.x==movex-300 && player.y==movey-550) {
			key3collected = true;
			key3b.x=9999;
			key3c.x=9999;}
		if(player.x==movex-350 && player.y==movey+850) {
			key4collected = true;}
		if(player.x==movex+150 && player.y==movey+500) {
			key5collected = true;
			key5b.x=9999;
			key5c.x=9999;}
		if(player.x==movex-2250 && player.y==movey-400) {
			key6collected = true;}
		if(player.x==movex-100 && player.y==movey-1050) {
			key7collected = true;}
		}
		if(stageVariation==1) {
		if(player.x==movex+500 && player.y==movey-500) {
			key1collected = true;}
		if(player.x==movex-100 && player.y==movey+500) {
			key2collected = true;
			key2a.x=9999;}
		if(player.x==movex-650 && player.y==movey-250) {
			key3collected = true;
			key3a.x=9999;
			key3c.x=9999;}
		if(player.x==movex-350 && player.y==movey+850) {
			key4collected = true;}
		if(player.x==movex-1100 && player.y==movey+100) {
			key5collected = true;
			key5a.x=9999;
			key5c.x=9999;}
		if(player.x==movex-2250 && player.y==movey-400) {
			key6collected = true;}
		if(player.x==movex-100 && player.y==movey-1050) {
			key7collected = true;}
		}

		if(stageVariation==2) {
		if(player.x==movex+500 && player.y==movey-500) {
			key1collected = true;}
		if(player.x==movex-800 && player.y==movey+550) {
			key2collected = true;
			key2b.x=9999;}
		if(player.x==movex+200 && player.y==movey+100) {
			key3collected = true;
			key3a.x=9999;
			key3b.x=9999;}
		if(player.x==movex-350 && player.y==movey+850) {
			key4collected = true;}
		if(player.x==movex-1300 && player.y==movey-350) {
			key5collected = true;
			key5a.x=9999;
			key5b.x=9999;}
		if(player.x==movex-2250 && player.y==movey-400) {
			key6collected = true;}
		if(player.x==movex-100 && player.y==movey-1050) {
			key7collected = true;}
		}

		//PINK KEY
		if(player.x==movex+1000 && player.y==movey+550) {
			pinkkey1collected = true;}
		if(stageVariation==0) {
		if(player.x==movex+800 && player.y==movey+1250) {
			pinkkey2collected = true;}
			pinkkey2b.x=9999;
		}
		if(stageVariation==1 || stageVariation==2) {
		if(player.x==movex+750 && player.y==movey-750) {
			pinkkey2collected = true;
			pinkkey2a.x=9999;}
		}
		if(stageVariation==0) {
		if(player.x==movex-2150 && player.y==movey+100) {
			pinkkey3collected = true;
			pinkkey3b.x=9999;}
		}
		if(stageVariation==1 || stageVariation==2) {
		if(player.x==movex-1850 && player.y==movey-100) {
			pinkkey3collected = true;
			pinkkey3a.x=9999;}
		}	
		if(player.x==movex-800 && player.y==movey-1150) {
			pinkkey4collected = true;}
		if(player.x==movex-100 && player.y==movey+1100) {
			pinkkey5collected = true;}

		//ORANGE KEY
		if(player.x==movex-1300 && player.y==movey-450) {
			orangekey1collected = true;}
		if(player.x==movex+1200 && player.y==movey+150) {
			orangekey2collected = true;}
		if(player.x==movex-2000 && player.y==movey+600) {
			orangekey3collected = true;}
		if(player.x==movex-1550 && player.y==movey+450) {
			orangekey4collected = true;}
		if(player.x==movex+1450 && player.y==movey-150) {
			orangekey5collected = true;}

		//BLUE KEY
		if(player.x==movex-750 && player.y==movey-850) {
			bluekey1collected = true;}
		if(player.x==movex+100 && player.y==movey+1200) {
			bluekey2collected = true;}
		if(player.x==movex+1900 && player.y==movey+1250) {
			bluekey3collected = true;}
		if(player.x==movex+1650 && player.y==movey-400) {
			bluekey4collected = true;}
		if(stageVariation==0 || stageVariation==1) {
		if(player.x==movex+1800 && player.y==movey-950) {
			bluekey5collected = true;}
			bluekey5b.x=9999;
		}
		if(stageVariation==2) {
		if(player.x==movex+1750 && player.y==movey-700) {
			bluekey5collected = true;
			bluekey5a.x=9999;}
		}

		if(player.x==movex+350 && player.y==movey-450) {
			door1opened = true;}
		if(player.x==movex+-1000 && player.y==movey+100) {
			door2opened = true;}
		if(player.x==movex+650 && player.y==movey+500) {
			door3opened = true;}
		if(player.x==movex+800 && player.y==movey+200) {
			door4opened = true;}
		if(player.x==movex+950 && player.y==movey+250) {
			door5opened = true;}
		if(player.x==movex+0 && player.y==movey+1250) {
			door6opened = true;}
		if(player.x==movex+-1500 && player.y==movey+350) {
			door7opened = true;}

		if(player.x==movex+-850 && player.y==movey+800) {
			pinkdoor1opened = true;}
		if(player.x==movex+-1000 && player.y==movey+-600) {
			pinkdoor2opened = true;}
		if(player.x==movex+-1550 && player.y==movey+350) {
			pinkdoor3opened = true;}
		if(player.x==movex+-600 && player.y==movey+-850) {
			pinkdoor4opened = true;}
		if(player.x==movex+1750 && player.y==movey+-300) {
			pinkdoor5opened = true;}

		if(player.x==movex+150 && player.y==movey+1350) {
			orangedoor1opened = true;}
		if(player.x==movex+-850 && player.y==movey+-800) {
			orangedoor2opened = true;}
		if(player.x==movex+1000 && player.y==movey+-600) {
			orangedoor3opened = true;}
		if(player.x==movex+-1700 && player.y==movey+-800) {
			orangedoor4opened = true;}
		if(player.x==movex+1450 && player.y==movey+1350) {
			orangedoor5opened = true;}
		
		if(player.x==movex+-2150 && player.y==movey+-1050) {
			bluedoor1opened = true;}
		if(player.x==movex+-2200 && player.y==movey+-1150) {
			bluedoor2opened = true;}
		if(player.x==movex+-2350 && player.y==movey+-800) {
			bluedoor3opened = true;}
		if(player.x==movex+-1900 && player.y==movey+-1150) {
			bluedoor4opened = true;}
		if(player.x==movex+-1800 && player.y==movey+-800) {
			bluedoor5opened = true;}
		
		//OPTIONS
		if(!menushown && !optionsshown && !pausedshown && Stroke) {
		stroke(bgColor.getRGB());
		}
		
		final int[][] BG_RGB  = {{50,0,0},{50,50,0},{0,50,0},{0,0,50},{50,0,50},{0,0,0}};
		final int[][] BG_ORGB = {{255,0,0},{255,255,0},{0,255,0},{0,0,255},{255,0,255},{0,0,0}};
		int bi = chosenBGcolor-1;
		bgColor = new Color(BG_RGB[bi][0],BG_RGB[bi][1],BG_RGB[bi][2]);
		bgColorOutline = new Color(BG_ORGB[bi][0],BG_ORGB[bi][1],BG_ORGB[bi][2]);
				
		final Color[] DIFF_COLORS = {new Color(0,255,0),new Color(255,255,0),new Color(255,0,0),new Color(255,0,255)};
		enemyDifficultyOutline = DIFF_COLORS[chosenEnemyDifficultyOutline-1];
		
		if(enemyInfo == true) {
			EnemyBorderColor = new Color(255,0,0);
		}else if(enemyInfo == false){
			EnemyBorderColor = bgColor;
		}
		

//88 --
//54 |		

		//rect(player.x, player.y, player.width, player.height); // Draw player
		if(!menushown && !optionsshown && !pausedshown && !mapshown) {
			player.draw();
		}

	}
	
	
	//x:-240/+195     y:-120/+145
	//x:400			  y:280
	//88			  54	

	public void mapp() {
		loadMapTiles("mapp");
	}

	public void mapp2() {
		loadMapTiles("mapp2");

		//MINI DOORS
		if(door1opened==false) {
		}
		if(door2opened==false) {
		}
		if(door3opened==false) {
		}
		if(door4opened==false) {
		}
		if(door5opened==false) {
		}
		if(door6opened==false) {
		}
		if(door7opened==false) {
		}
		
		if(pinkdoor1opened==false) {
		}
		if(pinkdoor2opened==false) {
		}
		if(pinkdoor3opened==false) {
		}
		if(pinkdoor4opened==false) {
		}
		if(pinkdoor5opened==false) {
		}
		
		if(orangedoor1opened==false) {
		}
		if(orangedoor2opened==false) {
		}
		if(orangedoor3opened==false) {
		}
		if(orangedoor4opened==false) {
		}
		if(orangedoor5opened==false) {
		}
		
		if(bluedoor1opened==false) {
		}
		if(bluedoor2opened==false) {
		}
		if(bluedoor3opened==false) {
		}
		if(bluedoor4opened==false) {
		}
		if(bluedoor5opened==false) {
		}

//		rects.add(new ColorfulRectangle(500+45,280+-120, 5, 5, Color.WHITE));
//		rects.add(new ColorfulRectangle(500+40,280+105, 5, 5, Color.WHITE));

		//KEY
		
		if(stageVariation==0) {
			if(key1collected==false) {
			}
			if(key2collected==false) {
			}
			if(key3collected==false) {
			}
			if(key4collected==false) {
			}
			if(key5collected==false) {
			}
			if(key6collected==false) {
			}
			if(key7collected==false) {
			}
		} else if(stageVariation==1) {
			if(key1collected==false) {
			}
			if(key2collected==false) {
			}
			if(key3collected==false) {
			}
			if(key4collected==false) {
			}
			if(key5collected==false) {
			}
			if(key6collected==false) {
			}
			if(key7collected==false) {
			}
		}if(stageVariation==2) {
			if(key1collected==false) {
			}
			if(key2collected==false) {
			}
			if(key3collected==false) {
			}
			if(key4collected==false) {
			}
			if(key5collected==false) {
			}
			if(key6collected==false) {
			}
			if(key7collected==false) {
			}
		}

		if(pinkkey1collected==false) {
		}
		if(stageVariation==0) {
		if(pinkkey2collected==false) {
		}}
		if(stageVariation==1 || stageVariation==2) {
		if(pinkkey2collected==false) {
		}}
		if(stageVariation==0) {
		if(pinkkey3collected==false) {
		}}
		if(stageVariation==1 || stageVariation==2) {
		if(pinkkey3collected==false) {
		}}
		if(pinkkey4collected==false) {
		}
		if(pinkkey5collected==false) {
		}

		if(orangekey1collected==false) {
		}
		if(orangekey2collected==false) {
		}
		if(orangekey3collected==false) {
		}
		if(orangekey4collected==false) {
		}
		if(orangekey5collected==false) {
		}

		if(bluekey1collected==false) {
		}
		if(bluekey2collected==false) {
		}
		if(bluekey3collected==false) {
		}
		if(bluekey4collected==false) {
		}
		if(stageVariation==0 || stageVariation==1) {
		if(bluekey5collected==false) {
		}
		}
		if(stageVariation==2) {
		if(bluekey5collected==false) {
		}
		}
		
		if(wall1==true) {
		}
		
		if(wall2==true) {
		}
		
		
		
		//rects.add(new ColorfulRectangle(435+-movex/11,305+-movey/11, 9, 9, Color.BLUE));

		//rects.add(new ColorfulRectangle(433+-movex/10,303+-movey/10, 9, 9, Color.RED));
		//rects.add(new ColorfulRectangle(435+-movex/10,305+-movey/10, 9, 9, Color.BLUE));
	}
	public void endingBlocks() {

		if(endingBlockSwitch<10) {

			endingBlockSwitch+=1;
		}else if(endingBlockSwitch>=10 && endingBlockSwitch<20) {

			endingBlockSwitch+=1;
		}else if(endingBlockSwitch>=20 && endingBlockSwitch<30) {

			endingBlockSwitch+=1;
		}
		if(endingBlockSwitch==30) {
			endingBlockSwitch=0;
		}

	}

	public void buildings() {
		loadWorldTiles();

//		enemyBorder.add(new ColorfulRectangle(movex+-1950,movey+300, 50, 50, EnemyBorderColor));
		
		
		rects.add(new ColorfulRectangle(movex+-50,movey+-100, 50, 50, Color.WHITE));	
		rects.add(new ColorfulRectangle(movex+400,movey+-250, 50, 50, Color.WHITE)); 
		//map
		if(finished==false)
		if(finished==false)
		
		
		if(stageVariation==0 || stageVariation==1) {
		}
		if(stageVariation==2) {
		}

		//TOP BORDER

		//LEFT BORDER

		//BOTTOM BORDER
		//rects.add(new ColorfulRectangle(movex+-2350,movey+1450, 4300, 50, Color.WHITE));

		//RIGHT BORDER
		//rects.add(new ColorfulRectangle(movex+1950,movey+-1150, 50, 2600, Color.WHITE));

		if(secret==false) {
		}
		
		//SECRET BORDER
		if(secret==true) {

		rects.add(new ColorfulRectangle(movex+2050,movey-1300, 50, 2250, bgColor));
		rects.add(new ColorfulRectangle(movex-1550,movey-1300, 3650, 50, bgColor));
		}

		//WALL
		if(wall1==true) {
			rects.add(new ColorfulRectangle(movex+450,movey+550, 50, 50, Color.DARK_GRAY));		
		}

		
		//WALL 2
		if(wall2==true) {
		}

		int marker2;
	}
	
	public void buildings2() {
		loadWorldTiles2();
	}

	public void mappdarkness() {
		loadDarkTiles();
	}

	public void buildingdarkness() {
		loadDarkTiles2();
	}
	
	public void menuBlocks() {
		loadMapTiles("menu");
	}
	
	public void pausedBlocks() {
		loadMapTiles("paused");
	}
	
	public void optionsBlocks() {
		loadMapTiles("options");
		
		//BACK ARROW

		//STROKE
		//X 50-350
		//Y 50-150
		//S
		//T
		//R
		//O
		//K
		//E
		//:
		//CHECK MARK
		if(Stroke==true) {
		}
		//X MARK
		if(Stroke==false) {
		}
		
		//BG COLOR
		//OUTLINE
		rects.add(new ColorfulRectangle(440,43, 320, 10, bgColorOutline));
		rects.add(new ColorfulRectangle(440,53, 10, 100, bgColorOutline));
		rects.add(new ColorfulRectangle(750,53, 10, 100, bgColorOutline));
		rects.add(new ColorfulRectangle(440,153, 320, 10, bgColorOutline));
		//C
		//O
		//L
		//O
		//R

		//:
		//RED
		//YELLOW
		//GREEN
		//BLUE
		//MAGENTA
		//BLACK
		
		//ENEMY DIFFICULTY	
		//OUTLINE
		rects.add(new ColorfulRectangle(40,187, 320, 10, enemyDifficultyOutline));
		rects.add(new ColorfulRectangle(40,197, 10, 100, enemyDifficultyOutline));
		rects.add(new ColorfulRectangle(350,197, 10, 100, enemyDifficultyOutline));
		rects.add(new ColorfulRectangle(40,297, 320, 10, enemyDifficultyOutline));
		//E
		//N
		//E
		//M
		//Y
		//:
		//Easy
		//Medium		
		//Hard
		//Extra Hard
		
		//GRAYSCALE
		//C
		//O
		//L
		//O
		//R
		//S
		//:
		//CHECK MARK
		if(GrayScale==true) {
		}
		//X MARK
		if(GrayScale==false) {
		}
		
		//FLASHING LIGHTS

		//F
		//L
		//A
		//S		
		//H		
		//I		
		//N
		//G
		//:
		//CHECK MARK
		if(FlashingLights) {
		}
		//X MARK
		if(!FlashingLights) {
		}
	}
	
	boolean playerInterectsBlock() {
		for(Rectangle r: rects) {
				if( r.intersects(player)){
					return true;
				}
		}
		return false;
	}

	boolean enemyInterectsBlock(Enemy e) {
		for(Rectangle r: rects) {
			if( r.intersects(e)){
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
	
	
	boolean playerupIntersectsDoorWithoutKey() {
		boolean returnValue = false;
		for(Entry<ColorfulRectangle,KeyCount> e: doorToKey.entrySet()) {
		ColorfulRectangle door = e.getKey();
		KeyCount collectedKeys = e.getValue();
		ColorfulRectangle Endingdoor1 = e.getKey();
		KeyCount collectedEndingKeys = e.getValue();
		
		if(playerup.intersects(door) && collectedKeys.keys==0) {
			returnValue = true;
		}
		if(finished==true) {
		if(playerup.intersects(Endingdoor1) && collectedEndingKeys.keys==0) {
			returnValue = false;
		}
		}
		}
		return returnValue;
	}
	
	boolean playerdownIntersectsDoorWithoutKey() {
		boolean returnValue = false;
		for(Entry<ColorfulRectangle,KeyCount> e: doorToKey.entrySet()) {
		ColorfulRectangle door = e.getKey();
		KeyCount collectedKeys = e.getValue();
		ColorfulRectangle Endingdoor1 = e.getKey();
		KeyCount collectedEndingKeys = e.getValue();

		if(playerdown.intersects(door) && collectedKeys.keys==0) {
			returnValue = true;
		}
		if(finished==true) {
		if(playerdown.intersects(Endingdoor1) && collectedEndingKeys.keys==0) {
			returnValue = false;
		}
		}
		}
		return returnValue;
	}

	
	boolean playerleftIntersectsDoorWithoutKey() {
		boolean returnValue = false;
		for(Entry<ColorfulRectangle,KeyCount> e: doorToKey.entrySet()) {
		ColorfulRectangle door = e.getKey();
		KeyCount collectedKeys = e.getValue();
		
		if(playerleft.intersects(door) && collectedKeys.keys==0) {
			returnValue = true;
		}
		}
		return returnValue;
	}
	
	boolean playerrightIntersectsDoorWithoutKey() {
		boolean returnValue = false;
		for(Entry<ColorfulRectangle,KeyCount> e: doorToKey.entrySet()) {
		ColorfulRectangle door = e.getKey();
		KeyCount collectedKeys = e.getValue();
		
		if(playerright.intersects(door) && collectedKeys.keys==0) {
			returnValue = true;
		}
		}
		return returnValue;
	}

	public void keyPressed() {

		if (key == CODED) {
			if(menushown==false) {
			if(map==false) {
				if (keyCode == UP) {

					if(playerupIntersectsDoorWithoutKey()==false) {
					
					if(playerupInterectsBlock()==false && movedelay<=0) {
						for (int i = 0; i < 2; i++) {
							movey+=25;
							draw();
						}
						facing=1;
						movedelay=1;
					}
					
					if(nocliped==true && build==true) {
						rects.clear();
					}
										
					teleportavaible=true;

					if(nocliped==false && playerInterectsBlock()) {
						movey-=50;
					}

					if(noclip==0) {
						noclip=1;
					}else if(noclip==1) {
						noclip=2;
					}else if(noclip==2) {
						noclip=2;
					}else{
						noclip=0;
					}
				}

				} else if (keyCode == DOWN) {

					if(playerdownIntersectsDoorWithoutKey()==false) {
					
					if(playerdownInterectsBlock()==false && movedelay<=0) {
						for (int i = 0; i < 2; i++) {
							movey-=25;
							draw();
						}
						facing=3;
						movedelay=1;
					}

					if(nocliped==true && build==true) {
						rects.clear();
					}
					
					//teleportavaible=true;

					if(nocliped==false && playerInterectsBlock()) {
						movey+=50;
					}

					if(noclip==2) {
						noclip=3;
					}else if(noclip==3) {
						noclip=4;
					}else{
						noclip=0;
					}
				}

				} else if (keyCode == LEFT) {

					if(playerleftIntersectsDoorWithoutKey()==false) {

					if(playerleftInterectsBlock()==false && movedelay<=0) {
						for (int i = 0; i < 2; i++) {
							movex+=25;
							draw();
						}
						facing=2;
						movedelay=1;
					}

					if(nocliped==true && build==true) {
						rects.clear();
					}
					
					//teleportavaible=true;

					if(nocliped==false && playerInterectsBlock()) {
						movex-=50;
					}	

					if(noclip==4) {
						noclip=5;
					}else if(noclip==6) {
						noclip=7;
					}else{
						noclip=0;
					}
					}
					
				} else if (keyCode == RIGHT) {

					if(playerrightIntersectsDoorWithoutKey()==false) {

					if(playerrightInterectsBlock()==false && movedelay<=0) {
						for (int i = 0; i < 2; i++) {
							movex-=25;
							draw();
						}
						facing=4;
						movedelay=1;
					}

					if(nocliped==true && build==true) {
						rects.clear();
					}
						
						//teleportavaible=true;

						if(nocliped==false && playerInterectsBlock()) {
							movex+=50;
						}

						if(noclip==5) {
							noclip=6;
						}else if(noclip==7) {
							noclip=8;
						}else{
							noclip=0;
						}
					}
				}
			}
			}
			if (keyCode == SHIFT) {
//				MAP
//				if(!pausedshown && !menushown && !optionsshown && !showTeleport && !finished) {
//				if(map==false) {
//					map=true;
//					mapshown=true;
//					facing=-1;
//				}else if(map==true) {
//					map=false;
//					mapshown=false;
//				}
//				}
//				if(build==true){
//					rects.clear();
//				}
				
				//BUILD MODE
				if(build && nocliped) {
				build=false;
				nocliped=false;
				}else {
				build=true;
				nocliped=true;
				}

												
			} else if (keyCode == ALT) {
//				CHANGE BLOCK SIZE (BUILD)
				blockplacesize+=1;
						if(blockplacesize>3) {
						blockplacesize=0;
						}
						if(blockplacesize==0) {
						System.out.println("50");
						}else if(blockplacesize==1) {
						System.out.println("10");
						}else if(blockplacesize==2) {
						System.out.println("9");
						}else if(blockplacesize==3) {
						System.out.println("5");
						}
									

//				WALLS OFF
				wall1=false;
				wall2=false;
				secret=true;
//				collectedKeys+=1;
//				collectedPinkKeys+=1;
//				collectedOrangeKeys+=1;
//				collectedBlueKeys+=1;

				//shoot=1;

				//rects.clear();

			}else if (keyCode == CONTROL) {

				if(pausedshown==false && optionsshown==false) {
				pausedshown=true;
				}else {
				pausedshown=false;
				optionsshown=false;
				}
				

//				rects.clear();
				
//				BUILD
//				if(build && nocliped) {
//				build=false;
//				nocliped=false;
//				}else {
//				build=true;
//				nocliped=true;
//				}
				
//				STAGE VARIATION
//				stageVariation+=1;
//				if(stageVariation>2) {
//					stageVariation=0;
//				}
//				if(stageVariation==0) {
//				System.out.println("0");
//				}else if(stageVariation==1) {
//				System.out.println("1");
//				}else if(stageVariation==2) {
//				System.out.println("2");
//				}
	
//				TOGGLE FINISHED
//				if(wall1==true) {
//					wall1=false;
//				}else if(wall1==false) {
//					wall1=true;
//				}
//				finished=true;
//				totalYellowKeyCollected=7;
//				totalPinkKeyCollected=5;
//				totalOrangeKeyCollected=5;
//				totalBlueKeyCollected=5;
//
//				movex=50;
//				movey=-600;
//				collectedEndingKeys=2;
//
//				wall1=false;
//				wall2=false;
//
//				door1.x=10000;
//				door2.x=10000;
//				door3.x=10000;
//				door4.x=10000;
//				door5.x=10000;
//				door6.x=10000;
//				door7.x=10000;
//
//				pinkdoor1.x=10000;
//				pinkdoor2.x=10000;
//				pinkdoor3.x=10000;
//				pinkdoor4.x=10000;
//				pinkdoor5.x=10000;
//
//				orangedoor1.x=10000;
//				orangedoor2.x=10000;
//				orangedoor3.x=10000;
//				orangedoor4.x=10000;
//				orangedoor5.x=10000;
//
//				bluedoor1.x=10000;
//				bluedoor2.x=10000;
//				bluedoor3.x=10000;
//				bluedoor4.x=10000;
//				bluedoor5.x=10000;
//
//
//				key1.x=10000;
//				key2.x=10000;
//				key3.x=10000;
//				key4.x=10000;
//				key5.x=10000;
//				key6.x=10000;
//				key7.x=10000;
//
//				pinkkey1.x=10000;
//				pinkkey2.x=10000;
//				pinkkey3.x=10000;
//				pinkkey4.x=10000;
//				pinkkey5.x=10000;
//
//				orangekey1.x=10000;
//				orangekey2.x=10000;
//				orangekey3.x=10000;
//				orangekey4.x=10000;
//				orangekey5.x=10000;
//
//				bluekey1.x=10000;
//				bluekey2.x=10000;
//				bluekey3.x=10000;
//				bluekey4.x=10000;
//				bluekey5.x=10000;
//				if(build==true){
//					rects.clear();
//				}

if(showblockmap==false) {
	showblockmap=true;
}else {
	showblockmap=false;
}

			}
		}

}

	public void mousePressed() {

		//MENU PLAY
		//X 275-525
		//Y 400-500
		if(mouseX>275 && mouseX<525 && mouseY>400 && mouseY<500 && menushown) {
			menushown=false;
		}
		//OPTIONS (PAUSED)
		//X 200-600
		//Y 150-250
		if(mouseX>200 && mouseX<600 && mouseY>150 && mouseY<250 && pausedshown) {
			pausedshown=false;
			optionsshown=true;
			noDoubleClickOptions = true;
		}
		//RESUME (PAUSED)
		//X 200-600
		//Y 350-450
		if(mouseX>200 && mouseX<600 && mouseY>350 && mouseY<450 && pausedshown) {
			pausedshown=false;
		}
		//BACK (OPTIONS)
		//X 9-72
		//Y 513-567
		if(mouseX>9 && mouseX<81 && mouseY>513 && mouseY<585 && optionsshown) {
			pausedshown=true;
			optionsshown=false;
			noDoubleClickOptions = true;
		}
		//STROKE (OPTIONS)
		//X 50-350
		//Y 50-150
		if(mouseX>50 && mouseX<350 && mouseY>50 && mouseY<150 && optionsshown) {
			if(Stroke==false) {Stroke=true;}
			else if(Stroke==true) {Stroke=false;}
		}
		//GRAYSCALE (OPTIONS)
		//X 450-750
		//Y 200-300
		if(mouseX>450 && mouseX<750 && mouseY>200 && mouseY<300 && optionsshown && !noDoubleClickOptions) {
			if(GrayScale==false) {GrayScale=true;}
			else if(GrayScale==true) {GrayScale=false;}
		}else if(mouseX>450 && mouseX<750 && mouseY>200 && mouseY<300 && optionsshown && noDoubleClickOptions){
			noDoubleClickOptions=false;
		}
		//FLASHING LIGHTS (OPTION)
		//X 50-425
		//Y 350-450
		if(mouseX>50 && mouseX<425 && mouseY>350 && mouseY<450 && optionsshown) {
			if(FlashingLights==true) {
				FlashingLights=false;
			}else if(FlashingLights==false) {
				FlashingLights=true;
			}
		}
		//COLOR (OPTIONS)
		if(mouseX>657 && mouseX<675 && mouseY>63 && mouseY<99 && optionsshown) {
		chosenBGcolor=1;
		chosenBGcolorOutline=1;
		}else if(mouseX>684 && mouseX<701 && mouseY>63 && mouseY<99 && optionsshown) {
		chosenBGcolor=2;
		chosenBGcolorOutline=2;
		}else if(mouseX>711 && mouseX<729 && mouseY>63 && mouseY<99 && optionsshown) {
		chosenBGcolor=3;
		chosenBGcolorOutline=3;
		}else if(mouseX>657 && mouseX<675 && mouseY>108 && mouseY<144 && optionsshown) {
		chosenBGcolor=4;
		chosenBGcolorOutline=4;
		}else if(mouseX>684 && mouseX<701 && mouseY>108 && mouseY<144 && optionsshown) {
		chosenBGcolor=5;
		chosenBGcolorOutline=5;
		}else if(mouseX>711 && mouseX<729 && mouseY>108 && mouseY<144 && optionsshown) {
		chosenBGcolor=6;
		chosenBGcolorOutline=6;
		}

		//ENEMY OPTIONS
		if(mouseX>270 && mouseX<297 && mouseY>207 && mouseY<243 && optionsshown && !noDoubleClickOptions) {
		enemyDifficulty=1;
		chosenEnemyDifficultyOutline=1;
		}else if(mouseX>306 && mouseX<333 && mouseY>207 && mouseY<243 && optionsshown && !noDoubleClickOptions) {
		enemyDifficulty=2;
		chosenEnemyDifficultyOutline=2;
		}else if(mouseX>270 && mouseX<297 && mouseY>252 && mouseY<288 && optionsshown) {
		enemyDifficulty=3;
		chosenEnemyDifficultyOutline=3;
		}else if(mouseX>306 && mouseX<333 && mouseY>252 && mouseY<288 && optionsshown) {
		enemyDifficulty=4;
		chosenEnemyDifficultyOutline=4;
		}else {
			noDoubleClickOptions=false;
		}

		if(build==true) {
if(blockplacesize==0) { //0
	//ENEMY BORDER
//	int moX = ((mouseX/50)*50)+-movex;
//	int moY = ((mouseY/50)*50)+-movey;
//	System.out.println("enemyBorder.add(new ColorfulRectangle("+ "movex+"+ moX +",movey+" + moY + ", 50, 50, EnemyBorderColor));");
//	rects.add(new ColorfulRectangle(moX+movex,moY+movey, 50, 50, Color.RED));

	//MAP
//	int moX = ((mouseX/50)*50)+-movex;
//	int moY = ((mouseY/50)*50)+-movey;
//	System.out.println("rects.add(new ColorfulRectangle("+ "movex+"+ moX +",movey+" + moY + ", 50, 50, Color.WHITE));");
//	rects.add(new ColorfulRectangle(moX+movex,moY+movey, 50, 50, Color.WHITE));

	//MENU
	int moX = ((mouseX/50)*50);
	int moY = ((mouseY/50)*50);
	System.out.println("rects.add(new ColorfulRectangle("+ moX +"," + moY + ", 50, 50, Color.WHITE));");
	rects.add(new ColorfulRectangle(moX,moY, 50, 50, Color.WHITE));
}else if(blockplacesize==1) {
	int moX = ((mouseX/10)*10);
	int moY = ((mouseY/10)*10);
	System.out.println("rects.add(new ColorfulRectangle("+ moX +"," + moY + ", 10, 10, Color.WHITE));");
	rects.add(new ColorfulRectangle(moX,moY, 10, 10, Color.WHITE));	
}else if(blockplacesize==2) { //2
	int moXmap = ((mouseX/9)*9);
	int moYmap = ((mouseY/9)*9);
	System.out.println("rects.add(new ColorfulRectangle("+ moXmap + "," + moYmap + ", 9, 9, Color.WHITE));");
	rects.add(new ColorfulRectangle(moXmap,moYmap, 9, 9, Color.WHITE));
}else if(blockplacesize==3) {
	int moXmap = ((mouseX/5)*5)+-movex;
	int moYmap = ((mouseY/5)*5)+-movey;
	System.out.println("rects.add(new ColorfulRectangle("+ moXmap + "," + moYmap + ", 5, 5, Color.WHITE));");
	rects.add(new ColorfulRectangle(moXmap+movex,moYmap+movey, 5, 5, Color.WHITE));
}
		}
		
	}

	static public void main(String[] passedArgs) {
		PApplet.main(ExploreLess.class.getName());
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

	class ColorfulRectangle extends Rectangle{

		Color col;
		Color grayCol;

		public ColorfulRectangle(int x, int y, int width, int height, Color col, Color grayCol) {
			super(x, y, width, height);
			this.col=col;
			this.grayCol=grayCol;
		}	
		public ColorfulRectangle(int x, int y, int width, int height, Color col) {
			super(x, y, width, height);
			this.col=col;
			this.grayCol=col;
		}

		void draw(){
			
			if(GrayScale) {
				fill(col.getRGB());
			}else {
				fill(grayCol.getRGB());
			}

			rect(x, y, width, height);

		}

	}
	
	
	class Enemy extends ColorfulRectangle{
		boolean alive = true;

		int enemyfacing = 0;

		int emovedx = x;
		int emovedy = y;
		
		int enemyRandomMove=4;
		int wait = 0;
		int waitSpeed = 150;

		ColorfulRectangle enemyup = new ColorfulRectangle(x,y-50,10,10,Color.RED);
		ColorfulRectangle enemydown = new ColorfulRectangle(x,y+50,10,10, Color.RED);
		ColorfulRectangle enemyleft = new ColorfulRectangle(x-25,y,10,10, Color.RED);
		ColorfulRectangle enemyright = new ColorfulRectangle(x+25,y,10,10, Color.RED);

		ColorfulRectangle enemyup_green = new ColorfulRectangle(x,y-50,10,10,Color.GREEN);
		ColorfulRectangle enemydown_green = new ColorfulRectangle(x,y+50,10,10, Color.GREEN);
		ColorfulRectangle enemyleft_green = new ColorfulRectangle(x-50,y,10,10, Color.GREEN);
		ColorfulRectangle enemyright_green = new ColorfulRectangle(x+50,y,10,10, Color.GREEN);

		ColorfulRectangle enemyup_yellow = new ColorfulRectangle(x,y-50,20,20,Color.YELLOW);
		ColorfulRectangle enemydown_yellow = new ColorfulRectangle(x,y+50,20,20, Color.YELLOW);
		ColorfulRectangle enemyleft_yellow = new ColorfulRectangle(x-50,y,20,20, Color.YELLOW);
		ColorfulRectangle enemyright_yellow = new ColorfulRectangle(x+50,y,20,20, Color.YELLOW);

		List<ColorfulRectangle> direction = new ArrayList<ColorfulRectangle>();

		public Enemy(int x, int y, int width, int height) {

			super(x, y, width, height, Red,grayRed);

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
		//ENEMY VS BLOCK
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
		
		//ENEMY VS KEY
		boolean enemyupInterectsKey() {
			for(Key r: keys) {
				if( r.intersects(enemyup)){
					return true;
				}
			}
			return false;
		}

		boolean enemydownInterectsKey() {
			for(Key r: keys) {
				if( r.intersects(enemydown)){
					return true;
				}
			}
			return false;
		}

		boolean enemyleftInterectsKey() {
			for(Key r: keys) {
				if( r.intersects(enemyleft)){
					return true;
				}
			}
			return false;
		}

		boolean enemyrightInterectsKey() {
			for(Key r: keys) {
				if( r.intersects(enemyright)){
					return true;
				}
			}
			return false;
		}
		
		//ENEMY VS DOOR
		boolean enemyupInterectsDoor() {
			for(Door r: doors) {
				if( r.intersects(enemyup)){
					return true;
				}
			}
			return false;
		}

		boolean enemydownInterectsDoor() {
			for(Door r: doors) {
				if( r.intersects(enemydown)){
					return true;
				}
			}
			return false;
		}

		boolean enemyleftInterectsDoor() {
			for(Door r: doors) {
				if( r.intersects(enemyleft)){
					return true;
				}
			}
			return false;
		}

		boolean enemyrightInterectsDoor() {
			for(Door r: doors) {
				if( r.intersects(enemyright)){
					return true;
				}
			}
			return false;
		}
		
		//ENENY VS BORDER
		boolean enemyupInterectsBorder() {
			for(Rectangle r: enemyBorder) {
				if( r.intersects(enemyup)){
					return true;
				}
			}
			return false;
		}

		boolean enemydownInterectsBorder() {
			for(Rectangle r: enemyBorder) {
				if( r.intersects(enemydown)){
					return true;
				}
			}
			return false;
		}
		
		boolean enemyleftInterectsBorder() {
			for(Rectangle r: enemyBorder) {
				if( r.intersects(enemyleft)){
					return true;
				}
			}
			return false;
		}
		
		boolean enemyrightInterectsBorder() {
			for(Rectangle r: enemyBorder) {
				if( r.intersects(enemyright)){
					return true;
				}
			}
			return false;
		}

		public void update() {

			if(x==player.x && y==player.y) {
				movex=0;		movey=0;
			}

			enemyup.x=x;		enemyup.y=y-50;
			enemydown.x=x;		enemydown.y=y+50;
			enemyleft.x=x-50;	enemyleft.y=y;
			enemyright.x=x+50;	enemyright.y=y;
			
			enemyup_green.x=x;			enemyup_green.y=y-50;
			enemydown_green.x=x;		enemydown_green.y=y+50;
			enemyleft_green.x=x-50;		enemyleft_green.y=y;
			enemyright_green.x=x+50;	enemyright_green.y=y;
			
			enemyup_yellow.x=x-5;		enemyup_yellow.y=y-55;
			enemydown_yellow.x=x-5;		enemydown_yellow.y=y+45;
			enemyleft_yellow.x=x-55;	enemyleft_yellow.y=y-5;
			enemyright_yellow.x=x+45;	enemyright_yellow.y=y-5;

			x=movex+emovedx;	y=movey+emovedy;

			
			if(intersectsBlock(enemydown) && intersectsBlock(enemyright) && intersectsBlock(enemyleft)) {
				enemyfacing=1;
				if(enemyInfo==true) {
				enemyup_yellow.draw();
				}
			}
			if(intersectsBlock(enemyup) && intersectsBlock(enemyright) && intersectsBlock(enemyleft)) {
				enemyfacing=2;
				if(enemyInfo==true) {
				enemydown_yellow.draw();
				}
			}
			if(intersectsBlock(enemyup) && intersectsBlock(enemydown) && intersectsBlock(enemyleft)) {
				enemyfacing=3;
				if(enemyInfo==true) {
				enemyright_yellow.draw();
				}
			}
			if(intersectsBlock(enemyup) && intersectsBlock(enemydown) && intersectsBlock(enemyright)) {
				enemyfacing=4;
				if(enemyInfo==true) {
				enemyleft_yellow.draw();
				}
			}
			
			if(enemyInfo==true) {
			if(enemyupInterectsBlock() || enemyupInterectsKey() || enemyupInterectsBorder()) {
				enemyup.draw();
			}else {
				enemyup_green.draw();
			}
			if(enemydownInterectsBlock() || enemydownInterectsKey() || enemydownInterectsBorder()) {
				enemydown.draw();
			}else {
				enemydown_green.draw();
			}
			if(enemyleftInterectsBlock() || enemyleftInterectsKey() || enemyleftInterectsBorder()) {
				enemyleft.draw();
			}else {
				enemyleft_green.draw();
			}
			if(enemyrightInterectsBlock() || enemyrightInterectsKey() || enemyrightInterectsBorder()) {
				enemyright.draw();
			}else {
				enemyright_green.draw();
			}
			}
			
			//System.out.println("up: " + intersectsBlock(enemyup) + "  down: " + intersectsBlock(enemydown) + "  right: " + intersectsBlock(enemyright) + "  left: " + intersectsBlock(enemyleft));

			
			if(enemymove == true) {

				wait+=1;

				if(wait>=waitSpeed) {
					wait=0;

					
					if(enemymove == true) {

						for (int i = 0; i < 100; i++) {
							enemyRandomMove = new Random().nextInt(4);
							//System.out.println(enemyRandomMove);
							
							if(enemyupInterectsKey()) {
								if(!intersectsBlock(enemydown)) {
									enemyfacing=2;
								}else if(!intersectsBlock(enemyright)) {
									enemyfacing=3;
								}else if(!intersectsBlock(enemyleft)) {
									enemyfacing=4;
								}
							}
							if(enemydownInterectsKey()) {
								if(!intersectsBlock(enemyup)) {
									enemyfacing=1;
								}else if(!intersectsBlock(enemyright)) {
									enemyfacing=3;
								}else if(!intersectsBlock(enemyleft)) {
									enemyfacing=4;
								}
							}
							if(enemyrightInterectsKey()) {
								if(!intersectsBlock(enemyleft)) {
									enemyfacing=4;
								}else if(!intersectsBlock(enemyup)) {
									enemyfacing=1;
								}else if(!intersectsBlock(enemydown)) {
									enemyfacing=2;
								}
							}
							if(enemyleftInterectsKey()) {
								if(!intersectsBlock(enemyright)) {
									enemyfacing=3;
								}else if(!intersectsBlock(enemyup)) {
									enemyfacing=1;
								}else if(!intersectsBlock(enemydown)) {
									enemyfacing=2;
								}
							}
							
							if(enemyfacing!=2 && !intersectsBlock(enemyup) && !enemyupInterectsKey() && !enemyupInterectsDoor() && !enemyupInterectsBorder() && enemyRandomMove==0) {
								emovedy-=50;
								enemyfacing=1;
								break;
							}
							if(enemyfacing!=1 && !intersectsBlock(enemydown) && !enemydownInterectsKey() && !enemydownInterectsDoor() && !enemydownInterectsBorder() && enemyRandomMove==1) {
								emovedy+=50;
								enemyfacing=2;	
								break;
							}
							if(enemyfacing!=4 && !intersectsBlock(enemyright) && !enemyrightInterectsKey() && !enemyrightInterectsDoor() && !enemyrightInterectsBorder() && enemyRandomMove==2) {
								emovedx+=50;
								enemyfacing=3;
								break;
							}
							if(enemyfacing!=3 && !intersectsBlock(enemyleft) && !enemyleftInterectsKey() && !enemyleftInterectsDoor() && !enemyleftInterectsBorder() && enemyRandomMove==3) {
								emovedx-=50;
								enemyfacing=4;
								break;
							}

						}
					}					
				}
			}
			if(enemyDifficulty == 1) {
				waitSpeed = 200;
			}else if(enemyDifficulty == 2) {
				waitSpeed = 150;
			}else if(enemyDifficulty == 3) {
				waitSpeed = 75;
			}else if(enemyDifficulty == 4) {
				waitSpeed = 10;
			}
			
		}

	}
	
	class KeyCount {
		int keys = 0;
		
	}

	class Key extends ColorfulRectangle{

		int keyx=x;
		int keyy=y;

		boolean collected = false;

		public Key(int x, int y, int width, int height, Color color, Color grayColor) {

			super(x, y, width, height, color, grayColor);

		}

		@Override
		public boolean equals(Object obj) {
			return this==obj;
		}
		@Override
		public int hashCode() {
			return Objects.hash(keyx, keyy);
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
			//	collectedKeys+=1;
				
				KeyCount keyCount = keyToKeyCount.get(this);
				
				keyCount.keys+=1;
				
				keyx=+9999;
				keyy=+9999;
				
				totalYellowKeyCollected+=1;
			}

		}

	}

	class Door extends ColorfulRectangle{

		int doorx=x;
		int doory=y;
		Color innerColor;
		boolean open = false;
	ColorfulRectangle Doorin;
			
		public Door(int x, int y, int width, int height, Color color, Color grayColor) {
			super(x, y, width, height, Color.WHITE, grayColor);
			this.innerColor = color;
		}

		void draw() {

			if(!open) {
				fill(Color.WHITE.getRGB());
				rect(x, y, width, height);
				Doorin = new ColorfulRectangle(x+10,y+10,30,30,innerColor,grayCol);
				Doorin.draw();
			}	
		}

		@Override
		public boolean equals(Object obj) {
			return this==obj;
		}
		@Override
		public int hashCode() {
			return Objects.hash(doorx, doory);
		}
		
		public void update() {

		

			x=doorx+movex;
			y=doory+movey;
			KeyCount collectedKeys = doorToKey.get(this);
			if(x==player.x && y==player.y && collectedKeys.keys>=1){
				collectedKeys.keys-=1;
				doorx=+9999;
				doory=+9999;
				Doorin.x=+9999;
				Doorin.y=+9999;

			}else if(x==player.x && y==player.y && collectedKeys.keys==0){
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

	class SecretEnding extends ColorfulRectangle{

		int endingx=x;
		int endingy=y;

		int colorSwitch = 0;

		boolean open = false;

		public SecretEnding(int x, int y, int width, int height) {

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

			ColorfulRectangle SecretEnding1 = new ColorfulRectangle(x,y,50,50,Color.RED);
			ColorfulRectangle SecretEnding2 = new ColorfulRectangle(x+1,y+1,48,48,Color.MAGENTA);
			ColorfulRectangle SecretEnding3 = new ColorfulRectangle(x+2,y+2,46,46,Color.ORANGE);
			ColorfulRectangle SecretEnding4 = new ColorfulRectangle(x+3,y+3,46,46,Color.PINK);
			ColorfulRectangle SecretEnding5 = new ColorfulRectangle(x+4,y+4,42,42,Color.BLUE);
			ColorfulRectangle SecretEnding6 = new ColorfulRectangle(x+5,y+5,40,40,Color.YELLOW);
			ColorfulRectangle SecretEnding7 = new ColorfulRectangle(x+6,y+6,38,38,Color.PINK);
			ColorfulRectangle SecretEnding8 = new ColorfulRectangle(x+7,y+7,36,36,Color.GREEN);
			ColorfulRectangle SecretEnding9 = new ColorfulRectangle(x+8,y+8,34,34,Color.BLUE);
			ColorfulRectangle SecretEnding10 = new ColorfulRectangle(x+9,y+9,32,32,Color.MAGENTA);
			ColorfulRectangle SecretEnding11 = new ColorfulRectangle(x+10,y+10,30,30,Color.BLUE);
			ColorfulRectangle SecretEnding12 = new ColorfulRectangle(x+11,y+11,28,28,Color.PINK);
			ColorfulRectangle SecretEnding13 = new ColorfulRectangle(x+12,y+12,26,26,Color.MAGENTA);
			ColorfulRectangle SecretEnding14 = new ColorfulRectangle(x+13,y+13,24,24,Color.BLUE);
			ColorfulRectangle SecretEnding15 = new ColorfulRectangle(x+12,y+12,22,22,Color.PINK);
			ColorfulRectangle SecretEnding16 = new ColorfulRectangle(x+13,y+13,22,22,Color.MAGENTA);
			ColorfulRectangle SecretEnding17 = new ColorfulRectangle(x+14,y+14,22,22,Color.BLUE);
			ColorfulRectangle SecretEnding18 = new ColorfulRectangle(x+15,y+15,20,20,Color.LIGHT_GRAY);
			ColorfulRectangle SecretEnding19 = new ColorfulRectangle(x+16,y+16,20,20,Color.PINK);
			ColorfulRectangle SecretEnding20 = new ColorfulRectangle(x+17,y+17,15,15,Color.WHITE);

			if(colorSwitch==0) {
				SecretEnding1.draw();
			}else if(colorSwitch==1) {
				SecretEnding2.draw();
			}else if(colorSwitch==2) {
				SecretEnding3.draw();
			}else if(colorSwitch==3) {
				SecretEnding4.draw();
			}else if(colorSwitch==4) {
				SecretEnding5.draw();
			}else if(colorSwitch==5) {
				SecretEnding6.draw();
			}else if(colorSwitch==6) {
				SecretEnding7.draw();
			}else if(colorSwitch==7) {
				SecretEnding8.draw();
			}else if(colorSwitch==8) {
				SecretEnding9.draw();
			}else if(colorSwitch==9) {
				SecretEnding10.draw();
			}else if(colorSwitch==10) {
				SecretEnding11.draw();
			}else if(colorSwitch==11) {
				SecretEnding12.draw();
			}else if(colorSwitch==12) {
				SecretEnding13.draw();
			}else if(colorSwitch==13) {
				SecretEnding14.draw();
			}else if(colorSwitch==14) {
				SecretEnding15.draw();
			}else if(colorSwitch==15) {
				SecretEnding16.draw();
			}else if(colorSwitch==16) {
				SecretEnding17.draw();
			}else if(colorSwitch==17) {
				SecretEnding18.draw();
			}else if(colorSwitch==18) {
				SecretEnding19.draw();
			}else if(colorSwitch==19) {
				SecretEnding20.draw();
			}

			colorSwitch+=1;

			if(colorSwitch>=20) {
				colorSwitch=0;
			}

			if(x==player.x && y==player.y){

			}

		}

	}

	
	class SecretTeleport extends ColorfulRectangle{

		int telex=x;
		int teley=y;

		int colorSwitch = 0;

		boolean open = false;

		public SecretTeleport(int x, int y, int width, int height) {

			super(x, y, width, height, Color.BLACK);

		}

		void draw() {

			if(!open) {
				super.draw();
			}	

		}

		public void update() {

			x=telex+movex;
			y=teley+movey;

			ColorfulRectangle SecretEnding1 = new ColorfulRectangle(x,y,50,50,Color.BLACK);
			ColorfulRectangle SecretEnding2 = new ColorfulRectangle(x,y,50,50,Color.BLACK);
			ColorfulRectangle SecretEnding3 = new ColorfulRectangle(x,y,50,50,Color.BLACK);
			ColorfulRectangle SecretEnding4 = new ColorfulRectangle(x,y,50,50,Color.BLACK);
			ColorfulRectangle SecretEnding5 = new ColorfulRectangle(x,y,50,50,Color.BLACK);
			ColorfulRectangle SecretEnding6 = new ColorfulRectangle(x,y,50,50,Color.BLACK);
			ColorfulRectangle SecretEnding7 = new ColorfulRectangle(x,y,50,50,Color.BLACK);
			ColorfulRectangle SecretEnding8 = new ColorfulRectangle(x,y,50,50,Color.WHITE);
			ColorfulRectangle SecretEnding9 = new ColorfulRectangle(x,y,50,50,Color.WHITE);
			ColorfulRectangle SecretEnding10 = new ColorfulRectangle(x,y,50,50,Color.WHITE);
			ColorfulRectangle SecretEnding11 = new ColorfulRectangle(x,y,50,50,Color.WHITE);
			ColorfulRectangle SecretEnding12 = new ColorfulRectangle(x,y,50,50,Color.WHITE);
			ColorfulRectangle SecretEnding13 = new ColorfulRectangle(x,y,50,50,Color.WHITE);
			ColorfulRectangle SecretEnding14 = new ColorfulRectangle(x,y,50,50,Color.WHITE);

			if(colorSwitch==0) {
				SecretEnding1.draw();
			}else if(colorSwitch==1) {
				SecretEnding2.draw();
			}else if(colorSwitch==2) {
				SecretEnding3.draw();
			}else if(colorSwitch==3) {
				SecretEnding4.draw();
			}else if(colorSwitch==4) {
				SecretEnding5.draw();
			}else if(colorSwitch==5) {
				SecretEnding6.draw();
			}else if(colorSwitch==6) {
				SecretEnding7.draw();
			}else if(colorSwitch==7) {
				SecretEnding8.draw();
			}else if(colorSwitch==8) {
				SecretEnding9.draw();
			}else if(colorSwitch==9) {
				SecretEnding10.draw();
			}else if(colorSwitch==10) {
				SecretEnding11.draw();
			}else if(colorSwitch==11) {
				SecretEnding12.draw();
			}else if(colorSwitch==12) {
				SecretEnding13.draw();
			}else if(colorSwitch==13) {
				SecretEnding14.draw();
			}
			colorSwitch+=1;

			if(colorSwitch>=14) {
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
			
			if(Stroke) {
				stroke(bgColor.getRGB());
			}

		}

		@Override
		public boolean equals(Object obj) {
			return this==obj;
		}
		@Override
		public int hashCode() {
			return Objects.hash(endingdoorx, endingdoory);
		}
		
		public void update() {
			
			if(mapshown==false && !optionsshown && !pausedshown) {
							
			ColorfulRectangle Endingred = new ColorfulRectangle(x+9,y+9,30,30,Red,grayRed);
			ColorfulRectangle Endingorange = new ColorfulRectangle(x+9,y+9,30,30,Orange,grayOrange);
			ColorfulRectangle Endingyellow = new ColorfulRectangle(x+9,y+9,30,30,Yellow,grayYellow);
			ColorfulRectangle Endinggreen = new ColorfulRectangle(x+9,y+9,30,30,Green,grayGreen);
			ColorfulRectangle Endingblue = new ColorfulRectangle(x+9,y+9,30,30,Blue,grayBlue);
			ColorfulRectangle Endingpurple = new ColorfulRectangle(x+9,y+9,30,30,Magenta,grayMagenta);
			ColorfulRectangle Endinggray = new ColorfulRectangle(x+9,y+9,30,30,Color.LIGHT_GRAY);
			ColorfulRectangle Endingwhite = new ColorfulRectangle(x+9,y+9,30,30,Color.WHITE);

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
			KeyCount collectedKeys = doorToKey.get(this);
			//System.out.println(collectedEndingKeys);

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

			}else if(x==player.x && y==player.y && collectedEndingKeys>=1){
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
	
}

//hi
