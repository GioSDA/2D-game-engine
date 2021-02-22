package main.java;

import main.java.input.KeyboardInput;
import main.java.input.MouseInput;
import main.java.render.Screen;
import main.java.shape.RenderMode;

public class MainLoop {
	/** Ticks per second. */
	public static int tps = 60;
	/** Frames per second. */
	public static int fps = 60;
		
	/** The way shapes are drawn to the screen. */
	public static RenderMode renderMode = RenderMode.LU_CORNER;
		
	/** Keyboard Input. */
	public static KeyboardInput key = new KeyboardInput();
	/** Mouse Input. */
	public static MouseInput mouse = new MouseInput();
	
	/** Screen. */
	public static Screen screen;
	
	/** Toggles debug mode. */
	public static boolean debugMode = false;
	
	/** Main Method */
	public static void main() {
		setUpScreen();
		
		long timer = System.currentTimeMillis();
		int frames = 0;
		int ticks = 0;
		
		long last = System.nanoTime();
		double e = 0;
		double f = 0;
		
		screen.render();
		
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
				if (debugMode) System.out.println("fps: " + frames + ", tps: " + ticks);
				timer += 1000;
				frames = 0;
				ticks = 0;
			}
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