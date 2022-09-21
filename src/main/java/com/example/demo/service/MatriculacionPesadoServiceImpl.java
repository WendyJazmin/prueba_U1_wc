package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("pesado")
public class MatriculacionPesadoServiceImpl implements IMatriculaService {

	@Override
	public BigDecimal calcular(BigDecimal precio) {
		// TODO Auto-generated method stub
		BigDecimal valor = precio.multiply(new BigDecimal(0.15));
		return valor;
	}

}
