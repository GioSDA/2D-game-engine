package main.java.render;

import main.java.shape.Rectangle;
import main.java.shape.Shape;
import main.java.sprite.Animation;
import main.java.sprite.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Screen to render shapes to. */
public class Screen extends Canvas {

	private static final long serialVersionUID = -7004570169397651722L;

	/** the JFrame. */
	public JFrame frame;
	
	/** List of pixels that will be drawn to screen. */
	public int[] pixels;
	
	public BufferedImage inBetween;
	
	/** List of shapes. */
	public static List<Shape> shapes = new ArrayList<>();
	
	public Screen(JFrame frame, Dimension dimension) {
		this.frame = frame;
		frame.setPreferredSize(dimension);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setTitle("Game");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.requestFocus();
		
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
		for (Shape shape : shapes) {
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
	
	/**
	 * Draws a rectangle to the screen with a sprite.
	 * @param x the x position of the rect.
	 * @param y the y position of the rect.
	 * @param sprite The sprite that will be rendered.
	 */
	public void Rect(int x, int y, Sprite sprite) {
		shapes.add(new Rectangle(x, y, sprite.getTexture().getWidth(), sprite.getTexture().getHeight(), 0, sprite));
	}
	
	/**
	 * Draws a rectangle to the screen with an animation.
	 * @param x the x position of the rect.
	 * @param y the y position of the rect.
	 */
	public void Rect(int x, int y, Animation animation) {
		shapes.add(new Rectangle(x, y, animation.getSprite(0).getTexture().getWidth(), animation.getSprite(0).getTexture().getHeight(), 0, animation));
	}
	
	/**
	 * Draws a Rectangle to the screen with a specified colour.
	 * @param x the x position of the rect.
	 * @param y the y position of the rect.
	 * @param width the width of the rect.
	 * @param height the height of the rect.
	 * @param colour The color of the rect.
	 */
	public void Rect(int x, int y, int width, int height, Color colour) {
		BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = b.createGraphics();
		g2d.setColor(colour);
		g2d.fillRect(0, 0, b.getWidth(), b.getHeight());
		g2d.dispose();
		
		shapes.add(new Rectangle(x, y, width, height, 0, new Sprite(b)));
	}
	
	/**
	 * Draws a Rectangle to the screen with a specified colour.
	 * @param x the x position of the rect.
	 * @param y the y position of the rect.
	 * @param width the width of the rect.
	 * @param height the height of the rect.
	 * @param rotation The rotation of the rect.
	 * @param colour The color of the rect.
	 */
	public void Rect(int x, int y, int width, int height, double rotation, Color colour) {
		BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = b.createGraphics();
		g2d.setColor(colour);
		g2d.fillRect(0, 0, b.getWidth(), b.getHeight());
		g2d.dispose();
		
		shapes.add(new Rectangle(x, y, width, height, rotation, new Sprite(b)));
	}
	
	/**
	 * Removes a shape with the curent index.
	 * @param index The index of the shape to be removed.
	 */
	public void removeShape(int index) {
		shapes.remove(index);
	}
	
	/**
	 * 
	 * @param index The index to be changed.
	 * @param newValue The value to change the new index to.
	 * @param list to do the changing in.
	 */
	public void changeItem(int index, int newValue, List<Integer> list) {
		list.set(index, newValue);
	}
	
	/**
	 * 
	 * @param index The index to be changed.
	 * @param newValue The value to change the new index to.
	 * @param list to do the changing in.
	 */
	public void changeItem(int index, Image newValue, List<Image> list) {
		list.set(index, newValue);
	}
	
}
