import BusinessLogic.UserBL;
import BusinessLogic.Entities.User;
import Framework.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Encrypter.*;




public class App2 extends JFrame{

    private JLabel aaLabelUsuario;
    private JTextField aaCampoUsuario;
    private JLabel aaLabelContrasena;
    private JPasswordField aaCampoContrasena;
    private JButton aaBotonIniciarSesion;
    private int aaIntentos = 0;
  
    public App2() {
      // Configuramos el título de la ventana
      super("Login");
  
      // Configuramos el tamaño de la ventana
      setSize(400, 200);
      
  
      // Creamos y configuramos los componentes de la ventana
      
      aaLabelUsuario= new JLabel("Usuario:");
      aaCampoUsuario = new JTextField(25);
      aaLabelContrasena = new JLabel("Contraseña:");
      aaCampoContrasena = new JPasswordField(25);
      aaBotonIniciarSesion = new JButton("Iniciar sesión");

      aaLabelUsuario.setBounds(50, 50, 100, 20);
      aaCampoUsuario.setBounds(150, 50, 200, 20);
      aaLabelContrasena.setBounds(50, 75, 100, 20);
      aaCampoContrasena.setBounds(150, 75, 200, 20);
      aaBotonIniciarSesion.setBounds(150, 110, 150, 20);

      setLayout(null);

      
  
      // Agregamos los componentes a la ventana
      add(aaLabelUsuario);
      add(aaCampoUsuario);
      add(aaLabelContrasena);
      add(aaCampoContrasena);
      add(aaBotonIniciarSesion);

      setVisible(true);
  
      // Configuramos el evento del botón "Iniciar sesión"
      aaBotonIniciarSesion.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          aaIniciarSesion();
        }
      });
  
      // Hacemos que la ventana sea visible
      setVisible(true);
    }
  
    private void aaIniciarSesion() {
        
      String aaUsuario = aaCampoUsuario.getText();
      String aaContrasena = new String(aaCampoContrasena.getPassword());
      String aaContrasena2=null;

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

        
        
  
      if (aaUsuario.equals(aaUsuario) && aaContrasena.equals(aaContrasena2)) {
        JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!");
        dispose();
      } else {
        aaIntentos++;
  
        if (aaIntentos == 3) {
          JOptionPane.showMessageDialog(this, "Demasiados intentos. El programa se cerrará.");
          dispose();
        } else {
          JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos. Intento " + aaIntentos + " de 3.");
          aaCampoUsuario.setText("");
          aaCampoContrasena.setText("");
        }
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

        App ventana = new App();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    };

      
}
  


