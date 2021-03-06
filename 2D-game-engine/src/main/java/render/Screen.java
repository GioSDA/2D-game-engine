package main.java.render;

import main.java.Game;
import main.java.shape.RenderMode;
import main.java.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/** Screen to render shapes to. */
public class Screen extends Canvas {

	private static final long serialVersionUID = -7004570169397651722L;

	/** the JFrame. */
	public JFrame frame = new JFrame();
	
	/** List of pixels that will be drawn to screen. */
	public int[] pixels;

	public Game game;

	public BufferedImage inBetween;
	
	public Screen(Dimension dimension, Game game) {
		frame.setPreferredSize(dimension);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setTitle("Game");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.requestFocus();


		this.game = game;

		pixels = new int[(int)dimension.getWidth()*(int)dimension.getHeight()];
		inBetween = new BufferedImage((int)dimension.getWidth(), (int)dimension.getHeight(), BufferedImage.TYPE_INT_RGB);
	}

	/** Sets size of Frame. */
	public void setSize(Dimension dimension) {
		frame.setPreferredSize(dimension);
	}
	
	/**  Sets the icon image of the frame.  */
	public void setIcon(Image icon) {
		frame.setIconImage(icon);
	}
	
	/** Sets the title of the frame. **/
	public void setTitle(String title) {
		frame.setTitle(title);
	}
	
	/** Enables the frame. **/
	public void enableFrame() {
		frame.setVisible(true);
	}
	
	/** Sets the pixels on the frame to specified values. */
	public void setPixels() {
		for (Shape shape : game.shapes) {
			if (!shape.isAnimated()) {
				
				for (int j = 0; j < shape.getSprite().getTexture().getHeight(); j++) {
					for (int l = 0; l < shape.getSprite().getTexture().getWidth(); l++) {
						if (l + shape.getX() < inBetween.getWidth() && j + shape.getY() < inBetween.getHeight() && j*getWidth() + l < pixels.length)
							if (shape.getSprite().getTexture().getRGB(l, j) != -65281) pixels[(j + shape.getY()) * inBetween.getWidth() + l + shape.getX()] = shape.getSprite().getTexture().getRGB(l, j);
							else pixels[(j + shape.getY()) * inBetween.getWidth() + l + shape.getX()] = 0;
					}
				}
				
			} else {
				
				for (int j = 0; j < shape.getAnimation().getSprite(shape.animIndex).getTexture().getHeight(); j++) {
					for (int l = 0; l < shape.getAnimation().getSprite(shape.animIndex).getTexture().getWidth(); l++) {
						if (l + shape.getX() < inBetween.getWidth() && j + shape.getY() < inBetween.getHeight() && j*getWidth() + l < pixels.length)
							if (shape.getAnimation().getSprite(shape.animIndex).getTexture().getRGB(l, j) != -65281) pixels[(j + shape.getY()) * inBetween.getWidth() + l + shape.getX()] = shape.getAnimation().getSprite(shape.animIndex).getTexture().getRGB(l, j);
							else pixels[(j + shape.getY()) * inBetween.getWidth() + l + shape.getX()] = 0;
					}
				}
				
				shape.animIndex = ((shape.animIndex + 1) % shape.getAnimation().getSprites().size());
			}
		}

		for (int i = 0; i < pixels.length; i++) {
			inBetween.setRGB(i % inBetween.getHeight(), i / inBetween.getWidth(), pixels[i]);
		}
	}

	/** Renders the shapes to the frame. */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		setPixels();

		Graphics g = bs.getDrawGraphics();
		g.drawImage(inBetween, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
}
