package com.udec_neiderbarrios.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Fincas")
public class Finca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numHectareas")
    private Integer numHectareas;


    @Column(name = "metrosCuadrados")
    private Integer metrosCuadrados;

    @Column(name = "propietario")
    private String propietario;

    @Column(name = "capataz")
    private String capataz;

    @Column(name = "pais")
    private String pais;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "si_Produce_Leche")
    private String siProduceLeche;

    @Column(name = "si_Produce_Cereales")
    private String siProduceCereales;

    @Column(name = "si_Produce_Frutas")
    private String siProduceFrutas;

    @Column(name = "si_Produce_Verduras")
    private String siProduceVerduras;

    @Column(name = "Propietario_id")
    private int propietarioId;

    public Finca() {
        // Constructor vacío necesario para JPA
    }

	public Finca(int id, String nombre, Integer numHectareas, Integer metrosCuadrados, String propietario,
			String capataz, String pais, String departamento, String ciudad, String siProduceLeche,
			String siProduceCereales, String siProduceFrutas, String siProduceVerduras, int propietarioId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numHectareas = numHectareas;
		this.metrosCuadrados = metrosCuadrados;
		this.propietario = propietario;
		this.capataz = capataz;
		this.pais = pais;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.siProduceLeche = siProduceLeche;
		this.siProduceCereales = siProduceCereales;
		this.siProduceFrutas = siProduceFrutas;
		this.siProduceVerduras = siProduceVerduras;
		this.propietarioId = propietarioId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumHectareas() {
		return numHectareas;
	}

	public void setNumHectareas(Integer numHectareas) {
		this.numHectareas = numHectareas;
	}

	public Integer getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Integer metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getCapataz() {
		return capataz;
	}

	public void setCapataz(String capataz) {
		this.capataz = capataz;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getSiProduceLeche() {
		return siProduceLeche;
	}

	public void setSiProduceLeche(String siProduceLeche) {
		this.siProduceLeche = siProduceLeche;
	}

	public String getSiProduceCereales() {
		return siProduceCereales;
	}

	public void setSiProduceCereales(String siProduceCereales) {
		this.siProduceCereales = siProduceCereales;
	}

	public String getSiProduceFrutas() {
		return siProduceFrutas;
	}

	public void setSiProduceFrutas(String siProduceFrutas) {
		this.siProduceFrutas = siProduceFrutas;
	}

	public String getSiProduceVerduras() {
		return siProduceVerduras;
	}

	public void setSiProduceVerduras(String siProduceVerduras) {
		this.siProduceVerduras = siProduceVerduras;
	}

	public int getPropietarioId() {
		return propietarioId;
	}

	public void setPropietarioId(int propietarioId) {
		this.propietarioId = propietarioId;
	}

}