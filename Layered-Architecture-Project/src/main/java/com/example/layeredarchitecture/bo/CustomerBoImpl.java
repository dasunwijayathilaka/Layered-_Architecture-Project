package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl {
    public ArrayList<CustomerDTO> getallCustomer() throws SQLException , ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAO();



    }


}
