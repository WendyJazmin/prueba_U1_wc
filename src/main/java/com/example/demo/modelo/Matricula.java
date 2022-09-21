package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="matriculacion")
public class Matricula {

	@Id
	@Column(name ="matr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matr_id_seq")
	@SequenceGenerator(name="matr_id_seq", sequenceName = "_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name ="matr_fecha_matricula")
	private LocalDateTime fechaMatricula;
	
	@Column(name ="matr_valor_matricula")
	private BigDecimal valorMatricula;
	
	@Column(name ="matr_cedula_propietario")
	private String cedulaPropietario;
	
	@Column(name ="matr_placa_vehiculo")
	private String placaVehiculo;
	
	@OneToOne
	@JoinColumn(name="matr_vehi_id")
	private Vehiculo vehiculo;

	@OneToOne
	@JoinColumn(name="matr_prop_id")
	private Propietario propietario;

	@Override
	public String toString() {
		return "Matriculacion [id=" + id + ", fechaMatricula=" + fechaMatricula + ", valorMatricula=" + valorMatricula
				+ ", cedulaPropietario=" + cedulaPropietario + ", placaVehiculo=" + placaVehiculo + "]";
	}

	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public String getCedulaPropietario() {
		return cedulaPropietario;
	}

	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	
	
}
