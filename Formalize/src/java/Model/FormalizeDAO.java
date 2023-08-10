/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author solam
 */
public class FormalizeDAO {

    private EntityManagerFactory conn;
    private EntityManager manager;

    //Fazendo Conexão como BD.
    public void connect() {
        conn = Persistence.createEntityManagerFactory("FormalizePU");//Nome tirado da pasta "Configuration Files", "pesistence.xml";
        manager = conn.createEntityManager();
    }

    // Este médetodo serve para validar o login, buscando no BD.
    public Acesso validarLogin(String u, String s) {
        connect();
        try {
            TypedQuery<Acesso> q = manager.createNamedQuery("Acesso.findByEmailSenha", Acesso.class);//Query tirado da classe "Acesso",query para pegar usuario e senha;
            q.setParameter("email", u);
            q.setParameter("senha", s);
            Acesso acesso = q.getSingleResult();
            return acesso;
        } catch (NoResultException ex) {
            return null;
        }
    }

    // Este método ira salvar o Colaborador e retornar um INT, para cadastrar o usuario ou veriricar a já existencia dessa conta;
    public int cadastrar(Colaborador colab) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(colab);
            manager.getTransaction().commit();
            return 1;//Cadastro;
        } catch (EntityExistsException ex) {
            return 2;//Já ta cadastrado;
        } catch (Exception ex) {
            return 3;//Deu qualquer outro erro;
        }
    }

    // Este método preenche a coluna de Acesso para o usuario logar no site, referente ao Cadastro dele.
    public void cadastrarAcesso(Acesso acesso) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(acesso);
            manager.getTransaction().commit();
        }catch (Exception ex) {
            
        }
    }
    
    // Este método ira criar um formulario, recebendo como parametro um OBJ Servico.
    public int criarForm(Servico servico) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(servico);
            manager.getTransaction().commit();
            return 1;
        } catch (NoResultException e) {
            return 2;
        }
    }

    // Este método criar um Cliente;
    public int criarCli(Cliente cliente) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(cliente);
            manager.getTransaction().commit();
            return 1;
        } catch (NoResultException e) {
            return 2;
        }
    }

    // Este método cria um Veiculo;
    public int criarVei(Veiculo veiculo) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(veiculo);
            manager.getTransaction().commit();
            return 1;
        } catch (NoResultException e) {
            return 2;
        }
    }
    
    public List<Servico> listarServico() {
        connect();
        try {
            TypedQuery<Servico> q = manager.createNamedQuery("Servico.findAll", Servico.class);//Query tirado da classe "Funcionario";
            List<Servico> servicos = q.getResultList();
            return servicos;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Servico> listarServicoTS(String tipoServ) {
        connect();
        try {
            TypedQuery<Servico> q = manager.createNamedQuery("Servico.findByTipoServico", Servico.class);//Query tirado da classe "Servico";
            q.setParameter("tipoServico", "%"+tipoServ+"%");
            List<Servico> servicos = q.getResultList();
            return servicos;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public List<Servico> listarServicoPlaca(String placa) {
        connect();
        try {
            TypedQuery<Servico> q = manager.createNamedQuery("Servico.findByPlacaVeiculo", Servico.class);//Query tirado da classe "Servico";
            q.setParameter("placa", "%"+placa+"%");
            List<Servico> servicos = q.getResultList();
            return servicos;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Servico> listarServicoNomeCli(String nomeCli) {
        connect();
        try {
            TypedQuery<Servico> q = manager.createNamedQuery("Servico.findByNomeCliente",Servico.class);
            q.setParameter("nomeCliente", "%" + nomeCli + "%");
            //Começar aqui.
            List<Servico> servicos = q.getResultList();
            return servicos;
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    
    public List<Servico> listarServicoData(String data) {
        connect();
        try {
            TypedQuery<Servico> q = manager.createNamedQuery("Servico.findByDataServico", Servico.class);//Query tirado da classe "Servico";
            q.setParameter("dataServico","%"+data+"%");
            List<Servico> servicos = q.getResultList();
            return servicos;
        } catch (NoResultException ex) {
            return null;
        }
    }
 
    public int excluirServico(int idServ) {
        connect();

        try {
            Servico serv = manager.find(Servico.class, idServ);
            if (serv == null) {
                return 2;//Nao Existe;
            } else {
                manager.getTransaction().begin();
                manager.remove(serv);//So aceita tipos Object;
                manager.getTransaction().commit();
                return 1;//Encontrados;
            }
        } catch (Exception ex) {
            return 0;//Nao encontrado;
        }

    }

    public int alterarServico(String tipoServ, String nomeCli, String emailCli, String cpfCli, String telefoneCli, String enderecoCli, String marcaVei, String modeloVei, String placaVei, String tipoVei, String anoVei, float valor, int idServ, int idCli) {
        connect();

        try {
            Servico serv = manager.find(Servico.class, idServ);
            Veiculo vei = manager.find(Veiculo.class, placaVei);
            Cliente cli = manager.find(Cliente.class, idCli);

            cli.setNome(nomeCli);
            cli.setEmail(emailCli);
            cli.setTelefone(telefoneCli);
            cli.setCpf(cpfCli);
            cli.setEndereco(enderecoCli);

            vei.setIdCliente(cli);
            vei.setAno(anoVei);
            vei.setMarca(marcaVei);
            vei.setModelo(modeloVei);
            vei.setPlaca(placaVei);
            vei.setTipo(tipoVei);

            serv.setPlaca(vei);
            serv.setTipoServico(tipoServ);
            serv.setValorServ(valor);

            manager.getTransaction().begin();
            manager.merge(serv);//So aceita tipos Object;
            manager.getTransaction().commit();
            return 1;//Encontrados;
        } catch (Exception ex) {
            return 0;//Nao encontrado;
        }

    }
}
