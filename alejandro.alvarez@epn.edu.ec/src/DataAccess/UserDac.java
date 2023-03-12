package DataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Encrypter.Encriptador;
import Framework.AppConfiguration;
import Framework.AppException;

public class UserDac extends SQLiteDataHelper {

    public UserDac() {
        super(AppConfiguration.getDBPathConnection());
    }


    public static void addUsuarios(String nombre, String apellido, String usuario, String psw) throws Exception {
        Connection conexion = null;
        PreparedStatement statement = null;
        try {    
            // 1. Conectar con la base de datos
            conexion = DriverManager.getConnection("jdbc:sqlite:data\\DBTest.db");
            // 2. Preparar la sentencia SQL
            String sql = "INSERT INTO USUARIOS (nombre, apellido, usuario, contrasena) VALUES (?, ?, ?, ?)";
            statement = conexion.prepareStatement(sql);
    
            // 3. Asignar los valores de los parámetros
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, usuario);
            statement.setString(4, Encriptador.aaEncriptar(psw));
    
            // 4. Ejecutar la sentencia SQL
            statement.executeUpdate();
    
            // 5. Cerrar la conexión
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public ResultSet aaGetUserbyuser(String user) throws AppException  {
        try {
            String sql = "SELECT *"
                        +"FROM USUARIOS "
                        +"WHERE Usuario = ? ";

            Connection conn = getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            //System.out.println(sql);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    }


    public ResultSet aaGetCoordenadasByInt(int coord) throws AppException  {
        try {
            String sql = "SELECT *"
                        +"FROM COORDENADAS "
                        +"WHERE Capacidad = ? ";

            Connection conn = getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setLong(1, coord);
            //System.out.println(sql);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    }

    public static void addCoordenadas(int i, String geolocalizacion, String tipoArsenal, int id) throws Exception {
        Connection conexion = null;
        PreparedStatement statement = null;
        try {    
            // 1. Conectar con la base de datos
            conexion = DriverManager.getConnection("jdbc:sqlite:data\\DBTest.db");
            // 2. Preparar la sentencia SQL
            String sql = "INSERT INTO COORDENADAS_PERSONALES (capacidad, geolocalizacion, tipoArsenal, id) VALUES (?, ?, ?, ?)";
            statement = conexion.prepareStatement(sql);
    
            // 3. Asignar los valores de los parámetros
            statement.setLong(1, i);
            statement.setString(2, geolocalizacion);
            statement.setString(3, tipoArsenal);
            statement.setLong(4, id);
    
            // 4. Ejecutar la sentencia SQL
            statement.executeUpdate();
    
            // 5. Cerrar la conexión
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
