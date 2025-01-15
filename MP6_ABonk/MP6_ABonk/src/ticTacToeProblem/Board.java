package ticTacToeProblem;

public class Board {
	private char board[][];
	private int size;
	public char emptySpace = '-';

	public Board(int size) {
		this.size = size;
		board = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.board[i][j] = emptySpace;
			}
		}
	}

	public boolean isTaken(int row, int column) {
		return board[row - 1][column - 1] != emptySpace;
	}

	public boolean isFull() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (this.board[i][j] == emptySpace) {
					return false;
				}
			}
		}
		return true;
	}

	public void displayBoard() {
		for (int i = 0; i < this.size; i++) {
			System.out.print("|");
			for (int j = 0; j < this.size; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}

	}

	public void placeToken(char token, int row, int column) {
		if (isTaken(row, column)) {
			System.out.println("Space at " + row + ", " + column + " is taken.");
		} else {
			board[row - 1][column - 1] = token;
		}
	}

	public char getWinner() {
		if (getHorizontalWinner() != emptySpace) {
			return getHorizontalWinner();
		}
		if (getVerticalWinner() != emptySpace) {
			return getVerticalWinner();
		}
		if (getDiagonalWinner() != emptySpace) {
			return getDiagonalWinner();
		}
		return emptySpace;
	}

	public char getHorizontalWinner() {
		char firstChar;
		boolean hasWinner;
		for (int i = 0; i < size; i++) {
			firstChar = board[i][0];
			if (firstChar != emptySpace) {
				hasWinner = true;
				for (int j = 0; j < size; j++) {
					if (board[i][j] != firstChar) {
						hasWinner = false;
						break;
					}
				}
				if (hasWinner) {
					return firstChar;
				}
			}
		}
		return emptySpace;
	}

	public char getVerticalWinner() {
		char firstChar;
		boolean hasWinner;
		for (int i = 0; i < size; i++) {
			firstChar = board[0][i];
			if (firstChar != emptySpace) {
				hasWinner = true;
				for (int j = 0; j < size; j++) {
					if (board[j][i] != firstChar) {
						hasWinner = false;
						break;
					}
				}
				if (hasWinner) {
					return firstChar;
				}
			}
		}
		return emptySpace;
	}

	public char getDiagonalWinner() {
		char firstChar;
		boolean hasWinner;
		firstChar = board[0][0];
		if (firstChar != emptySpace) {
			hasWinner = true;
			for (int i = 1; i < size; i++) {
				if (board[i][i] != firstChar) {
					hasWinner = false;
					break;
				}
			}
			if (hasWinner) {
				return firstChar;
			}
			firstChar = board[0][size - 1];
			if (firstChar != emptySpace) {
				hasWinner = true;
				for (int i = 1; i < size; i++) {
					if (board[i][size - 1 - i] != firstChar) {
						hasWinner = false;
						break;
					}
				}
				if (hasWinner) {
					return firstChar;
				}
			}
		}

		return emptySpace;
	}
}
