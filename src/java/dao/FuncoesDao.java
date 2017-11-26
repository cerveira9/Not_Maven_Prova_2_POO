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
import model.Funcoes;

/**
 *
 * @author fernandocerveira
 */
@Stateless
public class FuncoesDao {
    @PersistenceContext
    EntityManager em;
    

    public List<Funcoes> getList() {
        Query q = em.createQuery("select f from Funcoes f");
        return q.getResultList();
    }

    public void gravar(Funcoes object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void excluir(Funcoes object) {
        em.remove(em.merge(object));
    }
}
