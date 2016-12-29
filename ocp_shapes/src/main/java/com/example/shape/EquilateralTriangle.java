package com.example.shape;

public class EquilateralTriangle extends Shape {
    private double side;

    public EquilateralTriangle(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return (Math.pow(getSide(), 2) * Math.sqrt(3.0)) / 4.0;
    }

}
