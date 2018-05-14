<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Promoções</title>
    </head>
    <body>
        <h1>Lista de Todas as Promoções deste Site</h1>
        <hr>
        <c:if test="${empty requestScope.listaPromocoes}">
            Não há promoções cadastradas!
        </c:if>
        <c:if test="${!empty requestScope.listaPromocoes}">
            <table>
                <tr>
                    <th>CNPJ</th>
                    <th>URL</th>
                    <th>Preco</th>
                    <th>Data Inicial</th>
                    <th>Data Final</th>
                </tr>
                <c:forEach items="${requestScope.listaPromocoes}" var="promocao">
                    <tr>
                        <td>${promocao.hotel.CNPJ}</td>
                        <td>${promocao.site.URL}</td>
                        <td>${promocao.preco}</td>
                        <td>${promocao.dataInicial}</td>
                        <td>${promocao.dataFinal}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
