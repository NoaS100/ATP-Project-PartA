package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{

    protected HashSet<String> visitedStates;

    public DepthFirstSearch() {
        this.visitedStates = new HashSet<>();
    }

    @Override
    public Solution solve(ISearchable problem) {
        Stack<AState> stateStack = new Stack<>();

        stateStack.push(problem.getStartState());

        while(!stateStack.isEmpty()){

            AState currState = stateStack.pop();
            if (currState.getState().equals(problem.getGoalState().getState()))
                return new Solution(currState);

            visitedStates.add(currState.getState());

            for (AState state: problem.getAllSuccessors(currState)) {
                if (!visitedStates.contains(state.getState()))
                    stateStack.push(state);
            }
        }

        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return visitedStates.size();
    }
}
