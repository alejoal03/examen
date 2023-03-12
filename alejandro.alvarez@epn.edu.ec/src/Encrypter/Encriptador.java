package Encrypter;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Encriptador {

    private static final String ALGORITMO = "AES";
    private static final String CLAVE = "clave-secreta-12"; // la clave de cifrado debe tener 16, 24 o 32 bytes

    public static String aaEncriptar(String cadena) throws Exception {
        SecretKeySpec clave = new SecretKeySpec(CLAVE.getBytes(), ALGORITMO);
        Cipher cifrador = Cipher.getInstance(ALGORITMO);
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        byte[] textoCifrado = cifrador.doFinal(cadena.getBytes());
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    public static String aaDesencriptar(String cadenaCifrada) throws Exception {
        SecretKeySpec clave = new SecretKeySpec(CLAVE.getBytes(), ALGORITMO);
        Cipher cifrador = Cipher.getInstance(ALGORITMO);
        cifrador.init(Cipher.DECRYPT_MODE, clave);
        byte[] textoDescifrado = cifrador.doFinal(Base64.getDecoder().decode(cadenaCifrada));
        return new String(textoDescifrado);
    }
}    
