<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Hotel</title>
    </head>
    <body>
        <h1>Novo Cadastro de Hotel</h1>
        Confira se os dados estão corretos:
        <br/><br/>
        CNPJ: ${sessionScope.CadastroHotelServlet.CNPJ}<br/>
        Nome: ${sessionScope.CadastroHotelServlet.nome}<br/>
        Senha: ${sessionScope.CadastroHotelServlet.senha}<br/>
        Cidade: ${sessionScope.CadastroHotelServlet.cidade}<br/>
        <br/>
        <a href="GravarHotelServlet">Confirmar</a>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>

