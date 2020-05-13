package saber.kuns.application.component;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	private static final String CONFIRM = "";
	private static final String INFO = "";
	private static final String WARN = "";
	private static final String ERROR = "";

	/** 确认框 */
	public static void confirm(String message, EventHandler<DialogEvent> handler) {
		Alert alert = new Alert(AlertType.CONFIRMATION, "", new ButtonType(""));
		alert.setTitle(CONFIRM);
		alert.setHeaderText(message);
	}

	/** 提示框 */
	public static void info(String message, EventHandler<Event> handler) {

	}

	public static void info(String message) {

	}

	/** 警告框 */
	public static void warn(String message, EventHandler<Event> handler) {

	}

	/** 错误框 */
	public static void error(String message) {

	}

	class _Alert {

		String title;

		String message;

		public _Alert(String title, String message) {
			this.title = title;
			this.message = message;
		}

		public void show() {

		}

		public void display(String title, String message) {
			Stage window = new Stage();
			window.setTitle("title");
			// modality要使用Modality.APPLICATION_MODEL
			window.initModality(Modality.APPLICATION_MODAL);
			window.setMinWidth(300);
			window.setMinHeight(150);

			Button button = new Button("Close the window");
			button.setOnAction(e -> window.close());

			Label label = new Label(message);

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, button);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			// 使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
			window.showAndWait();
		}
	}

}