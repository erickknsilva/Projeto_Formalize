/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author solam
 */
@Entity
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c"),
    @NamedQuery(name = "Colaborador.findByEmail", query = "SELECT c FROM Colaborador c WHERE c.email = :email"),
    @NamedQuery(name = "Colaborador.findByNome", query = "SELECT c FROM Colaborador c WHERE c.nome = :nome"),
    @NamedQuery(name = "Colaborador.findByTelefone", query = "SELECT c FROM Colaborador c WHERE c.telefone = :telefone")})
public class Colaborador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "colaborador", fetch = FetchType.EAGER)
    private Acesso acesso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "email", fetch = FetchType.EAGER)
    private List<Servico> servicoList;

    public Colaborador() {
    }

    public Colaborador(String email) {
        this.email = email;
    }

    public Colaborador(String email, String nome, String telefone) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    @XmlTransient
    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Colaborador[ email=" + email + " ]";
    }
    
}
