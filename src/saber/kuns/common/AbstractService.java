package saber.kuns.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import saber.kuns.plugin.PageList;

public abstract class AbstractService<T, R extends CrudDao<T>> implements CrudService<T> {

	@Autowired
	private R dao;

	@Override
	public T get(String id) {
		return dao.get(id);
	}

	@Override
	public int insert(T t) {
		// TODO Auto-generated method stub
		return dao.insert(t);
	}

	@Override
	public int update(T t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

	@Override
	public int delete(T t) {
		// TODO Auto-generated method stub
		return dao.delete(t);
	}

	@Override
	public int selectByPrimaryKey(T t) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(t);
	}

	@Override
	public List<T> findList(T t) {
		// TODO Auto-generated method stub
		return dao.findList(t);
	}

	@Override
	public PageList<T> findPage(BaseForm form) {
		// TODO Auto-generated method stub
		PageList<T> pageList = new PageList<>();
		pageList.setDataList(dao.findPageList(form));
		pageList.setCount(form.getTotalSize());
		return pageList;
	}
	
	

}
