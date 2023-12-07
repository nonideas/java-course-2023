package edu.project2;

import edu.project2.maze.Cell;
import edu.project2.maze.CellType;
import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MazeTest {
    @Test
    void setMaze() {
        Maze maze = new Maze(2, 2);
        maze.setGridElement(new Coordinate(0, 0), CellType.WALL);
        maze.setGridElement(new Coordinate(0, 1), CellType.WALL);
        maze.setGridElement(new Coordinate(1, 0), CellType.WALL);
        maze.setGridElement(new Coordinate(1, 1), CellType.PASSAGE);
        Assertions.assertEquals(maze.getGridElement(new Coordinate(1, 0)).type(), CellType.WALL);
        Assertions.assertEquals(maze.getGridElement(new Coordinate(1, 1)).type(), CellType.PASSAGE);
    }

    @Test
    void inputMazeArray() {
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
        Assertions.assertEquals(maze.getGridElement(new Coordinate(2, 2)).type(), CellType.WALL);
        Assertions.assertEquals(maze.getGridElement(new Coordinate(3, 5)).type(), CellType.PASSAGE);
        Assertions.assertEquals(maze.getHeight(), 7);
        Assertions.assertEquals(maze.getWidth(), 7);
    }

    @Test
    void testAdjacentCells() {
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
        List<Cell> adjacentCells = maze.getAdjacentCells(new Cell(new Coordinate(2, 3), CellType.PASSAGE));
        Cell cell0 = adjacentCells.get(0);
        Cell cell1 = adjacentCells.get(1);

        Assertions.assertEquals(cell0.type(), CellType.PASSAGE);
        Assertions.assertEquals(cell1.type(), CellType.PASSAGE);

        Assertions.assertEquals(cell0.coordinate().col(), 3);
        Assertions.assertEquals(cell0.coordinate().row(), 1);
        Assertions.assertEquals(cell1.coordinate().col(), 3);
        Assertions.assertEquals(cell1.coordinate().row(), 3);
    }
}
