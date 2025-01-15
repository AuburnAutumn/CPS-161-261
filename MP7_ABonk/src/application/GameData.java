package application;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameData implements Serializable {

	String name;
	LocalDateTime date;
	String savedDate;
	int Score;
	String savedScore;
	String winOrLoss;

	public GameData(String name, int score, String winOrLoss) {
		super();
		this.name = name;
		this.date = LocalDateTime.now();
		Score = score;
		this.winOrLoss = winOrLoss;
	}

	public GameData(String name, String date, String score, String winOrLoss) {
		super();
		this.name = name;
		this.savedDate = date;
		this.savedScore = score;
		this.winOrLoss = winOrLoss;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public String getWinOrLoss() {
		return winOrLoss;
	}

	public void setWinOrLoss(String winOrLoss) {
		this.winOrLoss = winOrLoss;
	}

	public String getSavedDate() {
		return savedDate;
	}

	public void setSavedDate(String savedDate) {
		this.savedDate = savedDate;
	}

	public String getSavedScore() {
		return savedScore;
	}

	public void setSavedScore(String savedScore) {
		this.savedScore = savedScore;
	}

	public String dateToString(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateString = date.format(formatter);
		return dateString;
	}

	@Override
	public String toString() {
		return "GameData [name=" + name + ", date=" + date + ", Score=" + Score + ", winOrLoss=" + winOrLoss
				+ "] Saved date: " + savedDate + " Saved score: " + savedScore;
	}

}
