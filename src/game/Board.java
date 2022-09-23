package game;

import game.Debug;

public class Board {

	private int size = 20;
	private double chance = 15; // percentage outta 100
	
	private int[][] board;
	
	public Board() {
		board = new int[size][size]; // fuck this line specifically
	}
	
	public int[][] generateBoard() {
		for (int y = 0; y <= size - 1; y++) {
			for (int x = 0; x <= size - 1; x++) {
				board[x][y] = (Math.random() <= (chance / 100) ? -1 : 0);
				Debug.log("[" + (board[x][y] == -1 ? "X" : "O") + "]");
			}
			Debug.log("\n");
		}
		
		Debug.logln("\nCompleted mine generation. \nMoving onto calculations...\n");
		
		for (int y = 0; y <= size - 1; y++) {
			for (int x = 0; x <= size - 1; x++) {
				if (board[x][y] == -1) {
					Debug.log("[X]");
				} else {
					Debug.log("[" + checkOuter(x, y) + "]");
					board[x][y] = checkOuter(x, y);
				}
			}
			Debug.log("\n");
		}
		
		return board;
	}
	
	public int[][] initializeBoard() {
		for (int y = 0; y <= size - 1; y++) {
			for (int x = 0; x <= size - 1; x++) {
				board[x][y] = 0;
			}
			Debug.log("\n");
		}
		
		return board;
	}
	
	public int checkOuter(int posx, int posy) {
		int[] offsetx = {-1, 0, 1}, offsety = {-1, 0, 1};
		int numbrnd = 0;
		int[][] boardtmp = new int[size + 2][size + 2];
		
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				boardtmp[x + 1][y + 1] = board[x][y];
			}
		}
		
		for (int i = 0; i < offsetx.length * 3; i++) {
			if (boardtmp[posx - offsetx[i % 3] + 1][posy - offsety[i / 3] + 1] == -1) {
				numbrnd++;
			}
		}
		
		return numbrnd;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getBlockInfo(int x, int y) {
		return board[x][y];
	}
}
