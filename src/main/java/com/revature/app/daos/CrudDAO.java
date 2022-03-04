package com.revature.app.daos;

import com.revature.app.models.Reimbursement;
import com.revature.app.models.User;

import java.util.List;

public interface CrudDAO<T> {

    void save(T newObject);
    T getById(String id);
    List<T> getAll();
    void update(T updatedObject);
    void deleteById(String id);
}