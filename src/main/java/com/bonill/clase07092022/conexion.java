
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
        this.BD = "dbvclstp9ma9s9";
        this.usuario = "qavlwuiejdpjbi";
        this.contra = "6ce2b63815973f78d3fddc718ee6ddea3f83536e9793b575322d0a59f751d101";
    }

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            this.BD = "jdbc:postgresql://ec2-3-220-207-90.compute-1.amazonaws.com:5432/dbvclstp9ma9s9";
            this.usuario = "qavlwuiejdpjbi";
            this.contra = "6ce2b63815973f78d3fddc718ee6ddea3f83536e9793b575322d0a59f751d101";
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



