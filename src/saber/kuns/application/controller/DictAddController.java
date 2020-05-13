package saber.kuns.application.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import saber.kuns.entity.SysProperty;
import saber.kuns.service.SysPropertyService;
import saber.kuns.util.IdGen;
import saber.kuns.util.SpringBeanUtil;

public class DictAddController implements Initializable {

	Logger logger = Logger.getLogger(DictAddController.class);
	@FXML
	private TextField categoryTF;

	@FXML
	private TextField codeTF;

	@FXML
	private TextField valueTF;

	private SysPropertyService sysPropertyService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sysPropertyService = SpringBeanUtil.getBean(SysPropertyService.class);
		codeTF.setDisable(true);
	}

	public void save() {
		SysProperty sysProperty = new SysProperty();
		sysProperty.setId(IdGen.uuid());
		sysProperty.setCategory(categoryTF.getText());
		sysProperty.setCode(codeTF.getText());
		sysProperty.setValue(valueTF.getText());
		sysProperty.setCreateUser("shenk");
		sysProperty.setUpdateUser("shenk");
		sysProperty.setDelFlag("0");
		int row = sysPropertyService.insert(sysProperty);
		if (1 == row) {
			// AlertBox alertBox = new AlertBox();
			// alertBox.display("提示", "保存成功");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示信息");
			alert.setHeaderText("保存成功");
			alert.showAndWait();
			codeTF.setText(null);
			valueTF.setText(null);

		}
	}

	public void reset() {
		categoryTF.setText(null);
		codeTF.setText(null);
		valueTF.setText(null);
	}

	/** 生成字典code */
	public void genCode() {
		Map<String, Object> params = new HashMap<>();
		params.put("category", categoryTF.getText());
		String code = sysPropertyService.genCode(params);
		codeTF.setText(code);
	}

}
