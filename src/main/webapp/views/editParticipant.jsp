<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Modifier Participant</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

<jsp:include page="navbar.jsp" />

<h2>Modifier Participant</h2>
<form action="participants" method="post">
    <input type="hidden" name="action" value="update" />
    <input type="hidden" name="id" value="${participant.id}" />

    <div class="mb-2">
        <label>Nom :</label>
        <input type="text" name="nom" class="form-control" value="${participant.nom}" required />
    </div>

    <div class="mb-2">
        <label>Catégorie :</label>
        <input type="text" name="categorie" class="form-control" value="${participant.categorie}" required />
    </div>

    <button type="submit" class="btn btn-success">Enregistrer</button>
    <a href="participants" class="btn btn-secondary">Annuler</a>
</form>

</body>
</html>
