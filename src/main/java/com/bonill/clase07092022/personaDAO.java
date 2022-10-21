
package com.bonill.clase07092022;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57321
 */
public class personaDAO {

    private static final String SQL_READALL = "SELECT * FROM tb_persona";
    conexion con = conexion.getInstancia();
    
    public personaDAO() {
        con.conectar();
    }

    public List<personaDTO> readAll() {
        List<personaDTO> lista = null;
        PreparedStatement ps;
        try {
            ps = con.getConexion().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                personaDTO obj = new personaDTO(rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("clave"));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex);
        }
        return lista;
    }
}

