package algorithms.mazeGenerators;


public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        Maze emptyMaze = new Maze(rows, columns);
        emptyMaze.makeEndPosition();
        emptyMaze.makeEndPosition();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                emptyMaze.setMazeArray(i, j, 0);
            }
        }

        return emptyMaze;
    }

}
