package main.java.shape;

import main.java.Main;
import main.java.sprite.Animation;
import main.java.sprite.Sprite;

public class Rectangle extends Shape {
	
	public Rectangle(int x, int y, int width, int height, double rotation, Sprite sprite, RenderMode rm) {
		super(x, y, width, height, rotation, sprite);
		this.animated = false;
		switch (rm) {
		case RU_CORNER:
			this.x = x-width;
			this.y = y;
			break;
		case LD_CORNER:
			this.x = x;
			this.y = y-height;
			break;
		case RD_CORNER:
			this.x = x-width;
			this.y = y-height;
			break;
		case CENTER:
			this.x = x-(width/2);
			this.y = y-(height/2);
			break;
		default:
			this.x = x;
			this.y = y;
			break;
		}
		this.sprite = sprite;
	}
	
	public Rectangle(int x, int y, int width, int height, double rotation, Animation animation, RenderMode rm) {
		super(x, y, width, height, rotation, animation);
		this.animated = true;
		switch (rm) {
		case RU_CORNER:
			this.x = x-width;
			this.y = y;
			break;
		case LD_CORNER:
			this.x = x;
			this.y = y-height;
			break;
		case RD_CORNER:
			this.x = x-width;
			this.y = y-height;
			break;
		case CENTER:
			this.x = x-(width/2);
			this.y = y-(height/2);
			break;
		default:
			this.x = x;
			this.y = y;
			break;
		}
		
		this.animation = animation;
	}
	
}
