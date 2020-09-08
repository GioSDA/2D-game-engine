package main.java.shape;

/** The way that shapes are drawn to the screen. */
public enum RenderMode {
	/** Shapes are drawn with the leftmost up corner describing the X and Y position. */
	LU_CORNER,
	/** Shapes are drawn with the leftmost down corner describing the X and Y position. */
	LD_CORNER,
	/** Shapes are drawn with the rightmost up corner describing the X and Y position. */
	RU_CORNER,
	/** Shapes are drawn with the rightmost down corner describing the X and Y position. */
	RD_CORNER,
	/** Shapes are drawn with the center describing the X and Y position. */
	CENTER
}
