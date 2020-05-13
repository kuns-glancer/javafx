package saber.kuns.application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class IncluController implements Initializable {

	@FXML
	private Button btn1;

	private DatePicker datePicker;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}


	public void say() {
		System.out.println("child btn clicked");
	}

}
