package saber.kuns.application.component;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;

public class HyperlinkCell<S, T> extends TableCell<S, T> {

	private Hyperlink hyperlink;

	public HyperlinkCell() {
		hyperlink = new Hyperlink("编辑");
	}

	public Hyperlink getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(Hyperlink hyperlink) {
		this.hyperlink = hyperlink;
	}

}
