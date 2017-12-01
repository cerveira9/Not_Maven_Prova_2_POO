/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.EmpregadoDao;
import dao.PedidoDao;
import dao.ServicoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Empregado;
import model.Pedido;
import model.Servico;

/**
 *
 * @author fernandocerveira
 */
@Named(value = "guiPedido")
@SessionScoped
public class GuiPedido implements Serializable {

    @EJB
    PedidoDao daoPedido;
    @EJB
    private EmpregadoDao daoEmpregado;
    @EJB
    private ServicoDao daoServico;
    
    private Pedido pedido;
    private List<Pedido> listaPedidos;
    private Empregado empregado;
    private List<Empregado> listaEmpregados;
    private Servico servico;
    private List<Servico> listaServicos;
    private Boolean alterando;
    private String nomeEmpregado;
    private String nomeServico;
    
    public GuiPedido() {
    }
    
    
    
    public String iniciarLista() {
        listaPedidos = daoPedido.getList();
        return "ListaPedido";
    }
    
    public String iniciarNovo() {
        pedido = new Pedido();
        alterando = false;
        listaEmpregados = daoEmpregado.getList();
        listaServicos = daoServico.getList();
        return "CadastrarPedido";
    }
    
    private Empregado getEmpregadoSelecionado(){
        for (Empregado e: listaEmpregados) {
            if (e.toString().equals(nomeEmpregado)) {
                return e;
            }
        }
        return null;
    }
    
    private Servico getServicoSelecionado(){
        for (Servico s: listaServicos) {
            if (s.toString().equals(nomeServico)) {
                return s;
            }
        }
        return null;
    }
    
    public String iniciarAlterar(Pedido pedido) {
        this.pedido = pedido;
        alterando = true;
        return "CadastrarPedido";
    }
    
    public String excluir(Pedido pedido) {
        daoPedido.excluir(pedido);
        listaPedidos = daoPedido.getList();
        
        return null;
    }
    
    public String gravar() {
        pedido.setEmpregado(getEmpregadoSelecionado());
        pedido.setServico(getServicoSelecionado());
        daoPedido.gravar(pedido, alterando);
        listaPedidos = daoPedido.getList();
        return null;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaClientes(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }

    public List<Empregado> getListaEmpregados() {
        return listaEmpregados;
    }

    public void setListaEmpregados(List<Empregado> listaEmpregados) {
        this.listaEmpregados = listaEmpregados;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public String getNomeEmpregado() {
        return nomeEmpregado;
    }

    public void setNomeEmpregado(String nomeEmpregado) {
        this.nomeEmpregado = nomeEmpregado;
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

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }
    
    
}
