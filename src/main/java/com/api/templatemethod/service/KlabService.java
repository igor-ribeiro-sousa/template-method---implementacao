package com.api.templatemethod.service;

import com.api.templatemethod.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class KlabService<Entity> {

    public final Entity inserir(Entity entity) {
        Session session = Util.getSession();
        Transaction tx = session.beginTransaction();
        try {
            inserir(session, entity);
            tx.commit();
            return entity;
        } catch (Exception ae) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Erro ao inserir a entidade.", ae);
        } finally {
            session.close();
        }
    }
    protected Entity inserir(Session session, Entity entity){ return entity; }
}
