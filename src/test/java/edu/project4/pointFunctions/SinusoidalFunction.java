package edu.project4.pointFunctions;

import edu.project4.coordinate.Point;

public class SinusoidalFunction implements PointFunction {
    @Override
    public Point apply(Point oldPoint) {
        double x = oldPoint.x();
        double y = oldPoint.y();

        double newX = Math.sin(x);
        double newY = Math.sin(y);

        return new Point(newX, newY);
    }
}
