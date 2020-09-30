package application;

import org.w3c.dom.css.Rect;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid {

	Cell[][] grid;
	private int rows, columns;

	public Grid() {

	}

	public Grid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;

		this.grid = new Cell[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				// what is this?
				Cell cell = new Cell();
//				cell.setAlive(false);
				this.grid[i][j] = cell;
			}
		}


	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	// this is how to show the retangles.

	public void printGrid(GridPane panel) {
//		for (int r = 0; r < rows; r++) {
//			for (int c = 0; c < columns; c++) {
//				Rectangle rect = new Rectangle(c, r, 10, 10);// getRectangle(panel, i, j);
//				if (grid[r][c].isAlive()) {
//					rect.setFill(Color.AQUA);
//				} else {
//					rect.setFill(Color.BLACK);
//				}
//				panel.add(rect, c, r);
//				// System.out.print(this.grid[i][j] + " ");
//			}
//			// System.out.println("");
//		}
		 for (int r = 0; r < rows; r++) {
	            for (int c = 0; c < columns; c++) {
	                Rectangle rect = new Rectangle(c, r, 10, 10);
	                rect.setOnMouseClicked(e->{
	                    rect.setFill(Color.AQUA);    
	                    this.grid[(int) rect.getY()][(int) rect.getX()].setAlive(true);
	                });
	                if (grid[r][c].isAlive()) {
	                    rect.setFill(Color.AQUA);
	                } else {
	                    rect.setFill(Color.BLACK);
	                }
	                panel.add(rect, c, r);
	            }
	        }

	 

	    }

	

	private Rectangle getRectangle(GridPane panel, int r, int c) {
//		
//		Rectangle rec = new Rectangle();
//		rec.setHeight(10);
//		rec.setWidth(10);
//		rec.setX(i);
//		rec.setY(j);
		for (Node node : panel.getChildren()) {
			if (node instanceof Rectangle) {
				Rectangle rect = (Rectangle) node;
				if (rect.getX() == c && rect.getY() == r)
					return rect;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	// This method runs the game and update the board
	public void runGame(GridPane panel) {
		Cell[][] nextGrid = new Cell[rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {

				Rectangle t = getRectangle(panel, r, c);
				if (t == null) {
					System.out.println("Null rectangle ....");
					return;
				}

//				
//				
//					if(this.grid[r][c].isAlive())
//					{
//						this.grid[r][c].setAlive(false);
//						t.setFill(Color.BLACK);
//					}
//					else
//					{
//						this.grid[r][c].setAlive(true);
//						t.setFill(Color.AQUA);
//					}
//				

				int liveNeighbours = liveNeighbours(r, c);
//				if(r==4 && c==4)
//					System.out.println("XXXXXXXX");
				// System.out.print(String.valueOf(this.grid[r][c].isAlive()) + liveNeighbours +
				// " ");
//				//System.out.println("["+r+","+c+"] = " + liveNeighbours);

//				if (grid[r][c].isAlive() && (liveNeighbours == 2 || liveNeighbours == 3)) {
//					grid[r][c].setAlive(true);
//					t.setFill(Color.AQUA);
//				} 
//				
//				if (!grid[r][c].isAlive() && liveNeighbours == 3) {
//					grid[r][c].setAlive(true);
//					t.setFill(Color.AQUA);
//				} 

				if (grid[r][c].isAlive() && liveNeighbours < 2) {
					 nextGrid[r][c] = new Cell(false);
//					grid[r][c].setAlive(false);
//					t.setFill(Color.BLACK);
				} else if (grid[r][c].isAlive() && (liveNeighbours == 2 || liveNeighbours == 3)) {
					 nextGrid[r][c] = new Cell(true);
//					grid[r][c].setAlive(true);
//					t.setFill(Color.AQUA);
				} else if (grid[r][c].isAlive() && liveNeighbours > 3) {
					nextGrid[r][c] = new Cell(false);
//					grid[r][c].setAlive(false);
//					t.setFill(Color.BLACK);
				} else if (!grid[r][c].isAlive() && liveNeighbours == 3) {
					nextGrid[r][c] = new Cell(true);
//					grid[r][c].setAlive(true);
//					t.setFill(Color.AQUA);
				} else {
					nextGrid[r][c] = grid[r][c];
				}

//				else {
//					grid[r][c].setAlive(false);
//					t.setFill(Color.BLACK);
//				}

//				else if(grid[r][c].isAlive() && (liveNeighbours == 1 || liveNeighbours == 4 || 
//						liveNeighbours == 5 || liveNeighbours == 6 || liveNeighbours == 7 || liveNeighbours == 8)) {
////					grid[r][c].setAlive(false);
//					t.setFill(Color.BLACK);
////					panel.add(t,  r,  c);
//				}

			}
			// System.out.println("");

		}
		grid = nextGrid;
		panel.getChildren().clear();
		printGrid(panel);
	}

	public int liveNeighbours(int r, int c) {
		int liveCells = 0;

		if (getCellStatus(r - 1, c + 1, grid)) {
			liveCells += 1;
		}
		if (getCellStatus(r, c + 1, grid)) {
			liveCells += 1;
		}
		if (getCellStatus(r + 1, c + 1, grid)) {
			liveCells += 1;
		}
		if (getCellStatus(r + 1, c, grid)) {
			liveCells += 1;
		}
		if (getCellStatus(r + 1, c - 1, grid)) {
			liveCells += 1;
		}
		if (getCellStatus(r, c - 1, grid)) {
			liveCells += 1;
		}
		if (getCellStatus(r - 1, c - 1, grid)) {
			liveCells += 1;
		}
		if (getCellStatus(r - 1, c, grid)) {
			liveCells += 1;
		}
		return liveCells;
	}

	public boolean getCellStatus(int r, int c, Cell[][] grid) {
		if (r >= rows || r < 0) {
			return false;
		}
		if (c >= columns || c < 0) {
			return false;
		}

		return grid[r][c].isAlive();

	}
//	public int countN(MyCell[x][y]) {//must take x and y
//	
//		
//		int sum = 0;
//		for(int i = -1; i<2; i++) {
//			for(int j = -1; j<2; j++) {
//				sum += grid[i][j];
//				
//			}
//		}
//		sum -=  //grid[x][y];
//		return sum;
//	}

//	public void checkNeighbours() {
//		MyCell c = new MyCell();
//	
//this.grid = new MyCell[rows][columns];
//		
//		for(int i =0; i<rows; i++)
//		{
//			for(int j =0; j<columns; j++)
//			{
//		
//		int sum = 0;
//		int neighbours = count(grid, i, j);//int is number of MyCell
//		
//		c.isAlive() = grid
//		
//		if(state == 0 && neighbours ==3) {
//		next[i][j] = 1;//set to true
//			
//		}else if(state == 1 && (neighbours == <2 || neightbours == > 3 )) {
//			next[]
//		}
//	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

}
