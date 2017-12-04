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
import model.Login;

/**
 *
 * @author fernandocerveira
 */
@Stateless
public class LoginDao {
    @PersistenceContext
    EntityManager em;
    

    public List<Login> getList() {
        Query q = em.createQuery("select l from Login l");
        return q.getResultList();
    }
    
    public boolean entrar(String login, String senha){
        Query q = em.createQuery("select l from Login l where l.login = :login and l.senha = :senha");
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        List l = q.getResultList();
        if (l.isEmpty()){
            return false;
        } else {
            return true;
        }
    }
    
    public void gravar(Login object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void excluir(Login object) {
        em.remove(em.merge(object));
    }
}
