package main.java.shape;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import main.java.sprite.Animation;
import main.java.sprite.Sprite;

public abstract class Shape {

	public int x, y;
	public int width, height;
	public double rotation;
	public Sprite sprite;
	public Animation animation;
	
	public boolean animated;
	public int animIndex = 0;
	
	public Shape(int x, int y, int width, int height, double rotation, Sprite sprite) {
		
	}
	
	public Shape(int x, int y, int width, int height, double rotation, Animation animation) {
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		setSprite(new Sprite(resize(getSprite().getTexture(), width, getHeight())));
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		setSprite(new Sprite(resize(getSprite().getTexture(), getWidth(), height)));
	}
	
	public double getRot() {
		return rotation;
	}

	public void setRot(double rotation) {
		this.rotation = rotation;
		setSprite(new Sprite(rotate(getSprite().getTexture(), rotation)));
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	
	public static BufferedImage rotate(BufferedImage image, double angle) {
	    AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
	    at.rotate(Math.toRadians(angle));
	    BufferedImage dimg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
	    
	    Graphics2D g2d = dimg.createGraphics();
	    
	    g2d.drawImage(image, at, null);
	    g2d.dispose();
	    
	    return dimg;
	  }

	public static BufferedImage resize(BufferedImage img, int width, int height) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	
	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();
	
	    return dimg;
	}
	
	public boolean isAnimated() {
		return animated;
	}
	
}
