package Model;

import Model.Veiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-10T14:58:10")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> telefone;
    public static volatile ListAttribute<Cliente, Veiculo> veiculoList;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, String> endereco;
    public static volatile SingularAttribute<Cliente, String> cpf;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile SingularAttribute<Cliente, String> email;

}