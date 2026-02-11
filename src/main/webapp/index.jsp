<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sistema de Eventos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Gestão de Eventos</a>
        </div>
    </nav>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8 text-center">
                <h1 class="display-4 mb-4">Bem-vindo ao Sistema</h1>
                <p class="lead mb-5">Gerencie instituições e eventos de forma simples e automática.</p>
                
                <div class="row">
                    <div class="col-md-6">
                        <div class="card p-4">
                            <h3>Instituições</h3>
                            <p>Cadastre e gerencie as entidades parceiras.</p>
                            <a href="instituicao?action=list" class="btn btn-primary">Acessar</a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card p-4">
                            <h3>Eventos</h3>
                            <p>Controle datas e ativação automática de eventos.</p>
                            <a href="evento?action=list" class="btn btn-primary">Acessar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>