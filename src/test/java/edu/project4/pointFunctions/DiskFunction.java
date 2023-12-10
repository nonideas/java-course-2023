package edu.project4.pointFunctions;

import edu.project4.coordinate.Point;

public class DiskFunction implements PointFunction {
    @Override
    public Point apply(Point oldPoint) {
        double x = oldPoint.x();
        double y = oldPoint.y();

        double trigonomArg = Math.PI * Math.sqrt(x * x + y * y);
        double coeff = Math.atan(y / x) / Math.PI;

        double newX = coeff * Math.sin(trigonomArg);
        double newY = coeff * Math.cos(trigonomArg);

        return new Point(newX, newY);
    }
}
