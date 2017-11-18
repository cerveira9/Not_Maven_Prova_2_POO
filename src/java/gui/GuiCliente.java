/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ClienteDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Cliente;

/**
 *
 * @author fernandocerveira
 */
@Named(value = "guiCliente")
@SessionScoped
public class GuiCliente implements Serializable {

    @EJB
    ClienteDao daoCliente;
    private Cliente cliente;
    private List<Cliente> listaClientes;
    private Boolean alterando;
    
    public GuiCliente() {
    }
    
    public String iniciarLista() {
        listaClientes = daoCliente.getList();
        return "ListaCliente";
    }
    
    public String iniciarNovoCliente() {
        cliente = new Cliente();
        alterando = false;
        return "CadastrarCliente";
    }
    
    public String iniciarAlterarCliente(Cliente cliente) {
        this.cliente = cliente;
        alterando = true;
        return "CadastrarCliente";
    }
    
    public String excluirCliente(Cliente cliente) {
        daoCliente.excluir(cliente);
        listaClientes = daoCliente.getList();
        return null;
    }
    
    public String gravarCliente() {
        daoCliente.gravar(cliente, !alterando);
        listaClientes = daoCliente.getList();
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }
    
    
    
}
