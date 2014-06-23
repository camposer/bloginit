package controller;

import javax.servlet.http.HttpSession;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BlogServiceException;
import service.UsuarioService;
import form.UsuarioForm;

@Controller
@RequestMapping("/usuario/*")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@ModelAttribute
	public UsuarioForm usuarioForm() {
		return new UsuarioForm();
	}
	
	@RequestMapping(value={"inicio", ""})
	public String inicio() {
		return "/jsp/usuario/inicio.jsp";
	}
	
	@RequestMapping("autenticar")
	public String autenticar(@ModelAttribute("usuarioForm")
			UsuarioForm usuarioForm, HttpSession session) {
		
		Usuario u = usuarioService.autenticar(usuarioForm.getNombre(), usuarioForm.getClave1());

		if (u != null)
			session.setAttribute("usuario", u);
		
		return "redirect:/usuario/inicio.blog";
	}

	@RequestMapping("alta")
	public String alta(@ModelAttribute("usuarioForm")
			UsuarioForm usuarioForm) {
		
		// TODO Agregar validaciones adicionales de políticas de seguridad
		// TODO Mejorar respuesta de validaciones al usuario
		if (usuarioForm.getNombre() != null && 
				!usuarioForm.getNombre().trim().equals("") && 
				usuarioForm.getClave1() != null &&
				usuarioForm.getClave2() != null && 
				usuarioForm.getClave1().equals(usuarioForm.getClave2())) {
			
			Usuario u = new Usuario();
			u.setNombre(usuarioForm.getNombre());
			u.setClave(usuarioForm.getClave1());
			
			try {
				usuarioService.agregarUsuario(u);
			} catch(BlogServiceException bse) {
				// TODO Informar de la excepción al usuario!!
				bse.printStackTrace();
			}
			
			System.out.println(usuarioService.obtenerUsuarios());
		}
		
		return "redirect:/usuario/inicio.blog";
	}
}
