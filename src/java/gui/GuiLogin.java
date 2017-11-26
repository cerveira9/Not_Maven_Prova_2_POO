/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.LoginDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Login;

/**
 *
 * @author fernandocerveira
 */
@Named(value = "guiLogin")
@SessionScoped
public class GuiLogin implements Serializable {

    @EJB
    LoginDao daoLogin;
    private Login login = new Login();
    private List<Login> listaLogin;
    private Boolean alterando;
    
    public GuiLogin() {
    }
    
    public String entrar(){
        return "MenuInicial";
    }
    
    
    public String iniciarLista() {
        listaLogin = daoLogin.getList();
        return "";
    }
    
    public String iniciarNovo() {
        login = new Login();
        alterando = false;
        return "CadastroLogin";
    }
    
    public String iniciarAlterar(Login login) {
        this.login = login;
        alterando = true;
        return "";
    }
    
    public String excluir(Login login) {
        daoLogin.excluir(login);
        listaLogin = daoLogin.getList();
        return null;
    }
    
    public String gravar() {
        daoLogin.gravar(login, alterando);
        listaLogin = daoLogin.getList();
        return null;
    }

    public Login getLogin() {
        return login;
    }

    public void setCliente(Login login) {
        this.login = login;
    }

    public List<Login> getListaLogin() {
        return listaLogin;
    }

    public void setListaLogin(List<Login> listaLogin) {
        this.listaLogin = listaLogin;
    }

    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }
        
    
}
