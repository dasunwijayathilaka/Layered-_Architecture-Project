package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;

public interface ItemDAO extends CRUDdao <ItemDTO> {
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException ;
}
