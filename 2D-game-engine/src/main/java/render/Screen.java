package main.java.render;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Screen extends Canvas {

	private static final long serialVersionUID = -7004570169397651722L;

	public JFrame frame;
	public int[] pixels;
	
	public BufferedImage inBetween;
	
	public List<BufferedImage> images = new ArrayList<BufferedImage>();
	
	public List<Integer> x = new ArrayList<Integer>();
	public List<Integer> y = new ArrayList<Integer>();
	
	public Screen(JFrame frame, Dimension dimension) throws IOException {
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
		
		pixels = new int[getWidth()*getHeight()];
		inBetween = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
	}
	
	
	
	public void setSize(Dimension dimension) {
		frame.setPreferredSize(dimension);
	}
	
	public void setIcon(Image icon) {
		frame.setIconImage(icon);
	}
	
	public void setTitle(String title) {
		frame.setTitle(title);
	}
	
	public void enableFrame() {
		frame.setVisible(true);
	}
	
	public void setPixels() {
		for (int i = 0; i < images.size(); i++) {
			for (int j = 0; j < images.get(i).getHeight(); j++) {
				for (int l = 0; l < images.get(i).getWidth(); l++) {
					if (images.get(i).getRGB(l, j) != 0xFF00FF && j*getWidth() + l <= pixels.length) pixels[j*getWidth() + l] = images.get(i).getRGB(l, j);
				}
			}
			images.set(i, resize(images.get(i), images.get(i).getWidth(), images.get(i).getHeight()));
		}
		for (int i = 0; i < pixels.length; i++) {
			inBetween.setRGB(i % getWidth(), i / getWidth(), pixels[i]);
		}
	}
	
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
	
	public BufferedImage resize(BufferedImage img, int width, int height) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}
	
	public void addImage(BufferedImage image, int x, int y, int width, int height) {
		this.images.add(image);
		this.x.add(x);
		this.y.add(y);
	}
	
	public void removeImage(int index) {
		this.images.remove(index);
		this.x.remove(index);
		this.y.remove(index);
	}
	
	public void changeItem(int index, int newValue, List<Integer> list) {
		list.set(index, newValue);
	}
	
	public void changeItem(int index, Image newValue, List<Image> list) {
		list.set(index, newValue);
	}
	
}
