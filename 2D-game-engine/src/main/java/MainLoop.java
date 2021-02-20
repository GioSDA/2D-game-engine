package main.java;

import java.io.File;

import main.java.input.KeyboardInput;
import main.java.input.MouseInput;
import main.java.render.Screen;
import main.java.shape.RenderMode;

public class MainLoop {
	/** Ticks per second. */
	public static int tps;
	/** Frames per second. */
	public static int fps;
	
//	public static double i = 0;
	
	/** The way shapes are drawn to the screen. */
	public static RenderMode renderMode;
	
	public static File file = new File(MainLoop.class.getClassLoader().getResource("main/res/images/GameIcon.png").getFile());
	
	/** Keyboard Input. */
	public static KeyboardInput key;
	/** Mouse Input. */
	public static MouseInput mouse;
	
	/** Screen. */
	public static Screen screen;
	
	/** Main Method */
	public static void main() {
		setUpScreen();
		
		long timer = System.currentTimeMillis();
		int frames = 0;
		int ticks = 0;
		
		long last = System.nanoTime();
		double e = 0;
		double f = 0;
		
		while (true) {
			long now = System.nanoTime();
			e += (now - last) / (1000000000.0 / tps);
			f += (now - last) / (1000000000.0 / fps);
			last = now;
			
			while (e >= 1) {
				tick();
				e--; 
				ticks++;
			}
			
			while (f >= 1) { 
				screen.render();
				f--; 
				frames++;
			}
			
			if (System.currentTimeMillis() - timer >= 1000) { 
				System.out.println(ticks + ", " + frames);
				timer += 1000;
				frames = 0;
				ticks = 0;
			}
			
			screen.render();
		}
	}
	
	/** Called every tick. */
	public static void tick() {
		
	}
	
	public static void setUpScreen() {
		screen.addKeyListener(key);
		screen.addMouseListener(mouse);
		screen.setFocusable(true);
		screen.requestFocus();
		screen.enableFrame();
	}
	
}