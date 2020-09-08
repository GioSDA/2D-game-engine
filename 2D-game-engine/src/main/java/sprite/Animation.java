package main.java.sprite;

import java.util.List;

public class Animation {

	List<Sprite> sprites;
	
	public Animation(List<Sprite> sprites) {
		this.sprites = sprites;
	}
	
	/** Returns the sprite at a specific position of the animation. */
	public Sprite getSprite(int i) {
		return (sprites.get(i));
	}
	
	/** Returns a list of sprites that the animation is made up of. */
	public List<Sprite> getSprites() {
		return sprites;
	}
	
}
