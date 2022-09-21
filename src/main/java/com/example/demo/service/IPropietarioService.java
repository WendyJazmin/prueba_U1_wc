package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Propietario;

public interface IPropietarioService {

	public void insertar(Propietario propietario);
	
	public Propietario buscar(Integer id);
	
	public void actualizar(Propietario propietario);
	
	public void eliminar(Integer id);
	public Propietario buscarPorCedula(String cedula);

	public List<Propietario> buscarTodos();
}
