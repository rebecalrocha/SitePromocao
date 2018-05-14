<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Por Site</title>
    </head>
    <body>
        <h1>Lista de Promoções por Site</h1>
        
        <form action="VisualizarPromocaoSiteServlet">
            URL: <input name="URL" type="text" value="${sessionScope.VisualizarPromocaoSiteServlet.senha}" /><br/>
            Senha: <input name="senha" type="password" value="${sessionScope.VisualizarPromocaoSiteServlet.senha}" /><br/>
            <input type ="submit" value="Enviar"/>
            </form>
            <br/>
    </body>
</html>