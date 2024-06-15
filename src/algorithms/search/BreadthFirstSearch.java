package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{
//    protected HashSet<String> visitedStates;
    protected Queue<AState> stateQueue;

    public BreadthFirstSearch() {
//        this.visitedStates = new HashSet<>();
        this.stateQueue = new LinkedList<>();
    }

    @Override
    public Solution solve(ISearchable problem) {
//        this.visitedStates.clear();
        stateQueue.clear();
        this.numberOfNodesEvaluated = 0;

        ArrayList<AState> allSuccessors = problem.getAllSuccessors(problem.getStartState());
        stateQueue.addAll(allSuccessors);
        this.numberOfNodesEvaluated += allSuccessors.size();
        while(!stateQueue.isEmpty()){
            AState state = stateQueue.poll();
            if(state.isSameState(problem.getGoalState()))
                return new Solution(state);
            ArrayList<AState> temp = problem.getAllSuccessors(state);
            stateQueue.addAll(temp);
            this.numberOfNodesEvaluated += temp.size();
       }
        return null;
    }


}
