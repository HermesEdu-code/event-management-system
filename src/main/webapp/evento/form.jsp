<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cadastro de Evento</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body class="bg-light">
    <nav class="navbar navbar-expand-lg navbar-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="../index.jsp">Gestão de Eventos</a>
        </div>
    </nav>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-7">
                <div class="card shadow">
                    <div class="card-header bg-white py-3">
                        <h5 class="mb-0 text-primary">${evento.id == null ? 'Novo Evento' : 'Editar Evento'}</h5>
                    </div>
                    <div class="card-body">
                        <form action="evento" method="post">
                            <input type="hidden" name="id" value="${evento.id}">
                            
                            <div class="mb-3">
                                <label class="form-label">Nome do Evento</label>
                                <input type="text" name="nome" class="form-control" value="${evento.nome}" placeholder="Ex: Assembleia Geral" required>
                            </div>

                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <label class="form-label">Data Inicial</label>
                                    <input type="date" name="dataInicial" class="form-control" value="${evento.dataInicial}" required>
                                </div>
                                <div class="col-md-6">
                                    <label class="form-label">Data Final</label>
                                    <input type="date" name="dataFinal" class="form-control" value="${evento.dataFinal}" required>
                                </div>
                            </div>

                            <div class="mb-4">
                                <label class="form-label">Instituição Responsável</label>
                                <select name="instituicaoId" class="form-select" required>
                                    <option value="">Selecione uma instituição...</option>
                                    <c:forEach var="inst" items="${instituicoes}">
                                        <option value="${inst.id}" ${inst.id == evento.instituicaoId ? 'selected' : ''}>
                                            ${inst.nome} (${inst.tipo})
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-primary">Salvar Evento</button>
                                <a href="evento?action=list" class="btn btn-outline-secondary">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>