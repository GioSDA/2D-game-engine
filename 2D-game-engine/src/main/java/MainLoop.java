package main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import main.java.input.KeyboardInput;
import main.java.input.MouseInput;
import main.java.render.Screen;
import main.java.shape.RenderMode;

public class MainLoop {
	public static int tps = 60;
	public static int fps = 60;
	
//	public static double i = 0;
	
	public static RenderMode renderMode;
	
	public File file = new File(MainLoop.class.getClassLoader().getResource("main/res/images/GameIcon.png").getFile());
	
	public static KeyboardInput key = new KeyboardInput();
	public static MouseInput mouse = new MouseInput();
	
	public static Screen screen;
	
	public static void main(String[] args) {
		try {
			MainLoop mainloop = new MainLoop();
			screen = new Screen(new JFrame(), new Dimension(400, 400));
			screen.addKeyListener(key);
			screen.addMouseListener(mouse);
			screen.setFocusable(true);
			screen.requestFocus();
			screen.enableFrame();
			screen.addRect(0, 0, 400, 400, 0, ImageIO.read(mainloop.file));
			screen.addRect(150, 150, 100, 100, 0, Color.RED);
			
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
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Image file could not be read.");
			System.exit(0);
		}
	}
	
	public static void tick() {
//		i += 0.05;
//		Screen.shapes.get(0).setRot(i);
	}
	
}