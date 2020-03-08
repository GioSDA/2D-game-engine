package main.java;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import main.java.render.Screen;

public class MainLoop {
	public static int tps = 60;
	public static int fps = 60;
	
	public File file = new File(MainLoop.class.getClassLoader().getResource("main/res/images/GameIcon.png").getFile());
	public static int i = 0;
	
	public static Screen screen;
	
	public static void main(String[] args) {
		try {
			MainLoop mainloop = new MainLoop();
			screen = new Screen(new JFrame(), new Dimension(400, 400));
			screen.enableFrame();
			screen.addImage(ImageIO.read(mainloop.file), 0, 0, screen.getWidth(), screen.getHeight());
			screen.addImage(ImageIO.read(mainloop.file), 200, 200, 50, 25);
			
			long timer = System.currentTimeMillis();
			long frames = 0;
			long ticks = 0;
			
			long last = System.currentTimeMillis();
			long e = 0;
			long f = 0;
			
			while (true) {
				long now = System.nanoTime();
				e += (now - last) / fps * 0.000000001;
				f += (now - last) / tps * 0.000000001;
				
				if (e >= 1) { 
					tick();
					e--; 
					ticks++;
				}
				
				if (f >= 1) { 
					screen.render();
					f--; 
					frames++;
				}

				if (System.currentTimeMillis() - timer >= 1000) { 
					System.out.println(tps + ", " + fps);
					timer += 1000;
					frames = 0;
					ticks = 0;
				}
				
				screen.render();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void tick() {
		i++;
		screen.changeItem(1, i, screen.height);
	}
	
}