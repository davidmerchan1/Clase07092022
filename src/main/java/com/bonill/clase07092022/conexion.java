
package com.bonill.clase07092022;

import java.awt.HeadlessException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 57321
 */
public class conexion {

    private static conexion instancia;
    private Connection conectar;
    private String BD;
    private String usuario;
    private String contra;

    public conexion(Connection conectar, String BD, String usuario, String contra) {
        this.conectar = conectar;
        this.BD = BD;
        this.usuario = usuario;
        this.contra = contra;
    }

    public conexion() {
        this.conectar = null;
        this.BD = "bd_merchan";
        this.usuario = "postgres";
        this.contra = "123456789";
    }

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            this.BD = "jdbc:postgresql://127.0.0.1:5432/bd_merchan";
            this.usuario = "postgres";
            this.contra = "123456789";
            this.conectar = (Connection) DriverManager.getConnection(BD, usuario, contra);
        } catch (ClassNotFoundException | HeadlessException | SQLException e) {

            System.out.println("Error al conectar: " + e);
        }
    }


    public Connection getConexion() {
        return conectar;
    }
    
    //patron singleton
    public static conexion getInstancia(){
        if(instancia == null){
            instancia = new conexion();
        }
        return instancia;
    }
}

