package com.revature.app.daos;
import com.revature.app.models.Reimbursement;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO implements CrudDAO<T> {
    private List<T> reimbursement = new ArrayList<>();

    void save(T newObject);
    T getByUserId(String userId);
    List<T> getAll();
    void update(T updatedObject);
    void deleteByUserId(String userId);

}
