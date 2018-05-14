<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promocoes</title>
    </head>
    <body>
        <h1>Novo Site de Reservas</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
            <c:forEach items="${requestScope.mensagens}" var="mensagem">
                <li>${mensagem}</li>
            </c:forEach>
            </ul>
            <hr>
        </c:if>

        <form action="CadastroSiteServlet" method="post">
            Digite seus dados:<br/><br/>
            URL: <input name="URL" type="text" value="${sessionScope.CadastroSiteServlet.URL}" /><br/>
            Nome: <input name="nome" type="text" value="${sessionScope.CadastroSiteServlet.nome}" /><br/>
            Senha: <input name="senha" type="password" value="${sessionScope.CadastroSiteServlet.senha}" /><br/>
            Telefone: <input name="telefone" type="text" value="${sessionScope.CadastroSiteServlet.telefone}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
