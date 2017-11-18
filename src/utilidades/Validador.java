package utilidades;

import java.awt.event.KeyEvent;

/**
 * Validar diferentes entradas de usuario
 * @author Marvin
 */
public class Validador {
    
    public static final int DOS_BYTES = 1;
    public static final int UN_BYTE = 2;
    
    /**
     * Valida una entrada de datos que deba coincidir con un numero Hexadecimal
     * @param evento El evento de teclado
     * @param numeroBytes Numero de Bytes a verificar
     * @param numeroCaracteres Numero de Caracteres que posee la entrada a validar
     * @return boolean True si es valido el numero, False sino lo es
     */
    public static boolean validarBytesHexa(KeyEvent evento, int numeroBytes, int numeroCaracteres){
        char c = evento.getKeyChar();
        if((c<'a'||c>'f') && (c<'A'||c>'F') && (c<'0' || c>'9')){
            evento.consume();
            return false;
        }
        
        switch(numeroBytes){
            case UN_BYTE:
                if(numeroCaracteres>=2){
                    evento.consume();
                    return false;
                }
            break;
            case DOS_BYTES:
                if(numeroCaracteres>=4){
                    evento.consume();
                    return false;
                }
            break;
        }
        return true;
    }
    
}
