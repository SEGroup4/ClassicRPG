package classicRPG.view;

import classicRPG.GUIMain;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IntroScreenController {

	private GUIMain main;
	
	@FXML
	private void initialize() {	
	}
	
	@FXML
	public void handleNew() {
		main.showOverworld();
	}
	
	@FXML
	public void handleLoad() {
		
	}
	
	@FXML
	public void handleExit() {
		main.close();
	}
	
	public void setMain(GUIMain main) {
		this.main = main;
	}
}
