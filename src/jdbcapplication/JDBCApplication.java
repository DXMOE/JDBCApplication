/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcapplication;

import java.sql.*;

/**
 *
 * @author dxmoe
 */
public class JDBCApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Carga del controlador (Driver) JBDC
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Carga Exitosa");
            String url = "jdbc:postgresql://localhost/isma4?user=luis&password=LMorales";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Conexion Realizada");
            Statement st = conn.createStatement();
          
            
         //Sentencia de inserción  (Crea tres nuevos  usuarios)
         st.execute("INSERT INTO " + "lista (nombre,apellidos,edad) " + "VALUES ('Luis','Morales', 20)");
         st.execute("INSERT INTO " + "lista (nombre,apellidos,edad) " + "VALUES ('Jose','Escobar', 20)");
         st.execute("INSERT INTO " + "lista (nombre,apellidos,edad) " + "VALUES ('Juan','Perez', 22)");
         
         //Sentencia de eliminacion (En este caso selecciona y elimina la ID del segundo usuario registrado)
         String sql = "DELETE FROM lista WHERE id=2 ";
         st.executeUpdate(sql);
         
         //Sentencia de seleccion y muestra de resultados buscados
         ResultSet rs = st.executeQuery("SELECT * FROM lista");
         while ( rs.next() ) {
            int id = rs.getInt("id");
            String  nombre = rs.getString("nombre");
            String  apellido = rs.getString("apellidos");
            int edad  = rs.getInt("edad");
            System.out.println( "ID = " + id );
            System.out.println( "Nombre = " + nombre);
            System.out.println( "Apellido = " + apellido);
            System.out.println( "Edad = " + edad);
            System.out.println();     
         
         
         }
            conn.close();
        } catch (ClassNotFoundException ex){
            System.out.println("Error:Controlador");
            System.exit(1);
        } catch (SQLException ex){
            System.out.println("Error Conexion");
            ex.printStackTrace();
        }
        }
    }

