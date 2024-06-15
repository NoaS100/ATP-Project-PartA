package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class SearchableMaze implements ISearchable {

    protected Maze maze;

    protected boolean[][] visitedMaze;

    public SearchableMaze(Maze maze) {
        this.maze = maze;
        this.visitedMaze = new boolean[maze.getRows()][maze.getColumns()];
        initVisits();
    }

    private void initVisits(){
        for(int i = 0; i< visitedMaze.length; i++){
            for(int j = 0; j< visitedMaze[0].length; j++){
                visitedMaze[i][j] = false;
            }
        }
    }

    @Override
    public AState getStartState() {
        return new MazeState(maze.getStartPosition());
    }

    @Override
    public AState getGoalState() {
        return new MazeState(maze.getGoalPosition());
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState state) {
        ArrayList<AState> res = new ArrayList<>();
        Position position = Position.fromString(state.state);

        Position cameFrom;
        if (state.getCameFrom() == null) {
            cameFrom = new Position(-1, -1);
            initVisits();
//            System.out.println("initVisits");
        }
        else
            cameFrom = Position.fromString(state.getCameFrom().getState());

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Position currPos = new Position((position.getRowIndex() + i), (position.getColumnIndex() + j));
//                !currPos.equals(cameFrom) &&
                if (maze.checkPosition(currPos) && !visitedMaze[currPos.getRowIndex()][currPos.getColumnIndex()]) {
                    if ((i * i) + (j * j) == 2) { // corner -> check if there's a diagonal
                        if (maze.checkPosition((position.getRowIndex() + i), (position.getColumnIndex())) ||
                                maze.checkPosition((position.getRowIndex()), (position.getColumnIndex() + j))) {
                            visitedMaze[currPos.getRowIndex()][currPos.getColumnIndex()] = true;
                            res.add(new MazeState(currPos, state, state.getCost() + 15));
                        }
                    } else if ((i * i) + (j * j) == 1) { // not a corner and not self (0,0)
                        visitedMaze[currPos.getRowIndex()][currPos.getColumnIndex()] = true;
                        res.add(new MazeState(currPos, state, state.getCost() + 10));
                    }
                }
            }
        }

        return res;
    }
}
