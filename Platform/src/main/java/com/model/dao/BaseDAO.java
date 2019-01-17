package com.model.dao;

import java.io.Serializable;

public interface BaseDAO<T, PK extends Serializable> {

	void save(T admin);

	void delete(T selectedUser);

	T findByID(PK id);
	
	void update(T obj);
}
