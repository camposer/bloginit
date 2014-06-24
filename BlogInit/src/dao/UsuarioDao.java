package dao;

import model.Usuario;

public interface UsuarioDao 
		extends Dao<Usuario, Integer> {
	public Usuario obtener(String nombre);
	public Usuario obtener(String nombre, String clave);
}
