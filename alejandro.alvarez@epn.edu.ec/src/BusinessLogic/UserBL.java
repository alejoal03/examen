package BusinessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccess.UserDac;
import Framework.AppException;
import BusinessLogic.Entities.User;

public class UserBL {
    public List<User> aaGetUserbyuser(String string) throws AppException{
        try {
            UserDac UserDac = new UserDac();  
            List<User> User = new ArrayList<User>();
            ResultSet rs = UserDac.aaGetUserbyuser(string);
            while(rs.next()){
                User p = new User(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("usuario"),  rs.getString("contrasena"));
                User.add(p);
            }
            return User;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    } 
}
