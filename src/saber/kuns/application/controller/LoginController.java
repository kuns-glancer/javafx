package saber.kuns.application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import saber.kuns.application.MainApp;
import saber.kuns.dao.UserMapper;
import saber.kuns.util.SpringBeanUtil;

public class LoginController implements Initializable {

	@FXML
	private Button btn_login;

	@FXML
	private Button btn_reset;

	@FXML
	private TextField tf_username;

	@FXML
	private PasswordField tf_pwd;

	private UserMapper userMapper;

	private MainApp application;

	public MainApp getApplication() {
		return application;
	}

	public void setApplication(MainApp application) {
		this.application = application;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		userMapper = SpringBeanUtil.getBean(UserMapper.class);
	}

	public void login() {
		application.gotoMain();
	}

	public void reset() {
		tf_username.setText(null);
		tf_pwd.setText(null);
	}

}
