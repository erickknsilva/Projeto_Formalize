<%-- 
    Document   : listarHistorico
    Created on : 14 de jun. de 2023, 16:11:44
    Author     : solam
--%>

<%@page import="Model.Servico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./styleHistorico.css">
        <title>Consutar Historico</title>
        <link rel="stylesheet" href="./style.css">
    </head>
    <body>
        <header>

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
        <%
            List<Servico> listaServicos = (List<Servico>) request.getAttribute("listarServicos");
        %>

        <table>
            <tr>
                <th>Tipo Serviço</th>
                <th>Nome</th>
                <th>Marca</th>
                <th>Placa</th>
                <th>Valor</th>
                <th>Data</th>
            </tr>

            <%
                for (Servico servico : listaServicos) {
            %>
            <tr>
                <td><%= servico.getTipoServico()%></td>//<%--tag usada para exibir (<%= %> --%>
                <td><%= servico.getPlaca().getIdCliente().getNome()%></td>
                <td><%= servico.getPlaca().getModelo() %></td>
                <td><%= servico.getPlaca().getPlaca()%></td>
                <td><%= servico.getValorServ()%></td>
                <td><%= servico.getDataServico()%></td>
                <td>
                    <button class="btn btn-edit">Editar</button>
                    <button class="btn btn-delete">Excluir</button>
                    <button class="btn btn-ver">Ver</button>
                </td>
            </tr>
            <%
                }
            %>
        </table>

        <footer>
            <p style="font-size: 16px;"><strong> &#169;Grupo 4</strong></p>
        </footer>
    </body>
</html>
