
package com.mycompany.ejercicios_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ejercicio_1 {
    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/basedatos_contactos2", "root", "rm2122");
            Statement st = conexion.createStatement();
            st.executeUpdate("CREATE TABLE contactos (id INT AUTO_INCREMENT,\n"
                            + " PRIMARY KEY(id), nombre VARCHAR(20),\n"
                            + " apellidos VARCHAR(20), telefono VARCHAR(20))");
            
            String nombres[] = {"Juan", "Pedro", "Antonio"};
            String apellidos[] = {"Gomez", "Lopez", "Alvarez"};
            String telefonos[] = {"2334783273", "7834872872", "48943894389"};
            
            for(int i = 0; i<nombres.length; i++) {
                st.execute("INSERT INTO contactos (nombre, apellidos, telefono)"+
                           " VALUES ('" + nombres[i] + "','" + apellidos[i] + "','" + telefonos[i] + "' )");
            }
            
            ResultSet rs = st.executeQuery("SELECT * FROM contactos");
            
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            }
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            
        }finally{
            try{
                if(conexion != null){
                    conexion.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}

