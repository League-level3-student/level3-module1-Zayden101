import javax.swing.JOptionPane;

import processing.core.PApplet;

public class test extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;


	public static void main(String[] args) {
		
		for (int i = 0; i < 1; i++) {
			
		System.out.println("\t /t Hello");
		System.out.println("\n /n Hello");
		System.out.println("\r /r Hello");
		System.out.println("\f /f Hello");
		System.out.println("\b /b Hello");

//		JOptionPane.showMessageDialog(null, "hi" + "\nhello");
		
		}
	}
		
		@Override
		public void setup() {

		}

		@Override
		public void draw() {

		}
	
	
	
			public void mousePressed() {
			System.out.println("clicked");

		}
			
}
