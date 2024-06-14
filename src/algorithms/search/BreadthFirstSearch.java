package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{
    protected Dictionary<String, AState> minCostState;
    protected Queue<AState> stateQueue;

    public BreadthFirstSearch() {
        this.minCostState = new Hashtable<>();
        this.stateQueue = new LinkedList<>();
    }

    @Override
    public Solution solve(ISearchable problem) {
        this.minCostState = new Hashtable<>();
        stateQueue.clear();

        ArrayList<AState> allSuccessors = problem.getAllSuccessors(problem.getStartState());
        stateQueue.addAll(allSuccessors);
        while(!stateQueue.isEmpty()){
            AState state = stateQueue.poll();
            if(state.isSameState(problem.getGoalState()))
                return new Solution(state);
            if (ifVisited(state)) {
                stateQueue.addAll(problem.getAllSuccessors(state));
                this.minCostState.put(state.getState(), state);
            }
        }
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return minCostState.size();
    }

    public boolean ifVisited(AState state){
        return this.minCostState.get(state.getState()) == null;
    }
}
