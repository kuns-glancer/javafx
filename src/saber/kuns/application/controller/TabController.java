package saber.kuns.application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabController implements Initializable {

	@FXML
	private Button btn;

	@FXML
	private TabPane tabPane;

	@FXML
	private Tab abc;

	@FXML
	private IncluController abcController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(abc);
		System.out.println(abcController);

	}

	public void addTab() {

	}

}
