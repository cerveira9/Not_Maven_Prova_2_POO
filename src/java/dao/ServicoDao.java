/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Servico;

/**
 *
 * @author fernandocerveira
 */
@Stateless
public class ServicoDao {
    @PersistenceContext
    EntityManager em;
    

    public List<Servico> getList() {
        Query q = em.createQuery("select s from Servico s");
        return q.getResultList();
    }

    public void gravar(Servico object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void excluir(Servico object) {
        em.remove(em.merge(object));
    }
}
