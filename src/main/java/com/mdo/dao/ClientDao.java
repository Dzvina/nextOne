package com.mdo.dao;

import com.mdo.dao.impl.ClientD;
import com.mdo.model.Client;
import com.mdo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class ClientDao implements ClientD {

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
    public Collection getClientId(Integer client_id) {
        List clients = new ArrayList<Client>();
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        clients = session.createCriteria(Client.class).add(Restrictions.idEq(client_id)).list();
        session.close();
        return clients;
    }

    @Override
    public Collection getName(String name) {
        return null;
    }

    @Override
    public Collection getAddress(String address) {
        return null;
    }

    @Override
    public Collection getAge(Integer age) {
        return null;
    }

    @Override
    public Collection getAllClients() {
        List clients = new ArrayList<Client>();
        Session session = HibernateUtil.createSessionFactory().openSession();
        clients = session.createCriteria(Client.class).list();
        session.close();
        return clients;
    }
}
