<!-- webapp/views/navbar.jsp -->
  <c:if test="${not empty sessionScope.user}">
      <span class="navbar-text">Bonjour, ${sessionScope.user.prenom}</span>
      <a class="nav-link" href="logout">Se deconnecter</a>
  </c:if>

<nav class="navbar navbar-expand-lg navbar-light bg-light mb-4">
  <div class="container">
    <a class="navbar-brand" href="competitions">Accueil</a>
    <a class="nav-link" href="participants">Participants</a>
    <a class="nav-link" href="resultats">Resultats</a>
    <a class="nav-link" href="statistiques">Statistiques</a>
  </div>
</nav>
