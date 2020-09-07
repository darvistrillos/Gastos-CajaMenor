/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DarvisTrillosAriza
 */
public class Gasto {

    private Integer id;
    private String fecha;
    private String identificacion;
    private String nombre;
    private String obs;
    private Integer valor;

    public Gasto(Integer id, String fecha, String identificacion, String nombre, String obs, Integer valor) {
        this.fecha = fecha;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.obs = obs;
        this.valor = valor;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getIdenti() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObs() {
        return obs;
    }

    public Integer getValor() {
        return valor;
    }

}
