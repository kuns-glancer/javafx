package saber.kuns.form;

import java.math.BigDecimal;

import saber.kuns.common.BaseForm;

public class TblAccomodationForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal breakfastCost;

	/** 比较方式(eg.大于、不大于、) */
	private String compareWayB;

	private BigDecimal lunchCost;

	private String compareWayL;

	private BigDecimal dinnerCost;

	private String compareWayD;

	public BigDecimal getBreakfastCost() {
		return breakfastCost;
	}

	public void setBreakfastCost(BigDecimal breakfastCost) {
		this.breakfastCost = breakfastCost;
	}

	public BigDecimal getLunchCost() {
		return lunchCost;
	}

	public void setLunchCost(BigDecimal lunchCost) {
		this.lunchCost = lunchCost;
	}

	public BigDecimal getDinnerCost() {
		return dinnerCost;
	}

	public void setDinnerCost(BigDecimal dinnerCost) {
		this.dinnerCost = dinnerCost;
	}

	public String getCompareWayB() {
		return compareWayB;
	}

	public void setCompareWayB(String compareWayB) {
		this.compareWayB = compareWayB;
	}

	public String getCompareWayL() {
		return compareWayL;
	}

	public void setCompareWayL(String compareWayL) {
		this.compareWayL = compareWayL;
	}

	public String getCompareWayD() {
		return compareWayD;
	}

	public void setCompareWayD(String compareWayD) {
		this.compareWayD = compareWayD;
	}

}
