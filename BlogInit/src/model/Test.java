package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {
	private static EntityManager em;
	
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence
					.createEntityManagerFactory("BlogInit");   
		
		em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// Listar
		listar();
		
		// Agregar
		Usuario u = new Usuario();
		u.setNombre("pedro");
		u.setClave("123");
		em.persist(u);
		
		System.out.println();
		listar();
		
		// Modificar
		u.setNombre("otro");
		em.persist(u); 	// Actualiza porque "u" había sido
						// persistido anteriormente
		
		System.out.println();
		listar();
		
		// Eliminar
		//em.remove(u);
		Query q = em.createQuery("delete from Usuario u "
				+ "where u.id = :id");
		q.setParameter("id", u.getId());
		q.executeUpdate();
		
		System.out.println();
		listar();
		
		tx.commit();
		
		em.close(); // Cerrando conexiones
		
	}

	@SuppressWarnings("unchecked")
	private static void listar() {
		List<Usuario> usuarios = 
				em.createNamedQuery("Usuario.findAll")
					.getResultList();
		for (Usuario u : usuarios)
			System.out.println(u);

	}
}
