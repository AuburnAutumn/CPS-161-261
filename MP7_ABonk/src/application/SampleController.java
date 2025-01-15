package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SampleController {

	@FXML
	private Button newGameButton;
	@FXML
	private Button historyButton;
	@FXML
	private Text titleText;
	@FXML
	private Button forfeitButton;

	public void Initialize() {
	}

	// MAIN MENU METHODS

	public void newGameStart(MouseEvent e) {
		try {
			BorderPane gamePlay = (BorderPane) FXMLLoader.load(getClass().getResource("gamePlay.fxml"));
			Scene gamePlayScene = new Scene(gamePlay);

			Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
			window.setScene(gamePlayScene);
			window.show();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void displayHistory(MouseEvent e) {
		try {
			VBox historyDisplay = (VBox) FXMLLoader.load(getClass().getResource("History.fxml"));
			Scene historyDisplayScene = new Scene(historyDisplay);

			Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
			window.setScene(historyDisplayScene);
			window.show();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
