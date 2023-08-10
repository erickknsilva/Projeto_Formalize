/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author solam
 */
@Entity
@Table(name = "acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a"),
    @NamedQuery(name = "Acesso.findByEmailSenha", query = "SELECT a FROM Acesso a WHERE a.email = :email AND a.senha = :senha"),
    @NamedQuery(name = "Acesso.findBySenha", query = "SELECT a FROM Acesso a WHERE a.senha = :senha"),
    @NamedQuery(name = "Acesso.findByEmail", query = "SELECT a FROM Acesso a WHERE a.email = :email")})
public class Acesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Colaborador colaborador;

    public Acesso() {
    }

    public Acesso(String email) {
        this.email = email;
    }

    public Acesso(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
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
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Acesso[ email=" + email + " ]";
    }
    
}
