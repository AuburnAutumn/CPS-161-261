package Funky_Game;

public class FunkyBoard {

	private FunkyToken[][] board;
	private int size;
	public char emptySpace = '-';

	public FunkyBoard(int size) {
		this.size = size;
		board = new FunkyToken[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.board[i][j] = null;
			}
		}
	}

	public void displayBoard() {
		for (int i = 0; i < this.size; i++) {
			System.out.print("|");
			for (int j = 0; j < this.size; j++) {
				if (board[i][j] == null) {
					System.out.print(emptySpace + "|");
				} else {
					System.out.print((board[i][j].getToken()) + "|");
				}
			}
			System.out.println();
		}

	}

	public void placeToken(FunkyToken token, int rowPos, int columnPos) {
		board[rowPos][columnPos] = token;
		token.setRowPos(rowPos);
		token.setColumnPos(columnPos);
	}

	public int getSize() {
		return size;
	}

	public FunkyToken[][] getBoard() {
		return board;
	}

	public void setBoard(int newRow, int newColumn, int oldRow, int oldColumn, FunkyToken token) {
		if (board[newRow][newColumn] != null) {
			if (board[newRow][newColumn] == board[oldRow][oldColumn]) {
				return;
				// This logic was originally part of the 'if' statement using an &&
				// For some reason, this caused the tokens to take themselves out
			}
			board[newRow][newColumn].tokenLoss(false);
			board[newRow][newColumn] = null;
		}
		board[newRow][newColumn] = token;
		board[oldRow][oldColumn] = null;
	}

	public FunkyToken getWinner() {
		int remainingTokens = 0;
		FunkyToken winningToken = null;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (board[i][j] != null) {
					remainingTokens = remainingTokens + 1;
					winningToken = board[i][j];
				}
			}
		}
		if (remainingTokens > 1) {
			return null;
		} else {
			return winningToken;
		}
	};

}
