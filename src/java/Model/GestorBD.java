/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DarvisTrillosAriza
 */
public class GestorBD {

    Connection conn = null;
    Statement stm = null;
    ResultSet GastoResultSet;
    Gasto gastoHallado;
    String fec, ident, nomb, obs;
    Integer id, valor;
    int resultUpdate = 0;

    public boolean registrar(String fec, String ident, String nomb, String ob, Integer val) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("INSERT INTO gastos VALUES "
                    + "(0,'" + fec + "','" + ident + "','" + nomb + "','" + ob + "',''," + val + ");");
            if (resultUpdate != 0) {
                System.out.println("Acceso en la base de datos");
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return false;
        }

    }
  public Gasto consultar(Integer idx) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            GastoResultSet = stm.executeQuery("select * from gastos where id=" + idx);
            if (GastoResultSet.next()) {
                fec = GastoResultSet.getString("fecha");
                ident = GastoResultSet.getString("identificacion");
                nomb = GastoResultSet.getString("nombre");
                obs = GastoResultSet.getString("obs");
                valor = GastoResultSet.getInt("valor");
                gastoHallado = new Gasto(id,fec,ident,nomb,obs,valor);
                ConectaBD.cerrar();
                return gastoHallado;
            } else {
                ConectaBD.cerrar();
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
    public boolean borrar(Integer id) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("delete from gastos where (id=" + id + ");");
            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return false;
        }

    }
    public ArrayList<Gasto> leeTodos() {
        ArrayList<Gasto> gastos = new ArrayList<Gasto>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            GastoResultSet = stm.executeQuery("select * from gastos");
            if (!GastoResultSet.next()) {

                System.out.println(" No se encontraron registros2");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id = GastoResultSet.getInt("id");
                    fec = GastoResultSet.getString("fecha");
                    ident = GastoResultSet.getString("identificacion");
                    nomb = GastoResultSet.getString("nombre");
                    obs = GastoResultSet.getString("obs");
                    valor = GastoResultSet.getInt("valor");
                    gastoHallado = new Gasto(id, fec, ident, nomb, obs, valor);
                    gastos.add(gastoHallado);
                } while (GastoResultSet.next());
                ConectaBD.cerrar();
                return gastos;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
    
     public boolean actualizar(Integer id, String fecha, String identi, String nombre, String obs, Integer valor) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            String mysql="update gastos set fecha='"+ fecha +"',identificacion='"+ identi +"',nombre='"+ nombre +"',obs='"+ obs +"',valor="+ valor +" where id=" + id ;
            resultUpdate = stm.executeUpdate(mysql);
            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return false;
        }

    }

}
