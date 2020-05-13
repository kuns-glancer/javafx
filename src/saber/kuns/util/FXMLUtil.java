package saber.kuns.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;

public class FXMLUtil {


	public static <T> T getInitializeByFxml(String fxmlPath, Class<T> clz) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = FXMLUtil.class.getClassLoader().getResourceAsStream(fxmlPath);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(FXMLUtil.class.getClassLoader().getResource(fxmlPath));
		return loader.load(in);
	}

	public static <T> T getInitializeByFxml(String fxmlPath, String resource, Class<T> clz) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = FXMLUtil.class.getClassLoader().getResourceAsStream(fxmlPath);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(FXMLUtil.class.getClassLoader().getResource(fxmlPath));
		ResourceBundle rb = ResourceBundle.getBundle(resource);// 引入国际化资源
		loader.setResources(rb);
		return loader.load(in);

	}

	public static Map<String, Object> getControllerAndInitialize(String fxmlPath) throws IOException {
		Map<String, Object> map = new HashMap<>();
		FXMLLoader loader = new FXMLLoader();
		InputStream in = FXMLUtil.class.getClassLoader().getResourceAsStream(fxmlPath);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(FXMLUtil.class.getClassLoader().getResource(fxmlPath));
		map.put("initialize", loader.load(in));
		map.put("controller", loader.getController());
		return map;
	}
}
