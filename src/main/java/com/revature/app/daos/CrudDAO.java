package com.revature.app.daos;

import java.util.List;

public interface CrudDAO<T> {

    void save(T newObject);
    T getByUserId(String userId);
    List<T> getAll();
    void update(T updatedObject);
    void deleteByUserId(T newObject);

}