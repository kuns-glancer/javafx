package saber.kuns.application;

import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import saber.kuns.application.controller.LoginController;
import saber.kuns.application.controller.MainController;

public class MainApp extends Application {

	private Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("FXML Login Sample");
		//stage.setMinWidth(1000);
		//stage.setMinHeight(720);
		gotoLogin();
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = getClass().getClassLoader().getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(getClass().getClassLoader().getResource(fxml));
		// ResourceBundle rb =
		// ResourceBundle.getBundle("messages"+"_"+Global.localepre+"_"+Global.localesuf,
		// Global.locale);//引入国际化资源
		// loader.setResources(rb);
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page);
		// scene.getStylesheets()
		// .add(getClass().getClassLoader().getResource("static/css/mainapp/main.css").toExternalForm());
		stage.setScene(scene);
		stage.setResizable(false);
		return (Initializable) loader.getController();
	}

	public void gotoMain() {
		try {
			MainController main = (MainController) replaceSceneContent("saber/kuns/application/fxmls/MainApp.fxml");
			main.setApplication(this);
		} catch (Exception ex) {
			// Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void gotoLogin() throws Exception {
		LoginController loginController = (LoginController) replaceSceneContent(
				"saber/kuns/application/fxmls/Login.fxml");
		loginController.setApplication(this);
	}

}
