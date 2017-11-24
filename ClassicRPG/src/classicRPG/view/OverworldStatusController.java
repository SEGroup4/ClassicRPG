package classicRPG.view;

import classicRPG.GUIMain;
import javafx.fxml.FXML;

public class OverworldStatusController {
	
private GUIMain main;
	
	public void setMain(GUIMain main) {
		this.main = main;
	}
	
	@FXML
	public void handleExit() {
		this.handleSave();
		main.close();
	}
	
	@FXML
	public void handleSave() {
		main.save();
	}
}
