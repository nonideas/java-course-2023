package edu.project4.pointFunctions;

import edu.project4.coordinate.Point;
import java.awt.Color;

public record AffineTransformation(double a, double b, double c, double d, double e, double f, Color color) {
    public Point apply(Point point) {
        double newX = a * point.x() + b * point.y() + c;
        double newY = d * point.x() + e * point.y() + f;

        return new Point(newX, newY);
    }
}
