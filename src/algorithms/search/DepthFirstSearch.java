package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{

    public DepthFirstSearch() {
        super();
    }

    @Override
    public Solution solve(ISearchable problem) {
        Stack<AState> stateStack = new Stack<>();
        this.numberOfNodesEvaluated = 0;

        stateStack.push(problem.getStartState());
        numberOfNodesEvaluated++;

        while(!stateStack.isEmpty()){

            AState currState = stateStack.pop();
            if (currState.isSameState(problem.getGoalState()))
                return new Solution(currState);

            for (AState state: problem.getAllSuccessors(currState)) {
                numberOfNodesEvaluated++;
                stateStack.push(state);
            }
        }
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numberOfNodesEvaluated;
    }
}
