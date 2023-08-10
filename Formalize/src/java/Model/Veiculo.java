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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author solam
 */
@Entity
@Table(name = "veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.findByPlaca", query = "SELECT v FROM Veiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Veiculo.findByMarca", query = "SELECT v FROM Veiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Veiculo.findByModelo", query = "SELECT v FROM Veiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Veiculo.findByTipo", query = "SELECT v FROM Veiculo v WHERE v.tipo = :tipo"),
    @NamedQuery(name = "Veiculo.findByAno", query = "SELECT v FROM Veiculo v WHERE v.ano = :ano")})
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "ano")
    private String ano;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placa", fetch = FetchType.EAGER)
    private List<Servico> servicoList;

    public Veiculo() {
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo(String placa, String marca, String modelo, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Veiculo[ placa=" + placa + " ]";
    }
    
}
