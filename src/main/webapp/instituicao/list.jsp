<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Instituições</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="../index.jsp">Gestão de Eventos</a>
        </div>
    </nav>

    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Instituições</h2>
            <a href="instituicao?action=new" class="btn btn-success">+ Nova Instituição</a>
        </div>

        <div class="card">
            <div class="card-body p-0">
                <table class="table table-hover mb-0">
                    <thead class="table-light">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Tipo</th>
                            <th class="text-center">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="inst" items="${instituicoes}">
                            <tr>
                                <td>${inst.id}</td>
                                <td>${inst.nome}</td>
                                <td>${inst.tipo}</td>
                                <td class="text-center">
                                    <a href="instituicao?action=edit&id=${inst.id}" class="btn btn-sm btn-outline-primary">Editar</a>
                                    <a href="instituicao?action=delete&id=${inst.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('Excluir?')">Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="mt-3">
            <a href="../event-management-system/" class="btn btn-light">Voltar ao Início</a>
        </div>
    </div>
</body>
</html>