package algorithms.mazeGenerators;
import java.util.Random;
import java.util.*;

public class MyMazeGenerator extends AMazeGenerator{

    private static final int WALL = 1;
    private static final int EMPTY = 0;
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};
    private Random random;


    @Override
    public Maze generate(int rows, int columns) {
        Maze maze=new Maze(rows,columns);
        maze.makeStartPosition();
        maze.makeGoalPosition();
        this.random = new Random();

        // Initialize maze with walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maze.setMazeArray(i, j, WALL);
            }
        }

        // Generate maze
        dfs(maze.getStartPosition().getRowIndex(), maze.getStartPosition().getColumnIndex(), maze);

        return maze;

    }


    private void dfs(int rowIndex, int columnIndex, Maze maze) {
        Stack<Position> stack = new Stack<>();
        stack.push(new Position(rowIndex, columnIndex));

        while (!stack.isEmpty()) {
            Position current = stack.pop();
            int x = current.getRowIndex();
            int y = current.getColumnIndex();

            // Mark current cell as visited
            maze.setMazeArray(x, y, EMPTY);

            // Shuffle directions for randomized path carving
            List<Integer> directions = Arrays.asList(0, 1, 2, 3);
            Collections.shuffle(directions, random);

            // Try to explore each direction
            boolean foundPath = false;
            for (int d : directions) {
                int nx = x + DX[d];
                int ny = y + DY[d];


                if (canCarvePath(nx, ny, maze)) {
                    stack.push(new Position(nx, ny));
                    foundPath = true;

                }
            }

            // If no valid path found, backtrack
            if (!foundPath && current != maze.getStartPosition() && current != maze.getGoalPosition() ) {
                maze.setMazeArray(x, y, WALL); // Mark cell as wall
            }
        }
    }


    private boolean canCarvePath(int x, int y, Maze maze) {
        return x >= 0 && x < maze.getRows() && y >= 0 && y < maze.getColumns() && maze.getMazeArray()[x][y] == WALL;
    }

}



