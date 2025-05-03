<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Éditer une Compétition</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<jsp:include page="navbar.jsp" />

<h2 class="mb-4">${competition != null ? "Modifier" : "Ajouter"} une Compétition</h2>

<form method="post" action="${pageContext.request.contextPath}/competitions">
    <c:if test="${competition != null}">
        <input type="hidden" name="id" value="${competition.id}" />
    </c:if>

    <div class="mb-3">
        <label>Nom</label>
        <input type="text" name="nom" class="form-control"
               value="${competition.nom != null ? competition.nom : ''}" required />
    </div>

    <div class="mb-3">
        <label>Type</label>
        <input type="text" name="type" class="form-control"
               value="${competition.type != null ? competition.type : ''}" required />
    </div>

    <div class="mb-3">
        <label>Date début</label>
        <input type="date" name="dateDebut" class="form-control"
               value="${competition.dateDebut != null ? competition.dateDebut.toString().substring(0,10) : ''}" required />
    </div>

    <div class="mb-3">
        <label>Date fin</label>
        <input type="date" name="dateFin" class="form-control"
               value="${competition.dateFin != null ? competition.dateFin.toString().substring(0,10) : ''}" required />
    </div>

    <button type="submit" class="btn btn-success">Enregistrer</button>
    <a href="${pageContext.request.contextPath}/competitions" class="btn btn-secondary">Annuler</a>
</form>

</body>
</html>
