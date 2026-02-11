<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Eventos</title>
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
            <h2>Lista de Eventos</h2>
            <a href="evento?action=new" class="btn btn-success">+ Novo Evento</a>
        </div>

        <div class="card" id="tabelaEventosContainer">
            <div class="card-body p-0">
                <table class="table table-hover mb-0">
                    <thead class="table-light">
                        <tr>
                            <th>Nome</th>
                            <th>Instituição</th>
                            <th>Início</th>
                            <th>Fim</th>
                            <th>Status</th>
                            <th class="text-center">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="evento" items="${eventos}">
                            <tr>
                                <td>${evento.nome}</td>
                                <td>${evento.nomeInstituicao}</td>
                                <td>${evento.dataInicial}</td>
                                <td>${evento.dataFinal}</td>
                                <td>
                                    <span class="badge ${evento.ativo ? 'bg-success' : 'bg-secondary'}">
                                        ${evento.ativo ? 'Ativo' : 'Inativo'}
                                    </span>
                                </td>
                                <td class="text-center">
                                    <a href="evento?action=edit&id=${evento.id}" class="btn btn-sm btn-outline-primary">Editar</a>
                                    <a href="evento?action=delete&id=${evento.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('Excluir?')">Excluir</a>
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

    <!-- Script para atualização automática via AJAX -->
    <script>
        function atualizarTabela() {

            fetch('evento?action=list')
                .then(response => response.text())
                .then(html => {

                    const parser = new DOMParser();
                    const doc = parser.parseFromString(html, 'text/html');

                    const novaTabela = doc.getElementById('tabelaEventosContainer').innerHTML;

                    document.getElementById('tabelaEventosContainer').innerHTML = novaTabela;
                    console.log("Status dos eventos sincronizados com o servidor...");
                })
                .catch(err => console.warn('Erro ao sincronizar tabela:', err));
        }

        // Executa a atualização a cada 30 segundos
        setInterval(atualizarTabela, 30000);
    </script>
</body>
</html>