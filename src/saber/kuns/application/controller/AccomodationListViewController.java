package saber.kuns.application.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import saber.kuns.application.component.HyperlinkCell;
import saber.kuns.config.Model;
import saber.kuns.dao.TblAccomodationMapper;
import saber.kuns.entity.TblAccomodation;
import saber.kuns.form.TblAccomodationForm;
import saber.kuns.util.FXMLUtil;
import saber.kuns.util.SpringBeanUtil;
import saber.kuns.util.TimeUtils;

public class AccomodationListViewController implements Initializable {

	private static final int PAGE_SIZE = 8;

	private ObservableList<TblAccomodation> data;

	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@FXML
	private Button searchBtn;

	@FXML
	private TableView<TblAccomodation> tableView;

	@FXML
	private TableColumn<TblAccomodation, String> col_id;

	@FXML
	private TableColumn<TblAccomodation, Date> col_date;

	@FXML
	private TableColumn<TblAccomodation, String> col_mor;

	@FXML
	private TableColumn<TblAccomodation, String> col_lunch;

	@FXML
	private TableColumn<TblAccomodation, String> col_dinner;

	@FXML
	private TableColumn<TblAccomodation, String> col_op;

	@FXML
	private Pagination pagination;

	@FXML
	private DatePicker dateFrom;

	@FXML
	private DatePicker dateTo;

	private TblAccomodationMapper tblAccomodationMapper;

	public void search() {
		Platform.runLater(() -> {
			data.clear();
			LocalDate start = dateFrom.getValue();
			LocalDate end = dateTo.getValue();
			TblAccomodationForm tblAccomodationForm = new TblAccomodationForm();
			tblAccomodationForm.setPageSize(PAGE_SIZE);
			tblAccomodationForm.setCurrentPage(1);
			tblAccomodationForm.setStartDay(TimeUtils.localDate2Date(start));
			tblAccomodationForm.setEndDay(TimeUtils.localDate2Date(end));
			tblAccomodationMapper.findPageList(tblAccomodationForm);
			List<TblAccomodation> result = tblAccomodationMapper.findPageList(tblAccomodationForm);
			pagination.setPageCount((tblAccomodationForm.getTotalSize() - 1) / PAGE_SIZE + 1);
			data.addAll(result);
			tableView.setItems(data);
			tableView.refresh();
		});

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		data = FXCollections.observableArrayList();
		col_id.setCellFactory((col) -> {
			TableCell<TblAccomodation, String> cell = new TableCell<TblAccomodation, String>() {
				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					if (!empty) {
						int rowIndex = this.getIndex() + 1;
						this.setText(String.valueOf(rowIndex));
					}
				}
			};
			return cell;
		});
		col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		col_date.setCellFactory((col) -> {
			TableCell<TblAccomodation, Date> cell = new TableCell<TblAccomodation, Date>() {
				@Override
				public void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (!empty) {
						this.setText(format.format(item));
					}
				}
			};
			return cell;
		});

		col_op.setCellFactory((col) -> {
			HyperlinkCell<TblAccomodation, String> cell = new HyperlinkCell<TblAccomodation, String>() {
				@Override
				public void updateItem(String item, boolean empty) {

					TblAccomodation tblAccomodation = (TblAccomodation) this.getTableRow().getItem();
					int row = this.getTableRow().getIndex();
					if (tblAccomodation != null) {
						super.updateItem(item, empty);
						this.getHyperlink().setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								System.out.println(tblAccomodation.getId());
								Model.addAttribution("accomodationId", tblAccomodation.getId());
								Stage window = new Stage();
								window.setTitle("title");
								// modality要使用Modality.APPLICATION_MODEL
								window.initModality(Modality.APPLICATION_MODAL);
								window.setMinWidth(300);
								window.setMinHeight(150);
								try {
									Map<String, Object> map = FXMLUtil.getControllerAndInitialize(
											"saber/kuns/application/fxmls/AccomodationAdd.fxml");
									AccomodationAddController accomodationAddController = (AccomodationAddController) map
											.get("controller");
									accomodationAddController.setParentCtr(tableView);
									accomodationAddController.setUpdatableRow(row);
									AnchorPane anchorPane = (AnchorPane) map.get("initialize");
									Scene scene = new Scene(anchorPane);
									window.setScene(scene);
									window.showAndWait();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
						setGraphic(this.getHyperlink());
					}
				}
			};
			return cell;
		});

		col_mor.setCellValueFactory(new PropertyValueFactory<>("breakfastCost"));
		col_lunch.setCellValueFactory(new PropertyValueFactory<>("lunchCost"));
		col_dinner.setCellValueFactory(new PropertyValueFactory<>("dinnerCost"));
		tblAccomodationMapper = SpringBeanUtil.getBean(TblAccomodationMapper.class);

		pagination.setPageFactory(new Callback<Integer, Node>() {

			@Override
			public Node call(Integer param) {
				Platform.runLater(() -> {
					data.clear();
					LocalDate start = dateFrom.getValue();
					LocalDate end = dateTo.getValue();
					TblAccomodationForm tblAccomodationForm = new TblAccomodationForm();
					tblAccomodationForm.setPageSize(PAGE_SIZE);
					tblAccomodationForm.setCurrentPage(pagination.getCurrentPageIndex() + 1);
					tblAccomodationForm.setStartDay(TimeUtils.localDate2Date(start));
					tblAccomodationForm.setEndDay(TimeUtils.localDate2Date(end));
					List<TblAccomodation> result = tblAccomodationMapper.findPageList(tblAccomodationForm);
					pagination.setPageCount((tblAccomodationForm.getTotalSize() - 1) / PAGE_SIZE + 1);
					data.addAll(result);
					tableView.setItems(data);
					tableView.refresh();
				});
				return tableView;
			}
		});

	}

}
