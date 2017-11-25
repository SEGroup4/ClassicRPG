package classicRPG.view;

import classicRPG.GUIMain;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LevelUpController {

	private GUIMain main;

	@FXML
	private Label warHPNew;
	@FXML
	private Label warStrNew;
	@FXML
	private Label warMagNew;
	@FXML
	private Label warSpNew;
	@FXML
	private Label warHPOld;
	@FXML
	private Label warStrOld;
	@FXML
	private Label warMagOld;
	@FXML
	private Label warSpOld;
	@FXML
	private Label magHPNew;
	@FXML
	private Label magStrNew;
	@FXML
	private Label magMagNew;
	@FXML
	private Label magSpNew;
	@FXML
	private Label magHPOld;
	@FXML
	private Label magStrOld;
	@FXML
	private Label magMagOld;
	@FXML
	private Label magSpOld;
	@FXML
	private Label thiHPNew;
	@FXML
	private Label thiStrNew;
	@FXML
	private Label thiMagNew;
	@FXML
	private Label thiSpNew;
	@FXML
	private Label thiHPOld;
	@FXML
	private Label thiStrOld;
	@FXML
	private Label thiMagOld;
	@FXML
	private Label thiSpOld;
	@FXML
	private Label palHPNew;
	@FXML
	private Label palStrNew;
	@FXML
	private Label palMagNew;
	@FXML
	private Label palSpNew;
	@FXML
	private Label palHPOld;
	@FXML
	private Label palStrOld;
	@FXML
	private Label palMagOld;
	@FXML
	private Label palSpOld;
	
	public void setMain(GUIMain main) {
		this.main = main;
	}
	
	@FXML
	public void handleNextLevel() {
		//IMPORTANT: put in next level with new stats.
		main.showOverworld();
	}
}
