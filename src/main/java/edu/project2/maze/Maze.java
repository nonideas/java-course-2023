package edu.project2.maze;

import java.util.ArrayList;
import java.util.List;

public final class Maze {
    private final int width;
    private final int height;
    private final Cell[][] grid;

    public Maze(int width, int height) {
        this.height = height;
        this.width = width;
        this.grid = new Cell[height][width];
    }

    public Maze(String[][] givenMaze) {
        this.height = givenMaze.length;
        this.width = givenMaze[0].length;
        grid = new Cell[givenMaze.length][givenMaze[0].length];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grid[i][j] = new Cell(new Coordinate(i, j), CellType.fromString(givenMaze[i][j]));
            }
        }
    }

    public Maze(Maze other) {
        this.width = other.width;
        this.height = other.height;
        this.grid = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.grid[i][j] = new Cell(other.grid[i][j].coordinate(), other.grid[i][j].type());
            }
        }
    }

    public void setGridElement(Coordinate point, CellType type) {
        Cell cell = new Cell(point, type);
        grid[point.row()][point.col()] = cell;
    }

    public Cell getGridElement(Coordinate point) {
        return grid[point.row()][point.col()];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Cell> getAdjacentCells(Cell cell) {
        List<Cell> adjacentCells = new ArrayList<>();

        if (cell.coordinate().row() >= 1) {
            adjacentCells.add(new Cell(
                new Coordinate(cell.coordinate().row() - 1, cell.coordinate().col()),
                grid[cell.coordinate().row() - 1][cell.coordinate().col()].type()
            ));
        }

        if (cell.coordinate().col() < width - 1) {
            adjacentCells.add(new Cell(
                new Coordinate(cell.coordinate().row(), cell.coordinate().col() + 1),
                grid[cell.coordinate().row()][cell.coordinate().col() + 1].type()
            ));
        }

        if (cell.coordinate().row() < height - 1) {
            adjacentCells.add(new Cell(
                new Coordinate(cell.coordinate().row() + 1, cell.coordinate().col()),
                grid[cell.coordinate().row() + 1][cell.coordinate().col()].type()
            ));
        }

        if (cell.coordinate().col() >= 1) {
            adjacentCells.add(new Cell(
                new Coordinate(cell.coordinate().row(), cell.coordinate().col() - 1),
                grid[cell.coordinate().row()][cell.coordinate().col() + 1].type()
            ));
        }

        return adjacentCells.stream().filter(cell1 -> cell1.type() == CellType.PASSAGE).toList();
    }
}
