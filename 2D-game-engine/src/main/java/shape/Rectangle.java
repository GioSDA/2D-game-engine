package main.java.shape;

import java.awt.image.BufferedImage;

import main.java.MainLoop;

public class Rectangle extends Shape {
	
	public Rectangle(int x, int y, int width, int height, double rotation, BufferedImage texture) {
		super(x, y, width, height, rotation, texture);
		switch (MainLoop.renderMode) {
		case LU_CORNER:
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.rotation = rotation;
			this.texture = texture;
			break;
		case RU_CORNER:
			this.x = x-width;
			this.y = y;
			this.width = width;
			this.height = height;
			this.rotation = rotation;
			this.texture = texture;
			break;
		case LD_CORNER:
			this.x = x;
			this.y = y-height;
			this.width = width;
			this.height = height;
			this.rotation = rotation;
			this.texture = texture;
			break;
		case RD_CORNER:
			this.x = x-width;
			this.y = y-height;
			this.width = width;
			this.height = height;
			this.rotation = rotation;
			this.texture = texture;
			break;
		case CENTER:
			this.x = x-(width/2);
			this.y = y-(height/2);
			this.width = width;
			this.height = height;
			this.rotation = rotation;
			this.texture = texture;
			break;
		default:
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.rotation = rotation;
			this.texture = texture;
			break;
		}
	}
	
}
