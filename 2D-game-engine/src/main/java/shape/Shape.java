package main.java.shape;

import main.java.sprite.Animation;
import main.java.sprite.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Shape {

	public int x, y;
	public Sprite sprite;
	public Animation animation;
	
	public boolean animated;
	public int animIndex = 0;
	
	public Shape(int x, int y, int width, int height, double rotation, Sprite sprite) {
		
	}
	
	public Shape(int x, int y, int width, int height, double rotation, Animation animation) {
		
	}

	/** Gets x position of a shape. */
	public int getX() {
		return x;
	}

	/** Sets x position of a shape. */
	public void setX(int x) {
		this.x = x;
	}

	/** Gets y position of a shape. */
	public int getY() {
		return y;
	}

	/** Sets y position of a shape. */
	public void setY(int y) {
		this.y = y;
	}

	/** Gets width of a shape. */
	public int getWidth() {
		return this.sprite.getTexture().getWidth();
	}

	/** Sets width of a shape. */
	public void setWidth(int width) {
		setSprite(new Sprite(resize(getSprite().getTexture(), width, getHeight())));
	}

	/** Gets height of a shape. */
	public int getHeight() {
		return this.sprite.getTexture().getWidth();
	}

	/** Sets height of a shape. */
	public void setHeight(int height) {
		setSprite(new Sprite(resize(getSprite().getTexture(), getWidth(), height)));
	}

	/** Gets sprite of a shape if present. */
	public Sprite getSprite() {
		if (animated) return null;
		return sprite;
	}

	/** Sets sprite of a shape if not animated. */
	public void setSprite(Sprite sprite) {
		if (animated) return;
		this.sprite = sprite;
	}
	
	/** Gets animation of a shape if present. */
	public Animation getAnimation() {
		if (!animated) return null;
		return animation;
	}
	
	/** Sets sprite of a shape if animated. */
	public void setAnimation(Animation animation) {
		if (!animated) return;
		this.animation = animation;
	}

	public static BufferedImage resize(BufferedImage img, int width, int height) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	
	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();
	
	    return dimg;
	}
	
	/** Returns whether the shape is animated or not. */
	public boolean isAnimated() {
		return animated;
	}
}
