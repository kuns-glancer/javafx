package saber.kuns.application.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import saber.kuns.config.Model;
import saber.kuns.entity.TblAccomodation;
import saber.kuns.service.TblAccomodationService;
import saber.kuns.util.IdGen;
import saber.kuns.util.SpringBeanUtil;
import saber.kuns.util.StringUtils;
import saber.kuns.util.TimeUtils;

public class AccomodationAddController implements Initializable {

	/** 父页面中的TableView */
	private TableView<TblAccomodation> parentCtr;

	public TableView<TblAccomodation> getParentCtr() {
		return parentCtr;
	}

	public void setParentCtr(TableView<TblAccomodation> parentCtr) {
		this.parentCtr = parentCtr;
	}

	/** 更新数据组在的行 */
	private int UpdatableRow;

	public int getUpdatableRow() {
		return UpdatableRow;
	}

	public void setUpdatableRow(int updatableRow) {
		UpdatableRow = updatableRow;
	}

	@FXML
	private TextField morCost;

	@FXML
	private TextField lunchCost;

	@FXML
	private TextField dinnerCost;

	@FXML
	private DatePicker datePicker;

	@FXML
	private Button saveBtn;

	@FXML
	private Button restBtn;

	private TblAccomodationService service;

	private TblAccomodation tblAccomodation;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = SpringBeanUtil.getBean(TblAccomodationService.class);
		String accomodationId = StringUtils.valueOf(Model.getAttributionByName("accomodationId"));
		if (accomodationId != null) {
			datePicker.setDisable(true);
			tblAccomodation = service.get(accomodationId);
			if (tblAccomodation != null) {
				datePicker.setValue(TimeUtils.date2LocalDate(tblAccomodation.getDate()));
				morCost.setText(tblAccomodation.getBreakfastCost().toString());
				lunchCost.setText(tblAccomodation.getLunchCost().toString());
				dinnerCost.setText(tblAccomodation.getDinnerCost().toString());
			}
		} else {
			datePicker.setValue(LocalDate.now());
		}

	}

	public void save() {
		if (tblAccomodation == null) {
			tblAccomodation = new TblAccomodation();
			tblAccomodation.setId(IdGen.uuid());
		}
		tblAccomodation.setBreakfastCost(new BigDecimal(morCost.getText()));
		tblAccomodation.setLunchCost(new BigDecimal(lunchCost.getText()));
		tblAccomodation.setDinnerCost(new BigDecimal(dinnerCost.getText()));
		tblAccomodation.setCreateUser("shenk");
		tblAccomodation.setUpdateUser("shenk");
		tblAccomodation.setDelFlag("0");
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = datePicker.getValue().atStartOfDay().atZone(zone).toInstant();
		tblAccomodation.setDate(Date.from(instant));
		if (Model.getAttributionByName("accomodationId") == null) {
			service.insert(tblAccomodation);
		} else {
			tblAccomodation.setUpdateTime(new Date());
			service.update(tblAccomodation);
			getParentCtr().getItems().set(UpdatableRow, tblAccomodation);
			// getParentCtr().refresh();
			Model.removeAttribution("accomodationId");
		}
	}

	public void clear() {
		if (tblAccomodation != null) {
			datePicker.setValue(TimeUtils.date2LocalDate(tblAccomodation.getDate()));
			morCost.setText(tblAccomodation.getBreakfastCost().toString());
			lunchCost.setText(tblAccomodation.getLunchCost().toString());
			dinnerCost.setText(tblAccomodation.getDinnerCost().toString());
		} else {
			datePicker.setValue(LocalDate.now());
			morCost.setText("0.0");
			lunchCost.setText("0.0");
			dinnerCost.setText("0.0");
		}
	}

}
