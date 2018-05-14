<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Por Hotel</title>
    </head>
    <body>
        <h1>Lista de Promoções por Hotel</h1>
        
        <form action="VisualizarPromocaoHotelServlet">
            CNPJ: <input name="CNPJ" type="text" value="${sessionScope.VisualizarPromocaoHotelServlet.CNPJ}" /><br/>
            Senha: <input name="senha" type="password" value="${sessionScope.VisualizarPromocaoHotelServlet.senha}" /><br/>
            <input type ="submit" value="Enviar"/>
            </form>
            <br/>
    </body>
</html>
