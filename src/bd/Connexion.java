/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author IDA
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DATABASE_URL = "jdbc:mysql://localhost/gestion_reservation_bd";
static final String USER = "damessi";
static final String PASS = "1234";
static Statement statement=null;
static Connection connection=null;

    public static Connection getConnexion(){
    
          
                  
        try {
            Class.forName( JDBC_DRIVER );
      
           
               connection = DriverManager.getConnection( DATABASE_URL, USER, PASS);
                statement=connection.createStatement();
                System.out.println("connexion établie avec succès");
    } catch (ClassNotFoundException ex) {
           System.out.println("Impossible de trouver le pilote mysql");
        }
        catch (SQLException ex) {
             System.out.println("Base de données inacessible");
             System.out.println(ex.getMessage());
            }
        finally
        {
           
        }
    return connection;
    }
}

