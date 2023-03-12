import BusinessLogic.CoordenadasBL;
import BusinessLogic.UserBL;
import BusinessLogic.Entities.User;
import DataAccess.UserDac;
import Framework.*;
import java.util.Scanner;
import Encrypter.*;




public class App{
  static Scanner scanner = new Scanner(System.in);
        private static void aaMostrarCoordenadas(String contrasena){

            try {
                CoordenadasBL Coordenadas =  new CoordenadasBL();
                System.out.println("Cap |  Geo  |  TipoArsenal" );
                for (User p : Coordenadas.aaGetCoordenadasByInt(coord)) {
                    System.out.println("ID:" + p.getId());
                    
                }
            } catch (Exception e) { } 
            for(int i=contrasena.length(); i<0; i--){

            }            
        }


        private static void aaLogin(){
        String aaContrasena2=null;        
        int i = 0;
        for (; i < 3; i++) {
            System.out.println("------------------------");
            System.out.println("  Log In  ");
            System.out.println("------------------------");
            System.out.println("Numero de intentos:  "+(3-i));
            System.out.print("usuario: ");
            String aaUsuario = scanner.nextLine();
            System.out.print("clave: ");
            String aaContrasena = scanner.nextLine();

        //Acceso a datos y Exception
        try {
            UserBL Usuarios =  new UserBL();
            System.out.println("[Usuarios]" );
            for (User p : Usuarios.aaGetUserbyuser(aaUsuario)) {
                System.out.println("ID:" + p.getId());
                System.out.println("Nombre:" + p.aaGetNombre());
                System.out.println("Apellido:" + p.aaGetApellido());
                System.out.println("Usuario:" + p.aaGetUsuario());
                System.out.println("Contrasena:" + p.aaGetContrasena());
                System.out.println("\n") ;
                aaContrasena2=Encriptador.aaDesencriptar(p.aaGetContrasena());
            }
        } catch (Exception e) { } 


            if ((aaUsuario.equals(aaUsuario) && aaContrasena.equals(aaContrasena2))) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Usuario o contraseña incorrecta, vuelve a intentarlo!");
            }
        if(i>3)
            System.out.println("Lo sentimos, tu usuario y clave son incorrectos..!");   
            } 
  }

    public static void main(String[] args) throws Exception {
        //Configuracion de propiedades de la aplicacion
        AppConfiguration.load("src/config.properties"); 
        System.out.println(AppConfiguration.getDBName());
        System.out.println(AppConfiguration.getDBPathConnection());
        
        //UserDac.addUsuarios("Alejandro", "Alvarez","alejandro.alvarez@epn.edu.ec","0504042375");
        //UserDac.addUsuarios("Juanito", "Alimaña","juanito.alimana@epn.edu.ec","1705032371");
        //UserDac.addUsuarios("Patricio", "Paccha","profe","1234");

        aaLogin();
    };     
}
  

