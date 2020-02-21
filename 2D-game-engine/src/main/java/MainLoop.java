package main.java;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import main.java.render.Screen;

public class MainLoop {
	public static JFrame frame = new JFrame();
	
	public File file = new File(MainLoop.class.getClassLoader().getResource("main/res/images/GameIcon.png").getFile());
	public static int i = 0;
	
	public static void main(String[] args) {
		try {
			MainLoop mainloop = new MainLoop();
			Screen screen = new Screen(frame, new Dimension(400, 400), ImageIO.read(mainloop.file));
			screen.enableFrame(frame);
			screen.addImage(ImageIO.read(mainloop.file), 0, 0, screen.getWidth(), screen.getHeight());
			screen.addImage(ImageIO.read(mainloop.file), 200, 200, 50, 25);
			while (true) {
				screen.changeItem(1, i, screen.height);
				screen.render();
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}