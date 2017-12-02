/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Empregado;
import model.Pedido;

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
    
    public List<Empregado> getListCargoEmpregado(){
        Query q = em.createQuery("select e from Empregado e where e.cargo LIKE 'Empregado'");
        return q.getResultList();
    }
    
    public boolean getEmpregadoOcupado(Empregado e, Date d) {
        Query q = em.createQuery("select p from Pedido p where p.dataRealizacao = :dt and p.empregado.id = :emp");
        q.setParameter("dt", d);
        q.setParameter("emp", e.getId());
        List l = q.getResultList();
        if (l.isEmpty()) {
            return false;
        } else {
            return true;
        }
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
