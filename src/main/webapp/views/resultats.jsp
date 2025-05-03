<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Résultats</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

<jsp:include page="navbar.jsp" />

<h2>${editResultat != null ? "Modifier" : "Ajouter"} un Résultat</h2>

<form method="post" action="resultats" class="mb-4">
    <c:if test="${editResultat != null}">
        <input type="hidden" name="id" value="${editResultat.id}" />
    </c:if>

    <div class="mb-3">
        <label>Compétition :</label>
        <select name="competition_nom" class="form-control" required>
            <c:forEach var="c" items="${competitions}">
                <option value="${c.nom}" ${editResultat != null && editResultat.competition.nom == c.nom ? 'selected' : ''}>${c.nom}</option>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label>Participant :</label>
        <select name="participant_nom" class="form-control" required>
            <c:forEach var="p" items="${participants}">
                <option value="${p.nom}" ${editResultat != null && editResultat.participant.nom == p.nom ? 'selected' : ''}>${p.nom}</option>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label>Score :</label>
        <input type="number" name="score" step="0.01" class="form-control"
               value="${editResultat != null ? editResultat.score : ''}" required />
    </div>

    <button type="submit" class="btn btn-${editResultat != null ? "warning" : "primary"}">
        ${editResultat != null ? "Mettre à jour" : "Soumettre"}
    </button>
</form>

<h3 class="mt-5">Résultats enregistrés</h3>
<!-- 🔍 Recherche -->
<div class="mb-3">
    <input type="text" id="searchInput" class="form-control" placeholder="Rechercher...">
</div>

<!-- 📂 Filtre -->
<div class="mb-3">
    <label for="filtreCompetition">Filtrer par compétition :</label>
    <select id="filtreCompetition" class="form-select">
        <option value="">-- Toutes --</option>
        <c:forEach var="c" items="${competitions}">
            <option value="${c.nom}">${c.nom}</option>
        </c:forEach>
    </select>
</div>

<table class="table table-bordered" id="resultatsTable">
    <thead>
        <tr>
            <th>Compétition</th>
            <th>Participant</th>
            <th>Score</th>
            <th>Actions</th>
        </tr>
    </thead>



    <tbody>
        <c:forEach var="r" items="${resultats}">
            <tr>
                <td>${r.competition.nom}</td>
                <td>${r.participant.nom}</td>
                <td>${r.score}</td>
                <td>
                    <a href="resultats?action=edit&id=${r.id}" class="btn btn-sm btn-warning">Modifier</a>
                    <a href="resultats?action=delete&id=${r.id}" class="btn btn-sm btn-danger"
                       onclick="return confirm('Supprimer ce résultat ?')">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script>
    window.onload = function () {

        // 🔍 Recherche
        document.getElementById("searchInput").addEventListener("keyup", function () {
            const search = this.value.toLowerCase();
            document.querySelectorAll("#resultatsTable tbody tr").forEach(row => {
                row.style.display = row.textContent.toLowerCase().includes(search) ? "" : "none";
            });
        });

        // 📂 Filtrage
        document.getElementById("filtreCompetition").addEventListener("change", function () {
            const filtre = this.value.toLowerCase();
            document.querySelectorAll("#resultatsTable tbody tr").forEach(row => {
                const competition = row.children[0].textContent.toLowerCase();
                row.style.display = (!filtre || competition.includes(filtre)) ? "" : "none";
            });
        });

        // 📄 Pagination
        const rowsPerPage = 5;
        const rows = document.querySelectorAll("#resultatsTable tbody tr");
        const totalPages = Math.ceil(rows.length / rowsPerPage);
        const paginationDiv = document.createElement("div");
        paginationDiv.className = "mt-3";
        document.getElementById("resultatsTable").after(paginationDiv);

        function afficherPage(page) {
            rows.forEach((row, i) => {
                row.style.display = (i >= (page - 1) * rowsPerPage && i < page * rowsPerPage) ? "" : "none";
            });

            paginationDiv.innerHTML = "";
            for (let i = 1; i <= totalPages; i++) {
                paginationDiv.innerHTML += `<button class="btn btn-sm ${i == page ? 'btn-primary' : 'btn-light'} mx-1" onclick="afficherPage(${i})">${i}</button>`;
            }
        }

        afficherPage(1);
    };
</script>



</body>
</html>
