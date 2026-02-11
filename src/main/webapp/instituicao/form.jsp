<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Instituição</title>
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
            <div class="col-md-6">
                <div class="card shadow">
                    <div class="card-header bg-white py-3">
                        <h5 class="mb-0 text-primary">${instituicao.id == null ? 'Nova Instituição' : 'Editar Instituição'}</h5>
                    </div>
                    <div class="card-body">
                        <form action="instituicao" method="post">
                            <input type="hidden" name="id" value="${instituicao.id}">
                            
                            <div class="mb-3">
                                <label class="form-label">Nome da Instituição</label>
                                <input type="text" name="nome" class="form-control" value="${instituicao.nome}" required>
                            </div>

                            <div class="mb-4">
                                <label class="form-label">Tipo</label>
                                <select name="tipo" class="form-select" required>
                                    <option value="">Selecione...</option>
                                    <option value="Confederação" ${instituicao.tipo == 'Confederação' ? 'selected' : ''}>Confederação</option>
                                    <option value="Singular" ${instituicao.tipo == 'Singular' ? 'selected' : ''}>Singular</option>
                                    <option value="Central" ${instituicao.tipo == 'Central' ? 'selected' : ''}>Central</option>
                                    <option value="Cooperativa" ${instituicao.tipo == 'Cooperativa' ? 'selected' : ''}>Cooperativa</option>
                                </select>
                            </div>

                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-primary">Salvar Dados</button>
                                <a href="instituicao?action=list" class="btn btn-outline-secondary">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>