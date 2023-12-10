package edu.project4.pointFunctions;

import edu.project4.coordinate.Point;

public class PolarFunction implements PointFunction {
    @Override
    public Point apply(Point oldPoint) {
        double x = oldPoint.x();
        double y = oldPoint.y();

        double newX = Math.atan(y / x) / Math.PI;
        double newY = Math.sqrt(x * x + y * y) - 1;

        return new Point(newX, newY);
    }
}
