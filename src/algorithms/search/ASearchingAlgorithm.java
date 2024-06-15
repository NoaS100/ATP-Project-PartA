package algorithms.search;

import java.util.Dictionary;
import java.util.Hashtable;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{

    protected int numberOfNodesEvaluated;
    public ASearchingAlgorithm(){
        numberOfNodesEvaluated = 0;
    }
    @Override
    public Solution solve(ISearchable problem) {
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return this.numberOfNodesEvaluated;
    }

    @Override
    public String getName() {
        return this.getClass().toString();
    }
}
