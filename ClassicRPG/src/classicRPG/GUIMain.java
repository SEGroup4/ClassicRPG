package classicRPG;

import java.io.IOException;
import javafx.util.Duration;

import classicRPG.view.BattleScreenController;
import classicRPG.view.CreditsController;
import classicRPG.view.IntroScreenController;
import classicRPG.view.LevelUpController;
import classicRPG.view.OverworldController;
import classicRPG.view.OverworldStatusController;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class GUIMain extends Application {

	private Stage mainStage;
	private Scene intro;
	private Scene overworldCombiner;
	private Node overworldStatus;
	private Node overworld;
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
	
	public void fadeIn() {
		FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), mainStage.getScene().getRoot());
		fadeIn.setFromValue(0.0);
		fadeIn.setToValue(1.0);
		fadeIn.play();
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
            
            fadeIn();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void save() {
		
	}
	public void close() {
		mainStage.close();
	}
	
	public void showOverworld() {
		try {
			FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(GUIMain.class.getResource("view/OverworldStatus.fxml"));
            AnchorPane overworldStatus = (AnchorPane) loader1.load();
            this.overworldStatus = overworldStatus;
            
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(GUIMain.class.getResource("view/Overworld.fxml"));
            AnchorPane overworld = (AnchorPane) loader2.load();
            this.overworld = overworld;
            
            FXMLLoader loader3 = new FXMLLoader();
            loader3.setLocation(GUIMain.class.getResource("view/OverworldCombiner.fxml"));
            BorderPane overworldCombiner = (BorderPane) loader3.load();
            this.overworldCombiner = new Scene(overworldCombiner);
            overworldCombiner.setTop(this.overworldStatus);
            overworldCombiner.setCenter(this.overworld);
            
            mainStage.setScene(this.overworldCombiner);
            mainStage.getScene().getRoot().setOpacity(0);
            mainStage.show();
            OverworldStatusController overworldStatusController = loader1.getController();
            overworldStatusController.setMain(this);

            OverworldController overworldController = loader2.getController();
            overworldController.setMain(this);
            
            fadeIn();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showBattle() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUIMain.class.getResource("view/BattleScreen.fxml"));
            AnchorPane battle = (AnchorPane) loader.load();

            this.battle = new Scene(battle);
            mainStage.setScene(this.battle);
            mainStage.show();
            BattleScreenController battleController = loader.getController();
            battleController.setMain(this);

            fadeIn();
            battleController.doBattle();
		} 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showLevelUp() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUIMain.class.getResource("view/LevelUp.fxml"));
            AnchorPane levelUp = (AnchorPane) loader.load();

            this.levelUp = new Scene(levelUp);
            mainStage.setScene(this.levelUp);
            mainStage.show();
            LevelUpController levelUpController = loader.getController();
            levelUpController.setMain(this);
            
            fadeIn();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showCredits() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUIMain.class.getResource("view/Credits.fxml"));
            AnchorPane credits = (AnchorPane) loader.load();

            this.credits = new Scene(credits);
            mainStage.setScene(this.credits);
            mainStage.show();
            CreditsController creditsController = loader.getController();
            creditsController.setMain(this);
            
            fadeIn();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
