package com.example;

import com.example.shape.Shape;

public class AreaCalculator {
    public double Area(Shape[] shapes) {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.area();
        }

        return area;
    }
}