<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:remove scope="session" var="CadastroSites" />
<c:remove scope="session" var="CadastroHoteis" />
<c:remove scope="session" var="CriarPromocao" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promoções</title>
    </head>
    
        <h1>Criação de Promoções de Quarto de Hotel em Sites de Reservas </h1>
        <hr>
         <c:if test="${!empty mensagem}">
            ${mensagem}
            <hr>
        </c:if>
        <p class="paragrafo">Seja Bem Vindo à Atividade Avaliativa 1 da Rebeca Lima Rocha. O que deseja fazer?</p><br/>

        
        <a href="Loggin_sites_admin.jsp">Cadastro de site de reserva</a><br/>
        <a href="Loggin_hoteis_admin.jsp">Cadastro de hotél</a><br/><br/>
        
        <a href="VisualizarSiteServlet">Listagem de todos os sites de reservas</a><br/>
        <a href="VisualizarHotelServlet">Listagem de todos os hotéis</a><br/>
        <a href="EscolherCidade.jsp">Listagem de todos os hotéis por cidade</a><br/><br/>
        
        <a href="Loggin_promocao_hotel.jsp">Criação de uma promoção de um hotel</a><br/>
        <a href="EscolherHotel.jsp">Listagem de todas as promoções de um hotel</a><br/>
        <a href="EscolherSite.jsp">Listagem de todas as promoções de um site de reservas</a><br/>
        
    </body>
</html>
