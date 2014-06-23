package service;

import java.util.List;

import model.Usuario;

public interface UsuarioService {
	public void agregarUsuario(Usuario u) throws BlogServiceException;
	public void modificarUsuario(Usuario u);
	public Usuario autenticar(String usuario, String clave);
	public void eliminarUsuario(Integer id);
	public Usuario obtenerUsuario(Integer id);
	public List<Usuario> obtenerUsuarios();
}
