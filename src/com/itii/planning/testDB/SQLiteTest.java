package com.itii.planning.testDB; // Adapter en fonction de votre package
import java.sql.Connection; import java.sql.DriverManager; import java.sql.PreparedStatement; import java.sql.ResultSet;
import java.sql.SQLException; import java.sql.Statement;
/**
 * Test de connection / exécution de requêtes SQL / déconncetion de SQLite * @author Sebastien
 */
public class SQLiteTest {
    private static final String TABLE_NAME = "Tasks";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DATE = "date";
    private static final String FIELD_DETAILS = "details";
    private static final String FIELD_STATE = "state";

    public static void main(String[] args){
        Connection connection = null; Statement statement = null;
        // Création de la table
        try {
            // Chargement du Driver. Stockage des données dans le fichier planning.db
            connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
            // Objet permettant l'exécution des requêtes SQL
            statement = connection.createStatement();
            // Timeout en cas de non-réponse de la base de données. statement.setQueryTimeout(15);
            statement.execute("drop table if exists " + TABLE_NAME);
            // Création de la table
            statement.executeUpdate("create table " + TABLE_NAME + " ( "
                            + FIELD_ID + " integer primary key autoincrement, " // Primary key
                            + FIELD_NAME + " string, " // Name
                            + FIELD_DATE + " text, " // Details
                            + FIELD_DETAILS + " text, " // date as ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS").
                            + FIELD_STATE + " boolean " + " )"); // marquée
                    System.out.println("table \"" + TABLE_NAME + "\" créée ");
        }
        catch (SQLException e) {
            System.out.println(" Table non créée ou déjà existante");
            e.printStackTrace();
        }
// Test d'écriture dans la table
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into " + TABLE_NAME + " ( " + FIELD_NAME + ","
                            + FIELD_DATE + "," + FIELD_DETAILS + ","
                            + FIELD_STATE + " ) " + "values ( ?, ?, ?, ?) ");
            stmt.setString(1, "TP #1");
            stmt.setString(2, "2018-04-20 12:00");
            stmt.setString(3, "penser à rendre le tp");

            stmt.setString(4, "0");
            stmt.executeUpdate();
            System.out.println("insertion d'une nouvelle entrée dans la table");
        }
        catch (SQLException e) {
            System.out.println("problème dans l'insertion d'une nouvelle enrée dans la table."); }
        // Test de lecture depuis la table
        try {
            ResultSet rs = statement.executeQuery("select * from " + TABLE_NAME);
            while (rs.next()) {
                System.out.print("lecture d'une donnée [");
                System.out.print(" id = " + rs.getString(FIELD_ID));
                System.out.print(" ; name = " + rs.getString(FIELD_NAME));
                System.out.print(" ; date = " + rs.getString(FIELD_DATE));
                System.out.print(" ; details = " + rs.getString(FIELD_DETAILS));
                System.out.println( " ; etat = " + rs.getString(FIELD_STATE) + "]");
            }
        }
        catch (SQLException e) {
            System.out.println("erreur à la lecture de la table");
        }

        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                System.out.println("fermeture de la connection à la base de données");
            }
            catch (SQLException e) {
                System.out.println("erreur lors de la fermeture de la connection");
            }
        }
    }
}