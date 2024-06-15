package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{
    protected HashSet<String> visitedStates;
    protected Queue<AState> stateQueue;

    public BreadthFirstSearch() {
        this.visitedStates = new HashSet<>();
        this.stateQueue = new LinkedList<>();
    }

    @Override
    public Solution solve(ISearchable problem) {
        this.visitedStates.clear();
        stateQueue.clear();

        ArrayList<AState> allSuccessors = problem.getAllSuccessors(problem.getStartState());
        stateQueue.addAll(allSuccessors);
        while(!stateQueue.isEmpty()){
            AState state = stateQueue.poll();
            if(state.isSameState(problem.getGoalState()))
                return new Solution(state);
            if (!this.visitedStates.contains(state.getState())) {
                stateQueue.addAll(problem.getAllSuccessors(state));
                this.visitedStates.add(state.getState());
            }
        }
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return visitedStates.size();
    }


//    public boolean ifVisited(AState state){
//        return this.minCostState.get(state.getState()) == null;
//    }
}
