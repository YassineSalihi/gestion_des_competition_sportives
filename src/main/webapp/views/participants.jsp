<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Participants</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

    <jsp:include page="navbar.jsp" />

    <h2>Liste des Participants</h2>
    <table class="table table-striped">
        <thead>
            <tr><th>Nom</th><th>Catégorie</th></tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${participants}">
                <tr>
                    <td>${p.nom}</td>
                    <td>${p.categorie}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
