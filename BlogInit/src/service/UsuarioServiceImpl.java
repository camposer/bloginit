package service;

import java.util.List;

import javax.transaction.Transactional;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UsuarioDao;

@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public void agregarUsuario(Usuario u) throws BlogServiceException {
		Usuario u1 = usuarioDao.obtener(u.getNombre());

		if (u1 == null)
			usuarioDao.agregar(u);
		else
			throw new BlogServiceException("Usuario repetido");
	}

	@Override
	public void modificarUsuario(Usuario u) {
		usuarioDao.modificar(u);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		usuarioDao.eliminar(id);
	}

	@Override
	public Usuario obtenerUsuario(Integer id) {
		return usuarioDao.obtener(id);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioDao.obtenerTodos();
	}

	@Override
	public Usuario autenticar(String usuario, String clave) {
		return usuarioDao.obtener(usuario, clave);
	}

}
