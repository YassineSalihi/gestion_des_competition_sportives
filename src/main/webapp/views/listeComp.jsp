<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Compétitions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<jsp:include page="navbar.jsp" />

<h2 class="mb-4">Liste des Compétitions</h2>

<a href="competitions?action=edit" class="btn btn-success mb-3">+ Nouvelle Compétition</a>

<table class="table table-bordered">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Type</th>
            <th>Date début</th>
            <th>Date fin</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${competitions}">
        <tr>
            <td>${c.id}</td>
            <td>${c.nom}</td>
            <td>${c.type}</td>
            <td>${c.dateDebut}</td>
            <td>${c.dateFin}</td>
            <td>
                <a href="competitions?action=edit&id=${c.id}" class="btn btn-primary btn-sm">Modifier</a>
                <a href="competitions?action=delete&id=${c.id}" class="btn btn-danger btn-sm"
                   onclick="return confirm('Confirmer la suppression ?')">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
