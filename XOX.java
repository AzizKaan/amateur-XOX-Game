package xoxGame;

import java.util.Scanner;

public class XOX {
	public static int count = 0;
	public static String[][] board = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };

	public static void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		playGame();
	}

	public static String player1() {
		int x = (int) (Math.random() * 2);
		if (x == 0) {
			return "X";
		} else
			return "O";
	}

	public static String switchPlayer(String player) {
		if (player.equals("X")) {
			return "O";
		} else
			return "X";
	}

	public static void playerTurn(String p) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Satýr seçiniz...");
		int row = scan.nextInt();
		System.out.println("Sütun seçiniz...");
		int col = scan.nextInt();
		while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col].equals("X") || board[row][col].equals("O")) {
			System.out.println("Tekrar Deneyiniz!");
			System.out.println("Satýr seçiniz...");
			row = scan.nextInt();
			System.out.println("Sütun seçiniz...");
			col = scan.nextInt();
		}
		board[row][col] = p;
		count++;
	}

	public static boolean isWinner() {
		if (rowEquals(board) || colEquals(board) || diagonalOne(board) || diagonalTwo(board)) {
			return true;
		}
		return false;
	}

	static boolean rowEquals(String[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			if ((arr[i][0].equals("X") && arr[i][1].equals("X") && arr[i][2].equals("X"))
					|| (arr[i][0].equals("O") && arr[i][1].equals("O") && arr[i][2].equals("O")))
				return true;
		}
		return false;
	}

	static boolean colEquals(String[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			if ((arr[0][i].equals("X") && arr[1][i].equals("X") && arr[2][i].equals("X"))
					|| (arr[0][i].equals("O") && arr[1][i].equals("O") && arr[2][i].equals("O")))
				return true;
		}
		return false;
	}

	static boolean diagonalOne(String[][] arr) {
		if ((arr[0][0].equals("X") && arr[1][1].equals("X") && arr[2][2].equals("X"))
				|| (arr[0][0].equals("O") && arr[1][1].equals("O") && arr[2][2].equals("O")))
			return true;
		return false;
	}

	static boolean diagonalTwo(String[][] arr) {
		if ((arr[0][2].equals("X") && arr[1][1].equals("X") && arr[2][0].equals("X"))
				|| (arr[0][2].equals("O") && arr[1][1].equals("O") && arr[2][0].equals("O")))
			return true;
		return false;
	}

	public static void playGame() {
		printBoard();
		String player = player1();
		System.out.println(player + " baþlýyor...");
		playerTurn(player);
		while (!isWinner() && count != 9) {
			player = switchPlayer(player);
			printBoard();
			System.out.println("Sýra " + player + "'da");
			playerTurn(player);
		}
		printBoard();
		if (count == 9) {
			System.out.println("Berabere !!");
		} else
			System.out.println(player + " kazandý :)");
	}
}