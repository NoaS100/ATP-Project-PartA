package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class SearchableMaze implements ISearchable {

    protected Maze maze;

    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    public AState getStartState() {
        return new MazeState(maze.getStart());
    }

    @Override
    public AState getGoalState() {
        return new MazeState(maze.getEnd());
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState state) {
        ArrayList<AState> res = new ArrayList<>();
        Position position = Position.fromString(state.state);

        Position cameFrom;
        if (state.getCameFrom() == null)
            cameFrom = new Position(-1, -1);
        else
            cameFrom = Position.fromString(state.getCameFrom().getState());

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Position currPos = new Position((position.getX() + i), (position.getY() + j));
                if (!currPos.equals(cameFrom)) {
                    if (maze.checkPosition(currPos)) {
                        if ((i * i) + (j * j) == 2) { // corner -> check if there's a diagonal
                            if (maze.checkPosition((position.getX() + i), (position.getY())) || maze.checkPosition((position.getX()), (position.getY() + j)))
                                res.add(new MazeState(currPos, state, state.getCost() + 15));
                        } else if ((i * i) + (j * j) == 1) { // not a corner and not self (0,0)
                            res.add(new MazeState(currPos, state, state.getCost() + 10));
                        }
                    }
                }
            }
        }

        return res;
    }
}
