package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	private GridPane grid;
	boolean flag = false;
	Group viewGroup = new Group();
	Grid g = new Grid(5, 5);

	private int rows = 300;// later make this infinite
	private int cols = 300;// grid.getColumnCount();
	private static final int CELLSIZE = 10;

	// private int[][] theGrid;

	private Color defaultColor;

	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane border = new BorderPane();

		HBox hbox = addHBox();

		border.setTop(hbox);

		this.grid = addGridPane();
		border.setCenter(grid);

		Scene scene = new Scene(border, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

//		 g.printGrid(this.grid);
//		   g.runGame(this.grid);
		//drawGrid();
		g.printGrid(this.grid);
	}

	// private static final int GRIDSIZE = 300;

	public void drawGrid() {
		//Grid g = new Grid(5, 6);

		//g.printGrid(this.grid);
//   g.runGame(this.grid);

	}
	public void runGame() {
		//Grid g = new Grid(5, 6);
		g.runGame(grid);		
	}

	public HBox addHBox() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #336699;");

		// Stage btnStart = new Button("Start");
		Button btnStart = new Button("Start");
		btnStart.setPrefSize(100, 20);
		btnStart.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> start(btnStart));

		Button btnNext = new Button("Next");
		btnNext.setPrefSize(100, 20);
		btnNext.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Next());
//
//		Button btnReset = new Button("Reset");
//		btnReset.setPrefSize(100, 20);
//		btnReset.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> reset());

		hbox.getChildren().addAll(btnStart, btnNext);
		return hbox;
	}

	public GridPane addGridPane() {
		GridPane grid = new GridPane();
		grid.setStyle("-fx-background-color: #999999;");
		grid.setHgap(1);
		grid.setVgap(1);
		grid.setPadding(new Insets(0, 0, 0, 0));
		//grid.add();

		return grid;
	}

	private void start(Button btnStart) {
		this.flag = !this.flag;
		if (flag)
			btnStart.setText("Stop Moving");
		else
			btnStart.setText("Start Moving");
	}
	public void Next() {
		
		this.runGame();
		// g.printGrid(grid);
		// TODO Auto-generated method stub
		// drawGrid();

	}

//   //call this method? 
//	public void printGrid(GridPane panel) {
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < columns; j++) {
//				
//				Rectangle r = getRectangle(panel, i, j);
//				if(grid[i][j].isAlive())
//					r.setFill(Color.red);
//				else
//					r.setFill(Color.black);
//				
//				
//				
//				System.out.print(this.grid[i][j] + " ");
//			}
//			System.out.println("");
//		}
//
//	}

//	private void draw() {
//		
//		
//		
//		
//		
//		//System.out.println("DRAW");
//		// TODO Auto-generated method stub
//		for (int r = 0; r < g.getRows(); r++) {
//			for (int c = 0 ; c < g.getColumns(); c++) {
//				Rectangle rect = new Rectangle(r, c, CELLSIZE, CELLSIZE);
//				this.grid.add(rect, r, c);
//			}
//		}
//	}

	public static void main(String[] args) {
		launch(args);
		// TODO Auto-generated method stub

//		Grid g = new Grid(4, 5);
//		g.printGrid();
//
//		System.out.println("===========================");
//
//		//g.getGrid()[0][0].setAlive(!g.getGrid()[0][0].isAlive());
//		
//		g.runGame();
//
//		g.printGrid();
//
//	}
	}
}

// TODO Auto-generated method stub

//		Grid g = new Grid(4, 5);
//		MyCell c = new MyCell();
//		c.setAlive(true);
//		Rectangle r = new Rectangle(10, 10);
//		r.setFill(Color.AZURE);
//		//c = (Rectangle)c;
//		
//		
//		
//		
//		
//		g.printGrid();
//		
//		System.out.println("===========================");
//		
//		g.getGrid()[0][0].setAlive(!g.getGrid()[0][0].isAlive());
//		
//		g.printGrid();
//
//	}
//
//}
//
