package main.java;

import java.io.IOException;

public class MainLoop {

	public static Main main = null;

	static {
		try {
			main = new Main();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();

		setUpScreen();
		main.onStart();

		long timer = System.currentTimeMillis();
		int frames = 0;
		int ticks = 0;
		
		long last = System.nanoTime();
		double e = 0;
		double f = 0;
		
		main.screen.render();
		
		while (true) {
			long now = System.nanoTime();
			e += (now - last) / (1000000000.0 / main.tps);
			f += (now - last) / (1000000000.0 / main.fps);
			last = now;
			
			while (f >= 1) { 
				main.screen.render();
				f--; 
				frames++;
			}

			while (e >= 1) {
				main.tick();
				e--;
				ticks++;
			}

			if (System.currentTimeMillis() - timer >= 1000) { 
				if (main.debugMode) System.out.println("fps: " + frames + ", tps: " + ticks);
				timer += 1000;
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	public static void setUpScreen() {
		main.screen.addKeyListener(main.key);
		main.screen.addMouseListener(main.mouse);
		main.screen.setFocusable(true);
		main.screen.requestFocus();
		main.screen.enableFrame();
	}

}