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
 

Thought for a couple of seconds

Voici un fichier README en français pour le TP 1.7 : Scripts des développeurs utilisant JDBC et MySQL avec Java :

TP 1.7 : Scripts des Développeurs
Objectif
Ce TP vise à suivre la réalisation des scripts des développeurs d’un projet en enregistrant quotidiennement le nombre de scripts réalisés par chacun dans une base de données MySQL. Vous apprendrez à :

Ouvrir une connexion à une base de données MySQL depuis Java.
Créer, remplir et supprimer des tables via des scripts Java.
Exécuter des requêtes SQL pour rechercher et analyser des informations dans la base de données.
Utiliser les métadonnées des résultats de requêtes SQL.
Prérequis
Connaissance du langage Java
Connaissance de base des bases de données relationnelles et du SQL
NetBeans IDE ou tout autre environnement de développement Java
MySQL Database installé et configuré
Pilote JDBC pour MySQL (par exemple, mysql-connector-java.jar)
Outils et Bibliothèques
Java JDK
MySQL JDBC Driver
NetBeans IDE (ou un autre IDE de votre choix)
MySQL Server
Structure de la Base de Données
La table utilisée dans ce TP, nommée DevData, a la structure suivante :

Développeur	Jour	NBScripts
ALAMI	Lundi	1
WAFI	Lundi	2
SALAMI	Mardi	9
SAFI	Mardi	2
ALAMI	Mardi	2
SEBIHI	Mercredi	2
WAFI	Jeudi	3
ALAOUI	Vendredi	9
WAFI	Vendredi	3
SEBIHI	Vendredi	4
Programme du TP
Exercice 1 : Ouvrir une connexion, Créer et remplir une table
Étapes à Suivre
Charger le Driver JDBC de MySQL

Utilisez Class.forName("com.mysql.jdbc.Driver") pour charger le driver.
Se Connecter à la Source de Données

Utilisez DriverManager.getConnection(url, user, password) pour établir une connexion.
Exemple :
java
Copy code
String url = "jdbc:mysql://localhost/db";
String user = "root";
String password = "";
Connection cn = DriverManager.getConnection(url, user, password);
Créer la Table DevData

Obtenez un objet Statement depuis la connexion.
Exécutez la requête SQL suivante pour créer la table :
sql
Copy code
CREATE TABLE DevData (
    Developpeurs VARCHAR(32),
    Jour CHAR(11),
    NbScripts INTEGER
);
Insérer les Données Initiales

Insérez les enregistrements fournis dans la table DevData :
sql
Copy code
INSERT INTO DevData VALUES ('ALAMI', 'Lundi', 1);
INSERT INTO DevData VALUES ('WAFI', 'Lundi', 2);
INSERT INTO DevData VALUES ('SALAMI', 'Mardi', 9);
INSERT INTO DevData VALUES ('SAFI', 'Mardi', 2);
INSERT INTO DevData VALUES ('ALAMI', 'Mardi', 2);
INSERT INTO DevData VALUES ('SEBIHI', 'Mercredi', 2);
INSERT INTO DevData VALUES ('WAFI', 'Jeudi', 3);
INSERT INTO DevData VALUES ('ALAOUI', 'Vendredi', 9);
INSERT INTO DevData VALUES ('WAFI', 'Vendredi', 3);
INSERT INTO DevData VALUES ('SEBIHI', 'Vendredi', 4);
Supprimer la Table (Optionnel)

Pour supprimer la table DevData, exécutez :
sql
Copy code
DROP TABLE DevData;
Compiler et Tester le Programme

Assurez-vous que votre programme compile sans erreurs et que toutes les opérations SQL s'exécutent correctement.
Exemple de Code pour l'Exercice 1
java
Copy code
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Exo1_JDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/db";
        String user = "root";
        String password = "";
        Connection cn = null;
        Statement st = null;

        try {
            // Étape 1 : Charger le driver
            Class.forName("com.mysql.jdbc.Driver");

            // Étape 2 : Se connecter à la base
            cn = DriverManager.getConnection(url, user, password);

            // Étape 3 : Créer un Statement
            st = cn.createStatement();

            // Étape 4 : Créer la table DevData
            String createTable = "CREATE TABLE DevData (" +
                                 "Developpeurs VARCHAR(32)," +
                                 "Jour CHAR(11)," +
                                 "NbScripts INTEGER)";
            st.executeUpdate(createTable);
            System.out.println("Table DevData créée avec succès.");

            // Étape 5 : Insérer les données
            String[] insertData = {
                "INSERT INTO DevData VALUES ('ALAMI', 'Lundi', 1)",
                "INSERT INTO DevData VALUES ('WAFI', 'Lundi', 2)",
                "INSERT INTO DevData VALUES ('SALAMI', 'Mardi', 9)",
                "INSERT INTO DevData VALUES ('SAFI', 'Mardi', 2)",
                "INSERT INTO DevData VALUES ('ALAMI', 'Mardi', 2)",
                "INSERT INTO DevData VALUES ('SEBIHI', 'Mercredi', 2)",
                "INSERT INTO DevData VALUES ('WAFI', 'Jeudi', 3)",
                "INSERT INTO DevData VALUES ('ALAOUI', 'Vendredi', 9)",
                "INSERT INTO DevData VALUES ('WAFI', 'Vendredi', 3)",
                "INSERT INTO DevData VALUES ('SEBIHI', 'Vendredi', 4)"
            };
            for (String sql : insertData) {
                st.executeUpdate(sql);
            }
            System.out.println("Données insérées avec succès.");

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Impossible de charger le driver JDBC.");
        } finally {
            try {
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources.");
            }
        }
    }
}
Exercice 2 : Rechercher de l’Information dans la Base de Données
Étapes à Suivre
Écrire le Programme ExoJDBC pour Afficher :

(a) La personne ayant réalisé le nombre maximum de scripts en une journée :

sql
Copy code
SELECT Developpeurs, Jour, MAX(NbScripts)
FROM DevData
GROUP BY Jour;
(b) La liste des personnes triée dans l’ordre décroissant selon leur nombre total de scripts :

sql
Copy code
SELECT Developpeurs, SUM(NbScripts) AS TotalScripts
FROM DevData
GROUP BY Developpeurs
ORDER BY TotalScripts DESC;
Modifier le Programme pour Calculer et Afficher le Nombre Total de Scripts Réalisés en une Semaine :

sql
Copy code
SELECT SUM(NbScripts) AS TotalScriptsSemaine
FROM DevData;
Modifier le Programme pour Calculer le Nombre Total de Scripts Réalisés par un Programmeur Donné :

Par exemple, pour le développeur 'ALAMI' :
sql
Copy code
SELECT SUM(NbScripts) AS TotalScriptsAlami
FROM DevData
WHERE Developpeurs = 'ALAMI';
Exemple de Code pour l'Exercice 2
java
Copy code
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExoJDBC {
    private static final String URL = "jdbc:mysql://localhost/db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // Charger le driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se connecter
            cn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Créer Statement
            st = cn.createStatement();

            // (a) Personne avec le nombre max de scripts par jour
            String queryMaxScripts = "SELECT Developpeurs, Jour, MAX(NbScripts) AS MaxScripts " +
                                      "FROM DevData " +
                                      "GROUP BY Jour";
            rs = st.executeQuery(queryMaxScripts);
            System.out.println("Personne ayant réalisé le nombre maximum de scripts par jour :");
            while (rs.next()) {
                String dev = rs.getString("Developpeurs");
                String jour = rs.getString("Jour");
                int maxScripts = rs.getInt("MaxScripts");
                System.out.println(dev + " - " + jour + " : " + maxScripts + " scripts");
            }
            rs.close();

            // (b) Liste des personnes triées par nombre total de scripts décroissant
            String querySorted = "SELECT Developpeurs, SUM(NbScripts) AS TotalScripts " +
                                 "FROM DevData " +
                                 "GROUP BY Developpeurs " +
                                 "ORDER BY TotalScripts DESC";
            rs = st.executeQuery(querySorted);
            System.out.println("\nListe des développeurs triés par nombre total de scripts décroissant :");
            while (rs.next()) {
                String dev = rs.getString("Developpeurs");
                int total = rs.getInt("TotalScripts");
                System.out.println(dev + " : " + total + " scripts");
            }
            rs.close();

            // (2) Nombre total de scripts en une semaine
            String queryTotalWeek = "SELECT SUM(NbScripts) AS TotalScriptsSemaine FROM DevData";
            rs = st.executeQuery(queryTotalWeek);
            if (rs.next()) {
                int totalWeek = rs.getInt("TotalScriptsSemaine");
                System.out.println("\nNombre total de scripts réalisés en une semaine : " + totalWeek);
            }
            rs.close();

            // (3) Nombre total de scripts réalisés par un programmeur donné (ex: 'ALAMI')
            String programmeur = "ALAMI";
            String queryTotalDev = "SELECT SUM(NbScripts) AS TotalScriptsDev FROM DevData " +
                                    "WHERE Developpeurs = '" + programmeur + "'";
            rs = st.executeQuery(queryTotalDev);
            if (rs.next()) {
                int totalDev = rs.getInt("TotalScriptsDev");
                System.out.println("\nNombre total de scripts réalisés par " + programmeur + " : " + totalDev);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Impossible de charger le driver JDBC.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources.");
            }
        }
    }
}
Exercice 3 : Effectuer une Requête Libre et Obtenir les Métadonnées sur les Types de Données du Résultat
Étapes à Suivre
Modifier le Programme ExoJDBC pour Exécuter une Requête Libre :

Lire une requête SQL entrée par l'utilisateur via le clavier.
Exécuter la requête et déterminer si elle retourne un ResultSet ou non.
Afficher les Informations Suivantes :

Si la requête produit un ResultSet :
Nombre de colonnes.
Nom et type de chaque colonne.
Contenu de la table ligne par ligne.
Sinon :
Nombre de lignes modifiées dans la table DevData.
Exemple de Code pour l'Exercice 3

Conclusion
Ce TP vous a permis de :

Manipuler une base de données MySQL depuis Java en utilisant JDBC.
Créer, remplir et supprimer des tables via des scripts Java.
Exécuter des requêtes SQL pour extraire et analyser des données.
Utiliser les métadonnées pour obtenir des informations sur les résultats des requêtes
















