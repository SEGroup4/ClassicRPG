package classicRPG;

import java.io.IOException;
import classicRPG.view.IntroScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class GUIMain extends Application {

	private Stage mainStage;
	private Scene intro;
	private Scene overworld;
	private Scene battle;
	private Scene levelUp;
	private Scene credits;
	
	@Override
	public void start(Stage mainStage) {
		this.mainStage = mainStage;
		mainStage.setTitle("Classic RPG");
		startGame();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void startGame() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUIMain.class.getResource("view/IntroScreen.fxml"));
            AnchorPane intro = (AnchorPane) loader.load();

            this.intro = new Scene(intro);
            mainStage.setScene(this.intro);
            mainStage.show();
            IntroScreenController introController = loader.getController();
            introController.setMain(this);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void close() {
		mainStage.close();
	}
	
	public void showOverworld() {
		System.out.println("BUTTS");
	}
	
}
