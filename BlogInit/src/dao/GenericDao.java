package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

public class GenericDao<T, K> implements Dao<T, K> {
	@Autowired
	@PersistenceContext
	protected EntityManager em;
	private Class<T> clase;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.clase = (Class<T>)
                ((ParameterizedType)getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
	}

	@Override
	public void agregar(T u) {
		em.persist(u);
	}

	@Override
	public void modificar(T u) {
		em.merge(u);
	}

	@Override
	public void eliminar(K id) {
		Query q = em.createQuery("delete from " + clase.getSimpleName() + " u "
				+ "where u.id = :id");
		
		q.setParameter("id", id);
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T obtener(K id) {
		Query q = em.createQuery("from " + clase.getSimpleName() + " u "
				+ "where u.id = :id");
		
		q.setParameter("id", id);
		List<T> resultado = q.getResultList();
		if (resultado != null &&
				resultado.size() > 0)
			return resultado.get(0);
		else 
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> obtenerTodos() {
		Query q = em.createQuery("from " + clase.getSimpleName() + " u");
		
		return q.getResultList();
	}
}
