package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.UsuarioService;
import service.UsuarioServiceImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoDummyImpl;

@Configuration
public class Config {
	@Bean
	public UsuarioDao usuarioDao() {
		return new UsuarioDaoDummyImpl();
	}

	@Bean
	public UsuarioService usuarioService() {
		return new UsuarioServiceImpl();
	}
}
