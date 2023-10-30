package edu.project2.renders;

import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import java.util.List;

public interface Render {
    String render(Maze maze);
    String render(Maze maze, List<Coordinate> path);
}
