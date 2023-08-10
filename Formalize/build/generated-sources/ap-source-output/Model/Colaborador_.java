package Model;

import Model.Acesso;
import Model.Servico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-10T14:58:10")
@StaticMetamodel(Colaborador.class)
public class Colaborador_ { 

    public static volatile SingularAttribute<Colaborador, String> telefone;
    public static volatile SingularAttribute<Colaborador, Acesso> acesso;
    public static volatile ListAttribute<Colaborador, Servico> servicoList;
    public static volatile SingularAttribute<Colaborador, String> nome;
    public static volatile SingularAttribute<Colaborador, String> email;

}