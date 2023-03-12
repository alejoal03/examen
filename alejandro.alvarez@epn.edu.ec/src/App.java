import BusinessLogic.CoordenadasBL;
import BusinessLogic.UserBL;
import BusinessLogic.Entities.Coordenadas;
import BusinessLogic.Entities.User;
import DataAccess.UserDac;
import Framework.*;
import java.util.Scanner;
import Encrypter.*;


public class App{
  static Scanner scanner = new Scanner(System.in);


  /**
     * Metodo para limpiar pantalla
     */
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");
        System.out.flush();   
    } 

    //Metodo para limpiar pantalla
    public static void aaMostrarDatos(String developer, String ced, int capacidad, int coordenadaT, String coordenadaSec) {  
        System.out.println("Developer-Nombre:    "+developer);
        System.out.println("Developer-Cedula:    "+ced);
        System.out.println("Capacidad Belica:    "+capacidad);
        System.out.println("Coordenada-Total:    "+coordenadaT);
        System.out.println("Coordenada-SecCarga: "+coordenadaSec);
    } 

  public static void aaMostrarAnimacionDePorcentaje() {
    for (int i = 1; i <= 100; i++) {
        System.out.print("\r" + i + "%  | ");
        try {
            Thread.sleep(25); // espera 50 milisegundos antes de continuar
        } catch (InterruptedException e) {
            e.printStackTrace();
            }
        }   
    }



        private static void aaMostrarCoordenadas(String contrasena){
            for(int i=contrasena.length()-1; i>=0; i--){
                int coord = Character.getNumericValue(contrasena.charAt(i));
                try {
                    CoordenadasBL coorde =  new CoordenadasBL();
                    System.out.println("       Cap  |  Geo  |  TipoArsenal" );
                    for (Coordenadas a : coorde.aaGetCoordenadasByInt(coord)) {
                        aaMostrarAnimacionDePorcentaje();
                        System.out.print(a.getAaCapacidad()+"   |  ");
                        System.out.print(a.getAaGeolocalizacion()+" |       ");
                        System.out.println(a.getAaArsenal());      
                        System.out.println("----------------------------------");              
                    }
                } catch (Exception e) { } 
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
                clearScreen();
                aaMostrarCoordenadas(aaContrasena);
                try {
                    Thread.sleep(2000); // espera 50 milisegundos antes de continuar
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clearScreen(); 
                aaMostrarDatos(APP.AANOMBRE_COMPLETO, APP.AACEDULA, i, i, aaContrasena);
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
        clearScreen();
        aaLogin();
    };     
}
  

