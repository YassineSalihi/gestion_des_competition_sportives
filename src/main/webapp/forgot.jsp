<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mot de passe oublié</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
    <div class="card shadow p-4" style="width: 100%; max-width: 400px;">
        <h3 class="text-center mb-4">Mot de passe oublié</h3>

        <form method="post" action="ForgotPasswordServlet">
            <div class="mb-3">
                <label for="email" class="form-label">Adresse email</label>
                <input type="email" class="form-control" id="email" name="email" required placeholder="Entrez votre email">
            </div>
            <button type="submit" class="btn btn-primary w-100">Réinitialiser</button>
        </form>

        <div class="mt-3 text-center">
            <a href="login.jsp" class="text-decoration-none">Retour à la connexion</a>
        </div>
    </div>
</div>

</body>
</html>
