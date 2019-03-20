package com.mdo.dao;

import com.mdo.model.Client;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class ClientDao {

    public void addClient (Client client) throws SQLException;

    public void editClient (Client client) throws SQLException;


}
