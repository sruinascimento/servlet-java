<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/nova-empresa" var="link-form"/>

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
    <input type="text" id="empresa" name="empresa" value="${empresa.nome}"></br>

    <label for="cnpj">CNPJ</label>
    <input type="text" id="cnpj" name="cnpj" value="${empresa.cnpj}"></br>

    <input type="text" name="id" hidden="hidden" value="${empresa.id}"></br>

    <input type="text" name="acao" hidden="hidden" value="AlteraEmpresa">

    <input type="submit" value="atualizar" class="btn__form">
</form>

<c:import url="logout-parcial.jsp"/>

</body>
</html>