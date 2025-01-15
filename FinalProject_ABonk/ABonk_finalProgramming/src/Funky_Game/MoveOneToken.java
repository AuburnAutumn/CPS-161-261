package Funky_Game;

public class MoveOneToken extends FunkyToken {

	public MoveOneToken(char token) {
		super(token);

	}

	public void move(FunkyBoard board) {
		boolean impossibleMove = true;
		if (active == true) {
			int oldRow;
			int oldColumn;
			oldRow = rowPos;
			oldColumn = columnPos;
			while (impossibleMove) {
				rowPos = rowPos + ((int) ((Math.random() * 3)) - 1);
				columnPos = columnPos + ((int) ((Math.random() * 3)) - 1);

				if (rowPos > (board.getSize() - 1) || columnPos > (board.getSize() - 1) || rowPos < 0
						|| columnPos < 0) {
					rowPos = oldRow;
					columnPos = oldColumn;
				} else if (oldColumn == columnPos && oldRow == rowPos) {
					rowPos = oldRow;
					columnPos = oldColumn;
				} else {
					impossibleMove = false;
					board.setBoard(rowPos, columnPos, oldRow, oldColumn, this);
				}
			}
		}

	}
}
