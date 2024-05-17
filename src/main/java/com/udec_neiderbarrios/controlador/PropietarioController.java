package com.udec_neiderbarrios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.udec_neiderbarrios.modelo.Propietario;
import com.udec_neiderbarrios.service.PropietarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/propietario")
public class PropietarioController {

	private final PropietarioService propietarioService;

	public PropietarioController(PropietarioService propietarioService) {
		this.propietarioService = propietarioService;
	}

	@GetMapping("/registrar")
	public String mostrarFormularioRegistro(Model model) {
		model.addAttribute("propietario", new Propietario());
		return "Propietario/registrar";
	}

	@PostMapping("/registrar")
	public String registrarPropietario(@ModelAttribute("propietario") Propietario propietario) {
		propietarioService.registrarPropietario(propietario);
		return "redirect:/propietario/listar";
	}

	@GetMapping("/listar")
	public String listarPropietarios(Model model) {
		model.addAttribute("propietarios", propietarioService.obtenerTodosPropietarios());
		return "Propietario/listar";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
		Propietario propietario = propietarioService.obtenerPropietarioPorId(id);
		model.addAttribute("propietario", propietario);
		return "Propietario/editar";
	}

	@PostMapping("/editar")
	public String editarPropietario(@ModelAttribute("propietario") Propietario propietario) {
		propietarioService.actualizarPropietario(propietario);
		return "redirect:/propietario/listar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarPropietario(@PathVariable int id) {
		propietarioService.eliminarPropietario(id);
		return "redirect:/propietario/listar";
	}

	@GetMapping("/login")
	public String mostrarFormularioLogin(Model model) {
		model.addAttribute("propietario", new Propietario());
		return "Propietario/login";
	}

	@PostMapping("/login")
	public String iniciarSesion(@ModelAttribute("propietario") Propietario propietario, HttpSession session, Model model) {
	    // Aquí deberías validar las credenciales utilizando el servicio de Propietario
		var propitarioFind = propietarioService.validarCredenciales(propietario.getEmail(), propietario.getClave());
	    if ( propitarioFind != null && propitarioFind.getClave().equals(propietario.getClave())) {
	        // Credenciales válidas, se inicia sesión
//	        session.setAttribute("loggedIn", propitarioFind);
	        model.addAttribute("loggedIn", propietario);
	        return "index"; // Redirigir a la página de inicio
	    } else {
	        // Credenciales inválidas, se redirige al formulario de inicio de sesión con un mensaje de error
	        return "redirect:/propietario/login?error";
	    }
	}

	@GetMapping("/")
	public String mostrarPaginaInicio(Model model, HttpSession session) {
	    if (session.getAttribute("loggedIn") != null) {
	        // Si el usuario está autenticado, establecer loggedIn como true en el modelo
	        model.addAttribute("loggedIn", true);
	        // Aquí podrías obtener el nombre del propietario desde la sesión o la base de datos
	        String nombrePropietario = propietarioService.obtenerNombrePorCorreo((String) session.getAttribute("correoElectronico"));
	        model.addAttribute("propietarioLogueado", nombrePropietario); // Usar el nombre real del propietario
	    }
	    return "index";
	}


	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();
		return "redirect:/propietario/login";
	}
}
