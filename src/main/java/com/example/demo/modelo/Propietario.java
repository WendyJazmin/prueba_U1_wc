package com.example.demo.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="propietario")
public class Propietario {

	@Id
	@Column(name ="prop_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prop_id_seq")
	@SequenceGenerator(name="prop_id_seq", sequenceName = "prop_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name ="prop_nombre")
	private String nombre;
	
	@Column(name ="prop_apellido")
	private String apellido;
	
	@Column(name ="prop_cedula")
	private String cedula;
	
	@Column(name ="prop_fecha_nacimiento")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaNacimiento;
	
	@OneToMany(mappedBy="propietario")
	private List<Matricula> matriculas;

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	
	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	
	

}
