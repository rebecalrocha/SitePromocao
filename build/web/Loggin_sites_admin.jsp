<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Site</title>
    </head>
    <body>
        <h1>Autentificação</h1>
        
        <form action="UsuarioServlet" method="post">
            <br/>
            Login: <input name="login" type="text" value="${sessionScope.usuario.login}" /><br/>
            Senha: <input name="senha" type="text" value="${sessionScope.usuario.senha}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
</html>