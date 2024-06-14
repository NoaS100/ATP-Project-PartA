package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    public MazeState(Position position, AState cameFrom) {
        super(position.toString(), cameFrom);
    }

    public MazeState(Position position, AState cameFrom, double cost) {
        super(position.toString(), cameFrom, cost);
    }
    public MazeState(Position position) {
        super(position.toString(), null);
    }

    public Position getPosition(){
        return Position.fromString(this.state);
    }
}
