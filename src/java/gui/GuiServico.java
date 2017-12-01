/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ServicoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Servico;

/**
 *
 * @author fernandocerveira
 */
@Named(value = "guiServico")
@SessionScoped
public class GuiServico implements Serializable {

    @EJB
    ServicoDao daoServico;
    private Servico servico;
    private List<Servico> listaServicos;
    private Boolean alterando;
    
    public GuiServico() {
    }
    
    public String iniciarLista() {
        listaServicos = daoServico.getList();
        return "ListaServico";
    }
    
    public String iniciarNovo() {
        servico = new Servico();
        alterando = false;
        return "CadastrarServico";
    }
    
    public String iniciarAlterar(Servico servico) {
        this.servico = servico;
        alterando = true;
        return "CadastrarServico";
    }
    
    public String excluir(Servico servico) {
        daoServico.excluir(servico);
        listaServicos = daoServico.getList();
        return null;
    }
    
    public String gravar() {
        daoServico.gravar(servico, alterando);
        listaServicos = daoServico.getList();
        return null;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servico> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }
    
    
    
}
