<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Hotéis</title>
    </head>
    <body>
        <h1>Lista de Todos os Hotéis</h1>
        <hr>
        <c:if test="${empty requestScope.listaHoteis}">
            Não há hotéis cadastrados!
        </c:if>
        <c:if test="${!empty requestScope.listaHoteis}">
            <table>
                <tr>
                    <th>CNPJ</th>
                    <th>Nome</th>
                    <th>Cidade</th>
                </tr>
                <c:forEach items="${requestScope.listaHoteis}" var="hotel">
                    <tr>
                        <td>${hotel.CNPJ}</td>
                        <td>${hotel.nome}</td>
                        <td>${hotel.cidade}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
