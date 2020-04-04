package main.java.shape;

import java.awt.image.BufferedImage;

public class Rectangle extends Shape {

	public Rectangle(int x, int y, int width, int height, BufferedImage texture) {
		super(x, y, width, height, texture);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
	}
	
	
	
}
