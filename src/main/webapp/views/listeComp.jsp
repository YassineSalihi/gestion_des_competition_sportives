<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des compétitions</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

    <jsp:include page="navbar.jsp" />

    <h2>Liste des Compétitions</h2>
    <table class="table table-striped">
        <thead>
            <tr><th>Nom</th><th>Type</th><th>Date Début</th><th>Date Fin</th></tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${competitions}">
                <tr>
                    <td>${c.nom}</td>
                    <td>${c.type}</td>
                    <td>${c.dateDebut}</td>
                    <td>${c.dateFin}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
