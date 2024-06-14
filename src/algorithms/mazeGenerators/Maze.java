package algorithms.mazeGenerators;

import java.util.Random;
import java.util.Arrays;

public class Maze {

    private Position startPosition;
    private Position endPosition;
    private int[][] mazeArray;
    private int rows, columns;

    public Maze(int rows, int columns) {
        this.startPosition = null;
        this.endPosition = null;
        this.mazeArray = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getGoalPosition() {
        return endPosition;
    }

    public void makeStartPosition() {
        if (startPosition == null && rows > 0 && columns > 0) {
            startPosition = chooseRandomly();
        }
    }

    public void setStartPosition(Position position) {
        startPosition = position;
    }


    public void makeGoalPosition() {
        if (endPosition == null && rows > 0 && columns > 0) {
            boolean flag = true;
            Position endPos = chooseRandomly();

            //end position cant be WALL ot equal to start position
            while (flag) {
                if (mazeArray[endPos.getRowIndex()][endPos.getColumnIndex()] == 0 &&
                        endPos.getColumnIndex() != startPosition.getColumnIndex() &&
                        endPos.getRowIndex() != startPosition.getRowIndex()) {
                    flag = false;
                } else { // bad choice - keep random
                    endPos = chooseRandomly();
                }
            }
            endPosition = endPos;

        }
    }

    public void setEndPosition(Position position) {
        endPosition = position;
    }

    public int[][] getMazeArray() {
        return mazeArray;
    }

    public void setMazeArray(int rowIndex, int columnIndex, int newVal) {
        mazeArray[rowIndex][columnIndex] = newVal;
    }

    public void setMazeArray(int[][] newMazeArray) {
        this.mazeArray = newMazeArray;
    }


    public Position chooseRandomly() {
        Random random = new Random();
        int cases = random.nextInt(4);
        Position randomlyPos = new Position(random.nextInt(rows), random.nextInt(columns));

        if (cases == 0) {//first row
            randomlyPos.setRowIndex(0);
            randomlyPos.setColumnIndex(random.nextInt(columns));
        }
        if (cases == 1) {//last row
            randomlyPos.setRowIndex(rows - 1);
            randomlyPos.setColumnIndex(random.nextInt(columns));
        }
        if (cases == 2) {//first column
            randomlyPos.setRowIndex(random.nextInt(rows));
            randomlyPos.setColumnIndex(0);
        }
        if (cases == 3) { //last column
            randomlyPos.setRowIndex(random.nextInt(rows));
            randomlyPos.setColumnIndex(columns - 1);
        }

        return randomlyPos;
    }

    public boolean checkPosition(Position position) {
        int rowIndex = position.getRowIndex();
        int columnIndex = position.getColumnIndex();
        return checkPosition(rowIndex, columnIndex);
    }

    public boolean checkPosition(int rowIndex, int columnIndex) {
        return rowIndex < getRows() && rowIndex > -1 &&
                columnIndex < getColumns() && columnIndex > -1 &&
                mazeArray[rowIndex][columnIndex] == 0;
    }


    public void print() {
        if (startPosition != null && endPosition != null) {
            char[][] charMazeArr = new char[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    charMazeArr[i][j] = (char) ('0' + mazeArray[i][j]);
                }
            }
//            System.out.println("E  =" + charMazeArr[endPosition.getRowIndex()][endPosition.getColumnIndex()]);
//            System.out.println("S  =" + charMazeArr[startPosition.getRowIndex()][startPosition.getColumnIndex()]);
            charMazeArr[endPosition.getRowIndex()][endPosition.getColumnIndex()] = 'E';
            charMazeArr[startPosition.getRowIndex()][startPosition.getColumnIndex()] = 'S';
            for (int i = 0; i < rows; i++) {
                System.out.println(Arrays.toString(charMazeArr[i]));
            }
        }
    }
}

