package com.revature.app.daos;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementStatusDAO implements CrudDAO<T> {
    private List<T> reimbursementStatus = new ArrayList<T>();

    void save(T newObject);
    T getByUserId(String userId);
    List<T> getAll();
    void update(T updatedObject);
    void deleteByUserId(String userId);

}