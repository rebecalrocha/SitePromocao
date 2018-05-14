<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Promocao</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Nova Promoção</h1>
        Confira se os dados estão corretos:
        <br/><br/>
        CNPJ: ${sessionScope.CriarPromocaoServlet.CNPJ}<br/>
        URL: ${sessionScope.CriarPromocaoServlet.URL}<br/>
        Preco: ${sessionScope.CriarPromocaoServlet.preco}<br/>
        Data Inicial: ${sessionScope.CriarPromocaoServlet.dataInicial}<br/>
        Data Final: ${sessionScope.CriarPromocaoServlet.dataFinal}<br/>
        <br/>
        <a href="GravarPromocaoServlet">Confirmar</a>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>
