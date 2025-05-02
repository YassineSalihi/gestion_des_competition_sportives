<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Résultats</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="container mt-5">

    <jsp:include page="navbar.jsp" />

    <h2>Ajouter un Résultat</h2>

   <form id="resultatForm" class="mb-3">
       <div class="mb-2">
           <label>Compétition :</label>
           <select name="competition_nom" class="form-control" required>
               <c:forEach var="c" items="${competitions}">
                   <option value="${c.nom}">${c.nom}</option>
               </c:forEach>
           </select>
       </div>

       <div class="mb-2">
           <label>Participant :</label>
           <select name="participant_nom" class="form-control" required>
               <c:forEach var="p" items="${participants}">
                   <option value="${p.nom}">${p.nom}</option>
               </c:forEach>
           </select>
       </div>

       <div class="mb-2">
           <label>Score :</label>
           <input type="number" name="score" step="0.01" class="form-control" required>
       </div>

       <button type="submit" class="btn btn-primary">Soumettre</button>
   </form>


    <h3 class="mt-5">Résultats enregistrés</h3>
    <table class="table table-bordered" id="resultatsTable">
        <thead>
            <tr>
                <th>ID Compétition</th>
                <th>ID Participant</th>
                <th>Score</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>


   <script>
       function chargerResultats() {
           $.get('resultats', function(data) {
               const tbody = $('#resultatsTable tbody');
               tbody.empty();
               data.forEach(r => {
                   tbody.append(`
                       <tr>
                           <td>${r.competitionId}</td>
                           <td>${r.participantId}</td>
                           <td>${r.score}</td>
                       </tr>
                   `);
               });
           });
       }

       $('#resultatForm').submit(function(e) {
           e.preventDefault();
           $.ajax({
               type: 'POST',
               url: 'resultats',
               data: $('#resultatForm').serialize(),
               success: function() {
                   alert('Résultat ajouté');
                   $('#resultatForm')[0].reset();
                   chargerResultats();
               },
               error: function(xhr) {
                   alert("Erreur : " + xhr.responseText);
               }
           });
       });


       $(document).ready(chargerResultats);
   </script>

</body>
</html>
