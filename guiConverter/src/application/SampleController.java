package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class SampleController {
	@FXML
	private TextField textField1;
	@FXML
	private TextField textField2;
	@FXML
	Label label1;
	@FXML
	Label label2;
	@FXML
	Button calculateButton;
	@FXML
	RadioButton tempButton;
	@FXML
	RadioButton weightButton;
	@FXML
	RadioButton distanceButton;
	
	public void initialize() {
		calculateButton.setDisable(true);
		textField1.setDisable(true);
		textField2.setDisable(true);
	}
	
	@FXML
	public void setLabel() {
		if (tempButton.isSelected()){
			resetText();
			label1.setText("F:");
			label2.setText("C:");
		} else if (distanceButton.isSelected()){
			resetText();
			label1.setText("Mile:");
			label2.setText("KM:");
		} else
		if (weightButton.isSelected()){
			resetText();
			label1.setText("Pounds:");
			label2.setText("KG:");
		}
		calculateButton.setDisable(false);
	}
	
	public void resetText() {
		enableTxtField();
		textField2.setText("");
		textField1.setText("");
	}
	
	public void enableTxtField() {
		textField1.setDisable(false);
		textField2.setDisable(false);
	}
	
	public void calculate() {
		double tempNum;
		
		if (tempButton.isSelected()) {
			if (textField1.getText().isEmpty()) {
				tempNum = Double.valueOf(textField2.getText());
				textField1.setText(String.valueOf(tempNum+9/5+32));
			} else {
				tempNum = Double.valueOf(textField1.getText());
				textField2.setText(String.valueOf((tempNum-32)*5/9));
			}
		} else if (distanceButton.isSelected()) {
			if (textField1.getText().isEmpty()) {
				tempNum = Double.valueOf(textField2.getText());
				textField1.setText(String.valueOf(tempNum/1.609));
			} else {
				tempNum = Double.valueOf(textField1.getText());
				textField2.setText(String.valueOf(tempNum*1.609));
			}
		} else if (weightButton.isSelected()) {
			if (textField1.getText().isEmpty()) {
				tempNum = Double.valueOf(textField2.getText());
				textField1.setText(String.valueOf(tempNum/0.4536));
			} else {
				tempNum = Double.valueOf(textField1.getText());
				textField2.setText(String.valueOf(tempNum*0.4536));
			}
		}
	}
	
	public void clearField(KeyEvent e) {
		if((e.getSource().equals(textField1))) {
			textField2.setText("");
		} else {
			textField1.setText("");
		}
	}
	


}
