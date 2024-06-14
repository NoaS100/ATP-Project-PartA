package algorithms.search;

import java.util.Dictionary;
import java.util.Hashtable;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{


    public ASearchingAlgorithm(){
    }
    @Override
    public Solution solve(ISearchable problem) {
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return 0;
    }

    @Override
    public String getName() {
        return this.getClass().toString();
    }
}
