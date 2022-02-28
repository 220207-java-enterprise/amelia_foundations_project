package com.revature.app.daos;

import com.revature.app.models.Reimbursement;
import com.revature.app.models.ReimbursementStatus;
import com.revature.app.models.ReimbursementType;
import com.revature.app.util.ConnectionFactory;
import com.revature.app.util.exceptions.DataSourceException;
import com.revature.app.util.exceptions.ResourcePersistenceException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class ReimbursementDAO implements CrudDAO<Reimbursement> {

    @Override
    public void save(Reimbursement newObject) {

    }

    @Override
    public Reimbursement getByUserId(String UserId) {
        return null;
    }

    @Override
    public List<Reimbursement> getAll() {
        return null;
    }

    @Override
    public void update(Reimbursement updatedObject) {

    }

    @Override
    public void deleteByUserId(String userId) {

    }

}

