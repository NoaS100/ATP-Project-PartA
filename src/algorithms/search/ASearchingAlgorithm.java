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
    public int getNumberOfVisitedNodes() {
        return 0;
    }
}
