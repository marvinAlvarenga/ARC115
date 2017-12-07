package cpu;

/**
 * Todo relacionado al ingreso de peticiones por parte del CPU
 * @author Marvin
 */
public class Direccionamiento {
    
    public static final int DIRECTO = 0;
    public static final int INDIRECTO_REGISTRO = 1;
    public static final int DESPLAZA_RELATIVO = 2;
    public static final int DESPLAZA_REGISTRO_BASE = 3;
    public static final int INDEXADO = 4;
    public static final int PILA = 5;
    
    
    /**
     * Generar la Direccion Fisica del Operando a acceder
     * @param p Una peticion del Usuario a un operando
     * @return String - Una cadena con la direccion fisica del operando en base al metodo de direccionamiento
     */
    public static String generarDireccionFisica(Peticion p){
        String direccion = null;
        int desplaza4Bits = 0;
        int desplazamiento = 0;
        switch (p.metodoDireccion) {
            case DIRECTO:
                direccion = p.direccion;
                break;
            case INDIRECTO_REGISTRO:
                direccion = p.valorRegistro;
                break;
            case DESPLAZA_RELATIVO:
                desplaza4Bits = Integer.parseInt(p.valorRegistro, 16);  //Convertir a decimal un numero en Hexa
                desplaza4Bits *= 16;                                    //Desplazamiento de 4 bits del procesador 8086
                desplazamiento = Integer.parseInt(p.direccion, 16);
                direccion = Integer.toString(desplaza4Bits + desplazamiento, 16).toUpperCase(); //Sumar las direcciones y pasarlo a Hexadecimal
                break;
            case DESPLAZA_REGISTRO_BASE:
                desplaza4Bits = Integer.parseInt(p.valorRegistro, 16);
                desplaza4Bits *= 16;
                desplazamiento = Integer.parseInt(p.direccion, 16);
                direccion = Integer.toString(desplaza4Bits + desplazamiento, 16).toUpperCase();
                break;
            case INDEXADO:
                desplaza4Bits = Integer.parseInt(p.direccion, 16);
                desplaza4Bits *= 16;
                desplazamiento = Integer.parseInt(p.valorRegistro, 16);
                direccion = Integer.toString(desplaza4Bits + desplazamiento, 16).toUpperCase();
                break;
        }
        
        return direccion;
    }
}
