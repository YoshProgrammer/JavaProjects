/**
 * MazeSolver attempts to recursively traverse a 3DMaze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Joshua Brown - Foundation from Java Foundations
 */
public class MazeSolver
{
    private Maze maze;
    
    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    
    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse(int row, int column, int cell)
    {
        boolean done = false;
      
        if (maze.validPosition(row, column, cell))
        {
            maze.tryPosition(row, column, cell);

            if (row == maze.getRows() - 1 && column == maze.getColumns() - 1 && cell == maze.getCells() - 1) {
                done = true;
            }
            else {
                done = traverse(row + 1, column, cell);
            }
                if (!done) {
                    done = traverse(row, column + 1, cell);
                }

                if (!done) {
                    done = traverse(row, column, cell + 1);
                }

                if (!done) {
                    done = traverse(row - 1, column, cell);
                }

                if (!done) {
                    done = traverse(row, column - 1, cell);
                }

                if (!done) {
                    done = traverse(row, column, cell - 1);
                }

            if (done) { // this location is part of the final path
                maze.markPath(row, column, cell);
            }
        }
      
        return done;
    }
}
