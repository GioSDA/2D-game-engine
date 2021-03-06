package main.java;

import main.java.render.Screen;
import main.java.sprite.Animation;
import main.java.sprite.Sprite;
import main.java.sprite.SpriteMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Game {
	
	public final File file = new File(Objects.requireNonNull(Main.class.getClassLoader().getResource("main/res/images/GameIcon.png")).getFile());
	public final File file2 = new File(Objects.requireNonNull(Main.class.getClassLoader().getResource("main/res/images/GameIconFlipped.png")).getFile());

	public Main() throws IOException {
		fps = 60;
		debugMode = true;
		
		screen = new Screen(new Dimension(800, 800), this);

		//Rectangle tests
		Rect(0, 0, new Sprite(ImageIO.read(file)));
		Rect(150, 150, 100, 100, Color.RED);
		
		//Spritemap test
		SpriteMap sm = new SpriteMap(ImageIO.read(file), 2, 2);
		Rect(175, 175, sm.getSprite(0, 0));
		Rect(175, 239, sm.getSprite(0, 1));
		Rect(239, 175, sm.getSprite(1, 0));
		Rect(239, 239, sm.getSprite(1, 1));
		
		//Animation test
		Animation anim = new Animation(new ArrayList<>());
		anim.getSprites().add(new Sprite(ImageIO.read(file)));
		anim.getSprites().add(new Sprite(ImageIO.read(file2)));

		Rect(0, 200, anim);
	}

	@Override
	public void tick() {
		if (screen.getMousePosition() != null) {
			Rect((int) mouseMotion.x, (int) mouseMotion.y, 10, 10, Color.GREEN);
			System.out.println(mouseMotion.x + " " + mouseMotion.y);
		}
	}

	@Override
	public void onStart() {

	}

	@Override
	public void onStop() {

	}
}
