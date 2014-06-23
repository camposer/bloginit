package dao;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDaoDummyImpl implements UsuarioDao {
	private List<Usuario> usuarios;
	private Integer contador;
	
	public UsuarioDaoDummyImpl() {
		usuarios = new ArrayList<Usuario>();
		contador = 1;
	}

	@Override
	public void agregar(Usuario u) {
		u.setId(contador++);
		usuarios.add(u);
	}

	@Override
	public void modificar(Usuario u) {
		Usuario u1 = obtener(u.getId());
		if (u1 != null) {
			u1.setNombre(u.getNombre());
			u1.setClave(u.getClave());
		}
	}

	@Override
	public void eliminar(Integer id) {
		Usuario u = obtener(id);
		if (u != null) 
			usuarios.remove(u);
	}

	@Override
	public Usuario obtener(Integer id) {
		for (Usuario u : usuarios) {
			if (u.getId().equals(id))
				return u;
		}
		return null;
	}

	@Override
	public List<Usuario> obtenerTodos() {
		return usuarios;
	}

	public static void main(String[] args) {
		UsuarioDao usuarioDao = new UsuarioDaoDummyImpl();

		// Probar agregar
		Usuario u = new Usuario();
		u.setNombre("rodolfo");
		u.setClave("123456");
		
		usuarioDao.agregar(u);
		System.out.println(usuarioDao.obtenerTodos());
		
		// Probar modificar
		u.setNombre("enrique");
		usuarioDao.modificar(u);
		System.out.println(usuarioDao.obtenerTodos());
		
		usuarioDao.eliminar(1);
		System.out.println(usuarioDao.obtenerTodos());
	}

	@Override
	public Usuario obtener(String nombre) {
		for (Usuario u : usuarios) {
			if (u.getNombre().equals(nombre))
				return u;
		}
		return null;
	}

	@Override
	public Usuario obtener(String nombre, String clave) {
		for (Usuario u : usuarios) {
			if (u.getNombre().equals(nombre) && 
					u.getClave().equals(clave))
				return u;
		}
		return null;
	}
}




