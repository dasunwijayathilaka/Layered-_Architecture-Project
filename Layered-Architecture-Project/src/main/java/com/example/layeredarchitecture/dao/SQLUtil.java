package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T execute(String sql, Object... objects) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for(int i = 0; i < objects.length; i++) {
            pstm.setObject((i + 1), objects[i]);
        }

        if (sql.trim().toUpperCase().startsWith("SELECT")){
            ResultSet resultSet = pstm.executeQuery();
            return (T) resultSet ;
        } else {
            int affectedRows = pstm.executeUpdate();
            return (T) Boolean.valueOf(affectedRows > 0);
        }
    }
}
