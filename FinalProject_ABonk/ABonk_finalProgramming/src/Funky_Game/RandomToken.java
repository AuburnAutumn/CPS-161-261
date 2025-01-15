package Funky_Game;

public class RandomToken extends FunkyToken {

	public RandomToken(char token) {
		super(token);

	}

	public void move(FunkyBoard board) {
		boolean impossibleMove = true;
		int oldRow;
		int oldColumn;
		if (active == true) {
			while (impossibleMove) {
				oldRow = rowPos;
				oldColumn = columnPos;
				rowPos = (int) (Math.random() * board.getSize());
				columnPos = (int) (Math.random() * board.getSize());
				if (oldRow == rowPos && oldColumn == columnPos) {
					// In the MoveOneToken, this part of the code will reset the token to wherever
					// it was before it moved.
					// I did not include that here because its moves are always entirely random.
				} else {
					impossibleMove = false;
					board.setBoard(rowPos, columnPos, oldRow, oldColumn, this);
				}
			}
		}
	};

}
