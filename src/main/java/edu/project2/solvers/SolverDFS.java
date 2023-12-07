package edu.project2.solvers;

import edu.project2.maze.Cell;
import java.util.Stack;

public class SolverDFS extends SolverAbstract {
    private final Stack<Cell> stack;

    public SolverDFS() {
        stack = new Stack<>();
    }

    @Override
    protected Cell getNextCell() {
        return stack.pop();
    }

    @Override
    protected void pushCell(Cell cell) {
        stack.push(cell);
    }

    @Override
    protected boolean isContainerEmpty() {
        return stack.isEmpty();
    }
}
