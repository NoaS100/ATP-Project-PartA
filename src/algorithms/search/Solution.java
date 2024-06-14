package algorithms.search;

import java.util.ArrayList;

public class Solution{

    protected AState finalState;

    public Solution(AState finalState) {
        this.finalState = finalState;
    }

    public ArrayList<AState> getSolutionPath(){
        ArrayList<AState> res = new ArrayList<>();
        AState currState = finalState;
        while (currState != null){
            res.add(0,currState);
            currState = currState.getCameFrom();
        }
        return res;
    }

    public AState getFinalState() {
        return finalState;
    }
}
