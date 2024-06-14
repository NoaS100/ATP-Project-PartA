package algorithms.search;

public interface ISearchingAlgorithm {

    Solution solve(ISearchable problem);

    int getNumberOfVisitedNodes();
}
