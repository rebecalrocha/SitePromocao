<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirma Novo Site</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Novo Cadastro de Site de Reservas</h1>
        Confira se os dados estão corretos:
        <br/><br/>
        URL: ${sessionScope.CadastroSiteServlet.URL}<br/>
        Nome: ${sessionScope.CadastroSiteServlet.nome}<br/>
        Senha: ${sessionScope.CadastroSiteServlet.senha}<br/>
        Telefone: ${sessionScope.CadastroSiteServlet.telefone}<br/>
        <br/>
        <a href="GravarSiteServlet">Confirmar</a>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>
