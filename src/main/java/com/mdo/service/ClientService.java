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

    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

}
