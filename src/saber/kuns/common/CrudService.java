package saber.kuns.common;

import java.util.List;

import saber.kuns.plugin.PageList;

public interface CrudService<T> extends BaseService {

	public int insert(T t);

	public int update(T t);

	public int delete(T t);

	public T get(String id);

	public int selectByPrimaryKey(T t);

	public List<T> findList(T t);

	public PageList<T> findPage(BaseForm form);

}
