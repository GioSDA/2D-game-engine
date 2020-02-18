package main;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import render.Screen;

public class MainLoop{
	public static JFrame frame = new JFrame();
	public static void main(String[] args) {
		try {
			Screen screen = new Screen(frame, new Dimension(400, 400));
			screen.enableFrame(frame);
			while (true) {
				screen.render(ImageIO.read(new File("GameIcon.png")));
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
