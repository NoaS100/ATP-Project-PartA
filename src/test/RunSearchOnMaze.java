package test;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.*;

import java.util.ArrayList;

public class RunSearchOnMaze {
    public static void main(String[] args) {
        IMazeGenerator mg = new MyMazeGenerator();
//        System.out.println("Trying 100 on 100");
//        Maze maze = mg.generate(100, 100);
////        maze.print();
//        SearchableMaze searchableMaze = new SearchableMaze(maze);
//        solveProblem(searchableMaze, new BreadthFirstSearch());
//        solveProblem(searchableMaze, new DepthFirstSearch());
//        solveProblem(searchableMaze, new BestFirstSearch());
////
//        System.out.println("Trying 500 on 500");
//        maze = mg.generate(500, 500);
//        searchableMaze = new SearchableMaze(maze);
//        solveProblem(searchableMaze, new BreadthFirstSearch());
//        solveProblem(searchableMaze, new DepthFirstSearch());
//        solveProblem(searchableMaze, new BestFirstSearch());
        testAlgorithmsOnMultipleMazes(mg, 1000,1000,100);
    }

    private static double[]  solveProblem(ISearchable domain, ISearchingAlgorithm searcher) {
        long startTime = System.nanoTime();
        Solution solution = searcher.solve(domain);
        double[] res = new double[2];
        res[0] = searcher.getNumberOfNodesEvaluated();
        res[1] = solution.getFinalState().getCost();
        return res;
//        long endTime = System.nanoTime();
//        double timeTookInMS = (double) (endTime - startTime) / 1_000_000;
//        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s, time took: %s ms", searcher.getName(), searcher.getNumberOfNodesEvaluated(), timeTookInMS));
//        System.out.println(String.format("Solution Cost: %s", solution.getFinalState().getCost()));
//                        System.out.println("Solution path:");
//        ArrayList<AState> solutionPath = solution.getSolutionPath();
//        for (int i = 0; i < solutionPath.size(); i++) {
//            System.out.println(String.format("%s.%s",i,solutionPath.get(i)));
//        }
//        return res;
    }

    private static void testAlgorithmsOnMultipleMazes(IMazeGenerator mg, int rows, int columns, int numMazes) {
        ISearchingAlgorithm[] algorithms = {new BreadthFirstSearch(), new DepthFirstSearch(), new BestFirstSearch()};
//        ISearchingAlgorithm[] algorithms = {new DepthFirstSearch()};
        long[] totalTimes = new long[algorithms.length];
        long[] nodesVisit = new long[algorithms.length];
        long[] totalCost = new long[algorithms.length];

        for (int i = 0; i < numMazes; i++) {
            Maze maze = mg.generate(rows, columns);
//            maze.print();
            SearchableMaze searchableMaze = new SearchableMaze(maze);

            for (int j = 0; j < algorithms.length; j++) {
                long startTime = System.nanoTime();
                double[] res =  solveProblem(searchableMaze, algorithms[j]);
                long endTime = System.nanoTime();
                totalTimes[j] += (endTime - startTime);
                nodesVisit[j] += res[0];
                totalCost[j] += res[1];
            }
        }

        for (int j = 0; j < algorithms.length; j++) {
            System.out.println(String.format("Average time for '%s' algorithm: %s ms", algorithms[j].getName(), (totalTimes[j] / numMazes) / 1_000_000.0));

        }
        for (int j = 0; j < algorithms.length; j++) {
            System.out.println(String.format("Average Nodes visit for '%s' algorithm: %s ", algorithms[j].getName(), nodesVisit[j] / numMazes));

        }
        for (int j = 0; j < algorithms.length; j++) {
            System.out.println(String.format("Average Cost for '%s' algorithm: %s ", algorithms[j].getName(), totalCost[j] / numMazes));

        }
    }
}