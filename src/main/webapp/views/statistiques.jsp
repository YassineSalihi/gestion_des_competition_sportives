<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Statistiques</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body class="container mt-5">

    <jsp:include page="navbar.jsp" />

    <h2>Scores par compétition</h2>
    <canvas id="scoreChart" width="600" height="300"></canvas>

    <script>
        fetch('statistiques')
        .then(response => response.json())
        .then(data => {
            const ctx = document.getElementById('scoreChart').getContext('2d');
            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: data.map(d => d.nom),
                    datasets: [{
                        label: 'Score moyen',
                        data: data.map(d => d.score),
                        backgroundColor: 'rgba(54, 162, 235, 0.6)'
                    }]
                }
            });
        });
    </script>
</body>
</html>
