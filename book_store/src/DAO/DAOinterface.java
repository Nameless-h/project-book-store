
package DAO;

/**
 *
 * @author ASUS
 */

import java.util.ArrayList;

public interface DAOinterface<T> {
	public int insert(T t);

	public int update(T update_obj);

	public int delete(T t);

	public int delete_all();

	public ArrayList<T> selecAll();

	public T selectById(int t);

	public ArrayList<T> selecByCondition(String condition);

}
