<%-- Document : historico Created on : 14 de jun. de 2023, 16:42:51 Author : solam --%>

<%@page import="java.util.List" %>
<%@page import="Model.Servico" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css">
        <link rel="stylesheet" href="./styleHistorico.css">
        <title>JSP Page</title>
    </head>

    <body>

        <header style="margin-bottom: 100px">

            <h1>Forma<span>Lize</span></h1>

            <section id="home"></section>

            <nav>
                <div class="topnav" id="myTopnav">
                    <div class="dropdown">
                        <a class="dropbtn" style="color: #04AA6D" href="./indexUsuario.html" class="active">Home</a>
                    </div>
                    <div class="dropdown">
                        <a class="dropbtn" href="./telaUsuario.html">Formularios</a>

                    </div>

                    <div class="dropdown">
                        <a class="dropbtn" href="controle?flag=listarHistorico">Historico</a>
                    </div>
                    <div class="dropdown">
                        <a class="dropbtn" href="#perfil"><img width="24px" class="img-icon" src="./img/login.png"
                                                               alt="logo de login do usuario" class="perfil"></a>
                    </div>
                    <a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
                </div>
            </nav>
        </header>

        <form method="POST" action="controle">
            <input type="hidden" name="flag" value="filtrarFormulario" />
            <div class="search-bar">
                <input name="filtrar" type="text" placeholder="Pesquisar...">
                <select name="opcoes" id="filto">
                    <option value="tipoServ">Tipo de Serviço</option>
                    <option value="data">Data</option>
                    <option value="nomeCli">Nome do Cliente</option>
                    <option value="placa">Placa</option>
                </select>
                <button type="submit" value="Pesquisar" class="btn">Buscar</button>
            </div>

            <% List<Servico> listaServicos = (List<Servico>) request.getAttribute("listarServicos");
            %>

            <table>
                <tr>
                    <th>Tipo Serviço</th>
                    <th>Nome</th>
                    <th>Marca</th>
                    <th>Placa</th>
                    <th>Valor</th>
                    <th>Data</th> 
                    <th>Editar</th>
                    <th>Ver</th>
                    <th>Excluir</th>
                </tr>

                <% for (Servico servico : listaServicos) {%>
                <tr>
                    <td>
                        <%= servico.getTipoServico()%>
                    </td><%--tag usada para exibir (<%=%> --%>
                    <td>
                        <%= servico.getPlaca().getIdCliente().getNome()%>
                    </td>
                    <td><%= servico.getPlaca().getMarca()%></td>
                    <td>
                        <%= servico.getPlaca().getPlaca()%>
                    </td>
                    <td>
                        <%= servico.getValorServ()%>
                    </td>
                    <td>
                        <%= servico.getDataServico()%>
                    </td>
                    <td><a href="alterarServico.jsp?tipoServ=<%= servico.getTipoServico()%>&nomeCli=<%= servico.getPlaca().getIdCliente().getNome()%>&emailCli=<%= servico.getPlaca().getIdCliente().getEmail()%>&cpfCli=<%= servico.getPlaca().getIdCliente().getCpf()%>&telefoneCli=<%= servico.getPlaca().getIdCliente().getTelefone()%>&enderecoCli=<%= servico.getPlaca().getIdCliente().getEndereco()%>&marcaVei=<%= servico.getPlaca().getMarca()%>&modeloVei=<%= servico.getPlaca().getModelo()%>&placaVei=<%= servico.getPlaca().getPlaca()%>&tipoVei=<%= servico.getPlaca().getTipo()%>&anoVei=<%= servico.getPlaca().getAno()%>&valor=<%= servico.getValorServ()%>&idServ=<%= servico.getIdServico()%>&idCli=<%= servico.getPlaca().getIdCliente().getIdCliente()%>"><img src="./img/editar-informacao.png" width="30px"/></a></td>
                    <td><a href="verServico.jsp?tipoServ=<%= servico.getTipoServico()%>&nomeCli=<%= servico.getPlaca().getIdCliente().getNome()%>&emailCli=<%= servico.getPlaca().getIdCliente().getEmail()%>&cpfCli=<%= servico.getPlaca().getIdCliente().getCpf()%>&telefoneCli=<%= servico.getPlaca().getIdCliente().getTelefone()%>&enderecoCli=<%= servico.getPlaca().getIdCliente().getEndereco()%>&marcaVei=<%= servico.getPlaca().getMarca()%>&modeloVei=<%= servico.getPlaca().getModelo()%>&placaVei=<%= servico.getPlaca().getPlaca()%>&tipoVei=<%= servico.getPlaca().getTipo()%>&anoVei=<%= servico.getPlaca().getAno()%>&valor=<%= servico.getValorServ()%>&idServ=<%= servico.getIdServico()%>&idCli=<%= servico.getPlaca().getIdCliente().getIdCliente()%>"><img src="./img/bola-de-olho.png" width="30px"/></a></td>
                    <td><a href="controle?flag=excluirServico&idServ=<%= servico.getIdServico()%>"><img src="./img/excluirrr.png" width="30px"/></a></td>
                </tr>

                <% }%>
            </table>
            <form />

            <footer style="margin-top: 100px">
                <p style="font-size: 16px;"><strong> &#169;Grupo 3</strong></p>
            </footer>
    </body>

</html>