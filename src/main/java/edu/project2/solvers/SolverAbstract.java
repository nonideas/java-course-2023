package edu.project2.solvers;

import edu.project2.maze.Cell;
import edu.project2.maze.CellType;
import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public abstract class SolverAbstract implements Solver {
    protected abstract Cell getNextCell();

    protected abstract void pushCell(Cell cell);

    protected abstract boolean isContainerEmpty();

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        if (maze.getGridElement(start).type() != CellType.PASSAGE) {
            return new ArrayList<>();
        }

        if (maze.getGridElement(end).type() != CellType.PASSAGE) {
            return new ArrayList<>();
        }

        Map<Coordinate, Coordinate> pathMap = new HashMap<>();
        Queue<Cell> queue = new LinkedList<>();
        Set<Cell> visited = new HashSet<>();

        pathMap.put(start, null);
        pushCell(new Cell(start, CellType.PASSAGE));

        while (!isContainerEmpty()) {
            Cell curCell = getNextCell();
            if (curCell.coordinate().row() == end.row() && curCell.coordinate().col() == end.col()) {
                break;
            }
            visited.add(curCell);
            List<Cell> nextCells = maze.getAdjacentCells(curCell)
                .stream().filter(cell -> !visited.contains(cell)).toList();

            for (Cell cell : nextCells) {
                pathMap.put(cell.coordinate(), curCell.coordinate());
                pushCell(cell);
            }
        }

        List<Coordinate> path = new ArrayList<>();
        Coordinate cur = end;
        path.add(cur);
        while (pathMap.get(cur) != null) {
            cur = pathMap.get(cur);
            path.add(cur);
        }
        return path;
    }
}
