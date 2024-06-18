package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;


import java.sql.*;
import java.util.ArrayList;


public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();

        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            allCustomers.add(customerDTO);
        }
        return allCustomers ;
    }

    @Override
    public boolean save(CustomerDTO object) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", object.getId(), object.getName(), object.getAddress());
    }

    @Override
    public boolean update(CustomerDTO object) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM Customer WHERE id=?", object);
        return resultSet.next();
    }

    @Override
    public boolean isExist(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM Customer WHERE id=?", id);
        return resultSet.next();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?", id);
        rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
    }























//    @Override
//    public ArrayList<CustomerTM> getAllCustomers() throws SQLException, ClassNotFoundException {
//
//        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
//
//        ArrayList<CustomerTM> allCustomers = new ArrayList<>();
//
//        while (rst.next()){
//            CustomerTM customerTM = new CustomerTM(rst.getString("id"), rst.getString("name"), rst.getString("address"));
//            allCustomers.add(customerTM);
//        }
//        return allCustomers ;
//    }
//
//    @Override
//    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
//
//        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress());
//
//    }
//
//    @Override
//    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
//
//        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", customerDTO.getName(), customerDTO.getAddress(), customerDTO.getId());
//
//    }
//
//    @Override
//    public boolean isExistCustomer(String id) throws SQLException, ClassNotFoundException {
//
//        ResultSet resultSet = SQLUtil.execute("SELECT id FROM Customer WHERE id=?", id);
//        return resultSet.next();
//
//    }
//
//    @Override
//    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
//
//        return SQLUtil.execute("DELETE FROM Customer WHERE id=?", id);
//
//    }
//
//    @Override
//    public String  generateNewId() throws SQLException, ClassNotFoundException {
//
//        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//
//        if (rst.next()) {
//            String id = rst.getString("id");
//            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//            return String.format("C00-%03d", newCustomerId);
//        } else {
//            return "C00-001";
//        }
//    }
//
//    @Override
//    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
//
//        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?", id);
//        rst.next();
//        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
//    }
}
