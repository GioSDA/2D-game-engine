package main.java;

import main.java.input.KeyboardInput;
import main.java.input.MouseInput;
import main.java.render.Screen;
import main.java.shape.Rectangle;
import main.java.shape.RenderMode;
import main.java.shape.Shape;
import main.java.sprite.Animation;
import main.java.sprite.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    /** Ticks per second. */
    public int tps = 60;
    /** Frames per second. */
    public int fps = 60;

    /** The way shapes are drawn to the screen. */
    public RenderMode renderMode = RenderMode.LU_CORNER;

    /** List of shapes. */
    public static List<Shape> shapes = new ArrayList<>();

    /** Screen. */
    public Screen screen;

    /** Keyboard Input. */
    public final KeyboardInput key = new KeyboardInput();
    /** Mouse Input. */
    public final MouseInput mouse = new MouseInput();

    /** Toggles debug mode. */
    public boolean debugMode = false;

    /** The onStart method. Gets called when the player starts the game*/
    public abstract void onStart();

    /** The onStop method. Gets called when the player exits the game*/
    public abstract void onStop();

    /** The run method. Gets called every tick*/
    public abstract void tick();

    /**
     * Draws a rectangle to the screen with a sprite.
     * @param x the x position of the rect.
     * @param y the y position of the rect.
     * @param sprite The sprite that will be rendered.
     */
    public void Rect(int x, int y, Sprite sprite) {
        shapes.add(new Rectangle(x, y, sprite.getTexture().getWidth(), sprite.getTexture().getHeight(), 0, sprite, renderMode));
    }

    /**
     * Draws a rectangle to the screen with an animation.
     * @param x the x position of the rect.
     * @param y the y position of the rect.
     */
    public void Rect(int x, int y, Animation animation) {
        shapes.add(new Rectangle(x, y, animation.getSprite(0).getTexture().getWidth(), animation.getSprite(0).getTexture().getHeight(), 0, animation, renderMode));
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

        shapes.add(new Rectangle(x, y, width, height, 0, new Sprite(b), renderMode));
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

        shapes.add(new Rectangle(x, y, width, height, rotation, new Sprite(b), renderMode));
    }

    /**
     * Removes a shape with the current index.
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
