<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Promoção</title>
    </head>
    <body>
        <h1>Autentificação</h1>

        <form action="VerificaCNPJ" method="post">
            <br/>
            Login (CNPJ): <input name="CNPJ" type="text" value="${sessionScope.VerificaCNPJ.CNPJ}" /><br/>
            Senha: <input name="senha" type="password" value="${sessionScope.VerificaCNPJ.senha}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>