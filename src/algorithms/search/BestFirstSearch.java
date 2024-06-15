package algorithms.search;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch{
    public BestFirstSearch() {
        this.stateQueue = new PriorityQueue<>();
    }

//    @Override
//    public boolean ifVisited(AState state){
//        AState temp = minCostState.get(state.getState());
//        return temp == null || temp.getCost() > state.getCost();
//    }

}
