import java.util.*;
import java.io.*;

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeTester
{
    private static Scanner scan = new Scanner(System.in);

    /**
     * Asks the user if they want to use a pre-existing maze file or generate a random one
     */
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        System.out.print("Do you want to generate a random maze or use an existing maze? " +
                "(Enter random or existing): ");
        String useRandom = scan.next();

        if (useRandom.contains("random")) {
            randomMaze();
            solveMazeFromFile();
        } else {
            solveMazeFromFile();
        }
    }

    /**
     * Reads in the file name, creates the maze, and attempts to solve it.
     * @throws FileNotFoundException
     */
    private static void solveMazeFromFile() throws FileNotFoundException {
        System.out.print("Enter the name of the file containing the maze: (random.txt if you are using a " +
                "random maze): ");
        scan.nextLine();

        String filename = scan.nextLine();

        Maze labyrinth = new Maze(filename);

        System.out.println(labyrinth);

        MazeSolver solver = new MazeSolver(labyrinth);

        if (solver.traverse(0, 0, 0)) {
            System.out.println("The maze was successfully traversed!");
        }
        else {
            System.out.println("There is no possible path.");
        }

        System.out.println(labyrinth);
    }

    /**
     * Creates a random 3D maze.
     * @throws IOException
     */
    private static void randomMaze() throws IOException {

        try {
            String result = "10 10 10 \n";
            int[][][] newMaze = new int[10][10][10];

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 10; k++) {
                        if (Math.random() < 0.5) {
                            newMaze[i][j][k] = 0;
                        } else {
                            newMaze[i][j][k] = 1;
                        }
                    }
                }
            }

            for (int row = 0; row < newMaze.length; row++) {
                for (int column = 0; column < newMaze[row].length; column++) {
                    for (int cell = 0; cell < newMaze[row][column].length; cell++) {
                        for (int i = 0; i < 10; i++) {
                            result += newMaze[row][column][cell] + " ";
                            if (i + 1 == 10 && i < newMaze[row][column][cell]) {
                                result += "\n";
                                i = 0;
                            }
                        }
                        result += "\n";
                    }
                    result += "\n";
                }
            }


            Writer writer = new FileWriter("random.txt");
            writer.write(result);
            writer.close();
        } catch (IOException error) {
            System.out.println("IO EXCEPTION: " + error.getMessage());
        }
    }
}
