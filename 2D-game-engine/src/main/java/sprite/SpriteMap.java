package main.java.sprite;

import java.awt.image.BufferedImage;

public class SpriteMap {

	BufferedImage img;
	int width,height;
	
	public SpriteMap(BufferedImage img, int width, int height) {
		this.img = img;
		this.width = width;
		this.height = height;
	}
	
	/** Retruns the sprite at a specific position of the spritemap. */
	public Sprite getSprite(int x, int y) {
		int sx = x*width;
		int sy = y*width;
		
		return new Sprite(img.getSubimage(sx, sy, img.getWidth()/width, img.getHeight()/height));
	}
	
}
