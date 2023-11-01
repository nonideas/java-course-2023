package edu.project2;

import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import edu.project2.renders.Render;
import edu.project2.renders.RenderMaze;
import edu.project2.solvers.Solver;
import edu.project2.solvers.SolverBFS;
import edu.project2.solvers.SolverDFS;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ShowInConsoleTest {
    @Test
    void test() {
        String[][] mazeArray = new String[][] {
            {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜"},
            {"⬜", "⬛", "⬜", "⬛", "⬛", "⬛", "⬜"},
            {"⬜", "⬛", "⬜", "⬜", "⬜", "⬛", "⬜"},
            {"⬜", "⬛", "⬛", "⬛", "⬜", "⬛", "⬜"},
            {"⬜", "⬛", "⬜", "⬛", "⬜", "⬛", "⬜"},
            {"⬜", "⬛", "⬜", "⬛", "⬛", "⬛", "⬜"},
            {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜"}
        };
        Maze m = new Maze(mazeArray);
        Solver sd = new SolverDFS();
        List<Coordinate> p1 = sd.solve(m, new Coordinate(1, 1), new Coordinate(3, 5));
        Render r = new RenderMaze();
        System.out.println(r.render(m, p1));
        Solver sb = new SolverBFS();
        List<Coordinate> p2 = sb.solve(m, new Coordinate(1, 1), new Coordinate(3, 5));
        System.out.println(r.render(m, p2));
        System.out.println(r.render(m));
    }
}
