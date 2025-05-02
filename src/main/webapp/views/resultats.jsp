<%@ page contentType="text/html;charset=UTF-8" %>
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
            <label>ID compétition:</label>
            <input type="number" name="competition_id" class="form-control" required>
        </div>
        <div class="mb-2">
            <label>ID participant:</label>
            <input type="number" name="participant_id" class="form-control" required>
        </div>
        <div class="mb-2">
            <label>Score:</label>
            <input type="number" name="score" step="0.01" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Soumettre</button>
    </form>

    <script>
        $('#resultatForm').submit(function(e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: 'resultats',
                data: $('#resultatForm').serialize(),
                success: function() {
                    alert('Résultat ajouté');
                    location.reload();
                }
            });
        });
    </script>
</body>
</html>
