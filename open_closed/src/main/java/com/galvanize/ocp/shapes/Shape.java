package com.galvanize.ocp.shapes;

class Shape {

	private int a;
	private int b;
	private final String color;
	private final ShapeType type;


	Shape(final ShapeType type, final String color) {
		this.color = color;
		this.type = type;
	}

	int getA() {
		return a;
	}

	int getB() {
		return b;
	}

	String getColor() {
		return color;
	}

	ShapeType getType() {
		return type;
	}

	void setA(final int a) {
		this.a = a;
	}

	void setB(final int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Shape{" + "color='" + color + '\'' + ", type=" + type + '}';
	}
}
