package com.udec_neiderbarrios.service;

import org.springframework.stereotype.Service;

import com.udec_neiderbarrios.modelo.Propietario;
import com.udec_neiderbarrios.repositorio.PropietarioRepository;

import java.util.List;

@Service
public class PropietarioService {

	private final PropietarioRepository propietarioRepository;

	public PropietarioService(PropietarioRepository propietarioRepository) {
		this.propietarioRepository = propietarioRepository;
	}

	public void registrarPropietario(Propietario propietario) {
		propietarioRepository.save(propietario);
	}

	public List<Propietario> obtenerTodosPropietarios() {
		return propietarioRepository.findAll();
	}

	public Propietario obtenerPropietarioPorId(int id) {
		return propietarioRepository.findById(id).orElse(null);
	}

	public void actualizarPropietario(Propietario propietario) {
		propietarioRepository.save(propietario);
	}

	public void eliminarPropietario(int id) {
		propietarioRepository.deleteById(id);
	}

	public List<Integer> obtenerTodosIds() {
		return propietarioRepository.obtenerTodosIds();
	}

	public Propietario validarCredenciales(String email, String clave) {
		Propietario propietario = propietarioRepository.findByEmail(email);
		return propietario;
	}

	public String obtenerNombrePorCorreo(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
