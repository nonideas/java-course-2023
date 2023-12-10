package edu.project4.pointFunctions;

import edu.project4.coordinate.Point;

public class SphericalFunction implements PointFunction {

    @Override
    public Point apply(Point oldPoint) {
        double x = oldPoint.x();
        double y = oldPoint.y();

        double newX = x / (x * x + y * y);
        double newY = y / (x * x + y * y);

        return new Point(newX, newY);
    }
}
