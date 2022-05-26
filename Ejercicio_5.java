

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio_5 {
    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
//        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empl_depart", "root", "rm2122");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT empleados.apellido, "+" empleados.salario "+"FROM empleados WHERE comision IS NULL");
            System.out.println("APELLIDO SALARIO");
            while(rs.next()){
                
            }
        }
//    }
}
