import java.awt.Color;
import java.util.Iterator;

import Explore.ColorfulRectangle;


//TOP BORDER
/*rects.add(new ColorfulRectangle(movex+-800,movey+-1200, 50, 50, Color.WHITE));
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
*///rects.add(new ColorfulRectangle(movex+-2400,movey+-1200, 2850, 50, Color.WHITE));
//rects.add(new ColorfulRectangle(movex+-2400,movey+-1200, 50, 50, Color.WHITE));
/*
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
rects.add(new ColorfulRectangle(movex+400,movey+-1200, 50, 50, Color.WHITE));*/
//rects.add(new ColorfulRectangle(movex+500,movey+-1200, 1450, 50, Color.WHITE));
/*
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
*///rects.add(new ColorfulRectangle(movex+1950,movey+-1200, 50, 50, Color.WHITE));


//LEFT BORDER
//rects.add(new ColorfulRectangle(movex+-2400,movey+-1150, 50, 2600, Color.WHITE));
/*
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
rects.add(new ColorfulRectangle(movex+-2400,movey+1400, 50, 50, Color.WHITE));*/
//rects.add(new ColorfulRectangle(movex+-2400,movey+1450, 50, 50, Color.WHITE));


//BOTTOM BORDER
//rects.add(new ColorfulRectangle(movex+-2400,movey+1450, 50, 50, Color.WHITE));
//rects.add(new ColorfulRectangle(movex+-2350,movey+1450, 4300, 50, Color.WHITE));
/*
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
*///rects.add(new ColorfulRectangle(movex+1950,movey+1450, 50, 50, Color.WHITE));


//RIGHT BORDER
/*rects.add(new ColorfulRectangle(movex+1950,movey+1400, 50, 50, Color.WHITE));
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
rects.add(new ColorfulRectangle(movex+1950,movey+-1100, 50, 50, Color.WHITE));*/
//rects.add(new ColorfulRectangle(movex+1950,movey+-1150, 50, 2600, Color.WHITE));



//hi	}
	






