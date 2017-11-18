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
import model.Empregado;

/**
 *
 * @author fernandocerveira
 */
@Stateless
public class EmpregadoDao {
    @PersistenceContext
    EntityManager em;
    

    public List<Empregado> getList() {
        Query q = em.createQuery("select e from Empregado e");
        return q.getResultList();
    }

    public void gravar(Empregado object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void excluir(Empregado object) {
        em.remove(em.merge(object));
    }
}
