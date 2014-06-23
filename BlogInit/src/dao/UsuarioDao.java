package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDao {
	public void agregar(Usuario u);
	public void modificar(Usuario u);
	public void eliminar(Integer id);
	public Usuario obtener(Integer id);
	public Usuario obtener(String nombre);
	public Usuario obtener(String nombre, String clave);
	public List<Usuario> obtenerTodos();
}
