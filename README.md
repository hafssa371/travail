TP 1.7 : Scripts des Développeurs

Objectif

Ce TP vise à suivre la réalisation des scripts des développeurs d’un projet en enregistrant quotidiennement le nombre de scripts réalisés par chacun dans une base de données MySQL.

Vous apprendrez à :

1. Ouvrir une connexion à une base de données MySQL depuis Java.
2. Créer, remplir et supprimer des tables via des scripts Java.
3. Exécuter des requêtes SQL pour rechercher et analyser des informations dans la base de données.
4. Utiliser les métadonnées des résultats de requêtes SQL.
   
Prérequis

1. Connaissance du langage Java
2. Connaissance de base des bases de données relationnelles et du SQL
3. NetBeans IDE ou tout autre environnement de développement Java
4. MySQL Database installé et configuré
5. Pilote JDBC pour MySQL (par exemple, mysql-connector-java.jar)
   
Outils et Bibliothèques

1. Java JDK
2. MySQL JDBC Driver
3. NetBeans IDE (ou un autre IDE de votre choix)
4. MySQL Server
   
Structure de la Base de Données

La table utilisée dans ce TP, nommée DevData, a la structure suivante :
![image](https://github.com/user-attachments/assets/46ef883a-1cda-495c-9643-69840d9e535e)

Programme du TRAVAIL

Exercice 1 : Ouvrir une connexion, Créer et remplir une table

Étapes à Suivre

1.Charger le Driver JDBC de MySQL

Utilisez Class.forName("com.mysql.jdbc.Driver") pour charger le driver.

2. Se Connecter à la Source de Données

Utilisez DriverManager.getConnection(url, user, password) pour établir une connexion.

3. Créer la Table DevData

Obtenez un objet Statement depuis la connexion.
Exécutez la requête SQL suivante pour créer la table :

CREATE TABLE DevData (
Developpeurs VARCHAR (32),
Jour CHAR (11),
NbScripts INTEGER)

4. Insérer les Données Initiales
5. Compiler et Tester le Programme


   ![image](https://github.com/user-attachments/assets/2729ba21-c86a-4f8b-8cc3-1a00e1ea798d)

   ![image](https://github.com/user-attachments/assets/cf65f113-bc6f-4c39-b90e-e0bde3eadde7)

   ![image](https://github.com/user-attachments/assets/f778a9fd-8c7e-41c0-894a-2899c7147326)

   ![image](https://github.com/user-attachments/assets/1ee7f923-f213-43c1-b355-e8b80b9a1e55)

   ![image](https://github.com/user-attachments/assets/dc98e26e-404a-4125-a340-db6aa14f0959)

   Exercice 2 : Rechercher de l’Information dans la Base de Données

   Exemple de Code pour l'Exercice 2

   ![image](https://github.com/user-attachments/assets/8bc0d012-0d20-482a-a100-5a54bedddd7a)

   ![image](https://github.com/user-attachments/assets/1f5c4575-0075-4b79-98c0-834c92d39817)

   ![image](https://github.com/user-attachments/assets/9d6882f2-fe16-4c53-99f2-1a5e10783cc1)

   ![image](https://github.com/user-attachments/assets/29fa2d45-b70f-4d11-8b54-bf54f75977d1)

   ![image](https://github.com/user-attachments/assets/411a29dd-b9be-4ba8-80ff-63295204eb6d)

   Exercice 3 : Effectuer une Requête Libre et Obtenir les Métadonnées sur les Types de Données du Résultat
   
Étapes à Suivre

Modifier le Programme ExoJDBC pour Exécuter une Requête Libre :

1. Lire une requête SQL entrée par l'utilisateur via le clavier.
2. Exécuter la requête et déterminer si elle retourne un ResultSet ou non.
3. Afficher les Informations Suivantes :

Si la requête produit un ResultSet :

1. Nombre de colonnes.
2. Nom et type de chaque colonne.
3. Contenu de la table ligne par ligne.
   
Sinon :
 Nombre de lignes modifiées dans la table DevData.
 
 Exemple de Code pour l'Exercice 3

 ![image](https://github.com/user-attachments/assets/2e5fd335-d4fb-4e9f-a954-74fedb1dafa8)

 ![image](https://github.com/user-attachments/assets/c18ca160-e9fb-4f12-908e-0497d7942563)

 ![image](https://github.com/user-attachments/assets/d73b0299-38c0-40f5-bdcc-a3f03c14d91f)

 ![image](https://github.com/user-attachments/assets/806b15c7-7d55-4871-a9b7-a3d6302da290)
 

Conclusion
Ce TP vous a permis de :

Manipuler une base de données MySQL depuis Java en utilisant JDBC.
Créer, remplir et supprimer des tables via des scripts Java.
Exécuter des requêtes SQL pour extraire et analyser des données.
Utiliser les métadonnées pour obtenir des informations sur les résultats des requêtes
















