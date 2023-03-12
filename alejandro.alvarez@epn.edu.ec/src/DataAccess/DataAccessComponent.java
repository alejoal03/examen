package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import Framework.AppConfiguration;

public class DataAccessComponent extends SQLiteDataHelper {

    public DataAccessComponent() {
        super(AppConfiguration.getDBPathConnection());
    }

    public void getUsuario() {
        String sql = "SELECT Id, Nombre, Apellido, Usuario, Contrasena"
                    +"FROM USUARIOS "
                    +"WHERE Usuario = ? ";
        try (   ResultSet rs = getResultSet(sql)){
            while(rs.next()){
                System.out.println(rs.getInt("Id"));
                System.out.println(rs.getString("Nombre"));
                System.out.println(rs.getString("Apellido"));
                System.out.println(rs.getString("Usuario"));
                System.out.println(rs.getString("Contrasena"));
                System.out.println("------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
