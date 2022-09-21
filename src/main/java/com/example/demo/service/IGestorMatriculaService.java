package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Matricula;

public interface IGestorMatriculaService {

	public void insertarMatricula(String cedula, String placa);
	public List<Matricula> buscarTodos();
}
