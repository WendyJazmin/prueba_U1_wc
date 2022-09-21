package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Propietario;

public interface IPropietarioRepository {
	
	public void insertar(Propietario propietario);
	
	public Propietario buscar(Integer id);
	
	public void actualizar(Propietario propietario);
	
	public void eliminar(Integer id);
	
	public Propietario buscarPorCedula(String cedula);

	public List<Propietario> buscarTodos();
}
