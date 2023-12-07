package edu.project2.solvers;

import edu.project2.maze.Cell;
import java.util.LinkedList;
import java.util.Queue;

public class SolverBFS extends SolverAbstract {
    private final Queue<Cell> queue;

    public SolverBFS() {
        queue = new LinkedList<>();
    }

    @Override
    protected Cell getNextCell() {
        return queue.poll();
    }

    @Override
    protected void pushCell(Cell cell) {
        queue.add(cell);
    }

    @Override
    protected boolean isContainerEmpty() {
        return queue.isEmpty();
    }
}
