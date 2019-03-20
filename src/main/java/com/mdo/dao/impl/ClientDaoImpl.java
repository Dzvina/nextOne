package com.mdo.dao.impl;

import com.mdo.dao.ClientDao;
import com.mdo.model.Client;
import com.mdo.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    @Override
    public void addClient(Client client) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editClient(Client client) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteClient(Client client) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Client getClientById(Integer clientId) {
        Client client;
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        client = session.get(Client.class, clientId);
        session.close();
        return client;
    }


    @Override
    public List<Client> getAllClients() {
        List clients;
        Session session = HibernateUtil.createSessionFactory().openSession();
        clients = (List<Client>) session.createQuery("from Client").list();
        session.close();
        return clients;
    }
}
