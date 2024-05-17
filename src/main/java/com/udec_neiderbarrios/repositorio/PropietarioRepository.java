package com.udec_neiderbarrios.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.udec_neiderbarrios.modelo.Propietario;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {
	Propietario findByEmail(String email);

	@Query("SELECT p.id FROM Propietario p")
	List<Integer> obtenerTodosIds();

	Optional<Propietario> findById(Integer email);
}
