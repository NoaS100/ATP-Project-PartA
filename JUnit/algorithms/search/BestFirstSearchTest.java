package algorithms.search;

import algorithms.mazeGenerators.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    private BestFirstSearch BeFS;

    @BeforeEach
    void setUp() {
        this.BeFS = new BestFirstSearch();
    }

    @Test
    void getName() {
        assertEquals("BestFirstSearch", BeFS.getName());
    }

    @Test
    void solve() {
        IMazeGenerator emptyMazeGenerator = new EmptyMazeGenerator();
        Maze emptyMaze = emptyMazeGenerator.generate(7,7);
        SearchableMaze searchableEmptyMaze = new SearchableMaze(emptyMaze);
        Solution solution = BeFS.solve(searchableEmptyMaze);
        assertNotEquals(null, solution);
        assertNotEquals(0, solution.getFinalState().getCost());

        MyMazeGenerator myMazeGenerator = new MyMazeGenerator();
        Maze myMaze = myMazeGenerator.generate(10,10);
        SearchableMaze searchableMyMaze = new SearchableMaze(myMaze);
        solution = BeFS.solve(searchableMyMaze);
        assertNotEquals(null, solution);
        assertNotEquals(0, solution.getFinalState().getCost());

        SimpleMazeGenerator simpleMazeGenerator = new SimpleMazeGenerator();
        Maze simpleMaze = simpleMazeGenerator.generate(10,10);
        SearchableMaze searchableSimpleMaze = new SearchableMaze(simpleMaze);
        solution = BeFS.solve(searchableSimpleMaze);
        assertNotEquals(null, solution);
        assertNotEquals(0, solution.getFinalState().getCost());
    }

    @Test
    void testSize() {
        IMazeGenerator emptyMazeGenerator = new EmptyMazeGenerator();
        Maze emptyMaze = emptyMazeGenerator.generate(-7,7);
        assertNull(emptyMaze);

        MyMazeGenerator myMazeGenerator = new MyMazeGenerator();
        Maze myMaze = myMazeGenerator.generate(0,10);
        assertNull(myMaze);

        SimpleMazeGenerator simpleMazeGenerator = new SimpleMazeGenerator();
        Maze simpleMaze = simpleMazeGenerator.generate(10,-3);
        assertNull(simpleMaze);
    }
}