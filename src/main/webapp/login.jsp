<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Connexion</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Connexion</h2>
    <form method="post" action="login">
        <div class="mb-3">
            <label>Email</label>
            <input type="email" name="email" class="form-control" required />
        </div>
        <div class="mb-3">
            <label>Mot de passe</label>
            <input type="password" name="motDePasse" class="form-control" required />
        </div>
        <button type="submit" class="btn btn-primary">Se connecter</button>

        <c:if test="${not empty error}">
            <div class="text-danger mt-2">${error}</div>
        </c:if>
    </form>
</body>
</html>
