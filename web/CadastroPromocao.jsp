<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promocoes</title>
    </head>
    <body>
        <h1>Nova Promoção</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
            <c:forEach items="${requestScope.mensagens}" var="mensagem">
                <li>${mensagem}</li>
            </c:forEach>
            </ul>
            <hr>
        </c:if>   
    
        <form action="CriarPromocaoServlet" method="post">
            <!-- $ {sessionScope.CriarPromocaoServlet.CNPJ} = (String)session.getAttribute"CNPJ"); --> 
            Digite seus dados:<br/><br/>
            CNPJ: <input name="CNPJ" type="text" value="${sessionScope.CriarPromocaoServlet.CNPJ}" /><br/>
            URL: <input name="URL" type="text" value="${sessionScope.CriarPromocaoServlet.URL}" /><br/>
            Preco: <input name="preco" type="text" value="${sessionScope.CriarPromocaoServlet.preco}" /><br/>
            Data Inicial: <input name="dataInicial" type="text" value="${sessionScope.CriarPromocaoServlet.dataInicial}" /><br/>
            Data Final: <input name="dataFinal" type="text" value="${sessionScope.CriarPromocaoServlet.dataFinal}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
