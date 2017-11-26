package classicRPG.view;

import classicRPG.GUIMain;
import javafx.fxml.FXML;

public class CreditsController {

	private GUIMain main;
	
	public void setMain(GUIMain main) {
		this.main = main;
	}
	
	@FXML
	public void handleStartOver() {
		main.startGame();
	}
	
	@FXML
	public void handleExit() {
		main.close();
	}
}
