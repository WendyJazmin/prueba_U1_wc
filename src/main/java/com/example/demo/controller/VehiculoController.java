package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {

	@Autowired
	private IVehiculoService iVehiculoService;
	
	//lista de los vehiculos
	@GetMapping("/listaVehiculos")
	public String buscarTodos(Model modelo) {
		List<Vehiculo> lista = this.iVehiculoService.buscarTodos();
		modelo.addAttribute("vehiculos",lista);
		return "vistaListaVehiculos";
	}
	
	//insertar vehiculo
	@PostMapping("/insertar")
	public String insertar(Vehiculo vehiculo) {
		this.iVehiculoService.insertar(vehiculo);
		return "redirect:/vehiculos/listaVehiculos";
		
	}
	
	@GetMapping("/nuevoVehiculo")
	public String insertarNuevoVehiculo(Vehiculo vehiculo) {
		return "vistaInsertarNuevoVehiculo";
	}
}
