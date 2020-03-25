package main.java.render;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Screen extends Canvas {

	private static final long serialVersionUID = -7004570169397651722L;

	public JFrame frame;
	
	public List<Image> images = new ArrayList<Image>();
	
	public List<Integer> x = new ArrayList<Integer>();
	public List<Integer> y = new ArrayList<Integer>();
	public List<Integer> width = new ArrayList<Integer>();
	public List<Integer> height = new ArrayList<Integer>();
	
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
	}
	
	public void setIcon(Image icon) {
		frame.setIconImage(icon);
	}
	
	public void enableFrame() {
		frame.setVisible(true);
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, getWidth(), getHeight());
		for (int i = 0; i < images.size(); i++) {
			g.drawImage(this.images.get(i), (int)this.x.get(i), (int)this.y.get(i), (int)this.width.get(i), (int)this.height.get(i), null);
		}
		g.dispose();
		bs.show();
	}
	
	public void addImage(Image image, int x, int y, int width, int height) {
		this.images.add(image);
		this.x.add(x);
		this.y.add(y);
		this.width.add(width);
		this.height.add(height);
	}
	
	public void removeImage(int index) {
		this.images.remove(index);
		this.x.remove(index);
		this.y.remove(index);
		this.width.remove(index);
		this.height.remove(index);
	}
	
	public void changeItem(int index, int newValue, List<Integer> list) {
		list.set(index, newValue);
	}
	
}
