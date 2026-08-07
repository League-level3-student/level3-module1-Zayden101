
public class exploreStorage {

//	public void menuBlocks() {
				
//
//		//X 275-525
//		//Y 400-500
//		
//		//PLAY Background
//		rects.add(new ColorfulRectangle(275,400, 250, 50, Color.WHITE));
//		rects.add(new ColorfulRectangle(275,450, 250, 50, Color.WHITE));
//		//P
//		rects.add(new ColorfulRectangle(288,423, 9, 54, Color.BLACK));
//		rects.add(new ColorfulRectangle(297,423, 27, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(315,432, 9, 27, Color.BLACK));
//		rects.add(new ColorfulRectangle(297,450, 18, 9, Color.BLACK));
//		//L
//		rects.add(new ColorfulRectangle(351,423, 9, 54, Color.BLACK));
//		rects.add(new ColorfulRectangle(360,468, 27, 9, Color.BLACK));
//		//A
//		rects.add(new ColorfulRectangle(414,423, 9, 54, Color.BLACK));
//		rects.add(new ColorfulRectangle(423,423, 27, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(441,432, 9, 45, Color.BLACK));
//		rects.add(new ColorfulRectangle(423,450, 18, 9, Color.BLACK));
//		//Y
//		rects.add(new ColorfulRectangle(477,423, 9, 27, Color.BLACK));
//		rects.add(new ColorfulRectangle(504,423, 9, 27, Color.BLACK));
//		rects.add(new ColorfulRectangle(486,450, 18, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(490,455, 10, 20, Color.BLACK));
//		rects.add(new ColorfulRectangle(485,445, 20, 5, Color.BLACK));
//		rects.add(new ColorfulRectangle(485,440, 5, 5, Color.BLACK));
//		rects.add(new ColorfulRectangle(500,440, 5, 5, Color.BLACK));
//		rects.add(new ColorfulRectangle(480,450, 10, 5, Color.BLACK));
//		rects.add(new ColorfulRectangle(500,450, 10, 5, Color.BLACK));
//		
//		
//		//EXPLORE Background
//		rects.add(new ColorfulRectangle(50,50, 700, 50, Color.WHITE));
//		rects.add(new ColorfulRectangle(50,100, 700, 50, Color.WHITE));
//		rects.add(new ColorfulRectangle(50,150, 700, 50, Color.WHITE));		
//		rects.add(new ColorfulRectangle(50,200, 700, 50, Color.WHITE));
//		//E
//		rects.add(new ColorfulRectangle(63,63, 9, 171, Color.BLACK));
//		rects.add(new ColorfulRectangle(72,225, 81, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(72,63, 90, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(72,144, 36, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(72,72, 81, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(72,81, 9, 63, Color.GRAY));
//		rects.add(new ColorfulRectangle(72,153, 36, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(72,162, 9, 63, Color.GRAY));
//		rects.add(new ColorfulRectangle(63,234, 90, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(108,144, 9, 18, Color.GRAY));
//		rects.add(new ColorfulRectangle(153,63, 9, 18, Color.GRAY));
//		rects.add(new ColorfulRectangle(153,225, 9, 18, Color.GRAY));
//		//X
//		rects.add(new ColorfulRectangle(225,63, 9, 36, Color.BLACK));
//		rects.add(new ColorfulRectangle(225,198, 9, 36, Color.BLACK));
//		rects.add(new ColorfulRectangle(171,198, 9, 36, Color.BLACK));
//		rects.add(new ColorfulRectangle(189,126, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(171,63, 9, 36, Color.BLACK));
//		rects.add(new ColorfulRectangle(207,153, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(207,126, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(189,153, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(180,90, 9, 45, Color.BLACK));
//		rects.add(new ColorfulRectangle(216,90, 9, 45, Color.BLACK));
//		rects.add(new ColorfulRectangle(180,162, 9, 45, Color.BLACK));
//		rects.add(new ColorfulRectangle(216,162, 9, 45, Color.BLACK));
//		rects.add(new ColorfulRectangle(198,135, 9, 27, Color.BLACK));
//		rects.add(new ColorfulRectangle(171,234, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(225,234, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(180,207, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(189,171, 9, 36, Color.GRAY));
//		rects.add(new ColorfulRectangle(216,135, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(207,144, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(225,99, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(198,162, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(234,72, 9, 27, Color.GRAY));
//		rects.add(new ColorfulRectangle(225,108, 9, 27, Color.GRAY));
//		rects.add(new ColorfulRectangle(180,72, 9, 18, Color.GRAY));
//		rects.add(new ColorfulRectangle(189,90, 9, 36, Color.GRAY));
//		rects.add(new ColorfulRectangle(180,216, 9, 27, Color.GRAY));
//		rects.add(new ColorfulRectangle(180,63, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(234,63, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(216,153, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(225,162, 9, 36, Color.GRAY));
//		rects.add(new ColorfulRectangle(234,198, 9, 45, Color.GRAY));
//		//P
//		rects.add(new ColorfulRectangle(315,63, 9, 81, Color.BLACK));		
//		rects.add(new ColorfulRectangle(252,135, 63, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(252,63, 9, 72, Color.BLACK));
//		rects.add(new ColorfulRectangle(261,63, 54, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(252,144, 9, 90, Color.BLACK));
//		rects.add(new ColorfulRectangle(261,72, 54, 9, Color.GRAY));		
//		rects.add(new ColorfulRectangle(261,81, 9, 54, Color.GRAY));		
//		rects.add(new ColorfulRectangle(270,144, 54, 9, Color.GRAY));		
//		rects.add(new ColorfulRectangle(261,144, 9, 90, Color.GRAY));		
//		rects.add(new ColorfulRectangle(324,63, 9, 90, Color.GRAY));
//		rects.add(new ColorfulRectangle(252,234, 18, 9, Color.GRAY));
//		//L
//		rects.add(new ColorfulRectangle(342,63, 9, 171, Color.BLACK));
//		rects.add(new ColorfulRectangle(351,225, 90, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(351,63, 9, 162, Color.GRAY));
//		rects.add(new ColorfulRectangle(342,234, 99, 9, Color.GRAY));		
//		rects.add(new ColorfulRectangle(441,225, 9, 18, Color.GRAY));
//		//O
//		rects.add(new ColorfulRectangle(468,225, 9, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(459,72, 9, 153, Color.BLACK));
//		rects.add(new ColorfulRectangle(468,63, 63, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(531,72, 9, 153, Color.BLACK));
//		rects.add(new ColorfulRectangle(477,225, 54, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(531,63, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(468,72, 63, 9, Color.GRAY));		
//		rects.add(new ColorfulRectangle(468,81, 9, 144, Color.GRAY));
//		rects.add(new ColorfulRectangle(531,225, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(540,72, 9, 153, Color.GRAY));
//		rects.add(new ColorfulRectangle(468,234, 63, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(459,225, 9, 9, Color.GRAY));
//		//R
//		rects.add(new ColorfulRectangle(558,72, 9, 162, Color.BLACK));
//		rects.add(new ColorfulRectangle(558,63, 63, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(621,72, 9, 72, Color.BLACK));
//		rects.add(new ColorfulRectangle(567,135, 54, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(621,63, 9, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(585,153, 9, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(594,162, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(594,171, 9, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(585,144, 9, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(603,180, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(603,189, 9, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(612,198, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(612,207, 9, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(621,216, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(621,225, 9, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(567,144, 9, 90, Color.GRAY));
//		rects.add(new ColorfulRectangle(558,234, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(576,144, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(594,144, 36, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(630,63, 9, 90, Color.GRAY));
//		rects.add(new ColorfulRectangle(567,72, 9, 54, Color.GRAY));
//		rects.add(new ColorfulRectangle(567,81, 9, 54, Color.GRAY));
//		rects.add(new ColorfulRectangle(594,153, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(603,162, 9, 18, Color.GRAY));
//		rects.add(new ColorfulRectangle(612,180, 9, 18, Color.GRAY));
//		rects.add(new ColorfulRectangle(621,198, 9, 18, Color.GRAY));
//		rects.add(new ColorfulRectangle(630,216, 9, 27, Color.GRAY));
//		rects.add(new ColorfulRectangle(621,234, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(567,234, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(585,162, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(594,180, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(603,198, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(612,216, 9, 9, Color.GRAY));
//		//E
//		rects.add(new ColorfulRectangle(648,63, 90, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(648,72, 9, 162, Color.BLACK));
//		rects.add(new ColorfulRectangle(657,225, 81, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(657,144, 36, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(657,72, 81, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(657,81, 9, 63, Color.GRAY));
//		rects.add(new ColorfulRectangle(666,153, 27, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(657,153, 9, 72, Color.GRAY));
//		rects.add(new ColorfulRectangle(648,234, 99, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(738,63, 9, 18, Color.GRAY));
//		rects.add(new ColorfulRectangle(693,144, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(693,153, 9, 9, Color.GRAY));
//		rects.add(new ColorfulRectangle(738,225, 9, 18, Color.GRAY));

//	}
	
	
//	public void pausedBlocks() {
			
//		//OPTIONS BACKGROUND
//		//X 200-600
//		//Y 150-250
//		rects.add(new ColorfulRectangle(200,150, 400, 100, Color.WHITE));
//		//O
//		rects.add(new ColorfulRectangle(216,162, 27, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(207,171, 9, 54, Color.BLACK));
//		rects.add(new ColorfulRectangle(216,225, 27, 9, Color.BLACK));		
//		rects.add(new ColorfulRectangle(243,171, 9, 54, Color.BLACK));
//		//P
//		rects.add(new ColorfulRectangle(270,162, 9, 72, Color.BLACK));
//		rects.add(new ColorfulRectangle(279,162, 36, 9, Color.BLACK));		
//		rects.add(new ColorfulRectangle(306,171, 9, 36, Color.BLACK));		
//		rects.add(new ColorfulRectangle(279,198, 27, 9, Color.BLACK));
//		//T
//		rects.add(new ColorfulRectangle(324,162, 45, 9, Color.BLACK));	
//		rects.add(new ColorfulRectangle(342,171, 9, 63, Color.BLACK));
//		//I
//		rects.add(new ColorfulRectangle(378,162, 45, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(396,171, 9, 54, Color.BLACK));
//		rects.add(new ColorfulRectangle(378,225, 45, 9, Color.BLACK));
//		//O
//		rects.add(new ColorfulRectangle(441,162, 27, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(432,171, 9, 54, Color.BLACK));
//		rects.add(new ColorfulRectangle(441,225, 27, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(468,171, 9, 54, Color.BLACK));
//		//N
//		rects.add(new ColorfulRectangle(495,162, 9, 72, Color.BLACK));
//		
//		rects.add(new ColorfulRectangle(504,171, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(513,189, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(522,207, 9, 18, Color.BLACK));
//		
//		rects.add(new ColorfulRectangle(531,162, 9, 72, Color.BLACK));
//		//S
//		rects.add(new ColorfulRectangle(558,162, 36, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(549,171, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(558,189, 18, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(567,198, 18, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(585,207, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(549,225, 36, 9, Color.BLACK));
//		//RESUME BACKGROUND
//		//X 200-600
//		//Y 350-450
//		rects.add(new ColorfulRectangle(200,350, 400, 100, Color.WHITE));
//		//R
//		rects.add(new ColorfulRectangle(252,360, 9, 36, Color.BLACK));		
//		rects.add(new ColorfulRectangle(216,360, 9, 72, Color.BLACK));
//		rects.add(new ColorfulRectangle(225,360, 27, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(225,387, 27, 9, Color.BLACK));		
//		rects.add(new ColorfulRectangle(243,396, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(252,414, 9, 18, Color.BLACK));
//		//E
//		rects.add(new ColorfulRectangle(279,360, 45, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(279,369, 9, 27, Color.BLACK));
//		rects.add(new ColorfulRectangle(288,387, 36, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(279,396, 9, 36, Color.BLACK));
//		rects.add(new ColorfulRectangle(288,423, 36, 9, Color.BLACK));		
//		//S
//		rects.add(new ColorfulRectangle(351,360, 36, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(342,369, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(351,387, 18, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(360,396, 18, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(378,405, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(342,423, 36, 9, Color.BLACK));
//		//U
//		rects.add(new ColorfulRectangle(414,360, 9, 63, Color.BLACK));
//		rects.add(new ColorfulRectangle(423,423, 27, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(450,360, 9, 63, Color.BLACK));
//		//M
//		rects.add(new ColorfulRectangle(477,369, 9, 63, Color.BLACK));
//		rects.add(new ColorfulRectangle(477,360, 18, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(495,369, 9, 27, Color.BLACK));
//		rects.add(new ColorfulRectangle(504,360, 18, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(513,369, 9, 63, Color.BLACK));
//		//E
//		rects.add(new ColorfulRectangle(540,360, 45, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(540,369, 9, 36, Color.BLACK));
//		rects.add(new ColorfulRectangle(549,387, 28, 9, Color.BLACK));
//		rects.add(new ColorfulRectangle(540,405, 9, 18, Color.BLACK));
//		rects.add(new ColorfulRectangle(540,423, 45, 9, Color.BLACK));
//	}

	
}
