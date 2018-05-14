<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promocoes</title>
    </head>
    <body>
        <h1>Novo Hotel</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
            <c:forEach items="${requestScope.mensagens}" var="mensagem">
                <li>${mensagem}</li>
            </c:forEach>
            </ul>
            <hr>
        </c:if>

        <form action="CadastroHotelServlet" method="post">
            Digite seus dados:<br/><br/>
            CNPJ: <input name="CNPJ" type="text" value="${sessionScope.CadastroHotelServlet.CNPJ}" /><br/>
            Nome: <input name="nome" type="text" value="${sessionScope.CadastroHotelServlet.nome}" /><br/>
            Senha: <input name="senha" type="password" value="${sessionScope.CadastroHotelServlet.senha}" /><br/>
            Cidade: <input name="cidade" type="text" value="${sessionScope.CadastroHotelServlet.cidade}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
