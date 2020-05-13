package saber.kuns.application.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import saber.kuns.application.MainApp;
import saber.kuns.util.FXMLUtil;

public class MainController implements Initializable {

	private MainApp application;

	@FXML
	private AnchorPane content;

	@FXML
	private Button viewBtn;

	@FXML
	private Button addBtn;

	@FXML
	private Button dictAddBtn;

	@FXML
	AccomodationAddController accomodationAddController;

	public MainApp getApplication() {
		return application;
	}

	public void setApplication(MainApp application) {
		this.application = application;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void viewList() {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = getClass().getClassLoader().getResourceAsStream("saber/kuns/application/fxmls/ListView.fxml");
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(getClass().getClassLoader().getResource("saber/kuns/application/fxmls/ListView.fxml"));
		// ResourceBundle rb =
		// ResourceBundle.getBundle("messages"+"_"+Global.localepre+"_"+Global.localesuf,
		// Global.locale);//引入国际化资源
		// loader.setResources(rb);
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
			content.getChildren().clear();
			content.getChildren().add(page);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void addAccodationPage() throws IOException {
		AnchorPane anchorPane = FXMLUtil.getInitializeByFxml("saber/kuns/application/fxmls/AccomodationAdd.fxml",
				AnchorPane.class);
		content.getChildren().clear();
		content.getChildren().add(anchorPane);
	}

	public void dictAddPage() throws IOException {
		AnchorPane anchorPane = FXMLUtil.getInitializeByFxml("saber/kuns/application/fxmls/DictAdd.fxml",
				AnchorPane.class);
		content.getChildren().clear();
		content.getChildren().add(anchorPane);
	}

}
