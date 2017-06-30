package recur;

/* Maze Game:
 * ================
 * Create a matrix from input file represents 1's and 0's.
 * 1 represents path, 0 represents blocker
 * find the path exists or not
 * print matrix as well as result (exit found or not)
 * 
 * Ex1: 
 * Input file: first line is the size of the matrix, second line is the string "maze"
 * 5 
 * 1 0 0 0 1 1 1 1 1 0 0 0 1 0 1 0 1 1 1 0 0 0 0 0 1
 * 
 * program output:
 * 1 0 0 0 1 
 * 1 1 1 1 0 
 * 0 0 1 0 1 
 * 0 1 1 1 0 
 * 0 0 0 0 1 
 *  exit not found
 * 
 * Ex2:
 * Input file: first line size of the matrix, second line is the string
 * 
 * 7
 * 1 0 0 0 0 1 1 1 1 1 1 0 1 0 0 0 1 0 0 1 0 0 1 1 1 0 1 0 0 1 0 1 0 1 0 0 1 0 1 1 1 0 0 1 0 1 0 0 1
 * 
 * program output:
 * 
 * 1 0 0 0 0 1 1 
 * 1 1 1 1 0 1 0 
 * 0 0 1 0 0 1 0 
 * 0 1 1 1 0 1 0 
 * 0 1 0 1 0 1 0 
 * 0 1 0 1 1 1 0 
 * 0 1 0 1 0 0 1 
 * exit found
 * 
 * MazeRunner.java is a driver program
 * maze.jaa is a logic program a) converts string into a matrix and verifies the path exists or not b) prints both maze matrix as well as result path found or not
 * 
 *  Author:  Viswanath Kasireddy
 *  Date: 
 */
public class Maze {

	private final int[][] maze;

	// constructor
	public Maze(int size, String line) {
		// int j = 0;
		int i = 0;
		maze = new int[size][size];
		String[] items = line.split(" ");
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[0].length; c++) {
				// j = Integer.parseInt(items[c + r + (r * (size - 1))]);
				maze[r][c] = Integer.parseInt(items[i]);
				i = i + 1;
			}
		}
	}

	// method to print matrix maze
	public void print_maze() {
		System.out.println();

		for (int row = 0; row < maze.length; row++) {
			for (int column = 0; column < maze[row].length; column++) {
				System.out.print(maze[row][column] + " ");
			}
			System.out.println();
		}
	}

	// method to verify path exit or not
	public int hasExitPath(int row, int column) {
		int exitCnt = 0;
		if (matrixValidate(row, column)) {
			maze[row][column] = 2; // to avoid repeated calls (2 will replace 1
									// stating cell has been tried)

			// to check successful exit found else traverse down,right,up,left
			if (column == maze[0].length - 1) {
				exitCnt = 1;
				return 1;
			} else {
				exitCnt = hasExitPath(row + 1, column); // down
				if (exitCnt != 1) {
					exitCnt = hasExitPath(row, column + 1); // right
				}
				if (exitCnt != 1) {
					exitCnt = hasExitPath(row - 1, column); // up
				}
				if (exitCnt != 1) {
					exitCnt = hasExitPath(row, column - 1); // left
				}

			}

		}
		if (exitCnt == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	// method to validate the the input grid position is within the boundries of
	// matrix
	// check the cell is not blocked
	private boolean matrixValidate(int row, int column) {

		boolean validate = false;
		if (row >= 0 && row < maze.length && column >= 0
				&& column < maze[0].length)

			// check if cell is not blocked and not previously tried

			if (maze[row][column] == 1) {
				validate = true;
			}

		return validate;

	}

	@Override
	public String toString() {
		String ResultS = " ";
		int exit = hasExitPath(0, 0);
		if (exit == 1)
			ResultS = "exit found";
		else
			ResultS = "exit not found";

		return ResultS;
	}

}
