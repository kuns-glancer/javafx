package saber.kuns.common;

import java.util.List;

public interface CrudDao<T> extends BaseDao {

	public T get(String id);

	public int insert(T t);

	public int update(T t);

	public int delete(T t);

	public int selectByPrimaryKey(T t);

	public List<T> findList(T t);

	public List<T> findPageList(BaseForm form);
}
