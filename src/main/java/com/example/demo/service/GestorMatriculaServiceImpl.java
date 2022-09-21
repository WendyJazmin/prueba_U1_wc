package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.Propietario;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.IVehiculoRepository;

@Service
public class GestorMatriculaServiceImpl implements IGestorMatriculaService {

	@Autowired
	private IPropietarioRepository IPropietarioRepository; 
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	
	@Autowired
	private IMatriculaRepository iMatriculacionRepository;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaService IMatriculacionServiceL;
	

	@Autowired
	@Qualifier("pesado")
	private IMatriculaService IMatriculacionServiceP;
	
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public void insertarMatricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario propietario = this.IPropietarioRepository.buscarPorCedula(cedula);
		Vehiculo vehiculo = this.iVehiculoRepository.buscarPorPlaca(placa);
		
		
		BigDecimal valorMatricula;
		
		if(vehiculo.getTipo().equalsIgnoreCase("L")) {
			valorMatricula = this.IMatriculacionServiceL.calcular(vehiculo.getPrecio());
			//matricula.setValorMatricula(valorMatricula);
		}else {
			valorMatricula = this.IMatriculacionServiceP.calcular(vehiculo.getPrecio());
			//matricula.setValorMatricula(valorMatricula);
		}
		
		if(valorMatricula.compareTo(new BigDecimal(2000))>0) {
			BigDecimal valorDescuento = valorMatricula.multiply(new BigDecimal(0.07));
			valorMatricula = valorMatricula.subtract(valorDescuento);
		}
		
		Matricula matricula = new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValorMatricula(valorMatricula);
		matricula.setCedulaPropietario(propietario.getCedula());
		matricula.setPlacaVehiculo(vehiculo.getPlaca());
		
		this.iMatriculacionRepository.insertar(matricula);
	}


	@Override
	public List<Matricula> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iMatriculacionRepository.buscarTodos();
	}

}
