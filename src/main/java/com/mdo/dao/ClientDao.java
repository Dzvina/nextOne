package com.mdo.dao;

import com.mdo.model.Client;

import java.util.List;

public interface ClientDao {

    void addClient(Client client);

    void editClient(Client client);

    void deleteClient(Client client);

    Client getClientById(Integer clientId);

    List<Client> getAllClients();

}
