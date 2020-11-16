package TicTacToe;

import java.util.*;

public class TicTacToe {

	private static List<Integer> playerPositions = new ArrayList<>();
	private static List<Integer> cpuPositions = new ArrayList<>();
	// Create a 3x3 array to represent the tic tac toe board and fill it
	private static char[][] ticTacToeBoard = new char[3][3];

	public static void main(String[] args) {
		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, 
							   { '-', '+', '-', '+', '-' }, 
							   { ' ', '|', ' ', '|', ' ' },
				               { '-', '+', '-', '+', '-' }, 
				               { ' ', '|', ' ', '|', ' ' }, };

		printGameBoard(gameBoard);

		while (true) {
			Scanner scan = new Scanner(System.in);
			// The player (you) start to play firstly
			// Ask the user for the placement (1-9) and check if it is valid
			System.out.println("Enter your X's placement (1-9): ");
			int playerPos = scan.nextInt();
			if ((!playerPositions.contains(playerPos)) && (!cpuPositions.contains(playerPos))) {
				placePiece(gameBoard, playerPos, "player");
				if (checkWinner() != " ") {
					printResult();
					break;
				}
				// Then CPU (your computer) select a random position atomically to type
				int cpuPos = (int) (Math.random() * 9 + 1);
				while ((playerPositions.contains(cpuPos)) || (cpuPositions.contains(cpuPos)) == true) {
					cpuPos = (int) (Math.random() * 9 + 1);
				}
				placePiece(gameBoard, cpuPos, "cpu");
				System.out.println("Cpu has placed an O.");
				if (checkWinner() != " ") {
					printResult();
					break;
				}
			} else {
				System.out.println("This placement is invalid, please try another position");
			}
		}
	}

	// Check if the game has ended in a tie
	public static boolean checkTie() {
		return playerPositions.size() + cpuPositions.size() == 9 ? true : false;

	}

	// Draws the board and prints it out like a 3*3 square
	public static void printGameBoard(char[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length; j++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.print("\n");
		}
	}

	// Set the right position on the board to the player or CPU char
	public static void placePiece(char[][] gameBoard, int pos, String user) {

		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
			ticTacToeBoard[(pos - 1) / 3][(pos - 1) % 3] = 'X';
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
			ticTacToeBoard[(pos - 1) / 3][(pos - 1) % 3] = 'O';
		}

		// Draw the new board after each successful placement
		gameBoard[2 * ((pos - 1) / 3)][2 * ((pos - 1) % 3)] = symbol;
		System.out.print("\n");
		printGameBoard(gameBoard);
		System.out.print("\n");

	}

	// Checks if either player or CPU has won
	public static String checkWinner() {
		if ((ticTacToeBoard[0][0] == 'O' && ticTacToeBoard[0][1]  == 'O' && ticTacToeBoard[0][2] == 'O') || // top row
			(ticTacToeBoard[1][0] == 'O' && ticTacToeBoard[1][1]  == 'O' && ticTacToeBoard[1][2] == 'O') || // middle row
			(ticTacToeBoard[2][0] == 'O' && ticTacToeBoard[2][1]  == 'O' && ticTacToeBoard[2][2] == 'O') || // bottom row
            (ticTacToeBoard[0][0] == 'O' && ticTacToeBoard[1][0]  == 'O' && ticTacToeBoard[2][0] == 'O') || // left column
            (ticTacToeBoard[0][1] == 'O' && ticTacToeBoard[1][1]  == 'O' && ticTacToeBoard[2][1] == 'O') || // middle column
            (ticTacToeBoard[0][2] == 'O' && ticTacToeBoard[1][2]  == 'O' && ticTacToeBoard[2][2] == 'O') || // right column
            (ticTacToeBoard[0][0] == 'O' && ticTacToeBoard[1][1]  == 'O' && ticTacToeBoard[2][2] == 'O') || // diagonal1
            (ticTacToeBoard[0][2] == 'O' && ticTacToeBoard[1][1]  == 'O' && ticTacToeBoard[2][0] == 'O')) { // diagonal2
			return "cpu";
		}else if((ticTacToeBoard[0][0] == 'X' && ticTacToeBoard[0][1]  == 'X' && ticTacToeBoard[0][2] == 'X') || // top row
			     (ticTacToeBoard[1][0] == 'X' && ticTacToeBoard[1][1]  == 'X' && ticTacToeBoard[1][2] == 'X') || // middle row
				 (ticTacToeBoard[2][0] == 'X' && ticTacToeBoard[2][1]  == 'X' && ticTacToeBoard[2][2] == 'X') || // bottom row
	             (ticTacToeBoard[0][0] == 'X' && ticTacToeBoard[1][0]  == 'X' && ticTacToeBoard[2][0] == 'X') || // left column
	             (ticTacToeBoard[0][1] == 'X' && ticTacToeBoard[1][1]  == 'X' && ticTacToeBoard[2][1] == 'X') || // middle column
	             (ticTacToeBoard[0][2] == 'X' && ticTacToeBoard[1][2]  == 'X' && ticTacToeBoard[2][2] == 'X') || // right column
	             (ticTacToeBoard[0][0] == 'X' && ticTacToeBoard[1][1]  == 'X' && ticTacToeBoard[2][2] == 'X') || // diagonal1
	             (ticTacToeBoard[0][2] == 'X' && ticTacToeBoard[1][1]  == 'X' && ticTacToeBoard[2][0] == 'X')) { // diagonal2
			return "player";
		}else {
			return " ";
		}
	}
	
	//An alternative method
	/*public static String checkWinner() {
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> middleRow = Arrays.asList(4, 5, 6);
		List<Integer> bottomRow = Arrays.asList(7, 8, 9);
		List<Integer> leftCol = Arrays.asList(1, 4, 7);
		List<Integer> middleCol = Arrays.asList(2, 5, 8);
		List<Integer> rightCol = Arrays.asList(3, 6, 9);
		List<Integer> diagonal1 = Arrays.asList(1, 5, 9);
		List<Integer> diagonal2 = Arrays.asList(7, 5, 3);
		List<List<Integer>> winnerLayout = new ArrayList<>();
		winnerLayout.add(topRow);
		winnerLayout.add(middleRow);
		winnerLayout.add(bottomRow);
		winnerLayout.add(leftCol);
		winnerLayout.add(middleCol);
		winnerLayout.add(rightCol);
		winnerLayout.add(diagonal1);
		winnerLayout.add(diagonal2);
		for (List<Integer> pos : winnerLayout) {
			if (playerPositions.containsAll(pos)) {
				return "player";
			} else if (cpuPositions.containsAll(pos)) {
				return "cpu";
			} else if (checkTie()) {
				return "tie";
			}
		}
		return " ";
	}*/

	public static void printResult() {
		if (checkWinner().equals("cpu")) {
			System.out.println("CPU wins! Sorry:(");
		} else if (checkWinner().equals("player")) {
			System.out.println("Congratulations you won!");
		} else if (checkWinner().equals("tie")) {
			System.out.println("CAT!");
		}
	}
}