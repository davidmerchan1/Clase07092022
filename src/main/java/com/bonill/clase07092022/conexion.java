
package com.bonill.clase07092022;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 57321
 */
public class conexion {
      Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_parcial";
    String user = "root";
    String pass = "";       
    public Connection Conexion(){
      try{
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection(url, user, pass);
      }catch(Exception e){
          System.out.println("error en la conexion con la base de datos "+e.getMessage());
      }
         
    return con;
}
}
