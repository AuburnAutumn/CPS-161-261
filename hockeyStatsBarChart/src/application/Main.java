package application;
	
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXMLLoader;


class HockeyData{
	String teamName;
	double data;
	public HockeyData(String teamName, double data) {
		this.teamName = teamName;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "HockeyData: Team name:" + teamName + " , data: " + data;
	}
}

public class Main extends Application {
	ArrayList<HockeyData> stats = new ArrayList<>();
	double maxScore;
	
	public void fillArrayList() {
		Scanner fis = null;
		String str;
		String[] temp;
		String teamName;
		double data;
		try {
			fis = new Scanner(new FileInputStream("hockeyStats.txt"));
			while(fis.hasNextLine()) {
				str = fis.nextLine();
				temp = str.split(",");
				teamName = temp[0];
				data = Double.valueOf(temp[1]);
				stats.add(new HockeyData(teamName, data));
				System.out.println(teamName);
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
		}
		for (HockeyData hockeyData : stats) {
			if (hockeyData.data > maxScore) {
				maxScore = hockeyData.data;
			}
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.setVgap(20);
		fillArrayList();
		int rowNumb = stats.size();
		
		for (int i = 0; i< rowNumb; i++) {
			Rectangle rectangle = new Rectangle();
			rectangle.heightProperty().bind(pane.heightProperty().divide(rowNumb).subtract(20));
			rectangle.setFill(Color.CORNFLOWERBLUE);
			rectangle.widthProperty().bind(pane.widthProperty().subtract(100).multiply(stats.get(i).data/maxScore));
			pane.add(new Label(stats.get(i).teamName), 0, i);
			pane.add(rectangle, 1, i);
		}
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
