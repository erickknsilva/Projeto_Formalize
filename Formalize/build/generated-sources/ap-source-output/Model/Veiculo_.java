package Model;

import Model.Cliente;
import Model.Servico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-10T14:58:10")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ { 

    public static volatile SingularAttribute<Veiculo, String> marca;
    public static volatile SingularAttribute<Veiculo, String> tipo;
    public static volatile SingularAttribute<Veiculo, String> ano;
    public static volatile SingularAttribute<Veiculo, Cliente> idCliente;
    public static volatile ListAttribute<Veiculo, Servico> servicoList;
    public static volatile SingularAttribute<Veiculo, String> modelo;
    public static volatile SingularAttribute<Veiculo, String> placa;

}