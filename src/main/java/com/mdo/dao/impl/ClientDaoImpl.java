package com.mdo.dao.impl;

import com.mdo.dao.ClientDao;
import com.mdo.model.Client;
import com.mdo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    static final Logger LOG = LoggerFactory.getLogger(AccountDaoImpl.class);

    @Override
    public void addClient(Client client) {
        LOG.info("Add new client.");
        Session session = getSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        session.close();
        LOG.info("Add new client successful.");
    }

    @Override
    public void editClient(Client client) {
        LOG.info("Edit client.");
        Session session = getSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
        session.close();
        LOG.info("Edit client successful.");
    }

    @Override
    public void deleteClient(Client client) {
        LOG.info("Delete client.");
        Session session = getSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
        session.close();
        LOG.info("Delete client successful.");
    }

    @Override
    public Client getClientById(Integer clientId) {
        LOG.info("Get client by id.");
        Client client;
        Session session = getSession();
        session.beginTransaction();
        client = session.get(Client.class, clientId);
        session.close();
        LOG.info("Get client by id successful.");
        return client;
    }


    @Override
    public List<Client> getAllClients() {
        LOG.info("Get all clients.");
        List clients;
        Session session = getSession();
        clients = (List<Client>) session.createQuery("From Client").list();
        session.close();
        LOG.info("Get all clients successful.");
        return clients;
    }

    private Session getSession() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
}
