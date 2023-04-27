<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Empresas</h1>

<p>Usuario logado: ${usuarioLogado.login}</p>

<c:if test="${not empty empresa and not empty cnpj}">
    Empresa: ${empresa} cadastrada com sucesso!
    CNPJ: ${cnpj}
</c:if>

<ul>
    <c:forEach items="${empresas}" var="empresa">
        <li>
            Nome : ${empresa.nome}, CNPJ: ${empresa.cnpj}, Data de Cadastro - <fmt:formatDate
                value="${empresa.dataCadastro}"/>
            <a href="/root?acao=MostraEmpresa&id=${empresa.id}">atualizar</a>
            <a href="/root?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
        </li>
    </c:forEach>
</ul>

<c:import url="logout-parcial.jsp"/>
</body>
</html>
