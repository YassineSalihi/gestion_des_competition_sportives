# 🏆 Application de Gestion des Compétitions Sportives

## 📌 Contexte

Dans le cadre de la gestion d’activités sportives, il est essentiel de suivre les compétitions organisées, les participants inscrits, les résultats enregistrés et les statistiques de performances. Ce projet vise à développer une application web pour gérer efficacement ces éléments tout en assurant une interface moderne, interactive et intuitive.

## ❗ Problématique

Les plateformes sportives souffrent souvent de :
- Manque de centralisation des données (participants, scores...),
- Faible interactivité (inscription manuelle, rechargement de pages),
- Absence de visualisation claire des performances.

**➡️ Comment concevoir une application permettant de gérer les compétitions sportives, d’inscrire des participants, de saisir des résultats et de visualiser les scores de manière interactive ?**

## 🎯 Objectifs de l'application

### Objectif général
Développer une application Java Web dynamique pour gérer les compétitions sportives, les inscriptions, les résultats et les statistiques par score.

### Objectifs spécifiques
- Gérer les **compétitions** (nom, type, dates).
- Gérer les **participants** (nom, catégorie).
- Enregistrer les **résultats** pour chaque compétition.
- Afficher **les résultats par participant** et **par compétition**.
- Générer des **statistiques visuelles** avec Chart.js.
- Utiliser une **architecture MVC claire** (JSP/Servlets).
- Persister les données avec Hibernate + MySQL.

## 🛠️ Technologies et outils utilisés

| Outil / Technologie        | Description                                                                 |
|----------------------------|-----------------------------------------------------------------------------|
| **Java Web (JSP / Servlet)** | Interface utilisateur dynamique, logique métier, architecture MVC.         |
| **MySQL**                  | Base de données relationnelle pour stocker compétitions, participants, résultats. |
| **Hibernate**              | ORM pour la gestion automatique de la persistance des objets.              |
| **JDBC**                   | Accès aux données dans la couche DAO.                                       |
| **AJAX**                   | Pour l’ajout des résultats sans rechargement de page.                      |
| **Chart.js**               | Génération de graphiques statistiques (ex. score moyen par compétition).   |

## 📐 Diagramme de classes

Le diagramme suivant représente les entités principales de l'application ainsi que leurs relations :
![Image](https://github.com/user-attachments/assets/85274c95-333c-4a01-a26d-aaef823ccb68)

## 🗃️ Modèle conceptuel de la base généré
![Image](https://github.com/user-attachments/assets/fcee85e1-5340-42c0-9412-1835650a63bb)

## 📃 Pages principales

1. 🏁 **Liste des compétitions**
2. 👥 **Participants et résultats**
3. 🧾 **Mes compétitions**
4. 📊 **Statistiques des scores par compétition (Chart.js)**

## 📆 Planning (Méthodologie Agile – Sprints)

| Sprint       | Durée   | Contenu                                                                 |
|--------------|---------|-------------------------------------------------------------------------|
| **Sprint 1** | 2 jours | Création des entités `User`, `Participant`, `Competition`, `Resultat`   |
| **Sprint 2** | 3 jours | Développement de la couche **DAO** avec Hibernate                       |
| **Sprint 3** | 5 jours | Création des interfaces JSP + Servlet MVC pour saisie et affichage     |
| **Sprint 4** | 4 jours | Intégration **AJAX** et **Chart.js** pour les statistiques dynamiques   |

## ✅ Fonctionnalités à venir

- 🔐 Authentification des utilisateurs
- 🧮 Statistiques avancées (moyenne, classement)
- 📱 Version responsive mobile
- 📥 Export PDF des résultats

---
### 📥 Insertion des Données (Hibernate)
![Image](https://github.com/user-attachments/assets/7dce0b5e-6fcf-4387-9335-014a071ac320)
![Image](https://github.com/user-attachments/assets/67e096ed-edbd-4f67-ba40-4b4404436feb)
![Image](https://github.com/user-attachments/assets/97c72669-5496-4fe3-91ab-796bc604843b)

### 🔍 Le filtrage
![Image](https://github.com/user-attachments/assets/0d961d4c-9fd3-4f06-8572-4c59c6a26cf3)
![Image](https://github.com/user-attachments/assets/3d6794f2-510a-46f5-80f6-4b9a39cb50ba)

📌 Ce projet représente une **solution complète de gestion sportive**, alliant performance, ergonomie et visualisation en temps réel pour clubs, écoles ou événements.

### 📷 Screenshots

![Image](https://github.com/user-attachments/assets/7d3614f6-a248-4dc7-b261-fc0b0208ebae)
![Image](https://github.com/user-attachments/assets/84168baa-7f04-4cee-a9dc-03ea4dce48ae)
![Image](https://github.com/user-attachments/assets/23eba29f-c615-4df2-aa52-c94a6a6a2c9d)
![Image](https://github.com/user-attachments/assets/9af877e1-ea78-4484-813d-eb43f98be660)
![Image](https://github.com/user-attachments/assets/2e6d5e43-ba31-4fa2-90b3-302b634c652f)
![Image](https://github.com/user-attachments/assets/cfd92ba8-3df3-4b82-8cd3-1b65ab4beed1)
![Image](https://github.com/user-attachments/assets/bc00926a-c6ba-420f-9307-41aad0f45870)
