/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author fernandocerveira
 */
@Entity
public class Empregado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    private int matricula;
    private String nomeEmpregado;
    @OneToMany
    private Cargos cargo;
    @OneToMany
    private List<Funcoes> funcao;
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empregado)) {
            return false;
        }
        Empregado other = (Empregado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Empregado[ id=" + id + " ]";
    }
    
    public Empregado() {
    }
    
    public void createNewCargo(Cargos cargo){
        Funcoes c = new Funcoes(); 
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNomeEmpregado() {
        return nomeEmpregado;
    }

    public void setNomeEmpregado(String nomeEmpregado) {
        this.nomeEmpregado = nomeEmpregado;
    }

    public List<Funcoes> getFuncao() {
        return funcao;
    }

    public void setFuncao(List<Funcoes> funcao) {
        this.funcao = funcao;
    }

    public Cargos getCargo() {
        return cargo;
    }
    
}
