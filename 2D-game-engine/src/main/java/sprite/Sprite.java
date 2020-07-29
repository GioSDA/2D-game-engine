package main.java.sprite;

import java.awt.image.BufferedImage;

public class Sprite {

	BufferedImage img;
	
	public Sprite(BufferedImage img) {
		this.img = img;
	}
	
	public BufferedImage getTexture() {
		return img;
	}
	
}
