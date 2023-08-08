package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FacturaDTO {
	
	
	private LocalDate fecha;
	
	private String cedula;
	


	public FacturaDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public FacturaDTO(LocalDate fechaFactura, String cedulaCliente) {
		super();
		this.fecha = fechaFactura;
		this.cedula = cedulaCliente;
	}



	@Override
	public String toString() {
		return "FacturaDTO [fechaFactura=" + fecha+ ", cedulaCliente=" + cedula + "]";
	}



	
	
	
	

}
