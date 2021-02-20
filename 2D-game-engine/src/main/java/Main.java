package main.java;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import main.java.input.KeyboardInput;
import main.java.input.MouseInput;
import main.java.render.Screen;
import main.java.shape.RenderMode;
import main.java.sprite.Sprite;

public class Main extends MainLoop {

	public static int tps = 60;
	
	public static int fps = 60;
		
	public static RenderMode renderMode = RenderMode.LU_CORNER;
	
	public static File file = new File(MainLoop.class.getClassLoader().getResource("main/res/images/GameIcon.png").getFile());
	
	public static KeyboardInput key = new KeyboardInput();
	
	public static MouseInput mouse = new MouseInput();
	
	public static void main(String[] args) throws HeadlessException, IOException {
		screen = new Screen(new JFrame(), new Dimension(400, 400));
		
		screen.Rect(0, 0, 400, 400, 0, new Sprite(ImageIO.read(file)));
		screen.Rect(150, 150, 100, 100, 0, Color.RED);
		
		main();
	}

	public static void tick() {
		
	}
	
}
