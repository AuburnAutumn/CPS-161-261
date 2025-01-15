package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HistoryController {

	@FXML
	private Button returnToMenuButton;
	@FXML
	private TableView<GameData> historyDisplay;
	@FXML
	private TableColumn<GameData, String> nameColumn;
	@FXML
	private TableColumn<GameData, String> scoreColumn;
	@FXML
	private TableColumn<GameData, String> dateColumn;
	@FXML
	private TableColumn<GameData, String> resultColumn;
	@FXML
	private TextArea winCountDisplay;

	public void initialize() {
		ObservableList<GameData> data = FXCollections.observableArrayList(createList());
		nameColumn.setCellValueFactory(new PropertyValueFactory<GameData, String>("name"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<GameData, String>("savedScore"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<GameData, String>("savedDate"));
		resultColumn.setCellValueFactory(new PropertyValueFactory<GameData, String>("winOrLoss"));

		historyDisplay.setItems(data);

	}

	public void returnToMenuButtonPressed(MouseEvent e) {
		try {
			GridPane scene = (GridPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene MenuScene = new Scene(scene);
			Stage window = (Stage) returnToMenuButton.getScene().getWindow();
			window.setScene(MenuScene);
			window.show();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public List<GameData> createList() {
		List<GameData> dataList = new ArrayList<>();
		BufferedReader fis = null;
		try {
			fis = new BufferedReader(new FileReader("gameDataLog.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String nextLine;

		try {
			while ((nextLine = fis.readLine()) != null) {
				String[] words = nextLine.split(",");
				GameData readData = null;
				for (String word : words) {
					readData = new GameData(words[0], words[1], words[2], words[3]);
				}
				dataList.add(readData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Integer> occurrences = new HashMap<>();
		for (GameData data : dataList) {
			String name = data.getName();
			String winOrLoss = data.getWinOrLoss();
			if (winOrLoss.equals("win")) {
				occurrences.put(name, occurrences.getOrDefault(name, 0) + 1);
			}
		}
		for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
			winCountDisplay.appendText(entry.getKey() + " has " + entry.getValue() + " wins\n");
		}
		return dataList;
	}

}
