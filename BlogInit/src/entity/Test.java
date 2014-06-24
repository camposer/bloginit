package entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
		
		listar();
		
		
		
		
		tx.commit();
		
		
		
	}

	private static void listar() {
		List<Usuario> usuarios = 
				em.createNamedQuery("Usuario.findAll")
					.getResultList();
		for (Usuario u : usuarios)
			System.out.println(u);

	}
}
