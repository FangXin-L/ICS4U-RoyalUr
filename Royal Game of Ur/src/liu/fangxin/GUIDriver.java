package liu.fangxin;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import liu.fangxin.NewButton;

public class GUIDriver extends Application {
	

	private static final Pos TOP_LEFT = null;

	private static final Pos TOP_RIGHT = null;
	
	private final int NUM_ROWS = 3;
	private final int NUM_COLS = 8;
	
	private NewButton[][] btn = new NewButton[NUM_ROWS][NUM_COLS];
	
	@Override
	public void start(Stage primaryStage) throws Exception {	
		

		 // create stackpane for image
		StackPane sp = new StackPane();
		
		// create gridpane for buttons
	      GridPane gridPane = new GridPane();    
	      gridPane.setMinSize(500, 900); 
	      gridPane.setPadding(new Insets(0, 0, 0, 0)); 
	      gridPane.setVgap(20); 
	      gridPane.setHgap(20);   
	      gridPane.setAlignment(Pos.CENTER);

	      
			//add background board
			Image image = new Image("File:Images/UrBoard.jpg");
			ImageView imageView = new ImageView(image);
			sp.getChildren().add(imageView);
		   
			// tiles remaining test
			HBox player1 = new HBox();
			Text tilesRemain1 = new Text("Tiles Remaining");
			tilesRemain1.setFill(Color.WHITE);
			tilesRemain1.setFont(Font.font("Arial", FontWeight.BOLD, 35));
			player1.getChildren().addAll(tilesRemain1);
			
			player1.setAlignment(Pos.TOP_LEFT);
			
			HBox player2 = new HBox();
			Text tilesRemain2 = new Text("Tiles Remaining");
			tilesRemain2.setFill(Color.WHITE);
			tilesRemain2.setFont(Font.font("Arial", FontWeight.BOLD, 35));
			player2.getChildren().addAll(tilesRemain2);
			
			player2.setAlignment(Pos.TOP_RIGHT);
			
			Image score1 = new Image("File:Images/UrBoard.jpg");
			ImageView score1V = new ImageView(score1);
			
			sp.getChildren().addAll(player1,player2);
			
			
		 //r = row | c = collumn
		// make grid of buttons
		for(int r=0; r < NUM_ROWS; r++){
			for(int c=0; c < NUM_COLS; c++){			
	            Button btn = new Button();   
	            btn.setMinWidth(75);
	            btn.setMinHeight(75);
	            btn.setText("Button" + "["+r+"]"+"["+c+"]");    
	            btn.setOpacity(0);
	            btn.setOnAction(e ->{
					System.out.println( ((Button) e.getSource()).getText() );
					((Button) e.getSource()).setOpacity(100);
					
					 
				});
	            gridPane.add(btn, r, c);
			}
	            
		 }

		



		

	    sp.getChildren().add(gridPane);
	    
	    Scene scene = new Scene(sp);  
	    
	    primaryStage.setScene(scene);
		primaryStage.show();
		
		}
		
        
		
	
private Node btn(String string) {
		// TODO Auto-generated method stub
		return null;
	}




public static void main(String[] args) {
	launch(args);
}
}