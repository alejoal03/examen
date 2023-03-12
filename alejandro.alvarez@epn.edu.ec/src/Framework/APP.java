package Framework;
/**
 * Definicion de variables globales constantes 
 * Configuraciones del estado de aplicacion
 * singleton with enum
 */
public enum APP {
    GLOBAL;
    public final  String  DB_NAME           = "DB_NAME";
    public final  String  DB_PATH           = "DB_PATH";  

    //Constantes con informacion del developer
    public static final String AANOMBRE_COMPLETO="Alejandro Sebastian Alvarez Zambrano";
    public static final String AACEDULA="0504042375";


    //Constantes con definicion  
    private final String  EXCEPTION_UNDEFINED;
    private final String  EXCEPTION_UNDEFINED_CLASS;
    private final Boolean LOG_ON_OFF;
    private final Double  PI        ;
    
     
    APP(){
        //Configuraciones del estado de aplicacion
        EXCEPTION_UNDEFINED_CLASS   = "Excepcion sin decripcion de clase ";
        EXCEPTION_UNDEFINED         = "Excepcion sin decripcion";
        LOG_ON_OFF          = true;
        PI                  = 1.14;
    }

    public Double  getPI()          {   return  PI; }
    public Boolean getLogOnOff()    {   return  LOG_ON_OFF; }
    public String  getExceptionUndefined()      {   return  EXCEPTION_UNDEFINED; }
    public String  getExceptionUndefinedClass() {   return  EXCEPTION_UNDEFINED_CLASS; }
}
