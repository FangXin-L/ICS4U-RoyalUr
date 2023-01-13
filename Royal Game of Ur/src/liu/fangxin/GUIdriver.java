package liu.fangxin;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIDriver extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	private final double WIDTH = 400;
	private final double HEIGHT = 800;
	private final int NUM_ROWS = 8;
	private final int NUM_COLS = 3;
	
	private NewButton[][] slots = new NewButton[NUM_ROWS][NUM_COLS];
	
	@Override
	public void start(Stage primaryStage) throws Exception {				
		
		
		GridPane gridPane = new GridPane();		
		Scene mySceneGraph = new Scene(gridPane,750,850);
		gridPane.setAlignment(Pos.CENTER);
		
		// setup slots as NewButton objects
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
					slots[i][j] = new NewButton(i,j);
					slots[i][j].setMinSize(WIDTH/NUM_COLS, HEIGHT/NUM_ROWS);
					slots[i][j].setMaxSize(WIDTH/NUM_COLS, HEIGHT/NUM_ROWS);
					slots[i][j].setText(slots[i][j].toString());
					slots[i][j].setOnAction(e ->{
						System.out.println( ((NewButton) e.getSource()).getText() );
						((NewButton) e.getSource()).setStyle("-fx-background-color: Red");
					});
			}
		}
		
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				gridPane.add(slots[i][j], j,i+1);
			}
		}
		primaryStage.setScene(mySceneGraph);
		primaryStage.show();		
	}
}