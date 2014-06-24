package dao;

import java.util.List;

import javax.persistence.Query;

import model.Usuario;

public class UsuarioDaoImpl 
		extends GenericDao<Usuario, Integer>
		implements UsuarioDao {

	@SuppressWarnings("unchecked")
	@Override
	public Usuario obtener(String nombre) {
		Query q = em.createQuery("from Usuario u "
				+ "where u.nombre = :nombre");
		
		q.setParameter("nombre", nombre);
		List<Usuario> resultado = q.getResultList();
		if (resultado != null &&
				resultado.size() > 0)
			return resultado.get(0);
		else 
			return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario obtener(String nombre, String clave) {
		Query q = em.createQuery("from Usuario u "
				+ "where u.nombre = :nombre and u.clave = :clave");
		
		q.setParameter("nombre", nombre);
		q.setParameter("clave", clave);
		List<Usuario> resultado = q.getResultList();
		if (resultado != null &&
				resultado.size() > 0)
			return resultado.get(0);
		else 
			return null;

	} 

}
