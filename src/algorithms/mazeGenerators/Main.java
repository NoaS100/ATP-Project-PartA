package algorithms.mazeGenerators;

public class Main<T> {

    public static void main(String[] args) {

        int rows = 5, columns = 5;

//        EmptyMazeGenerator mazeGenerator = new EmptyMazeGenerator();
//
//        Maze maze = mazeGenerator.generate(rows, columns);


        SimpleMazeGenerator mazeGenerator = new SimpleMazeGenerator();

        Maze maze = mazeGenerator.generate(rows, columns);

        // Print the generated maze
        maze.print();

    }
}

