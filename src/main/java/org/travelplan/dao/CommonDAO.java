package org.travelplan.dao;

import java.util.List;

public interface CommonDAO<T> {
	public void add(T obj);
    public List<T> getList();
    public void remove(Integer id);
    public void update(T obj);
    public T findById(Integer id);
    public List<T> getList(boolean ascOrder, String fieldOrder);
}
