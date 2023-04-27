<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/root" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
    <link rel="stylesheet" href="../../styles/sytle.css">
</head>
<body>

<form action="${linkEntradaServlet}" method="POST">

    <label for="login">usuario</label>
    <input type="text" id="login" name="login"></br>

    <label for="senha">senha</label>
    <input type="password" id="senha" name="senha"></br>

    <input type="text" hidden="hidden" name="acao" value="LoginUsuario">

    <input type="submit" value="login" class="btn__form">
</form>
</body>
</html>