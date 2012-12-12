package org.travelplan.service;

import java.util.List;

public interface CommonService<T> {
	 public List<T> getList();
	 public void add(T obj);
	 public void remove(Integer id);
	 public void update(T obj);
	 public T findById(Integer id);
}
