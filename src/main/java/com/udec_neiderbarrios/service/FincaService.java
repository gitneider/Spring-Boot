package com.udec_neiderbarrios.service;

import org.springframework.stereotype.Service;

import com.udec_neiderbarrios.modelo.Finca;
import com.udec_neiderbarrios.repositorio.FincaRepository;

import java.util.List;

@Service
public class FincaService {

    private final FincaRepository fincaRepository;

  
    public FincaService(FincaRepository fincaRepository) {
        this.fincaRepository = fincaRepository;
    }

    public void guardarFinca(Finca finca) {
        fincaRepository.save(finca);
    }

    public List<Finca> obtenerTodasFincas() {
        return fincaRepository.findAll();
    }

    public Finca obtenerFincaPorId(int id) {
        return fincaRepository.findById(id).orElse(null);
    }

    public void actualizarFinca(Finca finca) {
        fincaRepository.save(finca);
    }

    public void eliminarFinca(Integer id) {
        fincaRepository.deleteById(id);
    }

	public Finca obtenerFincaPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
