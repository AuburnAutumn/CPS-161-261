package Funky_Game;

public abstract class FunkyToken {

	public char token;
	public int rowPos;
	public int columnPos;
	public boolean active;

	public abstract void move(FunkyBoard board);

	public FunkyToken(char token) {
		super();
		this.token = token;
		this.active = true;

	}

	public void setRowPos(int rowPos) {
		this.rowPos = rowPos;
	}

	public void setColumnPos(int columnPos) {
		this.columnPos = columnPos;
	}

	public char getToken() {
		return token;
	}

	public char getWinner(FunkyBoard board) {
		// Placeholder
		// Scan board to see if there are any tokens left
		return 'f';
	}

	public void tokenLoss(boolean active) {
		this.active = false;
		this.rowPos = -1;
		this.columnPos = -1;
	}

	public boolean isActive() {
		return active;
	}

}
