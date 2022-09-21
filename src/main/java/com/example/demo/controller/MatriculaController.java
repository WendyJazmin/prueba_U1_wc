package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.Propietario;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.service.IGestorMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private IGestorMatriculaService IGestorMatriculaService;

	//lista de matriculas
	@GetMapping("/listaMatriculas")
	public String buscar(Model modelo) {
		List<Matricula> lista = this.IGestorMatriculaService.buscarTodos();
		modelo.addAttribute("matriculas", lista);
		return "vistaListaMatriculas";
	}
	
	//insertar matricula
	@PostMapping("/insertar")
	public String insertar(Matricula matricula,Propietario pro, Vehiculo v) {
		this.IGestorMatriculaService.insertarMatricula(matricula.getCedulaPropietario(), matricula.getPlacaVehiculo());
		return "redirect:/matriculas/listaMatriculas";
	}
	
	@GetMapping("/nuevaMatricula")
	public String insertarNuevaMatricula(Matricula matricula) {
		return "vistaInsertarNuevaMatricula";
	}
}
