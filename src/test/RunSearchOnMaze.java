package test;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.*;

import java.util.ArrayList;

public class RunSearchOnMaze {
    public static void main(String[] args) {
        IMazeGenerator mg = new MyMazeGenerator();
        System.out.println("Trying 10 on 10");
        Maze maze = mg.generate(10, 10);
        maze.print();
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        solveProblem(searchableMaze, new BreadthFirstSearch());
        solveProblem(searchableMaze, new DepthFirstSearch());
        solveProblem(searchableMaze, new BestFirstSearch());

        System.out.println("Trying 500 on 500");
        maze = mg.generate(500, 500);
        searchableMaze = new SearchableMaze(maze);
        solveProblem(searchableMaze, new BreadthFirstSearch());
        solveProblem(searchableMaze, new DepthFirstSearch());
        solveProblem(searchableMaze, new BestFirstSearch());
    }

    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher) {
        long startTime = System.nanoTime();
        Solution solution = searcher.solve(domain);
        long endTime = System.nanoTime();
        double timeTookInMS = (double) (endTime - startTime) / 1_000_000;
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s, time took: %s ms", searcher.getName(), searcher.getNumberOfNodesEvaluated(), timeTookInMS));
        System.out.println(String.format("Solution Cost: %s", solution.getFinalState().getCost()));
//                        System.out.println("Solution path:");
//        ArrayList<AState> solutionPath = solution.getSolutionPath();
//        for (int i = 0; i < solutionPath.size(); i++) {
//            System.out.println(String.format("%s.%s",i,solutionPath.get(i)));
//        }
    }
}