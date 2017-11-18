/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.EmpregadoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Empregado;

/**
 *
 * @author fernandocerveira
 */
@Named(value = "guiEmpregado")
@SessionScoped
public class GuiEmpregado implements Serializable {

    @EJB
    EmpregadoDao daoEmpregado;
    private Empregado empregado;
    private List<Empregado> listaEmpregados;
    private Boolean alterando;
    
    public GuiEmpregado() {
    }
    
    public String iniciarLista() {
        listaEmpregados = daoEmpregado.getList();
        return "ListaEmpregado";
    }
    
    public String iniciarNovo() {
        empregado = new Empregado();
        alterando = false;
        return "CadastrarEmpregado";
    }
    
    public String iniciarAlterar(Empregado empregado) {
        this.empregado = empregado;
        alterando = true;
        return "CadastrarEmpregado";
    }
    
    public String excluir(Empregado empregado) {
        daoEmpregado.excluir(empregado);
        listaEmpregados = daoEmpregado.getList();
        return null;
    }
    
    public String gravar() {
        daoEmpregado.gravar(empregado, alterando);
        listaEmpregados = daoEmpregado.getList();
        return null;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public List<Empregado> getListaEmpregados() {
        return listaEmpregados;
    }

    public void setListaEmpregados(List<Empregado> listaEmpregados) {
        this.listaEmpregados = listaEmpregados;
    }

    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }
    
    
    
}
