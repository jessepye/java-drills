package com.galvanize.ocp.shapes;

import static com.galvanize.ocp.shapes.ShapeType.CIRCLE;
import static com.galvanize.ocp.shapes.ShapeType.RECTANGLE;

class App {

	public static void main(final String... args) {

		final Printer printer = new Printer();

		final Shape rectangle = new Shape(RECTANGLE, "blue");
		rectangle.setA(2);
		rectangle.setB(3);
		System.out.println(printer.draw(rectangle));

		final Shape circle = new Shape(CIRCLE, "red");
		circle.setA(4);
		System.out.println(printer.draw(circle));
	}
}
