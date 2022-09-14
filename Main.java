package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static Stage primaryStage;
	@Override
	public void start(Stage stage) {
		try {
			primaryStage = stage;
			Parent root = FXMLLoader.load(getClass().getResource("Canvas.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Demo Dolphin Technology VN Center");
			primaryStage.setFullScreen(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
