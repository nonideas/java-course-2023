package edu.project2;

import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import edu.project2.renders.Render;
import edu.project2.renders.RenderMaze;
import edu.project2.solvers.Solver;
import edu.project2.solvers.SolverDFS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class RenderMazeTest {

    @Test
    void renderWithoutPath() {
        String[][] mazeArray = new String[][] {
            {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜"},
            {"⬜", "⬛", "⬜", "⬛", "⬛", "⬛", "⬜"},
            {"⬜", "⬛", "⬜", "⬜", "⬜", "⬛", "⬜"},
            {"⬜", "⬛", "⬛", "⬛", "⬜", "⬛", "⬜"},
            {"⬜", "⬛", "⬜", "⬛", "⬜", "⬛", "⬜"},
            {"⬜", "⬛", "⬜", "⬛", "⬛", "⬛", "⬜"},
            {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜"}
        };
        Maze maze = new Maze(mazeArray);
        Render render = new RenderMaze();
        String outputMaze = """
            ⬜⬜⬜⬜⬜⬜⬜
            ⬜⬛⬜⬛⬛⬛⬜
            ⬜⬛⬜⬜⬜⬛⬜
            ⬜⬛⬛⬛⬜⬛⬜
            ⬜⬛⬜⬛⬜⬛⬜
            ⬜⬛⬜⬛⬛⬛⬜
            ⬜⬜⬜⬜⬜⬜⬜
            """;

        Assertions.assertEquals(outputMaze, render.render(maze));
    }

    @Test
    void renderWithPath() {
        String[][] mazeArray = new String[][] {
            {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜"},
            {"⬜", "⬛", "⬜", "⬛", "⬛", "⬛", "⬜"},
            {"⬜", "⬛", "⬜", "⬜", "⬜", "⬛", "⬜"},
            {"⬜", "⬛", "⬛", "⬛", "⬜", "⬛", "⬜"},
            {"⬜", "⬛", "⬜", "⬛", "⬜", "⬛", "⬜"},
            {"⬜", "⬛", "⬜", "⬛", "⬛", "⬛", "⬜"},
            {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜"}
        };
        Maze maze = new Maze(mazeArray);
        Render render = new RenderMaze();
        Solver sd = new SolverDFS();
        List<Coordinate> path = sd.solve(maze, new Coordinate(1, 1), new Coordinate(3, 5));

        String outputMaze = """
            ⬜⬜⬜⬜⬜⬜⬜
            ⬜🟥⬜⬛⬛⬛⬜
            ⬜🟥⬜⬜⬜⬛⬜
            ⬜🟥🟥🟥⬜🟥⬜
            ⬜⬛⬜🟥⬜🟥⬜
            ⬜⬛⬜🟥🟥🟥⬜
            ⬜⬜⬜⬜⬜⬜⬜
            """;

        Assertions.assertEquals(outputMaze, render.render(maze, path));
    }
}
