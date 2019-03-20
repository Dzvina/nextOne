package com.mdo.dao.impl;

import com.mdo.model.Client;

import java.util.Collection;

public interface ClientD {

    public void addClient(Client client);

    public void editClient(Client client);

    public void deleteClient(Client client);

    public Collection getClientId(Integer client_id);

    public Collection getName(String name);

    public Collection getAddress(String address);

    public Collection getAge(Integer age);

    public Collection getAllClients();

}
