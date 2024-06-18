package com.example.layeredarchitecture.dao.custom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CRUDdao <T> {
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(T object) throws SQLException, ClassNotFoundException ;

    public boolean update(T object) throws SQLException, ClassNotFoundException ;

    public boolean isExist(String  id) throws SQLException, ClassNotFoundException ;


    public boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public String  generateNewId() throws SQLException, ClassNotFoundException ;

    public T search(String id) throws SQLException, ClassNotFoundException;
}
