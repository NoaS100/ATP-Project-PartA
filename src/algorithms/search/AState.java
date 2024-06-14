package algorithms.search;

public abstract class AState implements Comparable<AState> {
    protected String state;
    protected double cost;
    protected AState cameFrom;

    public AState(String state, AState cameFrom, double cost){
        this.state = state;
        this.cameFrom = cameFrom;
        this.cost = cost;
    }

    public AState(String state, AState cameFrom){
        this(state,cameFrom,0);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public AState getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(AState cameFrom) {
        this.cameFrom = cameFrom;
    }

    public boolean isSameState(AState state) {
        return this.state.equals(state.getState());
    }

    @Override
    public int compareTo(AState o) {
        if (this.cost > o.cost)
            return 1;
        else if (this.cost < o.cost)
            return -1;
        return 0;
    }
}
