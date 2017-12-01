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
import model.Pedido;

/**
 *
 * @author fernandocerveira
 */
@Stateless
public class PedidoDao {
    @PersistenceContext
    EntityManager em;
    

    public List<Pedido> getList() {
        Query q = em.createQuery("select p from Pedido p");
        return q.getResultList();
    }

    public void gravar(Pedido object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void excluir(Pedido object) {
        em.remove(em.merge(object));
    }
}
