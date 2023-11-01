package edu.project2.generators;

import edu.project2.maze.CellType;
import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorRandom implements Generator {

    @Override
    public Maze generate(int width, int height) {
        Random random = new Random();
        Maze maze = new Maze(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                maze.setGridElement(new Coordinate(x, y), CellType.WALL);
            }
        }
        int startX = random.nextInt(width / 2) * 2 + 1;
        int startY = random.nextInt(height / 2) * 2 + 1;
        maze.setGridElement(new Coordinate(startX, startY), CellType.PASSAGE);

        List<Coordinate> border = new ArrayList<>();
        border.add(new Coordinate(startX, startY));

        while (!border.isEmpty()) {
            Coordinate currentPoint = border.remove(random.nextInt(border.size()));

            Direction[] directions = Direction.values();

            for (Direction direction : directions) {
                Coordinate newPoint = new Coordinate(currentPoint.row() + direction.dx,
                    currentPoint.col() + direction.dy
                );

                if (isInside(newPoint, width, height) && maze.getGridElement(newPoint).type() == CellType.WALL) {
                    maze.setGridElement(newPoint, CellType.PASSAGE);
                    maze.setGridElement(new Coordinate(
                        currentPoint.row() + direction.dx / 2,
                        currentPoint.col() + direction.dy / 2
                    ), CellType.PASSAGE);
                    border.add(newPoint);
                }
            }

        }
        return maze;
    }

    private boolean isInside(Coordinate point, int width, int height) {
        return point.row() > 0 && point.row() < width && point.col() > 0 && point.col() < height;
    }
}
