package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.Vehiculo;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public List<Matricula> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Matricula> myQuery = this.entityManager.createQuery("SELECT m FROM Matricula m",Matricula.class);
		
		return myQuery.getResultList();
	}

}
