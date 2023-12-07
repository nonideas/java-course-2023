package edu.project2.renders;

import edu.project2.maze.CellType;
import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import java.util.List;

public class RenderMaze implements Render {
    @Override
    public String render(Maze maze) {
        StringBuilder currentMaze = new StringBuilder();
        for (int row = 0; row < maze.getWidth(); row++) {
            for (int col = 0; col < maze.getHeight(); col++) {
                currentMaze.append(maze.getGridElement(new Coordinate(row, col)).type().draw());
            }
            currentMaze.append('\n');
        }
        return currentMaze.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        Maze mazeCopy = new Maze(maze);
        for (Coordinate point : path) {
            mazeCopy.setGridElement(new Coordinate(point.row(), point.col()), CellType.PATH);
        }
        return render(mazeCopy);
    }
}
