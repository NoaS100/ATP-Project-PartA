import algorithms.mazeGenerators.Maze;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(4, 4);
        SearchableMaze searchableMaze = new SearchableMaze(maze);

        ASearchingAlgorithm searchingAlgorithm = new BreadthFirstSearch();

        Solution solution = searchingAlgorithm.solve(searchableMaze);

        solution.getSolutionPath();

        int x = 0;

    }
}