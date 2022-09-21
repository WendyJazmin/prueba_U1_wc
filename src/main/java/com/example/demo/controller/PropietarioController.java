package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {

	@Autowired
	private IPropietarioService iPropietarioService;
	
	//lista de propietarios
	@GetMapping("/listaPropietarios")
	public String buscarTodos(Model modelo) {
		List<Propietario> lista = this.iPropietarioService.buscarTodos();
		modelo.addAttribute("propietarios",lista);
		return "vistaListaPropietarios";
	}
	
//
	//insertar propietarios
	
	@GetMapping("/nuevoPropietario")
	public String insertarNuevoPropietario(Propietario propietario) {
		return "vistaInsertarNuevoPropietario";
	}
	
	@PostMapping("/insertar")//paso 2 despues de insertar el propietario, se direcciona a la lista
	public String insertar(Propietario propietario ) {
		this.iPropietarioService.insertar(propietario);
		return "redirect:/propietarios/listaPropietarios";
	}
	//
}
