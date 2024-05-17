package com.udec_neiderbarrios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.udec_neiderbarrios.modelo.Finca;

import java.util.List;

@Repository
public interface FincaRepository extends JpaRepository<Finca, Integer> {

    // Ejemplo de consulta personalizada para encontrar todos los nombres de los propietarios de fincas
    @Query("SELECT DISTINCT f.propietario FROM Finca f")
    List<String> findDistinctPropietarios();
}
