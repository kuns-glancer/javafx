package saber.kuns.application.component;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

	@Override
	public void replaceText(int start, int end, String text) {
		if (text.matches("[0-9]*(\\.[0-9]*){0,1}")) {
			if (this.getText().contains(".") && ".".equals(text)) {
				return;
			}
			super.replaceText(start, end, text);
		}
	}

	@Override
	public void replaceSelection(String text) {
		System.out.println("replaceSelection:" + text);
		if (text.matches("[0-9]*(\\.[0-9]+)?")) {
			super.replaceSelection(text);
		}
	}

}
