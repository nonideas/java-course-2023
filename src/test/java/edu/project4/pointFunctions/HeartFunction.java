package edu.project4.pointFunctions;

import edu.project4.coordinate.Point;

public class HeartFunction implements PointFunction {

    @Override
    public Point apply(Point oldPoint) {
        double x = oldPoint.x();
        double y = oldPoint.y();

        double sqrt = Math.sqrt(x * x + y * y);
        double trigonometryArgs = sqrt * Math.atan(y / x);

        double newX = sqrt * Math.sin(trigonometryArgs);
        double newY = -sqrt * Math.cos(trigonometryArgs);

        return new Point(newX, newY);
    }
}
