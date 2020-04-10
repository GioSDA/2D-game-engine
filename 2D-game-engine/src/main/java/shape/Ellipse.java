package main.java.shape;

import java.awt.image.BufferedImage;

public class Ellipse extends Shape {

	public Ellipse(int x, int y, int width, int height, BufferedImage texture) {
		super(x, y, width, height, texture);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
	}
	
}
