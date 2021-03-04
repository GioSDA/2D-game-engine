package main.java;

import main.java.input.KeyboardInput;
import main.java.input.MouseInput;
import main.java.render.Screen;
import main.java.shape.RenderMode;
import main.java.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    /** Ticks per second. */
    public int tps = 60;
    /** Frames per second. */
    public int fps = 60;

    /** The way shapes are drawn to the screen. */
    public RenderMode renderMode = RenderMode.LU_CORNER;

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
}
