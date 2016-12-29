package com.galvanize.ocp.shapes;

import static java.lang.Math.round;

class Printer {

	private static final int INK_PER_SQUARE_INCH = 5;

	private int calculateInkForCircle(final int radius) {
		return INK_PER_SQUARE_INCH * (int) round(Math.PI * radius * radius);
	}

	private int calculateInkForRectangle(final int height, final int width) {
		return INK_PER_SQUARE_INCH * round(height * width);
	}

	String draw(final Shape shape) {

		if (shape.getType() == ShapeType.CIRCLE) {
			int ink = calculateInkForCircle(shape.getA());
			return drawCircle(shape.getA(), shape.getColor(), ink);
		} else if (shape.getType() == ShapeType.RECTANGLE) {
			int ink = calculateInkForRectangle(shape.getA(), shape.getB());
			return drawRectangle(shape.getA(), shape.getB(), shape.getColor(), ink);
		} else {
			throw new RuntimeException("Unsupported Shape: " + shape);
		}
	}

	private String drawCircle(final int radius, final String color, final int ink) {
		return "Circle, radius: " + radius + ", color: " + color +
				", ink: " + ink + " ml";
	}

	private String drawRectangle(final int height, final int width, final String color, final int ink) {
		return "Rectangle, height: " + height + ", width: " + width + ", color: " + color +
				", ink: " + ink + " ml";
	}
}