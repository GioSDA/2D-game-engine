package main.java.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionInput implements MouseMotionListener {

    public double x,y;

    @Override
    public void mouseDragged(MouseEvent e) {
        try {
            x = e.getX() + (17 / ((double) e.getComponent().getWidth() / e.getX()));
        } catch (ArithmeticException arithmeticException) {
            x = 0;
        }

        try {
            y = e.getY() + (40 / ((double) e.getComponent().getHeight() / e.getY()));
        } catch (ArithmeticException arithmeticException) {
            y = 0;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        try {
            x = e.getX() + (17 / ((double) e.getComponent().getWidth() / e.getX()));
        } catch (ArithmeticException arithmeticException) {
            x = 0;
        }

        try {
            y = e.getY() + (40 / ((double) e.getComponent().getHeight() / e.getY()));
        } catch (ArithmeticException arithmeticException) {
            y = 0;
        }
    }
}
