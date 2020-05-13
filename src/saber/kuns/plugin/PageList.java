package saber.kuns.plugin;

import java.util.List;

public class PageList<T> {

	public PageList() {
	}

	private List<T> dataList;
	
	private int count;

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
