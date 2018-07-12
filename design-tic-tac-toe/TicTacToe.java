public class TicTacToe {
	/** Initialize your data structure here. */
	private int n;
	private int[] rows;
	private int[] cols;
	private int diagonalUlToLr;
	private int diagonalLlToUr;

	public TicTacToe(int n) {
		this.n = n;
		rows = new int[n];
		cols = new int[n];
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row
	 *            The row of the board.
	 * @param col
	 *            The column of the board.
	 * @param player
	 *            The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		int target = (player == 1) ? n : -n;
		int delta = (player == 1) ? 1 : -1;

		rows[row] += delta;
		if (rows[row] == target) {
			return player;
		}

		cols[col] += delta;
		if (cols[col] == target) {
			return player;
		}

		if (row == col) {
			diagonalUlToLr += delta;
			if (diagonalUlToLr == target) {
				return player;
			}
		}

		if (row + col == n - 1) {
			diagonalLlToUr += delta;
			if (diagonalLlToUr == target) {
				return player;
			}
		}

		return 0;
	}
}

// Your TicTacToe object will be instantiated and called as such:
// TicTacToe obj = new TicTacToe(n);
// int param_1 = obj.move(row,col,player);
