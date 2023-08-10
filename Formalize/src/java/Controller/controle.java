/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Acesso;
import Model.Cliente;
import Model.Colaborador;
import Model.FormalizeDAO;
import Model.Servico;
import Model.Veiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author solam
 */
@WebServlet(name = "controle", urlPatterns = {"/controle"})
public class controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String flag, mensagem = "";
        FormalizeDAO dao = new FormalizeDAO();
        flag = request.getParameter("flag");
        HttpSession session = null;
        
        if(flag.equalsIgnoreCase("login")){
            String user ,password;
            user = request.getParameter("email");
            password = request.getParameter("senha");
            Acesso acesso = new FormalizeDAO().validarLogin(user, password);
            if(acesso == null){
                request.setAttribute("m", "Usuário não encontrado seu PATIFE >:C");
                RequestDispatcher disp = request.getRequestDispatcher("MensagensErro.jsp");
                disp.forward(request, response);
            }else{
                String nome, email;
                nome = acesso.getColaborador().getNome();
                email = acesso.getColaborador().getEmail();

                session = request.getSession();
                session.setAttribute("email", email);
                RequestDispatcher disp = request.getRequestDispatcher("telaUsuario.html");
                disp.forward(request, response);
            }
        }else if(flag.equalsIgnoreCase("cadastro")){
            String nome, sobrenome, email, senha, telefone;
            nome = request.getParameter("primeiroNome");
            sobrenome = request.getParameter("sobrenome");
            email = request.getParameter("email");
            senha = request.getParameter("password");
            telefone = request.getParameter("telefone");
            
            Acesso acesso = new Acesso();
            Colaborador colab = new Colaborador();
            
            colab.setEmail(email);
            colab.setNome(nome);
            colab.setTelefone(sobrenome);
            colab.setTelefone(telefone);
            
            acesso.setEmail(colab.getEmail());
            acesso.setSenha(senha);

            int resp = new FormalizeDAO().cadastrar(colab);
            
            if(resp == 1){
                mensagem = "Cadastrado com sucesso.";
                new FormalizeDAO().cadastrarAcesso(acesso);
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("telaUsuario.html");
                disp.forward(request, response);
            }else if(resp == 2){
                mensagem = "Este login já existe, por favor faça o login.";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("MensagensDeErro.jsp");
                disp.forward(request, response);
            }else if(resp == 3){
                mensagem = "Houve algum erro ao tentar cadastrar, por favor reporte ao suporte.";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("MensagensDeErro.jsp");
                disp.forward(request, response);
            }
            RequestDispatcher disp = request.getRequestDispatcher("historico.jsp");
            disp.forward(request, response);
        }else if (flag.equalsIgnoreCase("formulario")){
            
            Servico servico = new Servico();
            Veiculo veiculo = new Veiculo();
            Cliente cliente = new Cliente();
            Colaborador colab = new Colaborador();

            cliente.setNome(request.getParameter("nome"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setEndereco(request.getParameter("endereco"));
            cliente.setTelefone(request.getParameter("telefone"));
            int resp1 = new FormalizeDAO().criarCli(cliente);

            veiculo.setPlaca(request.getParameter("placa"));
            veiculo.setIdCliente(cliente);
            veiculo.setMarca(request.getParameter("marca"));
            veiculo.setModelo(request.getParameter("modelo"));
            veiculo.setTipo(request.getParameter("tipo"));
            veiculo.setAno(request.getParameter("ano"));

            int resp2 = new FormalizeDAO().criarVei(veiculo);

            servico.setTipoServico(request.getParameter("tipoS"));
            float valor = Float.parseFloat(request.getParameter("valor").replace(',', '.'));//Convertendo para float o 'text' do formulario;
            servico.setValorServ(valor);
            servico.setPlaca(veiculo);
            Date data = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = formato.format(data);
            servico.setDataServico(dataFormatada);
            String emaill;
            session = request.getSession(false);
            if (session != null) {
                emaill = (String) session.getAttribute("email");
                colab.setEmail(emaill);
            } else {
                response.sendRedirect("indexUsuario.html");
            }

            servico.setEmail(colab);

            int resp = new FormalizeDAO().criarForm(servico);

            switch (resp) {
                case 1:
                    mensagem = "Formulario salvo com sucesso";
                    break;
                case 2:
                    mensagem = "Erro ao tentar criar";
                    break;
                default:
                    mensagem = "Entre em contato com o administrador";
                    break;
            }
            
            RequestDispatcher disp = request.getRequestDispatcher("telaUsuario.html");
            disp.forward(request, response);
        }else if(flag.equalsIgnoreCase("listarHistorico")){
            
            List<Servico> servico = dao.listarServico();
            request.setAttribute("listarServicos", servico);
            RequestDispatcher disp = request.getRequestDispatcher("historico.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("excluirServico")) {
            
            int idServ = Integer.parseInt(request.getParameter("idServ"));
            int resultado = dao.excluirServico(idServ);
            if (resultado == 1) {
                mensagem = "Servico excluído com sucesso";
            } else if (resultado == 2) {
                mensagem = "Servico '" + idServ + "' nao existe";
            } else {
                mensagem = "Erro ao tentar excluir o Servico";
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("telaUsuario.html");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("alterarFormulario")) {

            String tipoServ, nomeCli, emailCli, cpfCli, telefoneCli, enderecoCli, marcaVei, modeloVei, placaVei, tipoVei, anoVei;
            float valor;
            int idServ, idCli;
            tipoServ = request.getParameter("tipoS");
            nomeCli = request.getParameter("nomeCliente");
            emailCli = request.getParameter("emailCliente");
            cpfCli = request.getParameter("cpfCliente");
            telefoneCli = request.getParameter("telefoneCliente");
            enderecoCli = request.getParameter("enderecoCliente");
            marcaVei = request.getParameter("marcaVeiculo");
            modeloVei = request.getParameter("modeloVeiculo");
            placaVei = request.getParameter("placaVeiculo");
            tipoVei = request.getParameter("tipoVeiculo");
            anoVei = request.getParameter("anoVeiculo");
            valor = Float.parseFloat(request.getParameter("valor"));
            idServ = Integer.parseInt(request.getParameter("idServ"));
            idCli = Integer.parseInt(request.getParameter("idCli"));

            System.out.println(tipoServ+" "+ nomeCli+" "+ emailCli);
            int resultado = dao.alterarServico(tipoServ, nomeCli, emailCli, cpfCli, telefoneCli, enderecoCli, marcaVei, modeloVei, placaVei, tipoVei, anoVei, valor, idServ, idCli);
            if (resultado == 1) {
                mensagem = "Formulario alterado com sucesso";
          
            } else {
                mensagem = "Erro ao tentar alterar dados do Formulario";
            }

            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("telaUsuario.html");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("filtrarFormulario")) {
            String opcoes = request.getParameter("opcoes");
            String filtro = request.getParameter("filtrar");
            
            if (opcoes.equalsIgnoreCase("tipoServ")) {
                List<Servico> servico = dao.listarServicoTS(filtro);
                request.setAttribute("listarServicos", servico);
                RequestDispatcher disp = request.getRequestDispatcher("historico.jsp");
                disp.forward(request, response);
                
            } else if (opcoes.equalsIgnoreCase("data")) {
                List<Servico> servico = dao.listarServicoData(filtro);
                request.setAttribute("listarServicos", servico);
                RequestDispatcher disp = request.getRequestDispatcher("historico.jsp");
                disp.forward(request, response);

            } else if (opcoes.equalsIgnoreCase("nomeCli")) {
                List<Servico> servico = dao.listarServicoNomeCli(filtro);
                request.setAttribute("listarServicos", servico);
                RequestDispatcher disp = request.getRequestDispatcher("historico.jsp");
                disp.forward(request, response);
                
            } else if (opcoes.equalsIgnoreCase("placa")) {
                List<Servico> servico = dao.listarServicoPlaca(filtro);
                request.setAttribute("listarServicos", servico);
                RequestDispatcher disp = request.getRequestDispatcher("historico.jsp");
                disp.forward(request, response);
            }
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
