package main.java;

import main.java.render.Screen;
import main.java.sprite.Animation;
import main.java.sprite.Sprite;
import main.java.sprite.SpriteMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends MainLoop {
	
	public static final File file = new File(Objects.requireNonNull(Main.class.getClassLoader().getResource("main/res/images/GameIcon.png")).getFile());
	public static final File file2 = new File(Objects.requireNonNull(Main.class.getClassLoader().getResource("main/res/images/GameIconFlipped.png")).getFile());
	
	public static void main(String[] args) throws HeadlessException, IOException {
		fps = 60;
		debugMode = true;
		
		screen = new Screen(new JFrame(), new Dimension(400, 400));
		
		//Rectangle tests
		screen.Rect(0, 0, new Sprite(ImageIO.read(file)));
		screen.Rect(150, 150, 100, 100, Color.RED);
		
		//Spritemap test
		SpriteMap sm = new SpriteMap(ImageIO.read(file), 2, 2);
		screen.Rect(175, 175, sm.getSprite(0, 0));
		screen.Rect(175, 239, sm.getSprite(0, 1));
		screen.Rect(239, 175, sm.getSprite(1, 0));
		screen.Rect(239, 239, sm.getSprite(1, 1));
		
		//Animation test
		Animation anim = new Animation(new ArrayList<>());
		anim.getSprites().add(new Sprite(ImageIO.read(file)));
		anim.getSprites().add(new Sprite(ImageIO.read(file2)));
				
		screen.Rect(0, 200, anim);
		main();
	}
	
}
