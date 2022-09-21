package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);
	
	public Vehiculo buscar(Integer id);
	
	public void actualizar(Vehiculo vehiculo);
	
	public void eliminar(Integer id);
	
	public Vehiculo buscarPorPlaca(String placa);
	
	public List<Vehiculo> buscarTodos();
}
