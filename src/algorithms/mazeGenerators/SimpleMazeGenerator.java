//package algorithms.mazeGenerators;
//import java.util.Random;
//
//public class SimpleMazeGenerator extends AMazeGenerator {
//
//    @Override
//    public Maze generate(int rows, int columns) {
//        Maze maze=new Maze(rows,columns);
//
//        Random random = new Random( );
//        int[][] newMazeArr=new int[rows][columns];
//        for(int i=0; i < rows; i++){
//            for(int j=0; j < columns; j++){
//                newMazeArr[i][j] = random.nextInt( 2 );
//            }
//        }
//
//        maze.setMazeArray(newMazeArr);
//
//        //choosing random start and end point
//        maze.makeStartPosition();
//        maze.makeGoalPosition();
//        makingAPath(maze);
//        return maze;
//    }
//
//    private void makingAPath(Maze maze){
//        int rowDifference = maze.getStartPosition().getRowIndex()-maze.getGoalPosition().getRowIndex();
//        int colDifference = maze.getStartPosition().getColumnIndex()-maze.getGoalPosition().getColumnIndex();
//
//        if(rowDifference < 0){
//            for (int i = maze.getStartPosition().getRowIndex() ; i <= maze.getGoalPosition().getRowIndex() ; i++){
//                maze.setMazeArray(i, maze.getStartPosition().getColumnIndex(), 0);
//            }
//        }else{
//            for (int i=maze.getGoalPosition().getRowIndex() ;i<=maze.getStartPosition().getRowIndex() ; i++){
//                maze.setMazeArray(i, maze.getGoalPosition().getColumnIndex(), 0);
//            }
//        }
//        if(colDifference<0) {
//            for (int i = maze.getStartPosition().getColumnIndex(); i <= maze.getGoalPosition().getColumnIndex(); i++) {
//                maze.setMazeArray(maze.getGoalPosition().getRowIndex() ,i, 0);
//            }
//        }else{
//            for (int i=maze.getGoalPosition().getColumnIndex();i<=maze.getStartPosition().getColumnIndex();i++){
//                maze.setMazeArray(maze.getStartPosition().getRowIndex() ,i, 0);
//            }
//        }
//    }
//
//}

package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        Maze maze = new Maze(rows, columns);
        Random random = new Random();
        int[][] newMazeArr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMazeArr[i][j] = random.nextInt(2);
            }
        }

        maze.setMazeArray(newMazeArr);

        // choosing random start and end point
        maze.makeStartPosition();
        maze.makeGoalPosition();
        makingAPath(maze);
        return maze;
    }

    private void makingAPath(Maze maze) {
        Position start = maze.getStartPosition();
        Position goal = maze.getGoalPosition();
        int startRow = start.getRowIndex();
        int startCol = start.getColumnIndex();
        int goalRow = goal.getRowIndex();
        int goalCol = goal.getColumnIndex();

        int currentRow = startRow;
        int currentCol = startCol;

        // Create a path to the goal
        while (currentRow != goalRow || currentCol != goalCol) {
            maze.setMazeArray(currentRow, currentCol, 0);

            if (currentRow < goalRow) {
                currentRow++;
            } else if (currentRow > goalRow) {
                currentRow--;
            } else if (currentCol < goalCol) {
                currentCol++;
            } else {
                currentCol--;
            }
        }

        maze.setMazeArray(goalRow, goalCol, 0);
    }
}
