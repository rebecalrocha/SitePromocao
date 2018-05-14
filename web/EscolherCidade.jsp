<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Por Cidade</title>
    </head>
    <body>
        <h1>Lista de Hotéis por Cidade</h1>
        
        <form action="VisualizarHotelCidadeServlet">
            Cidade: <input name="cidade" type="text" value="" /><br/><br/>
            <input type ="submit" value="enviar"/>
            </form>
            <br/>
    </body>
</html>

