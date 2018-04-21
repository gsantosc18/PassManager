package model.util;

import model.entity.Usuario;

public class UsuarioCache {
    private static Usuario usuario = null;
    
    public static boolean isEmpty(){
        return getUsuario() == null;
    }

    /**
     * @return the usuario
     */
    public static Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public static void setUsuario(Usuario aUsuario) {
        usuario = aUsuario;
    }
}
