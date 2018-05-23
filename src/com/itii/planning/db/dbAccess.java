package com.itii.planning.db;

import java.sql.*;
import java.util.ArrayList;

public class dbAccess {

    private static final String PATH = "jdbc:sqlite:database/planning.db";
    private static final String TABLE_NAME = "Tasks";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DATE = "date";
    private static final String FIELD_DETAILS = "details";
    private static final String FIELD_STATE = "state";
    private Connection connection = null;
    private Statement statement = null;

    public dbAccess() {

        try {
            // Chargement du Driver. Stockage des données dans le fichier planning.db
            connection = DriverManager.getConnection(PATH);
            // Objet permettant l'exécution des requêtes SQL
            statement = connection.createStatement();

            statement.executeUpdate("create table if not exists " + TABLE_NAME + " ( "
                    + FIELD_ID + " integer primary key autoincrement, " // Primary key
                    + FIELD_NAME + " string, " // Name
                    + FIELD_DATE + " text, " // Details
                    + FIELD_DETAILS + " text, " // date as ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS").
                    + FIELD_STATE + " boolean " + " )"); // marquée
            //System.out.println("table \"" + TABLE_NAME + "\" créée ");
        } catch (SQLException e) {
            System.out.println(" Table non créée ou déjà existante");
            e.printStackTrace();
        }
    }

    public ArrayList<Object[]> readDB(){
        ArrayList<Object[]> obj = new ArrayList<Object[]>();
        try {
            ResultSet rs = statement.executeQuery("select * from " + TABLE_NAME);
            while (rs.next()) {
                obj.add(new Object[]{rs.getString(FIELD_NAME),rs.getString(FIELD_DATE),rs.getString(FIELD_DETAILS),rs.getString(FIELD_ID), rs.getString(FIELD_STATE)});
            }
        }
        catch (SQLException e) {
            System.out.println("erreur à la lecture de la table");
        }
        return obj;
    }

    public void writeDB(String name, String date, String comment){

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into " + TABLE_NAME + " ( " + FIELD_NAME + ","
                            + FIELD_DATE + "," + FIELD_DETAILS + ","
                            + FIELD_STATE + " ) " + "values ( ?, ?, ?, ?) ");
            stmt.setString(1, name);
            stmt.setString(2, date);
            stmt.setString(3, comment);
            stmt.setString(4, "0");
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("problème dans l'insertion d'une nouvelle enrée dans la table.");
        }
    }

    public void deleteRow(int id){
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "delete from " +TABLE_NAME+ " WHERE "+FIELD_ID+" = ? ");
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("problème dans la suppression d'un élement dans la base");
        }
    }

    //Fermeture de Bade de données
    public void closeDb (){
        try {
            if (connection != null) {
                connection.close();
            }
            //System.out.println("fermeture de la connection à la base de données");
        } catch (SQLException e) {
            System.out.println("erreur lors de la fermeture de la connection");
        }
    }

    public Object[] getObject(int id){

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "select * from " +TABLE_NAME+ " WHERE "+FIELD_ID+" = ? ");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();


            return new Object[]{rs.getString(FIELD_NAME),rs.getString(FIELD_DATE),rs.getString(FIELD_DETAILS),rs.getString(FIELD_ID), rs.getString(FIELD_STATE)};


        }
        catch (SQLException e) {
            System.out.println("problème dans la duplication d'un élement dans la base");
        }


        return null;
    }

    public String getTopID(){
        String id=new String();
        try {
            ResultSet rs = statement.executeQuery("select max(" +FIELD_ID+ ") as last from " + TABLE_NAME);

            id=rs.getString("last");

        }
        catch (SQLException e) {
            System.out.println("erreur à la lecture de la table");
        }
        return id;
    }

    public void alterDB(String name, String date, String comment, int id){
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "update " + TABLE_NAME + " set " + FIELD_NAME + " = ?, "
                            + FIELD_DATE + " = ?,  " + FIELD_DETAILS + " = ? where "+FIELD_ID+ "= ?");
            stmt.setString(1, name);
            stmt.setString(2, date);
            stmt.setString(3, comment);
            stmt.setInt(4, id);

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("problème dans la modification d'une valeur dans la table.");
        }
    }

    public void MarkDB(int id){
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "update " + TABLE_NAME + " set " + FIELD_STATE + " = 1  where "+FIELD_ID+ "= ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("problème dans le marquage d'une valeur dans la table.");
        }
    }
    public void unMarkDB(int id){
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "update " + TABLE_NAME + " set " + FIELD_STATE + " = 0  where "+FIELD_ID+ "= ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("problème dans le marquage d'une valeur dans la table.");
        }
    }
}
