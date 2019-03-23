package com.mdo.service;

import com.mdo.dao.impl.ClientDaoImpl;
import com.mdo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientDaoImpl clientDao;

    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    public void editClient(Client client) {
        clientDao.editClient(client);
    }

    public void deleteClient(Client client) {
        clientDao.deleteClient(client);
    }

    public Client getClientById(Integer clientId) {
        return clientDao.getClientById(clientId);
    }

    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

}
