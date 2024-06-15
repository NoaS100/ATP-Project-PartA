//package algorithms.mazeGenerators;
//import java.util.Random;
//import java.util.*;
//
//public class MyMazeGenerator extends AMazeGenerator{
//
//    private static final int WALL = 1;
//    private static final int EMPTY = 0;
//    private static final int[] DX = {0, 0, 1, -1};
//    private static final int[] DY = {1, -1, 0, 0};
//    private Random random;
//
//
//    @Override
//    public Maze generate(int rows, int columns) {
//        Maze maze=new Maze(rows,columns);
//        maze.makeStartPosition();
//        maze.makeGoalPosition();
//        this.random = new Random();
//
//        // Initialize maze with walls
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                maze.setMazeArray(i, j, WALL);
//            }
//        }
//
//        // Generate maze
//        dfs(maze.getStartPosition().getRowIndex(), maze.getStartPosition().getColumnIndex(), maze);
//
//        //maze.makeGoalPosition();
//        return maze;
//
//    }
//
//
//    private void dfs(int rowIndex, int columnIndex, Maze maze) {
//        Stack<Position> stack = new Stack<>();
//        stack.push(new Position(rowIndex, columnIndex));
//
//        while (!stack.isEmpty()) {
//            Position current = stack.pop();
//            int x = current.getRowIndex();
//            int y = current.getColumnIndex();
//
//            // Mark current cell as visited
//            maze.setMazeArray(x, y, EMPTY);
//
//            // Shuffle directions for randomized path carving
//            List<Integer> directions = Arrays.asList(0, 1, 2, 3);
//            Collections.shuffle(directions, random);
//
//            // Try to explore each direction
//            boolean foundPath = false;
//            for (int d : directions) {
//                int nx = x + DX[d];
//                int ny = y + DY[d];
//
//
//                if (canCarvePath(nx, ny, maze)) {
//                    stack.push(new Position(nx, ny));
//                    foundPath = true;
//
//                }
//            }
//
//            // If no valid path found, backtrack
//            if (!foundPath && current != maze.getStartPosition() && current != maze.getGoalPosition() ) {
//                maze.setMazeArray(x, y, WALL); // Mark cell as wall
//            }
//        }
//    }
//
//
//    private boolean canCarvePath(int x, int y, Maze maze) {
//        return x >= 0 && x < maze.getRows() && y >= 0 && y < maze.getColumns() && maze.getMazeArray()[x][y] == WALL;
//    }
//
//}
//

package algorithms.mazeGenerators;

import java.util.*;

public class MyMazeGenerator extends AMazeGenerator {

    private static final int WALL = 1;
    private static final int EMPTY = 0;
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};
    private Random random;

    @Override
    public Maze generate(int rows, int columns) {
        Maze maze = new Maze(rows, columns);
        maze.makeStartPosition();
        this.random = new Random();

        // Initialize maze with walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maze.setMazeArray(i, j, WALL);
            }
        }

        // Generate maze
        generateMaze(maze.getStartPosition().getRowIndex(), maze.getStartPosition().getColumnIndex(), maze);

        maze.makeGoalPosition();
        return maze;
    }

    private void generateMaze(int startRow, int startCol, Maze maze) {
        Position curr;
        int count; //counting the visited neighbors for current cell

        //frontiers list , candidates to be selected as the next cell in the maze.
        List<Position> frontier= new ArrayList<>();
        frontier.add(new Position(startRow, startCol));

        while (!frontier.isEmpty()) {
            curr=frontier.remove(random.nextInt(frontier.size()));
            count=neighborsVisited(maze,curr);

            if(count<=1){
                maze.setMazeArray(curr.getRowIndex(), curr.getColumnIndex(), EMPTY);
                //down
                addValidPath(curr.getRowIndex()+1, curr.getColumnIndex(), maze,frontier);
                //up
                addValidPath(curr.getRowIndex()-1, curr.getColumnIndex(), maze,frontier);
                //left
                addValidPath(curr.getRowIndex(), curr.getColumnIndex()-1, maze,frontier);
                //right
                addValidPath(curr.getRowIndex(), curr.getColumnIndex()+1, maze,frontier);
            }
        }

    }


    //return the count of visited neighbors for a cell
    private int neighborsVisited(Maze maze, Position curr){
        int Ncount=0;
        //down
        if(curr.getRowIndex()+1< maze.getRows() && maze.getMazeArray()[curr.getRowIndex()+1][curr.getColumnIndex()]==0)
            Ncount++;
        //up
        if(curr.getRowIndex()-1>=0 && maze.getMazeArray()[curr.getRowIndex()-1][curr.getColumnIndex()]==0)
            Ncount++;
        //right
        if(curr.getColumnIndex()+1<maze.getColumns() && maze.getMazeArray()[curr.getRowIndex()][curr.getColumnIndex()+1]==0)
            Ncount++;
        //left
        if(curr.getColumnIndex()-1>=0 && maze.getMazeArray()[curr.getRowIndex()][curr.getColumnIndex()-1]==0)
            Ncount++;
        return Ncount;}

    private void addValidPath(int x, int y, Maze maze, List<Position> frontiers) {
        if (x >= 0 && x < maze.getRows() && y >= 0 && y < maze.getColumns() && maze.getMazeArray()[x][y] == WALL){
            frontiers.add(new Position(x, y));
        }
    }
}

