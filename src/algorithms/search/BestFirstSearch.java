package algorithms.search;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch{
    public BestFirstSearch() {
        this.stateQueue = new PriorityQueue<>();
    }
}
