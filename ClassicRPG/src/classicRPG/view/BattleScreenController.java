package classicRPG.view;

import classicRPG.GUIMain;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BattleScreenController {

	private GUIMain main;
	@FXML
	private TextArea battleText;

	
	public void setMain(GUIMain main) {
		this.main = main;
	}
	
	@FXML
	public void handleBack() {
		main.showOverworld();
	}
	
}
