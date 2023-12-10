package edu.project4.fractalCreators;

import edu.project4.coordinate.Dot;
import edu.project4.coordinate.Point;
import edu.project4.graphics.PixelCanvas;
import edu.project4.pointFunctions.AffineTransformation;
import edu.project4.pointFunctions.PointFunction;
import java.util.List;

public class SingleThreadFractalCreator extends AbstractFractalCreator {

    public static void fillCanvas(
        PixelCanvas canvas,
        int samples,
        int iterationsPerSample,
        int offset,
        List<AffineTransformation> transformations,
        List<PointFunction> pointFunctions
    ) {
        for (int sample = 0; sample < samples; sample++) {
            Point startPoint = getRandomInitialPoint();
            iteratePoint(startPoint, offset, iterationsPerSample, transformations, pointFunctions, canvas);
        }
    }

    private static void iteratePoint(
        Point point,
        int offset,
        int iterationsPerSample,
        List<AffineTransformation> transformations,
        List<PointFunction> pointFunctions,
        PixelCanvas canvas
    ) {
        Point newPoint = point;
        for (int iteration = offset; iteration < iterationsPerSample; iteration++) {
            AffineTransformation transformation = getRandomElement(transformations);

            newPoint = transformation.apply(newPoint);
            newPoint = applyPointFunctions(newPoint, pointFunctions);

            if (iteration >= 0
                && (newPoint.x() >= X_MIN && newPoint.x() <= X_MAX)
                && (newPoint.y() >= Y_MIN && newPoint.y() <= Y_MAX)) {

                Dot dot = getDot(newPoint, canvas.getHeight(), canvas.getWidth());

                if (dot.x() < canvas.getHeight() && dot.y() < canvas.getWidth()) {
                    paintPixel(dot, canvas, transformation.color());
                }
            }
        }
    }
}
