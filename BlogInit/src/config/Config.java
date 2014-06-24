package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import service.UsuarioService;
import service.UsuarioServiceImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;

@Configuration
@EnableTransactionManagement
public class Config {
	@Bean
	public UsuarioDao usuarioDao() {
		return new UsuarioDaoImpl();
	}

	@Bean
	public UsuarioService usuarioService() {
		return new UsuarioServiceImpl();
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("BlogInit");
	}
	
	@Bean
	public EntityManager entityManager() {
		return entityManagerFactory().createEntityManager();
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
}


