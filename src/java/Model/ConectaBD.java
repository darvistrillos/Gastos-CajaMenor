/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DarvisTrillosAriza
 */
public class ConectaBD {

    public static Connection con=null;
    private static String bd = "tesoreria";
    public static String usuario = "root";
    public static String passw = "";
    public static String url = "jdbc:mysql://localhost/" + bd;

    public static Connection abrir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, passw);
            
        } catch (Exception e) {
            System.out.println("Error en la conexion...");
            e.printStackTrace();
            return null;
        }
        return con;
    }

    public static void cerrar() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error no se logro la conexion:\n" + e);
        }
    }
}
