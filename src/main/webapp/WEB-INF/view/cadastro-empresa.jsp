<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
    <link rel="stylesheet" href="../../styles/sytle.css">
</head>
<body>

<form action="/root" method="POST">

    <label for="empresa">Nome</label>
    <input type="text" id="empresa" name="empresa"></br>

    <label for="cnpj">CNPJ</label>
    <input type="text" id="cnpj" name="cnpj"></br>

    <input type="text" name="acao" hidden="hidden" value="NovaEmpresa">


    <input type="submit" value="cadastrar" class="btn__form">
</form>

<c:import url="logout-parcial.jsp"/>

</body>
</html>