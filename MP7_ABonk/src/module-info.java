module pigFour {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.fxml, javafx.base;
	
	exports application;
	//opens application to javafx.graphics, javafx.fxml;
}
