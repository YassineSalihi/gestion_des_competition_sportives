<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Participants</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

<jsp:include page="navbar.jsp" />

<h2>Liste des participants</h2>
<table class="table table-bordered">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Catégorie</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="p" items="${participants}">
            <tr>
                <td>${p.id}</td>
                <td>${p.nom}</td>
                <td>${p.categorie}</td>
                <td>
                    <a href="participants?action=edit&id=${p.id}" class="btn btn-warning btn-sm">Modifier</a>
                    <form action="participants" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete" />
                        <input type="hidden" name="id" value="${p.id}" />
                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Supprimer ?')">Supprimer</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<h3>Ajouter un participant</h3>
<form action="participants" method="post">
    <input type="hidden" name="action" value="create" />
    <div class="mb-2">
        <input type="text" name="nom" placeholder="Nom" class="form-control" required />
    </div>
    <div class="mb-2">
        <input type="text" name="categorie" placeholder="Catégorie" class="form-control" required />
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>

</body>
</html>
