package classicRPG.view;

import classicRPG.GUIMain;
import javafx.fxml.FXML;

public class OverworldController {
	
private GUIMain main;
	
	public void setMain(GUIMain main) {
		this.main = main;
	}
	
	@FXML
	public void handleBattle() {
		main.showBattle();
	}
	@FXML
	public void handleLevelUp() {
		main.showLevelUp();
	}
	@FXML
	public void handleCredits() {
		main.showCredits();
	}
}
