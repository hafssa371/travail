package beans;

import java.sql.*;
import java.util.Scanner;

public class ExoJDBC {

    private static final String URL = "jdbc:mysql://localhost/dbtav";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection cn = null;
        Statement st = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Ouvrir une connexion
            cn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Créer un objet Statement
            st = cn.createStatement();

            // Créer et remplir la table DevData
            creerEtRemplirTable(st);

            //  Effectuer les requêtes
            effectuerRequetesExercice2(st, scanner);

            //  Requête libre avec méta-informations
            effectuerRequeteLibre(st, scanner);


        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de chargement du driver JDBC.");

        } catch (SQLException e) {
            System.err.println("Erreur SQL.");

        } finally {
            // Fermer les ressources
            try {
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
                scanner.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources");
            }
        }
    }

    /**
     *  Créer la table DevData et insérer les données.
     */
    private static void creerEtRemplirTable(Statement st) throws SQLException {
        // Supprimer la table si elle existe déjà pour éviter les erreurs
        String dropTableSQL = "DROP TABLE IF EXISTS DevData";
        st.executeUpdate(dropTableSQL);
        System.out.println("Table DevData supprimée (si elle existait déjà).");

        // Créer la table DevData
        String createTableSQL = "CREATE TABLE DevData ("
                + "Developpeurs VARCHAR(32),"
                + "Jour VARCHAR(11),"
                + "NbScripts INTEGER"
                + ")";
        st.executeUpdate(createTableSQL);
        System.out.println("Table DevData créée avec succès.");

        // Insérer les données
        String[] inserts = {
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

        for (String insertSQL : inserts) {
            st.executeUpdate(insertSQL);
        }
        System.out.println("Données insérées dans la table DevData.");
    }

    /**
     *  Effectuer les différentes requêtes SQL.
     */
    private static void effectuerRequetesExercice2(Statement st, Scanner scanner) throws SQLException {
        System.out.println("\n***************");

        //  Personne ayant réalisé le nombre maximum de scripts en une journée
        String queryMaxScripts = "SELECT Developpeurs, Jour, NbScripts "
                + "FROM DevData d1 "
                + "WHERE NbScripts = ("
                + "    SELECT MAX(NbScripts) "
                + "    FROM DevData d2 "
                + "    WHERE d1.Jour = d2.Jour"
                + ")";
        ResultSet rs = st.executeQuery(queryMaxScripts);

        System.out.println("\n Personne ayant réalisé le nombre maximum de scripts en une journée :");
        while (rs.next()) {
            String dev = rs.getString("Developpeurs");
            String jour = rs.getString("Jour");
            int nb = rs.getInt("NbScripts");
            System.out.println(dev + " a réalisé " + nb + " scripts le " + jour);
        }
        rs.close();

        //  Liste des personnes triées par nombre total de scripts décroissant
        String queryListeTriée = "SELECT Developpeurs, SUM(NbScripts) AS totalScripts "
                + "FROM DevData "
                + "GROUP BY Developpeurs "
                + "ORDER BY totalScripts DESC";
        rs = st.executeQuery(queryListeTriée);

        System.out.println("\n Liste des personnes triées par nombre total de scripts décroissant :");
        while (rs.next()) {
            String dev = rs.getString("Developpeurs");
            int total = rs.getInt("totalScripts");
            System.out.println(dev + " : " + total + " scripts");
        }
        rs.close();

        //  Nombre total de scripts réalisés en une semaine
        String queryTotalScripts = "SELECT SUM(NbScripts) AS totalScriptsWeek FROM DevData";
        rs = st.executeQuery(queryTotalScripts);

        if (rs.next()) {
            int totalWeek = rs.getInt("totalScriptsWeek");
            System.out.println("\n Nombre total de scripts réalisés en une semaine : " + totalWeek);
        }
        rs.close();

        //  Nombre total de scripts réalisés par un développeur donné
        System.out.print("\n Entrez le nom du développeur pour calculer le nombre total de scripts réalisés : ");
        String devRecherche = scanner.nextLine().trim();

        // Utilisation de PreparedStatement pour éviter les injections SQL
        String queryTotalDev = "SELECT SUM(NbScripts) AS totalScriptsDev "
                + "FROM DevData "
                + "WHERE Developpeurs = ?";
        PreparedStatement pstmt = st.getConnection().prepareStatement(queryTotalDev);
        pstmt.setString(1, devRecherche);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            int totalDev = rs.getInt("totalScriptsDev");
            System.out.println("Nombre total de scripts réalisés par " + devRecherche + " : " + totalDev);
        } else {
            System.out.println("Aucun script trouvé pour le développeur " + devRecherche + ".");
        }
        rs.close();
        pstmt.close();
    }

    /**
     *  Exécuter une requête SQL libre et afficher les
     * méta-informations.
     */
    private static void effectuerRequeteLibre(Statement st, Scanner scanner) throws SQLException {
        System.out.println("\n*************");

        System.out.print("Entrez votre requête SQL : ");
        String requete = scanner.nextLine().trim();

        boolean hasResultSet = st.execute(requete);

        if (hasResultSet) {
            ResultSet rs = st.getResultSet();
            ResultSetMetaData meta = rs.getMetaData();
            int nbColonnes = meta.getColumnCount();
            System.out.println("Nombre de colonnes dans le résultat : " + nbColonnes);

            // Afficher les noms et types des colonnes
            for (int i = 1; i <= nbColonnes; i++) {
                String nomColonne = meta.getColumnName(i);
                String typeColonne = meta.getColumnTypeName(i);
                System.out.println("Colonne " + i + " : " + nomColonne + " (" + typeColonne + ")");
            }

            // Afficher le contenu du ResultSet
            System.out.println("\nContenu de la table résultat :");
            while (rs.next()) {
                for (int i = 1; i <= nbColonnes; i++) {
                    String valeur = rs.getString(i);
                    System.out.print(valeur + "\t");
                }
                System.out.println();
            }
            rs.close();
        } else {
            int lignesModifiees = st.getUpdateCount();
            System.out.println("Nombre de lignes modifiées : " + lignesModifiees);
        }
    }

    @SuppressWarnings("unused")
    private static void supprimerTable(Statement st) throws SQLException {
        String dropTableSQL = "DROP TABLE DevData";
        st.executeUpdate(dropTableSQL);
        System.out.println("Table DevData supprimée.");
    }
}
