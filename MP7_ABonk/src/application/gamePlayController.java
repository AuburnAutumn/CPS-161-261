package application;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class gamePlayController {
	@FXML
	private Button forfeitButton;
	@FXML
	private Button nameSelectButton;
	@FXML
	private TextField nameBox;
	@FXML
	private Label playerNameLabel;
	@FXML
	private Button rollAgainButton;
	@FXML
	private Button takeScoreButton;
	@FXML
	private Label infoText;
	@FXML
	private Label cpuCurrentText;
	@FXML
	private Label cpuTotalText;
	@FXML
	private Label playerCurrentText;
	@FXML
	private Label playerTotalText;
	@FXML
	private ImageView playerDice;
	@FXML
	private ImageView cpuDice;

	private String name;
	private String filePath = "file:///E:/Java/MP7_ABonk/dicePics/";

	private int playerTotal = 0;
	private int playerCurrent = 0;
	private int computerTotal = 0;
	private int computerCurrent = 0;

	public void initialize() {
		rollAgainButton.setDisable(true);
		forfeitButton.setDisable(true);
		takeScoreButton.setDisable(true);
		nameBox.setDisable(false);
		nameSelectButton.setDisable(false);

	}

	public void inputNameClicked(MouseEvent e) {
		if (nameBox.getText().equals("")) {
			System.out.println("No name input");
		} else {
			name = nameBox.getText();
			playerNameLabel.setText(name + ":");
			nameBox.setDisable(true);
			nameSelectButton.setDisable(true);
			Random random = new Random();
			if (random.nextInt(2) == 0) {
				computerTurn();
			} else {
				playerTurn();
			}

		}
	}

	public void computerTurn() {
		rollAgainButton.setDisable(true);
		forfeitButton.setDisable(true);
		takeScoreButton.setDisable(true);
		infoText.setText("Computer's turn");
		Random cpuRollAgain = new Random();
		int lastRoll = rollDice(2);
		int rollAgain;
		while (lastRoll != 0) {
			lastRoll = rollDice(2);
			if (lastRoll == 1) {
				infoText.setText("Computer rolled a 1! 0 added to score this turn!");
				computerCurrent = 0;
				cpuCurrentText.setText("Current: " + computerCurrent);
				playerTurn();
				break;
			} else {
				computerCurrent = computerCurrent + lastRoll;
				rollAgain = cpuRollAgain.nextInt(1);
				if (rollAgain == 1) {
					cpuCurrentText.setText("Current: " + computerCurrent);
					continue;
				} else {
					computerTotal = computerTotal + computerCurrent;
					cpuTotalText.setText("Total: " + computerTotal);
					infoText.setText("Computer adds " + computerCurrent + " to its score this turn");
					computerCurrent = 0;
					if (checkWin(computerTotal)) {
						infoText.setText("CPU wins!");
						GameData game = new GameData(name, playerTotal, "loss");
						writeGame(game);
						returnToMenu();
						break;
					} else {
						playerTurn();
						break;
					}
				}
			}
		}
	}

	public void playerTurn() {
		rollAgainButton.setDisable(false);
		forfeitButton.setDisable(false);
		takeScoreButton.setDisable(false);
	}

	public void rollAgainButtonPressed(MouseEvent e) {
		int lastRoll = rollDice(1);
		if (lastRoll == 1) {
			infoText.setText("Oh no! " + name + " rolled a 1!");
			playerCurrentText.setText("Current: 0");
			playerCurrent = 0;
			computerTurn();
		} else {
			infoText.setText(name + " rolled a " + lastRoll + "!");
			playerCurrent = playerCurrent + lastRoll;
			playerCurrentText.setText("Current: " + playerCurrent);
		}
	}

	public void takeScoreButtonPressed(MouseEvent e) {
		infoText.setText(name + " takes " + playerCurrent + "!");
		playerTotal = playerTotal + playerCurrent;
		playerCurrent = 0;
		playerCurrentText.setText("Current: 0");
		playerTotalText.setText("Total: " + playerTotal);
		if (checkWin(playerTotal)) {
			infoText.setText(name + " wins!");
			GameData game = new GameData(name, playerTotal, "win");
			writeGame(game);
			returnToMenu();
		} else {
			computerTurn();
		}
	}

	public void foreitButtonPressed(MouseEvent e) {
		GameData game = new GameData(name, playerTotal, "loss");
		writeGame(game);
		returnToMenu();
	}

	public int rollDice(int turn) {
		int numRolled;
		Random random = new Random();
		numRolled = random.nextInt(6) + 1;
		if (turn == 1) {
			playerDice.setImage(new Image(filePath + numRolled + ".png"));
		} else if (turn == 2) {
			cpuDice.setImage(new Image(filePath + numRolled + ".png"));
		}
		return numRolled;

	}

	public boolean checkWin(int score) {
		if (score >= 100) {
			return true;
		} else {
			return false;
		}
	}

	public void returnToMenu() {
		try {
			GridPane scene = (GridPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene MenuScene = new Scene(scene);

			Stage window = (Stage) infoText.getScene().getWindow();
			window.setScene(MenuScene);
			window.show();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void writeGame(GameData game) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("gameDataLog.txt", true))) {
			writer.write(game.getName() + "," + game.dateToString(game.getDate()) + "," + game.getScore() + ","
					+ game.getWinOrLoss());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
