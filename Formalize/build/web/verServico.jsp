<%-- 
    Document   : verServico
    Created on : 14 de jun. de 2023, 21:27:43
    Author     : solam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./styleFormulario.css">
        <title>Alterar Formulario</title>
    </head>
    <header>

        <h1>Forma<span>Lize</span></h1>



        <section id="home"></section>
        <ul aria-label="Navegação primaria" class="navegacao-primaria">
            <li><a class="dropbtn" style="color: #04AA6D" href="./indexUsuario.html" class="active">Home</a></li>
            <li><a class="dropbtn" href="./telaUsuario.html">Formularios</a></li>
            <li><a class="dropbtn" href="controle?flag=listarHistorico">Historico</a></li>
            <img src="img/login.png" alt="logo de login do usuario" class="perfil">
        </ul>

        <hr class="h"></hr>
    </header>
    <div class="form">
        <form method="POST" action="controle"><br>
            <input type="hidden" name="flag" value="alterarFormulario">
            <h1>Formulario</h1><br><br><br>

            <h2 style="margin-top: -40px">Cliente</h2><br><br>
            <input type="hidden" name="idServ" value="<%= request.getParameter("idServ")%>">
            <input type="hidden" name="idCli" value="<%= request.getParameter("idCli")%>">

            <label for="tiposerv">Tipo de Serviço:</label>
            <input type="text" name="tipoS" value="<%= request.getParameter("tipoServ")%>" readonly>

            <label for="valor">Valor:</label>
            <input type="text" pattern="[0-9]+([,\.][0-9]+)?" name="valor" size="10" value="<%= request.getParameter("valor")%>" readonly><br><br>

            <label for="nome">Nome:</label>
            <input type="text" size="40" name="nomeCliente" value="<%= request.getParameter("nomeCli")%>" readonly>

            <label for="cpf">CPF:</label>
            <input type="text" name="cpfCliente" value="<%= request.getParameter("cpfCli")%>" readonly><br><br>

            <label for="endereco">Endereço:</label>
            <input type="text" size="40" name="enderecoCliente" value="<%= request.getParameter("enderecoCli")%>" readonly>

            <label for="email">Email:</label>
            <input type="text" name="emailCliente" value="<%= request.getParameter("emailCli")%>" readonly><br><br>

            <label for="tel">Tel:</label>
            <input type="text" name="telefoneCliente" value="<%= request.getParameter("telefoneCli")%>" readonly><br><br>

            <h2>Veiculo</h2><br><br>

            <label for="marca">Marca:</label>
            <input type="text" name="marcaVeiculo" value="<%= request.getParameter("marcaVei")%>" readonly>

            <label for="modelo">Modelo:</label>
            <input type="text" name="modeloVeiculo" value="<%= request.getParameter("modeloVei")%>" readonly><br><br>

            <label for="placa">Placa:</label>
            <input type="text" name="placaVeiculo" value="<%= request.getParameter("placaVei")%>" readonly>

            <label for="tipo">Tipo:</label>
            <input type="text" name="tipoVeiculo" value="<%= request.getParameter("tipoVei")%>" readonly><br><br>

            <label for="ano">Ano:</label>
            <input type="text" size="15" name="anoVeiculo" value="<%= request.getParameter("anoVei")%>" readonly><br><br>

            <input type="submit" value="Enviar">&nbsp; &nbsp;
        </form>
    </div>

    <script src="./scriptFormulario.js"></script>
</body>
</html>
