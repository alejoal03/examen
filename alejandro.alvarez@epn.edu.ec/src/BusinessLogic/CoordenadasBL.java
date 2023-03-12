package BusinessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccess.UserDac;
import Framework.AppException;
import BusinessLogic.Entities.Coordenadas;

public class CoordenadasBL {
    public List<Coordenadas> aaGetCoordenadasByInt(int coord) throws AppException{
        try {
            UserDac UserDac = new UserDac();  
            List<Coordenadas> Coordenadas = new ArrayList<Coordenadas>();
            ResultSet rs = UserDac.aaGetCoordenadasByInt(coord);
            while(rs.next())    {
                Coordenadas p = new Coordenadas(rs.getInt("capacidad"), rs.getString("geolocalizacion"), rs.getString("arsenal"));
                Coordenadas.add(p);
            }
            return Coordenadas;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    } 
}