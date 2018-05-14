<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Sites</title>
    </head>
    <body>
        <h1>Lista de Todos os Sites</h1>
        <hr>
        <c:if test="${empty requestScope.listaSites}">
            Não há sites cadastrados!
        </c:if>
        <c:if test="${!empty requestScope.listaSites}">
            <table>
                <tr>
                    <th>URL</th>
                    <th>Nome</th>
                    <th>Senha</th>
                    <th>Telefone</th>
                </tr>
                <c:forEach items="${requestScope.listaSites}" var="site">
                    <tr>
                        <td>${site.URL}</td>
                        <td>${site.nome}</td>
                        <td>${site.senha}</td>
                        <td>${site.telefone}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
