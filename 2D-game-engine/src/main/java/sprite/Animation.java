package main.java.sprite;

import java.util.List;

public class Animation {

	List<Sprite> sprites;
	
	public Animation(List<Sprite> sprites) {
		this.sprites = sprites;
	}
	
	public Sprite getSprite(int i) {
		return (sprites.get(i));
	}
	
	public List<Sprite> getSprites() {
		return sprites;
	}
	
}
