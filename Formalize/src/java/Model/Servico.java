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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author solam
 */
@Entity
@Table(name = "servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByNomeCliente", query = "SELECT s FROM Servico s JOIN s.placa v JOIN v.idCliente c WHERE c.nome LIKE :nomeCliente"),
    @NamedQuery(name = "Servico.findByPlacaVeiculo", query = "SELECT s FROM Servico s WHERE s.placa.placa LIKE :placa"),
    @NamedQuery(name = "Servico.findByIdServico", query = "SELECT s FROM Servico s WHERE s.idServico = :idServico"),
    @NamedQuery(name = "Servico.findByTipoServico", query = "SELECT s FROM Servico s WHERE s.tipoServico LIKE :tipoServico"),
    @NamedQuery(name = "Servico.findByValorServ", query = "SELECT s FROM Servico s WHERE s.valorServ = :valorServ"),
    @NamedQuery(name = "Servico.findByDataServico", query = "SELECT s FROM Servico s WHERE s.dataServico LIKE :dataServico")})
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idServico")
    private Integer idServico;
    @Basic(optional = false)
    @Column(name = "tipo_servico")
    private String tipoServico;
    @Basic(optional = false)
    @Column(name = "valor_serv")
    private float valorServ;
    @Basic(optional = false)
    @Column(name = "dataServico")
    private String dataServico;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Colaborador email;
    @JoinColumn(name = "placa", referencedColumnName = "placa")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Veiculo placa;

    public Servico() {
    }

    public Servico(Integer idServico) {
        this.idServico = idServico;
    }

    public Servico(Integer idServico, String tipoServico, float valorServ, String dataServico) {
        this.idServico = idServico;
        this.tipoServico = tipoServico;
        this.valorServ = valorServ;
        this.dataServico = dataServico;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public float getValorServ() {
        return valorServ;
    }

    public void setValorServ(float valorServ) {
        this.valorServ = valorServ;
    }

    public String getDataServico() {
        return dataServico;
    }

    public void setDataServico(String dataServico) {
        this.dataServico = dataServico;
    }

    public Colaborador getEmail() {
        return email;
    }

    public void setEmail(Colaborador email) {
        this.email = email;
    }

    public Veiculo getPlaca() {
        return placa;
    }

    public void setPlaca(Veiculo placa) {
        this.placa = placa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServico != null ? idServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.idServico == null && other.idServico != null) || (this.idServico != null && !this.idServico.equals(other.idServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Servico[ idServico=" + idServico + " ]";
    }
    
}
