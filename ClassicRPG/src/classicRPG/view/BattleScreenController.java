package classicRPG.view;

import classicRPG.GUIMain;
import classicRPG.model.TextAreaTester;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BattleScreenController {

	private GUIMain main;
	@FXML
	private TextArea battleText;
	
	@FXML
	private Button fighterAttack; 
	@FXML
	private Button fighterDefend; 
	@FXML
	private Button fighterAbility; 
	@FXML
	private Button fighterItem; 
	@FXML
	private Button rogueAttack; 
	@FXML
	private Button rogueDefend; 
	@FXML
	private Button rogueAbility; 
	@FXML
	private Button rogueItem; 
	@FXML
	private Button mageAttack; 
	@FXML
	private Button mageDefend; 
	@FXML
	private Button mageAbility; 
	@FXML
	private Button mageItem; 
	@FXML
	private Button paladinAttack; 
	@FXML
	private Button paladinDefend; 
	@FXML
	private Button paladinAbility; 
	@FXML
	private Button paladinItem; 
	
	private TextAreaTester tat;
	int turn = 1;
	int choice = 1;
	
	
	public void doBattle() {
		tat = new TextAreaTester();
		tat.setTextArea(battleText);
		battleText.setEditable(false);
		battleText.setText("Battle:\n");
		tat.newBattle();
		while (tat.getEnemyHP() > 0) {
			tat.listEnemies();
			//turn = tat.whoTurn("Fighter");
			tat.turn(turn, choice);
		}

	}
	
	public void handleAttack() {
		choice = 1;

	}
	public void handleGuard() {
		choice = 2;
	}
	public void handleAbility() {
		choice = 3;
	}
	public void handleItem() {
		choice = 4;
	}
	
	public void setMain(GUIMain main) {
		this.main = main;
	}
	
	@FXML
	public void handleBack() {
		main.showOverworld();
	}
	
}
