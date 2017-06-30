package recur;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/* Maze Game:
 *===============
 *
 * Create a matrix from input file represents 1's and 0's.
 * 1 represents path, 0 represents blocker
 * find the path exists or not
 * print matrix as well as result (exit found or not)
 * 
 * Ex1: 
 * Input file: first line is the size of the matrix, second line is the string "maze"
 * 
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
 * 
 * Input file: first line size of the matrix, second line is the string
 * 7
 * 1 0 0 0 0 1 1 1 1 1 1 0 1 0 0 0 1 0 0 1 0 0 1 1 1 0 1 0 0 1 0 1 0 1 0 0 1 0 1 1 1 0 0 1 0 1 0 0 1
 * program output:
 * 1 0 0 0 0 1 1 
 * 1 1 1 1 0 1 0 
 * 0 0 1 0 0 1 0 
 * 0 1 1 1 0 1 0 
 * 0 1 0 1 0 1 0 
 * 0 1 0 1 1 1 0 
 * 0 1 0 1 0 0 1 
 * exit found
 * MazeRunner.java is a driver program
 * maze.jaa is a logic program a) converts string into a matrix and verifies the path exists or not b) prints both maze matrix as well as result path found or not
 * 
 *  Author:  Viswanath Kasireddy
 *  Date: 
 */
public class MazeRunner {
	public static void main(String args[]) throws IOException {
		Scanner file = new Scanner(
				new File(
						"/users/user name/Documents/workspace/NewJavaTest/src/maze.dat"));
		while (file.hasNextLine()) {
			int size = file.nextInt();
			file.nextLine();
			String line = file.nextLine();

			Maze op = new Maze(size, line);

			op.print_maze(); // print the input matrix

			// using toString method to verify exit found or not and to print
			// the result
			System.out.println(op);
		}
		file.close();
	}

}
