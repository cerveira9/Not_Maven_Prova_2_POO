/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.FuncoesDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Funcoes;

/**
 *
 * @author fernandocerveira
 */
@Named(value = "guiFuncoes")
@SessionScoped
public class GuiFuncoes implements Serializable {

    @EJB
    FuncoesDao daoFuncoes;
    private Funcoes funcoes;
    private List<Funcoes> listaFuncoes;
    private Boolean alterando;   
    
    public GuiFuncoes() {
    }
    
    public String iniciarLista() {
        listaFuncoes = daoFuncoes.getList();
        return "ListaFuncao";
    }
    
    public String iniciarNovo() {
        funcoes = new Funcoes();
        alterando = false;
        return "CadastroFuncao";
    }
    
    public String iniciarAlterar(Funcoes funcoes) {
        this.funcoes = funcoes;
        alterando = true;
        return "CadastroFuncao";
    }
    
    public String excluir(Funcoes funcoes) {
        daoFuncoes.excluir(funcoes);
        listaFuncoes = daoFuncoes.getList();
        return null;
    }
    
    public String gravar() {
        daoFuncoes.gravar(funcoes, alterando);
        listaFuncoes = daoFuncoes.getList();
        return "ListaFuncoes";
    }

    public Funcoes getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(Funcoes funcoes) {
        this.funcoes = funcoes;
    }

    public List<Funcoes> getListaFuncoes() {
        return listaFuncoes;
    }

    public void setListaFuncoes(List<Funcoes> listaFuncoes) {
        this.listaFuncoes = listaFuncoes;
    }

    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }

    
}
